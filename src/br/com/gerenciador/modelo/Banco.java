package br.com.gerenciador.modelo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Banco {
	
	private static List<Empresa> lista = new ArrayList<Empresa>();
	private static List<Usuario> listaUsuario = new ArrayList<Usuario>();
	private static Integer chaveSequencial = 1;
	
	static {
		Empresa empresa = new Empresa();
		empresa.setId(chaveSequencial++);
		empresa.setNome("Augusto");
		Empresa empresa2 = new Empresa();
		empresa2.setNome("TerraVegana");
		empresa2.setId(chaveSequencial++);
		lista.add(empresa);
		lista.add(empresa2);
		
		Usuario u1 = new Usuario();
		u1.setLogin("Augusto");
		u1.setSenha("12345");
		Usuario u2 = new Usuario();
		u2.setLogin("dani");
		u2.setSenha("12345");
		
		listaUsuario.add(u1);
		listaUsuario.add(u2);
		
	}

	public void adiciona(Empresa empresa) {
		empresa.setId(Banco.chaveSequencial++);
		Banco.lista.add(empresa);
		//System.out.println(lista.get(0));
	}
	
	public List<Empresa> getEmpresas(){
		return Banco.lista;
	}

	public void removeEmpresa(Integer id) {
		
		Iterator<Empresa> it = lista.iterator();
		
		while(it.hasNext()) {
			Empresa emp = it.next();
			
			if(emp.getId() == id) {
				it.remove();
			}
		}
		
	}

	public Empresa buscaEmpresaId(Integer id) {
		for (Empresa empresa : lista) {
			if(empresa.getId() == id) {
				return empresa;
			}
		}
		return null;
	}

	public Usuario existeUsuario(String login, String senha) {
		for(Usuario usuario : listaUsuario) {
			if(usuario.ehIgual(login, senha)) {
				return usuario;
			}
		}
		return null;
	}

}
