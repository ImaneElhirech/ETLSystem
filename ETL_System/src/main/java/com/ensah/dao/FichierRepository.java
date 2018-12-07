package com.ensah.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ensah.bo.Fichier;

public interface FichierRepository extends JpaRepository<Fichier, Long> {

}
