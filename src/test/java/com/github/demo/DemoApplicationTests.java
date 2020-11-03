package com.github.demo;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.params.ExcelExportEntity;
import org.apache.poi.ss.usermodel.Workbook;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
class DemoApplicationTests {

    /**
     * 直接导出数据测试
     * @throws IOException
     */
    @Test
    public void directExportExcel() throws IOException {
        // Map作为每一行的数据容器，List作为行的容器
        List<Map<String, Object>> rowDataList = new ArrayList<>();
        // 每个ExcelExportEntity存放Map行数据的key
        List<ExcelExportEntity> keyList = new ArrayList<>();
        Map<String, Object> aRowMap;
        final int COMMON_KEY_INDEX = 10;
        for (int i = 0; i < 5; i++) {
            // 一个Map对应一行数据（如果需要导出多行数据，那么需要多个Map）
            aRowMap = new HashMap<>(16);
            for (int j = 0; j < COMMON_KEY_INDEX; j++) {
                String key = j + "";
                aRowMap.put(key, "坐标(" + i + "," + j + ")");
            }
            rowDataList.add(aRowMap);
            // 同一列对应的cell,在从Map里面取值时，会共用同一个key
            // 因此ExcelExportEntity的个数要保持和列数做多的行 的map.size()大小一致
            if (i == 0) {
                ExcelExportEntity excelExportEntity;
                for (int j = 0; j < COMMON_KEY_INDEX; j++) {
                    excelExportEntity = new ExcelExportEntity();
                    excelExportEntity.setKey(j + "");
                    // 设置cell宽
                    excelExportEntity.setWidth(15D);
                    // 设置cell是否自动换行
                    excelExportEntity.setWrap(true);
                    keyList.add(excelExportEntity);
                }
            }
        }
        // excel总体设置
        ExportParams exportParams = new ExportParams();
        // 不需要标题
        exportParams.setCreateHeadRows(false);
        // 指定sheet名字
        exportParams.setSheetName("直接导出数据测试");
        // 生成workbook 并导出
        Workbook workbook = ExcelExportUtil.exportExcel(exportParams, keyList, rowDataList);
        File savefile = new File("E:\\temp\\easypoi");
        if (!savefile.exists()) {
            boolean result = savefile.mkdirs();
            System.out.println("目录不存在，创建" + result);
        }
        FileOutputStream fos = new FileOutputStream("E:\\temp\\easypoi\\坐标.xls");
        workbook.write(fos);
        fos.close();
    }

}
