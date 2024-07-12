package com.dun.entity.query;

import lombok.Data;

@Data
public class GetUserListQuery extends PagingQuery{

    private String name; // 姓名
    private String address; // 籍贯
    private String email; // 邮箱
}
