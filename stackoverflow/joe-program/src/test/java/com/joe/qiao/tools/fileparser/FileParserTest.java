package com.joe.qiao.tools.fileparser;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Joe Qiao on 05/01/2018.
 */
public class FileParserTest {
    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testParseCurrentClassPathFile() {
        String fileContent=FileParser.parseCurrentClassLoaderFile("configuration.json",FileParser.class);
        System.out.println(fileContent);
        assertNotNull(fileContent);
    }

    @Test
    public void testParseCurrentClassLoaderFile() throws Exception {
    }

    @Test
    public void testReadFile() throws Exception {
    }

}