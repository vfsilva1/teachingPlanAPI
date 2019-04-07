package edu.planner.service;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import edu.planner.exception.BusinessException;
import edu.planner.exception.ErrorCode;
import edu.planner.models.Disciplina;
import edu.planner.repositories.IDisciplinaRepo;

@Service
public class DisciplinaService implements IService<Disciplina> {

	@Autowired
	IDisciplinaRepo iDisciplinaRepo;

	@Override
	public Disciplina insert(Disciplina disciplina) {
		Disciplina disciplinaIncluido = null;
		try {
			disciplinaIncluido = iDisciplinaRepo.save(disciplina);
		} catch (Exception e) {
			throw new BusinessException(ErrorCode.CURSO_SAVE, e);
		}
		return disciplinaIncluido;
	}

	@Override
	public Disciplina update(Disciplina disciplina) {
		Disciplina disciplinaAlterado = null;
		try {
			disciplinaAlterado = iDisciplinaRepo.save(disciplina);
		} catch (Exception e) {
			throw new BusinessException(ErrorCode.CURSO_UPDATE, e);
		}
		return disciplinaAlterado;
	}

	@Override
	public Boolean delete(int id) {
		Boolean retorno = false;

		try {
			iDisciplinaRepo.deleteById(id);
			retorno = true;
		} catch (ConstraintViolationException e) {
			throw new BusinessException(ErrorCode.CURSO_DELETE_VIOLATION, e);
		} catch (Exception e) {
			throw new BusinessException(ErrorCode.CURSO_DELETE, e);
		}
		return retorno;
	}

	public Page<Disciplina> findPageable(int page, int count, String descricao) {
		Page<Disciplina> disciplina = null;
		try {
			disciplina = iDisciplinaRepo.findByNomeContaining(PageRequest.of(page, count), descricao);

		} catch (Exception e) {
			throw new BusinessException(ErrorCode.CURSO_SEARCH, e);
		}

		return disciplina;
	}
}