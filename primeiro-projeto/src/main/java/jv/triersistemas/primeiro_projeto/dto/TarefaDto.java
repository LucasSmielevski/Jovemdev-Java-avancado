package jv.triersistemas.primeiro_projeto.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import jv.triersistemas.primeiro_projeto.entity.CategoriaEntity;
import jv.triersistemas.primeiro_projeto.entity.TarefaEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TarefaDto {
	private Long id;
	private String titulo;
	private String descricao;
	private Boolean completa;
	private int idCategoria;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private LocalDate dataCriacao;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private LocalDate dataExpiracao;
	
	public TarefaDto(TarefaEntity entity) {
		this.id = entity.getId();
		this.titulo = entity.getTitulo();
		this.descricao = entity.getDescricao();
		this.completa = entity.getCompleta();
		this.idCategoria = entity.getCategoria().getId();
		this.dataCriacao = entity.getDataCriacao();
		this.dataExpiracao = entity.getDataExpiracao();
	}
}
