/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.pethub.model;

/**
 *
 * @author danie
 */
public class Services {

    private int id;
    private String service_name;
    private String service_description;
    private double price_large;
    private double price_medium;
    private double price_small;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getService_name() {
        return service_name;
    }

    public String toString() {
        return service_name;
    }

    public void setService_name(String service_name) {
        this.service_name = service_name;
    }

    public String getService_description() {
        return service_description;
    }

    public void setService_description(String service_description) {
        this.service_description = service_description;
    }

    public double getPrice_large() {
        return price_large;
    }

    public void setPrice_large(double price_large) {
        this.price_large = price_large;
    }

    public double getPrice_medium() {
        return price_medium;
    }

    public void setPrice_medium(double price_medium) {
        this.price_medium = price_medium;
    }

    public double getPrice_small() {
        return price_small;
    }

    public void setPrice_small(double price_small) {
        this.price_small = price_small;
    }
}
