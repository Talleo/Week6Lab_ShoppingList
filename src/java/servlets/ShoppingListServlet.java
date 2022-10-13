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
 * @author godim
 */
public class ShoppingListServlet extends HttpServlet {

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        
        // get the current session
        HttpSession session = request.getSession();
        
        // get the list of strings from the session
        ArrayList<String> shoppingList = (ArrayList<String>)session.getAttribute("shoppingList");
        
        // if there is no list of numbers in the session, create a list
        if (shoppingList == null)
            shoppingList = new ArrayList<>();
        
        // get the item the user entered
        // if there is a String, add it to the list
        if (request.getParameter("item") != null) {
            String item = request.getParameter("item");
            shoppingList.add(item);
            
            // store the list back into the session
            session.setAttribute("shoppingList", shoppingList);
        }
    } 

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {


    }

}
