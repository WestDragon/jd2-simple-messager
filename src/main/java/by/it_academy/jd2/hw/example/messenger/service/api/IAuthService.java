package by.it_academy.jd2.hw.example.messenger.service.api;

import by.it_academy.jd2.hw.example.messenger.core.dto.UserLoginDTO;
import by.it_academy.jd2.hw.example.messenger.storage.entity.User;

public interface IAuthService {
    User authentication(UserLoginDTO credential);
}
