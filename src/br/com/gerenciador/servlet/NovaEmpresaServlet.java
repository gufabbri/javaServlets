package br.com.gerenciador.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.gerenciador.modelo.Banco;
import br.com.gerenciador.modelo.Empresa;

/**
 * Servlet implementation class NovaEmpresaServlet
 */
//@WebServlet("/novaEmpresa")
public class NovaEmpresaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("Cadastrando nova Empresa");
		
/*leitura de parametros*/		String nomeEmpresa = request.getParameter("nome");//pega o parametro enviado pela requisição do browser
								String paramDataEmpresa = request.getParameter("data");
		
		Date dataAbertura = null;
		
/*parsing*/		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			dataAbertura = sdf.parse(paramDataEmpresa);
		} catch (ParseException e) {
			throw new ServletException(e); //vai levar a exceção original CATCH AND RETHROW
		}
		
/*populando o modelo*/		Empresa empresa = new Empresa(); //cria uma empresa
							empresa.setNome(nomeEmpresa);
							empresa.setDataAbertura(dataAbertura);
		
		Banco banco = new Banco();
		banco.adiciona(empresa);
		
		request.setAttribute("empresa", empresa.getNome());
		response.sendRedirect("listaEmpresas");
		
		//chamar o JSP
		
//		RequestDispatcher rd = request.getRequestDispatcher("/listaEmpresas");
//		request.setAttribute("empresa", empresa.getNome()); //coloca o atributo na requisição
//		rd.forward(request, response);
		//método para empurrar
		
	}

}
