package jv.triersistemas.desafio_dados.controller;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jv.triersistemas.desafio_dados.dto.DadoDto;
import jv.triersistemas.desafio_dados.service.DadoService;

@RestController
@RequestMapping("/dados")
public class DadoController {

	@Autowired
	private DadoService dadoService;

	@PostMapping
	public String adicionarAposta(@RequestBody DadoDto novaApost) {
		int valorMaximo = novaApost.getQntdDados() * 6;
		if(novaApost.getQntdDados() >1 && novaApost.getQntdDados() <= 4) {
			if(novaApost.getValorAposta() > valorMaximo) {
				return "O valor máximo da aposta tem que ser " + valorMaximo;
			}
			return "Aposta feita com sucesso: " + dadoService.adicionarAposta(novaApost);
		}else {
			throw new IllegalArgumentException("O número máximo de dados lançados não pode ser maior que 4 e nem menor que 1");
		}
	}

	@GetMapping
	public String resultadoaposta(DadoDto aposta) {
		DecimalFormat df = new DecimalFormat("#.00");
		aposta = dadoService.resultadoAposta();
		int totalSoma = 0;
		List<Integer> listaDados = new ArrayList<Integer>();
		Random aleatorio = new Random();
		for (int i = 0; i < aposta.getQntdDados(); i++) {
			int num = aleatorio.nextInt(6) + 1;
			listaDados.add(num);
			totalSoma += num;
		}

		double percentual = ((double) totalSoma / aposta.getValorAposta()) * 100;
		return "Resultado dos Dados: " + listaDados.toString() + "\n Total Soma:" + totalSoma + "\n Percentual: "
				+ df.format(percentual) + "%";
	}
}
