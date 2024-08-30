package jv.triersistemas.primeiro_projeto.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import jv.triersistemas.primeiro_projeto.dto.CategoriaDto;
import jv.triersistemas.primeiro_projeto.entity.CategoriaEntity;
import jv.triersistemas.primeiro_projeto.repository.CategoriaRepository;
import jv.triersistemas.primeiro_projeto.service.CategoriaService;

@Service
public class CategoriaServiceImpl implements CategoriaService {

	@Autowired
	private CategoriaRepository repository;

	@Override
	public List<CategoriaDto> getTodasCategorias() {
		List<CategoriaEntity> categoriaAll = repository.findAll();
		return categoriaAll.stream().map(CategoriaDto::new).toList();
	}

	@Override
	public Optional<CategoriaDto> getCategoriaPorId(int id) {
		Optional<CategoriaEntity> categoriaPorId = repository.findById(id);
		return categoriaPorId.map(CategoriaDto::new);
	}

	@Override
	public CategoriaDto adicionarCategoria(CategoriaDto novaCategoria) {
		CategoriaEntity entidadePersistida = repository.save(new CategoriaEntity(novaCategoria));
		return new CategoriaDto(entidadePersistida);
	}

	@Override
	public CategoriaDto atualizarCategoria(int id, CategoriaDto categoriaAtualizada) {
		Optional<CategoriaEntity> categoriaEntity = repository.findById(id);
		if (categoriaEntity.isPresent()) {
			categoriaEntity.get().atualizaTarefa(categoriaAtualizada);
			var entidadePersistida = repository.save(categoriaEntity.get());
			return new CategoriaDto(entidadePersistida);
		}
		return null;
	}

	@Override
	public void removerCategoria(int id) {
		try {
			repository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new RuntimeException("Não é possível excluir a categoria. Existem tarefas associadas.");
		}
	}
}
