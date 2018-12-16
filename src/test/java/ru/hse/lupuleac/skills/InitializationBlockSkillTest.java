package ru.hse.lupuleac.skills;

import org.junit.Test;

public class InitializationBlockSkillTest {

    @Test
    public void visit() throws Exception {
        TestHelper.test(2, "InitializationBlockExample.java", new InitializationBlockSkill());
    }
}