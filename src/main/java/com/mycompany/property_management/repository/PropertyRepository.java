package com.mycompany.property_management.repository;

import com.mycompany.property_management.entity.PropertyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface PropertyRepository extends CrudRepository<PropertyEntity, Long> {

}
