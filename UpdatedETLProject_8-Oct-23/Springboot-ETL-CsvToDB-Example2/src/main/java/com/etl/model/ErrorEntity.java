package com.etl.model;

import java.time.LocalDateTime;

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
    private String EntityName;
    public String getEntityName() {
		return EntityName;
	}
    public void setEntityName(String entityName) {
		EntityName = entityName;
	}
    @Column(name = "errorMessage", length = 900)
    private String errorMessage;

    // Constructors, getters, and setters
    // Getters and setters
    public Long geterrorId() {
        return errorId;
    }
    @Override
	public String toString() {
		return "ErrorEntity [errorId=" + errorId + ", EntityName=" + EntityName + ", errorMessage=" + errorMessage
				+ "]";
	}
	public ErrorEntity(Long errorId, String entityName, String errorMessage) {
		super();
		this.errorId = errorId;
		EntityName = entityName;
		this.errorMessage = errorMessage;
	}
	public ErrorEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	public void seterrorId(Long errorId) {
        this.errorId = errorId;
    }
    public String getErrorMessage() {
        return errorMessage;
    }
    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
