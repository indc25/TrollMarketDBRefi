package com.TrollMarket.TrollMarket.Dto;

import com.TrollMarket.TrollMarket.Models.History;
import com.TrollMarket.TrollMarket.Models.Product;
import com.TrollMarket.TrollMarket.Models.Profile;
import com.TrollMarket.TrollMarket.Models.Shipper;
import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
public class HistoryDto {
    private final Long id;
    private final Long buyerId;
    private final int quantity;
    private final LocalDate historyDate;
    private final String productName;
    private final String shipName;
    private final Long totalPrice;

    public static List<HistoryDto> toList (List<History> histories){
        List<HistoryDto> result = new ArrayList<>();

        for (History history : histories){
            result.add(new HistoryDto(
                    history.getId(),
                    history.getBuyerID().getId(),
                    history.getQuantity(),
                    history.getHistoryDate(),
                    history.getProductID().getProductName(),
                    history.getShipVia().getCompanyName(),
                    history.getTotalPrice()));
        }
        return result;
    }
}
