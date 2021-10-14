package com.ebasar;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {
        System.out.println(Result.caesarCipher("www.abc.xy", 87));
    }


    class Result {

        /*
         * Complete the 'caesarCipher' function below.
         *
         * The function is expected to return a STRING.
         * The function accepts following parameters:
         *  1. STRING s
         *  2. INTEGER k
         */

        public static String caesarCipher(String s, int k) {
            String alphabet = "abcdefghijklmnopqrstuvwxyz";
            String alphabetU = alphabet.toUpperCase();
            StringBuilder cipheredString = new StringBuilder(s);
            for (int i = 0; i < s.length(); i++) {
                if (alphabet.indexOf(s.charAt(i)) >= 0) {
                    if (alphabet.indexOf(s.charAt(i)) + k%alphabet.length() >= alphabet.length()) {
                        cipheredString.setCharAt(i, alphabet.charAt(alphabet.indexOf(s.charAt(i)) + k%alphabet.length() - alphabet.length()));
                    } else {
                        cipheredString.setCharAt(i, alphabet.charAt(alphabet.indexOf(s.charAt(i) + k%alphabet.length())));
                    }
                } else if (alphabetU.indexOf(s.charAt(i)) >= 0) {
                    if (alphabetU.indexOf(s.charAt(i)) + k%alphabetU.length() >= alphabetU.length()) {
                        cipheredString.setCharAt(i, alphabetU.charAt(alphabetU.indexOf(s.charAt(i)) + k%alphabetU.length() - alphabetU.length()));
                    } else {
                        cipheredString.setCharAt(i, alphabetU.charAt(alphabetU.indexOf(s.charAt(i) + k%alphabetU.length())));
                    }
                } else
                    continue;

            }
            return cipheredString.toString();
        }

        public class Solution {
            public static void main(String[] args) throws IOException {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

                int n = Integer.parseInt(bufferedReader.readLine().trim());

                String s = bufferedReader.readLine();

                int k = Integer.parseInt(bufferedReader.readLine().trim());

                String result = Result.caesarCipher(s, k);

                bufferedWriter.write(result);
                bufferedWriter.newLine();

                bufferedReader.close();
                bufferedWriter.close();
            }
        }
    }
}
