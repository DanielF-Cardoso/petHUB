package br.com.pethub.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 * This class represents a Schedule in the application.
 * It contains fields that represent different properties of a schedule, such as id, date, time, status, total_Value, and references to Services, Customers, and Pets objects.
 * It also contains getter and setter methods for these fields.
 */
public class Schedule {

    private int id;
    private String date;
    private String time;
    private String status;
    private double total_Value;

    private Services services;
    private Customers custumers;
    private Pets pets;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public double getTotal_Value() {
        return total_Value;
    }

    public void setTotal_Value(double total_Value) {
        this.total_Value = total_Value;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public Services getServices() {
        return services;
    }

    public void setServices(Services services) {
        this.services = services;
    }

    
    
}
