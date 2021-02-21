package edu.unbosque.FourPawsCitizens.model.daos;

public class Pet {
    String id;
    long microchip;
    String species;
    String sex;
    String size;
    boolean potentDanger;
    String neighborhood;
    public Pet(String ID, long micro, String Sp, String Sex, String Size, boolean PotentD, String NeighborH){
        id = ID;
        microchip = micro;
        sex = Sex;
        size = Size;
        potentDanger = PotentD;
        neighborhood = NeighborH;
    }

}
