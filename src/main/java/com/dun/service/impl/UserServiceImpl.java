package com.dun.service.impl;

import com.dun.entity.User;
import com.dun.entity.query.GetUserListQuery;
import com.dun.mapper.UserMapper;
import com.dun.service.UserService;
import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public void save(User user) {
        User existUser = userMapper.selectById(user.getId());
        if (existUser == null){
            userMapper.insert(user);
        }else {
            userMapper.updateById(user);
        }
    }

    @Override
    public boolean isExistName(String name, String id) {
        User user = userMapper.getByName(name);
        return user != null && !user.getId().equals(id);
    }

    @Override
    public User getByName(String name) {
        return userMapper.getByName(name);
    }

    @Override
    public Page<User> getList(GetUserListQuery query) {
        return userMapper.getList(query);
    }

    @Override
    public void deleteById(String id) {
        userMapper.deleteById(id);
    }

    @Override
    public User getById(String id) {
        return userMapper.selectById(id);
    }

    @Override
    public void deleteBatchIds(List<String> id) {
        userMapper.deleteBatchIds(id);
    }

    @Override
    public User getByUsername(String username) {
        return userMapper.getByUsername(username);
    }

    @Override
    public boolean isExistUsername(String username, String id) {
        User user = userMapper.getByUsername(username);
        return user != null && !user.getId().equals(id);
    }
}
