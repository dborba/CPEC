/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.danielborba.cpec;

import org.apache.commons.lang.*;

/**
 * An n-bit representation of an Integer. Size currently restricted by
 * the size of a Long, that is 64-bit two's complement.
 * @author dborba
 */
public class nbitInteger {
    // Unsigned numbers to be implemented in the future
        // private Boolean unsigned;
    private int bitLength; // Number valid bits
    private long value; // Current value
    
    // Constructors
    public nbitInteger(int bitLength){
        this.bitLength = bitLength;
        this.value=0;
    }
    public nbitInteger(int bitLength, long value){
        this.bitLength = bitLength;
        this.value = value;
    }
    
    public void setBitLength(int bitLength) {
        this.bitLength = bitLength;
    }
    public void setValue(long value){
        this.value = value;
    }
    
    public Boolean safeSetValue(long value){
        if(value > (long) Math.pow(2,(this.bitLength-1)) -1
                || value < (long) -Math.pow(2,(this.bitLength-1))) {
            return Boolean.FALSE;
        }
        this.value = value;
        return Boolean.TRUE;
    }
    
    public int getBitLength(){
        return bitLength;
    }
    public long getValue(){
        return value;
    }
    
    public String getTwosComplement(){
        String twosComplement="";

        long tempConversionValue = Math.abs(value);
        while(tempConversionValue > 0) {
            twosComplement = (Long.toString(tempConversionValue%2)).concat(twosComplement);
            tempConversionValue/=2;
        }
        if(twosComplement.length() < this.bitLength){
            String leadingZeros = StringUtils.repeat("0", 
                    this.bitLength - twosComplement.length());
            twosComplement = leadingZeros.concat(twosComplement);
        }
        if(value < 0){
            char[] inversionArray = twosComplement.toCharArray();
            for(int i = twosComplement.lastIndexOf('1')-1; i >= 0; i--){
                if(inversionArray[i] == '1'){
                    inversionArray[i] = '0';
                } else {
                    inversionArray[i] = '1';
                }
            }
            twosComplement = new String(inversionArray);
        }

        return twosComplement;
    }
}
