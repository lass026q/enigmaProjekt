package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Dette er en krypteringsmaskine!");
            System.out.println("Du kan vælge mellem 3 former for kryptering");
            System.out.println(" 1) number cipher:");
            System.out.println(" 2) Caeser cipher:");
            System.out.println(" 3) Vigenére cipher:");
            System.out.println(" 0) afslut program:");
            int type = scanner.nextInt();
            scanner.nextLine();
            if (type == 1) {
                System.out.println("Number cipher");
                System.out.println(               );
            }
            else if (type == 2) {
                System.out.println("Caeser cipher");
                System.out.println("             ");
            }
            else if (type == 3) {
                System.out.println("Vigenére cipher");
                System.out.println("               ");
            }
            else if (type == 0) {
                System.out.println("Du har afsluttet programmet");
                System.exit(0);
            }

            System.out.println("Vælg (e)ncrypt eller (d)ecrypt");
            char mode = scanner.nextLine().charAt(0);

            if (type == 1 && mode == 'e') {
                numberCipherEncrypt();
            } else if (type == 1 && mode == 'd') {
                numberCipherDecrypt();
            } else if (type == 2 && mode == 'e') {
                caesarCipherEncrypt();
            } else if (type == 2 && mode == 'd') {
                caesarCipherDecrypt();
            }
        }
    }


    //Number cipher

    public static void numberCipherEncrypt() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Number cipher encrypt");
        System.out.println("Indtast tekst: ");
        String plaintext = scanner.nextLine();

        int [] cipher = textToListOfNumbers(plaintext);


        System.out.println("Kodeteksten er: ");
        System.out.println(Arrays.toString(cipher));
    }


    public static int[] textToListOfNumbers(String text){
        int[] numbers = new int[text.length()];
        char[] letters = text.toCharArray();

        for(int i=0; i < letters.length; i++){
            numbers[i] = letterToNumber(letters[i] );
        }

        return numbers;
    }



    public static void numberCipherDecrypt() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Number Cipher decrypt");
        System.out.println("Indtast kodetekst");
        String ciphertext = scanner.nextLine();
        int[] cipher = getIntArrayFromString(ciphertext);
        String plaintext = listOfNumbersToText(cipher);

        System.out.println("Klarteksten er:");
        System.out.println(plaintext);
    }

    public static int[] getIntArrayFromString(String commaSeparatedNumbers) {
        String[] numberStrings = commaSeparatedNumbers.substring(1,commaSeparatedNumbers.length()-1).split(",");
        int[] numbers = new int[numberStrings.length];
        for(int i=0; i < numberStrings.length; i++ ) {
            numbers[i] = Integer.parseInt(numberStrings[i].trim());
        }
        return numbers;
    }

    public static String listOfNumbersToText(int[] numbers){
        String text = "";
        for (int i=0; i < numbers.length; i++){
            int number = numbers[i];

            char letter = numberToLetter(number);

            text = text + letter;
        }
        return text;

    }

    public static int letterToNumber(char letter) {

        String alfabetet = " ABCDEFGHIJKLMNOPQRSTUVWXYZÆØÅ";
        int num = alfabetet.indexOf( letter );

        return num;
    }

    public static char numberToLetter(int number){
        String alfabetet = " ABCDEFGHIJKLMNOPQRSTUVWXYZÆØÅ";
        char letter = alfabetet.charAt(number);

        return letter;
    }


    // **************************
    // *
    // * CAESAR CIPHER
    // *
    // **************************

    public static final String ALPHABET = "abcdefghijklmnopqrstuvwxyzæøå";

    public static void caesarCipherEncrypt() {

        Scanner sc = new Scanner(System.in);
        System.out.println(" Skriv den tekst du ønsker at kryptere: ");
        String plaintext = sc.nextLine();
        System.out.println(" Skriv din ønskede shift-værdi: ");
        int shift = sc.nextInt();
        String ciphertext = "";
        char alphabet;
        for(int i=0; i < plaintext.length();i++) {
            alphabet = plaintext.charAt(i);

            // Små bogstaver
            if(alphabet >= 'a' && alphabet <= 'å') {

                alphabet = (char) (alphabet + shift);

                if(alphabet > 'å') {
                    alphabet = (char) (alphabet+'a'-'å'-1);
                }
                ciphertext = ciphertext + alphabet;
            }

            // Store bogstaver
            else if(alphabet >= 'A' && alphabet <= 'Å') {
                // shift alphabet
                alphabet = (char) (alphabet + shift);

                if(alphabet > 'Å') {

                    alphabet = (char) (alphabet+'A'-'Å'-1);
                }
                ciphertext = ciphertext + alphabet;
            }
            else {
                ciphertext = ciphertext + alphabet;
            }

        }
        System.out.println(" ciphertekst : " + ciphertext);
    }



    public static void caesarCipherDecrypt() {
        Scanner sc = new Scanner(System.in);
        System.out.println(" Skriv den tekst du ønsker at dekryptere : ");
        String ciphertext = sc.nextLine();
        System.out.println(" Skriv shift-værdi : ");
        int shift = sc.nextInt();
        String decryptMessage = "";
        for(int i=0; i < ciphertext.length();i++) {

            char alphabet = ciphertext.charAt(i);
            // små bogstaver
            if(alphabet >= 'a' && alphabet <= 'å') {

                alphabet = (char) (alphabet - shift);

                if(alphabet < 'a') {
                    alphabet = (char) (alphabet-'a'+'å'+1);
                }
                decryptMessage = decryptMessage + alphabet;
            }

            // store bogstaver
            else if(alphabet >= 'A' && alphabet <= 'Å') {

                alphabet = (char) (alphabet - shift);

                if (alphabet < 'A') {
                    alphabet = (char) (alphabet-'A'+'Å'+1);
                }
                decryptMessage = decryptMessage + alphabet;
            }
            else {
                decryptMessage = decryptMessage + alphabet;
            }
        }
        System.out.println(" Dekrypterede besked: " + decryptMessage);
    }
}