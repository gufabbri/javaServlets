package br.com.gerenciador.acao;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.gerenciador.modelo.Banco;
import br.com.gerenciador.modelo.Empresa;

public class NovaEmpresa {

	public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("Acao nova empresa");

		String nomeEmpresa = request.getParameter("nome");// pega o parametro enviado pela requisição do browser
		String paramDataEmpresa = request.getParameter("data");

		Date dataAbertura = null;

		/* parsing */ try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			dataAbertura = sdf.parse(paramDataEmpresa);
		} catch (ParseException e) {
			throw new ServletException(e); // vai levar a exceção original CATCH AND RETHROW
		}

		/* populando o modelo */ Empresa empresa = new Empresa(); // cria uma empresa
		empresa.setNome(nomeEmpresa);
		empresa.setDataAbertura(dataAbertura);

		Banco banco = new Banco();
		banco.adiciona(empresa);

		request.setAttribute("empresa", empresa.getNome());
		
		response.sendRedirect("entrada?acao=ListaEmpresas");

//chamar o JSP

//RequestDispatcher rd = request.getRequestDispatcher("/listaEmpresas");
//request.setAttribute("empresa", empresa.getNome()); //coloca o atributo na requisição
//rd.forward(request, response);
//método para empurrar

	}

}
