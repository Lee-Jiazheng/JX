package com.neusoft.mapper;

import com.neusoft.model.AdminUser;
import org.apache.ibatis.annotations.Insert;

/**
 * Created by Bruce Lee on 2017/7/18.
 */
public interface IAdminMapper {
    @Insert("insert into admin_user(admin_name, admin_password, phone_num) values(#{adminName}, #{adminPassword}, #{phoneNum})")
    int addAdminUser(AdminUser adminUser);
}
