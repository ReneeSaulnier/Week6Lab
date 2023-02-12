/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Renee
 */
public class ShoppingListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        String action = request.getParameter("action");
        String username = request.getParameter("username");
        
        if(action != null){
            session.invalidate();
            getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
        }else if(username != null){
            response.sendRedirect("shoppinglist");
            return;
        }
        
    getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
    
}

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            
            HttpSession session = request.getSession();
            String action = request.getParameter("action");
            String username = request.getParameter("username");
            String item = request.getParameter("itemlist");
            ArrayList<String> items;
            
            if(session.getAttribute("items") == null){
                items = new ArrayList<>();
            }else{
                items = (ArrayList<String>) session.getAttribute("items");
            }
            
            if(username == null || username.equals("")){
                request.setAttribute("message", "Please enter a username");
            }
            
            switch(action){
                case "add": items.add(item);
                            session.setAttribute("items", items);
                            getServletContext().getRequestDispatcher("/WEB-INF/shoppinglist.jsp").forward(request, response);
                            break;
                            
                case "logout": items.clear();
                               session.invalidate();
                               getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
                               break;
                               
                case "delete": items.remove(item);
                               session.setAttribute("items", items);
                               getServletContext().getRequestDispatcher("/WEB-INF/shoppinglist.jsp").forward(request, response);
                               break;
                               
                case "register": session.setAttribute("username", username);
                                 getServletContext().getRequestDispatcher("/WEB-INF/shoppinglist.jsp").forward(request, response);
                                 break;
            }   
        getServletContext().getRequestDispatcher("/WEB-INF/shoppinglist.jsp").forward(request, response);
    }

}
