package com.framework.tests;


import com.framework.pages.FrontPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class RegisterForm extends BaseClass {


@Test
    public void mainTest(){

        FrontPage frontPage = new FrontPage(driver);

        driver.get("http://newtours.demoaut.com/mercuryregister.php");

        frontPage.setUp();
        List<String> names =  frontPage.getname();



    }









}
