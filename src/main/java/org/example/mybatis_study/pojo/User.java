package org.example.mybatis_study.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private Long id;

    private String username;
    private String password;

    private String nickname;
    private String realName;

    private Integer gender;
    private Integer age;
    private LocalDate birthday;

    private String phone;
    private String email;

    private String avatar;

    private Long deptId;

    private String position;
    private BigDecimal salary;

    private Integer status;
    private Integer isDeleted;

    private LocalDate hireDate;

    private LocalDateTime createTime;
    private LocalDateTime updateTime;

    private LocalDateTime lastLoginTime;
    private String lastLoginIp;

    private String remark;
}