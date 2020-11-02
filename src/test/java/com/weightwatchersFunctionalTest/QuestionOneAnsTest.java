package com.weightwatchersFunctionalTest;

import com.weightwatchersproject.pages.CalledAndPrintDoesFileExist;
import org.testng.annotations.Test;

public class QuestionOneAnsTest {

//a) Create a method called doesFileExist(String path) which takes the path of the file and tells the user if the file exists at that path or not. Assume all paths are relative to your project structure. If the file does not exist, catch the requisite exception.
    @Test
    public void doesFileExist(){
        System.out.println("********** Solution 1a *************");
        String txtFile = System.getProperty("user.dir") + "/" + "src/main/resources/dictionary.txt";
        CalledAndPrintDoesFileExist.doesFileExist(txtFile);
    }

//b) Read each word and its possible meanings and print them out. Your output should look like this:
    @Test
    public void print() {
        System.out.println("********** Solution 1b *************");
        String txtFile = System.getProperty("user.dir") + "/" + "src/main/resources/dictionary.txt";
        CalledAndPrintDoesFileExist.print(txtFile);
    }




}
