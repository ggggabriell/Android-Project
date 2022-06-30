package com.example.novoapp.viewModel;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validacao {


    public static boolean userName(String name) {
        boolean verify = false;
        if (name.length() >= 5) {
            if (name.indexOf("a") != -1 || name.indexOf("e") != -1 ||
                    name.indexOf("i") != -1 || name.indexOf("o") != -1 ||
                    name.indexOf("u") != -1) {
                verify = true;
            }
        }
        return verify;
    }

    public static boolean email(String email) {
        String regex = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@" + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);


        return matcher.matches();
    }

    public static boolean password(String password) {
        boolean verify = false;

        char passwordArr[] = new char[password.length()];
        for (int i = 0; i< password.length(); i++){
            passwordArr[i] = password.charAt(i);

            if(Character.isUpperCase(passwordArr[i]) && password.length() >= 7){
                verify = true;
            }
        }

        return verify;
    };


    public static boolean cpf(String cpf) {
        boolean verify = false;
        int firstDigitVerifyer = 0;
        int secondDigitVerifyer = 0;
        int cpfArr[] = new int[cpf.length()];

        for (int i = 0; i < cpf.length(); i++) {
            cpfArr[i] = cpf.charAt(i) - '0';
        }

        for (int i = 0; i < cpf.length() - 2; i++) {
            firstDigitVerifyer += (cpfArr[i] * (i + 1));
        }

        firstDigitVerifyer = ((firstDigitVerifyer % 11) == 10) ? 0 : (firstDigitVerifyer % 11);

        for (int i = 0; i < cpf.length() - 1; i++) {
            secondDigitVerifyer += (cpfArr[i] * i);
            if (i > 8) {
                secondDigitVerifyer += (cpfArr[i] * firstDigitVerifyer);
            }
        }

        secondDigitVerifyer = ((secondDigitVerifyer % 11) == 10) ? 0 : (secondDigitVerifyer % 11);

        if (firstDigitVerifyer == cpfArr[cpf.length() - 2] || secondDigitVerifyer == cpfArr[cpf.length() - 1]) {
            verify = true;
        }

        return verify;
    }

}


