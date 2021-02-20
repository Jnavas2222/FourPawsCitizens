package edu.unbosque.FourPawsCitizens.model.daos;

public class Pet {
    String id;
    long microchip;
    String species;
    String sex;
    String size;
    String potentDanger;
    String neighborhood;
    public void Pet(String ID, long micro, String Sp, String Sex, String Size, String PotentD, String NeighborH){
        id = ID;
        microchip = micro;
        sex = Sex;
        size = Size;
        potentDanger = PotentD;
        neighborhood = NeighborH;
    }

}
