package com.theironyard;

import org.junit.Test;

import java.io.File;
import java.util.HashMap;

import static org.junit.Assert.*;

/**
 * Created by will on 5/25/16.
 */
public class MainTest {
    static final String TEST_FILE = "test.json";


    @Test
    public void saveAndLoad() throws Exception {
        HashMap answers = new HashMap();
        answers.put("Q1", 1000);
        answers.put("Q2", "Test Model");
        answers.put("Q3", "Test Color");
        answers.put("Q4", 2016);
        answers.put("Q5", 0);

        Main.save(answers, TEST_FILE);

        HashMap newAnswers = Main.load(TEST_FILE);

        File f = new File(TEST_FILE);
        f.delete();

        assertTrue(newAnswers != null);
    }


}