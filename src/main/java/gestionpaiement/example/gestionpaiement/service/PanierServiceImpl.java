package gestionpaiement.example.gestionpaiement.service;

import gestionpaiement.example.gestionpaiement.model.Panier;
import gestionpaiement.example.gestionpaiement.repository.PanierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class PanierServiceImpl implements PanierService {
    @Autowired
    private PanierRepository panierRepository;

    @Override
    public Panier save(Panier panier) {
        return panierRepository.save(panier);
    }

    @Override
    public String deletePanier(long id) {
        panierRepository.deleteById(id);
        return "Panier supprimé avec succès !";
    }

    @Override
    public List<Panier> getAllPaniers() {
        return panierRepository.findAll();
    }

    @Override
    public Panier updatePanier(Long id, Panier panier) {
        Optional<Panier> existingPanierOptional = panierRepository.findById(id);
        if (existingPanierOptional.isPresent()) {
            Panier existingPanier = existingPanierOptional.get();
            existingPanier.setDate(panier.getDate());
            existingPanier.setPaiements(panier.getPaiements());
            existingPanier.setLignepanier(panier.getLignepanier());
            // Appeler la méthode pour calculer le montant total
            double montantTotal = calculerMontantTotal(Collections.singletonList(existingPanier));
            existingPanier.setTotalP(montantTotal);
            return panierRepository.save(existingPanier);
        } else {
            return null;
        }
    }


    @Override
    public Optional<Panier> findById(long id) {
        return panierRepository.findById(id);
    }


    // Méthode pour calculer le montant total
    @Override
    public double calculerMontantTotal(List<Panier> paniers) {
        double montantTotal = 0.0;
        // Parcourir la liste des paniers et ajouter le total de chacun au montant total
        for (Panier panier : paniers) {
            // Ajouter le total de chaque panier au montant total
            montantTotal += panier.getTotalP();
        }
        return montantTotal;
    }
}
