package com.weightwatchersFunctionalTest;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Random;

public class QuestionThreeAnsTest {

    //Question 3:Generate 500 random numbers and create a method to print the nth smallest number in a programming language of your choice.
    @Test
    public void generateRandomNumber() {

        System.out.println("********** Solution 3 *************");

        Random random = new Random();
        int[] numbers = new int[500];
        int smallest = numbers[0];

        for (int i = 1; i < 500; i++) {
            numbers[i] = random.nextInt(1000);
            smallest = Math.min(smallest, numbers[i]);
        }
        System.out.println("List of array is: " + Arrays.toString(numbers));
        System.out.println("Smallest number is : " + smallest);
    }


}
