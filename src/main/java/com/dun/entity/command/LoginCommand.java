package com.dun.entity.command;

import lombok.Data;

@Data
public class LoginCommand {

    private String username; // 名称
    private String password; // 密码
}