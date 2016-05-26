package com.theironyard;

import jodd.json.JsonParser;
import jodd.json.JsonSerializer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static final String SAVE_FILE = "answers.json";
    static HashMap answers;

    public static void main(String[] args) {
        answers = load(SAVE_FILE);

        try {
            if (!answers.isEmpty()) {
                while (true) {
                    System.out.printf("\nCurrent Answers:");
                    System.out.printf("\n %s\n\n", answers);
                    System.out.printf("Enter a question number to change a previous answer\n");
                    String ans = scanner.nextLine();

                        switch (ans) {
                            case "1":
                                q1();
                                break;
                            case "2":
                                q2();
                                break;
                            case "3":
                                q3();
                                break;
                            case "4":
                                q4();
                                break;
                            case "5":
                                q5();
                                break;
                            default:
                                System.out.println("Invalid option selected");
                                break;
                    }
                }
            }
        }
        catch (NullPointerException e){
            askAll();
        }


    }

    public static void save(HashMap answers, String filename) {
        File f = new File(filename);
        JsonSerializer serializer = new JsonSerializer();
        String json = serializer.serialize(answers);

        try {
            FileWriter fw = new FileWriter(f);
            fw.write(json);
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static HashMap load(String filename) {
        File f = new File(filename);

        try {
            Scanner scanner = new Scanner(f);
            scanner.useDelimiter("\\Z");
            String contents = scanner.next();
            JsonParser parser = new JsonParser();
            return parser.parse(contents);

        }
        catch (FileNotFoundException e) {
        }
        return null;
    }

    public static void q1() {
        System.out.printf("Question 1: \nHow much are you willing to spend?\n");
        double price = Double.valueOf(scanner.nextLine());
        answers.put("Q1", price);
        save(answers, SAVE_FILE);
    }

    public static void q2() {
        System.out.printf("Question 2: \nWhat make and model are you looking for?\n");
        String makeAndModel = scanner.nextLine();
        answers.put("Q2", makeAndModel);
        save(answers, SAVE_FILE);
    }

    public static void q3() {
        System.out.printf("Question 3: \nWhat color are you looking for?\n");
        String color = scanner.nextLine();
        answers.put("Q3", color);
        save(answers, SAVE_FILE);
    }

    public static void q4() {
        System.out.printf("Question 4: \nWhat year are you looking for?\n");
        int year = Integer.valueOf(scanner.nextLine());
        answers.put("Q4", year);
        save(answers, SAVE_FILE);
    }

    public static void q5() {
        System.out.printf("Question 5: \nWhat's the mileage you're looking for?\n");
        int mileage = Integer.valueOf(scanner.nextLine());
        answers.put("Q5", mileage);
        save(answers, SAVE_FILE);
    }

    public static void askAll() {
        System.out.printf("Welcome to the car dealership. \nIt looks like you haven't filled out the questionnaire yet." +
                "\nPlease take our survey so that we can help you pick out a car.\n\n");
        answers = new HashMap(); //unnecessary?
        q1();
        q2();
        q3();
        q4();
        q5();
    }
}
