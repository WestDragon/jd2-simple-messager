package by.it_academy.jd2.hw.example.messenger.controller.web.servlets.ui;

import by.it_academy.jd2.hw.example.messenger.service.MessageService;
import by.it_academy.jd2.hw.example.messenger.service.api.IMessageService;
import by.it_academy.jd2.hw.example.messenger.storage.entity.Message;
import by.it_academy.jd2.hw.example.messenger.storage.entity.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "ChatsServlet", urlPatterns = "/ui/user/chats")
public class UiChatsServlet extends HttpServlet {

    private final IMessageService messageService;

    public UiChatsServlet() {
        this.messageService = MessageService.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        User user = (User) session.getAttribute("user");

        if(user == null){
            throw new SecurityException("Ошибка безопасности");
        }

        List<Message> messages = this.messageService.get(user);

        req.setAttribute("chat", messages);
        req.getRequestDispatcher("/views/chats.jsp").forward(req, resp);
    }
}
