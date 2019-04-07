package edu.planner.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import edu.planner.models.TipoUsuario;

public interface ITipoUsuarioRepo extends PagingAndSortingRepository<TipoUsuario, Integer> {

	public Page<TipoUsuario> findByNomeContaining(Pageable page, String descricao);
}