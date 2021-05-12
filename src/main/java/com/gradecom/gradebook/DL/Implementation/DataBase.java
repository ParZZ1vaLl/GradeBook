package com.gradecom.gradebook.DL.Implementation;

import com.gradecom.gradebook.model.Classwork;
import com.gradecom.gradebook.model.Grade;
import com.gradecom.gradebook.model.Gradebook;
import com.gradecom.gradebook.model.User;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class DataBase {
    Map<Integer, Gradebook> gradebooks;
    Map<Integer, User> users;
    Map<Integer, Classwork> classworks;
    Map<Integer, Grade> grades;

    public DataBase() {
        gradebooks = new LinkedHashMap<>();
        users = new LinkedHashMap<>();
        classworks = new LinkedHashMap<>();
        grades = new LinkedHashMap<>();
        
    }

    public DaoFactory getDaoFactory() {
        return new DaoFactory(this);
    }  
    
    public void generate(){
        User teacher = new User(1, "user", "1111", "Anatoliy", "Sergiyovich");
        
        User user1 = new User(2, "user1", "1111", "Sergiy", "Teren");
        User user2 = new User(3, "user2", "1111", "Arseniy", "Mayboroda");
        User user3 = new User(4, "user3", "1111", "Andriy", "Vilniy");
        
        users.put(teacher.getId(), teacher);
        users.put(user1.getId(), user1);
        users.put(user2.getId(), user2);
        users.put(user3.getId(), user3);
        
        List<User> users1 = new ArrayList<>();
        users1.add(user1);
        users1.add(user2);
        users1.add(user3);
        Gradebook gb1 = new Gradebook(1, "Math", users1, teacher);
        
        List<User> users2 = new ArrayList<>();
        users2.add(user1);
        users2.add(user2);
        Gradebook gb2 = new Gradebook(2, "PT", users2, teacher);
        
        gradebooks.put(gb1.getId(), gb1);
        gradebooks.put(gb2.getId(), gb2);
        
        Grade g0 = new Grade(1, ""); 
        Grade g1 = new Grade(2, "Н"); 
        Grade g2 = new Grade(3, "1"); 
        Grade g3 = new Grade(4, "2"); 
        Grade g4 = new Grade(5, "3"); 
        Grade g5 = new Grade(6, "4");
        Grade g6 = new Grade(7, "5"); 
        
        grades.put(g0.getId(), g0);
        grades.put(g1.getId(), g1);
        grades.put(g2.getId(), g2);
        grades.put(g3.getId(), g3);
        grades.put(g4.getId(), g4);
        grades.put(g5.getId(), g5);
        grades.put(g6.getId(), g6);
        
        
        Map map1 = new LinkedHashMap<User, Grade>();
        map1.put(user1, g1);
        map1.put(user2, g6);
        map1.put(user3, g2);
        
        Classwork cw1 = new Classwork(1, new GregorianCalendar(2021, 5, 2), map1, gb1);
        
        Map map2 = new LinkedHashMap<User, Grade>();
        map2.put(user1, g1);
        map2.put(user2, g6);
        map2.put(user3, g2);
        
        Classwork cw2 = new Classwork(2, new GregorianCalendar(2021, 5, 4), map2, gb1);
        
        Map map3 = new LinkedHashMap<User, Grade>();
        map3.put(user2, g1);
        map3.put(user3, g6);
        
        Classwork cw3 = new Classwork(3, new GregorianCalendar(2021, 5, 4), map3, gb2);
        
        classworks.put(cw1.getId(), cw1);
        classworks.put(cw2.getId(), cw2);
        classworks.put(cw3.getId(), cw3);
    }
}
