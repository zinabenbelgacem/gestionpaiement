package gestionpaiement.example.gestionpaiement.model;

import java.util.Date;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class Panier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double TotalP ;

    private Date date;

    @JsonIgnore
    @OneToMany(mappedBy = "panier")
    private List<Paiement> paiements;


    @ManyToOne
    @JoinColumn(name = "lignepanier_id")
    private Lignepanier lignepanier;

    @OneToOne
    private Part_En parten;

}
