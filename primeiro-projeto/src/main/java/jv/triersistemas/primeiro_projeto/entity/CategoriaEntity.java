package jv.triersistemas.primeiro_projeto.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jv.triersistemas.primeiro_projeto.dto.CategoriaDto;
import jv.triersistemas.primeiro_projeto.enums.PrioridadeEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity(name =  "categoria")
public class CategoriaEntity {
	
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private int id;
	
	private String nome;
	private String descricao;
	
	@Enumerated(EnumType.ORDINAL)
	private PrioridadeEnum prioridade;
	
	@OneToMany(mappedBy = "categoria", cascade = CascadeType.DETACH)
	private List<TarefaEntity> tarefas;
	
	public CategoriaEntity(CategoriaDto dto) {
		this.id = dto.getId();
		this.nome = dto.getNome();
		this.descricao = dto.getDescricao();
		this.prioridade= dto.getPrioridade();
		this.tarefas = dto.getTarefas();
	}
	
    public CategoriaEntity atualizaTarefa(CategoriaDto dto) {
    	this.nome = dto.getNome();
    	this.descricao = dto.getDescricao();
    	this.prioridade = dto.getPrioridade();
    	return this;
    }
}
