package com.dun.entity.query;

import lombok.Data;

/**
 * 通用分页查询基类
 */
@Data
public abstract class PagingQuery {

    private int pageNum = 1; // 页索引。默认值为1
    private int pageSize = 10; // 每页记录数。默认值为10，传0查询全部结果
}
