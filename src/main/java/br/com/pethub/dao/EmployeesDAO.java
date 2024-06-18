package br.com.pethub.dao;

import br.com.pethub.jdbc.ConnectionFactory;
import br.com.pethub.model.Employees;
import br.com.pethub.utils.EncryptPassword;
import br.com.pethub.view.DashboardScreen;
import br.com.pethub.view.LoginScreen;
import org.mindrot.jbcrypt.BCrypt;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * This class is responsible for managing the data access for the Employees in the application.
 * It provides methods to add, edit, delete, list, and search employees in the database.
 * It also provides a method to authenticate an employee.
 */
public class EmployeesDAO {

    private Connection con;

    /**
     * The constructor method of the EmployeesDAO class.
     */
    public EmployeesDAO() {
        this.con = new ConnectionFactory().getConnection();
    }

    /**
     * This method is used to add a new employee to the database.
     * @param obj The employee to be added.
     */
    public void addEmployees(Employees obj) {
        try {

            Employees existingEmployee = searchEmployeeByCPF(obj.getCpf());
            if (existingEmployee != null) {
                JOptionPane.showMessageDialog(null, "Já existe um funcionário cadastrado com este CPF.");
                return;
            }
            String sql = "insert into tb_employees (name, rg, cpf, email, password, responsibility, access_level, landline, phone, cep, address, number,"
                    + "complement, district, city, state)"
                    + "values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, obj.getName());
            stmt.setString(2, obj.getRg());
            stmt.setString(3, obj.getCpf());
            stmt.setString(4, obj.getEmail());

            EncryptPassword encryptor = new EncryptPassword();
            String encryptedPassword = encryptor.encryptPassword(obj.getPassword());
            stmt.setString(5, encryptedPassword);

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

    /**
     * This method is used to edit the details of an existing employee in the database.
     * @param obj The employee with the updated details.
     */
    public void editEmployees(Employees obj) {
        try {
            String sql = "update tb_employees set name = ?, rg = ?, cpf = ?, email = ?, "
                    + "responsibility = ?, access_level = ?, landline = ?, phone = ?, cep = ?, address = ?, number = ?,"
                    + "complement = ?, district = ?, city = ?, state = ?"
                    + (obj.getPassword() != null && !obj.getPassword().isEmpty() ? ", password = ? " : "")
                    + "where id = ?";

            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, obj.getName());
            stmt.setString(2, obj.getRg());
            stmt.setString(3, obj.getCpf());
            stmt.setString(4, obj.getEmail());
            stmt.setString(5, obj.getResponsibility());
            stmt.setString(6, obj.getAccess_level());
            stmt.setString(7, obj.getLandline());
            stmt.setString(8, obj.getPhone());
            stmt.setString(9, obj.getCep());
            stmt.setString(10, obj.getAddress());
            stmt.setInt(11, obj.getNumber());
            stmt.setString(12, obj.getComplement());
            stmt.setString(13, obj.getDistrict());
            stmt.setString(14, obj.getCity());
            stmt.setString(15, obj.getState());

            if (obj.getPassword() != null && !obj.getPassword().isEmpty()) {
                EncryptPassword encryptor = new EncryptPassword();
                String encryptedPassword = encryptor.encryptPassword(obj.getPassword());
                stmt.setString(16, encryptedPassword);
                stmt.setInt(17, obj.getId());
            } else {
                stmt.setInt(16, obj.getId());
            }

            stmt.execute();
            stmt.close();

            JOptionPane.showMessageDialog(null, "Funcionário editado com sucesso!");

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro: " + erro);
        }
    }

    /**
     * This method is used to delete an employee from the database.
     * @param obj The employee to be deleted.
     */
    public void deleteEmployees(Employees obj) {

        try {

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

    /**
     * This method is used to retrieve a list of all employees from the database.
     * @return A list of all employees.
     */
    public List<Employees> listEmployees() {
        try {

            List<Employees> listEmployees = new ArrayList<>();

            String sql = "select * from tb_employees";
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Employees obj = new Employees();
                obj.setId(rs.getInt("id"));
                obj.setName(rs.getString("name"));
                obj.setRg(rs.getString("rg"));
                obj.setCpf(rs.getString("cpf"));
                obj.setEmail(rs.getString("email"));
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

    /**
     * This method is used to search for employees by name.
     * @param name The name of the employee to search for.
     * @return A list of employees that match the provided name.
     */
    public List<Employees> searchEmployees(String name) {
        try {

            List<Employees> listEmployees = new ArrayList<>();

            String sql = "select * from tb_employees where name like ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, name);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Employees obj = new Employees();
                obj.setId(rs.getInt("id"));
                obj.setName(rs.getString("name"));
                obj.setRg(rs.getString("rg"));
                obj.setCpf(rs.getString("cpf"));
                obj.setEmail(rs.getString("email"));
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

    /**
     * This method is used to authenticate an employee by email and password.
     * @param email The email of the employee to authenticate.
     * @param password The password of the employee to authenticate.
     * @return true if the employee is authenticated, false otherwise.
     */
    public boolean toLogin(String email, String password) {
        try {
            String sql = "select * from tb_employees where email = ?";

            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, email);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                if (BCrypt.checkpw(password, rs.getString("password"))) {
                    if (rs.getString("access_level").equals("Administrador")) {
                        JOptionPane.showMessageDialog(null, "Bem-vindo ao PetHUB!");
                        DashboardScreen screen = new DashboardScreen();
                        screen.userLogin = rs.getString("name");
                        screen.setVisible(true);
                    } else if (rs.getString("access_level").equals("Vendedor")) {
                        JOptionPane.showMessageDialog(null, "Bem-vindo ao PetHUB!");
                        DashboardScreen screen = new DashboardScreen();
                        screen.userLogin = rs.getString("name");

                        screen.totalSalesDay.setVisible(false);
                        screen.historySalesMenu.setVisible(false);
                        screen.employeeMenu.setVisible(false);
                        screen.supplierMenu.setVisible(false);
                        screen.reportsMenu.setVisible(false);
                        screen.vaccineMenu.setVisible(false);

                        screen.setVisible(true);
                    } else if (rs.getString("access_level").equals("Veterinário")) {
                        JOptionPane.showMessageDialog(null, "Bem-vindo ao PetHUB!");
                        DashboardScreen screen = new DashboardScreen();
                        screen.userLogin = rs.getString("name");

                        screen.totalSalesDay.setVisible(false);
                        screen.historySalesMenu.setVisible(false);
                        screen.employeeMenu.setVisible(false);
                        screen.supplierMenu.setVisible(false);
                        screen.salesMenu.setVisible(false);
                        screen.reportsMenu.setVisible(false);

                        screen.setVisible(true);
                    }
                    rs.close();
                    stmt.close();
                    return true;
                } else {
                    JOptionPane.showMessageDialog(null, "Dados incorretos. Por favor, verifique suas credenciais e tente novamente.");
                    return false;
                }
            } else {
                JOptionPane.showMessageDialog(null, "Dados incorretos. Por favor, verifique suas credenciais e tente novamente.");
                return false;
            }

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro : " + erro);
            return false;
        }
    }

    /**
     * This method searches for an employee in the database by CPF.
     * @param cpf The CPF of the employee to be searched.
     * @return The employee with the CPF searched.
     */
    public Employees searchEmployeeByCPF(String cpf) {
        try {

            String sql = "select * from tb_employees where cpf = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, cpf);

            ResultSet rs = stmt.executeQuery();
            Employees obj = null;

            if (rs.next()) {
                obj = new Employees();
                obj.setId(rs.getInt("id"));
                obj.setName(rs.getString("name"));
                obj.setRg(rs.getString("rg"));
                obj.setCpf(rs.getString("cpf"));
                obj.setEmail(rs.getString("email"));
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
            }

            return obj;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e);
            return null;
        }
    }

}
