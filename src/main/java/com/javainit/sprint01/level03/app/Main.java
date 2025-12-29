package com.javainit.sprint01.level03.app;

import com.javainit.sprint01.level03.domain.F1News;
import com.javainit.sprint01.level03.domain.MotoGPNews;

public class Main {
public static void main(String[] args) {
    F1News n1 = new F1News("Hamilton rumors", "Mercedes");
    System.out.println("Price: " + n1.calculatePrice());
    System.out.println("Score: " + n1.calculateScore());

    MotoGPNews moto = new MotoGPNews("Marquez returns", "Honda");
    System.out.println("MotoGP price: " + moto.calculatePrice());
    System.out.println("MotoGP score: " + moto.calculateScore());
    }
}