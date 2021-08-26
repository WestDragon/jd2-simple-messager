package by.it_academy.jd2.hw.example.messenger.storage;

import by.it_academy.jd2.hw.example.messenger.storage.api.IUserStorage;

public class UserStorageFactory {
    private static StorageType type = null;

    private UserStorageFactory() {
    }

    public static synchronized void setType(StorageType type) {
        if(type != null){
            UserStorageFactory.type = type;
        } else {
            throw new IllegalStateException("Нельзя менять тип хранилища");
        }
    }

    public static IUserStorage getInstance(){
        if(type == null){
            throw new IllegalStateException("Тип хранилища не задан");
        }

        switch (type){
            case MEMORY:
                return MemoryUserStorage.getInstance();
            default:
                throw new IllegalStateException("Неизвестный тип хранилища пользователей");
        }
    }
}
