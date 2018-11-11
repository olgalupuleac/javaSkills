package ru.hse.lupuleac;

import org.junit.Test;

import static org.junit.Assert.*;

public class RegexSkillTest {

    @Test
    public void visit() throws Exception {
        TestHelper.test(13, "RegexExample.java", new RegexSkill());
    }
}