package VISTA;

import CONTROLADOR.ControladorLogin;

public class frmLogin extends javax.swing.JFrame {

    private final ControladorLogin controlador;

    public frmLogin() {
        initComponents();
        controlador = new ControladorLogin(this);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        panelRound1 = new MODELO.COMPONET.PanelRound();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnIngresar = new button.Button();
        BarraTitulo = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        panelCustom2 = new MODELO.COMPONET.PanelCustom();
        txtPassword = new javax.swing.JPasswordField();
        labelOjito = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        panelCustom1 = new MODELO.COMPONET.PanelCustom();
        txtUsuario = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login");
        setIconImage(java.awt.Toolkit.getDefaultToolkit().getImage(getClass().getResource("/com/img/icons/llave.png")));
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelRound1.setBackground(new java.awt.Color(30, 30, 30));
        panelRound1.setRoundBottomLeft(25);
        panelRound1.setRoundBottomRight(25);
        panelRound1.setRoundTopLeft(25);
        panelRound1.setRoundTopRight(25);
        panelRound1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Century Gothic", 1, 22)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Contraseña");
        panelRound1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 250, -1, -1));

        jLabel3.setFont(new java.awt.Font("Century Schoolbook", 1, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Login");
        panelRound1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 60, -1, -1));

        jLabel4.setFont(new java.awt.Font("Century Gothic", 1, 22)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Usuario");
        panelRound1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 130, -1, -1));

        btnIngresar.setBackground(new java.awt.Color(30, 30, 30));
        btnIngresar.setForeground(new java.awt.Color(255, 255, 255));
        btnIngresar.setText("INGRESAR");
        btnIngresar.setCurrentCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnIngresar.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        btnIngresar.setShadowColor(new java.awt.Color(0, 0, 0));
        btnIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarActionPerformed(evt);
            }
        });
        panelRound1.add(btnIngresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 370, 170, 60));

        BarraTitulo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BarraTitulo.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                BarraTituloMouseDragged(evt);
            }
        });
        BarraTitulo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                BarraTituloMousePressed(evt);
            }
        });
        panelRound1.add(BarraTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 300, 40));

        jLabel5.setFont(new java.awt.Font("DialogInput", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("X");
        jLabel5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });
        panelRound1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 10, 30, -1));

        panelCustom2.setBackground(new java.awt.Color(204, 204, 204));
        panelCustom2.setRound(40);
        panelCustom2.setShadowColor(new java.awt.Color(0, 0, 0));
        panelCustom2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtPassword.setFont(new java.awt.Font("DialogInput", 0, 19)); // NOI18N
        txtPassword.setSelectionColor(new java.awt.Color(51, 51, 51));
        panelCustom2.add(txtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 0, 140, 50));

        labelOjito.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelOjito.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/img/icons/OjoAbierto.png"))); // NOI18N
        labelOjito.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        labelOjito.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelOjitoMouseClicked(evt);
            }
        });
        panelCustom2.add(labelOjito, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 0, 40, 50));

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/img/icons/ICONO CONTRASEÑA.png"))); // NOI18N
        panelCustom2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 50, 50));

        panelRound1.add(panelCustom2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 290, 250, 55));

        panelCustom1.setBackground(new java.awt.Color(204, 204, 204));
        panelCustom1.setRound(40);
        panelCustom1.setShadowColor(new java.awt.Color(0, 0, 0));
        panelCustom1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtUsuario.setFont(new java.awt.Font("DialogInput", 0, 19)); // NOI18N
        txtUsuario.setSelectionColor(new java.awt.Color(51, 51, 51));
        panelCustom1.add(txtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 0, 170, 50));

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/img/icons/ICONO USUARIO.png"))); // NOI18N
        panelCustom1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 50, 50));

        panelRound1.add(panelCustom1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, 250, 55));

        getContentPane().add(panelRound1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 330, 470));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarActionPerformed
        controlador.btnIngresarActionPerformed(evt);
    }//GEN-LAST:event_btnIngresarActionPerformed

    private void BarraTituloMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BarraTituloMouseDragged
        controlador.BarraTituloMouseDragged(evt);
    }//GEN-LAST:event_BarraTituloMouseDragged

    private void BarraTituloMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BarraTituloMousePressed
        controlador.BarraTituloMousePressed(evt);
    }//GEN-LAST:event_BarraTituloMousePressed

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabel5MouseClicked

    private void labelOjitoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelOjitoMouseClicked
        controlador.clickOjo();
    }//GEN-LAST:event_labelOjitoMouseClicked

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new frmLogin().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JLabel BarraTitulo;
    public button.Button btnIngresar;
    public javax.swing.JLabel jLabel1;
    public javax.swing.JLabel jLabel2;
    public javax.swing.JLabel jLabel3;
    public javax.swing.JLabel jLabel4;
    public javax.swing.JLabel jLabel5;
    public javax.swing.JLabel jLabel6;
    public javax.swing.JLabel jLabel8;
    public javax.swing.JLabel labelOjito;
    public MODELO.COMPONET.PanelCustom panelCustom1;
    public MODELO.COMPONET.PanelCustom panelCustom2;
    public MODELO.COMPONET.PanelRound panelRound1;
    public javax.swing.JPasswordField txtPassword;
    public javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
