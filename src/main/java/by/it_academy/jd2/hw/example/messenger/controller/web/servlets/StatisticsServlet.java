package by.it_academy.jd2.hw.example.messenger.controller.web.servlets;

import by.it_academy.jd2.hw.example.messenger.view.StatisticsService;
import by.it_academy.jd2.hw.example.messenger.view.api.IStatisticsService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@WebServlet(name = "StatisticsServlet", urlPatterns = "/statistics")
public class StatisticsServlet extends HttpServlet {

    private final IStatisticsService statisticsService;

    public StatisticsServlet() {
        this.statisticsService = StatisticsService.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding(StandardCharsets.UTF_8.toString());
        resp.setContentType("text/html; charset=UTF-8");

        req.setAttribute("stats",statisticsService.getStats());


        req.getRequestDispatcher("/views/statistics.jsp").forward(req, resp);
    }
}
