package ru.hse.lupuleac;

import org.junit.Test;

import static org.junit.Assert.*;

public class ArraySkillTest {

    @Test
    public void visit() throws Exception {
        TestHelper.test(8, "ArrayExample.java", new ArraySkill());
    }
}