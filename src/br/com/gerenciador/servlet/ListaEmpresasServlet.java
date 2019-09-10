package br.com.gerenciador.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.gerenciador.modelo.Banco;
import br.com.gerenciador.modelo.Empresa;


@WebServlet("/listaEmpresas")
public class ListaEmpresasServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
  
	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		Banco banco = new Banco();
		List<Empresa> lista = banco.getEmpresas();
		
		//PrintWriter out = response.getWriter();//PrintWriter escreve o html no navegador
		
		RequestDispatcher rd =  request.getRequestDispatcher("/listaEmpresas.jsp");
		
		request.setAttribute("empresas", lista );//o serlet vai ler as empresas e colocar o atributo dentro da requisição
		// essa é a ligação entra a requisição, lista, jsp
		rd.forward(request, response);
		
		
		
	}

}
