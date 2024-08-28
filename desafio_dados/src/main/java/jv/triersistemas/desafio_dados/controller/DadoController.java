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
		return dadoService.adicionarAposta(novaApost);

	}
}
