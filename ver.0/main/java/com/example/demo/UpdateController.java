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
			if(!Character.isDigit(str.charAt(i))) 
				return !false;
		}
		return !true;
	}
	
	@PostMapping("expensesItem/update")
	public String expensesItem(@ModelAttribute @Valid ExpensesItemForm form, BindingResult bindingResult) {
		//入力が不適切
		if( IsInt(form.getNumber())||form.getName().isEmpty()||IsInt(form.getRate())||form.getEffectiveness().isEmpty()||IsInt(form.getEffectiveness()))
			return "redirect:/select/expensesItem";
		UpdateMapper.expensesItem(form);
		return "redirect:/select/expensesItem";
	}
	
	@PostMapping("expenses/update")
	public String expenses(@ModelAttribute @Valid ExpensesForm form, BindingResult bindingResult) {
		//入力が不適切
		if( IsInt(form.getNumber())||IsInt(form.getDate())||IsInt(form.getExpenses())|| !form.getDate().matches("[0-9]{4}-[1][0-2]|[0-9]{4}-[0][1-9]|[0-9]{4}-[1-9]"))
			return "redirect:/select/expenses";
		UpdateMapper.expenses(form);
		return "redirect:/select/expenses";
	}
	
	@PostMapping("Sales/update")
	public String Sales(@ModelAttribute @Valid PaidForm form, BindingResult bindingResult) {
		//入力が不適切
		if( IsInt(form.getNumber())||IsInt(form.getCompany())||IsInt(form.getMoney())|| !form.getDate().matches("[0-9]{4}-[1][0-2]|[0-9]{4}-[0][1-9]|[0-9]{4}-[1-9]"))
			return "redirect:/select/Sales";
		UpdateMapper.Sales(form);
		return "redirect:/select/Sales";
	}
	
	@PostMapping("paid/update")
	public String paid(@ModelAttribute @Valid PaidForm form, BindingResult bindingResult) {
		//入力が不適切
		if( IsInt(form.getNumber())||IsInt(form.getNumber())||IsInt(form.getMoney()))
			return "redirect:/select/paid";
		UpdateMapper.paid(form);
		return "redirect:/select/paid";
	}
	
	@PostMapping("company/update")
	public String company(@ModelAttribute @Valid CompanyForm form, BindingResult bindingResult) {
		//入力が不適切
		if( IsInt(form.getNumber())||form.getName().isEmpty()||form.getEffectiveness().isEmpty()||IsInt(form.getEffectiveness()))
			return "redirect:/select/company";
		UpdateMapper.company(form);
		return "redirect:/select/company";
	}
}
