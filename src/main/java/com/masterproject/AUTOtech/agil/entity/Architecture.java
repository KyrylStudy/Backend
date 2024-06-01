package com.masterproject.AUTOtech.agil.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Architecture")
@Entity
public class Architecture {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "type")
	private String type;
	
	@Column(name = "description")
	private String description;
	
	@Builder.Default
	@OneToMany(mappedBy = "architecture", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ECU> software = new ArrayList<ECU>();//-------------------------------------переименовать софтвеар на ецу
	
	@Builder.Default
	@OneToMany(mappedBy = "architecture", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Bus> bus = new ArrayList<Bus>();

}

