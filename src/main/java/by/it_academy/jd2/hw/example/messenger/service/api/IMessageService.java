package by.it_academy.jd2.hw.example.messenger.service.api;

import by.it_academy.jd2.hw.example.messenger.core.dto.MessageCreateDTO;
import by.it_academy.jd2.hw.example.messenger.storage.entity.Message;
import by.it_academy.jd2.hw.example.messenger.storage.entity.User;

import java.util.List;

public interface IMessageService {
    List<Message> get(User currentUser);

    void addMessage(MessageCreateDTO message);

    long getCount(User currentUser);
    long getCount();
}
