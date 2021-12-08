package com.ficr.avaliacao.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ficr.avaliacao.model.Treinamento;
import com.ficr.avaliacao.repository.TreinamentoRepository;

@RestController
@RequestMapping("/treinamentos")
public class TreinamentoController {

	@Autowired
	private TreinamentoRepository trp;

	@GetMapping("/treinamentos")
	public List<Treinamento> listTreinamentos() {
		return trp.findAll();

	}

	@GetMapping("/treinamento/{codigo}")
	public Optional<Treinamento> showTreinamento(@PathVariable Long codigo) {
		return trp.findById(codigo);

	}

	@PostMapping("/treinamento")
	public Treinamento addTreinamento(@RequestBody Treinamento treinamento) {
		return trp.save(treinamento);

	}

	@PutMapping("/treinamento")
	public void updateTreinamento(@RequestBody Treinamento treinamento) {
		if (treinamento.getCodigo() > 0) {
			trp.save(treinamento);
		}

	}

	@DeleteMapping("/treinamento/{codigo}")
	public void deletarTreinamento(@PathVariable Long codigo) {
		trp.deleteById(codigo);

	}

}
