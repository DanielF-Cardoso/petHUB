
package br.com.pethub.model;

import java.util.Date;


public class Pets {
    
    private int id;
    private String pet_name;
    private String gender;
    private String birth;
    private double pet_weight;
    private String species;
    private String breed;
    
    private Customers custumers;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPet_name() {
        return pet_name;
    }

    public void setPet_name(String pet_name) {
        this.pet_name = pet_name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public double getPet_weight() {
        return pet_weight;
    }

    public void setPet_weight(double pet_weight) {
        this.pet_weight = pet_weight;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public Customers getCustumers() {
        return custumers;
    }

    public void setCustumers(Customers custumers) {
        this.custumers = custumers;
    }
    
    
    
    
}
