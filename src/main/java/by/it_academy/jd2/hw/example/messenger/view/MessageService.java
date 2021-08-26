package by.it_academy.jd2.hw.example.messenger.view;

import by.it_academy.jd2.hw.example.messenger.model.Message;
import by.it_academy.jd2.hw.example.messenger.model.User;
import by.it_academy.jd2.hw.example.messenger.storage.ChatStorageFactory;
import by.it_academy.jd2.hw.example.messenger.storage.api.IChatStorage;
import by.it_academy.jd2.hw.example.messenger.view.api.IMessageService;

import java.util.Date;
import java.util.List;

public class MessageService implements IMessageService {
    private final static MessageService instance = new MessageService();

    private final IChatStorage chatStorage;

    private MessageService() {
        this.chatStorage = ChatStorageFactory.getInstance();
    }

    @Override
    public List<Message> get(User currentUser) {
        return this.chatStorage.get(currentUser.getLogin());
    }

    @Override
    public void addSystemMessage(String loginRecipient, String text) {
        Message message = new Message();
        message.setFrom("Evil");
        message.setSendDate(new Date());
        message.setText(text);

        this.addMessage(loginRecipient, message);
    }

    @Override
    public void addMessage(String loginRecipient, Message message) {
        this.chatStorage.addMessage(loginRecipient, message);
    }

    @Override
    public void addMessage(User recipient, Message message) {
        this.addMessage(recipient.getLogin(), message);
    }

    public static MessageService getInstance() {
        return instance;
    }
}
