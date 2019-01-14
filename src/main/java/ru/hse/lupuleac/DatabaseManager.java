package ru.hse.lupuleac;

import com.sun.org.apache.xpath.internal.operations.Bool;
import org.jetbrains.annotations.NotNull;
import ru.hse.lupuleac.skills.Skill;

import java.io.File;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DatabaseManager {
    private static Connection c;

    private static void handleException(@NotNull Exception e) {
        System.err.println(e.getClass().getName() + ": " + e.getMessage());
        System.exit(0);
    }

    static {
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager
                    .getConnection("jdbc:postgresql://localhost:5432/skills",
                            "postgres", "123");
            System.out.println("Opened database successfully");
        } catch (Exception e) {
            handleException(e);
        }
    }


    private static void insertGrainedSkill(String grain, Statement stmt) throws Exception {
        String sql = "INSERT INTO GRAIN_SKILLS( NAME) " +
                "VALUES ('"  + grain + "')" +
                "ON CONFLICT (NAME)" +
                "DO NOTHING";
        System.out.println(sql);
        stmt.executeUpdate(sql);
    }

    private static void insertSkill(String skill, Statement stmt) throws Exception {
        String sql = "INSERT INTO SKILLS( NAME) " +
                "VALUES ('"  + skill + "')" +
                "ON CONFLICT (NAME)" +
                "DO NOTHING";
        System.out.println(sql);
        stmt.executeUpdate(sql);
    }

    private static void insertInvalid(int id) throws Exception {
        Statement statement = c.createStatement();
        String sql = "INSERT INTO unparseable_submissions " +
                "VALUES (" + id + ")" +
                "ON CONFLICT (ID)" +
                "DO NOTHING";
        statement.executeUpdate(sql);
    }

    private static void insertPerformance(String skill,
                                          Integer user,
                                          Integer problem, Integer attempt, Boolean isPassed)  {
        try {
            Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT ID FROM GRAIN_SKILLS WHERE (NAME = '" + skill + "')");
            Integer skillId = -1;
            while(rs.next()) {
                skillId = rs.getInt("ID");
            }
            if (skillId == -1) {
                throw new RuntimeException("Didn't find a skill");
            }
            stmt = c.createStatement();
            String sql = "INSERT INTO STUDENT_PERFORMANCE(USR, PROBLEM, ATTEMPT, IS_PASSED, SKILL)" +
                    "VALUES (" + String.join(", ", user.toString(), problem.toString(),
                    attempt.toString(), isPassed.toString(), skillId.toString()) + ")" +
                    "ON CONFLICT (USR, PROBLEM, ATTEMPT, SKILL)" +
                    "DO NOTHING";
            stmt.executeUpdate(sql);
        } catch (Exception e) {
            handleException(e);
        }
    }

    private static void codeToSkills(String code, int user, int step,  int attempt, boolean isPassed) throws Exception {
        Map<String, Set<String>> res = SkillFilter.getSkillsForCode(code);
        for (Map.Entry<String, Set<String>> e : res.entrySet()) {
            System.out.println(e.getKey());
            insertSkill(e.getKey(), c.createStatement());
            //insertProgress()
            for (String grain : e.getValue()) {
                insertGrainedSkill(skill, c.createStatement());
                insertPerformance(skill, user, step, attempt, isPassed);
            }
        }
        System.out.println("Done");
    }


    private static void getSkills() {
        try {
            Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT sub.id,  sub.usr,  sub.step,  sub.is_passed,\n" +
                    "                           sub.code,  sub.attempt, raw.code AS raw FROM student_performance AS st\n" +
                    "                                    RIGHT JOIN submissions AS sub ON\n" +
                    "                                               (st.usr = sub.usr AND\n" +
                    "                                                st.problem = sub.step AND\n" +
                    "                                                st.attempt = sub.attempt)\n" +
                    "                                    JOIN raw_submissions AS raw ON\n" +
                    "                                            (raw.usr = sub.usr AND\n" +
                    "                                             raw.step = sub.step AND\n" +
                    "                                             raw.attempt = sub.attempt)\n" +
                    "                                     LEFT JOIN unparseable_submissions AS u ON (\n" +
                    "                                 sub.id =  u.id\n" +
                    "    )\n" +
                    "                                        WHERE problem isnull AND u.id isnull ORDER BY sub.usr LIMIT 100000;");
            //Integer skillId = -1;
            while (rs.next()) {
                String code = rs.getString("code");
                Integer user = rs.getInt("usr");
                Integer step = rs.getInt("step");
                Integer attempt = rs.getInt("attempt");
                Boolean isPassed = rs.getBoolean("is_passed");
                String raw = rs.getString("raw");
                System.out.println(user + " " + step + " " + attempt);
               try  {
                    codeToSkills(code, user, step, attempt, isPassed);

                } catch (Throwable e) {
                   if (e instanceof Error) {
                       System.out.print(e.getClass());
                       insertInvalid(rs.getInt("id"));
                   } else {
                       try {
                           codeToSkills(raw, user, step, attempt, isPassed);
                       } catch (Throwable e1) {
                           insertInvalid(rs.getInt("id"));
                           System.out.println(e1.getClass());
                           System.out.println(raw);
                           System.out.println(rs.getInt("usr"));
                           System.out.println(rs.getInt("step"));
                       }
                   }
                }
            }
        } catch (Exception e) {
            handleException(e);
        }
    }

    public static void main(String args[]) {
        //createSkillsTable();
        //createProblemsTable();
        //createUsersTable();
        //createProgressTable();
        //insertIntoSkills();
        //insertIntoSkills();
        //trackProgress();
        getSkills();
        //createStudentPerformanceTable();
    }
}
//363 57792 9