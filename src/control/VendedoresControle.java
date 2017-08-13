package control;

import java.io.IOException;
import java.util.ArrayList;

import database.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.DBclientes;
import model.Clientes;

/**
 * Servlet implementation class VendedoresControle
 */
@WebServlet("/VendedoresControle")
public class VendedoresControle extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VendedoresControle() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String dsnome = request.getParameter("dsnome");
		String cdtab = request.getParameter("cdtab");
		String dtnasc = request.getParameter("dtnasc");
		String update = request.getParameter("update");
		String excluir = request.getParameter("excluir");
		
		ArrayList<String> addClientes = new ArrayList<>();
		ArrayList<Clientes> clientes = DBclientes.pegarClientes();
		
		for(Clientes c : clientes){
			if(request.getParameter(c.getCdcl())!=null)
				addClientes.add(request.getParameter(c.getCdcl()));
		}
		
		if(excluir==null&&update==null) {
			if(dsnome==""|| cdtab =="" || dtnasc == "" ) {
				RequestDispatcher dispatcher = request.getRequestDispatcher("Index.jsp");
				dispatcher.forward(request, response);
			}else {
				try {
				    int i = Integer.parseInt(cdtab);
				    DBvendedores.insereVendedor("uuid()", dsnome, cdtab, dtnasc);
				    RequestDispatcher dispatcher = request.getRequestDispatcher("Index.jsp");
	
				    response.sendRedirect("Index.jsp");
				    } catch (NumberFormatException ex) {
				    	RequestDispatcher dispatcher = request.getRequestDispatcher("Index.jsp");
						dispatcher.forward(request, response);
				    }     
			}
		}
		if(update!=null) {
			if(dsnome==""|| cdtab =="" || dtnasc == "" ) {
				RequestDispatcher dispatcher = request.getRequestDispatcher("Index.jsp");
				dispatcher.forward(request, response);
			}else {
				try {
				    int i = Integer.parseInt(cdtab);
				    DBvendedores.updateVendedor(update, dsnome, cdtab, dtnasc);
				    for(String s : addClientes) {
				    	DBclientes.updateCliente(s,update);
				    }
				    RequestDispatcher dispatcher = request.getRequestDispatcher("Index.jsp");
	
				    response.sendRedirect("Index.jsp");
				    } catch (NumberFormatException ex) {
				    	RequestDispatcher dispatcher = request.getRequestDispatcher("Index.jsp");
						dispatcher.forward(request, response);
				    }     
			}

		}
		
		if(excluir!=null) {	
			System.out.println("Entrou excluir");
			DBvendedores.excluiVendedor(excluir);
			RequestDispatcher dispatcher = request.getRequestDispatcher("Index.jsp");
			response.sendRedirect("Index.jsp");
		}
		
	}

}
