package com.example.demo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface UpdateDbMapper {
	void expensesItem(ExpensesItemForm form);
	void expenses(ExpensesForm form);
	void company(CompanyForm form);
	void Sales(PaidForm form);
	void paid(PaidForm form);
}
