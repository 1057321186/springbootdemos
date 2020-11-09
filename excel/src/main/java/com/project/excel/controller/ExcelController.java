package com.project.excel.controller;


import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import com.alibaba.fastjson.JSONObject;
import com.project.excel.template.StudentParam;
import com.project.excel.vo.ApiResult;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@Slf4j
public class ExcelController {

    /**
     * 上传Excel
     * 单个sheet，未校验
     * @param file
     */
    @PostMapping("/import")
    public ApiResult importExcel(@RequestParam MultipartFile file){
        ApiResult result = new ApiResult();
        log.info("上传Excel");
        // 初始化ImportParams
        ImportParams params = new ImportParams();
        // 开启校验
//        params.setNeedVerify(true);
            try {
                List<StudentParam> list = ExcelImportUtil.importExcel(file.getInputStream(),StudentParam.class,params);
                for(StudentParam studentParam : list){
                    log.info(JSONObject.toJSONString(studentParam));
                }
            } catch (Exception e) {
                log.error("导入失败",e);
                result.error("导入失败");
            }
            return result;
    }

    /**
     * 单个sheet导出
     */
    @GetMapping("/export")
    public void exportExcel(){
        ApiResult result = new ApiResult();

        // 造的数据
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

        // 保存数据
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
