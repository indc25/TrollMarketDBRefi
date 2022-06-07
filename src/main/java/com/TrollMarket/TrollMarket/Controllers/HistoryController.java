//package com.TrollMarket.TrollMarket.Controllers;
//
//import com.TrollMarket.TrollMarket.Dto.HistoryDto;
//import com.TrollMarket.TrollMarket.Models.Profile;
//import com.TrollMarket.TrollMarket.Services.HistoryService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@CrossOrigin(origins = "*", allowedHeaders = "*")
//@RequestMapping("api/history")
//public class HistoryController {
//
//    private HistoryService historyService;
//
//    @Autowired
//    public HistoryController(HistoryService historyService) {
//        this.historyService = historyService;
//    }
//
//    @RequestMapping("buyerId")
//    public List<HistoryDto> findAllHistoryByBuyerId(@RequestParam Long buyerID) {
//        return historyService.findAllHistoryByBuyerId(buyerID);
//    }
//}
