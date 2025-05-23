package com.saloon.controller;

import com.saloon.modal.ServiceOffering;
import com.saloon.service.ServiceOfferingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/api/service-offering")
@RequiredArgsConstructor
public class ServiceOfferingController {

    private final ServiceOfferingService serviceOfferingService;

    @GetMapping("/salon/{salonId}")
    public ResponseEntity<Set<ServiceOffering>> getServicesBySalon(
            @PathVariable Long salonId,
            @RequestParam(required = false) Long categoryId) {

        Set<ServiceOffering> services = serviceOfferingService.getAllServiceBySalonId(salonId, categoryId);
        return ResponseEntity.ok(services);
    }

    @GetMapping("/batch")
    public ResponseEntity<Set<ServiceOffering>> getServicesByIds(@RequestParam Set<Long> ids) {
        Set<ServiceOffering> services = serviceOfferingService.getServicesById(ids);
        return ResponseEntity.ok(services);
    }

    @GetMapping("/{serviceId}")
    public ResponseEntity<ServiceOffering> getServiceById(
            @PathVariable Long serviceId) throws Exception {

        ServiceOffering service = serviceOfferingService.getServiceById(serviceId);
        return ResponseEntity.ok(service);
    }
}