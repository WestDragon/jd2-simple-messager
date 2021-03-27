package by.it_academy.jd2.hw.example.messenger.view.api;

import by.it_academy.jd2.hw.example.messenger.model.Message;
import by.it_academy.jd2.hw.example.messenger.model.User;

import java.util.List;

public interface IMessageService {
    List<Message> get(User currentUser);

    void addSystemMessage(String loginRecipient, String message);

    void addMessage(String loginRecipient, Message message);
    void addMessage(User recipient, Message message);
}
