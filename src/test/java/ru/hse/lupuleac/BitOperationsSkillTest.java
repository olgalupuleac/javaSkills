package ru.hse.lupuleac;

import org.junit.Test;

import static org.junit.Assert.*;

public class BitOperationsSkillTest {

    @Test
    public void visit() throws Exception {
        TestHelper.test(13, "BitOperationsExample.java", new BitOperationsSkill());
    }
}