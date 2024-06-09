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
        v.btnListaVenta.setBackground(new Color(252, 36, 56));
        v.btnNuevaVenta.setBackground(new Color(252, 77, 89));
        UIController.MostrarPanel(v.panelRound2, new moduloNuevaVenta(), 1120, 950);
    }

    public void btnNuevaVentaActionPerformed() {
        v.btnNuevaVenta.setBackground(new Color(252, 36, 56));
        v.btnListaVenta.setBackground(new Color(252, 77, 89));
        UIController.MostrarPanel(v.panelRound2, new moduloListaVentas(), 920, 634);
    }

}
