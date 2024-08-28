package jv.triersistemas.primeiro_projeto.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import jv.triersistemas.primeiro_projeto.dto.TarefaDto;
import jv.triersistemas.primeiro_projeto.service.TarefaService;

@Service
public class TarefaServiceImpl implements TarefaService{
	
    private static List<TarefaDto> listatarefas = new ArrayList<>();
    private static long contadorId = 1;
	
    @Override
	public List<TarefaDto> getTodasTarefas() {
		return listatarefas;
	}

	@Override
	public Optional<TarefaDto> getTarefaPorId(Long id) {
		 return listatarefas.stream().filter(t -> t.getId().equals(id)).findFirst();
	}

	@Override
	public TarefaDto adicionarTarefa(TarefaDto novaTarefa) {
        novaTarefa.setId(contadorId++);
        listatarefas.add(novaTarefa);
        return novaTarefa;
	}

	@Override
	public TarefaDto atualizarTarefa(Long id, TarefaDto tarefaAtualizada) {
		Optional<TarefaDto> tarefa = getTarefaPorId(id);
        if (tarefa.isPresent()) {
            tarefa.get().setTitulo(tarefaAtualizada.getTitulo());
            tarefa.get().setDescricao(tarefaAtualizada.getDescricao());
            tarefa.get().setCompleta(tarefaAtualizada.isCompleta());
            return tarefa.get();
        }
        return null;
	}

	@Override
	public boolean removerTarefa(Long id) {
        return listatarefas.removeIf(t -> t.getId().equals(id));
	}
}
