package by.it_academy.jd2.hw.example.messenger.service.api;

import by.it_academy.jd2.hw.example.messenger.storage.entity.User;

public interface IAuthService {
    User authentication(String login, String password);
}
