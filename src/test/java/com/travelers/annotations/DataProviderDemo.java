package com.travelers.annotations;

import com.travelers.helpers.TestListener;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;

@Listeners(TestListener.class)
public class DataProviderDemo {

    @DataProvider
    public Object[][] getData(){
        return new Object[][]{
                {"user1","$22"},
                {"user2","$50"},
                {"user3","$80"},
                {"user4","$150"}};
    }


    @Test(dataProvider = "getData")
    public void fistTest(String price, String name){
        System.out.println("Price: " + price);
        System.out.println("Name: " + name);
    }
}
