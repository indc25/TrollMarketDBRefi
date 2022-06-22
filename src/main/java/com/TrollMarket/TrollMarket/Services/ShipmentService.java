package com.TrollMarket.TrollMarket.Services;

import com.TrollMarket.TrollMarket.Dto.ShipperDto;
import com.TrollMarket.TrollMarket.Models.Shipper;
import com.TrollMarket.TrollMarket.Repositories.ProfileRepository;
import com.TrollMarket.TrollMarket.Repositories.ShipperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

@Service
public class ShipmentService {

    private final ProfileRepository profileRepositories;
    private final ShipperRepository shippingRepository;

    @Autowired
    public ShipmentService(ProfileRepository profileRepositories, ShipperRepository shippingRepository) {
        this.profileRepositories = profileRepositories;
        this.shippingRepository = shippingRepository;
    }

    public List<ShipperDto> findAllShipper() {
        List<Shipper> shipperList = shippingRepository.findAll();
        return shipperList.stream()
                .map(ShipperDto -> new ShipperDto(
                        ShipperDto.getId(),
                        ShipperDto.getCompanyName(),
                        NumberFormat.getCurrencyInstance(new Locale("id", "ID")).format(ShipperDto.getPrice()),
                        ShipperDto.getEnabled() ? "Yes" : "No"
                ))
                .collect(java.util.stream.Collectors.toList());
    }

    public void stopService(int id){
        Shipper shipper = shippingRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Shipper not found"));
        if (shipper.getEnabled() == false){
            shipper.setEnabled(true);
        } else {
            shipper.setEnabled(false);
        }
        shippingRepository.save(shipper);
    }
}
