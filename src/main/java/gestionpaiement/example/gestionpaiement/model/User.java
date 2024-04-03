package gestionpaiement.example.gestionpaiement.model;


import com.fasterxml.jackson.annotation.*;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Data
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler","demandes"})
@Inheritance(strategy = InheritanceType.JOINED)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    @Setter
    @Size(max = 20)
    private String type;

    @NotBlank
    @Size(max = 20)
    private String nom;

    @NotBlank
    @Size(max = 20)
    private String prenom;

    @NotNull(message = "Tel cannot be null")
    private Integer tel;

    @NotBlank
    @Size(max = 50)
    @Email
    private String email;

    @NotBlank
    @Size(max = 120)
    private String password;

    @Min(value = 1000, message = "Postal code must be at least 1000")
    @Max(value = 9999, message = "Postal code must be at most 9999")
    private Integer codePostal;

    @Size(max = 20)
    private String pays;

    @Size(max = 20)
    private String ville;

    @Digits(integer = 8, fraction = 0, message = "CIN must contain exactly 8 digits")
    @Size(min = 8, max = 8, message = "CIN must contain exactly 8 digits")
    private int cin;

    private double longitude;
    private double latitude;


    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "parten_id")
    private Part_En parten ;

}