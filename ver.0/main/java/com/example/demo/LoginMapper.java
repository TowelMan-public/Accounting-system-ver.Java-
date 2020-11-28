package com.example.demo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface LoginMapper {
	LoginForm selectById(LoginForm form);
}
