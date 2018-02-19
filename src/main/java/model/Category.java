/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Ratchanon
 */
public class Category {
    int c_no ;
    String c_name ;
    int c_percent ;
    int s_no ;

    public Category(int c_no, String c_name, int c_percent, int s_no) {
        this.c_no = c_no;
        this.c_name = c_name;
        this.c_percent = c_percent;
        this.s_no = s_no;
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
    
}
