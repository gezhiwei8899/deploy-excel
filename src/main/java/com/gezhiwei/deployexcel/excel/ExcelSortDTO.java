package com.ddhz.hospitalcommunity.excel;

/**
 * Created by Administrator on 2018/12/22.
 */
public class ExcelSortDTO {
    String name ;

    Integer sort;

    public ExcelSortDTO(String name, Integer sort) {
        this.name = name;
        this.sort = sort;
    }

    public ExcelSortDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }
}
