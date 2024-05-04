
package br.com.pethub.dao;

import br.com.pethub.jdbc.ConnectionFactory;
import br.com.pethub.model.Customers;
import br.com.pethub.model.Products;
import br.com.pethub.model.Suppliers;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


public class ProductsDAO {
    
    private Connection con;

    public ProductsDAO(){
        this.con = new ConnectionFactory().getConnection();
    }
    
    
    public void addProducts(Products obj){
    
        try {

            //Criar o comando sql

            String sql = "insert into tb_products (product, price, stock_qty, for_id)"
                    + "values (?,?,?,?)";

            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, obj.getProduct());
            stmt.setDouble(2, obj.getPrice());
            stmt.setInt(3, obj.getStock_qty());
            stmt.setInt(4, obj.getSuppliers().getId());

            stmt.execute();
            stmt.close();

            JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso!");
            
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro: " + erro);
        }
        
    }
    
    public void editProducts(Products obj){
    
        try {

            //Criar o comando sql

            String sql = "update tb_products set product=?, price=?, stock_qty=?, for_id=? where id=?";

            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, obj.getProduct());
            stmt.setDouble(2, obj.getPrice());
            stmt.setInt(3, obj.getStock_qty());
            
            stmt.setInt(4, obj.getSuppliers().getId());
            
            stmt.setInt(5, obj.getId());

            stmt.execute();
            stmt.close();

            JOptionPane.showMessageDialog(null, "Produto alterado com sucesso!");
            
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro: " + erro);
        }
        
    }
    
    
     public void deleteProducts(Products obj){
    
                try {

            //Criar o comando sql

            String sql = "delete from tb_products where id = ?";

            PreparedStatement stmt = con.prepareStatement(sql);
            
            stmt.setInt(1, obj.getId());

            stmt.execute();
            stmt.close();

            JOptionPane.showMessageDialog(null, "Produto excluido com sucesso!");
            
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro: " + erro);
        }
    
    }
    
    
    
    
    
    public List<Products>  listProducts(){
        try {

            List<Products> listProducts = new ArrayList<>();

            String sql = "select p.id, p.product, p.price, p.stock_qty, f.name from tb_products as p "
                    + "inner join tb_suppliers as f on (p.for_id = f.id)";
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery(); //retorna um conjunto de dados

            while(rs.next()){
                
                Products obj = new Products();
                Suppliers f = new Suppliers();
                
                obj.setId(rs.getInt("p.id"));
                obj.setProduct(rs.getString("p.product"));
                obj.setPrice(rs.getDouble("p.price"));
                obj.setStock_qty(rs.getInt("p.stock_qty"));
                
                f.setName(rs.getString("f.name"));
                
                obj.setSuppliers(f);
                
                listProducts.add(obj);
            }

            return listProducts;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e);
            return null;
        }
    }
    
    
    
     public List<Products>  searchProducts(String name){
        try {

            List<Products> listProducts = new ArrayList<>();

            String sql = "select p.id, p.product, p.price, p.stock_qty, f.name from tb_products as p "
                    + "inner join tb_suppliers as f on (p.for_id = f.id) where p.product like ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, name);
            
            ResultSet rs = stmt.executeQuery(); //retorna um conjunto de dados

            while(rs.next()){
                
                Products obj = new Products();
                Suppliers f = new Suppliers();
                
                obj.setId(rs.getInt("p.id"));
                obj.setProduct(rs.getString("p.product"));
                obj.setPrice(rs.getDouble("p.price"));
                obj.setStock_qty(rs.getInt("p.stock_qty"));
                
                f.setName(rs.getString("f.name"));
                
                obj.setSuppliers(f);
                
                listProducts.add(obj);
            }

            return listProducts;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e);
            return null;
        }
    }
    
}
