package ru.hse.lupuleac.skills;

import org.junit.Test;

public class AbstractClassSkillTest {
    @Test
    public void visit() throws Exception {
        TestHelper.test(2, "AbstractClassExample.java", new AbstractClassSkill());
    }
}