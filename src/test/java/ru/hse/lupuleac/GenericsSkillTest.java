package ru.hse.lupuleac;

import org.junit.Test;

import static org.junit.Assert.*;

public class GenericsSkillTest {

    @Test
    public void visit() throws Exception {
        TestHelper.test(2, "GenericsExample.java", new GenericsSkill());
    }
}