
package br.com.pethub.model;

/**
 * This class represents a Product in the application.
 * It contains fields that represent different properties of a product, such as id, product, price, stock_qty, and a reference to a Suppliers object.
 * It also contains getter and setter methods for these fields.
 */

public class Products {
    
    private int id;
    private String product;
    private double price;
    private int stock_qty;
    
    private Suppliers suppliers;

    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStock_qty() {
        return stock_qty;
    }

    public void setStock_qty(int stock_qty) {
        this.stock_qty = stock_qty;
    }

    public Suppliers getSuppliers() {
        return suppliers;
    }

    public void setSuppliers(Suppliers suppliers) {
        this.suppliers = suppliers;
    }
    
    
    
}
