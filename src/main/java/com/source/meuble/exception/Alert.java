package com.source.meuble.exception;

import com.source.meuble.util.AlertType;

public class Alert extends Exception {
    private String type = AlertType.WARNING;
    private String title = "Information";

    public Alert(String message) {
        super(message);
    }


    public Alert(String type, String title, String message) {
        super(message);
        setType(type);
        setTitle(title);
    }

    public static Alert success(String msg) {
        return new Alert(AlertType.SUCCESS, "Succès!", msg);
    }

    public static Alert warning(String msg) {
        return new Alert(AlertType.WARNING, "Information", msg);
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
