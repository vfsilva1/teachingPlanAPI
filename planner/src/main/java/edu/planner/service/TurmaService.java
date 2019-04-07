package edu.planner.service;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import edu.planner.exception.BusinessException;
import edu.planner.exception.ErrorCode;
import edu.planner.models.Turma;
import edu.planner.repositories.ITurmaRepo;

@Service
public class TurmaService implements IService<Turma> {

	@Autowired
	ITurmaRepo iTurmaRepo;

	@Override
	public Turma insert(Turma turma) {
		Turma turmaIncluido = null;
		try {
			turmaIncluido = iTurmaRepo.save(turma);
		} catch (Exception e) {
			throw new BusinessException(ErrorCode.TURMA_SAVE, e);
		}
		return turmaIncluido;
	}

	@Override
	public Turma update(Turma turma) {
		Turma turmaAlterado = null;
		try {
			turmaAlterado = iTurmaRepo.save(turma);
		} catch (Exception e) {
			throw new BusinessException(ErrorCode.TURMA_UPDATE, e);
		}
		return turmaAlterado;
	}

	@Override
	public Boolean delete(int id) {
		Boolean retorno = false;

		try {
			iTurmaRepo.deleteById(id);
			retorno = true;
		} catch (ConstraintViolationException e) {
			throw new BusinessException(ErrorCode.TURMA_DELETE_VIOLATION, e);
		} catch (Exception e) {
			throw new BusinessException(ErrorCode.TURMA_DELETE, e);
		}
		return retorno;
	}

	public Page<Turma> findPageable(int page, int count, String descricao) {
		Page<Turma> turma = null;
		try {
			turma = iTurmaRepo.findByNomeContaining(PageRequest.of(page, count), descricao);
		} catch (Exception e) {
			throw new BusinessException(ErrorCode.TURMA_SEARCH, e);
		}

		return turma;
	}
}