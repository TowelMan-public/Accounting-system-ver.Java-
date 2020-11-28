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
	
	@PostMapping("Sales/delete")
	public String Sales(@ModelAttribute @Valid PaidForm form, BindingResult bindingResult) {
		//入力が不適切
		if(IsInt(form.getNumber()))
			return "redirect:/select/Sales";
		DeleteDbMapper.Sales(Integer.valueOf(form.getNumber()).intValue());
		return "redirect:/select/Sales";
	}
	
	@PostMapping("paid/delete")
	public String paid(@ModelAttribute @Valid PaidForm form, BindingResult bindingResult) {
		//入力が不適切
		if(IsInt(form.getNumber()))
			return "redirect:/select/paid";
		DeleteDbMapper.paid(Integer.valueOf(form.getNumber()).intValue());
		return "redirect:/select/paid";
	}
	
	@PostMapping("expensesItem/delete")
	public String expensesItem(@ModelAttribute @Valid ExpensesItemForm form, BindingResult bindingResult) {
		//入力が不適切
		if(IsInt(form.getNumber()))
			return "redirect:/select/expensesItem";
		DeleteDbMapper.expensesItem(Integer.valueOf(form.getNumber()).intValue());
		return "redirect:/select/expensesItem";
	}
	
	@PostMapping("tax/delete")
	public String tax(@ModelAttribute @Valid PaidForm form, BindingResult bindingResult) {
		//入力が不適切
		if(IsInt(form.getNumber()))
			return "redirect:/select/tax";
		DeleteDbMapper.tax(Integer.valueOf(form.getNumber()).intValue());
		return "redirect:/select/tax";
	}
	
	@PostMapping("unpaid/delete")
	public String unpaid(@ModelAttribute @Valid PaidForm form, BindingResult bindingResult) {
		//入力が不適切
		if(IsInt(form.getNumber()))
			return "redirect:/select/unpaid";
		DeleteDbMapper.unpaid(Integer.valueOf(form.getNumber()).intValue());
		return "redirect:/select/unpaid";
	}
	
	@PostMapping("company/delete")
	public String company(@ModelAttribute @Valid CompanyForm form, BindingResult bindingResult) {
		//入力が不適切
		if(IsInt(form.getNumber()))
			return "redirect:/select/company";
		DeleteDbMapper.company(Integer.valueOf(form.getNumber()).intValue());
		return "redirect:/select/company";
	}
	
	@PostMapping("expenses/delete")
	public String expenses(@ModelAttribute @Valid ExpensesForm form, BindingResult bindingResult) {
		//入力が不適切
		if(IsInt(form.getNumber()))
			return "redirect:/select/expenses";
		DeleteDbMapper.expenses(Integer.valueOf(form.getNumber()).intValue());
		return "redirect:/select/expenses";
	}
}
