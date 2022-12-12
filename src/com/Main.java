package com;

import java.math.BigInteger;

public class Main {
    public static void main(String[] args) {
        System.out.println("Şifrelenmiş metin = " + sifreleme("this is homework"));
        System.out.println("Çözümlenmiş metin = " + sifreCozucu("ghjsazfvhabdzxxk"));
    }

    public static String sifreleme(String sifrelenecekMetin) {

        int x = 0;


        char[] harfler = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        int indis = 0;
        StringBuilder araSifre = new StringBuilder();
        StringBuilder sonSifre = new StringBuilder();
        sifrelenecekMetin = sifrelenecekMetin.replace(" ", "");


        while (sifrelenecekMetin.length() % 4 != 0) {
            sifrelenecekMetin += String.valueOf(harfler[x]);
            x++;
        }




        char[][] araci = new char[sifrelenecekMetin.length()/4][4];
        for (int i = 0; i < sifrelenecekMetin.length()/4; i++) {
            for (int j = 0; j < 4; j++) {
                araci[j][i] = sifrelenecekMetin.charAt(indis);
                indis++;
            }
        }



        for (int i = 0; i < sifrelenecekMetin.length()/4; i++) {

            for (int j = 0; j < 4; j++) {

                araSifre.append(araci[i][j]);

            }
        }

        System.out.println("Ara Şifrelenmiş metin = "+araSifre);

        for (int i = 0; i < araSifre.length(); i++) {
            for (int j = 0; j < harfler.length; j++) {
                if (araSifre.charAt(i) == harfler[j]) {
                    sonSifre.append(harfler[((7 * j) + 3) % 26]);
                }
            }
        }

        return sonSifre.toString();
    }

    public static String sifreCozucu(String sifrelenecekMetin) {
        char[] harfler = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        int a = 7;
        int b = 3;
        StringBuilder araSifre = new StringBuilder();
        StringBuilder sonSifre = new StringBuilder();

        BigInteger tersMod = BigInteger.valueOf(a).modInverse(BigInteger.valueOf(26));
        for (int i = 0; i < sifrelenecekMetin.length(); i++) {

            int y = 0;
            for (int j = 0; j < harfler.length; j++) {
                if (sifrelenecekMetin.charAt(i) == harfler[j]) {
                    y = j;
                }
            }
            int sonuc = tersMod.intValue() * (y - b) % 26;
            while (sonuc < 0) {
                sonuc += 26;
            }
            araSifre.append(harfler[sonuc]);
        }

        for(int i = 0 ; i < sifrelenecekMetin.length()/4; i++){

            for(int j = 0 ; j < sifrelenecekMetin.length()/4 ; j++){

                sonSifre.append(araSifre.charAt(i+(4*j)));
            }


        }


        // ara sonuç bulundu.


        return sonSifre.toString();
    }
}