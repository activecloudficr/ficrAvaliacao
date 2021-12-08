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

import com.ficr.avaliacao.model.Empregado;
import com.ficr.avaliacao.repository.EmpregadoRepository;

@RestController
@RequestMapping("/empregados")
public class EmpregadoController {

	@Autowired
	private EmpregadoRepository erp;

	@GetMapping("/empregados")
	public List<Empregado> list() {
		return erp.findAll();
	}

	@GetMapping("/empregados/{matricula}")
	public Optional<Empregado> showEmpregado(@PathVariable Long matricula) {
		return erp.findById(matricula);

	}

	@PostMapping("/empregado")
	public Empregado addEmpregado(@RequestBody Empregado empregado) {
		return erp.save(empregado);

	}

	@PutMapping("/empregado")
	public void updateEmpregado(@RequestBody Empregado empregado) {
		if (empregado.getMatricula() > 0) {
			erp.save(empregado);
		}

	}

	@DeleteMapping("/empregados/{matricula}")
	public void deletarEmpregado(@PathVariable Long matricula) {
		erp.deleteById(matricula);
	}

}
