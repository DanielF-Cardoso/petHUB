/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.pethub.dao;

import br.com.pethub.jdbc.ConnectionFactory;
import br.com.pethub.model.Customers;
import br.com.pethub.model.ItemSale;
import br.com.pethub.model.Products;
import br.com.pethub.model.Sales;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
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

    public List<ItemSale> ListItemSales (int sale_Id) {
        try {

            List<ItemSale> listItems = new ArrayList<>(); //ItemVenda // lista

            String sql = "select p.product, i.qty, p.price, i.subtotal from tb_itemssales as i "
                    + "inner join tb_products as p on (i.product_id = p.id) "
                    + "where i.sale_id = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, sale_Id);

            ResultSet rs = stmt.executeQuery(); //retorna um conjunto de dados
            while (rs.next()) {
                ItemSale item = new ItemSale();
                Products product = new Products();

                product.setProduct(rs.getString("p.product"));
                item.setQty(rs.getInt("i.qty"));
                product.setPrice(rs.getInt("p.price"));
                item.setSubtotal(rs.getDouble("i.subtotal"));

                item.setProduct(product);

                listItems.add(item);

            }

            return listItems;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e);
            return null;
        }
    }

}
