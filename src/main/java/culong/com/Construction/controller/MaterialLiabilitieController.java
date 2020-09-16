package culong.com.Construction.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import culong.com.Construction.dto.MaterialLiabilitieDto;
import culong.com.Construction.service.MaterialLiabilitieService;

@RestController
public class MaterialLiabilitieController {
	@Autowired
	MaterialLiabilitieService materialLiabilitieService;
	
	@RequestMapping( value = "/materialLiabilitieService" , method = RequestMethod.POST)
	@ResponseBody
	public MaterialLiabilitieDto createMaterialLiabilitie(@RequestBody MaterialLiabilitieDto materialLiabilitieDto ) throws Exception {
		
		return materialLiabilitieService.createMaterialLiabilitie(materialLiabilitieDto);
	}
	
	@RequestMapping( value = "/materialLiabilitieService" , method = RequestMethod.PUT)
	@ResponseBody
	public MaterialLiabilitieDto updateMaterialLiabilitie(@RequestBody MaterialLiabilitieDto materialLiabilitieDto ) throws Exception {
		
		return materialLiabilitieService.updateMaterialLiabilitieDto(materialLiabilitieDto);
	}
	
	@RequestMapping(value = "/materialLiabilitieService/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	public boolean deletematerialLiabilitieService(@PathVariable(value = "id") long id) {

		return materialLiabilitieService.deleteMaterialLiabilitieDto(id);

	}

}
