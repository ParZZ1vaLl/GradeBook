package com.gradecom.gradebook.UI;

import com.gradecom.gradebook.BL.Abstract.IClassworkService;
import com.gradecom.gradebook.BL.Abstract.IGradeService;
import com.gradecom.gradebook.BL.Abstract.IGradebookService;
import com.gradecom.gradebook.BL.Abstract.IUserService;
import com.gradecom.gradebook.BL.Implementation.ClassworkService;
import com.gradecom.gradebook.BL.Implementation.GradeService;
import com.gradecom.gradebook.BL.Implementation.GradebookService;
import com.gradecom.gradebook.BL.Implementation.UserService;
import com.gradecom.gradebook.DL.Abstract.IDaoFactory;
import com.gradecom.gradebook.DL.Implementation.DataBase;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class GradebookListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        DataBase database = new DataBase();
        database.generate();

        IDaoFactory daoFactory = database.getDaoFactory();

        IGradebookService gradebookService = new GradebookService(daoFactory);
        sce.getServletContext().setAttribute("gbserv", gradebookService);

        IUserService userService = new UserService(daoFactory);
        sce.getServletContext().setAttribute("userv", userService);
        
        IClassworkService classworkService = new ClassworkService(daoFactory);
        sce.getServletContext().setAttribute("cserv", classworkService);

        IGradeService gradeService = new GradeService(daoFactory);
        sce.getServletContext().setAttribute("gserv", gradeService);
        
        sce.getServletContext().setAttribute("grades", gradeService.getAll());
          
    }
    

    @Override
    public void contextDestroyed(ServletContextEvent arg0) {
        
    }
}
