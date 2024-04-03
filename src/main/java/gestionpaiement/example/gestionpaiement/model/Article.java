package gestionpaiement.example.gestionpaiement.model;

import com.fasterxml.jackson.annotation.*;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titre;

    @Column(length = 1000)
    private String photo;
    private String description;
    private int quantiter;

    private double prix;
    private boolean Livrable = false;
    private String statut;
    private double prixinitial;
    private double prixvente;


    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "lignepanier_id")
    private Lignepanier lignepanier;
}
