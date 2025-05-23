package com.saloon.service;

import com.saloon.dto.CategoryDTO;
import com.saloon.dto.SalonDTO;
import com.saloon.dto.ServiceDTO;
import com.saloon.modal.ServiceOffering;

import java.util.Set;

public interface ServiceOfferingService {

    ServiceOffering createService(SalonDTO salonDTO,
                                  ServiceDTO serviceDTO,
                                  CategoryDTO categoryDTO);

    ServiceOffering updateService(Long serviceId,ServiceOffering service) throws Exception;

    Set<ServiceOffering> getAllServiceBySalonId(Long salonId,Long categoryId);

    Set<ServiceOffering> getServicesById(Set<Long> ids);

    ServiceOffering getServiceById(Long id) throws Exception;





}
