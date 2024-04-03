package gestionpaiement.example.gestionpaiement.controller;

import gestionpaiement.example.gestionpaiement.model.Article;
import gestionpaiement.example.gestionpaiement.model.Lignepanier;
import gestionpaiement.example.gestionpaiement.repository.LignepanierRepository;
import gestionpaiement.example.gestionpaiement.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/articles")
public class ArticleController {

    private final ArticleService articleService;
    @Autowired
    private LignepanierRepository lignePanierRepository;

   /* @PostMapping(value ="/{articleId}/ajouter-au-panier")
    public ResponseEntity<Lignepanier> ajouterAuPanier(@PathVariable Long articleId, @RequestParam int quantitecde) {
        Lignepanier lignePanier = articleService.ajouterArticleAuPanier(articleId, quantitecde);
        return ResponseEntity.ok(lignePanier);
    }*/
   /*@PostMapping(value ="/{articleId}/ajouter-au-panier")
   public ResponseEntity<Lignepanier> ajouterAuPanier(@PathVariable Long articleId, @RequestBody Map<String, Object> requestBody) {
       int quantitecde = (int) requestBody.get("quantitecde");
       Lignepanier lignePanier = articleService.ajouterArticleAuPanier(articleId, quantitecde);
       return ResponseEntity.ok(lignePanier);
   }*/


    @Autowired
    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @PostMapping
    public ResponseEntity<Article> createArticle(@RequestBody Article article) {
        Article createdArticle = articleService.createArticle(article);
        return new ResponseEntity<>(createdArticle, HttpStatus.CREATED);
    }

    // Endpoint pour récupérer tous les articles
    @GetMapping
    public ResponseEntity<List<Article>> getAllArticles() {
        List<Article> articles = articleService.getAllArticles();
        return new ResponseEntity<>(articles, HttpStatus.OK);
    }

    // Endpoint pour récupérer un article par son ID
    @GetMapping("/{id}")
    public ResponseEntity<Article> getArticleById(@PathVariable long id) {
        return articleService.getArticleById(id)
                .map(article -> new ResponseEntity<>(article, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Endpoint pour mettre à jour un article
    @PutMapping("/{id}")
    public ResponseEntity<Article> updateArticle(@PathVariable long id, @RequestBody Article newArticleData) {
        Article updatedArticle = articleService.updateArticle(id, newArticleData);
        if (updatedArticle != null) {
            return new ResponseEntity<>(updatedArticle, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Endpoint pour supprimer un article
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteArticle(@PathVariable long id) {
        articleService.deleteArticle(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
