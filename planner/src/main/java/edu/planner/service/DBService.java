package edu.planner.service;

import java.text.ParseException;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import edu.planner.enums.Perfil;
import edu.planner.enums.Titulacao;
import edu.planner.models.Privilegio;
import edu.planner.models.Usuario;
import edu.planner.repositories.IPrivilegioRepo;
import edu.planner.repositories.IUsuarioRepo;

@Service
public class DBService {

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Autowired
	private IPrivilegioRepo iPrivilegioRepo;

	@Autowired
	private IUsuarioRepo iUsuarioRepo;

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

		Usuario user1 = new Usuario();
		user1.setNome("Jair Rodrigo");
		user1.setEmail("rodrigoes@outlook.com");
		user1.setTitulacao(Titulacao.MESTRE);
		user1.setHashKey(bCryptPasswordEncoder.encode("1234"));
		user1.addPerfil(Perfil.ADMIN);
		user1.addPerfil(Perfil.COORDENADOR);

		Usuario user2 = new Usuario();
		user2.setNome("Vitor Silva");
		user2.setEmail("vitao@outlook.com");
		user2.setTitulacao(Titulacao.DOUTOR);
		user2.setHashKey(bCryptPasswordEncoder.encode("hueBR"));
		user2.addPerfil(Perfil.PROFESSOR);

		iUsuarioRepo.saveAll(Arrays.asList(user1, user2));
	}
}