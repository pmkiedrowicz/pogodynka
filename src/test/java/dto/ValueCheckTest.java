package dto;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class ValueCheckTest {
    ValueCheck valueCheck = new ValueCheck();

    @Test
    public void isDouble() {
        String temp1 = "22.5";
        String temp2 = "nan";
        String temp3 = "66.8";
        String temp4 = "nan";
        String humi1 = "55.6";
        String humi2 = "45.5";
        String humi3 = "nan";
        String humi4 = "nan";

        Assert.assertTrue(valueCheck.isDouble(temp1, humi1));
        Assert.assertFalse(valueCheck.isDouble(temp2, humi2));
        Assert.assertFalse(valueCheck.isDouble(temp3, humi3));
        Assert.assertFalse(valueCheck.isDouble(temp4, humi4));
    }
}