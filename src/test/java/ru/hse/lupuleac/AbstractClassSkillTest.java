package ru.hse.lupuleac;

import org.junit.Test;

import static org.junit.Assert.*;

public class AbstractClassSkillTest {
    @Test
    public void visit() throws Exception {
        TestHelper.test(2, "AbstractClassExample.java", new AbstractClassSkill());
    }
}