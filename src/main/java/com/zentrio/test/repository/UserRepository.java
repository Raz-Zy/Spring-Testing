package com.zentrio.test.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserRepository {
    @Select("""
        SELECT name from "user"
        where name='Tan Dara'
    """)
    public String getUserName();
}
