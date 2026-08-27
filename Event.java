package com.eventify.model;
import jakarta.persistence.*;
import java.time.LocalDateTime;
@Entity
@Table(name = "Event")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long eventId;
   @Column
    private String title;
    private String description;
    private String eventType;
    private String location;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Integer capacity;
    private Double price;
    @Enumerated(EnumType.STRING)
    private EventStatus status; // active/cancelled
    @ManyToOne
    @JoinColumn(name = "organizer_id")
    private Organizer organizer;
    // Getters & Setters
	public Long getEventId() {
		return eventId;
	}
	public void setEventId(Long eventId) {
		this.eventId = eventId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getEventType() {
		return eventType;
	}
	public void setEventType(String eventType) {
		this.eventType = eventType;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public LocalDateTime getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDateTime startDate) {
		this.startDate = startDate;
	}
	public LocalDateTime getEndDate() {
		return endDate;
	}
	public void setEndDate(LocalDateTime endDate) {
		this.endDate = endDate;
	}
	public Integer getCapacity() {
		return capacity;
	}
	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public EventStatus getStatus() {
		return status;
	}
	public void setStatus(EventStatus status) {
		this.status = status;
	}
	public Organizer getOrganizer() {
		return organizer;
	}
	public void setOrganizer(Organizer organizer) {
		this.organizer = organizer;
	}
	@Override
	public String toString() {
		return "Event [eventId=" + eventId + ", title=" + title + ", description=" + description + ", eventType="
				+ eventType + ", location=" + location + ", startDate=" + startDate + ", endDate=" + endDate
				+ ", capacity=" + capacity + ", price=" + price + ", status=" + status + ", organizer=" + organizer
				+ "]";
	}
	
    
}
