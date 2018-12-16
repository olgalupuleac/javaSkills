package ru.hse.lupuleac.skills;

import org.junit.Test;

public class ArraySkillTest {

    @Test
    public void visit() throws Exception {
        TestHelper.test(8, "ArrayExample.java", new ArraySkill());
    }
}