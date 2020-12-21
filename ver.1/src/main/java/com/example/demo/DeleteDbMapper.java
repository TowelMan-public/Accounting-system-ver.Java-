package com.example.demo;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface DeleteDbMapper {
	void Sales(int id);
	void paid(int id);
	void expensesItem(int id);
	void tax(int id);
	void unpaid(int id);
	void company(int id);
	void expenses(int id);
}
