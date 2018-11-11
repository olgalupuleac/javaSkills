package ru.hse.lupuleac;

import org.junit.Test;

import static org.junit.Assert.*;

public class ExceptionsSkillTest {

    @Test
    public void visit() throws Exception {
        TestHelper.test(1, "ExceptionsExample.java", new ExceptionsSkill());
    }
}