package CONTROLADOR;

import MODELO.UIController;
import VISTA.moduloListaVentas;
import VISTA.moduloNuevaVenta;
import VISTA.moduloVentas;
import java.awt.Color;

public class ControladorModuloVentas {

    private final moduloVentas v;

    public ControladorModuloVentas(moduloVentas v) {
        this.v = v;
        initDiseño();
    }

    private void initDiseño() {
        UIController.MostrarPanel(v.panelRound2, new moduloNuevaVenta(), 1120, 950);
    }

    public void btnListaVentaActionPerformed() {
        v.btnNuevaVenta.setBackground(new Color(30, 30, 30));
        v.btnListaVenta.setBackground(new Color(233, 181, 30));
        UIController.MostrarPanel(v.panelRound2, new moduloNuevaVenta(), 1120, 950);
    }

    public void btnNuevaVentaActionPerformed() {
        v.btnListaVenta.setBackground(new Color(30, 30, 30));
        v.btnNuevaVenta.setBackground(new Color(233, 181, 30));
        UIController.MostrarPanel(v.panelRound2, new moduloListaVentas(), 920, 634);
    }

}
