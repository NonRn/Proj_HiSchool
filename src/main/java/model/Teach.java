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
    
    
}
