package ru.hse.lupuleac.skills;

import org.junit.Test;

public class RegexSkillTest {

    @Test
    public void visit() throws Exception {
        TestHelper.test(13, "RegexExample.java", new RegexSkill());
    }
}