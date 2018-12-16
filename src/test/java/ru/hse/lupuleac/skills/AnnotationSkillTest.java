package ru.hse.lupuleac.skills;

import org.junit.Test;

public class AnnotationSkillTest {
    @Test
    public void visit() throws Exception {
        TestHelper.test(2, "AnnotationExample.java", new AnnotationSkill());
    }
}