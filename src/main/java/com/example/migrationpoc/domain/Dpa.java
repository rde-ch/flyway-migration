package com.example.migrationpoc.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "dpa")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Dpa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long recordIdentifier;

     private String changeType;
     private Integer proOrder;

    @Column(unique = true, nullable = false)
     private Long uprn;
     private Long udprn;
     private String organisationName;
     private String departmentName;
     private String subBuildingName;
     private String buildingName;
     private Integer buildingNumber;
     private String dependentThoroughfare;
     private String thoroughFareName;
     private String doubleDependentLocality;
     private String dependentLocality;
     private String postTown;
     private String postcode;
     private String postCodeType;
     private String deliveryPointSuffix;
     private String  welshDependentThoroughfare;
     private String welshThoroughfare;
     private String welshDoubleDependentLocality;
     private String welshDependentLocality;
     private String welshPostTown;
     private String poBoxNumber;

     private LocalDate processDate;
     private LocalDate startDate;
     private LocalDate endDate;
     private LocalDate lastUpdateDate;
     private LocalDate entryDate;

}
