/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Meen
 */
public class Teach {
    int t_no;
    int s_no;
    int r_no;

    public Teach() {
    }

    public Teach(int t_no, int s_no, int r_no) {
        this.t_no = t_no;
        this.s_no = s_no;
        this.r_no = r_no;
    }

    public int getT_no() {
        return t_no;
    }

    public void setT_no(int t_no) {
        this.t_no = t_no;
    }

    public int getS_no() {
        return s_no;
    }

    public void setS_no(int s_no) {
        this.s_no = s_no;
    }

    public int getR_no() {
        return r_no;
    }

    public void setR_no(int r_no) {
        this.r_no = r_no;
    }
    
    public static int[] getSubjectByTeacher(int t_no){
        Connection con = null;
        String SQL = "Select s_no From Teach Where t_no=?";
        int subjectNo [] = new int[10];
        try {
            ConnectionBuilder connect = new ConnectionBuilder();
            con = connect.getConnection();
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setInt(1, t_no);
            ResultSet rs = ps.executeQuery();
            int index = 0;
            while(rs.next()){
                subjectNo[index] = rs.getInt("s_no");
                index++;
            }
               
        } catch (Exception e) {
            System.out.println(e);
        }
        
        return subjectNo;
    }
    
    public static int[] getTaskByTeach(int r_no, int s_no){
        Connection con = null;
        String SQL = "Select task_no From Task t join Category c on c.c_no = t.c_no Where t.r_no=? and c.s_no = ?";
        int taskNo[] = new int[10];
        try {
            ConnectionBuilder connect = new ConnectionBuilder();
            con = connect.getConnection();
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setInt(1, r_no);
            ps.setInt(2, s_no);
            ResultSet rs = ps.executeQuery();
            int index = 0;
            while(rs.next()){
                taskNo[index] = rs.getInt("task_no");
                index++;
            }
               
        } catch (Exception e) {
            System.out.println(e);
        }
        
        return taskNo;
    }
    
    public static int[] getRoomBySubjectAndTeacher(int s_no, int t_no){
        Connection con = null;
        String SQL = "Select r_no From Teach Where s_no = ? and t_no = ?";
        int roomNo[] = new int[10];
        try {
            ConnectionBuilder connect = new ConnectionBuilder();
            con = connect.getConnection();
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setInt(1, s_no);
            ps.setInt(2, t_no);
            ResultSet rs = ps.executeQuery();
            int index = 0;
            while(rs.next()){
                roomNo[index] = rs.getInt("r_no");
                index++;
            }
               
        } catch (Exception e) {
            System.out.println(e);
        }
        
        return roomNo;
    }
}
