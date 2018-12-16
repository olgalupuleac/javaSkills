package ru.hse.lupuleac.skills;

import org.junit.Test;

public class ScanningTheInputSkillTest {

    @Test
    public void visit() throws Exception {
        TestHelper.test(1, "ScanningTheInputExample.java", new ScanningTheInputSkill());
    }
}