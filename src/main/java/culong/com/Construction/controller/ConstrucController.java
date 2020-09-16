package culong.com.Construction.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import culong.com.Construction.dto.ConstructDto;
import culong.com.Construction.service.ConstrucService;

@RestController
public class ConstrucController {
	
	@Autowired
	ConstrucService construcService;
	
	@RequestMapping(value = "/construct", method =RequestMethod.POST) 
	@ResponseBody
	public ConstructDto createConstruct(@RequestBody ConstructDto constructDto) {
		return construcService.createConstruct(constructDto);
		
	}
	@RequestMapping(value = "/construct/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	public boolean deleteConstruct(@PathVariable(value = "id") long id) {

		return construcService.deleteConstruct(id);

	}
	
	@RequestMapping( value = "/construct" , method = RequestMethod.PUT)
	@ResponseBody
	public ConstructDto updateConstructDto(@RequestBody ConstructDto constructDto ) throws Exception {
		
		return construcService.updateConstruct(constructDto);
	}

}
