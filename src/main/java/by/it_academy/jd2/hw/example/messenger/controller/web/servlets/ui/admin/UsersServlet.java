package by.it_academy.jd2.hw.example.messenger.controller.web.servlets.ui.admin;

import by.it_academy.jd2.hw.example.messenger.service.UserService;
import by.it_academy.jd2.hw.example.messenger.service.api.IUserService;
import by.it_academy.jd2.hw.example.messenger.storage.entity.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.Collection;

@WebServlet(name = "UsersServlet", urlPatterns = "/admin/users")
public class UsersServlet extends HttpServlet {

    private final IUserService userService;

    public UsersServlet() {
        this.userService = UserService.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        resp.setCharacterEncoding(StandardCharsets.UTF_8.toString());
        resp.setContentType("text/html; charset=UTF-8");
        Collection<User> users = userService.getAll();
        for (User user : users) {
            writer.println(user);
        }
    }
}
