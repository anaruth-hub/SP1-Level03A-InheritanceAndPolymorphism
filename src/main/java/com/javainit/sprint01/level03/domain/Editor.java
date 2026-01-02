package com.javainit.sprint01.level03.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public final class Editor {
    private static double salary = 1500.0;

    private final String dni;
    private final String name;
    private final List<News> newsList = new ArrayList<>();

    public Editor(String dni, String name) {
      this.dni = Objects.requireNonNull(dni, "dni cannot be null").trim();
      this.name = Objects.requireNonNull(name, "name cannot be null").trim();
    }

    public String getDni() { return dni;

    }

    public String getName() { return name;

    }

    public static double getSalary() { return salary;

    }

    public static void setSalary(double newSalary) {
        salary = newSalary;
    }

    public List<News> getNewsList() {
        return Collections.unmodifiableList(newsList);
    }

    public void addNews(News news) {
        newsList.add(Objects.requireNonNull(news));
    }

    public boolean removeNewsByTitle(String title) {
        return newsList.removeIf(n -> n.getTitle().equalsIgnoreCase(title));
    }

    public News findNewsByTitle(String title) {
        for (News n : newsList) {
            if(n.getTitle().equalsIgnoreCase(title)) return n;
        }
        return null;
    }
}
