package com.dun.entity.command;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * 通用根据ID列表批量写操作Command，如果有其他属性请新建自定义Command
 */
@Data
public final class GenericBatchWriteByIdsCommand {

    @NotNull
    private String[] ids; // ID列表。以英文逗号分隔
}
