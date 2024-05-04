
package br.com.pethub.model;

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
