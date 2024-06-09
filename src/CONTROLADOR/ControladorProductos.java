package CONTROLADOR;

import DAO.ConexionSQL;
import MODELO.ActionUtils;
import MODELO.COMPONET.FileChooserCustom;
import MODELO.Filtrado;
import MODELO.UIController;
import VISTA.moduloProductos;
import java.awt.Cursor;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ControladorProductos {

    private final moduloProductos p;
    Connection conexion;
    PreparedStatement consulta;
    ResultSet resultado;
    DefaultTableModel modelo;
    String idc;
    int filaSeleccionada = -1;

    public ControladorProductos(moduloProductos p) {
        this.p = p;
        mostrar();
    }

    public void initDiseño() {
        initButton();
        if (ControladorFrmPrincipal.rango.equalsIgnoreCase("empleado")) {
            p.panelBotones.setVisible(false);
        }
        Filtrado.setupTableSorting(p.tablaProductos);
        p.panelCustom1.setCursor(new Cursor(12));
        p.imagenPerfil.setCursor(new Cursor(12));
    }

    private void mostrar() {
        try {
            conexion = new ConexionSQL().conexion();
            consulta = conexion.prepareStatement("SELECT * FROM productos");
            resultado = consulta.executeQuery();
            Object datos[] = new Object[6];
            modelo = (DefaultTableModel) p.tablaProductos.getModel();
            modelo.setRowCount(0);
            while (resultado.next()) {
                datos[0] = resultado.getString("codigoProducto");
                datos[1] = resultado.getString("nombre");
                datos[2] = resultado.getDouble("precio");
                datos[3] = resultado.getInt("stock");
                datos[4] = resultado.getDate("fecha");
                modelo.addRow(datos);
            }
            p.tablaProductos.setModel(modelo);
        } catch (SQLException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }

    public InputStream clickImagen() {
        try {
            String extensiones[] = {"png", "jpg", "jpeg"};
            String urlImgen = FileChooserCustom.FileChosserArchivo("", extensiones, ".png .jpg .jpeg");
//            System.out.println(urlImgen);
            if (urlImgen != null) {
                InputStream inputUrl = UIController.toInputStream(urlImgen);
                p.imagenPerfil.setImage(UIController.toIcon(inputUrl));
//                System.out.println(p.imagenPerfil.getImage().toString());
                return inputUrl;
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return null;
    }

    public void registrar() {
        try {
            String codigo = p.txtCodigo.getText();
            String nombre = p.txtNombre.getText();
            double precio = Double.parseDouble(p.txtPrecio.getText());
            InputStream foto = UIController.toInputStream(p.imagenPerfil.getImage());
            int stock = Integer.parseInt(p.txtStock.getText());
            if (UIController.datosCompletos(codigo, nombre, String.valueOf(precio), String.valueOf(stock))) {
                Date fecha = new SimpleDateFormat("yyyy-MM-dd").parse(ActionUtils.FechaActual());
                conexion = new ConexionSQL().conexion();
                consulta = conexion.prepareStatement("INSERT INTO productos (codigoProducto, nombre, precio, stock, foto, fecha) VALUES (?,?,?,?,?,?)");
                consulta.setString(1, codigo);
                consulta.setString(2, nombre);
                consulta.setDouble(3, precio);
                consulta.setInt(4, stock);
                consulta.setBinaryStream(5, foto);
                consulta.setDate(6, new java.sql.Date(fecha.getTime()));
                consulta.executeUpdate();
                filaSeleccionada = -1;
                limpiar();
                mostrar();
            } else {
                JOptionPane.showMessageDialog(null, "Datos incompletos", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException | NumberFormatException | ParseException | IOException e) {
//            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage() + "Error" + JOptionPane.ERROR_MESSAGE);
            System.out.println("ERROR: " + e.getMessage());
        }
    }

    public void actualizar() {
        try {
            String codigo = p.txtCodigo.getText();
            String nombre = p.txtNombre.getText();
            double precio = Double.parseDouble(p.txtPrecio.getText());
            int stock = Integer.parseInt(p.txtStock.getText());
            Date fecha = new SimpleDateFormat("yyyy-MM-dd").parse(ActionUtils.FechaActual());
            InputStream foto = UIController.toInputStream(p.imagenPerfil.getImage());
            conexion = new ConexionSQL().conexion();
            consulta = conexion.prepareStatement("UPDATE productos set nombre=?, precio=?, stock=?, foto=?, fecha=? WHERE codigoProducto=?");
            consulta.setString(1, nombre);
            consulta.setDouble(2, precio);
            consulta.setInt(3, stock);
            consulta.setBinaryStream(4, foto);
            consulta.setDate(5, new java.sql.Date(fecha.getTime()));
            consulta.setString(6, codigo);
            consulta.executeUpdate();
            filaSeleccionada = -1;
            limpiar();
            mostrar();
        } catch (SQLException | NumberFormatException | ParseException | IOException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }

    public void limpiar() {
        UIController.vaciarTxtField(p.txtCodigo, p.txtNombre, p.txtPrecio, p.txtStock);
        p.imagenPerfil.setImage(new javax.swing.ImageIcon(getClass().getResource("/com/img/icons/imagen.png")));
    }

    public void btnActualizarActionPerformed() {
        if (filaSeleccionada < 0) {
            JOptionPane.showMessageDialog(null, "Selecciona una fila");
        } else {
            int dialog = JOptionPane.YES_NO_OPTION;
            int result = JOptionPane.showConfirmDialog(null, "Confirmar actualizacion", "Confirmacion", dialog);
            if (result == 0) {
                actualizar();
            }
        }
    }

    public void btnBorrarActionPerformed() {
        if (filaSeleccionada < 0) {
            JOptionPane.showMessageDialog(null, "Selecciona una fila");
        } else {
            int dialog = JOptionPane.YES_NO_OPTION;
            int result = JOptionPane.showConfirmDialog(null, "Confirmar eliminacion", "Confirmacion", dialog);
            if (result == 0) {
                try {
                    String codigo = p.txtCodigo.getText();
                    conexion = new ConexionSQL().conexion();
                    consulta = conexion.prepareStatement("DELETE FROM productos WHERE codigoProducto=?");
                    consulta.setString(1, codigo);
                    consulta.executeUpdate();
                    filaSeleccionada = -1;
                    limpiar();
                    mostrar();
                } catch (SQLException e) {
                    System.out.println("ERROR: " + e.getMessage());
                }
            }
        }
    }

    private InputStream imagenProducto(String idProducto) {
        InputStream fotex = null;
        try {
            conexion = new ConexionSQL().conexion();
            consulta = conexion.prepareStatement("SELECT * FROM productos WHERE codigoProducto=?");
            consulta.setString(1, idProducto);
            resultado = consulta.executeQuery();
            if (resultado.next()) {
                fotex = resultado.getBinaryStream("foto");
                if (fotex == null) {
                    return UIController.toInputStream("src/com/img/icons/imagen.png");
                } else {
                    return fotex;
                }
            }
        } catch (SQLException | IOException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
        return fotex;
    }

    public void tablaProductosMouseClicked() {
        filaSeleccionada = p.tablaProductos.getSelectedRow();

        idc = p.tablaProductos.getValueAt(filaSeleccionada, 0).toString();
        String nombre = p.tablaProductos.getValueAt(filaSeleccionada, 1).toString();
        String precio = p.tablaProductos.getValueAt(filaSeleccionada, 2).toString();
        String stock = p.tablaProductos.getValueAt(filaSeleccionada, 3).toString();

        p.txtCodigo.setText(idc);
        p.txtNombre.setText(nombre);
        p.txtPrecio.setText(precio);
        p.txtStock.setText(stock);
        try {
            p.imagenPerfil.setImage(UIController.toIcon(imagenProducto(idc)));
        } catch (IOException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }

    private void initButton() {
        Cursor cursor = new Cursor(12);
        p.btnRegistrar.setCurrentCursor(cursor);
        p.btnBorrar.setCurrentCursor(cursor);
        p.btnActualizar.setCurrentCursor(cursor);
        p.btnLimpiar.setCurrentCursor(cursor);
    }

}
