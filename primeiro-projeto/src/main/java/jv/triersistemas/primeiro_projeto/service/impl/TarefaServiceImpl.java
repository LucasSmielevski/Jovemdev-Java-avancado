package jv.triersistemas.primeiro_projeto.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jv.triersistemas.primeiro_projeto.dto.CategoriaDto;
import jv.triersistemas.primeiro_projeto.dto.TarefaDto;
import jv.triersistemas.primeiro_projeto.entity.CategoriaEntity;
import jv.triersistemas.primeiro_projeto.entity.TarefaEntity;
import jv.triersistemas.primeiro_projeto.repository.CategoriaRepository;
import jv.triersistemas.primeiro_projeto.repository.TarefaRepository;
import jv.triersistemas.primeiro_projeto.service.TarefaService;

@Service
public class TarefaServiceImpl implements TarefaService {

	@Autowired
	private TarefaRepository repository;
	
	@Autowired
	private CategoriaServiceImpl categoriaServiceImpl;


	@Override
	public List<TarefaDto> getTodasTarefas() {
		List<TarefaEntity> entidadeAll = repository.findAll();
		return entidadeAll.stream().map(this::convertParaDto).toList();
	}

	@Override
	public Optional<TarefaDto> getTarefaPorId(Long id) {
		Optional<TarefaEntity> entidadePorId = repository.findById(id);
		return entidadePorId.map(this::convertParaDto);
	}

	@Override
	public TarefaDto adicionarTarefa(TarefaDto novaTarefa, CategoriaDto categoria) {
		Optional<CategoriaDto> categoriaEntidade = categoriaServiceImpl.getCategoriaPorId(categoria.getId());
		CategoriaDto categoriaDto = categoriaEntidade.get();
		
		TarefaEntity entidadePersistida = new TarefaEntity(novaTarefa);
		entidadePersistida.setCategoria(categoriaDto);
		repository.save(new TarefaEntity(novaTarefa));
		return new TarefaDto(entidadePersistida);
	}

	@Override
	public TarefaDto atualizarTarefa(Long id, TarefaDto tarefaAtualizada) {
		Optional<TarefaEntity> tarefa = repository.findById(id);
		if (tarefa.isPresent()) {
			tarefa.get().setTitulo(tarefaAtualizada.getTitulo());
			tarefa.get().setDescricao(tarefaAtualizada.getDescricao());
			tarefa.get().setCompleta(tarefaAtualizada.getCompleta());
			tarefa.get().setCategoria(tarefaAtualizada.getCategoria());
			TarefaEntity entidadeAtualizada = repository.save(tarefa.get());
			return new TarefaDto(entidadeAtualizada);
		}
		return null;
	}

	@Override
	public void removerTarefa(Long id) {
		 repository.deleteById(id);
	}
	
	
	private TarefaDto convertParaDto(TarefaEntity entity) {
		TarefaDto tarefaDto = new TarefaDto();
		tarefaDto.setId(entity.getId());
		tarefaDto.setTitulo(entity.getTitulo());
		tarefaDto.setDescricao(entity.getDescricao());
		tarefaDto.setCompleta(entity.getCompleta());
		return tarefaDto;
	}
}
