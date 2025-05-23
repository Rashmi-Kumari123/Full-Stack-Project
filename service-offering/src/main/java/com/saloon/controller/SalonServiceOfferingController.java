package com.saloon.controller;

import com.saloon.dto.CategoryDTO;
import com.saloon.dto.SalonDTO;
import com.saloon.dto.ServiceDTO;
import com.saloon.modal.ServiceOffering;
import com.saloon.service.ServiceOfferingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/service/salon-owner")
public class SalonServiceOfferingController {    // purpose that salon owner can create service and update service

    private final ServiceOfferingService serviceOfferingService;

//    @PostMapping("/salon/{salonId}/category/{categoryId}")
    @PostMapping
    public ResponseEntity<ServiceOffering> createService(
            @RequestBody ServiceDTO serviceDTO) {

        SalonDTO salonDTO = new SalonDTO();
        salonDTO.setId(1L);

        CategoryDTO categoryDTO = new CategoryDTO();
        System.out.println("value printed"+serviceDTO.getCategory());
        categoryDTO.setId(serviceDTO.getCategory());

        ServiceOffering createdService = serviceOfferingService.createService(
                salonDTO,
                serviceDTO,
                categoryDTO
        );
        return new ResponseEntity<>(createdService, HttpStatus.CREATED);
    }

    @PutMapping("/{serviceId}")
    public ResponseEntity<ServiceOffering> updateService(
            @PathVariable Long serviceId,
            @RequestBody ServiceOffering service) throws Exception {

        ServiceOffering updatedService = serviceOfferingService.updateService(serviceId, service);
        return ResponseEntity.ok(updatedService);
    }
}
