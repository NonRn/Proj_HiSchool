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
import model.Task;
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
        if (request.getParameter("subjectslist") != null || request.getParameter("subjectSelect") != null) {
            ArrayList<Room> rooms = new ArrayList<Room>();
            int roomNo[] ;
            if (request.getParameter("subjectSelect") == null)
                roomNo = Teach.getRoomBySubjectAndTeacher(Integer.parseInt(request.getParameter("subjectslist")), 10006);
            else 
                roomNo = Teach.getRoomBySubjectAndTeacher(Integer.parseInt(request.getParameter("subjectSelect")), 10006);
            Room r = new Room();
            for (int j : roomNo) {
                if (j != 0) {
                    rooms.add(r.getRoomById(j));
                }
            }
            String subSelect = request.getParameter("subjectslist");
            request.setAttribute("subSelect", subSelect);
            request.setAttribute("room", rooms);
        }
        if (request.getParameter("roomslist") != null) {
            ArrayList<Task> tasks = new ArrayList<Task>();
            int taskNo[] = Teach.getTaskByTeach(Integer.parseInt(request.getParameter("roomslist")), Integer.parseInt(request.getParameter("subjectSelect")));
            Task t = new Task();
            String subSelect = request.getParameter("subjectSelect");
            String roomSelect = request.getParameter("roomslist");
            System.out.println("subSe : " + subSelect);
            System.out.println("roomSe : " + roomSelect);
            for (int k : taskNo) {
                if (k != 0) {
                    tasks.add(t.getTaskByTaskNo(k));
                }
            }
            request.setAttribute("subSelect", subSelect);
            request.setAttribute("roomSelect", roomSelect);
            request.setAttribute("task", tasks);
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
