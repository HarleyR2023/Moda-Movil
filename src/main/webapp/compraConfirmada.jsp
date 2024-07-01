<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Compra Confirmada</title>
    <link href="CSS/compraconfirmada.css?v=<%= System.currentTimeMillis() %>" rel="stylesheet" type="text/css"/>
</head>
<body>
    <div class="container-confirmacion">
        <h1 class="color-of">Compra Confirmada</h1>
        <p class="color-of">Gracias por tu compra. Tu pedido ha sido procesado exitosamente.</p>
        <div class="voucher" id="voucher">
            <h1>Comprobante de Compra</h1>
            <p>Nombre: Juan</p>
            <table>
                <thead>
                    <tr>
                        <th>Producto</th>
                        <th>Cantidad</th>
                        <th>Precio Unitario</th>
                        <th>Subtotal</th>
                    </tr>
                </thead>
                <tbody id="product-list">
                    <tr>
                        <td>Producto A</td>
                        <td>2</td>
                        <td>S/. 25.00</td>
                        <td>S/. 50.00</td>
                    </tr>
                    <tr>
                        <td>Producto B</td>
                        <td>1</td>
                        <td>S/. 35.00</td>
                        <td>S/. 35.00</td>
                    </tr>
                    <tr>
                        <td>Producto C</td>
                        <td>3</td>
                        <td>S/. 10.00</td>
                        <td>S/. 30.00</td>
                    </tr>
                </tbody>
                <tfoot>
                    <tr>
                        <td colspan="3">Total Final</td>
                        <td id="total-final">S/. 115.00</td> <!-- Total estático -->
                    </tr>
                </tfoot>
            </table>
            <p>Estado: Pagado</p>
        </div>
        <button onclick="downloadPDF()">Descargar PDF</button>
        <a href="<%= request.getContextPath()%>/Controlador?menu=Productos&accion=Listar">Volver a la tienda</a>        
    </div>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jspdf/2.4.0/jspdf.umd.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jspdf-autotable/3.5.25/jspdf.plugin.autotable.min.js"></script>
    <script>
        function downloadPDF() {
            const { jsPDF } = window.jspdf;
            const doc = new jsPDF();
            
            doc.text("Comprobante de Compra", 10, 10);
            doc.text("Nombre: Juan Pérez", 10, 20);

            doc.autoTable({
                startY: 30,
                head: [['Producto', 'Cantidad', 'Precio Unitario', 'Subtotal']],
                body: [
                    ['Producto A', '2', 'S/. 25.00', 'S/. 50.00'],
                    ['Producto B', '1', 'S/. 35.00', 'S/. 35.00'],
                    ['Producto C', '3', 'S/. 10.00', 'S/. 30.00']
                ]
            });

            doc.text(`Total Final: S/. 115.00`, 10, doc.lastAutoTable.finalY + 10);
            doc.text(`Estado: Pagado`, 10, doc.lastAutoTable.finalY + 20);

            doc.save('voucher.pdf');
        }
    </script>
</body>
</html>
