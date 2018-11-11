package ru.hse.lupuleac;

import org.junit.Test;

import static org.junit.Assert.*;

public class AnonymousClassSkillTest {

    @Test
    public void visit() throws Exception {
        TestHelper.test(2, "AnonymousClassExample.java", new AnonymousClassSkill());
    }
}