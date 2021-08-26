package by.it_academy.jd2.hw.example.messenger.controller.web.listeners;

import by.it_academy.jd2.hw.example.messenger.storage.ChatStorageFactory;
import by.it_academy.jd2.hw.example.messenger.storage.StorageType;
import by.it_academy.jd2.hw.example.messenger.storage.UserStorageFactory;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;

public class StorageInitializer implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {

        String storageTypeRaw = sce.getServletContext().getInitParameter("storageType");

        StorageType storageType = StorageType.valueOf(storageTypeRaw);

        ChatStorageFactory.setType(storageType);
        UserStorageFactory.setType(storageType);
    }
}
