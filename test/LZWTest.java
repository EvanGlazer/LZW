/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Evan
 */
public class LZWTest {
    
    public LZWTest() {
    }
    
    @Test
    public void compressTest()
    {
        assertEquals("65,66,66,256,257,259,65", LZW.compression("ABBABBBABBA"));
    }
    @Test
    public void decompressTest()
    {
        /*
        List<Integer> s = ArrayList<Integer>();
        s = {656666,256,257,259,65}
        assertEquals("65,66,66,256,257,259,65", LZW.decompression(s));
                */
    }
}
