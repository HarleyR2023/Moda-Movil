package com.utp.modamovil.controlador;

import com.utp.modamovil.modelo.Proveedor;
import com.utp.modamovil.dao.ProveedorDAO;
import com.utp.modamovil.dao.ProductoDAO;
import com.utp.modamovil.dao.VentaDAO;
import com.utp.modamovil.dao.EnvioDAO;
import com.utp.modamovil.dao.ProveedorDAO;
import com.utp.modamovil.modelo.Producto;
import com.utp.modamovil.modelo.Venta;
import com.utp.modamovil.modelo.Envio;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@WebServlet(name = "Controlador", urlPatterns = {"/Controlador"})
public class Controlador extends HttpServlet {
    ProductoDAO proddao = new ProductoDAO();
    VentaDAO ventadao = new VentaDAO();
    EnvioDAO enviodao = new EnvioDAO();
    List<Producto> carrito = new ArrayList<>();
    Proveedor em = new Proveedor();
    ProveedorDAO edao = new ProveedorDAO();
    

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String menu = request.getParameter("menu");
        String accion = request.getParameter("accion");
        if(menu.equals("PrinicipalT.jsp")){
            switch (accion) {
                case "Listar":
                    List lista = edao.listar();
                    request.setAttribute("Proveedores", lista);
                    break;
                case "Agregar":
                    
                    break;
                case "Editar":
                    
                    break;
                case "Delete":
                    
                    break;
                default:
                    throw new AssertionError();
            }
            request.getRequestDispatcher("PrincipalT.jsp").forward(request, response);
        
        }
        if ("Principal".equals(menu)) {
            request.getRequestDispatcher("Principal.jsp").forward(request, response);
        } else if (menu.equals("Productos")) {
            switch (accion) {
                case "AgregarCarrito":
                    int id = Integer.parseInt(request.getParameter("id"));
                    Producto producto = proddao.listarId(id);

                    // Comprobar si el producto ya está en el carrito
                    boolean exists = false;
                    for (Producto prod : carrito) {
                        if (prod.getId() == producto.getId()) {
                            prod.setCantidad(prod.getCantidad() + 1);
                            exists = true;
                            break;
                        }
                    }

                    if (!exists) {
                        producto.setCantidad(1); // Cantidad inicial es 1
                        carrito.add(producto);
                    }

                    request.getSession().setAttribute("carrito", carrito);
                    // Obtener nuevamente la lista de productos
                    List<Producto> productos = proddao.listar();
                    // Enviar la lista de productos de vuelta a la vista
                    request.setAttribute("producto", productos);
                    request.getRequestDispatcher("Productos.jsp").forward(request, response);
                    break;
                default:
                    List<Producto> productosDefault = proddao.listar();
                    request.setAttribute("producto", productosDefault);
                    request.getRequestDispatcher("Productos.jsp").forward(request, response);
                    
                    case "PrincipalT":
            request.getRequestDispatcher("PrincipalT.jsp").forward(request, response);
            }
            
           
        } else if (menu.equals("Pago")) {
            request.getRequestDispatcher("Pago.jsp").forward(request, response);
        } else if (menu.equals("ConfirmarCompra")) {
            String metodoPago = request.getParameter("metodoPago");
            String metodoEnvio = request.getParameter("metodoEnvio");
            Venta venta = new Venta();
            venta.setUsuarioId(1); // Suponiendo un usuario con ID 1 para el ejemplo
            venta.setFecha(new Date());
            venta.setTotal(carrito.stream().mapToDouble(p -> p.getPrecio() * p.getCantidad()).sum());
            venta.setMetodoPago(metodoPago);
            venta.setEstado("Completado");

            int ventaId = ventadao.agregar(venta);

            Envio envio = new Envio();
            envio.setVentaId(ventaId);
            envio.setTipoEnvio(metodoEnvio);
            enviodao.agregar(envio);

            carrito.clear();
            request.getSession().setAttribute("carrito", carrito);

            request.getRequestDispatcher("compraConfirmada.jsp").forward(request, response);
        } else if (menu.equals("ActualizarCarrito")) {
            int id = Integer.parseInt(request.getParameter("id"));
            int cantidad = Integer.parseInt(request.getParameter("cantidad"));

            for (Producto prod : carrito) {
                if (prod.getId() == id) {
                    switch (accion) {
                        case "Restar":
                            if (prod.getCantidad() > 1) {
                                prod.setCantidad(prod.getCantidad() - 1);
                            }
                            break;
                        case "Sumar":
                            prod.setCantidad(prod.getCantidad() + 1);
                            break;
                        case "Eliminar":
                            carrito.remove(prod);
                            break;
                    }
                    break;
                }
            }

            request.getSession().setAttribute("carrito", carrito);
            // Obtener nuevamente la lista de productos
            List<Producto> productos = proddao.listar();
            request.setAttribute("producto", productos);

            request.getRequestDispatcher("Productos.jsp").forward(request, response);
            //AQUI PONES TU IF Y ELSE
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
