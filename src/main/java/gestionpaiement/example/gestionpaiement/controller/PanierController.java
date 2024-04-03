package gestionpaiement.example.gestionpaiement.controller;

import gestionpaiement.example.gestionpaiement.model.Panier;
import gestionpaiement.example.gestionpaiement.service.PanierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/panier")
public class PanierController {

    @Autowired
    private PanierService panierService;

    @PostMapping("/addPanier")
    public Panier addPanier(@RequestBody Panier panier) {

        return panierService.save(panier);
    }

    @GetMapping("/getAllPaniers")
    public List<Panier> getAllPaniers() {
        return panierService.getAllPaniers();
    }

    @GetMapping("/getPanierById/{id}")
    public Panier getPanierById(@PathVariable Long id) {
        return panierService.findById(id).orElse(null);
    }

    @PutMapping("/updatePanier/{id}")
    public Panier updatePanier(@RequestBody Panier panier, @PathVariable Long id) {
        return panierService.updatePanier(id, panier);
    }

    @DeleteMapping("/deletePanier/{id}")
    public String deletePanier(@PathVariable Long id) {
        return panierService.deletePanier(id);
    }

    @GetMapping("/calculerMontantTotal")
    public double calculerMontantTotal() {
        List<Panier> paniers = panierService.getAllPaniers();
        return panierService.calculerMontantTotal(paniers);
    }


}
