package by.it_academy.jd2.hw.example.messenger.storage;

import by.it_academy.jd2.hw.example.messenger.storage.api.IUserStorage;
import by.it_academy.jd2.hw.example.messenger.model.User;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class MemoryUserStorage implements IUserStorage {
    private static final MemoryUserStorage instance = new MemoryUserStorage();

    private final Map<String, User> users = new HashMap<>();


    private MemoryUserStorage() {
    }

    @Override
    public User get(String login) {
        return this.users.get(login);
    }

    @Override
    public void add(User user) {
        if(this.users.containsKey(user.getLogin())){
            throw new IllegalArgumentException("Пользователь с логином " + user.getLogin() + " уже сущуствует");
        }
        this.users.put(user.getLogin(), user);
    }

    @Override
    public Collection<User> getAll() {
        return this.users.values();
    }

    public static MemoryUserStorage getInstance() {
        return instance;
    }
}
