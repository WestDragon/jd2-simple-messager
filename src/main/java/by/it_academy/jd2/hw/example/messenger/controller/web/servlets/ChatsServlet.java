package by.it_academy.jd2.hw.example.messenger.controller.web.servlets;

import by.it_academy.jd2.hw.example.messenger.model.Message;
import by.it_academy.jd2.hw.example.messenger.model.User;
import by.it_academy.jd2.hw.example.messenger.storage.MemoryChatStorage;
import by.it_academy.jd2.hw.example.messenger.storage.api.IChatStorage;
import by.it_academy.jd2.hw.example.messenger.view.AuthService;
import by.it_academy.jd2.hw.example.messenger.view.api.IAuthService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "ChatsServlet", urlPatterns = "/chats")
public class ChatsServlet extends HttpServlet {

    private final IChatStorage chatStorage;

    public ChatsServlet() {
        this.chatStorage = MemoryChatStorage.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        User user = (User) session.getAttribute("user");

        if(user == null){
            throw new SecurityException("Ошибка безопасности");
        }

        List<Message> messages = this.chatStorage.get(user.getLogin());

        req.setAttribute("chat", messages);
        req.getRequestDispatcher("/views/chats.jsp").forward(req, resp);
    }
}
