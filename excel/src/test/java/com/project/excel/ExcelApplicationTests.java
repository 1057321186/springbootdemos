package com.project.excel;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.TemplateExportParams;
import com.project.excel.template.StudentParam;
import org.apache.poi.ss.usermodel.Workbook;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
class ExcelApplicationTests {

    @Test
    void contextLoads() {

        List<StudentParam> list = new ArrayList<>();
        for(int i = 0;i < 5; i++){
            StudentParam studentParam = new StudentParam();
            studentParam.setAge(i);
            studentParam.setName("王春"+i);
            studentParam.setClassId(i+"班级");
            studentParam.setSex("男");
            list.add(studentParam);
        }


        Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams("学生信息","学生"),
                StudentParam.class, list);

        //保存数据
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream("F:\\emp.xls");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            workbook.write(fos);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
