package ru.hse.lupuleac.skills;

import org.junit.Test;

public class BitOperationsSkillTest {

    @Test
    public void visit() throws Exception {
        TestHelper.test(13, "BitOperationsExample.java", new BitOperationsSkill());
    }
}