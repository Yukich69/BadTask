package com.bad.ykryvoruchko;

import java.util.Scanner;

public class FirstUniqCharParser {
    public static void main(String[] args) {
        System.out.println("----===Use me to find the first unique character in the text===----");
        Scanner in = new Scanner(System.in);
        System.out.println("Enter your text: ");

        StringBuilder text = new StringBuilder(in.nextLine());
        while(!in.nextLine().isEmpty()){
            text.append(in.nextLine());
        }

        String[] words = textToWords(text.toString());
        String uniqSymbol = toFirstUniq(words);

        System.out.printf("First unique symbol is: " + uniqSymbol);
        in.close();
    }

    public static String toFirstUniq(String[] words){
        StringBuilder uniqSymbols = new StringBuilder();

        for (String word : words) {
            String uniqSymbol = findUniq(word);
            uniqSymbols.append(uniqSymbol);
        }

        return findUniq(uniqSymbols.toString());
    }

    public static String[] textToWords(String text){
        return text.split("[^A-Za-z]+");
    }

    public static String findUniq(String word){
        StringBuilder uniq = new StringBuilder();

        for (int i = 0; i < word.length(); i++) {
            char current = word.charAt(i);

            if(word.indexOf(current,word.indexOf(current) + 1) == -1) {
                uniq.append(current);
                break;
            }
        }
        return String.valueOf(uniq);
    }
}
