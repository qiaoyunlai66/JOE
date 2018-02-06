package com.joe.qiao.tools.fileparser;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.Assert.*;

/**
 * Created by Joe Qiao on 05/01/2018.
 */
public class FileReaderHelperTest {
    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testParseCurrentClassPathFile() {
        String fileContent= null;
        try {
            fileContent = FileReaderHelper.getFromCurrentClassPath("configuration.json",FileReaderHelper.class);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(fileContent);
        assertNotNull(fileContent);
    }

    @Test
    public void testParseCurrentClassLoaderFile() throws Exception {
//        String s = FileReaderHelper.getFromCurrentClassPath("query.json");
//        System.out.println(s);
    }

    @Test
    public void testReadFile() throws Exception {
    }

}