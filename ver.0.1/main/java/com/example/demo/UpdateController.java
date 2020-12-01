package com.example.demo;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("home/select")
public class UpdateController {
	@Autowired//検索(グループじゃない)
	UpdateDbMapper UpdateMapper;
	
	//指定されたString文字列が整数であるかを判定する
	private boolean IsInt(String str) {
		for(int i=0;i<str.length();i++) {
			if(!Character.isDigit(str.charAt(i))&&str.charAt(i)!='.') 
				return true;
		}
		return str.isEmpty();
	}
	
	@PostMapping("/update/expensesItem")
	public String expensesItem(@ModelAttribute @Valid ExpensesItemForm form, BindingResult bindingResult) {
		//入力が不適切
		if( IsInt(form.getNumber())||form.getName().isEmpty()||IsInt(form.getRate())||form.getEffectiveness().isEmpty()||IsInt(form.getEffectiveness()))
			return "redirect:/select/expensesItem";
		UpdateMapper.expensesItem(form);
		return "/select/expensesItem";
	}
	
	@PostMapping("/update/expenses")
	public String expenses(@ModelAttribute @Valid ExpensesForm form, BindingResult bindingResult) {
		//入力が不適切
		if( IsInt(form.getNumber())||IsInt(form.getExpenses())|| !form.getDate().matches("^[0-9]{4}-[0-9]{1,2}-[0-9]{1,2}$"))
			return "redirect:/select/expenses";
		UpdateMapper.expenses(form);
		return "/select/expenses";
	}
	
	@PostMapping("/update/Sales")
	public String Sales(@ModelAttribute @Valid PaidForm form, BindingResult bindingResult) {
		//入力が不適切
		if( IsInt(form.getNumber())||IsInt(form.getCompany())||IsInt(form.getMoney())|| !form.getDate().matches("^[0-9]{4}-[0-9]{1,2}-[0-9]{1,2}$"))
			return "redirect:/select/Sales";
		UpdateMapper.Sales(form);
		return "/select/Sales";
	}
	
	@PostMapping("/update/paid")
	public String paid(@ModelAttribute @Valid PaidForm form, BindingResult bindingResult) {
		//入力が不適切
		if( IsInt(form.getNumber())||IsInt(form.getNumber())||IsInt(form.getMoney()))
			return "redirect:/select/paid";
		UpdateMapper.paid(form);
		return "/select/paid";
	}
	
	@PostMapping("/update/company")
	public String company(@ModelAttribute @Valid CompanyForm form, BindingResult bindingResult) {
		//入力が不適切
		if( IsInt(form.getNumber())||form.getName().isEmpty()||form.getEffectiveness().isEmpty()||IsInt(form.getEffectiveness()))
			return "redirect:/select/company";
		UpdateMapper.company(form);
		return "/select/company";
	}
}
