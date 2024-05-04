
package br.com.pethub.dao;

import br.com.pethub.jdbc.ConnectionFactory;
import br.com.pethub.model.Products;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
    
}
