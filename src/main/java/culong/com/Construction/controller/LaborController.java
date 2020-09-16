package culong.com.Construction.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import culong.com.Construction.dto.LaborDto;
import culong.com.Construction.service.LaborService;

@RestController
public class LaborController {
	@Autowired
	LaborService laborService;

	@RequestMapping( value = "/labor" , method = RequestMethod.POST)
	@ResponseBody
	public LaborDto createLabor(@RequestBody LaborDto laborDto ) throws Exception {
		
		return laborService.createLabor(laborDto);
	}
	
}
