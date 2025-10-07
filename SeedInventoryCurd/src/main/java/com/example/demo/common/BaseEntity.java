package com.example.demo.common;

	
	import java.time.LocalDateTime;
	import jakarta.persistence.MappedSuperclass;
	import jakarta.persistence.PrePersist;
	import jakarta.persistence.PreUpdate;

	@MappedSuperclass
	public abstract class BaseEntity {

	    private LocalDateTime createdAt;
	    private LocalDateTime updatedAt;

	    @PrePersist
	    protected void onCreate() {
	        createdAt = LocalDateTime.now();
	    }

	    @PreUpdate
	    protected void onUpdate() {
	        updatedAt = LocalDateTime.now();
	    }

	    // Getters and Setters
	    public LocalDateTime getCreatedAt() {
	        return createdAt;
	    }

	    public void setCreatedAt(LocalDateTime createdAt) {
	        this.createdAt = createdAt;
	    }

	    public LocalDateTime getUpdatedAt() {
	        return updatedAt;
	    }

	    public void setUpdatedAt(LocalDateTime updatedAt) {
	        this.updatedAt = updatedAt;
	    }
	}


