package jv.triersistemas.primeiro_projeto.service;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import jv.triersistemas.primeiro_projeto.dto.CategoriaDto;

public interface CategoriaService {
	List<CategoriaDto> getTodasCategorias();

	Optional<CategoriaDto> getCategoriaPorId(@RequestParam int id);

	CategoriaDto adicionarCategoria(@RequestBody CategoriaDto novaCategoria);

	CategoriaDto atualizarCategoria(int id, CategoriaDto categoriaAtualizada);

	void removerCategoria(@RequestParam int id);
}
