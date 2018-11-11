package ru.hse.lupuleac;

import org.junit.Test;

import static org.junit.Assert.*;

public class LogicalOperationsSkillTest {

    @Test
    public void visit() throws Exception {
        TestHelper.test(6, "LogicalOperationsExample.java", new LogicalOperationsSkill());
    }
}