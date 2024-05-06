package br.com.pethub.dao;

import br.com.pethub.jdbc.ConnectionFactory;
import br.com.pethub.model.Customers;
import br.com.pethub.model.Sales;
import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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

    public List<Sales> listSales(LocalDate date_start, LocalDate date_end) {
        try {
            
            List<Sales> listSale = new ArrayList<>();

            String sql = "select s.id, date_format(s.sale_date, '%d/%m/%y') as date_formatted, c.name, s.total_sale, s.note from tb_sales as s "
                    + "inner join tb_customers c on (s.client_id = c.id) "
                    + "where s.sale_date between ? and ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, date_start.toString());
            stmt.setString(2, date_end.toString());

            ResultSet rs = stmt.executeQuery(); //retorna um conjunto de dados
            while (rs.next()) {

                Sales sale = new Sales();
                Customers customer = new Customers();

                sale.setId(rs.getInt("s.id"));
                sale.setSale_date(rs.getString("date_formatted"));
                customer.setName(rs.getString("c.name"));
                sale.setTotal_sale(rs.getDouble("s.total_sale"));
                sale.setNote(rs.getString("s.note"));

                sale.setCustomer(customer);

                listSale.add(sale);
            }

            return listSale;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e);
            return null;
        }
    }


}
