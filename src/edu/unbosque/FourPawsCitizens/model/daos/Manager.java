package edu.unbosque.FourPawsCitizens.model.daos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Manager {
    public Manager(){
        try {
            funcionar();
        }
        catch (Exception e){

        }
    }
    public void funcionar() throws IOException {
        uploadData();
    }

    ArrayList Pets = new ArrayList<Pet>();
    BufferedReader Br = null;

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
                    Boolean aux2 = false;
                    if(split[4]=="SI"){
                        aux2 = true;
                    }
                    Pets.add(new Pet("",aux,split[1],split[2],split[3],aux2,split[5]));
                }
                catch (Exception e) {
                    System.out.println("Error, The neighborhood is not defined");
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

    }

    public void findByMicrochip(long microchip) {

    }

    public void countBySpecies(String species) {

    }

    public void findByPotentDangerousInNeighborhood(int n, String position, String neighborhood) {

    }

    public void findByMultipleFields(String sex, String species, String size, String potentDangerous) {

    }
}
