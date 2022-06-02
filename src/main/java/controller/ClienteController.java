package controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import model.Cliente;
import dao.ClienteDAO;



@WebServlet(name = "Clientes", urlPatterns = {"/ClienteController"})
public class ClienteController extends HttpServlet {
    private static String INSERT_OR_EDIT = "/CadastroCliente.jsp";
    private static String LIST = "/listarCliente.jsp";
    private ClienteDAO dao;
	
    
    public ClienteController() {
        super();
        dao = new ClienteDAO();
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String forward="";
        String action = request.getParameter("action");

        if (action.equalsIgnoreCase("delete")){
            int id = Integer.parseInt(request.getParameter("clienteid"));
            dao.deleteCliente(id);
            forward = LIST;
            request.setAttribute("clientes", dao.getAllClientes());    
        } else if (action.equalsIgnoreCase("edit")){
            forward = INSERT_OR_EDIT;
            int id = Integer.parseInt(request.getParameter("clienteid"));
            Cliente cliente = dao.getClienteById(id);
            request.setAttribute("cliente", cliente);
        } else if (action.equalsIgnoreCase("list")){
            forward = LIST;
            request.setAttribute("clientes", dao.getAllClientes());    
        } else {
            forward = INSERT_OR_EDIT;
        }

        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cliente cliente = new Cliente();
        
        cliente.setNome(request.getParameter("nome"));
        cliente.setEmail(request.getParameter("email"));
        cliente.setCidade(request.getParameter("cidade"));
        cliente.setTelefone(Integer.parseInt(request.getParameter("telefone")));
       
        String id = request.getParameter("clienteid");
        if(id == null || id.isEmpty())
        {
            dao.addCliente(cliente);
        }
        else
        {
            cliente.setId(Integer.parseInt(id));
            dao.updateCliente(cliente);
        }
        RequestDispatcher view = request.getRequestDispatcher(INSERT_OR_EDIT);
        request.setAttribute("clientes", dao.getAllClientes());
        view.forward(request, response);
    }
}
