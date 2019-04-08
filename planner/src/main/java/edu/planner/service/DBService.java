package edu.planner.service;

import java.text.ParseException;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.planner.models.Privilegio;
import edu.planner.repositories.IPrivilegioRepo;

@Service
public class DBService {

	@Autowired
	private IPrivilegioRepo iPrivilegioRepo;

	public void instantiateTestDatabase() throws ParseException {
		Privilegio priv1 = new Privilegio();
		priv1.setNome("Cadastrar coordenador");

		Privilegio priv2 = new Privilegio();
		priv2.setNome("Cadastrar professor");

		Privilegio priv3 = new Privilegio();
		priv3.setNome("Cadastrar administrador");

		Privilegio priv4 = new Privilegio();
		priv4.setNome("Remover permissões de administrador");

		Privilegio priv5 = new Privilegio();
		priv5.setNome("Remover permissões de coordenador");

		Privilegio priv6 = new Privilegio();
		priv6.setNome("Remover permissões de professor");

		Privilegio priv7 = new Privilegio();
		priv7.setNome("Remover usuário");

		iPrivilegioRepo.saveAll(Arrays.asList(priv1, priv2, priv3, priv4, priv5, priv6, priv7));
	}
}