package gestionpaiement.example.gestionpaiement.model;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Lignepanier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    @Column(name = "quantite_commandee")
    private  int quantitecde;


    @OneToMany
    @JoinColumn(name = "article_id")
    private List<Article> article;

    @OneToMany(mappedBy = "lignepanier")
    private List<Panier> panier;



}
