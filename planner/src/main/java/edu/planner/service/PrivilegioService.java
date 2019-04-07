package edu.planner.service;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import edu.planner.exception.BusinessException;
import edu.planner.exception.ErrorCode;
import edu.planner.models.Privilegio;
import edu.planner.repositories.IPrivilegioRepo;

@Service
public class PrivilegioService implements IService<Privilegio> {

	@Autowired
	IPrivilegioRepo iPrivilegioRepo;

	@Override
	public Privilegio insert(Privilegio privilegio) {
		Privilegio privilegioIncluido = null;
		try {
			privilegioIncluido = iPrivilegioRepo.save(privilegio);
		} catch (Exception e) {
			throw new BusinessException(ErrorCode.PRIVILEGIO_SAVE, e);
		}
		return privilegioIncluido;
	}

	@Override
	public Privilegio update(Privilegio privilegio) {
		Privilegio privilegioAlterado = null;
		try {
			privilegioAlterado = iPrivilegioRepo.save(privilegio);
		} catch (Exception e) {
			throw new BusinessException(ErrorCode.PRIVILEGIO_UPDATE, e);
		}
		return privilegioAlterado;
	}

	@Override
	public Boolean delete(int id) {
		Boolean retorno = false;

		try {
			iPrivilegioRepo.deleteById(id);
			retorno = true;
		} catch (ConstraintViolationException e) {
			throw new BusinessException(ErrorCode.PRIVILEGIO_DELETE_VIOLATION, e);
		} catch (Exception e) {
			throw new BusinessException(ErrorCode.PRIVILEGIO_DELETE, e);
		}
		return retorno;
	}

	public Page<Privilegio> findPageable(int page, int count, String descricao) {
		Page<Privilegio> privilegio = null;
		try {
			privilegio = iPrivilegioRepo.findByNomeContaining(PageRequest.of(page, count), descricao);
		} catch (Exception e) {
			throw new BusinessException(ErrorCode.PRIVILEGIO_SEARCH, e);
		}

		return privilegio;
	}
}