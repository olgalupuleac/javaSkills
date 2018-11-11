package ru.hse.lupuleac;

import org.junit.Test;

import static org.junit.Assert.*;

public class CollectorsSkillTest {

    @Test
    public void visit() throws Exception {
        TestHelper.test(10, "CollectorsExample.java", new CollectorsSkill());
    }
}