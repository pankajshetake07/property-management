package com.mycompany.property_management.controller;

import com.mycompany.property_management.dto.PropertyDTO;
import com.mycompany.property_management.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/properties")
public class PropertyController {

    @Value("${pms.dummy:}")
    private String dummy;

    @Autowired
    private PropertyService propertyService;

    //RESTFULL API is just mapping of a url to a java class function
    //http://localhost:8080/api/v1/properties/hello
    //this URL is map to a function
    @GetMapping("/hello")
    public String sayHello(){
        return "Hello World";
    }


    @PostMapping("/data")
    public ResponseEntity<PropertyDTO> saveProperty(@RequestBody PropertyDTO propertyDTO){
        propertyDTO = propertyService.saveProperty(propertyDTO);
        ResponseEntity<PropertyDTO> responseEntity = new ResponseEntity<>(propertyDTO, HttpStatus.CREATED);
        return responseEntity;
    }

    @GetMapping("/data")
    public ResponseEntity<List<PropertyDTO>> getAllProperties(){
        System.out.println(dummy);  //this is the environment on which we are running the database
        List<PropertyDTO> propertyList = propertyService.getAllProperties();
        ResponseEntity<List<PropertyDTO>> responseEntity = new ResponseEntity<>(propertyList, HttpStatus.OK);
        return responseEntity;
    }

    @PutMapping("/data/{propertyId}")
    public ResponseEntity<PropertyDTO> updateProperty(@RequestBody PropertyDTO propertyDTO, @PathVariable Long propertyId){
        propertyDTO = propertyService.updateProperty(propertyDTO, propertyId);
        ResponseEntity<PropertyDTO> responseEntity = new ResponseEntity<>(propertyDTO, HttpStatus.OK);
        return responseEntity;
    }

    @PatchMapping("/data/update-ownername/{propertyId}")
    public ResponseEntity<PropertyDTO> updateOwnerName(@RequestBody PropertyDTO propertyDTO, @PathVariable Long propertyId){
        propertyDTO = propertyService.updateOwnerName(propertyDTO, propertyId);
        ResponseEntity<PropertyDTO> responseEntity = new ResponseEntity<>(propertyDTO, HttpStatus.OK);
        return responseEntity;
    }

    @PatchMapping("/data/update-owneremail/{propertyId}")
    public ResponseEntity<PropertyDTO> updateOwnerEmail(@RequestBody PropertyDTO propertyDTO, @PathVariable Long propertyId){
        propertyDTO = propertyService.updateOwnerEmail(propertyDTO, propertyId);
        ResponseEntity<PropertyDTO> responseEntity = new ResponseEntity<>(propertyDTO, HttpStatus.OK);
        return responseEntity;
    }

    @DeleteMapping("/data/delete/{propertyId}")
    public ResponseEntity deleteRecord (@PathVariable Long propertyId){
        propertyService.deleteRecord(propertyId);
        ResponseEntity<Void> responseEntity = new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        return responseEntity;
    }
}
