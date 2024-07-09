package com.dun.entity.query;

import lombok.Data;

@Data
public class GetUserListQuery {

    private String name; // 姓名
    private String username; // 用户名
    private String email; // 邮箱
}
