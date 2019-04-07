package edu.planner.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import edu.planner.models.Curso;

public interface ICursoRepo extends PagingAndSortingRepository<Curso, Integer> {

	public Page<Curso> findByNomeContaining(Pageable page, String descricao);
}