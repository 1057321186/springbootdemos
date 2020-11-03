package com.project.excel.template;


import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;

import java.io.Serializable;

@Data
public class StudentParam implements Serializable {


    private String name;


    private Integer age;

    private String classId;

    private String sex;






}
