/*
 *  UCF COP3330 Fall 2021 Assignment 37 Solution
 *  Copyright 2021 Jenna Busch
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class exercise37 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int minLen = -1;
        int spc = -1;
        int num = -1;
        int letters = -1;

        System.out.print("What's the minimum length?");
        minLen = input.nextInt();

        System.out.print("How many special characters?");
        spc = input.nextInt();

        System.out.print("How many numbers?");
        num = input.nextInt();

        letters = minLen - (spc + num);
        if (letters < (spc + num))
            letters = spc + num;

        if (minLen < letters * 2)
            minLen = letters * 2;

        ArrayList<Integer> indexArray = new ArrayList<Integer>();
        for (int i = 0; i < minLen; i++) {
            indexArray.add(i);
        }


        generatePassword(minLen, spc, num);

    }

    public static void generatePassword(int minLen, int spc, int num) {
        String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        String specialCharacters = "!@#$%^&*";
        String numbers = "1234567890";
        ArrayList<Character> password = new ArrayList<>();

        for (int i = 0; i < spc; i++) {
            password.add(specialCharacters.charAt((int)(Math.random() * specialCharacters.length())));
        }

        for (int i = 0; i < num; i++) {
            password.add(numbers.charAt((int)(Math.random() * numbers.length())));
        }

        for (int i = password.size() - 1; i < minLen; i++) {
            password.add(letters.charAt((int)(Math.random() *letters.length())));
        }


        Collections.shuffle(password);
        for (int i = 0; i < password.size(); i++) {
            System.out.print(password.get(i));
        }

    }
}


