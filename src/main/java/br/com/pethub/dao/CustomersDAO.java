/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.pethub.dao;

import br.com.pethub.jdbc.ConnectionFactory;
import br.com.pethub.model.Customers;
import java.io.InputStream;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Daniel Fernandes
 */

/**
 * This class is responsible for managing the data access for the Customers in the application.
 * It provides methods to add, edit, delete, list, and search customers in the database.
 * It also provides a method to generate a report of all customers.
 */
public class CustomersDAO {

    private Connection con;

    /**
     * The constructor method of the CustomersDAO class.
     */
    public CustomersDAO() {
        this.con = new ConnectionFactory().getConnection();
    }

    /**
     * This method adds a customer to the database.
     * @param obj The customer object to be added.
     */
    public void addCustomer(Customers obj) {

        try {
            Customers existingCustomer = searchCustomerByCPF(obj.getCpf());
            if (existingCustomer != null) {
                JOptionPane.showMessageDialog(null, "Já existe um cliente cadastrado com este CPF.");
                return;
            }

            String sql = "insert into tb_customers (name, rg, cpf, email, landline, phone, cep, address, number,"
                    + "complement, district, city, state)"
                    + "values (?,?,?,?,?,?,?,?,?,?,?,?,?)";

            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, obj.getName());
            stmt.setString(2, obj.getRg());
            stmt.setString(3, obj.getCpf());
            stmt.setString(4, obj.getEmail());
            stmt.setString(5, obj.getLandline());
            stmt.setString(6, obj.getPhone());
            stmt.setString(7, obj.getCep());
            stmt.setString(8, obj.getAddress());
            stmt.setInt(9, obj.getNumber());
            stmt.setString(10, obj.getComplement());
            stmt.setString(11, obj.getDistrict());
            stmt.setString(12, obj.getCity());
            stmt.setString(13, obj.getState());

            stmt.execute();
            stmt.close();

            JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso!");

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro: " + erro);
        }

    }

    /**
     * This method edits a customer in the database.
     * @param obj The customer object to be edited.
     */
    public void editCustomer(Customers obj) {

        try {

            String sql = "update tb_customers set name = ?, rg = ?, cpf = ?, email = ?, landline = ?, phone = ?, cep = ?, address = ?, number = ?,"
                    + "complement = ?, district = ?, city = ?, state = ? where id = ?";

            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, obj.getName());
            stmt.setString(2, obj.getRg());
            stmt.setString(3, obj.getCpf());
            stmt.setString(4, obj.getEmail());
            stmt.setString(5, obj.getLandline());
            stmt.setString(6, obj.getPhone());
            stmt.setString(7, obj.getCep());
            stmt.setString(8, obj.getAddress());
            stmt.setInt(9, obj.getNumber());
            stmt.setString(10, obj.getComplement());
            stmt.setString(11, obj.getDistrict());
            stmt.setString(12, obj.getCity());
            stmt.setString(13, obj.getState());
            stmt.setInt(14, obj.getId());

            stmt.execute();
            stmt.close();

            JOptionPane.showMessageDialog(null, "Cliente editado com sucesso!");

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro: " + erro);
        }

    }

    /**
     * This method deletes a customer from the database.
     * @param obj The customer object to be deleted.
     */
    public void deleteCustomer(Customers obj) {
        SalesDAO salesDAO = new SalesDAO();
        salesDAO.deleteSalesByCustomerId(obj.getId());

        PetsDAO petsDAO = new PetsDAO();
        petsDAO.deletePetsByCustomerId(obj.getId());

        VaccineDAO vaccineDAO = new VaccineDAO();
        vaccineDAO.deleteVaccinesByCustomerId(obj.getId());

        ItemSaleDAO itemSaleDAO = new ItemSaleDAO();
        itemSaleDAO.deleteItemsSaleByCustomerId(obj.getId());

        try {

            String sql = "delete from tb_customers where id = ?";

            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, obj.getId());

            stmt.execute();
            stmt.close();

            JOptionPane.showMessageDialog(null, "Cliente e seus registros relacionados foram excluídos com sucesso!");

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro: " + erro);
        }

    }

    /**
     * This method lists all customers in the database.
     * @return A list of all customers in the database.
     */
    public List<Customers> listCustomers() {
        try {

            List<Customers> listCustomer = new ArrayList<>();

            String sql = "select * from tb_customers";
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Customers obj = new Customers();
                obj.setId(rs.getInt("id"));
                obj.setName(rs.getString("name"));
                obj.setRg(rs.getString("rg"));
                obj.setCpf(rs.getString("cpf"));
                obj.setEmail(rs.getString("email"));
                obj.setLandline(rs.getString("landline"));
                obj.setPhone(rs.getString("phone"));
                obj.setCep(rs.getString("cep"));
                obj.setAddress(rs.getString("address"));
                obj.setNumber(rs.getInt("number"));
                obj.setComplement(rs.getString("complement"));
                obj.setDistrict(rs.getString("district"));
                obj.setCity(rs.getString("city"));
                obj.setState(rs.getString("state"));

                listCustomer.add(obj);
            }

            return listCustomer;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e);
            return null;
        }
    }

    /**
     * This method searches for a customer in the database by name.
     * @param name The name of the customer to be searched.
     * @return A list of customers with the name searched.
     */
    public List<Customers> searchCustomer(String name) {
        try {

            List<Customers> listCustomer = new ArrayList<>();

            String sql = "select * from tb_customers where name like ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, name);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Customers obj = new Customers();
                obj.setId(rs.getInt("id"));
                obj.setName(rs.getString("name"));
                obj.setRg(rs.getString("rg"));
                obj.setCpf(rs.getString("cpf"));
                obj.setEmail(rs.getString("email"));
                obj.setLandline(rs.getString("landline"));
                obj.setPhone(rs.getString("phone"));
                obj.setCep(rs.getString("cep"));
                obj.setAddress(rs.getString("address"));
                obj.setNumber(rs.getInt("number"));
                obj.setComplement(rs.getString("complement"));
                obj.setDistrict(rs.getString("district"));
                obj.setCity(rs.getString("city"));
                obj.setState(rs.getString("state"));

                listCustomer.add(obj);
            }

            return listCustomer;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e);
            return null;
        }
    }

    /**
     * This method searches for a customer in the database by CPF.
     * @param cpf The CPF of the customer to be searched.
     * @return The customer with the CPF searched.
     */
    public Customers searchCustomerByCPF(String cpf) {
        try {

            String sql = "select * from tb_customers where cpf = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, cpf);

            ResultSet rs = stmt.executeQuery();
            Customers obj = null;

            if (rs.next()) {
                obj = new Customers();
                obj.setId(rs.getInt("id"));
                obj.setName(rs.getString("name"));
                obj.setRg(rs.getString("rg"));
                obj.setCpf(rs.getString("cpf"));
                obj.setEmail(rs.getString("email"));
                obj.setLandline(rs.getString("landline"));
                obj.setPhone(rs.getString("phone"));
                obj.setCep(rs.getString("cep"));
                obj.setAddress(rs.getString("address"));
                obj.setNumber(rs.getInt("number"));
                obj.setComplement(rs.getString("complement"));
                obj.setDistrict(rs.getString("district"));
                obj.setCity(rs.getString("city"));
                obj.setState(rs.getString("state"));

            }

            return obj;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e);
            return null;
        }
    }

    /**
     * This method is used to consult a customer by name.
     * @param name The name of the customer to consult.
     * @return The customer that matches the provided name, or null if no match is found.
     */
    public Customers consultCustomers(String name) {
        try {

            String sql = "select * from tb_customers where name = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, name);
            ResultSet rs = stmt.executeQuery();

            Customers obj = new Customers();

            if (rs.next()) {

                obj.setId(rs.getInt("id"));
                obj.setName(rs.getString("name"));
                obj.setRg(rs.getString("rg"));
                obj.setCpf(rs.getString("cpf"));
                obj.setEmail(rs.getString("email"));
                obj.setLandline(rs.getString("landline"));
                obj.setPhone(rs.getString("phone"));
                obj.setCep(rs.getString("cep"));
                obj.setAddress(rs.getString("address"));
                obj.setNumber(rs.getInt("number"));
                obj.setComplement(rs.getString("complement"));
                obj.setDistrict(rs.getString("district"));
                obj.setCity(rs.getString("city"));
                obj.setState(rs.getString("state"));
            }

            return obj;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e);
            return null;
        }
    }

    /**
     * This method generates a report of all customers in the database.
     */
    public void clientsReport() {
        try {
            String sql = "select * from tb_customers";

            InputStream inputStream = getClass().getResourceAsStream("/br/com/pethub/reports/clientsReport.jrxml");
            JasperDesign jd = JRXmlLoader.load(inputStream);
            JRDesignQuery query = new JRDesignQuery();
            query.setText(sql);
            jd.setQuery(query);

            JasperReport jr = JasperCompileManager.compileReport(jd);
            JasperPrint jp = JasperFillManager.fillReport(jr, null, con);

            JasperViewer.viewReport(jp, false);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e);
        }
    }

}
