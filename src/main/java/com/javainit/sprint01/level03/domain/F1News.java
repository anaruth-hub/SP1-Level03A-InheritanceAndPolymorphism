package com.javainit.sprint01.level03.domain;

import java.util.Locale;
public final class F1News extends News {
    private final String team;

    public F1News(String title, String team) {
        super(title);
        this.team = team;
    }
    public String getTeam() {
        return team;
    }
    @Override
    public double calculatePrice() {
        double result = 100.0;

        String normalizedTeam = normalize(team);
        if (normalizedTeam.equals("ferrari") || normalizedTeam.equals("mercedes")) {
            result += 50.0;
        }
        setPrice(result);
        return result;
    }
    @Override
    public int calculateScore() {
        int result = 4;

        String normalizedTeam = normalize(team);
        if (normalizedTeam.equals("ferrari") || normalizedTeam.equals("mercedes")) {
            result += 2;
        }
        setScore(result);
        return result;
    }
    private static String normalize(String value) {
        return value == null ? "" : value.trim().toLowerCase(Locale.ROOT);
    }
}
