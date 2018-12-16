package ru.hse.lupuleac.skills;

import org.junit.Test;

public class CollectorsSkillTest {

    @Test
    public void visit() throws Exception {
        TestHelper.test(10, "CollectorsExample.java", new CollectorsSkill());
    }
}