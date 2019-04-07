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

import edu.planner.models.TipoUsuario;
import edu.planner.service.TipoUsuarioService;

@RestController
@RequestMapping("api/tipoUsuario")
public class TipoUsuarioController implements IController<TipoUsuario> {

	@Autowired
	TipoUsuarioService tipoUsuarioService;

	@Override
	@PostMapping
	public ResponseEntity<TipoUsuario> insert(@RequestBody TipoUsuario tipoUsuario) {
		tipoUsuario = tipoUsuarioService.insert(tipoUsuario);
		return tipoUsuario != null ? ResponseEntity.ok(tipoUsuario) : ResponseEntity.noContent().build();
	}

	@Override
	@PutMapping
	public ResponseEntity<TipoUsuario> update(@RequestBody TipoUsuario tipoUsuario) {
		tipoUsuario = tipoUsuarioService.update(tipoUsuario);
		return tipoUsuario != null ? ResponseEntity.ok(tipoUsuario) : ResponseEntity.noContent().build();
	}

	@Override
	@DeleteMapping("{id}")
	public ResponseEntity<Boolean> delete(@PathVariable int id) {
		Boolean retorno = tipoUsuarioService.delete(id);
		return retorno ? ResponseEntity.ok(retorno) : ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	}

	@GetMapping("/intervalo/{page}/{count}/{descricao}")
	public ResponseEntity<Page<TipoUsuario>> findPageable(@PathVariable("page") int page, @PathVariable("count") int count,
			@PathVariable("descricao") String descricao) {
		Page<TipoUsuario> tipoUsuario = tipoUsuarioService.findPageable(page, count, descricao);
		return tipoUsuario != null ? ResponseEntity.ok(tipoUsuario) : ResponseEntity.noContent().build();
	}
}