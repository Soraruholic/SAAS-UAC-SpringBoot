package com.bit.saas_uac.utils;

import java.sql.*;

public class DatabaseInitializer {

    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/SAAS?useUnicode=true&characterEncoding=utf-8&useSSL=false";
    static final String USER = "root";
    static final String PASS = "saas123";

    private static void dropTables() throws Exception {
        Class.forName(JDBC_DRIVER);
        Connection con = DriverManager.getConnection(DB_URL, USER, PASS);

        String dropUserTable = "DROP TABLE IF EXISTS User;";
        String dropRoleTable = "DROP TABLE IF EXISTS Role;";
        String dropUserRoleTable = "DROP TABLE IF EXISTS UserRole;";

        Statement stat = con.createStatement();

        int count1 = stat.executeUpdate(dropUserTable);
        int count2 = stat.executeUpdate(dropRoleTable);
        int count3 = stat.executeUpdate(dropUserRoleTable);

        if (count1 == 0 && count2 == 0 && count3 == 0) {
            System.out.println("All tables dropped successfully");
        }
        stat.close();
        con.close();
    }
    private static void createUserTable() throws Exception {
        Class.forName(JDBC_DRIVER);
        Connection con = DriverManager.getConnection(DB_URL, USER, PASS);

        String createUserTable = "CREATE TABLE IF NOT EXISTS User (" +
                "userID VARCHAR(255) NOT NULL," +
                "userName VARCHAR(255) NOT NULL," +
                "userPassword VARCHAR(255) NOT NULL," +
                "userEmail VARCHAR(255) NOT NULL," +
                "userPhone VARCHAR(255) NOT NULL," +
                "lastPasswordResetDate VARCHAR(255) NOT NULL," +
                "PRIMARY KEY (userID)" +
                ");";
        Statement stat = con.createStatement();
        int count = stat.executeUpdate(createUserTable);
        if (count == 0) {
            System.out.println("User table created successfully");
        }
        stat.close();
        con.close();
    }
    private static void createRoleTable() throws Exception {
        Class.forName(JDBC_DRIVER);
        Connection con = DriverManager.getConnection(DB_URL, USER, PASS);

        String createRoleTable = "CREATE TABLE IF NOT EXISTS Role (" +
                "roleID VARCHAR(255) NOT NULL," +
                "roleDescription VARCHAR(255) NOT NULL," +
                "PRIMARY KEY (roleID)" +
                ");";
        Statement stat = con.createStatement();
        int count = stat.executeUpdate(createRoleTable);
        if (count == 0) {
            System.out.println("Role table created successfully");
        }
        stat.close();
        con.close();
    }
    private static void createUserRoleTable() throws Exception {
        Class.forName(JDBC_DRIVER);
        Connection con = DriverManager.getConnection(DB_URL, USER, PASS);

        String createUserRoleTable = "CREATE TABLE IF NOT EXISTS UserRole (" +
                "roleID VARCHAR(255) NOT NULL," +
                "userID VARCHAR(255) NOT NULL," +
                "FOREIGN KEY (roleID) REFERENCES Role(roleID)," +
                "FOREIGN KEY (userID) REFERENCES User(userID)" +
                ");";
        Statement stat = con.createStatement();
        int count = stat.executeUpdate(createUserRoleTable);
        if (count == 0) {
            System.out.println("UserRole table created successfully");
        }
        stat.close();
        con.close();
    }

    public static void initialize() throws Exception {
        dropTables();
        createUserTable();
        createRoleTable();
        createUserRoleTable();
    }
    public static void main(String[] args) throws Exception {
        initialize();
    }
}