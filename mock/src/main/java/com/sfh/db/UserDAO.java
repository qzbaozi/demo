package com.sfh.db;

import com.sfh.entity.UserDO;

public interface UserDAO {

     Long getIdByName(String anyString) ;

     boolean create(UserDO capture) ;

    boolean modify(UserDO modify);
}

