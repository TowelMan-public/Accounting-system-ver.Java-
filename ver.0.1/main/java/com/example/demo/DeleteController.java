package com.example.demo;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home/select")
public class DeleteController {
	@Autowired//検索(グループじゃない)
	DeleteDbMapper DeleteDbMapper;
	
	//指定されたString文字列が整数であるかを判定する
	private boolean IsInt(String str) {
		for(int i=0;i<str.length();i++) {
			if(!Character.isDigit(str.charAt(i))) 
				return true;
		}
		return false;
	}
	
	@PostMapping("/delete/Sales")
	public String Sales(@ModelAttribute @Valid PaidForm form, BindingResult bindingResult) {
		//入力が不適切
		if(IsInt(form.getNumber()))
			return "/select/Sales";
		DeleteDbMapper.Sales(Integer.valueOf(form.getNumber()).intValue());
		return "/select/Sales";
	}
	
	@PostMapping("/delete/paid")
	public String paid(@ModelAttribute @Valid PaidForm form, BindingResult bindingResult) {
		//入力が不適切
		if(IsInt(form.getNumber()))
			return "/select/paid";
		DeleteDbMapper.paid(Integer.valueOf(form.getNumber()).intValue());
		return "/select/paid";
	}
	
	@PostMapping("/delete/expensesItem")
	public String expensesItem(@ModelAttribute @Valid ExpensesItemForm form, BindingResult bindingResult) {
		//入力が不適切
		if(IsInt(form.getNumber()))
			return "/select/expensesItem";
		DeleteDbMapper.expensesItem(Integer.valueOf(form.getNumber()).intValue());
		return "/select/expensesItem";
	}
	
	@PostMapping("/delete/tax")
	public String tax(@ModelAttribute @Valid PaidForm form, BindingResult bindingResult) {
		//入力が不適切
		if(IsInt(form.getNumber()))
			return "/select/tax";
		DeleteDbMapper.tax(Integer.valueOf(form.getNumber()).intValue());
		return "/select/tax";
	}
	
	@PostMapping("/delete/unpaid")
	public String unpaid(@ModelAttribute @Valid PaidForm form, BindingResult bindingResult) {
		//入力が不適切
		if(IsInt(form.getNumber()))
			return "/select/unpaid";
		DeleteDbMapper.unpaid(Integer.valueOf(form.getNumber()).intValue());
		return "/select/unpaid";
	}
	
	@PostMapping("/delete/company")
	public String company(@ModelAttribute @Valid CompanyForm form, BindingResult bindingResult) {
		//入力が不適切
		if(IsInt(form.getNumber()))
			return "/select/company";
		DeleteDbMapper.company(Integer.valueOf(form.getNumber()).intValue());
		return "/select/company";
	}
	
	@PostMapping("/delete/expenses")
	public String expenses(@ModelAttribute @Valid ExpensesForm form, BindingResult bindingResult) {
		//入力が不適切
		if(IsInt(form.getNumber()))
			return "/select/expenses";
		DeleteDbMapper.expenses(Integer.valueOf(form.getNumber()).intValue());
		return "/select/expenses";
	}
}
