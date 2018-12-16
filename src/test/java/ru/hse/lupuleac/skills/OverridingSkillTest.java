package ru.hse.lupuleac.skills;

import org.junit.Test;

public class OverridingSkillTest {

    @Test
    public void visit() throws Exception {
        TestHelper.test(1, "OverridingExample.java", new OverridingSkill());
    }
}