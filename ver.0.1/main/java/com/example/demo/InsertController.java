package com.example.demo;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/insert")
public class InsertController {
	@Autowired//検索(グループじゃない)
	InsertDbMapper insertMapper;
	
	//指定されたString文字列が整数であるかを判定する
	private boolean IsInt(String str) {
		for(int i=0;i<str.length();i++) {
			if(!Character.isDigit(str.charAt(i))&&str.charAt(i)!='.') 
				return true;
		}
		return str.isEmpty();
	}
	
	@PostMapping("expensesItem/do")
	public String expensesItem(@ModelAttribute @Valid InsertExpensesItemForm form, BindingResult bindingResult) {
		//入力が不適切
		if( form.getItem().isEmpty()||IsInt(form.getRate()))
			return "/insert/expensesItem";
		insertMapper.expensesItem(form);
		return "/insert/expensesItem";
	}
	
	@PostMapping("expenses/do")
	public String expenses(@ModelAttribute @Valid InsertExpensesForm form, BindingResult bindingResult) {
		//入力が不適切
		if( IsInt(form.getMoney())||IsInt(form.getExpenses())|| !form.getDate().matches("^[0-9]{4}-[0-9]{1,2}-[0-9]{1,2}$"))
			return "/insert/expenses";
		insertMapper.expenses(form);
		return "/insert/expenses";
	}
	
	@PostMapping("Sales/do")
	public String Sales(@ModelAttribute @Valid InsertSalesForm form, BindingResult bindingResult) {
		//入力が不適切
		if( IsInt(form.getCompany())||IsInt(form.getMoney())|| !form.getDate().matches("^[0-9]{4}-[0-9]{1,2}-[0-9]{1,2}$"))
			return "/insert/Sales";
		insertMapper.Sales(form);
		return "/insert/Sales";
	}
	
	@PostMapping("paid/do")
	public String paid(@ModelAttribute @Valid InsertPaidForm form, BindingResult bindingResult) {
		//入力が不適切
		if( IsInt(form.getNumber())||IsInt(form.getMoney()))
			return "/insert/paid";
		insertMapper.paid(form);
		return "/insert/paid";
	}
	
	@PostMapping("company/do")
	public String company(@ModelAttribute @Valid InsertCompanyForm form, BindingResult bindingResult) {
		//入力が不適切
		if( form.getName().isEmpty())
			return "/insert/company";
		insertMapper.company(form);
		return "/insert/company";
	}
}
