package controller;

import java.io.IOException;

import dao.AcessorioDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Acessorio;


@WebServlet(name = "Acessorio", urlPatterns = {"/AcessorioController"})
public class AcessorioController extends HttpServlet {
    private static String INSERT_OR_EDIT = "/CadastroAcessorio.jsp";
    private static String LIST = "/listarAcessorio.jsp";
    private AcessorioDAO dao;
	
    
    public AcessorioController() {
        super();
        dao = new AcessorioDAO();
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String forward="";
        String action = request.getParameter("action");

        if (action.equalsIgnoreCase("delete")){
            int id = Integer.parseInt(request.getParameter("acessorioid"));
            dao.deleteAcessorio(id);
            forward = LIST;
            request.setAttribute("acessorios", dao.getAllAcessorio());    
        } else if (action.equalsIgnoreCase("edit")){
            forward = INSERT_OR_EDIT;
            int id = Integer.parseInt(request.getParameter("acessorioid"));
            Acessorio acessorio = dao.getAcessorioById(id);
            request.setAttribute("acessorio", acessorio);
        } else if (action.equalsIgnoreCase("list")){
            forward = LIST;
            request.setAttribute("acessorios", dao.getAllAcessorio());    
            
        } else {
            forward = INSERT_OR_EDIT;
        }

        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Acessorio acessorio = new Acessorio();
        
        acessorio.setNome(request.getParameter("nome"));
        acessorio.setMarca(request.getParameter("marca"));
        acessorio.setCor(request.getParameter("cor"));
        acessorio.setPreco(request.getParameter("preco"));
        
       
        String id = request.getParameter("acessorioid");
        if(id == null || id.isEmpty())
        {
            dao.addAcessorio(acessorio);
        }
        else
        {
            acessorio.setId(Integer.parseInt(id));
            dao.updateAcessorio(acessorio);
        }
        RequestDispatcher view = request.getRequestDispatcher(INSERT_OR_EDIT);
        request.setAttribute("acessorios", dao.getAllAcessorio());
        view.forward(request, response);
    }
}

