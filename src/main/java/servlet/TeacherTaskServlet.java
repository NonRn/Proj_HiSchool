/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Room;
import model.Subject;
import model.Teach;

/**
 *
 * @author Ratchanon
 */
public class TeacherTaskServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        if (request.getParameter("subjectslist")== null){
            ArrayList<Subject> subs = new ArrayList<Subject>();
            int subNo[] = Teach.getSubjectByTeacher(10006);
//        int roomNo[] = Teach.getRoomBySubjectAndTeacher(0, 0);
            Subject s = new Subject();
            for (int i : subNo) {
                if (i != 0) {
                    subs.add(s.getSubjectById(i));
                }
            }
            request.setAttribute("subject", subs);
        } else {
            ArrayList<Room> rooms = new ArrayList<Room>();
            int roomNo[] = Teach.getRoomBySubjectAndTeacher(Integer.parseInt(request.getParameter("subjectslist")),10006);
            Room r = new Room();
            for (int j : roomNo) {
                if (j != 0) {
                    rooms.add(r.getRoomById(j));
                }
            }
            request.setAttribute("room", rooms);
        }
        getServletContext().getRequestDispatcher("/TaskList.jsp").forward(request, response);
        
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
