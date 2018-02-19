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
 * @author Ratchanon
 */
public class Room {
    int r_no ;
    String r_name ;
    int stdCount ;

    public Room(int r_no, String r_name, int stdCount) {
        this.r_no = r_no;
        this.r_name = r_name;
        this.stdCount = stdCount;
    }

    public Room() {
    }
    
    public int getR_no() {
        return r_no;
    }

    public void setR_no(int r_no) {
        this.r_no = r_no;
    }

    public String getR_name() {
        return r_name;
    }

    public void setR_name(String r_name) {
        this.r_name = r_name;
    }

    public int getStdCount() {
        return stdCount;
    }

    public void setStdCount(int stdCount) {
        this.stdCount = stdCount;
    }

    public Room getRoomById(int room_id){
        Room room = null ;
        String SQL = "select * from hi_school.Room where r_no = ?";
        Connection con = null;
        try {
            ConnectionBuilder connect = new ConnectionBuilder();
            con = connect.getConnection();
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setInt(1, room_id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                room = new Room(rs.getInt("r_no"), rs.getString("r_name"), rs.getInt("stdCount"));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return room ;
    }
    
    public static void main(String[] args) {
        Room r = new Room();
        r = r.getRoomById(400001);
        System.out.println(r.getR_name()+r.getStdCount());
    }
    
}
