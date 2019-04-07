package edu.planner.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import edu.planner.models.Turma;

public interface ITurmaRepo extends PagingAndSortingRepository<Turma, Integer> {

	public Page<Turma> findByNomeContaining(Pageable page, String descricao);
}