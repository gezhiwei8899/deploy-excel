package com.ddhz.hospitalcommunity.excel;

import java.lang.reflect.Field;

/**
 * Created by Administrator on 2018/12/22.
 */
public class ExcelWrapper extends ExcelSortDTO {

    private Field field;

    public Field getField() {
        return field;
    }

    public void setField(Field field) {
        this.field = field;
    }
}
