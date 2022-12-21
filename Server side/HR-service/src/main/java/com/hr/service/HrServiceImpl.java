package com.hr.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hr.entity.HR;

@Service
public class HrServiceImpl implements IhrService {

	//fake hr list
	List<HR> list=List.of(
			new HR(1001L,"Vivek","8210678720"),
			new HR(1002L,"Keshav","8210678720"),
			new HR(1003L,"Rishav","8210678720"),
			new HR(1004L,"Kumar","8210678720"),
			new HR(1005L,"Sayantan","8210678720"),
			new HR(1006L,"Dhruv","8210678720"));
	
	@Override
	public HR getHR(Long id) {
		
		return list.stream().filter(hr->hr.getUserID().equals(id)).findAny().orElse(null);
	}
	

}
