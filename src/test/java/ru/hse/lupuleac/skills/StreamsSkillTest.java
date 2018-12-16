package ru.hse.lupuleac.skills;

import org.junit.Test;

public class StreamsSkillTest {

    @Test
    public void visit() throws Exception{
        TestHelper.test(2, "StreamsExample.java", new StreamsSkill());
    }
}