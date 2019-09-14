package br.com.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

//@WebFilter("/entrada")/*todas as requests vao passar pelo filtro*/
public class MonitoramentoFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {//objeto chain: falar para dar continuidade na requisicao
	
		System.out.println("MonitoramentoFilter");
		
		long antes = System.currentTimeMillis();
		
		String acao = request.getParameter("acao");
		
		//se esse objeto n for chamado, a execução é parada
		chain.doFilter(request, response);
		
		long depois = System.currentTimeMillis();		
		System.out.println("tempo de execução da acao:" + acao + "-> " + (depois - antes));
		
	}

}
