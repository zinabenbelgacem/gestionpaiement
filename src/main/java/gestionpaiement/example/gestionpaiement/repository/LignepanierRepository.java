package gestionpaiement.example.gestionpaiement.repository;

import gestionpaiement.example.gestionpaiement.model.Article;
import gestionpaiement.example.gestionpaiement.model.Lignepanier;
import gestionpaiement.example.gestionpaiement.model.Panier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface LignepanierRepository extends JpaRepository<Lignepanier,Long> {
    List<Lignepanier> findByArticle(Article article);


}
