package br.com.pethub.dao;

import br.com.pethub.jdbc.ConnectionFactory;
import br.com.pethub.model.Employees;
import br.com.pethub.view.DashboardScreen;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeesDAO {

    private Connection con;

    public EmployeesDAO() {
        this.con = new ConnectionFactory().getConnection();
    }

    public void addEmployees(Employees obj) {

        try {

            //Criar o comando sql
            String sql = "insert into tb_employees (name, rg, cpf, email, password, responsibility, access_level, landline, phone, cep, address, number,"
                    + "complement, district, city, state)"
                    + "values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, obj.getName());
            stmt.setString(2, obj.getRg());
            stmt.setString(3, obj.getCpf());
            stmt.setString(4, obj.getEmail());
            stmt.setString(5, obj.getPassword());
            stmt.setString(6, obj.getResponsibility());
            stmt.setString(7, obj.getAccess_level());
            stmt.setString(8, obj.getLandline());
            stmt.setString(9, obj.getPhone());
            stmt.setString(10, obj.getCep());
            stmt.setString(11, obj.getAddress());
            stmt.setInt(12, obj.getNumber());
            stmt.setString(13, obj.getComplement());
            stmt.setString(14, obj.getDistrict());
            stmt.setString(15, obj.getCity());
            stmt.setString(16, obj.getState());

            stmt.execute();
            stmt.close();

            JOptionPane.showMessageDialog(null, "Funcionário cadastrado com sucesso!");

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro: " + erro);
        }
    }

    public void editEmployees(Employees obj) {

        try {

            //Criar o comando sql
            String sql = "update tb_employees set name = ?, rg = ?, cpf = ?, email = ?, "
                    + "password = ?, responsibility = ?, access_level = ?, landline = ?, phone = ?, cep = ?, address = ?, number = ?,"
                    + "complement = ?, district = ?, city = ?, state = ? where id = ?";

            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, obj.getName());
            stmt.setString(2, obj.getRg());
            stmt.setString(3, obj.getCpf());
            stmt.setString(4, obj.getEmail());
            stmt.setString(5, obj.getPassword());
            stmt.setString(6, obj.getResponsibility());
            stmt.setString(7, obj.getAccess_level());
            stmt.setString(8, obj.getLandline());
            stmt.setString(9, obj.getPhone());
            stmt.setString(10, obj.getCep());
            stmt.setString(11, obj.getAddress());
            stmt.setInt(12, obj.getNumber());
            stmt.setString(13, obj.getComplement());
            stmt.setString(14, obj.getDistrict());
            stmt.setString(15, obj.getCity());
            stmt.setString(16, obj.getState());
            stmt.setInt(17, obj.getId());

            stmt.execute();
            stmt.close();

            JOptionPane.showMessageDialog(null, "Funcionário editado com sucesso!");

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro: " + erro);
        }

    }

    public void deleteEmployees(Employees obj) {

        try {

            //Criar o comando sql
            String sql = "delete from tb_employees where id = ?";

            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, obj.getId());

            stmt.execute();
            stmt.close();

            JOptionPane.showMessageDialog(null, "Funcionário excluido com sucesso!");

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro: " + erro);
        }

    }

    public List<Employees> listEmployees() {
        try {

            List<Employees> listEmployees = new ArrayList<>();

            String sql = "select * from tb_employees";
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery(); //retorna um conjunto de dados

            while (rs.next()) {
                Employees obj = new Employees();
                obj.setId(rs.getInt("id"));
                obj.setName(rs.getString("name"));
                obj.setRg(rs.getString("rg"));
                obj.setCpf(rs.getString("cpf"));
                obj.setEmail(rs.getString("email"));
                obj.setPassword(rs.getString("password"));
                obj.setResponsibility(rs.getString("responsibility"));
                obj.setAccess_level(rs.getString("access_level"));
                obj.setLandline(rs.getString("landline"));
                obj.setPhone(rs.getString("phone"));
                obj.setCep(rs.getString("cep"));
                obj.setAddress(rs.getString("address"));
                obj.setNumber(rs.getInt("number"));
                obj.setComplement(rs.getString("complement"));
                obj.setDistrict(rs.getString("district"));
                obj.setCity(rs.getString("city"));
                obj.setState(rs.getString("state"));

                listEmployees.add(obj);
            }

            return listEmployees;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e);
            return null;
        }
    }

    public List<Employees> searchEmployees(String name) {
        try {

            List<Employees> listEmployees = new ArrayList<>();

            String sql = "select * from tb_employees where name like ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, name);
            ResultSet rs = stmt.executeQuery(); //retorna um conjunto de dados

            while (rs.next()) {
                Employees obj = new Employees();
                obj.setId(rs.getInt("id"));
                obj.setName(rs.getString("name"));
                obj.setRg(rs.getString("rg"));
                obj.setCpf(rs.getString("cpf"));
                obj.setEmail(rs.getString("email"));
                obj.setPassword(rs.getString("password"));
                obj.setResponsibility(rs.getString("responsibility"));
                obj.setAccess_level(rs.getString("access_level"));
                obj.setLandline(rs.getString("landline"));
                obj.setPhone(rs.getString("phone"));
                obj.setCep(rs.getString("cep"));
                obj.setAddress(rs.getString("address"));
                obj.setNumber(rs.getInt("number"));
                obj.setComplement(rs.getString("complement"));
                obj.setDistrict(rs.getString("district"));
                obj.setCity(rs.getString("city"));
                obj.setState(rs.getString("state"));

                listEmployees.add(obj);
            }

            return listEmployees;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e);
            return null;
        }
    }

    public void toLogin(String email, String password) {
        try {
            String sql = "select * from tb_employees where email = ? and password = ?";

            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, email);
            stmt.setString(2, password);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                JOptionPane.showMessageDialog(null, "Seja bem vindo ao Sistema");
                DashboardScreen screen = new DashboardScreen();
                screen.userLogin = rs.getString("name");
                screen.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null, "Dados incorretos");
            }
            
            rs.close();
            stmt.close();

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro : " + erro);
        }
    }

}