package com.TrollMarket.TrollMarket.Services;

import com.TrollMarket.TrollMarket.Dto.HistoryDto;
import com.TrollMarket.TrollMarket.Models.History;
import com.TrollMarket.TrollMarket.Repositories.HistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class HistoryService {

    private HistoryRepository historyRepository;

    @Autowired
    public HistoryService(HistoryRepository historyRepository) {
        this.historyRepository = historyRepository;
    }

    public List<HistoryDto> findAllHistory() {

        List<History> historyList = historyRepository.findAll();
        List<HistoryDto> result = historyList.stream()
                .map(history -> new HistoryDto(
                        history.getId(),
                        history.getBuyerID().getId()    ,
                        history.getQuantity(),
                        history.getHistoryDate(),
                        history.getProductID().getProductName(),
                        history.getShipVia().getCompanyName(),
                        history.getTotalPrice()))
                .collect(Collectors.toList());
        return result;
    }

    public List<HistoryDto> findAllHistoryByBuyerId(Long buyerID) {
        return HistoryDto.toList(historyRepository.getBuyerId(buyerID));
    }
}
