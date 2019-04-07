package edu.planner.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import edu.planner.models.Disciplina;

public interface IDisciplinaRepo extends PagingAndSortingRepository<Disciplina, Integer> {

	public Page<Disciplina> findByNomeContaining(Pageable page, String descricao);
}