/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.danielborba.cpec;

/**
 *
 * @author dborba
 */
public class nbitNumber {
    // Unsigned numbers to be implemented in the future
        // private Boolean unsigned;
    private int bitLength;
    private long value;
    
    public void setBitLength(int bitLenght) {
        this.bitLength = bitLength;
    }
    public void setValue(long value){
        this.value = value;
    }
    
    public Boolean safeSetValue(long value){
        if(value > (long) Math.pow(2,(bitLength-1)) -1 || value < (long) -Math.pow(2,(bitLength-1))) {
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
        while(tempConversionValue > 0){
            twosComplement.concat(Long.toString(tempConversionValue%2));
            tempConversionValue/=2;
        }
        if(value < 0){
            "1".concat(twosComplement);
        }
        return twosComplement;
    }
}
