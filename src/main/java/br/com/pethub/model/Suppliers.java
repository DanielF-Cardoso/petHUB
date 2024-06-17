
package br.com.pethub.model;

/**
 * This class represents a Supplier in the application.
 * It extends the Customers class, inheriting its fields and methods.
 * It contains an additional field specific to a supplier, which is cnpj.
 * It also contains getter and setter methods for this field.
 */

public class Suppliers extends Customers{
    
    private String cnpj;

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
    
    
    @Override
    public String toString(){
        return this.getName();
    }
}
