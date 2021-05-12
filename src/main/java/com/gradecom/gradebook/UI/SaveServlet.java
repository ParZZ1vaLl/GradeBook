package com.gradecom.gradebook.UI;

import com.gradecom.gradebook.BL.Abstract.IClassworkService;
import com.gradecom.gradebook.BL.Abstract.IGradeService;
import com.gradecom.gradebook.model.Classwork;
import com.gradecom.gradebook.model.Grade;
import com.gradecom.gradebook.model.Gradebook;
import java.io.IOException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SaveServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        ServletContext context=getServletContext(); 
        IClassworkService cwService = (IClassworkService)context.getAttribute("cserv");
        Classwork cw = (Classwork)request.getSession().getAttribute("saved");
        IGradeService gService = (IGradeService)context.getAttribute("gserv");
        cw.getGrades().keySet().forEach(u -> {
            Grade grade = gService.get(Integer.parseInt(request.getParameter(u.getId().toString())));
            cw.getGrades().put(u, grade);
        });
        cwService.Save(cw);
        request.getSession().setAttribute("classworks",
                cwService.getByGB(((Gradebook)request.getSession().getAttribute("gb")).getId()));
        request.getSession().removeAttribute("saved");
        request.getRequestDispatcher("main.jsp").forward(request, response);
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
