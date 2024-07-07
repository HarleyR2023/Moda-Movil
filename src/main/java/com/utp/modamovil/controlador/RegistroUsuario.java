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
        String register = request.getParameter("register");
        if (!register.equalsIgnoreCase("Registrar")) return;
        
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("confirm_password");
        
        
        if (!password.equals(confirmPassword)) {
            return;
        }
        if (usuarios.buscar(username) != null) {
            return;
        }
        Usuario usuario = new Usuario();
        
        usuario.setNombreUsuario(username);
        usuario.setContra(password);
        
        usuario.setIndicador("C");
        
        usuarios.agregar(usuario);
    }
    
    @Override
    public String getServletInfo() {
        return "Registro Usuario";
    }
}
