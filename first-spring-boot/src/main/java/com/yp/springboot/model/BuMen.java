package com.yp.springboot.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class BuMen {
    @Id
    @GeneratedValue
    private int buid;

    @Column(name = "buame")
    private String buame;


    @OneToMany(mappedBy = "bumen")
    @JsonIgnore
    private Set<Ren> set = new HashSet<Ren>();

    //======映射=======

    @JsonIgnore
    @ManyToMany(mappedBy = "bumen")
    private Set<ZhiCheng> zc = new HashSet<ZhiCheng>();


    public int getBuid() {
        return buid;
    }

    public void setBuid(int buid) {
        this.buid = buid;
    }

    public String getBuame() {
        return buame;
    }

    public void setBuame(String buame) {
        this.buame = buame;
    }

    public Set<Ren> getSet() {
        return set;
    }

    public void setSet(Set<Ren> set) {
        this.set = set;
    }

    public Set<ZhiCheng> getZc() {
        return zc;
    }

    public void setZc(Set<ZhiCheng> zc) {
        this.zc = zc;
    }

    @Override
    public String toString() {
        return "BuMen{" +
                "buid=" + buid +
                ", buame='" + buame + '\'' +
                ", set=" + set +
                ", zc=" + zc +
                '}';
    }
}
