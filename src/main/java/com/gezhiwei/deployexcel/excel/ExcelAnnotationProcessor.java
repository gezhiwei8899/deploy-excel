package com.ddhz.hospitalcommunity.excel;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

/**
 * @ClassName: ExcelAnnotationProcessor
 * @Author: 葛志伟(赛事)
 * @Description:
 * @Date: 2018/12/22 14:20
 * @modified By:
 */
public class ExcelAnnotationProcessor {

    private static <T> Map<Field, ExcelSortDTO> getFieldName(Class<T> clazz) {
        HashMap<Field, ExcelSortDTO> map = Maps.newHashMap();
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field field : declaredFields) {
            Excel annotation = field.getAnnotation(Excel.class);
            if (null == annotation) {
                continue;
            }
            String name = annotation.name();
            Integer sort = annotation.sort();
            ExcelSortDTO sortDTO = new ExcelSortDTO(name, sort);
            map.put(field, sortDTO);

        }
        return map;
    }

    public static <T> HSSFWorkbook createHssfWorkbook(List<T> list, Class<T> clazz) throws InvocationTargetException, IllegalAccessException {
        // 创建excel
        HSSFWorkbook wb = new HSSFWorkbook();
        HSSFSheet sheet = wb.createSheet();
        //取得key value
        Map<Field, ExcelSortDTO> fieldName = getFieldName(clazz);
        //有序集合
        List<Field> fieldList = new ArrayList<>(list.size());
        ArrayList<String> strings = new ArrayList<>(list.size());
        List<ExcelWrapper> wrappers = Lists.newArrayList();
        for (Field key : fieldName.keySet()) {
            ExcelWrapper wrapper = new ExcelWrapper();
            wrapper.setField(key);
            wrapper.setName(fieldName.get(key).getName());
            wrapper.setSort(fieldName.get(key).getSort());
            wrappers.add(wrapper);
        }
        wrappers.sort(Comparator.comparing(ExcelSortDTO::getSort));

        wrappers.forEach(wrapper -> {
            fieldList.add( wrapper.getField());
            strings.add(wrapper.getName());
        });


        //第一row 为汉字
        createRowZore(sheet.createRow(0), strings);

        //从“1”row开始
        HSSFRow row = null;
        int i = 0;
        for (T t : list) {
            row = sheet.createRow(i + 1);
            Class<?> aClass = t.getClass();
            Method[] ms = aClass.getDeclaredMethods();
            int c = 0;
            for (Field field : fieldList) {
                for (Method m : ms) {
                    if (m.getName().equalsIgnoreCase("get" + StringUtils.capitalize(field.getName()))) {
                        Object invoke = m.invoke(t);
                        row.createCell(c).setCellValue(null == invoke ? StringUtils.EMPTY : invoke.toString());
                        c++;
                    }
                }
            }
            i++;
        }
        return wb;
    }

    private static void createRowZore(HSSFRow row, List<String> fieldName) {
        int i = 0;
        for (String s : fieldName) {
            row.createCell(i).setCellValue(s);
            i++;
        }
    }

}
