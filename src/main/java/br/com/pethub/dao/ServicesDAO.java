package br.com.pethub.dao;

import br.com.pethub.jdbc.ConnectionFactory;
import br.com.pethub.model.Customers;
import br.com.pethub.model.Pets;
import br.com.pethub.model.Schedule;
import br.com.pethub.model.Services;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ServicesDAO {

    private Connection con;

    public ServicesDAO() {
        this.con = new ConnectionFactory().getConnection();
    }

    public void addServices(Services obj) {
        try {
            String sql = "insert into tb_services (service_name, service_description, price_large, price_medium, price_small)"
                    + "values (?,?,?,?,?)";

            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, obj.getService_name());
            stmt.setString(2, obj.getService_description());
            stmt.setDouble(3, obj.getPrice_large());
            stmt.setDouble(4, obj.getPrice_medium());
            stmt.setDouble(5, obj.getPrice_small());

            stmt.execute();
            stmt.close();

            JOptionPane.showMessageDialog(null, "Serviço cadastrado com sucesso!");

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro: " + erro);
        }
    }

    public void editServices(Services obj) {
        try {
            String sql = "update tb_services set service_name=?, service_description=?, price_large=?, price_medium=?, price_small=? where id=?";

            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, obj.getService_name());
            stmt.setString(2, obj.getService_description());
            stmt.setDouble(3, obj.getPrice_large());
            stmt.setDouble(4, obj.getPrice_medium());
            stmt.setDouble(5, obj.getPrice_small());
            stmt.setInt(6, obj.getId());

            stmt.execute();
            stmt.close();

            JOptionPane.showMessageDialog(null, "Serviço alterado com sucesso!");

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro: " + erro);
        }
    }

    public void deleteServices(Services obj) {
        try {

            deleteServiceSchedulesByServiceId(obj.getId());

            String sql = "delete from tb_services where id=?";

            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, obj.getId());

            stmt.execute();
            stmt.close();

            JOptionPane.showMessageDialog(null, "Serviços e agendamentos excluídos com sucesso!");

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro: " + erro);
        }
    }

    public List<Services> listServices() {
        try {
            List<Services> listServices = new ArrayList<>();

            String sql = "SELECT * FROM tb_services";
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Services obj = new Services();

                obj.setId(rs.getInt("id"));
                obj.setService_name(rs.getString("service_name"));
                obj.setService_description(rs.getString("service_description"));
                obj.setPrice_large(rs.getDouble("price_large"));
                obj.setPrice_medium(rs.getDouble("price_medium"));
                obj.setPrice_small(rs.getDouble("price_small"));

                listServices.add(obj);
            }

            return listServices;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e);
            return null;
        }
    }

    public List<Services> searchServicesByName(String name) {
        try {
            List<Services> listServices = new ArrayList<>();

            String sql = "SELECT * FROM tb_services WHERE service_name LIKE ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, "%" + name + "%");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Services obj = new Services();

                obj.setId(rs.getInt("id"));
                obj.setService_name(rs.getString("service_name"));
                obj.setService_description(rs.getString("service_description"));
                obj.setPrice_large(rs.getDouble("price_large"));
                obj.setPrice_medium(rs.getDouble("price_medium"));
                obj.setPrice_small(rs.getDouble("price_small"));

                listServices.add(obj);
            }

            return listServices;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e);
            return null;
        }
    }

    public List<Schedule> listSchedules() {
        try {
            List<Schedule> listSchedules = new ArrayList<>();

            String sql = "SELECT s.*, c.name as customer_name, p.pet_name as pet_name, sv.service_name as service_name, DATE_FORMAT(s.date, '%d/%m/%Y') AS date_formatted FROM tb_service_schedules s "
                    + "JOIN tb_customers c ON s.for_id = c.id "
                    + "JOIN tb_pets p ON s.for_pet = p.id "
                    + "JOIN tb_services sv ON s.service_id = sv.id";
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Schedule obj = new Schedule();
                Customers customer = new Customers();
                Pets pet = new Pets();
                Services service = new Services();

                obj.setId(rs.getInt("id"));
                obj.setDate(rs.getString("date_formatted"));
                obj.setTime(rs.getString("time"));
                obj.setStatus(rs.getString("status"));
                obj.setTotal_Value(rs.getDouble("total_value"));

                customer.setName(rs.getString("customer_name"));
                obj.setCustumers(customer);

                pet.setPet_name(rs.getString("pet_name"));
                obj.setPets(pet);

                service.setService_name(rs.getString("service_name"));
                obj.setServices(service);

                listSchedules.add(obj);
            }

            return listSchedules;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e);
            return null;
        }
    }

    public List<Schedule> listSchedules(LocalDate date_start, LocalDate date_end) {
        try {
            List<Schedule> listSchedules = new ArrayList<>();

            String sql = "SELECT s.*, c.name as customer_name, p.pet_name as pet_name, sv.service_name as service_name, DATE_FORMAT(s.date, '%d/%m/%Y') AS date_formatted FROM tb_service_schedules s "
                    + "JOIN tb_customers c ON s.for_id = c.id "
                    + "JOIN tb_pets p ON s.for_pet = p.id "
                    + "JOIN tb_services sv ON s.service_id = sv.id "
                    + "WHERE s.date >= ? AND s.date < ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, date_start.toString());
            stmt.setString(2, date_end.plusDays(1).toString());

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Schedule obj = new Schedule();
                Customers customer = new Customers();
                Pets pet = new Pets();
                Services service = new Services();

                obj.setId(rs.getInt("id"));
                obj.setDate(rs.getString("date_formatted"));
                obj.setTime(rs.getString("time"));
                obj.setStatus(rs.getString("status"));
                obj.setTotal_Value(rs.getDouble("total_value"));

                customer.setName(rs.getString("customer_name"));
                obj.setCustumers(customer);

                pet.setPet_name(rs.getString("pet_name"));
                obj.setPets(pet);

                service.setService_name(rs.getString("service_name"));
                obj.setServices(service);

                listSchedules.add(obj);
            }

            return listSchedules;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e);
            return null;
        }
    }

    public List<Schedule> listSchedulesForToday() {
        List<Schedule> listSchedulesForToday = new ArrayList<>();

        String sql = "SELECT s.*, c.name as customer_name, p.pet_name as pet_name, sv.service_name as service_name, DATE_FORMAT(s.date, '%d/%m/%Y') AS date_formatted FROM tb_service_schedules s "
                + "JOIN tb_customers c ON s.for_id = c.id "
                + "JOIN tb_pets p ON s.for_pet = p.id "
                + "JOIN tb_services sv ON s.service_id = sv.id "
                + "WHERE s.date = CURDATE()";

        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Schedule obj = new Schedule();
                Customers customer = new Customers();
                Pets pet = new Pets();
                Services service = new Services();

                obj.setId(rs.getInt("id"));
                obj.setDate(rs.getString("date_formatted"));
                obj.setTime(rs.getString("time"));
                obj.setStatus(rs.getString("status"));
                obj.setTotal_Value(rs.getDouble("total_value"));

                customer.setName(rs.getString("customer_name"));
                obj.setCustumers(customer);

                pet.setPet_name(rs.getString("pet_name"));
                obj.setPets(pet);

                service.setService_name(rs.getString("service_name"));
                obj.setServices(service);

                listSchedulesForToday.add(obj);
            }

            return listSchedulesForToday;
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro: " + erro);
            return null;
        }
    }

    public Services getServicesByName(String name) {
        try {
            String sql = "SELECT * FROM tb_services WHERE service_name = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, name);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Services obj = new Services();

                obj.setId(rs.getInt("id"));
                obj.setService_name(rs.getString("service_name"));
                obj.setService_description(rs.getString("service_description"));
                obj.setPrice_large(rs.getDouble("price_large"));
                obj.setPrice_medium(rs.getDouble("price_medium"));
                obj.setPrice_small(rs.getDouble("price_small"));

                return obj;
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e);
        }
        return null;
    }

    public void addSchedule(Schedule obj) {
        try {
            String sql = "INSERT INTO tb_service_schedules (for_id, for_pet, service_id, date, time, status, total_value) VALUES (?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setInt(1, obj.getCustumers().getId());
            stmt.setInt(2, obj.getPets().getId());
            stmt.setInt(3, obj.getServices().getId());
            stmt.setString(4, obj.getDate());
            stmt.setString(5, obj.getTime());
            stmt.setString(6, obj.getStatus());
            stmt.setDouble(7, obj.getTotal_Value());

            stmt.execute();
            stmt.close();

            JOptionPane.showMessageDialog(null, "Agendamento adicionado com sucesso!");

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro: " + erro);
        }
    }

    public void editSchedule(Schedule obj) {
        try {
            String sql = "UPDATE tb_service_schedules SET for_id=?, for_pet=?, service_id=?, date=?, time=?, status=?, total_value=? WHERE id=?";

            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, obj.getCustumers().getId());
            stmt.setInt(2, obj.getPets().getId());
            stmt.setInt(3, obj.getServices().getId());
            stmt.setString(4, obj.getDate());
            stmt.setString(5, obj.getTime());
            stmt.setString(6, obj.getStatus());
            stmt.setDouble(7, obj.getTotal_Value());
            stmt.setInt(8, obj.getId());

            stmt.execute();
            stmt.close();

            JOptionPane.showMessageDialog(null, "Agendamento atualizado com sucesso!");

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro: " + erro);
        }
    }

    public void deleteSchedule(Schedule obj) {
        try {
            String sql = "DELETE FROM tb_service_schedules WHERE id=?";

            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, obj.getId());

            stmt.execute();
            stmt.close();

            JOptionPane.showMessageDialog(null, "Agendamento excluído com sucesso!");

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro: " + erro);
        }
    }

    public boolean checkScheduleConflict(Schedule obj) {
        try {
            String sql = "SELECT * FROM tb_service_schedules WHERE time = ? AND service_id = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, obj.getTime());
            stmt.setInt(2, obj.getServices().getId());
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return true;
            }
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro: " + erro);
        }
        return false;
    }

    public void deleteScheduleByPetId(int petId) {
        try {
            String sqlServices = "DELETE FROM tb_service_schedules WHERE for_pet = ?";
            PreparedStatement stmtServices = con.prepareStatement(sqlServices);
            stmtServices.setInt(1, petId);
            stmtServices.execute();
            stmtServices.close();
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro: " + erro);
        }
    }

    public void deleteServiceSchedulesByServiceId(int serviceId) {
        try {
            String sqlSchedules = "DELETE FROM tb_service_schedules WHERE service_id = ?";
            PreparedStatement stmtSchedules = con.prepareStatement(sqlSchedules);
            stmtSchedules.setInt(1, serviceId);
            stmtSchedules.execute();
            stmtSchedules.close();
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro: " + erro);
        }
    }

}
