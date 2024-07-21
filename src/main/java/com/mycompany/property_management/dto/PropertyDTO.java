
package com.mycompany.property_management.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PropertyDTO {

    private Long id;
    private String title;
    private String description;

    @JsonProperty("OwnerName")
    private String ownerName;

    @JsonProperty("OwnerEmail")
    private String ownerEmail;

    private Double price;
    private String address;

}

