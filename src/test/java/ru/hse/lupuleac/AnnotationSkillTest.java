package ru.hse.lupuleac;

import org.junit.Test;

import static org.junit.Assert.*;

public class AnnotationSkillTest {
    @Test
    public void visit() throws Exception {
        TestHelper.test(2, "AnnotationExample.java", new AnnotationSkill());
    }
}