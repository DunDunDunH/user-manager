package com.dun.entity.command;

import lombok.Data;

import java.util.List;

@Data
public class DeleteUserBatchIdsCommand {
    private List<String> ids; // ID列表
}
