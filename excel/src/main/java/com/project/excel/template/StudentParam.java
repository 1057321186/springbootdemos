package com.project.excel.template;


import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;

import javax.validation.constraints.*;
import java.io.Serializable;

@Data
public class StudentParam implements Serializable {

    @Excel(name = "姓名",orderNum = "0",width = 25)
//    @Size(max = 5,message = "姓名太长")
    private String name;

    @Excel(name = "年纪",orderNum = "1",width = 25)
    @NotNull(message = "年龄不能为空")
    private Integer age;

    @Excel(name = "班级",orderNum = "2",width = 25)
    @NotBlank(message = "班级不能为空")
    private String classId;

    @Excel(name = "性别",orderNum = "3",width = 25)
    @Pattern(regexp = "[\u4E00-\u9FA5]*", message = "不是中文")
    private String sex;


}
