package com.dun.entity.command;

import lombok.Data;

import java.util.Date;

@Data
public class SaveUserCommand {

    private String id; // ID
    private String name; // 姓名
    private String username; // 用户名
    private String password; // 密码
    private String confirmPassword; // 确认密码
    private String gender; // 性别。1：男；2：女
    private Integer age; // 年龄
    private String address; // 住址
    private String qq; // QQ
    private String email; // 邮箱
}
