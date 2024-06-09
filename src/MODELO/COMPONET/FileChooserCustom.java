package MODELO.COMPONET;

import jnafilechooser.api.JnaFileChooser;

public class FileChooserCustom {

    public static String FileChosserArchivo(String defaultName, String[] extension, String descripcionTitulo) {
        JnaFileChooser fileChooser = new JnaFileChooser();
        fileChooser.addFilter(descripcionTitulo, extension);
        fileChooser.setMultiSelectionEnabled(false); // Cambia a true si deseas habilitar la selecci�n m�ltiple
        fileChooser.setMode(JnaFileChooser.Mode.Files); // Cambia el modo seg�n tus necesidades

        // Establece el nombre de archivo por defecto
        if (defaultName != null && !defaultName.isEmpty()) {
            fileChooser.setDefaultFileName(defaultName + "." + extension);
        }

        if (fileChooser.showOpenDialog(null)) {
            String selectedFilePath = fileChooser.getSelectedFile().getAbsolutePath();
//            System.out.println("Archivo seleccionado: " + selectedFilePath);
            return selectedFilePath;
        } else {
//            System.out.println("Selecci�n de archivo cancelada.");
            return null;
        }
    }

}
