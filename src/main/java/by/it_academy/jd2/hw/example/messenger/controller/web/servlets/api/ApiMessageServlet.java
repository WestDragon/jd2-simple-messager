package by.it_academy.jd2.hw.example.messenger.controller.web.servlets.api;

import by.it_academy.jd2.hw.example.messenger.core.dto.MessageCreateDTO;
import by.it_academy.jd2.hw.example.messenger.service.MessageService;
import by.it_academy.jd2.hw.example.messenger.service.api.IMessageService;
import by.it_academy.jd2.hw.example.messenger.storage.entity.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "ApiMessageServlet", urlPatterns = "/api/message")
public class ApiMessageServlet extends HttpServlet {

    private final IMessageService messageService;

    public ApiMessageServlet() {
        this.messageService = MessageService.getInstance();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        User user = (User) session.getAttribute("user");

        if(user == null){
            throw new SecurityException("Ошибка безопасности");
        }

        String recipient = req.getParameter("recipient");
        String text = req.getParameter("text");

        MessageCreateDTO message = new MessageCreateDTO();
        message.setFrom(user.getLogin());
        message.setTo(recipient);
        message.setText(text);

        try{
            this.messageService.addMessage(message);
            req.setAttribute("success", true);
        } catch (IllegalArgumentException e){
            req.setAttribute("error", true);
            req.setAttribute("message",  e.getMessage());
        }
        req.getRequestDispatcher("/views/message.jsp").forward(req, resp);
    }
}
