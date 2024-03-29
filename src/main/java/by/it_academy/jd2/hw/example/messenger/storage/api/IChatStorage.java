package by.it_academy.jd2.hw.example.messenger.storage.api;

import by.it_academy.jd2.hw.example.messenger.storage.entity.Message;

import java.util.List;

public interface IChatStorage {
    List<Message> get(String login);
    void addMessage(String login, Message message);

    long getCount();
}
