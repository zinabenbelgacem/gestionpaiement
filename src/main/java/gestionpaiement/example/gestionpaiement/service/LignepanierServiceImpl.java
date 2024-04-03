package gestionpaiement.example.gestionpaiement.service;

import gestionpaiement.example.gestionpaiement.model.Article;
import gestionpaiement.example.gestionpaiement.model.Lignepanier;
import gestionpaiement.example.gestionpaiement.repository.LignepanierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LignepanierServiceImpl implements LignepanierService {

    private final LignepanierRepository lignepanierRepository;

    @Autowired
    public LignepanierServiceImpl(LignepanierRepository lignepanierRepository) {
        this.lignepanierRepository = lignepanierRepository;
    }

    // Create
    public Lignepanier createLignepanier(Lignepanier lignepanier) {
        return lignepanierRepository.save(lignepanier);
    }

    // Read
    public List<Lignepanier> getAllLignepaniers() {
        return lignepanierRepository.findAll();
    }

    public Optional<Lignepanier> getLignepanierById(long id) {

        return lignepanierRepository.findById(id);
    }

    // Update
    public Lignepanier updateLignepanier(long id, Lignepanier newLignepanierData) {
        Optional<Lignepanier> optionalLignepanier = lignepanierRepository.findById(id);
        if (optionalLignepanier.isPresent()) {
            Lignepanier existingLignepanier = optionalLignepanier.get();
            existingLignepanier.setQuantitecde(newLignepanierData.getQuantitecde());
            return lignepanierRepository.save(existingLignepanier);
        } else {
            return null; // Ou lancez une exception indiquant que la ligne de panier n'a pas été trouvée
        }
    }

    // Delete
    public void deleteLignepanier(long id) {
        lignepanierRepository.deleteById(id);
    }
    public List<Lignepanier> findByArticle(Article article) {
        return lignepanierRepository.findByArticle(article);
    }
}
