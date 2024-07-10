package com.dun.entity.query;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * 通用根据ID读操作Query
 */
@Data
public final class GenericReadByIdQuery {

    private String id; // ID
}
