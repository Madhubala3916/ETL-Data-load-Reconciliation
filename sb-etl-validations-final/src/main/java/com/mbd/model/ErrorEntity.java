package com.mbd.model;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class ErrorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long errorId;

    @Column
    private String entityName;

    @Column(name = "errorMessage", length = 900)
    private String errorMessage;

    public ErrorEntity() {
    }

    public ErrorEntity(Long errorId, String entityName, String errorMessage) {
        this.errorId = errorId;
        this.entityName = entityName;
        this.errorMessage = errorMessage;
    }

    // Constructors, getters, and setters
    // Getters and setters

    public Long getErrorId() {
        return errorId;
    }

    public void setErrorId(Long errorId) {
        this.errorId = errorId;
    }

    public String getEntityName() {
        return entityName;
    }

    public void setEntityName(String entityName) {
        this.entityName = entityName;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
