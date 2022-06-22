package com.TrollMarket.TrollMarket.Controllers;

import com.TrollMarket.TrollMarket.Services.ProfileService;
import com.TrollMarket.TrollMarket.Services.ShipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/shipment")
public class ShipmentController {

    @Autowired private ProfileService profileService;
    @Autowired private ShipmentService shipmentService;

    @RequestMapping("/index")
    public String homePages(Model model) {
        model.addAttribute("profile", profileService.getProfileUserLogin());
        model.addAttribute("shipment", shipmentService.findAllShipper());
        return "shipment/shipment-index";
    }

    @GetMapping("/stopService")
    public String stopService(@RequestParam int id) {
        shipmentService.stopService(id);
        return "redirect:/shipment/index";
    }
}
