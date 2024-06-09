package CONTROLADOR;

import DAO.ModeloDAO;
import MODELO.UIController;
import VISTA.frmPrincipal;
import VISTA.pnlHome;
import java.awt.Cursor;
import javax.swing.JPanel;

public class ControladorFrmPrincipal {

    private final frmPrincipal p;
    public static String rango = ModeloDAO.getRangoEmpleado(ModeloDAO.DNI_EMPLEADO);

    public ControladorFrmPrincipal(frmPrincipal p) {
        this.p = p;
        initDiseño();
    }

    private void initDiseño() {
        initPanel();
        p.setLocationRelativeTo(null);

        UIController.MostrarPanel(p.CONTENEDOR, new pnlHome(), 865, 576);
        UIController.removerBordeBlanco(p.scrollContenedor);
        p.pictureBox1.setCursor(new Cursor(12));
        frmPrincipal.txtRango.setText(rango);
        if (rango.equalsIgnoreCase("empleado")) {
            p.btnTrabajador.setVisible(false);
        }
    }
    
    private void initPanel() {
        UIController.setPanelBackgroundColors(p.btnTrabajador, "#282828", "#232323");
        UIController.setPanelBackgroundColors(p.btnProductos, "#282828", "#232323");
        UIController.setPanelBackgroundColors(p.btnContratos, "#282828", "#232323");
        UIController.setPanelBackgroundColors(p.btnAutos, "#282828", "#232323");
    }

    public void cambiarPanel(JPanel panel) {
        p.scrollContenedor.getVerticalScrollBar().setValue(0);
        UIController.MostrarPanel(p.CONTENEDOR, panel, 865, 576);
    }
}
