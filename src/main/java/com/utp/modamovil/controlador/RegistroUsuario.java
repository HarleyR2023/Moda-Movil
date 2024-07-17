package com.utp.modamovil.controlador;

import com.utp.modamovil.dao.UsuarioDAO;
import com.utp.modamovil.modelo.Usuario;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "RegistroUsuario", urlPatterns = {"/RegistroUsuario"})
public class RegistroUsuario extends HttpServlet {
    
    UsuarioDAO usuarios = new UsuarioDAO();
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String accion = request.getParameter("accion");
    
        if (accion.equalsIgnoreCase("Crear Cuenta")) {
            this.registrarUsuario(request, response);
        }
    }
    
    /**
     * Gestiona la página de registrar usuarios.
     * @param request - La solicitud de la página
     * @param response - La respuesta de la página
     */
    public void registrarUsuario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String confirmarPassword = request.getParameter("confirmar_password");
        
        if (!password.equals(confirmarPassword) || usuarios.buscar(username) != null) return;
        
        Usuario usuario = new Usuario();
        usuario.setNombreUsuario(username);
        usuario.setContra(password);
        usuario.setNombre(request.getParameter("nombre"));
        usuario.setApellido(request.getParameter("apellidos"));
        usuario.setIndicador("C");
        usuarios.agregar(usuario);
        
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
    
    @Override
    public String getServletInfo() {
        return "Registro Usuario";
    }
}
