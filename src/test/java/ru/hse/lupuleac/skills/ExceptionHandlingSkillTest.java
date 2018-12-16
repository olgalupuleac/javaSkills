package ru.hse.lupuleac.skills;

import org.junit.Test;

public class ExceptionHandlingSkillTest {

    @Test
    public void visit() throws Exception {
        TestHelper.test(1, "ExceptionHandlingExample.java", new ExceptionHandlingSkill());
    }
}