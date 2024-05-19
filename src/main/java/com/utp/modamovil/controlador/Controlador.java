/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.utp.modamovil.controlador;

import com.utp.modamovil.dao.ProductoDAO;
import com.utp.modamovil.modelo.Producto;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Arturo
 */
@WebServlet(name = "Controlador", urlPatterns = {"/Controlador"})
public class Controlador extends HttpServlet {
    Producto prod = new Producto();
    ProductoDAO proddao = new ProductoDAO();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String menu = request.getParameter("menu");
        String accion = request.getParameter("accion");

        if ("Principal".equals(menu)) {
            request.getRequestDispatcher("Principal.jsp").forward(request, response);
        } else if ("Productos".equals(menu)) {
            switch (accion) {
                case "Listar":
                    List<Producto> lista = proddao.listar();
                    request.setAttribute("producto", lista);
                    request.getRequestDispatcher("Productos.jsp").forward(request, response);
                    break;
                case "AgregarCarrito":
                    int id = Integer.parseInt(request.getParameter("id"));
                    Producto producto = proddao.listarId(id);
                    List<Producto> carrito = (List<Producto>) session.getAttribute("carrito");
                    if (carrito == null) {
                        carrito = new ArrayList<>();
                    }
                    carrito.add(producto);
                    session.setAttribute("carrito", carrito);

                    // Volver a listar los productos
                    List<Producto> listaProductos = proddao.listar();
                    request.setAttribute("producto", listaProductos);
                    request.getRequestDispatcher("Productos.jsp").forward(request, response);
                    break;
                default:
                    response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Acción no reconocida: " + accion);
                    return;
            }
        } else {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Menú no reconocido: " + menu);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}