/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.danielborba.cpec;

import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author dborba
 */
public class nbitIntegerTest {
    @Test
    public void safeSetValueTest(){
        System.out.println("Testing nbitInteger.safeSetValue(long value)...");
        nbitInteger i = new nbitInteger(4);
        assertTrue(i.safeSetValue(4)==Boolean.TRUE);
        assertTrue(i.safeSetValue(8)==Boolean.FALSE);
        assertTrue(i.safeSetValue(-9)==Boolean.FALSE);
    }
    @Test
    public void getTwosComplementTest(){
        System.out.println("Testing nbitInteger.getTwosComplement()...");
        nbitInteger i = new nbitInteger(4);
        i.safeSetValue(4);
        assertTrue(i.getTwosComplement().equals("0100"));
        i.safeSetValue(-4);
        assertTrue(i.getTwosComplement().equals("1100"));
    }
}