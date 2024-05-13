package br.com.pethub.model;

public class Vaccine {

    private int id;
    private String vaccine_name;
    private String vaccine_application;
    private String vaccine_expiration;
    private String note;


    private Customers custumers;
    private Pets pets;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVaccine_name() {
        return vaccine_name;
    }

    public void setVaccine_name(String vaccine_name) {
        this.vaccine_name = vaccine_name;
    }

    public String getVaccine_application() {
        return vaccine_application;
    }

    public void setVaccine_application(String vaccine_application) {
        this.vaccine_application = vaccine_application;
    }

    public String getVaccine_expiration() {
        return vaccine_expiration;
    }

    public void setVaccine_expiration(String vaccine_expiration) {
        this.vaccine_expiration = vaccine_expiration;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Customers getCustumers() {
        return custumers;
    }

    public void setCustumers(Customers custumers) {
        this.custumers = custumers;
    }

    public Pets getPets() {
        return pets;
    }

    public void setPets(Pets pets) {
        this.pets = pets;
    }
}
