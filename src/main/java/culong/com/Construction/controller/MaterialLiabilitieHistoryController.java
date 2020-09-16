package culong.com.Construction.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import culong.com.Construction.dto.MaterialLiabilitieHistoryDto;
import culong.com.Construction.service.MaterialLiabilitieHistoryService;

@RestController
public class MaterialLiabilitieHistoryController {
	@Autowired
	MaterialLiabilitieHistoryService materialLiabilitieHistoryService;

	@RequestMapping(value = "/materialLiabilitieHistory", method = RequestMethod.POST)
	@ResponseBody
	public MaterialLiabilitieHistoryDto MaterialLiabilitieHistory(
			@RequestBody MaterialLiabilitieHistoryDto materialLiabilitieHistoryDto) throws Exception {

		return materialLiabilitieHistoryService.createMaterialLiabilitieHistory(materialLiabilitieHistoryDto);

	}

}
