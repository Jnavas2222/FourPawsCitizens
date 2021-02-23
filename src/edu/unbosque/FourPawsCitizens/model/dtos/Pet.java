package edu.unbosque.FourPawsCitizens.model.dtos;

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
        species = Sp;
        sex = Sex;
        size = Size;
        potentDanger = PotentD;
        neighborhood = NeighborH;
    }
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public long getMicrochip() {
		return microchip;
	}
	public void setMicrochip(long microchip) {
		this.microchip = microchip;
	}
	public String getSpecies() {
		return species;
	}
	public void setSpecies(String species) {
		this.species = species;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public boolean isPotentDanger() {
		return potentDanger;
	}
	public void setPotentDanger(boolean potentDanger) {
		this.potentDanger = potentDanger;
	}
	public String getNeighborhood() {
		return neighborhood;
	}
	public void setNeighborhood(String neighborhood) {
		this.neighborhood = neighborhood;
	}

 
}
