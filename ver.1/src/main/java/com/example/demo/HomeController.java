package com.example.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.beans.factory.annotation.Autowired;

@Controller
@RequestMapping("/home")
public class HomeController {
	@Autowired//検索(グループじゃない)
	HomeSelectDbMapper selectMapper;
	
	@Autowired//検索(グループ化)
	HomeSelectGroupDbMapper selectGroupMapper;
	
	//指定されたString文字列が整数であるかを判定する
	private boolean IsInt(String str) {
		for(int i=0;i<str.length();i++) {
			if(!Character.isDigit(str.charAt(i))) 
				return false;
		}
		return str.isEmpty();
	}
	
	private String getString(String num) {
		if(IsInt(num)) return "";
		Integer outNum = Integer.parseInt(num);
		return outNum.toString();
	}	
	@GetMapping()
	public String displaySearch(Model model) {
	    return "/home";
	}
	@GetMapping("/result")
	public String Debag_displaySearch(Model model) {
	    return "/select/tax";
	}
	//登録（URLはリダイレクトする）
	@PostMapping("insert")
	public String insert(@ModelAttribute @Valid InsertSelectForm form, BindingResult bindingResult)
	{
		switch(form.getInsertSelect()) {
		case "expensesItem":
			return "/insert/expensesItem";
		case "expenses":
			return "/insert/expenses";
		case "company":
			return "/insert/company";
		case "Sales":
			return "/insert/Sales";
		case "paid":
			return "/insert/paid";
		default://無効
			return "/home";	
		}
	}
	
	//検索（URLはリダイレクトする）
	@GetMapping("select")
	public String select(@ModelAttribute("SelectForm") SelectForm form,Model model) 
	{
		/*各検索条件のチェック・調整*/
		//空文字にする
		if(IsInt(form.getItem()))
			form.setItem(getString(form.getItem()));
		else
			form.setItemSelect("");
		
		if(IsInt(form.getMoon()))
			form.setMoon(getString(form.getMoon()));
		else
			form.setMoon("");
		
		if(IsInt(form.getListStart()))
			form.setListStart(getString(form.getListStart()));
		else
			form.setListStart("");
		
		if(IsInt(form.getListFinish()))
			form.setListFinish(getString(form.getListFinish()));
		else
			form.setListFinish("");
		//月別について、調整
		Calendar calendar = Calendar.getInstance();//現在の年の取得
		Integer year = calendar.get(Calendar.YEAR);
		String moon = form.getMoon().replace("/", "-");	
		if(!moon.matches("^[1][0-2]|[1-9]$"))//月しか指定されてない
			moon="";
		form.setMoon(moon);
		/*データベースで取得・それを反映*/
		if(form.getGroupSelect().isEmpty()) {//削除等が可能（グループ化されてない）
			switch(form.getSelectSelect()) {
			case "expensesItem":				
				List<ExpensesItemForm> data1 = selectMapper.expensesItem(form);
				model.addAttribute("ResultForm",data1);
				return "/select/expensesItem";
			case "expenses":
				List<ExpensesForm> data2 = selectMapper.expenses(form);
				model.addAttribute("ResultForm",data2);
				return "/select/expenses";
			case "company":
				List<CompanyForm> data3 = selectMapper.company(form);
				model.addAttribute("ResultForm",data3);
				return "/select/company";
			case "Sales":
				List<PaidForm> data4 = selectMapper.Sales(form);
				model.addAttribute("ResultForm",data4);
				return "/select/Sales";
			case "paid":
				List<PaidForm> data5 = selectMapper.paid(form);
				model.addAttribute("ResultForm",data5);
				return "/select/paid";
			case "unpaid":
				List<PaidForm> data6 = selectMapper.unpaid(form);
				model.addAttribute("ResultForm",data6);
				return "/select/unpaid";
			case "tax":
				List<PaidForm> data7 = selectMapper.tax(form);
				model.addAttribute("ResultForm",data7);
				return "/select/tax";
			default:
				return"redirect:/home";
			}
		}else {//削除等が不可能（グループ化されてる）
			List<List<ResultForm>> result = new ArrayList<>();
			List<ResultForm> bufferList;
			List<ResultFormA> resultA;
			ResultFormA buffer;
			switch(form.getSelectSelect()) {
			case "expenses":
				//データ取得
				resultA = selectGroupMapper.expenses(form);
				//カラム名の作成
				bufferList = new ArrayList<>((Arrays.asList(new ResultForm("年"),new ResultForm("月"),new ResultForm("項目"),new ResultForm("合計金額"))));
				break;
			case "Sales":
				//データ取得
				resultA = selectGroupMapper.Sales(form);
				//カラム名の作成
				bufferList = new ArrayList<>((Arrays.asList(new ResultForm("年"),new ResultForm("月"),new ResultForm("社名"),new ResultForm("合計金額"))));
				break;
			case "paid":
				//データ取得
				resultA = selectGroupMapper.paid(form);
				//カラム名の作成
				bufferList = new ArrayList<>((Arrays.asList(new ResultForm("年"),new ResultForm("月"),new ResultForm("社名"),new ResultForm("合計金額"))));
				break;
			case "unpaid":
				//データ取得
				resultA = selectGroupMapper.unpaid(form);
				//カラム名の作成
				bufferList = new ArrayList<>((Arrays.asList(new ResultForm("年"),new ResultForm("月"),new ResultForm("社名"),new ResultForm("合計金額"))));
				break;
			case "tax":
				//データ取得
				resultA = selectGroupMapper.tax(form);
				//カラム名の作成
				bufferList = new ArrayList<>((Arrays.asList(new ResultForm("年"),new ResultForm("月"),new ResultForm("社名"),new ResultForm("合計金額"))));
				break;
			default:
				return"redirect:/home";
			}
			//カラム名のセット
			model.addAttribute("ResultColumn",bufferList);
			//結果のセット
			for(int i=0;i<resultA.size();i++) {
				buffer= resultA.get(i);
				bufferList = new ArrayList<>((Arrays.asList(new ResultForm(buffer.getData1()),new ResultForm(buffer.getData2()),new ResultForm(buffer.getData3()),new ResultForm(buffer.getData4()))));
				result.add(bufferList);
			}
			int size=result.get(0).size();
			model.addAttribute("ResultForm",result);
			return "/select/resault";
		}
	}
}
