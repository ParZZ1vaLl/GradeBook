package com.gradecom.gradebook.UI;

import com.gradecom.gradebook.BL.Abstract.IClassworkService;
import com.gradecom.gradebook.BL.Abstract.IGradebookService;
import java.io.IOException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class OpenServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ServletContext context=getServletContext(); 
        IClassworkService cwService = (IClassworkService)context.getAttribute("cserv");
        request.getSession().setAttribute("classworks",
                cwService.getByGB(Integer.parseInt(request.getParameter("id"))));
        IGradebookService dbService = (IGradebookService)context.getAttribute("gbserv");
        request.getSession().setAttribute("gb",
                dbService.get(Integer.parseInt(request.getParameter("id"))));
        request.getSession().removeAttribute("saved");
        request.getRequestDispatcher("main.jsp").forward(request,response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
