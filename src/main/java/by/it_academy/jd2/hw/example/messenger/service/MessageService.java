package by.it_academy.jd2.hw.example.messenger.service;

import by.it_academy.jd2.hw.example.messenger.core.dto.MessageCreateDTO;
import by.it_academy.jd2.hw.example.messenger.service.api.IMessageService;
import by.it_academy.jd2.hw.example.messenger.storage.MemoryChatStorage;
import by.it_academy.jd2.hw.example.messenger.storage.api.IChatStorage;
import by.it_academy.jd2.hw.example.messenger.storage.entity.Message;
import by.it_academy.jd2.hw.example.messenger.storage.entity.User;

import java.time.LocalDateTime;
import java.util.List;

public class MessageService implements IMessageService {
    private final static MessageService instance = new MessageService();

    private final IChatStorage chatStorage;

    private MessageService() {
        this.chatStorage = MemoryChatStorage.getInstance();
    }

    @Override
    public List<Message> get(User currentUser) {
        return this.chatStorage.get(currentUser.getLogin());
    }

    @Override
    public void addMessage(MessageCreateDTO message) {
        this.validation(message);
        Message entity = new Message();
        entity.setFrom(message.getFrom());
        entity.setTo(message.getTo());
        entity.setText(message.getText());
        entity.setSendDate(LocalDateTime.now());

        this.chatStorage.addMessage(entity.getTo(), entity);
    }

    public void validation(MessageCreateDTO message){
        if(message.getTo() == null || message.getTo().isBlank()){
            throw new IllegalArgumentException("Не заполнена информация кому отправили сообщение");
        }
    }

    @Override
    public long getCount(User currentUser) {
        return this.chatStorage.get(currentUser.getLogin()).size();
    }

    @Override
    public long getCount() {
        return this.chatStorage.getCount();
    }

    public static MessageService getInstance() {
        return instance;
    }
}
