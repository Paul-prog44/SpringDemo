package com.autourducode.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.autourducode.demo.modele.Produit;

public interface ProduitRepository extends JpaRepository<Produit, Long> {

}
