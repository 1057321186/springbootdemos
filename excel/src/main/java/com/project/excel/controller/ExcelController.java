package com.project.excel.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@Slf4j
public class ExcelController {


    @PostMapping("/import")
    public void importExcel(MultipartFile file){






    }


    @GetMapping("/export")
    public void exportExcel(){




    }


}
