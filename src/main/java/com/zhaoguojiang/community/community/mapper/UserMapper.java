package com.zhaoguojiang.community.community.mapper;

import com.zhaoguojiang.community.community.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;


/**
 * @Author: xj0927
 * @Description:
 * @Date Created in 2020-11-23 21:29
 * @Modified By:
 */
@Mapper
public interface UserMapper {
    @Insert("insert into user (name,account_id,token,gmt_create,gmt_modified) values(#{name},#{accountId},#{token},#{gmtCreate},#{gmtModified})")
    void insert(User user);

}
