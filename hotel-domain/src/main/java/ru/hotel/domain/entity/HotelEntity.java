package ru.hotel.domain.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "hotels")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HotelEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 200)
    private String name;

    @Column(nullable = false, length = 20)
    private String category;

    @Column(columnDefinition = "TEXT")
    private String notes;

}
