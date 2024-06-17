package br.com.pethub.model;

/**
 * This class represents an Employee in the application.
 * It extends the Customers class, inheriting its fields and methods.
 * It contains additional fields specific to an employee, such as password, responsibility, and access level.
 * It also contains getter and setter methods for these fields.
 */

public class Employees extends Customers{

    private String password;
    private String responsibility;
    private String access_level;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getResponsibility() {
        return responsibility;
    }

    public void setResponsibility(String responsibility) {
        this.responsibility = responsibility;
    }

    public String getAccess_level() {
        return access_level;
    }

    public void setAccess_level(String access_level) {
        this.access_level = access_level;
    }
}
