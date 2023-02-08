package com.tunidesign.backendutilisateurmicroservice.model.entity;

import java.time.LocalDate;

import com.tunidesign.backendutilisateurmicroservice.model.annotations.Primarykeys.UserShiftId;

import jakarta.persistence.CascadeType;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserShift {
	@EmbeddedId
	private UserShiftId id;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@MapsId("userId")
	private User user;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@MapsId("shiftId")
	private Shift shift;

	private LocalDate startDate;
	private LocalDate endDate;
}
