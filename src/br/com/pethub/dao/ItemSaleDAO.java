/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.pethub.dao;

import br.com.pethub.jdbc.ConnectionFactory;
import br.com.pethub.model.ItemSale;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author danie
 */
public class ItemSaleDAO {

    private Connection con;

    public ItemSaleDAO() {
        this.con = new ConnectionFactory().getConnection();
    }

    public void addItem(ItemSale obj) {
        try {

            //Criar o comando sql
            String sql = "insert into tb_itemssales (sale_id, product_id, qty, subtotal)"
                    + "values (?,?,?,?)";

            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, obj.getSale().getId());
            stmt.setInt(2, obj.getProduct().getId());
            stmt.setInt(3, obj.getQty());
            stmt.setDouble(4, obj.getSubtotal());

            stmt.execute();
            stmt.close();


        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro: " + erro);
        }
    }

}
