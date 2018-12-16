package ru.hse.lupuleac.skills;

import org.junit.Test;

public class FilesSkillTest {

    @Test
    public void visit() throws Exception {
        TestHelper.test(0, "FilesExample.java", new FilesSkill());
    }
}