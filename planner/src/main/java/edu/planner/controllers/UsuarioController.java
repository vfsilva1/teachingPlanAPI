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

import edu.planner.models.Usuario;
import edu.planner.service.UsuarioService;

@RestController
@RequestMapping("api/usuario")
public class UsuarioController implements IController<Usuario> {

	@Autowired
	UsuarioService usuarioService;

	@Override
	@PostMapping
	public ResponseEntity<Usuario> insert(@RequestBody Usuario usuario) {
		usuario = usuarioService.insert(usuario);
		return usuario != null ? ResponseEntity.ok(usuario) : ResponseEntity.noContent().build();
	}

	@Override
	@PutMapping
	public ResponseEntity<Usuario> update(@RequestBody Usuario usuario) {
		usuario = usuarioService.update(usuario);
		return usuario != null ? ResponseEntity.ok(usuario) : ResponseEntity.noContent().build();
	}

	@Override
	@DeleteMapping("{id}")
	public ResponseEntity<Boolean> delete(@PathVariable int id) {
		Boolean retorno = usuarioService.delete(id);
		return retorno ? ResponseEntity.ok(retorno) : ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	}

	@GetMapping("/intervalo/{page}/{count}/{descricao}")
	public ResponseEntity<Page<Usuario>> findPageable(@PathVariable("page") int page, @PathVariable("count") int count,
			@PathVariable("descricao") String descricao) {
		Page<Usuario> usuario = usuarioService.findPageable(page, count, descricao);
		return usuario != null ? ResponseEntity.ok(usuario) : ResponseEntity.noContent().build();
	}
}