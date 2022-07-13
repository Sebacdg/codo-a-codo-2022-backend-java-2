package ar.com.codoacodo.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ar.com.codoacodo.daos.ProductoDAO;

/*HERENCIA*/
//Create Controller es hijo de :
@WebServlet("/CreateController")
public class CreateController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// recibe los datos del front
		
		// en req viene los datos que manda el formulario html
		//clave=valor
			
		String nombre = req.getParameter("nombre");//titulo1
		String precio = req.getParameter("precio");//1500
		String imagen = req.getParameter("imagen");
		String codigo = req.getParameter("codigo");//0001
		
		//ctrl+shift+o es para que desaparezcan las clases que no sirven y quedan solo las que uso
		//crear productoDAO
		ProductoDAO dao = new ProductoDAO();
		
		
		//ejecutar el metodo crearProducto(conlosparametros)
		dao.crearProducto(nombre, Float.parseFloat(precio), imagen, codigo); 
		/*al poner crea ya lo completa solo apretando enter, como precio no es un string, convierto en un parse*/
		
		//ir a la siguiente pagina, un redirect
		
		resp.sendRedirect(req.getContextPath()+"/api/ListadoController");
	}
}