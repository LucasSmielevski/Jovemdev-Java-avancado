package jv.triersistemas.primeiro_projeto.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jv.triersistemas.primeiro_projeto.dto.CategoriaDto;
import jv.triersistemas.primeiro_projeto.service.CategoriaService;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {
	
	@Autowired
	private CategoriaService categoriaService;
	
	@GetMapping
	public List<CategoriaDto> getTodasCategorias(){
		return categoriaService.getTodasCategorias();
	}
	
	@GetMapping("/{id}")
	public CategoriaDto getCategorPorId(@PathVariable int id) {
		Optional<CategoriaDto> categoria = categoriaService.getCategoriaPorId(id);
		return categoria.orElse(null);
	}
	
	@PostMapping
	public CategoriaDto adicionarCategoria(@RequestBody CategoriaDto novaCategoria) {
		return categoriaService.adicionarCategoria(novaCategoria);
	}
	
	@PutMapping
	public CategoriaDto atualizarCategoria(@PathVariable int id , @RequestBody CategoriaDto categoriaAtualizada) {
		return categoriaService.atualizarCategoria(id, categoriaAtualizada);
	}
	
	@DeleteMapping
	public void removerCategoria(@RequestParam int id) {
		categoriaService.removerCategoria(id);
	}
}
