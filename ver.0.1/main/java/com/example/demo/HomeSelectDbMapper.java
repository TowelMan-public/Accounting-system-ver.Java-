package com.example.demo;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface HomeSelectDbMapper {
	List<ExpensesItemForm> expensesItem(SelectForm form);
	List<ExpensesForm> expenses(SelectForm form);
	List<CompanyForm> company(SelectForm form);
	List<PaidForm> Sales(SelectForm form);
	List<PaidForm> paid(SelectForm form);
	List<PaidForm> unpaid(SelectForm form);
	List<PaidForm> tax(SelectForm form);
}
