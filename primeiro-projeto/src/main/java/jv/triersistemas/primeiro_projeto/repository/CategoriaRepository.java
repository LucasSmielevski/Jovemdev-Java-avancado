package jv.triersistemas.primeiro_projeto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import jv.triersistemas.primeiro_projeto.entity.CategoriaEntity;

public interface CategoriaRepository extends JpaRepository<CategoriaEntity, Integer>{

}
