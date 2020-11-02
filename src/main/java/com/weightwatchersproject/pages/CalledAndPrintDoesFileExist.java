package com.weightwatchersproject.pages;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class CalledAndPrintDoesFileExist {

    public static void doesFileExist(String path) {
        try {
            File file = new File(path);
            if (file.isFile()) {
                System.out.println("File exists: " + path);

            } else {
                System.out.println("File does not exist: " + path);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void print(String path) {

        BufferedReader bR = null;
        FileReader fR = null;

        try {

            fR = new FileReader(path);
            bR = new BufferedReader(fR);

            HashMap<String, ArrayList<String>> items = new LinkedHashMap<>();
            String row;
            while ((row = bR.readLine()) != null) {
                String[] entry = row.split("-");
                String[] definition = entry[1].split(",");

                ArrayList<String> aL = new ArrayList<String>();
                for (int i = 0; i < definition.length; i++)
                    aL.add(definition[i].trim());

                items.put(entry[0], aL);
            }
            int count = 0;
            for (Map.Entry<String, ArrayList<String>> item : items.entrySet()) {
                System.out.println(++count + " " + item.getKey());
                ArrayList<String> value = item.getValue();
                for (int i = 0; i < value.size(); i++)
                    System.out.println(value.get(i));

            }
            bR.close();
            fR.close();

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }
}
