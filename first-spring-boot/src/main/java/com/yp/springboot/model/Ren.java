package com.yp.springboot.model;

import javax.persistence.*;

@Entity
public class Ren {
    @Id
    @GeneratedValue
    private int rid;
    @Column(name = "rname")
    private String rname;


    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "buid")
    private BuMen bumen;

    public int getRid() {
        return rid;
    }

    public void setRid(int rid) {
        this.rid = rid;
    }

    public String getRname() {
        return rname;
    }

    public void setRname(String rname) {
        this.rname = rname;
    }

    public BuMen getBumen() {
        return bumen;
    }

    public void setBumen(BuMen bumen) {
        this.bumen = bumen;
    }

    @Override
    public String toString() {
        return "Ren{" +
                "rid=" + rid +
                ", rname='" + rname + '\'' +
                ", bumen=" + bumen +
                '}';
    }

}
