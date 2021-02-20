package edu.unbosque.FourPawsCitizens.model.daos;

import javafx.scene.chart.ScatterChart;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Manager {
    ArrayList Pets = new ArrayList<Pet>();
    BufferedReader Br = null;
    public void uploadData() throws IOException {
        try {
            Br = new BufferedReader(new FileReader("files/pets-citizens.csv"));
            String line = Br.readLine();
            while(null!=line)
            System.out.println(line);
            } catch (Exception e) {
                e.printStackTrace();
            }
        finally{
                if(null!= Br){
                    Br.close();
                }
        }
    }
    public void assignID(){

    }
    public void findByMicrochip(long microchip){

    }
    public void countBySpecies(String species){

    }
    public void findByPotentDangerousInNeighborhood(int n, String position, String neighborhood){

    }
    public void findByMultipleFields(String sex,String species, String size, String potentDangerous){

    }
}
