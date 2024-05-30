package ru.itis.tarot_whispers.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tarot_cards")
@Getter
@Setter
@EqualsAndHashCode
public class TarotCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "meaning", columnDefinition = "TEXT", nullable = false)
    private String meaning;

    @Column(name = "imageUrl", nullable = false)
    private String imageUrl;
}