/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Meen
 */
public class Subject {
    int s_no;
    int s_name;
    int credit;

    public Subject() {
    }

    public Subject(int s_no, int s_name, int credit) {
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

    public int getS_name() {
        return s_name;
    }

    public void setS_name(int s_name) {
        this.s_name = s_name;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }
    
    
}
