package ru.hse.lupuleac.skills;

import org.junit.Test;

public class ExceptionsSkillTest {

    @Test
    public void visit() throws Exception {
        TestHelper.test(1, "ExceptionsExample.java", new ExceptionsSkill());
    }
}