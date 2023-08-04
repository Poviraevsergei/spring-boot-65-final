package com.tms.controller;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;


@DisplayName("Наш класс")
public class UserControllerTest {


    @BeforeAll
    public static void beforeAll(){
        System.out.println("Before all!");
    }

    @BeforeEach
    public void beforeEach(){
        System.out.println("Before each!");
    }

    @AfterAll
    public static void afterAll(){
        System.out.println("After all!");
    }

    @AfterEach
    public void afterEach(){
        System.out.println("After each!");
    }
    @Test
    @DisplayName("Наш метод")
    @RepeatedTest(5)
    @Tag("user")
    public void getUserTest(){

    }

    @Test
    public void getUserSecondTest(){

    }
}
