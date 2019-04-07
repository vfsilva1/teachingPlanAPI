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

import edu.planner.models.Curso;
import edu.planner.service.CursoService;

@RestController
@RequestMapping("api/curso")
public class CursoController implements IController<Curso> {

	@Autowired
	CursoService cursoService;

	@Override
	@PostMapping
	public ResponseEntity<Curso> insert(@RequestBody Curso curso) {
		curso = cursoService.insert(curso);
		return curso != null ? ResponseEntity.ok(curso) : ResponseEntity.noContent().build();
	}

	@Override
	@PutMapping
	public ResponseEntity<Curso> update(@RequestBody Curso curso) {
		curso = cursoService.update(curso);
		return curso != null ? ResponseEntity.ok(curso) : ResponseEntity.noContent().build();
	}

	@Override
	@DeleteMapping("{id}")
	public ResponseEntity<Boolean> delete(@PathVariable int id) {
		Boolean retorno = cursoService.delete(id);
		return retorno ? ResponseEntity.ok(retorno) : ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	}

	@GetMapping("/intervalo/{page}/{count}/{descricao}")
	public ResponseEntity<Page<Curso>> findPageable(@PathVariable("page") int page, @PathVariable("count") int count,
			@PathVariable("descricao") String descricao) {
		Page<Curso> curso = cursoService.findPageable(page, count, descricao);
		return curso != null ? ResponseEntity.ok(curso) : ResponseEntity.noContent().build();
	}
}