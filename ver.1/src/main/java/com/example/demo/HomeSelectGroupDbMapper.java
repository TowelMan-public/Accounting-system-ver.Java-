package com.example.demo;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface HomeSelectGroupDbMapper {
	List<ResultFormA> expenses(SelectForm form);
	List<ResultFormA> Sales(SelectForm form);
	List<ResultFormA> paid(SelectForm form);
	List<ResultFormA> unpaid(SelectForm form);
	List<ResultFormA> tax(SelectForm form);
}
