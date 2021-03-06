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
 * @author narischa
 */
public class Task {
    int task_No;
    String task_Name;
    String deadline;
    int score;
    String description;
    int c_No;
    int r_No;

    public Task() {
    }

    public Task(int task_No, String task_Name, String deadline, int score, String description, int c_No, int r_No) {
        this.task_No = task_No;
        this.task_Name = task_Name;
        this.deadline = deadline;
        this.score = score;
        this.description = description;
        this.c_No = c_No;
        this.r_No = r_No;
    }
    
    

    public int getTask_No() {
        return task_No;
    }

    public void setTask_No(int task_No) {
        this.task_No = task_No;
    }

    public String getTask_Name() {
        return task_Name;
    }

    public void setTask_Name(String task_Name) {
        this.task_Name = task_Name;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getC_No() {
        return c_No;
    }

    public void setC_No(int c_No) {
        this.c_No = c_No;
    }
    
    public int getR_No() {
        return c_No;
    }

    public void setR_No(int r_No) {
        this.r_No = r_No;
    }

    @Override
    public String toString() {
        return "Task{" + "task_No=" + task_No + ", task_Name=" + task_Name + ", deadline=" + deadline + ", score=" + score + ", description=" + description + ", c_No=" + c_No + ", r_No=" + r_No + '}';
    }
    
    
    

    public void addTask(Task t){
        Connection con = null;
        String SQL = "Insert into Task(Task_Name,Deadline,Score,Description,C_No,R_No) values(?,?,?,?,?,?)";
        try {
            con = ConnectionBuilder.getConnection();
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setString(1, t.task_Name);
            ps.setString(2, t.deadline);
            ps.setInt(3, t.score);
            ps.setString(4, t.description);
            ps.setInt(5, t.c_No);
            ps.setInt(6, t.r_No);
            int i = ps.executeUpdate();
            System.out.println("Add Success!!!");
            System.out.println(i);
            
            
            
            
            
        } catch (Exception e) {
            System.out.println(e);
        }
        
    }
    
    public Task getTaskByTaskNo(int task_no){
        Connection con = null;
        String SQL = "Select * from Task where task_no = ?";
        Task task = null;
        try {
            con = ConnectionBuilder.getConnection();
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setInt(1, task_no);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                task = new Task(
                        rs.getInt("task_No"),
                        rs.getString("task_Name"), 
                        rs.getString("deadline"), 
                        rs.getInt("score"), 
                        rs.getString("description"), 
                        rs.getInt("c_No"), 
                        rs.getInt("r_No"));
            }
            System.out.println(this.description);
                
        } catch (Exception e) {
            System.out.println(e);
        }
        
        return task;
             
    }
    
    public static void main(String[] args) {
        //Task t1 = new Task("test", "20/2/2018", 20, "ทดลองเลี้ยงปลา", 200003,400001);
        //t1.addTask(t1);
        Task t2 = new Task().getTaskByTaskNo(100026);
        System.out.println(t2);
        
        
        
        
    }
    
    
}
