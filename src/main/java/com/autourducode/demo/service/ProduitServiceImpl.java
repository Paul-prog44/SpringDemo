package com.autourducode.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.autourducode.demo.modele.Produit;
import com.autourducode.demo.repository.ProduitRepository;

import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor
public class ProduitServiceImpl implements ProduitService {
	
	private final ProduitRepository produitRepository;
	
	@Override
	public Produit creer(Produit produit) {
		return produitRepository.save(produit);
	}

	@Override
	public List<Produit> lire() {
		return produitRepository.findAll();
	}

	@Override
	public Produit modifier(Long id, Produit produit) {
		return produitRepository.findById(id)
				.map(p-> {
					p.setPrix(p.getPrix());
					p.setNom(produit.getNom());
					p.setDescription(produit.getDescription());
					return produitRepository.save(p);
				}).orElseThrow(() -> new RuntimeException("Produit non trouvé"));
	}

	@Override
	public String supprimer(Long id) {
		produitRepository.deleteById(id);
		return "Produit supprimé";
	}

}
