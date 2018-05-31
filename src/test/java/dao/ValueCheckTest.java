package dao;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class ValueCheckTest {
    ValueCheck valueCheck = new ValueCheck();

    String temp1 = "22.5";
    String temp2 = "nan";
    String temp3 = "66.8";
    String temp4 = "nan";
    String humi1 = "55.6";
    String humi2 = "45.5";
    String humi3 = "nan";
    String humi4 = "nan";

    String humi5 = "-0.1";
    String humi6 = "0";
    String humi7 = "100";
    String humi8 = "100.1";

    @Test
    public void isDouble() {
        Assert.assertTrue(valueCheck.isDouble(temp1, humi1));
        Assert.assertFalse(valueCheck.isDouble(temp2, humi2));
        Assert.assertFalse(valueCheck.isDouble(temp3, humi3));
        Assert.assertFalse(valueCheck.isDouble(temp4, humi4));
    }

    @Test
    public void isHumiInRange() {
        Assert.assertFalse(valueCheck.isHumiInRange(humi5));
        Assert.assertTrue(valueCheck.isHumiInRange(humi6));
        Assert.assertTrue(valueCheck.isHumiInRange(humi7));
        Assert.assertFalse(valueCheck.isHumiInRange(humi8));
    }
}