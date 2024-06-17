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
 * @author Daniel Fernandes
 */

/**
 * This class is responsible for managing the data access for the ItemSale in the application.
 * It provides methods to add items to a sale and list items in a sale.
 */
public class ItemSaleDAO {

    private Connection con;

    /**
     * The constructor method of the ItemSaleDAO class.
     */
    public ItemSaleDAO() {
        this.con = new ConnectionFactory().getConnection();
    }

    /**
     * This method is used to add an item to a sale.
     * @param obj The ItemSale object to be added.
     */
    public void addItem(ItemSale obj) {
        try {

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

    /**
     * This method is used to list all items in a sale.
     * @param sale_Id The ID of the sale.
     * @return A list of ItemSale objects.
     */
    public List<ItemSale> ListItemSales(int sale_Id) {
        try {

            List<ItemSale> listItems = new ArrayList<>();

            String sql = "select p.product, i.qty, p.price, i.subtotal from tb_itemssales as i "
                    + "inner join tb_products as p on (i.product_id = p.id) "
                    + "where i.sale_id = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, sale_Id);

            ResultSet rs = stmt.executeQuery();
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

    /**
     * This method is used to delete all items from a sale by customer ID.
     * @param customerId The ID of the customer.
     */
    public void deleteItemsSaleByCustomerId(int customerId) {
        try {
            String sql = "delete from tb_itemssales where sale_id in (select id from tb_sales where client_id = ?)";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, customerId);

            stmt.execute();
            stmt.close();

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ao deletar itens de venda: " + erro);
        }
    }

}
