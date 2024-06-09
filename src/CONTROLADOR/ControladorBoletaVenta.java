package CONTROLADOR;

import DAO.ConexionSQL;
import DAO.ModeloDAO;
import MODELO.COMPONET.GeneradorFacturaPDF;
import VISTA.BoletaVenta;
import VISTA.moduloListaVentas;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

public class ControladorBoletaVenta {

    Connection conexion;
    ResultSet resultado;
    PreparedStatement consulta;
    DefaultTableModel modelo;

    String CodigoVenta = moduloListaVentas.codigoVenta;
    String codigoEmpleado = moduloListaVentas.codigoEmpleado;
    String codigoCliente = moduloListaVentas.codigoCliente;
    String fechaVenta = moduloListaVentas.fechaVenta;
    String empleado = ModeloDAO.consultarDato("empleados", "dni", codigoEmpleado, "nombre", "String").toString() + " "
            + ModeloDAO.consultarDato("empleados", "dni", codigoEmpleado, "apellido", "String").toString();

    String nombreCliente = ModeloDAO.consultarDato("cliente", "dniCliente", codigoCliente, "nombre", "String").toString();
    String apellidoCliente = ModeloDAO.consultarDato("cliente", "dniCliente", codigoCliente, "apellido", "String").toString();
    String direccion = ModeloDAO.consultarDato("cliente", "dniCliente", codigoCliente, "direccion", "String").toString();

    private final BoletaVenta b;

    public ControladorBoletaVenta(BoletaVenta b) {
        this.b = b;
    }

    public void initDiseño() {
        b.setLocationRelativeTo(null);
        b.setBackground(new Color(0, 0, 0, 0));
        consultar(CodigoVenta);
//        System.out.println(CodigoVenta);
        double acum = 0;
        for (int i = 0; i < b.tablaVenta.getRowCount(); i++) {
            acum = acum + Double.parseDouble(b.tablaVenta.getValueAt(i, 3).toString());
        }
        b.txtTotal.setText("" + acum);
    }

    private void consultar(String codigoVenta) {
        try {
            conexion = new ConexionSQL().conexion();
            consulta = conexion.prepareStatement("SELECT * FROM ventaProductos ventaP inner join productos prod on ventaP.codigoProducto = prod.codigoProducto WHERE idVenta=?");
            consulta.setString(1, codigoVenta);
            resultado = consulta.executeQuery();
            Object datos[] = new Object[4];
            modelo = (DefaultTableModel) b.tablaVenta.getModel();
            modelo.setRowCount(0);
            while (resultado.next()) {
                datos[0] = resultado.getString("nombre");
                datos[1] = resultado.getDouble("precio");
                datos[2] = resultado.getInt("cantidad");
                datos[3] = resultado.getDouble("total");
                modelo.addRow(datos);
            }
            b.txtNombreEmpleado.setText(empleado);

            b.txtNombreCliente.setText(nombreCliente);
            b.txtApellidoCliente.setText(apellidoCliente);
            b.txtDireccionCliente.setText(direccion);

            b.tablaVenta.setModel(modelo);
        } catch (SQLException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }

    int LayoutX;
    int LayoutY;

    public void BarraTituloMouseDragged(java.awt.event.MouseEvent evt) {
        b.setLocation(evt.getXOnScreen() - LayoutX, evt.getYOnScreen() - LayoutY);
    }

    public void BarraTituloMousePressed(java.awt.event.MouseEvent evt) {
        if (evt.getButton() == java.awt.event.MouseEvent.BUTTON1) {
            LayoutX = evt.getX();
            LayoutY = evt.getY();
        }
    }

    public void generarPDF() {
        DefaultTableModel modeloPDF = new javax.swing.table.DefaultTableModel(
                new Object[][]{},
                new String[]{
                    "Nombre", "Precio U.", "Cantidad"
                }
        );

        Object datos[] = new Object[3];
        for (int i = 0; i < b.tablaVenta.getRowCount(); i++) {
            datos[0] = b.tablaVenta.getValueAt(i, 0);
            datos[1] = b.tablaVenta.getValueAt(i, 2);
            datos[2] = b.tablaVenta.getValueAt(i, 1);
            modeloPDF.addRow(datos);
        }
        String nombreEmpresa = "Ladyshop";
        String direccionEmpresa = "Av. Rivadavia 5512 Piso 1 Local 38";
        String emailEmpresa = "info@leidyshop.com";
        String descripcionEmpresa = "Es increíble que hayas llegado hasta aqui a LADY POSH \n"
                + ". Disfruta de todas las novedades que tenemos para ti. lo mejor en ropa urbana \n"
                + ", encuentra los mejores precios";
        GeneradorFacturaPDF facturaElectronica = new GeneradorFacturaPDF(nombreEmpresa, direccionEmpresa, emailEmpresa, descripcionEmpresa);
        facturaElectronica.generarPDF(CodigoVenta, ModeloDAO.DNI_EMPLEADO, codigoCliente, direccion, modeloPDF, fechaVenta);
    }
}
