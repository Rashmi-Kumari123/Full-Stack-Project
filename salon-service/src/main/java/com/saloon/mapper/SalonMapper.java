package com.saloon.mapper;


import com.saloon.modal.Salon;
import com.saloon.dto.SalonDTO;

public class SalonMapper {

    public static SalonDTO mapToDTO(Salon salon){
        SalonDTO salonDTO = new SalonDTO();
        salonDTO.setCity(salon.getCity());
        salonDTO.setAddress(salon.getAddress());
        salonDTO.setImages(salon.getImages());
        salonDTO.setName(salon.getName());
        salonDTO.setCloseTime(salon.getCloseTime());
        salonDTO.setOpenTime(salon.getOpenTime());
        salonDTO.setOwnerId(salon.getOwnerId());
        salonDTO.setId(salon.getId());
        salonDTO.setEmail(salon.getEmail());
        return salonDTO;

    }
}
