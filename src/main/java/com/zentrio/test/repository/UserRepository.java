package com.zentrio.test.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserRepository {
    @Select("""
        SELECT name FROM user
        WHERE name = 'Tan Dara'
    """)
    public String getUserName();
}
