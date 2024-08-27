package jv.triersistemas.desafio_dados.service.impl;

import java.util.Optional;

import org.springframework.stereotype.Service;

import jv.triersistemas.desafio_dados.dto.DadoDto;
import jv.triersistemas.desafio_dados.service.DadoService;

@Service
public class DadoServiceImpl implements DadoService{

	private static DadoDto dado = new DadoDto();

	@Override
	public DadoDto adicionarAposta(DadoDto novaApost) {
		return dado = novaApost;
	}

	@Override
	public DadoDto resultadoAposta() {
		return dado;
	}

}
