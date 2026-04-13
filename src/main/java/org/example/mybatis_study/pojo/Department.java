package org.example.mybatis_study.pojo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Department {

    private Long id;

    private String name;
    private String code;

    private Long parentId;

    private String leader;
    private String phone;

    private Integer sort;

    private Integer status;
    private Integer isDeleted;

    private LocalDateTime createTime;
    private LocalDateTime updateTime;

    private String remark;
}