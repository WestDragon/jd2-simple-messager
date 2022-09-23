package by.it_academy.jd2.hw.example.messenger.service;

import by.it_academy.jd2.hw.example.messenger.core.dto.UserLoginDTO;
import by.it_academy.jd2.hw.example.messenger.service.api.IAuthService;
import by.it_academy.jd2.hw.example.messenger.service.api.IUserService;
import by.it_academy.jd2.hw.example.messenger.storage.entity.User;

import java.util.Objects;

public class AuthService implements IAuthService {
    private final static AuthService instance = new AuthService();

    private final IUserService userService;

    private AuthService() {
        this.userService = UserService.getInstance();
    }

    @Override
    public User authentication(UserLoginDTO credential) {
        User user = this.userService.get(credential.getLogin());
        if(user == null){
            throw new IllegalArgumentException("Неверный логин или пароль");
        }

        if(!Objects.equals(user.getPassword(), credential.getPassword())){
            throw new IllegalArgumentException("Неверный логин или пароль");
        }

        return user;
    }

    public static AuthService getInstance() {
        return instance;
    }
}
