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
    int task_Name;
    int deadline;
    int score;
    int description;
    int c_No;

    
    public int getTask_No() {
        return task_No;
    }

    public void setTask_No(int task_No) {
        this.task_No = task_No;
    }

    public int getTask_Name() {
        return task_Name;
    }

    public void setTask_Name(int task_Name) {
        this.task_Name = task_Name;
    }

    public int getDeadline() {
        return deadline;
    }

    public void setDeadline(int deadline) {
        this.deadline = deadline;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getDescription() {
        return description;
    }

    public void setDescription(int description) {
        this.description = description;
    }

    public int getC_No() {
        return c_No;
    }

    public void setC_No(int c_No) {
        this.c_No = c_No;
    }
    
}
