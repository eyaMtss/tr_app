package com.tunidesign.backendutilisateurmicroservice.model.entity;

import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

import ch.qos.logback.core.util.Duration;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Shift {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private LocalTime startTime;
	private LocalTime endTime;
	private String duration;

	@OneToMany(mappedBy = "shift")
	private Set<UserShift> userShifts = new HashSet<UserShift>();
}