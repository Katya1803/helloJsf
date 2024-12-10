package com.example.helloworld;



import javax.annotation.PostConstruct;

import javax.faces.bean.ApplicationScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Named("employeeBean")
@ApplicationScoped
public class EmployeeBean implements Serializable {
    private List<Employee> employees;

    @PostConstruct
    public void init() {
        employees = new ArrayList<>();
        try {

            Class.forName("org.h2.Driver");
            Connection connection = DriverManager.getConnection("jdbc:h2:mem:testdb", "sa", "");

            Statement stmt = connection.createStatement();
            String sql = "CREATE TABLE Mt_employees (id INT AUTO_INCREMENT PRIMARY KEY, " +
                    "name VARCHAR(100), age INT, date_of_birth VARCHAR(20)); " +
                    "INSERT INTO Mt_employees (name, age, date_of_birth) VALUES " +
                    "('Vu Vu', 21, '2003-01-01'), " +
                    "('Thien Thien', 22, '2002-05-05'), " +
                    "('Katyusha', 21, '2003-01-01');";
            stmt.execute(sql);


            String query = "SELECT id, name, age, date_of_birth FROM Mt_employees";
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                Employee e = new Employee();
                e.setEmployeeCode(rs.getInt("id"));
                e.setEmployeeName(rs.getString("name"));
                e.setEmployeeAge(rs.getInt("age"));
                e.setDateOfBirth(rs.getString("date_of_birth"));
                employees.add(e);
            }

            connection.close();
            System.out.println("H2 Database initialized and data fetched successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Employee> getEmployees() {
        return employees;
    }
}
