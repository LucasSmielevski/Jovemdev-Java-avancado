package jv.triersistemas.primeiro_projeto.controller;

import org.springframework.web.bind.annotation.*;

import jv.triersistemas.primeiro_projeto.Tarefa;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tarefa")
public class TarefaController {

    private static List<Tarefa> tarefas = new ArrayList<>();
    private static long contadorId = 1;


    @GetMapping
    public List<Tarefa> getTodasTarefas() {
        return tarefas;
    }

    @GetMapping("/{id}")
    public Tarefa getTarefaPorId(@RequestParam Long id) {
        Optional<Tarefa> tarefa = tarefas.stream().filter(t -> t.getId().equals(id)).findFirst();
        return tarefa.orElse(null);
    }

    @PostMapping
    public void adicionarTarefa(@RequestBody Tarefa novaTarefa) {
        novaTarefa.setId(contadorId++);
        tarefas.add(novaTarefa);
    }

    @PutMapping("/{id}")
    public void atualizarTarefa(@RequestParam Long id, @RequestBody Tarefa tarefaAtualizada) {
        Tarefa tarefa = getTarefaPorId(id);
        if (tarefa != null) {
            tarefa.setTitulo(tarefaAtualizada.getTitulo());
            tarefa.setDescricao(tarefaAtualizada.getDescricao());
            tarefa.setCompleta(tarefaAtualizada.isCompleta());
        }
    }

    @DeleteMapping("/{id}")
    public boolean removerTarefa(@RequestParam Long id) {
        return tarefas.removeIf(t -> t.getId().equals(id));
    }
}
