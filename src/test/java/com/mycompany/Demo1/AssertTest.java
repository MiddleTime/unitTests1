
package com.mycompany.Demo1;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;


public class AssertTest {
    
    @Test
    @Ignore
    public void substring() {
        assertEquals("llo", "Hello".substring(3));
    }

    @Test
    public void demo_test() {
        assertEquals("Hello", "Hel" + "lo");
        assertEquals(
                1.0,
                1d / 3 + 1d / 3 + 1d / 3,
                1e-10);
    }
}
