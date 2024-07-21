package com.mycompany.property_management.service;

import com.mycompany.property_management.dto.PropertyDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface PropertyService {

    PropertyDTO saveProperty(PropertyDTO propertyDTO);

    List<PropertyDTO> getAllProperties();

    PropertyDTO updateProperty(PropertyDTO propertyDTO, Long propertyId);

    PropertyDTO updateOwnerName(PropertyDTO propertyDTO, Long propertyId);

    PropertyDTO updateOwnerEmail(PropertyDTO propertyDTO, Long propertyId);

    void deleteRecord(Long propertyId);
}
