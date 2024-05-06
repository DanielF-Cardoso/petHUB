package br.com.pethub.dao;

import br.com.pethub.jdbc.ConnectionFactory;
import br.com.pethub.model.Sales;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author danie
 */

public class SalesDAO {

    private Connection con;

    public SalesDAO(){
        this.con = new ConnectionFactory().getConnection();
    }

    public void addSales(Sales obj){

        try {

            //Criar o comando sql

            String sql = "insert into tb_sales (client_id, sale_date, total_sale, note)"
                    + "values (?,?,?,?)";

            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, obj.getCustomer().getId());
            stmt.setString(2, obj.getSale_date());
            stmt.setDouble(3, obj.getTotal_sale());
            stmt.setString(4, obj.getNote());

            stmt.execute();
            stmt.close();


        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro: " + erro);
        }

    }

    public int returnLastSale(){
        int idSale = 0;
        try {
            String sql = "select max(id) id from tb_sales";
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                Sales sales = new Sales();
                sales.setId(rs.getInt("id"));
                idSale = sales.getId();
            }
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro: " + erro);
        }
        return idSale;
    }


}
