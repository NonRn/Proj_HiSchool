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
    
    public  int[] getSubjectByTeacher(int t_no){
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
    
    public static void main(String[] args) {
        Teach t = new Teach();
        int [] forLoop = t.getSubjectByTeacher(10001);
        for(int i : forLoop){
            System.out.println(i);
        }
        
        
        
    }
}
