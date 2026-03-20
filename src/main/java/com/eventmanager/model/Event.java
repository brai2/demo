package com.eventmanager.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;

@Entity
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Ten su kien khong duoc de trong")
    @Size(max = 150, message = "Ten su kien toi da 150 ky tu")
    private String name;

    @Size(max = 1000, message = "Mo ta toi da 1000 ky tu")
    private String description;

    @NotBlank(message = "Dia diem khong duoc de trong")
    @Size(max = 255, message = "Dia diem toi da 255 ky tu")
    private String location;

    @NotNull(message = "Thoi gian bat dau la bat buoc")
    @Future(message = "Thoi gian bat dau phai o tuong lai")
    private LocalDateTime startTime;

    @NotNull(message = "Thoi gian ket thuc la bat buoc")
    @Future(message = "Thoi gian ket thuc phai o tuong lai")
    private LocalDateTime endTime;

    @NotNull(message = "So luong toi da la bat buoc")
    @Min(value = 1, message = "So luong toi da phai lon hon 0")
    private Integer maxAttendees;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public Integer getMaxAttendees() {
        return maxAttendees;
    }

    public void setMaxAttendees(Integer maxAttendees) {
        this.maxAttendees = maxAttendees;
    }
}
