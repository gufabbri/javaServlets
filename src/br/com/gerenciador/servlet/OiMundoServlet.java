package br.com.gerenciador.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//oi
@WebServlet(urlPatterns="/oi") //url que responde
public class OiMundoServlet extends HttpServlet {
	
	//tomcat é um middleware, intermediario entre requisicoes e servlets
	
	public OiMundoServlet() {
		System.out.println("criando oi mundo servlet");
	}

	@Override // a requisiçao e resposta são apresentadas desses dois objetos abaixo
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException {

		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("Oi Mundo, PRIMEIRO SERVLET");
		out.println("</body>");
		out.println("</html>");
		
		System.out.println("o servlet OiMundoServlet foi chamado");

	}

}
