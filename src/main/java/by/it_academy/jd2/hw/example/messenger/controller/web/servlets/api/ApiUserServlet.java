package by.it_academy.jd2.hw.example.messenger.controller.web.servlets.api;

import by.it_academy.jd2.hw.example.messenger.core.dto.UserCreateDTO;
import by.it_academy.jd2.hw.example.messenger.service.UserService;
import by.it_academy.jd2.hw.example.messenger.service.api.IUserService;
import by.it_academy.jd2.hw.example.messenger.storage.entity.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@WebServlet(name = "ApiUserServlet", urlPatterns = "/api/user")
public class ApiUserServlet extends HttpServlet {

    private final IUserService userService;

    public ApiUserServlet() {
        this.userService = UserService.getInstance();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        String fio = req.getParameter("fio");
        String birthday = req.getParameter("birthday");

        UserCreateDTO user = new UserCreateDTO();
        user.setLogin(login);
        user.setPassword(password);
        user.setFio(fio);
        if(!birthday.isBlank()){
            user.setBirthday(LocalDate.parse(birthday, DateTimeFormatter.ISO_LOCAL_DATE));
        }

        try{
            User signUp = this.userService.signUp(user);
            req.getSession().setAttribute("user", signUp);
            resp.sendRedirect(req.getContextPath() + "/");
        } catch (IllegalArgumentException e){
            req.setAttribute("error", true);
            req.setAttribute("message", e.getMessage());
            req.getRequestDispatcher("/views/signUp.jsp").forward(req, resp);
        }
    }
}
