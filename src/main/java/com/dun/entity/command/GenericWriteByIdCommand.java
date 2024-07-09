package com.dun.entity.command;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * 通用根据ID写操作Command
 */
@Data
public class GenericWriteByIdCommand {

    private String id; // ID
}
