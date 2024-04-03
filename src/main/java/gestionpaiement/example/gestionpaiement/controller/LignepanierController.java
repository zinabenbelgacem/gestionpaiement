package gestionpaiement.example.gestionpaiement.controller;

import gestionpaiement.example.gestionpaiement.model.Lignepanier;
import gestionpaiement.example.gestionpaiement.service.LignepanierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/lignepanier")
public class LignepanierController {

    @Autowired
    private LignepanierService lignepanierService;

    @PostMapping("/addLignePanier")
    public Lignepanier addLignePanier(@RequestBody Lignepanier lignepanier) {
        return lignepanierService.createLignepanier(lignepanier);
    }

    @GetMapping("/getAllLignePaniers")
    public List<Lignepanier> getAllLignePaniers() {

        return lignepanierService.getAllLignepaniers();
    }

    @GetMapping("/getLignePanierById/{id}")
    public ResponseEntity<Lignepanier> getLignePanierById(@PathVariable long id) {
        Optional<Lignepanier> lignepanierOptional = lignepanierService.getLignepanierById(id);
        if (lignepanierOptional.isPresent()) {
            return ResponseEntity.ok(lignepanierOptional.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @PutMapping("/updateLignePanier/{id}")
    public Lignepanier updateLignePanier(@RequestBody Lignepanier newLignepanier, @PathVariable long id) {
        return lignepanierService.updateLignepanier(id, newLignepanier);
    }

    @DeleteMapping("/deleteLignePanier/{id}")
    public void deleteLignePanier(@PathVariable long id) {
        lignepanierService.deleteLignepanier(id);
    }
}
