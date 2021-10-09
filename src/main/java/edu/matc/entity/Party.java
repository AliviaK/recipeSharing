package edu.matc.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * The type Recipe ingredient.
 */
@Entity(name = "Party")
@Table(name = "party")
public class Party {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;

    @ManyToOne
    private User user;

    @ManyToOne
    private Recipe recipe;

    /** Not sure yet how to do this */
    private LocalDateTime partyDate;

    private String details;
}
