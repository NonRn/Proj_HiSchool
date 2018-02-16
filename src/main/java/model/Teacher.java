/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Teacher {
    int t_no;
    String national_id;
    String t_name;
    String t_lastname;
    String gender;
    String Address;
    String tel;
    String email;
    int r_no;

    public Teacher() {
    }
    
    public Teacher(int t_no, String national_id, String t_name, String t_lastname, String gender, String Address, String tel, String email, int r_no) {
        this.t_no = t_no;
        this.national_id = national_id;
        this.t_name = t_name;
        this.t_lastname = t_lastname;
        this.gender = gender;
        this.Address = Address;
        this.tel = tel;
        this.email = email;
        this.r_no = r_no;
    }

    public int getT_no() {
        return t_no;
    }

    public void setT_no(int t_no) {
        this.t_no = t_no;
    }

    public String getNational_id() {
        return national_id;
    }

    public void setNational_id(String national_id) {
        this.national_id = national_id;
    }

    public String getT_name() {
        return t_name;
    }

    public void setT_name(String t_name) {
        this.t_name = t_name;
    }

    public String getT_lastname() {
        return t_lastname;
    }

    public void setT_lastname(String t_lastname) {
        this.t_lastname = t_lastname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getR_no() {
        return r_no;
    }

    public void setR_no(int r_no) {
        this.r_no = r_no;
    }
   
    public Teacher getProfile(int no){
        String SQL = "select * from hi_school.Teacher where t_no = ?";
        Connection con = null;
        Teacher teacher = new Teacher() ;
        try {
            ConnectionBuilder connect = new ConnectionBuilder();
            con = connect.getConnection();
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setInt(1, no);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                teacher = new Teacher(rs.getInt("T_no"), rs.getString("National_Id"), rs.getString("T_Name"), rs.getString("T_Lastname"), rs.getString("Gender"), rs.getString("Address"), rs.getString("Tel"), rs.getString("Email"), rs.getInt("R_No"));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return teacher ;
    }
}
