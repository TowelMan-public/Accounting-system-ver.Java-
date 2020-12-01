package com.example.demo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface InsertDbMapper {
	void expensesItem(InsertExpensesItemForm form);
	void expenses(InsertExpensesForm form);
	void Sales(InsertSalesForm form);
	void paid(InsertPaidForm form);
	void company(InsertCompanyForm form);
}