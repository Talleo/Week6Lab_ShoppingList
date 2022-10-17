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

        // variables
        HttpSession session = request.getSession();
        String action = request.getParameter("action");
        String username = (String) session.getAttribute("username");
        String loggedOut = (String) session.getAttribute("loggedout");

        // display message if logged out
        if (loggedOut != null) {
            request.setAttribute("message",
                    "You are logged out of the Shopping List web application.");
        }

        // when user pushes logout button, destroy session and go back to registration page
        if (action != null && action.equals("logout")) {
            session.invalidate();
            session = request.getSession();
            session.setAttribute("loggedout", "Yep. Logged out alright.");
            request.setAttribute("message", "You are now logged out of the Shopping List web application.");
            getServletContext().getRequestDispatcher("/WEB-INF/register.jsp")
                    .forward(request, response);
        }

        // if username is valid, go to shoppingList jsp
        if (username == null || username.equals("")) {
            getServletContext().getRequestDispatcher("/WEB-INF/register.jsp")
                    .forward(request, response);
        } else {
            getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp")
                    .forward(request, response);
        }
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

        // variables
        HttpSession session = request.getSession();
        String action = request.getParameter("action");
        String username = request.getParameter("username");
        ArrayList<String> shoppingCart = new ArrayList();
        String item = request.getParameter("item");

        if (session.getAttribute("shoppingCart") != null) {
            shoppingCart = (ArrayList) session.getAttribute("shoppingCart");
        }

        switch (action) {
            case "register":
                session.setAttribute("username", username);
                response.sendRedirect("ShoppingList");
                break;

            case "add":
                shoppingCart.add(item);
                session.setAttribute("shoppingCart", shoppingCart);
                response.sendRedirect("ShoppingList");
                break;

            case "delete":
                shoppingCart.remove(item);
                session.setAttribute("shoppingCart", shoppingCart);
                response.sendRedirect("ShoppingList");
                break;
        }
    }
}
