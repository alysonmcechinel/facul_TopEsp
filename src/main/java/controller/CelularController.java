package controller;

import java.io.IOException;

import dao.CelularDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Celular;

@WebServlet(name = "Celular", urlPatterns = {"/CelularController"})
	public class CelularController extends HttpServlet {
	    private static String INSERT_OR_EDIT = "/CadastroCelular.jsp";
	    private static String LIST = "/listarCelular.jsp";
	    private CelularDAO dao;
		
	    
	    public CelularController() {
	        super();
	        dao = new CelularDAO();
	    }
	    
	    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        String forward="";
	        String action = request.getParameter("action");

	        if (action.equalsIgnoreCase("delete")){
	            int id = Integer.parseInt(request.getParameter("celularid"));
	            dao.deleteCelular(id);
	            forward = LIST;
	            request.setAttribute("celular", dao.getAllCelular());    
	        } else if (action.equalsIgnoreCase("edit")){
	            forward = INSERT_OR_EDIT;
	            int id = Integer.parseInt(request.getParameter("celularid"));
	            Celular celular = dao.getCelularById(id);
	            request.setAttribute("celular", celular);
	        } else if (action.equalsIgnoreCase("list")){
	            forward = LIST;
	            request.setAttribute("celular", dao.getAllCelular());    
	            
	        } else {
	            forward = INSERT_OR_EDIT;
	        }

	        RequestDispatcher view = request.getRequestDispatcher(forward);
	        view.forward(request, response);
	    }
	    
	    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        Celular celular = new Celular();
	        
	        celular.setNome(request.getParameter("nome"));
	        celular.setMarca(request.getParameter("marca"));
	        celular.setCor(request.getParameter("cor"));
	        celular.setTela(request.getParameter("tela"));
	        celular.setMemoria(request.getParameter("memoria"));
	        celular.setPreco(request.getParameter("preco"));
	        
	       
	        String id = request.getParameter("celularid");
	        if(id == null || id.isEmpty())
	        {
	            dao.addCelular(celular);
	        }
	        else
	        {
	            celular.setId(Integer.parseInt(id));
	            dao.updateCelular(celular);
	        }
	        RequestDispatcher view = request.getRequestDispatcher(INSERT_OR_EDIT);
	        request.setAttribute("celular", dao.getAllCelular());
	        view.forward(request, response);
	    }
}
