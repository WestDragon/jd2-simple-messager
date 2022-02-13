package by.it_academy.jd2.hw.example.messenger.controller.web.listeners;

import by.it_academy.jd2.hw.example.messenger.model.Message;
import by.it_academy.jd2.hw.example.messenger.model.User;
import by.it_academy.jd2.hw.example.messenger.storage.MemoryChatStorage;
import by.it_academy.jd2.hw.example.messenger.storage.MemoryUserStorage;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class DefaultDataInitializer implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        MemoryUserStorage userStorage = MemoryUserStorage.getInstance();

        User user = new User();
        user.setLogin("Evil");
        user.setPassword("666");
        user.setFio("Evil Ivan Ivanovich");
        user.setBirthday(LocalDate.of(1993,7, 1));
        user.setRegistration(LocalDateTime.now());

        userStorage.add(user);

        MemoryChatStorage chatStorage = MemoryChatStorage.getInstance();

        Message message = new Message();
        message.setFrom("unknown");
        message.setSendDate(LocalDateTime.now());
        message.setText("Я слежу за тобой!");

        chatStorage.addMessage(user.getLogin(), message);
    }
}
