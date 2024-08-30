package jv.triersistemas.primeiro_projeto.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
import jv.triersistemas.primeiro_projeto.dto.TarefaDto;
import jv.triersistemas.primeiro_projeto.service.TarefaService;

@RestController
@RequestMapping("/tarefa")
public class TarefaController {

	@Autowired
	private TarefaService tarefaService;

	@GetMapping
	public List<TarefaDto> getTodasTarefas() {
		return tarefaService.getTodasTarefas();
	}

	@GetMapping("/{id}")
	public TarefaDto getTarefaPorId(@PathVariable Long id) {
		Optional<TarefaDto> tarefa = tarefaService.getTarefaPorId(id);
		return tarefa.orElse(null);
	}

	@GetMapping("/buscar")
	public List<TarefaDto> getTarefaPorTitulo(@RequestParam String titulo) {
		List<TarefaDto> tarefa = tarefaService.buscarTarefaPorTitulo(titulo);
		return tarefa;
	}

	@GetMapping("/incompletas/categoria/{categoriaId}")
	public List<TarefaDto> buscarTarefasIncompletasPorCategoria(@PathVariable int categoriaId) {
		List<TarefaDto> tarefas = tarefaService.buscarTarefasIncompletasPorCategoria(categoriaId);
		return tarefas;
	}

	@PostMapping
	public TarefaDto adicionarTarefa(@RequestBody TarefaDto novaTarefa, CategoriaDto categoriaDto) {
		return tarefaService.adicionarTarefa(novaTarefa, categoriaDto);
	}

	@PutMapping("/{id}")
	public TarefaDto atualizarTarefa(@PathVariable Long id, @RequestBody TarefaDto tarefaAtualizada) {
		return tarefaService.atualizarTarefa(id, tarefaAtualizada);
	}

	@DeleteMapping
	public void removerTarefa(@RequestParam Long id) {
		tarefaService.removerTarefa(id);
	}
}
