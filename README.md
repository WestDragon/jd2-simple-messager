# Мессенджер
## На первом этапе требуется выполнить
- Написать JSP страницу /signUp на которой будет форма для регистрации. Данные для регистрации:
  -- Логин\Пароль
  -- ФИО
  -- Дата рождения
- Зарегистрировать пользователя, значит сохранить данные о нём в приложении
- Написать JSP страницу /signIn на которой будет форма для входа. (логин\пароль). Если не нашли пользователя или не подошел пароль, выдать ошибку.
- Написать JSP страницу /message где при GET запросе будет отображаться форма для отправки сообщения (логин кому\текст), при POST запросе отправляться сообщение.
- Написать JSP страницу /chats на которой будут отображаться сообщения отправленные текущему пользователю.
  -- Дата\время отправки
  -- От кого
  -- Текст
- Подключите SecurityFilter к проекту

```java
@WebFilter(urlPatterns = {"/chats", "/message"})
public class SecurityFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        String contextPath = req.getContextPath();
        HttpSession session = req.getSession();
        if((session!=null) && (session.getAttribute("user") != null)) {
            chain.doFilter(request, response);
        } else {
            //редирект на логин
            res.sendRedirect(contextPath + "/signIn");
        }
    }
}
```
## На втором этапе требуется выполнить
- Сохранять данные о зарегистрированных пользователях в файле
- Сохранять данные о сообщениях в файле
- Каждый раз при обращении к хранилищу за информацией считывать информацию из файла заново и отдавать запрошенное
- Сделать возможность выбора, до запуска приложения, где хранить данные:
  -- как раньше в памяти
  -- новым способом в файле
- Создать страницу /user на которой будет отражена вся информация о зарегистрированных пользователях, дату и время их регистрации
- Создать страницу /about на которой будет отражена дата запуска приложения, информацию о выборе способа хранения.