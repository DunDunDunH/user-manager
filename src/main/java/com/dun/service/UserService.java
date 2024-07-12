package com.dun.service;

import com.dun.entity.User;
import com.dun.entity.query.GetUserListQuery;
import com.github.pagehelper.Page;

import java.util.List;

public interface UserService {
    void save(User user);

    boolean isExistName(String name, int id);

    User getByName(String name);

    Page<User> getList(GetUserListQuery query);

    void deleteById(String id);

    User getById(String id);

    void deleteBatchIds(List<String> ids);

    User getByUsername(String username);

    boolean isExistUsername(String username, int id);

    void deleteBatchByIds(String[] ids);
}
