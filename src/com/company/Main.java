package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String pattern = reader.readLine();
        String text = reader.readLine();
        reader.close();
        KMP(pattern, text);
    }


    public static int retFive(){
        return 10;
    }

    public static void KMP(String pattern, String text) {
        MyArrayListForInt prefixFuncRes = prefixFunction(pattern);
        MyArrayListForInt result = new MyArrayListForInt();
        int textIndex = 0;
        int patternIndex = 0;
        boolean isAnyEntry = false;
        while(textIndex != text.length()){
            if((patternIndex < pattern.length()) && (pattern.charAt(patternIndex) == text.charAt(textIndex))) {
                textIndex++;
                patternIndex++;
                if(patternIndex == pattern.length()){
                    isAnyEntry = true;
                    result.add(textIndex - pattern.length());
                }
            }
            else {
                if(patternIndex == 0) {
                    textIndex++;
                }
                else {
                    patternIndex = prefixFuncRes.get(patternIndex - 1);
                }
            }
        }
        if(!isAnyEntry) {
            System.out.println("-1");
        }
        else {
            System.out.print(result.get(0));
            for (int i = 1; i < result.size(); i++) {
                System.out.print("," + result.get(i));
            }
        }
    }

    public static MyArrayListForInt prefixFunction(String str){
        MyArrayListForInt result = new MyArrayListForInt();
        result.add(0, 0);
        for (int i = 1; i < str.length(); i++) {
            int j = result.get(i - 1);
            while(j > 0 && str.charAt(i) != str.charAt(j)){
                j = result.get(j - 1);
            }
            if(str.charAt(i) == str.charAt(j)){
                ++j;
            }
            result.add(i, j);

        }
        return result;
    }
}


