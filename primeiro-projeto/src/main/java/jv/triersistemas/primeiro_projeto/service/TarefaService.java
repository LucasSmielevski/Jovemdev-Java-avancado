package jv.triersistemas.primeiro_projeto.service;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import jv.triersistemas.primeiro_projeto.dto.CategoriaDto;
import jv.triersistemas.primeiro_projeto.dto.TarefaDto;
import jv.triersistemas.primeiro_projeto.entity.CategoriaEntity;
import jv.triersistemas.primeiro_projeto.entity.TarefaEntity;

public interface TarefaService {
	
	List<TarefaDto> getTodasTarefas();
	
	Optional<TarefaDto> getTarefaPorId(@RequestParam Long id);
	
	List<TarefaDto> buscarTarefasIncompletasPorCategoria(int categoriaId) ;
	 
    List<TarefaDto> buscarTarefaPorTitulo(String titulo);

	TarefaDto adicionarTarefa(@RequestBody TarefaDto novaTarefa, CategoriaDto categoriaDto);
	
	TarefaDto atualizarTarefa( Long id, TarefaDto tarefaAtualizada);
	
	void removerTarefa(@RequestParam Long id); 
}
