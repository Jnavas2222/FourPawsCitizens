package edu.unbosque.FourPawsCitizens.model;

import edu.unbosque.FourPawsCitizens.model.dtos.Pet;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Manager {
    private ArrayList<Pet> Pets;
    public Manager(){
        try {
            funcionar();
            
        }
        catch (Exception e){
            e.printStackTrace();
            System.out.println("Información no detectada");
        }
    }
    public void funcionar() throws IOException {
    	Pets = new ArrayList<Pet>();
    	Imprimir("Bienvenido al administrador de información de mascotas");
        uploadData();
        intro();
    }

    public void intro(){
        Imprimir("Ques es lo que quieres hacer: "+"\n"+
                "1 para asignar id"+"\n"+
                "2 para encontrar por microchip"+"\n"+
                "3 para contar por especie"+"\n"+
                "4 para encontrar masoctas peligrosas por barrio"+"\n"+
                "5 para buscar por diferentes factores"+"\n"+
                "6 para salir"+"\n");
        int n = Integer.parseInt(Recolectar());
        menu(n);
    }

    BufferedReader Br = null;
    public void menu(int n){
    if(n == 1){
       assignID();
    }
    else if(n == 2){
        Imprimir("¿Cual es el microchip que quieres buscar?");
        long busc = Long.parseLong(Recolectar());
        findByMicrochip(busc);
        intro();
    }
    else if(n == 3){
        Imprimir("Cual es la especie que quieres buscar");
        countBySpecies(Recolectar());
        intro();
    }
    else if(n == 4){
        Imprimir("Escribe se parando por , de la siguiente forma: número_de_mascotas,Top/last,barrio");
        String [] aux = Recolectar().split(",");
        findByPotentDangerousInNeighborhood(Integer.parseInt(aux[0]),aux[1],aux[2]);
        intro();
    }
    else if(n == 5){
        Imprimir("Escribe se parando por , de la siguiente forma: tamaño,sexo,barrio,es_peligroso(si/no)");
        String [] aux = Recolectar().split(",");
        findByMultipleFields(aux[0],aux[1],aux[2],aux[3]);
        intro();
    }
    else if(n == 6) {
        Imprimir("Gracias por usar el sistema");
    }
    }

    public void uploadData() throws IOException {
        try {
            Br = new BufferedReader(new FileReader("C:\\Users\\Lenovo\\Downloads\\pets-citizens.csv"));
            String line;
            int count = 0;
            while (null != (line = Br.readLine())) {
                if(count != 0){
                try {
                    String[] split = line.split(";");
                    Long aux = Long.parseLong(split[0]);
                    Boolean aux2 = null;
                    if(split[4].equals("SI")){
                        aux2 = true;
                    }
                    else if(split[4].equals("NO")){
                        aux2 = false;
                    }
                    Pets.add(new Pet("NO-ID",aux,split[1],split[2],split[3],aux2,split[5]));
                }
                catch (Exception e) {
                        }
                    }
                count++;
                }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (null != Br) {
                Br.close();
                System.out.println("The data was stored successfully");
            }
        }
    }

    public void assignID() {
    for(int i = 0;i<Pets.size();i++){
        String mi = String.valueOf(Pets.get(i).getMicrochip());
        String sp = "";
        String sx = "";
        String sz = "";
        String dang = "";
        if(Pets.get(i).getSpecies().equals("CANINO")){
            sp = "C";
        }
        else if(Pets.get(i).getSpecies().equals("FELINO")){
            sp = "F";
        }

        if(Pets.get(i).getSex().equals("MACHO")){
            sx = "M";
        }
        else if(Pets.get(i).getSex().equals("HEMBRA")){
            sx = "H";
        }

        if(Pets.get(i).getSize().equals("MINIATURA")) {
            sz = "MI";
        }
        else if(Pets.get(i).getSize().equals("PEQUE�O")){
            sz = "P";
        }
        else if(Pets.get(i).getSize().equals("MEDIANO")){
            sz = "M";
        }
        else if(Pets.get(i).getSize().equals("GRANDE")){
            sz = "G";
        }

        if(Pets.get(i).isPotentDanger() == false){
            dang = "F";
        }
        else if(Pets.get(i).isPotentDanger() == true){
            dang = "T";
        }

        Pets.get(i).setId(mi.substring(mi.length()-4)+"-"+sp+sx+sz+dang+"-"+Pets.get(i).getNeighborhood());
    }
    }

    public void findByMicrochip(long microchip) {
        for(int i = 0;i<Pets.size();i++){
            if(microchip == Pets.get(i).getMicrochip()){
                Imprimir("ID: "+Pets.get(i).getId()+"\n"+
                        "Species: "+Pets.get(i).getSpecies()+"\n"+
                        "Gender: "+Pets.get(i).getSex()+"\n"+
                        "Size: "+Pets.get(i).getSize()+"\n"+
                        "Potentially Dangerous: "+Pets.get(i).isPotentDanger()+"\n"+
                        "Neighborhood: "+Pets.get(i).getNeighborhood()+"\n");
            }
        }
    }

    public void countBySpecies(String species) {
        int cont = 0;
        String sp = species.toUpperCase();
        for(int i = 0;i<Pets.size();i++){
            if(sp.equals(Pets.get(i).getSpecies()) == true){
                cont++;
            }
        }
        Imprimir("El número de animales de la clase "+species.toUpperCase(Locale.ROOT)+" es: "+cont);
    }

    public void findByPotentDangerousInNeighborhood(int n, String position, String neighborhood) {
        if(position.toUpperCase().equals("TOP")){
            int j = 0;
            int i = 0;
            while(j < n){
                if(neighborhood.toUpperCase().equals(Pets.get(i).getNeighborhood())&&Pets.get(i).isPotentDanger()==true) {
                        Imprimir("ID: " + Pets.get(i).getId() + "\n" +
                                "Species: " + Pets.get(i).getSpecies() + "\n" +
                                "Gender: " + Pets.get(i).getSex() + "\n" +
                                "Size: " + Pets.get(i).getSize() + "\n" +
                                "Potentially Dangerous: " + Pets.get(i).isPotentDanger() + "\n" +
                                "Neighborhood: " + Pets.get(i).getNeighborhood() + "\n");
                        j++;
                }
                i++;
                }
            }
        else if(position.toUpperCase().equals("LAST")){
            int j = 0;
            int i = Pets.size()-1;
            while(j < n){
                if(neighborhood.toUpperCase().equals(Pets.get(i).getNeighborhood()) && Pets.get(i).isPotentDanger()) {
                    Imprimir("ID: " + Pets.get(i).getId() + "\n" +
                            "Species: " + Pets.get(i).getSpecies() + "\n" +
                            "Gender: " + Pets.get(i).getSex() + "\n" +
                            "Size: " + Pets.get(i).getSize() + "\n" +
                            "Potentially Dangerous: " + Pets.get(i).isPotentDanger() + "\n" +
                            "Neighborhood: " + Pets.get(i).getNeighborhood() + "\n");
                    j++;
                }
                i--;
            }
        }
    }

    public void findByMultipleFields(String species, String sex, String size, String potentDangerous) {
        boolean potent = false;
        if (potentDangerous.toUpperCase().equals("SI")){
            potent = true;
        }
        for(int i = 0; i<Pets.size();i++){
            if(Pets.get(i).getSex().equals(sex)&&Pets.get(i).getSpecies().equals(species)&&Pets.get(i).getSize().equals(size)&&Pets.get(i).isPotentDanger() == potent){
                Imprimir(Pets.get(i).getId());
            }
        }
    }

    public String Recolectar(){
        Scanner scan=new Scanner(System.in);
        String aux=scan.next();
        return aux;
    }

    public void Imprimir(String aux){
        System.out.println(aux);
    }
}
