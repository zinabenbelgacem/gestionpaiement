package gestionpaiement.example.gestionpaiement.service;

import gestionpaiement.example.gestionpaiement.model.Lignepanier;

import java.util.List;
import java.util.Optional;

public interface LignepanierService {

    // Créer
    Lignepanier createLignepanier(Lignepanier lignepanier);

    // Lire
    List<Lignepanier> getAllLignepaniers();

    Optional<Lignepanier> getLignepanierById(long id);

    // Mettre à jour
    Lignepanier updateLignepanier(long id, Lignepanier newLignepanierData);

    // Supprimer
    void deleteLignepanier(long id);
}
