package ru.hse.lupuleac.skills;

import org.junit.Assert;
import ru.hse.lupuleac.SkillCalculator;
import ru.hse.lupuleac.skills.Skill;

import static org.junit.Assert.assertEquals;

public class TestHelper {
    public static void test(int expected, String filename, Skill skill) throws Exception {
        String root = "src/test/resources/src/main/java/ru/hse/lupuleac";
        Assert.assertEquals(expected, SkillCalculator.getScore(skill, root + "/" + filename,
                root));
    }
}

