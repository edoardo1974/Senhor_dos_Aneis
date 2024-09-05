package com.tokio.util;


import java.util.Random;

public class Dados {

    public static Integer rolar(int max) {
        //System.out.println("Rolar dado");
        Random random = new Random();
        return random.nextInt( max + 1);
    }
}
