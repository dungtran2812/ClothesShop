/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import sample.shopping.Cart;
import sample.shopping.Clothes;
import sample.user.UserDAO;
import sample.user.UserDTO;
import sample.user.UserError;

/**
 *
 * @author asus
 */
public class CheckOutController extends HttpServlet {

    private static final String ERROR = "viewcart.jsp";
    private static final String SUCCESS = "viewcart.jsp";
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        
        
        try {
            HttpSession session = request.getSession();
            Cart cart = (Cart) session.getAttribute("CART");
            UserDTO user = (UserDTO) session.getAttribute("LOGIN_USER");
            UserDAO dao = new UserDAO();
            Cart storage = dao.getStorage();
            boolean checkQuanity = true;
            double total = 0;
            
            for (Clothes cloth : cart.getCart().values()) {
                int quantity = storage.getCart().get(cloth.getId()).getQuantity();
                if (cloth.getQuantity() > storage.getCart().get(cloth.getId()).getQuantity()) {
                    checkQuanity = false;
                    request.setAttribute("QUANTITY_MESSAGE", cloth.getName() + " only has " + storage.getCart().get(cloth.getId()).getQuantity());
                }
                
            }
            if (checkQuanity) {
                boolean checkCheckOut = dao.checkout(user, cart, total);
                if (checkCheckOut) {
                    url = SUCCESS;
                    request.setAttribute("CHECKOUT_MESSAGE", "Order successful");
                    session.removeAttribute("CART");
                } else {
                    request.setAttribute("CHECKOUT_MESSAGE", "Order fail");
                }
            } 
        } catch (SQLException e) {
            log("error at checkoutcontroller");
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
        }
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
