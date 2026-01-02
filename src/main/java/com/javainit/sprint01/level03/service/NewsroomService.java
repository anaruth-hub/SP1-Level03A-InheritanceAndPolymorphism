package com.javainit.sprint01.level03.service;

import com.javainit.sprint01.level03.domain.Editor;
import com.javainit.sprint01.level03.domain.News;

import java.util.*;

public final class NewsroomService {
    private final Map<String, Editor> editorsByDni = new LinkedHashMap<>();

    public boolean addEditor(Editor editor) {
        Objects.requireNonNull(editor);
        String dni = editor.getDni();
        if (editorsByDni.containsKey(dni)) return false;
        editorsByDni.put(dni, editor);
        return true;

    }

    public boolean removeEditor(String dni) {
        return editorsByDni.get(dni) != null;

    }

    public Editor findEditor(String dni) {
        return editorsByDni.get(dni);

    }

    public Collection<Editor> getAllEditors() {
        return editorsByDni.values();

    }

    public boolean addNewsToEditor(String dni, News news) {
        Editor editor = editorsByDni.get(dni);
        if (editor == null) return false;
        editor.addNews(news);
        return true;

    }

    public boolean removeNews(String dni, String title) {
        Editor editor = editorsByDni.get(dni);
        if (editor == null) return false;
        return editor.removeNewsByTitle(title);

    }

    public String listNews(String dni) {
        Editor editor = editorsByDni.get(dni);
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
        Editor editor = editorsByDni.get(dni);
        if (editor == null) return null;
        return editor.findNewsByTitle(title);
    }
}
