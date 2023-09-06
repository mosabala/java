package es.springboot.application.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import es.springboot.application.dao.PersonaDAO;
import es.springboot.application.dao.PersonaDAOImpl;
import es.springboot.application.model.Persona;

@WebServlet(name = "/SvPersonas", urlPatterns="/SvPersonas")
public class SvPersonas extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Autowired
	private PersonaDAO personaDAO;
       
	public void init(ServletConfig config) throws ServletException {
	    super.init(config);
	    SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this,
	      config.getServletContext());
	  }
	
	
    public SvPersonas() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		List<Persona> lstUsers = new ArrayList<>();
		lstUsers = getPersonas();
		
//		lstUsers.add(new Persona("1234545","Jose","Fernandez","1234-5412"));		
//		lstUsers.add(new Persona("2457878","Juana","Lopez","5241-6358"));		
//		lstUsers.add(new Persona("2596357","Federica","Hernandez","2495-6357"));		
		
		HttpSession msession = request.getSession();
		msession.setAttribute("listaPersonas", lstUsers);
		
		response.sendRedirect("mostrarPersonas.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//doGet(request, response);
		
		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		String email = request.getParameter("email");
		String telefono = request.getParameter("telefono");

		System.out.println("Nombre: " + nombre);
		System.out.println("Apellido: " + apellido);
		System.out.println("Email: " + email);
		System.out.println("Telefono: " + telefono);
		
	}
	
	public List<Persona> getPersonas(){
		return personaDAO.getAll();
	}

	
//	protected void processRequest(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
//		response.setContentType("text/html;charset-UTF-8");
//		try(PrintWriter out = response.getWriter()){
//			out.println("<!DOCTYPE html>");
//			out.println("<html>");
//			out.println("<head>");
//			out.println("<title>Servlet SvUsuarios</title>");
//			out.println("</head>");
//			out.println("<body>");
//			out.println("<h1>Servlet SvUsuarios at "+request.getContextPath()+"</h1>");
//			out.println("</body>");
//			out.println("</html>");
//		}
//	}

}
