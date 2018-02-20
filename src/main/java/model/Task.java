/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

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

    
    
    
}
