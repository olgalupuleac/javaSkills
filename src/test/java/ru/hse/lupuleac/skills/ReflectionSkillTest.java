package ru.hse.lupuleac.skills;

import org.junit.Test;

public class ReflectionSkillTest {

    @Test
    public void visit() throws Exception {
        TestHelper.test(3, "ReflectionExample.java", new ReflectionSkill());
    }
}