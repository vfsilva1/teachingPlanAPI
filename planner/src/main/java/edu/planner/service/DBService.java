package edu.planner.service;

import java.text.ParseException;

import org.springframework.stereotype.Service;

import edu.planner.models.Privilegio;

@Service
public class DBService {

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

	        
	}
}