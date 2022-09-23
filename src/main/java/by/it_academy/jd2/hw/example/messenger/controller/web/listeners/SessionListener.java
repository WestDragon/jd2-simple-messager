package by.it_academy.jd2.hw.example.messenger.controller.web.listeners;

import by.it_academy.jd2.hw.example.messenger.service.StatisticsService;
import by.it_academy.jd2.hw.example.messenger.service.api.IStatisticsService;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;

public class SessionListener implements HttpSessionListener {

    private final IStatisticsService statisticsService;

    public SessionListener() {
        this.statisticsService = StatisticsService.getInstance();
    }

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        this.statisticsService.incSessionCount();
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        this.statisticsService.decSessionCount();
    }
}
