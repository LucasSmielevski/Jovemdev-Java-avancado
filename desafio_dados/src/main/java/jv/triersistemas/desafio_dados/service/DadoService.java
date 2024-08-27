package jv.triersistemas.desafio_dados.service;

import java.util.Optional;

import jv.triersistemas.desafio_dados.dto.DadoDto;

public interface DadoService {
	DadoDto adicionarAposta(DadoDto novaApost);
	DadoDto resultadoAposta();
}
