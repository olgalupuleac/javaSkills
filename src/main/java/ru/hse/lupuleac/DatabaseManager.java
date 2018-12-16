package ru.hse.lupuleac;

import org.jetbrains.annotations.NotNull;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DatabaseManager {
    private static Connection c;

    private static void handleException(@NotNull Exception e) {
        System.err.println( e.getClass().getName()+": "+ e.getMessage() );
        System.exit(0);
    }

    static {
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager
                    .getConnection("jdbc:postgresql://localhost:5432/skills",
                            "postgres", "123");
            System.out.println("Opened database successfully");
        } catch ( Exception e ) {
           handleException(e);
        }
    }

    private static void createTable(String sql) {
        Statement stmt;
        try {
            stmt = c.createStatement();
            stmt.executeUpdate(sql);
            stmt.close();
            c.close();
        } catch ( Exception e ) {
            handleException(e);
        }
    }

    private static void createSkillsTable() {
        String sql = "CREATE TABLE SKILLS " +
                "(ID SERIAL PRIMARY KEY," +
                " NAME  VARCHAR(50)  NOT NULL UNIQUE)";
        createTable(sql);
    }

    private static void createUsersTable() {
        String sql = "CREATE TABLE USERS " +
                    "(ID INTEGER NOT NULL PRIMARY KEY)";
         createTable(sql);
    }

    private static void createProblemsTable() {
        String sql = "CREATE TABLE PROBLEMS " +
                "(ID INTEGER NOT NULL PRIMARY KEY)";
        createTable(sql);
    }

    private static void createProgressTable() {
        String sql = "CREATE TABLE PROGRESS " +
                "(ID SERIAL PRIMARY KEY," +
                "USER INTEGER NOT NULL REFERENCES(USERS)," +
                "PROBLEM INTEGER NOT NULL REFERENCES(PROBLEMS)," +
                "ATTEMPT INTEGER NOT NULL CHECK(ATTEMPT >= 0)," +
                "IS_PASSED BOOLEAN NOT NULL," +
                "SKILL INTEGER NOT NULL REFERENCES(SKILLS)," +
                "SCORE INTEGER NOT NULL CHECK(SCORE >= 0)," +
                "UNIQUE(USER, PROBLEM, ATTEMPT, SKILL))";
        createTable(sql);
    }

    private static void insertIntoSkills() {

    }
    public static void main( String args[] ) {

    }
}
