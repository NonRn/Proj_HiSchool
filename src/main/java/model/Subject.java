/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Meen
 */
public class Subject {
    int s_no;
    String s_name;
    int credit;

    public Subject() {
    }

    public Subject(int s_no, String s_name, int credit) {
        this.s_no = s_no;
        this.s_name = s_name;
        this.credit = credit;
    }

    public int getS_no() {
        return s_no;
    }

    public void setS_no(int s_no) {
        this.s_no = s_no;
    }

    public String getS_name() {
        return s_name;
    }

    public void setS_name(String s_name) {
        this.s_name = s_name;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }
    
    public Subject getSubjectById(int subject_No){
        Subject subject = null ;
        String SQL = "select * from hi_school.Subject where s_no = ?";
        Connection con = null;
        try {
            ConnectionBuilder connect = new ConnectionBuilder();
            con = connect.getConnection();
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setInt(1, subject_No);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                subject = new Subject(rs.getInt("s_no"), rs.getString("s_name"), rs.getInt("credit"));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return subject ;
    }
}
