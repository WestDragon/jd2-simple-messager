package by.it_academy.jd2.hw.example.messenger.storage;

import by.it_academy.jd2.hw.example.messenger.model.Message;
import by.it_academy.jd2.hw.example.messenger.storage.api.IChatStorage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MemoryChatStorage implements IChatStorage {
    private final static MemoryChatStorage instance = new MemoryChatStorage();

    private final Map<String, List<Message>> chats = new HashMap<>();

    @Override
    public List<Message> get(String login) {
        return this.chats.get(login);
    }

    @Override
    public void addMessage(String login, Message message) {
        List<Message> chat;
        if(this.chats.containsKey(login)){
            chat = this.chats.get(login);
        } else {
            chat = new ArrayList<>();
            this.chats.put(login, chat);
        }
        chat.add(message);
    }

    @Override
    public long getCount() {
        return this.chats.values().stream()
                .mapToInt(List::size)
                .sum();
    }

    public static MemoryChatStorage getInstance() {
        return instance;
    }
}
