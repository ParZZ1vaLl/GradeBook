package com.gradecom.gradebook.UI;

import com.gradecom.gradebook.BL.Abstract.IGradebookService;
import com.gradecom.gradebook.BL.Abstract.IUserService;
import com.gradecom.gradebook.model.User;
import java.io.IOException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ServletContext context = getServletContext();
        IUserService userService = (IUserService) context.getAttribute("userv");
        IGradebookService gbService = (IGradebookService) context.getAttribute("gbserv");

        String log = request.getParameter("log");
        User user = userService.getByLogin(log);

        if (user == null) {
            request.setAttribute("error", "Неправильно введені дані");
            request.getRequestDispatcher("main.jsp").forward(request, response);
            return;
        }
        String pass = request.getParameter("pas");

        if (!userService.checkPassword(user, pass)) {
            request.setAttribute("error", "Неправильно введені дані");
            request.getRequestDispatcher("main.jsp").forward(request, response);
            return;
        }
        request.getSession().setAttribute("userGradebooks", gbService.getByUser(user));
        request.getSession().setAttribute("user", user);
        request.getRequestDispatcher("main.jsp").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
