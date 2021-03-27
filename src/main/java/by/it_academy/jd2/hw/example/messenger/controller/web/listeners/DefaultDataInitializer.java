package by.it_academy.jd2.hw.example.messenger.controller.web.listeners;

import by.it_academy.jd2.hw.example.messenger.model.Message;
import by.it_academy.jd2.hw.example.messenger.model.User;
import by.it_academy.jd2.hw.example.messenger.storage.MemoryChatStorage;
import by.it_academy.jd2.hw.example.messenger.storage.MemoryUserStorage;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;

import java.util.Date;

public class DefaultDataInitializer implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        MemoryUserStorage userStorage = MemoryUserStorage.getInstance();

        User user = new User();
        user.setLogin("admin");
        user.setPassword("admin");
        user.setFio("Админ Адинович Админов");
        user.setBirthday(new Date());
        user.setRegistration(user.getBirthday());

        userStorage.add(user);

        MemoryChatStorage chatStorage = MemoryChatStorage.getInstance();

        Message message = new Message();
        message.setFrom("unknown");
        message.setSendDate(new Date());
        message.setText("Я слежу за тобой!");

        chatStorage.addMessage(user.getLogin(), message);
    }
}
