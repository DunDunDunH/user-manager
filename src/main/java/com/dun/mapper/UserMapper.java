package com.dun.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dun.entity.User;
import com.dun.entity.query.GetUserListQuery;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface UserMapper extends BaseMapper<User> {
    User getByName(String name);

    Page<User> getList(GetUserListQuery query);

    User getByUsername(String username);

    void deleteBatchByIds(String[] ids);
}
