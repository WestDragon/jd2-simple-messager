package by.it_academy.jd2.hw.example.messenger.storage;

import by.it_academy.jd2.hw.example.messenger.storage.api.IChatStorage;

public class ChatStorageFactory {
    private static StorageType type = null;

    private ChatStorageFactory() {
    }

    public static synchronized void setType(StorageType type) {
        if(type != null){
            ChatStorageFactory.type = type;
        } else {
            throw new IllegalStateException("Нельзя менять тип хранилища");
        }
    }

    public static IChatStorage getInstance(){
        if(type == null){
            throw new IllegalStateException("Тип хранилища не задан");
        }

        switch (type){
            case MEMORY:
                return MemoryChatStorage.getInstance();
            default:
                throw new IllegalStateException("Неизвестный тип хранилища сообщений");
        }
    }
}
