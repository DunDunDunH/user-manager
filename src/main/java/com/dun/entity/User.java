package com.dun.entity;

import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.dun.service.UserService;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;
import java.util.regex.Pattern;

@NoArgsConstructor
@Data
public class User {

    private String id; // ID
    private String name; // 姓名
    private String username; // 用户名
    private String password; // 密码
    private String gender; // 性别。1：男；2：女
    private Integer age; // 年龄
    private String address; // 住址
    private String qq; // QQ
    private String email; // 邮箱
    @TableLogic(value = "0", delval = "1")
    private boolean isDeleted; // 是否删除。0：否；1：是

    public User(String name,String username, String password, String gender, Integer age, String address, String qq, String email) {
        this.id = UUID.randomUUID().toString().replace("-", "");
        this.name = name;
        this.username = username;
        this.password = password;
        this.gender = gender;
        this.age = age;
        this.address = address;
        this.qq = qq;
        this.email = email;
        this.isDeleted = false;
    }

    public void update(String username, String password, String gender, Integer age, String address, String qq, String email){
        this.username = username;
        this.password = password;
        this.gender = gender;
        this.age = age;
        this.address = address;
        this.qq = qq;
        this.email = email;
    }

    public String check(String confirmPassword,UserService userService){
        String msg = null;
        // 密码正则表达式，为数字或字母，长度大于等于8小于等于16
        String pwdPattern = "^[0-9A-Za-z]{8,16}$";
        if (StringUtils.isBlank(this.name)) {
            msg=  "姓名不能为空";
        }else if (StringUtils.isBlank(this.username)) {
            msg=  "用户名不能为空";
        } else if (StringUtils.isBlank(this.password)) {
            msg=  "密码不能为空";
        } else if (!this.password.equals(confirmPassword)) {
            msg=  "两次输入密码不一致";
        }  else if (this.age!=null && this.age < 0) {
            msg=  "年龄不能为负数";
        } else if (!Pattern.matches(pwdPattern, this.password)) {
            msg=  "密码为数字或字母，且长度大于等于8小于等于16";
        } else if (userService.isExistName(this.name, this.id)) {
            msg=  "姓名已存在";
        } else if (userService.isExistUsername(this.username, this.id)) {
            msg=  "用户名已存在";
        }
        return msg;
    }

    public void deleted() {
        this.isDeleted = true;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name=" + name +
                ", username=" + username +
                ", password=" + password +
                ", gender=" + gender +
                ", age=" + age +
                ", address=" + address +
                ", qq=" + qq +
                ", email=" + email +
                ", isDeleted=" + isDeleted +
                '}';
    }
}
