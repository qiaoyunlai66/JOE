package com.joe.qiao.drreports.field;

import java.util.List;

/**
 * Created by Joe Qiao on 19/12/2017.
 */
public class Section {
    private Integer id;
    private String name;
    private List<Detail> detailList;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Detail> getDetailList() {
        return detailList;
    }

    public void setDetailList(List<Detail> detailList) {
        this.detailList = detailList;
    }
}
