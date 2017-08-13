package control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.DBclientes;

/**
 * Servlet implementation class ClientesControle
 */
@WebServlet("/ClientesControle")
public class ClientesControle extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClientesControle() {
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
		String nome = request.getParameter("nome");
		String tipo = request.getParameter("tipo");
		String vendedor = request.getParameter("vendedor");
		String limite = request.getParameter("limite");
		String excluir = request.getParameter("excluir");
		String update = request.getParameter("update");
		
		if(excluir==null&&update==null) {
			System.out.println("Entrou insere");
			if(nome==""|| tipo =="" || limite == "" ) {
				RequestDispatcher dispatcher = request.getRequestDispatcher("Index.jsp");
				dispatcher.forward(request, response);
			}else {
				try {
				    Float f = Float.parseFloat(limite);
				    if(vendedor.equals("NenhumVendedor"))
				    	vendedor = "NULL";
				    DBclientes.insereCliente("uuid()", nome, tipo, vendedor, limite);
				    RequestDispatcher dispatcher = request.getRequestDispatcher("Index.jsp");
				    response.sendRedirect("Index.jsp");
				    } catch (NumberFormatException ex) {
				    	RequestDispatcher dispatcher = request.getRequestDispatcher("Index.jsp");
						dispatcher.forward(request, response);
				    }     
			}
		}
		if(update!=null){
			System.out.println("Entrou update");
			if(nome==""|| tipo =="" || limite == "" ) {
				RequestDispatcher dispatcher = request.getRequestDispatcher("Index.jsp");
				dispatcher.forward(request, response);
			}else {
				try {
				    Float f = Float.parseFloat(limite);
				    if(vendedor.equals("NenhumVendedor"))
				    	DBclientes.updateCliente(update,nome, tipo, "null", limite);
				    DBclientes.updateCliente(update,nome, tipo, vendedor, limite);
				    
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
			DBclientes.excluiCliente(excluir);
			RequestDispatcher dispatcher = request.getRequestDispatcher("Index.jsp");
			response.sendRedirect("Index.jsp");
		}
	}

}
