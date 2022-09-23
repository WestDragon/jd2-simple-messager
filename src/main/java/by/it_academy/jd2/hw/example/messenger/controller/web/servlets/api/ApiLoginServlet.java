package by.it_academy.jd2.hw.example.messenger.controller.web.servlets.api;

import by.it_academy.jd2.hw.example.messenger.core.dto.UserLoginDTO;
import by.it_academy.jd2.hw.example.messenger.service.AuthService;
import by.it_academy.jd2.hw.example.messenger.service.api.IAuthService;
import by.it_academy.jd2.hw.example.messenger.storage.entity.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "ApiLoginServlet", urlPatterns = "/api/login")
public class ApiLoginServlet extends HttpServlet {

    private final IAuthService authService;

    public ApiLoginServlet() {
        this.authService = AuthService.getInstance();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");

        try{
            User authentication = this.authService.authentication(new UserLoginDTO(login, password));
            req.getSession().setAttribute("user", authentication);
            resp.sendRedirect(req.getContextPath() + "/");
        } catch (IllegalArgumentException e){
            req.setAttribute("error", true);
            req.setAttribute("message", e.getMessage());
            req.getRequestDispatcher("/views/signUp.jsp").forward(req, resp);
        }
    }
}
