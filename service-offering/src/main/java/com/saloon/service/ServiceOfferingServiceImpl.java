package com.saloon.service;

import com.saloon.dto.CategoryDTO;
import com.saloon.dto.SalonDTO;
import com.saloon.dto.ServiceDTO;
import com.saloon.modal.ServiceOffering;
import com.saloon.repository.ServiceOfferingRepository;
import com.saloon.service.ServiceOfferingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ServiceOfferingServiceImpl implements ServiceOfferingService {

    // here we can annotate  we can use AutoWired instead of RequiredArgsConstructor
    private final ServiceOfferingRepository serviceOfferingRepository;

    @Override
    public ServiceOffering createService(SalonDTO salonDTO,
                                         ServiceDTO serviceDTO,
                                         CategoryDTO categoryDTO) {
        ServiceOffering serviceOffering = new ServiceOffering();
        serviceOffering.setName(serviceDTO.getName());
        serviceOffering.setPrice(serviceDTO.getPrice());
        serviceOffering.setDescription(serviceDTO.getDescription());
        serviceOffering.setImage(serviceDTO.getImage());
        serviceOffering.setDuration(serviceDTO.getDuration());
        serviceOffering.setSalonId(salonDTO.getId());
        serviceOffering.setCategoryId(categoryDTO.getId());
        return serviceOfferingRepository.save(serviceOffering);
    }

    @Override
    public ServiceOffering updateService(Long serviceId, ServiceOffering service) throws Exception {

        ServiceOffering serviceOffering = serviceOfferingRepository
                .findById(serviceId).orElse(null);

        if (serviceOffering == null){
            throw new Exception("service id not found");

        }
        serviceOffering.setName(service.getName());
        serviceOffering.setDescription(service.getDescription());
        serviceOffering.setImage(service.getImage());
        serviceOffering.setDuration(service.getDuration());
        return serviceOfferingRepository.save(serviceOffering);
    }

    @Override
    public Set<ServiceOffering> getAllServiceBySalonId(Long salonId, Long categoryId) {

        Set<ServiceOffering> services = serviceOfferingRepository.findBySalonId(salonId);

        // filtering the services based on categoryId
        if(categoryId != null){
            services = services.stream().filter((service) -> service.getCategoryId() != null &&
                    service.getCategoryId() == categoryId).collect(Collectors.toSet());
        }
        return services;
    }

    @Override
    public Set<ServiceOffering> getServicesById(Set<Long> ids) {
        List<ServiceOffering> services = serviceOfferingRepository.findAllById(ids);
        return new HashSet<>(services);
    }

    @Override
    public ServiceOffering getServiceById(Long id) throws Exception {
        ServiceOffering service = serviceOfferingRepository.findById(id).orElse(null);

        if(service == null){
            throw new Exception("service id not found");
        }

        return service;
    }
}
