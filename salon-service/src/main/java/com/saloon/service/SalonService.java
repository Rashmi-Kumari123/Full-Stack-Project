package com.saloon.service;

import com.saloon.modal.Salon;
import com.saloon.dto.SalonDTO;
import com.saloon.dto.UserDTO;

import java.util.List;

public interface SalonService {

    Salon createSalon(SalonDTO salon, UserDTO user);

    Salon updateSalon(SalonDTO salon, UserDTO user,Long salonId) throws Exception;

    List<Salon> getAllSalons();

    Salon getSalonById(Long salonId) throws Exception;

    Salon getSalonByOwnerId(Long ownerId);

    List<Salon> searchSalonByCityName(String city);

}
