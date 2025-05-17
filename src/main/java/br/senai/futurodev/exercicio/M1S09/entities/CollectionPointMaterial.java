package br.senai.futurodev.exercicio.M1S09.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "collection_points_materials")
public class CollectionPointMaterial {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @ManyToOne
    private CollectionPoint collectionPoint;

    @Column(nullable = false)
    @ManyToOne
    private EletronicWaste eletronicWaste;

    @Column(nullable = false)
    private BigDecimal maxCapacity;

}
