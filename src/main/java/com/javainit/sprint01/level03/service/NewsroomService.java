package com.javainit.sprint01.level03.service;

import com.javainit.sprint01.level03.domain.Editor;
import com.javainit.sprint01.level03.domain.News;

import java.util.*;

public final class NewsroomService {

    private final Map<String, Editor> editorsByDni = new LinkedHashMap<>();

    public boolean addEditor(Editor editor) {
        Objects.requireNonNull(editor, "editor cannot de null");
        String dniKey = normalizeDni(editor.getDni());
        if (editorsByDni.containsKey(dniKey)) return false;
        editorsByDni.put(dniKey, editor);
        return true;

    }

    public boolean removeEditor(String dni) {
        return editorsByDni.remove(normalizeDni(dni)) != null;

    }

    public Editor findEditor(String dni) {
        return editorsByDni.get(normalizeDni(dni));

    }

    public Collection<Editor> getAllEditors() {
        return Collections.unmodifiableCollection(editorsByDni.values());

    }

    public boolean addNewsToEditor(String dni, News news) {
        Objects.requireNonNull(news, "news cannot be null");
        Editor editor = editorsByDni.get(normalizeDni(dni));
        if (editor == null) return false;
        editor.addNews(news);
        return true;

    }

    public boolean removeNews(String dni, String title) {
        Editor editor = editorsByDni.get(normalizeDni(dni));
        if (editor == null) return false;
        return editor.removeNewsByTitle(title);

    }

    public String listNews(String dni) {
        Editor editor = editorsByDni.get(normalizeDni(dni));
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
        return (news == null) ? null : news.calculateScore();
    }

    public Double calculatePrice(String dni, String title) {
        News news = findNews(dni, title);
        return (news == null) ? null : news.calculatePrice();
    }

    private News findNews(String dni, String title) {
        Editor editor = editorsByDni.get(normalizeDni(dni));
        if (editor == null) return null;
        return editor.findNewsByTitle(title);
    }

    private static String normalizeDni(String dni) {
        return dni == null ? "" : dni.trim().toUpperCase(Locale.ROOT);
    }
}
