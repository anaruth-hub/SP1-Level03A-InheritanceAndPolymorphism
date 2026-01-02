package com.javainit.sprint01.level03.app;

import com.javainit.sprint01.level03.domain.Editor;
import com.javainit.sprint01.level03.domain.F1News;
import com.javainit.sprint01.level03.domain.MotoGPNews;
import com.javainit.sprint01.level03.service.NewsroomService;

public class Main {
public static void main(String[] args) {
    demoDirectNewsCalculations();
    demoServiceFlow();
}

private static void demoDirectNewsCalculations() {
    F1News n1 = new F1News("Hamilton rumors", "Mercedes");
    System.out.println("Price: " + n1.calculatePrice());
    System.out.println("Score: " + n1.calculateScore());

    MotoGPNews moto = new MotoGPNews("Marquez returns", "Honda");
    System.out.println("MotoGP price: " + moto.calculatePrice());
    System.out.println("MotoGP score: " + moto.calculateScore());
    System.out.println("_______");
}
private static void demoServiceFlow() {
        NewsroomService service = new NewsroomService();
        String dni = "12345678A";
        Editor ana = new Editor(dni, "Ana");
        boolean added = service.addEditor(ana);
        if (!added) {
            System.out.println("Editor already exists.");
            return;

        }

        service.addNewsToEditor("123456789A", new MotoGPNews("MotoGP test", "Honda"));

        System.out.println(service.listNews(dni));

        Double price = service.calculatePrice(dni, "MotoGP test");
        Integer score = service.calculateScore(dni, "MotoGP test");

        System.out.println("Price: " + (price == null ? "(Not found)" : price));
        System.out.println("Score: " + (score == null ? "(Not found)" : score));


    }
}