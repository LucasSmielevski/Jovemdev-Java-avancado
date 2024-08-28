package jv.triersistemas.primeiro_projeto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import jv.triersistemas.primeiro_projeto.dto.TarefaDto;
import jv.triersistemas.primeiro_projeto.entity.TarefaEntity;
import jv.triersistemas.primeiro_projeto.service.TarefaService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tarefa")
public class TarefaController {

	@Autowired
	private TarefaService tarefaService;

	@GetMapping
	public List<TarefaEntity> getTodasTarefas() {
		return tarefaService.getTodasTarefas();
	}

	@GetMapping("/{id}")
	public TarefaDto getTarefaPorId(@PathVariable Long id) {
		Optional<TarefaDto> tarefa = tarefaService.getTarefaPorId(id);
		return tarefa.orElse(null);
	}

	@PostMapping
	public TarefaDto adicionarTarefa(@RequestBody TarefaDto novaTarefa) {
		return tarefaService.adicionarTarefa(novaTarefa);
	}

	@PutMapping("/{id}")
	public TarefaDto atualizarTarefa(@PathVariable Long id, @RequestBody TarefaDto tarefaAtualizada) {
		return tarefaService.atualizarTarefa(id, tarefaAtualizada);
	}

	@DeleteMapping("/{id}")
	public void removerTarefa(@PathVariable Long id) {
		tarefaService.removerTarefa(id);
	}
}
