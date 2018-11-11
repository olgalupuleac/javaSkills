package ru.hse.lupuleac;

import org.junit.Test;

import static org.junit.Assert.*;

public class InitializationBlockSkillTest {

    @Test
    public void visit() throws Exception {
        TestHelper.test(2, "InitializationBlockExample.java", new InitializationBlockSkill());
    }
}