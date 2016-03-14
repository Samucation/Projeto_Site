package br.com.siteTeste.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//Manipula os Servlets
//O chamado irá tepender do nome colocando no @WebServlet por exemplo.
//http://localhost:8080/ProjetoSite/usucontroller.do

@WebServlet("/usucontroller.do")
public class UsuarioControler extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("chamou!");
	}

}
