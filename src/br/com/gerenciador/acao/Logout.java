package br.com.gerenciador.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Logout implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession sessao = request.getSession();
		sessao.invalidate();//remove o objeto httpsession e destroi o cookie
		//sessao.removeAttribute("usuarioLogado");

		return "redirect:entrada?acao=LoginForm";
	}

}
