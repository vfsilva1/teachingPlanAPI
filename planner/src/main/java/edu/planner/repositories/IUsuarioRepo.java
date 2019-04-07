package edu.planner.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import edu.planner.models.Usuario;

public interface IUsuarioRepo extends PagingAndSortingRepository<Usuario, Integer> {

	public Page<Usuario> findByNomeContaining(Pageable page, String descricao);
}