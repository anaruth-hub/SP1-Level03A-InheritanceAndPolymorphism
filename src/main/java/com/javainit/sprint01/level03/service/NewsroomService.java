package com.javainit.sprint01.level03.service;

import com.javainit.sprint01.level03.domain.Editor;
import com.javainit.sprint01.level03.domain.News;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Collections;

public final class NewsroomService {

    private final Map<String, Editor> editorsByDni = new LinkedHashMap<>();

    public boolean addEditor(Editor editor) {
        Objects.requireNonNull(editor, "editor cannot de null");

        String dni = normalizeKey(editor.getDni());
        if (dni.isEmpty()) return false;

        if (editorsByDni.containsKey(dni)) return false;

        editorsByDni.put(dni, editor);
        return true;

    }

    public boolean removeEditor(String dni) {
        String key = normalizeKey(dni);
        if (key.isEmpty()) return false;

        return editorsByDni.remove(key) != null;

    }

    public Editor findEditor(String dni) {
        String key = normalizeKey(dni);
        if (key.isEmpty()) return null;

        return editorsByDni.get(key);

    }

    public Collection<Editor> getAllEditors() {
        return Collections.unmodifiableCollection(editorsByDni.values());

    }

    public boolean addNewsToEditor(String dni, News news) {
        Objects.requireNonNull(news, "news cannot be null");

        Editor editor = findEditor(dni);
        if (editor == null) return false;

        editor.addNews(news);
        return true;

    }

    public boolean removeNews(String dni, String title) {
        Editor editor = findEditor(dni);
        if (editor == null) return false;
        String safeTitle = normalizeKey(title);
        if (safeTitle.isEmpty()) return false;

        return editor.removeNewsByTitle(safeTitle);

    }

    public String listNews(String dni) {
        Editor editor = findEditor(dni);
        if (editor == null) return "(Editor not found)";
        if (editor.getNewsList().isEmpty()) return "(No news yet)";

        StringBuilder sb = new StringBuilder();
        for(News n : editor.getNewsList()) {
            sb.append("- ").append(n.getTitle()).append(System.lineSeparator());
        }
        return sb.toString();

    }

    public Integer calculateScore(String dni, String title) {
        News news = findNews(dni, title);
        if (news == null) return null;

        return news.calculateScore();
    }

    public Double calculatePrice(String dni, String title) {
        News news = findNews(dni, title);
        if(news == null) return null;

        return news.calculatePrice();
    }

    private News findNews(String dni, String title) {
        Editor editor = findEditor(dni);
        if (editor == null) return null;

        String safeTitle = normalizeKey(title);
        if (safeTitle.isEmpty()) return null;

        return editor.findNewsByTitle(safeTitle);
    }

    private static String normalizeKey(String value) {
        return value == null ? "" : value.trim();
    }
}
