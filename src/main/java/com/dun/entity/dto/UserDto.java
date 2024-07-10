package com.dun.entity.dto;

import com.dun.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserDto extends User {

    private String confirmPassword; // 确认密码
}
