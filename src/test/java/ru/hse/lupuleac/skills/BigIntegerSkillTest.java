package ru.hse.lupuleac.skills;

import org.junit.Test;

public class BigIntegerSkillTest {

    @Test
    public void visit() throws Exception {
        TestHelper.test(3, "BigIntegerExample.java", new BigIntegerSkill());
    }
}