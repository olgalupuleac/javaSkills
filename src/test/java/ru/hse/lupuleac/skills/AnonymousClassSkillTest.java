package ru.hse.lupuleac.skills;

import org.junit.Test;

public class AnonymousClassSkillTest {

    @Test
    public void visit() throws Exception {
        TestHelper.test(2, "AnonymousClassExample.java", new AnonymousClassSkill());
    }
}