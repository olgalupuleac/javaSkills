package ru.hse.lupuleac.skills;

import org.junit.Test;

public class CollectionsSkillTest {
    @Test
    public void visit() throws Exception {
       TestHelper.test(2, "CollectionsExample.java", new CollectionsSkill());
    }
}