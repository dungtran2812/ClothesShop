/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package sample.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sample.user.UserDAO;
import sample.user.UserDTO;
import sample.user.UserError;

/**
 *
 * @author truon
 */
@WebServlet(name = "CreateController", urlPatterns = {"/CreateController"})
public class CreateController extends HttpServlet {

    private static final String ERROR = "create.jsp";
    private static final String SUCCESS = "login.html";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        UserError userError = new UserError();
        boolean check = true;
        try {
            String userID = request.getParameter("userID");
            String fullName = request.getParameter("fullName");
            String roleID = request.getParameter("roleID");
            String password = request.getParameter("password");
            String confirm = request.getParameter("confirm");
            UserDAO dao = new UserDAO();
            if (userID.length() < 2 || userID.length() > 10) {
                check = false;
                userError.setUserIDError("User ID in range [2,10]");
            }
//            boolean checkID = dao.checkDuplicate(userID);
//            if (checkID) {
//                check = false;
//                userError.setUserIDError("User ID has existed!");
//            }
            if (fullName.length() < 5 || fullName.length() > 28) {
                check = false;
                userError.setFullNameError("Full Name must be in range [5,28]");
            }
            if (!password.equals(confirm)) {
                check = false;
                userError.setPasswordError("2 Password must be the same");
            }
            if (check) {
                //boolean checkInsert = dao.insert(new UserDTO(userID, fullName, roleID, password));
                boolean checkInsert = dao.insertv2(new UserDTO(userID, fullName, roleID, password));
                if (checkInsert) {
                    url = SUCCESS;
                } else {
                    userError.setError("Unknown Error!");
                    request.setAttribute("USER_ERROR", userError);
                }
            } else {
                request.setAttribute("USER_ERROR", userError);
            }
        } catch (Exception e) {
            log("Error at CreateController: " + e.toString());
            if (e.toString().contains("duplicate")) {
                userError.setUserIDError("User ID has existed!");
                request.setAttribute("USER_ERROR", userError);
            }
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
