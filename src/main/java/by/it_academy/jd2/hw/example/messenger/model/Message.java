package by.it_academy.jd2.hw.example.messenger.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

public class Message implements Serializable {
    private String from;
    private LocalDateTime sendDate;
    private String text;

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public LocalDateTime getSendDate() {
        return sendDate;
    }

    public void setSendDate(LocalDateTime sendDate) {
        this.sendDate = sendDate;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
