package culong.com.Construction.service;

import culong.com.Construction.dto.ConstrucHistoryDto;

public interface ConstrucHistoryService {
	ConstrucHistoryDto createConstrucHistory(ConstrucHistoryDto construcHistoryDto);

	boolean deleteConstrucHistory(long id);

	ConstrucHistoryDto updateConstrucHistory(ConstrucHistoryDto construcHistoryDto);
}
