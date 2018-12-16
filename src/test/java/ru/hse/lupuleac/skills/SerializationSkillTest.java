package ru.hse.lupuleac.skills;

import org.junit.Test;

public class SerializationSkillTest {

    @Test
    public void visit() throws Exception {
        TestHelper.test(3, "SerializationExample.java", new SerializationSkill());
    }
}