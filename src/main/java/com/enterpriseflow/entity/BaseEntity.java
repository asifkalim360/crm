package com.enterpriseflow.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;


@Getter
@Setter
@MappedSuperclass
//Iska matlab hai ye class Table nahi bnayegi,lekin jo bhi Entity class esko extend kregi usme ye filed Add ho jayegi.
public abstract class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // Yahan pe Auto-increment ID generate hoga database ke through.
    private Long id;

    @Column(name="created_at", updatable = false)
    // updatable=false ka matlab hai once insert ho gaya to update nahi hoga.
    private LocalDateTime createdAt;

    @Column(name="updated_at")
    private LocalDateTime updatedAt;

    @Column(name="created_by")
    //Yahan pe LoggedIN user ka ID ya Email store karenge.
    private String createBy;

    @Column(name="updated_by")
    private String updatedBy;

    @Column(name="is_deleted")
    // Soft deleted ke liye flag.
    private Boolean isDeleted = false;

    @PrePersist
    // yeh method tab chalega jab first time data insert hoga.
    public void onCreated()
    {
        this.createdAt = LocalDateTime.now();
    }
    @PreUpdate
    // Yeh method tab chalega jab record update hoga.
    public void onUpdate()
    {
        this.updatedAt = LocalDateTime.now();
    }
}
