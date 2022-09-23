package by.it_academy.jd2.hw.example.messenger.service.api;

import by.it_academy.jd2.hw.example.messenger.core.dto.UserCreateDTO;
import by.it_academy.jd2.hw.example.messenger.storage.entity.User;

import java.util.Collection;

public interface IUserService {
    User get(String login);
    User signUp(UserCreateDTO user);
    Collection<User> getAll();
    long getCount();
}
