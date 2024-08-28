package jv.triersistemas.desafio_dados.service.impl;

import java.util.Optional;

import org.springframework.stereotype.Service;

import jv.triersistemas.desafio_dados.dto.DadoDto;
import jv.triersistemas.desafio_dados.service.DadoService;

@Service
public class DadoServiceImpl implements DadoService{

	private static DadoDto dado = new DadoDto();

	@Override
	public String adicionarAposta(DadoDto novaApost) {
		int valorMaximo = novaApost.getQntdDados() * 6;
		if(novaApost.getQntdDados() >1 && novaApost.getQntdDados() <= 4) {
			if(novaApost.getValorAposta() > valorMaximo) {
				return "O valor máximo da aposta tem que ser " + valorMaximo;
			}
			return "Aposta feita com sucesso: " + dadoService.adicionarAposta(novaApost);
		}else {
			throw new IllegalArgumentException("O número máximo de dados lançados não pode ser maior que 4 e nem menor que 1");
		}
		return dado = novaApost;
	}

	@Override
	public DadoDto resultadoAposta() {
		return dado;
	}

}
