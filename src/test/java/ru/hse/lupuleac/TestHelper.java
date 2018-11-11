package ru.hse.lupuleac;

import static org.junit.Assert.assertEquals;

public class TestHelper {
    public static void test(int expected, String filename, Skill skill) throws Exception {
        String root = "src/test/resources/src/main/java/ru/hse/lupuleac";
        assertEquals(expected, SkillCalculator.getScore(skill, root + "/" + filename,
                root));
    }
}

