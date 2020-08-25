package com.nagarro.Demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CourseEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)  
	private Long id;   
	@Column(name = "title", nullable = false)  
	private String title;  
	@Column(name = "valid_from", nullable = false)  
	private String validFrom;  
	@Column(name = "valid_till", nullable = false)  
	private String validTill;
	@Column(name = "coordinator_id")  
	private String coordinatorId;
	@Column(name = "rating")  
	private double rating;
	@Column(name = "description", nullable = false)  
	private String description;
	@Column(name = "total_enrollments", nullable = false)  
	private double totalEnrollments;
	@Column(name = "image_url", nullable = false) 
	private String imageUrl; 
	@Column(name = "active_enrollments")  
	private double activeEnrollments;  
	
	public CourseEntity() {
		super();
	}

	public CourseEntity(Long id, String title, String validFrom, String validTill, String coordinatorId, double rating,
			String description, double totalEnrollments, String imageUrl, long activeEnrollments) {
		super();
		this.id = id;
		this.title = title;
		this.validFrom = validFrom;
		this.validTill = validTill;
		this.coordinatorId = coordinatorId;
		this.rating = rating;
		this.description = description;
		this.totalEnrollments = totalEnrollments;
		this.imageUrl = imageUrl;
		this.activeEnrollments = activeEnrollments;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getValidFrom() {
		return validFrom;
	}

	public void setValidFrom(String validFrom) {
		this.validFrom = validFrom;
	}

	public String getValidTill() {
		return validTill;
	}

	public void setValidTill(String validTill) {
		this.validTill = validTill;
	}

	public String getCoordinatorId() {
		return coordinatorId;
	}

	public void setCoordinatorId(String coordinatorId) {
		this.coordinatorId = coordinatorId;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getTotalEnrollments() {
		return totalEnrollments;
	}

	public void setTotalEnrollments(double totalEnrollments) {
		this.totalEnrollments = totalEnrollments;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public double getActiveEnrollments() {
		return activeEnrollments;
	}

	public void setActiveEnrollments(double activeEnrollments) {
		this.activeEnrollments = activeEnrollments;
	}	
}
