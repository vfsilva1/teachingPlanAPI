package edu.planner.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.planner.models.Turma;
import edu.planner.service.TurmaService;

@RestController
@RequestMapping("api/turma")
public class TurmaController implements IController<Turma> {

	@Autowired
	TurmaService turmaService;

	@Override
	@PostMapping
	public ResponseEntity<Turma> insert(@RequestBody Turma turma) {
		turma = turmaService.insert(turma);
		return turma != null ? ResponseEntity.ok(turma) : ResponseEntity.noContent().build();
	}

	@Override
	@PutMapping
	public ResponseEntity<Turma> update(@RequestBody Turma turma) {
		turma = turmaService.update(turma);
		return turma != null ? ResponseEntity.ok(turma) : ResponseEntity.noContent().build();
	}

	@Override
	@DeleteMapping("{id}")
	public ResponseEntity<Boolean> delete(@PathVariable int id) {
		Boolean retorno = turmaService.delete(id);
		return retorno ? ResponseEntity.ok(retorno) : ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	}

	@GetMapping("/intervalo/{page}/{count}/{descricao}")
	public ResponseEntity<Page<Turma>> findPageable(@PathVariable("page") int page, @PathVariable("count") int count,
			@PathVariable("descricao") String descricao) {
		Page<Turma> turma = turmaService.findPageable(page, count, descricao);
		return turma != null ? ResponseEntity.ok(turma) : ResponseEntity.noContent().build();
	}
}