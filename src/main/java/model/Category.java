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
import java.util.List;

/**
 *
 * @author Ratchanon
 */
public class Category {

    int c_no;
    String c_name;
    int c_percent;
    int s_no;

    public Category(int c_no, String c_name, int c_percent, int s_no) {
        this.c_no = c_no;
        this.c_name = c_name;
        this.c_percent = c_percent;
        this.s_no = s_no;
    }

    public Category(int c_no, String c_name) {
        this.c_no = c_no;
        this.c_name = c_name;
    }

    public Category() {
    }

    public int getC_no() {
        return c_no;
    }

    public void setC_no(int c_no) {
        this.c_no = c_no;
    }

    public String getC_name() {
        return c_name;
    }

    public void setC_name(String c_name) {
        this.c_name = c_name;
    }

    public int getC_percent() {
        return c_percent;
    }

    public void setC_percent(int c_percent) {
        this.c_percent = c_percent;
    }

    public int getS_no() {
        return s_no;
    }

    public void setS_no(int s_no) {
        this.s_no = s_no;
    }

    @Override
    public String toString() {
        return "Category{" + "c_no=" + c_no + ", c_name=" + c_name + ", c_percent=" + c_percent + ", s_no=" + s_no + '}';
    }

    public ArrayList<Category> getCategoryBySubject(int subjectNo) {
        String SQL = "select c_no, c_name From Category Where s_no = ?";
        Connection con = null;
        ArrayList<Category> listCategory = new ArrayList<>();

        try {
            con = ConnectionBuilder.getConnection();
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setInt(1, subjectNo);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Category cat = new Category(c_no = rs.getInt("C_No"),
                        c_name = rs.getString("C_Name"));
                listCategory.add(cat);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return listCategory;
    }
    
    public Category getCategoryById(int c_no){
        String SQL = "select * from Category where c_no = ?";
        Connection con = null;
        Category catDetail = null;
        try {
            con = ConnectionBuilder.getConnection();
            PreparedStatement ps = con.prepareCall(SQL);
            ps.setInt(1, c_no);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                catDetail = new Category(rs.getInt("c_no"),
                        rs.getString("c_name") , 
                        rs.getInt("c_percent"), 
                        rs.getInt("s_no"));
                
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return catDetail;
        
    }

}
