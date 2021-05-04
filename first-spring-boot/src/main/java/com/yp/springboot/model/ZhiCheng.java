package com.yp.springboot.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
//职称
public class ZhiCheng {
    @Id
    @GeneratedValue//代表自增
    private Integer zgid;

    @Column(name = "zgname")
    private String zgname;

    //======映射=======
    //多对多
    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "BM_ZC", joinColumns = @JoinColumn(name = "ZG_id"), inverseJoinColumns = @JoinColumn(name = "BM_id"))
    private Set<BuMen> bumen = new HashSet<BuMen>();

    public Integer getZgid() {
        return zgid;
    }

    public void setZgid(Integer zgid) {
        this.zgid = zgid;
    }

    public String getZgname() {
        return zgname;
    }

    public void setZgname(String zgname) {
        this.zgname = zgname;
    }

    public Set<BuMen> getBumen() {
        return bumen;
    }

    public void setBumen(Set<BuMen> bumen) {
        this.bumen = bumen;
    }
}
