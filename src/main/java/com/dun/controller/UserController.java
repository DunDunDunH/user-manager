package com.dun.controller;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.dun.entity.User;
import com.dun.entity.command.DeleteUserBatchIdsCommand;
import com.dun.entity.command.GenericWriteByIdCommand;
import com.dun.entity.command.LoginCommand;
import com.dun.entity.command.SaveUserCommand;
import com.dun.entity.query.GetUserListQuery;
import com.dun.service.UserService;
import com.github.pagehelper.Page;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.regex.Pattern;

@AllArgsConstructor
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 登录
     */
    @GetMapping("loginPage")
    public String loginPage() {
        return "login";
    }

    /**
     * 登录
     */
    @PostMapping("login")
    public String login(LoginCommand command, HttpSession session, HttpServletRequest request) {
        // 校验
        if (StringUtils.isBlank(command.getUsername())) {
            request.setAttribute("msg", "用户名不能为空");
        } else if (StringUtils.isBlank(command.getPassword())) {
            request.setAttribute("msg", "密码不能为空");
        } else {
            // 根据名称获取用户数据
            User user = userService.getByUsername(command.getUsername());

            if (user == null || !user.getPassword().equals(command.getPassword())) {
                request.setAttribute("msg", "用户名或密码错误");
            } else {
                // 用户列表
                GetUserListQuery query = new GetUserListQuery();
                Page<User> cars = userService.getList(query);
                request.setAttribute("userList", cars.getResult());
                request.setAttribute("pages", cars.getPages());
                request.setAttribute("pageNum", cars.getPageNum());
                request.setAttribute("pageSize", cars.getPageSize());
                request.setAttribute("total", cars.getTotal());
                request.setAttribute("query", query);
                // 保存session
                session.setAttribute("name", user.getName());
                return "index";
            }
        }

        request.setAttribute("user", command);
        return "login";
    }

    /**
     * 注册
     */
    @GetMapping("registerPage")
    public String registerPage() {
        return "register";
    }

//    /**
//     * 注册
//     *
//     * @param command
//     */
//    @PostMapping("register")
//    public String register(SaveUserCommand command, HttpServletRequest request) {
//        request.setAttribute("user", command);
//        // 校验
//        // 密码正则表达式，为数字或字母，长度大于等于8小于等于16
//        String pwdPattern = "^[0-9A-Za-z]{8,16}$";
//        if (StringUtils.isBlank(command.getName())) {
//            request.setAttribute("msg", "姓名不能为空");
//        } else if (StringUtils.isBlank(command.getUsername())) {
//            request.setAttribute("msg", "用户名不能为空");
//        } else if (StringUtils.isBlank(command.getPassword())) {
//            request.setAttribute("msg", "密码不能为空");
//        } else if (StringUtils.isBlank(command.getConfirmPassword())) {
//            request.setAttribute("msg", "确认密码不能为空");
//        } else if (!command.getPassword().equals(command.getConfirmPassword())) {
//            request.setAttribute("msg", "两次输入密码不一致");
//        } else if (command.getAge() < 0) {
//            request.setAttribute("msg", "年龄不能为负数");
//        } else if (!Pattern.matches(pwdPattern, command.getPassword())) {
//            request.setAttribute("msg", "密码为数字或字母，且长度大于等于8小于等于16");
//        } else if (userService.isExistName(command.getName(), command.getId())) {
//            request.setAttribute("msg", "姓名已存在");
//        } else if (userService.isExistUsername(command.getUsername(), command.getId())) {
//            request.setAttribute("msg", "用户名已存在");
//        } else {
//            // 保存
//            User user = new User(command.getName(), command.getUsername(), command.getPassword(), command.getGender(), command.getAge(), command.getAddress(), command.getQq(), command.getEmail());
//            userService.save(user);
//            request.setAttribute("msg", "注册成功");
//            return "login";
//        }
//        return "register";
//    }

    /**
     * 注销
     */
    @GetMapping("logout")
    public String logout(HttpSession session) {
        session.removeAttribute("name");
        return "login";
    }

    @GetMapping("indexPage")
    public String indexPage() {
        return "index";
    }

    @GetMapping("addPage")
    public String addPage() {
        return "add";
    }

    @GetMapping("updatePage")
    public String updatePage() {
        return "update";
    }

    @GetMapping("getList")
    public String getUserList(GetUserListQuery query, HttpServletRequest request) {
        // 用户列表
        Page<User> cars = userService.getList(query);
        request.setAttribute("userList", cars.getResult());
        request.setAttribute("pages", cars.getPages());
        request.setAttribute("pageNum", cars.getPageNum());
        request.setAttribute("pageSize", cars.getPageSize());
        request.setAttribute("total", cars.getTotal());
        request.setAttribute("query", query);
        return "index";
    }

    @PostMapping("save")
    public String saveUser(SaveUserCommand command, HttpServletRequest request) {
        request.setAttribute("user", command);
        // 判断登录状态
        boolean isLogin;
        String currentName = (String) request.getAttribute("name");
        if (StringUtils.isBlank(currentName)) {
            isLogin = false;
        } else {
            isLogin = true;
        }

        // 保存用户
        User user;
        if (StringUtils.isBlank(command.getId())) {
            // 新增
            user = new User(command.getName(), command.getUsername(), command.getPassword(), command.getGender(), command.getAge(), command.getAddress(), command.getQq(), command.getEmail());
        } else {
            // 修改
            user = userService.getById(command.getId());
            user.update(user.getUsername(), user.getPassword(), user.getGender(), user.getAge(), user.getAddress(), user.getQq(), user.getEmail());
        }
        // 校验
        String msg = user.check(command.getConfirmPassword(), userService);
        if (StringUtils.isBlank(msg)) {
            userService.save(user);
            if (isLogin){
                return "index";
            }else {
                return "login";
            }
        }else {
            if (isLogin){
                return "register";
            }else {
                if (StringUtils.isBlank(command.getId())){
                    return "add";
                }else {
                    return "update";
                }
            }
        }
    }

    @GetMapping("deleteById")
    public String deleteUserById(GenericWriteByIdCommand command) {
        userService.deleteById(command.getId());
        return "index";
    }

    @GetMapping("deleteBatchIds")
    public String deleteUserBatchIds(DeleteUserBatchIdsCommand command) {
        userService.deleteBatchIds(command.getIds());
        return "index";
    }
}
