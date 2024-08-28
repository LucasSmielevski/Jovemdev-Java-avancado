package jv.triersistemas.desafio_dados.service.impl;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.stereotype.Service;

import jv.triersistemas.desafio_dados.dto.DadoDto;
import jv.triersistemas.desafio_dados.service.DadoService;

@Service
public class DadoServiceImpl implements DadoService {

	private static DadoDto dado = new DadoDto();

	@Override
	public String adicionarAposta(DadoDto novaAposta) {
		int valorMaximo = novaAposta.getQntdDados() * 6;
		if (novaAposta.getQntdDados() > 1 && novaAposta.getQntdDados() <= 4) {
			if (novaAposta.getValorAposta() > valorMaximo) {
				return "O valor máximo da aposta tem que ser " + valorMaximo;
			}
			DecimalFormat df = new DecimalFormat("#.00");
			int totalSoma = 0;
			List<Integer> listaDados = new ArrayList<Integer>();
			Random aleatorio = new Random();
			for (int i = 0; i < novaAposta.getQntdDados(); i++) {
				int num = aleatorio.nextInt(6) + 1;
				listaDados.add(num);
				totalSoma += num;
			}

			double percentual = ((double) totalSoma / novaAposta.getValorAposta()) * 100;
			return "Resultado dos Dados: " + listaDados.toString() + "\n Total Soma:" + totalSoma + "\n Percentual: "
					+ df.format(percentual) + "%";
		} else {
			throw new IllegalArgumentException(
					"O número máximo de dados lançados não pode ser maior que 4 e nem menor que 1");
		}
	}

}
