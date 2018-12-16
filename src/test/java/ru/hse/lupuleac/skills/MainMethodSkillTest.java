package ru.hse.lupuleac.skills;

import org.junit.Test;

public class MainMethodSkillTest {

    @Test
    public void visit() throws Exception {
        TestHelper.test(0, "MainMethodExample.java", new MainMethodSkill());
    }
}