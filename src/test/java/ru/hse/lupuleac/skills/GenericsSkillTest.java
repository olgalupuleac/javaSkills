package ru.hse.lupuleac.skills;

import org.junit.Test;

public class GenericsSkillTest {

    @Test
    public void visit() throws Exception {
        TestHelper.test(2, "GenericsExample.java", new GenericsSkill());
    }
}