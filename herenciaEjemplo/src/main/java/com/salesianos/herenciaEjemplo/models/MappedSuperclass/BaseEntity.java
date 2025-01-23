package com.salesianos.herenciaEjemplo.models.MappedSuperclass;


import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

import java.io.Serializable;
import java.time.LocalDateTime;

@MappedSuperclass
public abstract class BaseEntity implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    private String createdBy;
    
    private LocalDateTime createdDate;

}
