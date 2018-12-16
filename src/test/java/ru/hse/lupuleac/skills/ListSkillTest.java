package ru.hse.lupuleac.skills;

import org.junit.Assert;
import org.junit.Test;
import ru.hse.lupuleac.SkillCalculator;
import ru.hse.lupuleac.skills.ListSkill;

import static org.junit.Assert.*;

public class ListSkillTest {

    @Test
    public void visit() throws Exception {
        Assert.assertEquals(8, SkillCalculator.getScore(new ListSkill(), "src/test/resources/src/main/java/ru/hse/lupuleac/ListExample.java",
                "src/test/resources/src/main/java/ru/hse/lupuleac"));
    }
}