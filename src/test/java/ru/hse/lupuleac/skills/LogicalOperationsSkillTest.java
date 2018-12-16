package ru.hse.lupuleac.skills;

import org.junit.Test;

public class LogicalOperationsSkillTest {

    @Test
    public void visit() throws Exception {
        TestHelper.test(6, "LogicalOperationsExample.java", new LogicalOperationsSkill());
    }
}