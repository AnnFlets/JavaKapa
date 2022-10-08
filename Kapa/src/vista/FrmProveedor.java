/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vista;

/**
 *
 * @author Pablo_Fuentes
 */
public class FrmProveedor extends javax.swing.JFrame {

    /**
     * Creates new form frm_01producto
     */
    public FrmProveedor() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jopMensajeProveedor = new javax.swing.JOptionPane();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnLimpiarProveedor = new javax.swing.JButton();
        txtIdProveedor = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        txtNombreProveedor = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator8 = new javax.swing.JSeparator();
        jLabel10 = new javax.swing.JLabel();
        txtTelefonoProveedor = new javax.swing.JTextField();
        btnSalirProveedor = new javax.swing.JButton();
        btnCrearProveedor = new javax.swing.JButton();
        btnActualizarProveedor = new javax.swing.JButton();
        btnEliminarProveedor = new javax.swing.JButton();
        btnReporteProveedor = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProveedores = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Administrador de Proveedores");
        setBackground(new java.awt.Color(187, 128, 201));
        setName("frm_01producto"); // NOI18N
        setResizable(false);
        setSize(new java.awt.Dimension(1100, 600));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Century Gothic", 1, 30)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("ADMINISTRADOR DE PROVEEDORES");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 20, -1, -1));

        jLabel2.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel2.setForeground(java.awt.Color.white);
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("ID");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 80, 40, -1));

        btnLimpiarProveedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ic_limpiarcampos.png"))); // NOI18N
        btnLimpiarProveedor.setToolTipText("Limpiar campos");
        getContentPane().add(btnLimpiarProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, 40, 30));

        txtIdProveedor.setEditable(false);
        txtIdProveedor.setBackground(new java.awt.Color(169, 234, 255));
        txtIdProveedor.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        txtIdProveedor.setForeground(new java.awt.Color(51, 51, 51));
        txtIdProveedor.setName("txtIdProveedor"); // NOI18N
        getContentPane().add(txtIdProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 110, 40, -1));

        jSeparator1.setForeground(new java.awt.Color(204, 153, 255));
        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, 10, 350));

        jSeparator2.setForeground(new java.awt.Color(204, 153, 255));
        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);
        getContentPane().add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 85, -1, 50));

        jLabel3.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel3.setForeground(java.awt.Color.white);
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Nombre del Proveedor");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 80, 289, -1));

        txtNombreProveedor.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        txtNombreProveedor.setForeground(new java.awt.Color(51, 51, 51));
        txtNombreProveedor.setName("txtNombreProveedor"); // NOI18N
        getContentPane().add(txtNombreProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 110, 280, -1));

        jSeparator3.setForeground(new java.awt.Color(204, 153, 255));
        jSeparator3.setOrientation(javax.swing.SwingConstants.VERTICAL);
        getContentPane().add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 85, -1, 50));

        jSeparator4.setForeground(new java.awt.Color(204, 153, 255));
        jSeparator4.setOrientation(javax.swing.SwingConstants.VERTICAL);
        getContentPane().add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(569, 29, 0, 62));

        jSeparator8.setBackground(new java.awt.Color(204, 153, 255));
        jSeparator8.setForeground(new java.awt.Color(204, 153, 255));
        jSeparator8.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        getContentPane().add(jSeparator8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, 700, 10));

        jLabel10.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Teléfono del Proveedor");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 80, 240, -1));

        txtTelefonoProveedor.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        txtTelefonoProveedor.setForeground(new java.awt.Color(51, 51, 51));
        txtTelefonoProveedor.setName("txt_descripcion"); // NOI18N
        getContentPane().add(txtTelefonoProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 110, 240, -1));

        btnSalirProveedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ic_java_4salir.png"))); // NOI18N
        btnSalirProveedor.setToolTipText("Regresar al menú principal");
        getContentPane().add(btnSalirProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 460, 40, 30));

        btnCrearProveedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ic_java_1crear.png"))); // NOI18N
        btnCrearProveedor.setToolTipText("Crear (debe tener los campos llenos)");
        getContentPane().add(btnCrearProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 220, 40, 30));

        btnActualizarProveedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ic_java_2actulizar.png"))); // NOI18N
        btnActualizarProveedor.setToolTipText("Actualizar (debe tener algún registro seleccionado)");
        getContentPane().add(btnActualizarProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 280, 40, 30));

        btnEliminarProveedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ic_java_3eliminar.png"))); // NOI18N
        btnEliminarProveedor.setToolTipText("Eliminar (debe tener algún registro seleccionado)");
        getContentPane().add(btnEliminarProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 340, 40, 30));

        btnReporteProveedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ic_java_5reporte.png"))); // NOI18N
        btnReporteProveedor.setToolTipText("Crear un reporte (Con los registros mostrados)");
        getContentPane().add(btnReporteProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 400, 40, 30));

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/fondoLogin.png"))); // NOI18N
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 700, 160));

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/fondoLogin.png"))); // NOI18N
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, 40, 350));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblProveedores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tblProveedores);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 620, 280));

        jLabel4.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setText("De doble clic sobre el proveedor para seleccionarlo.");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, 660, 350));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmProveedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmProveedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmProveedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmProveedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmProveedor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnActualizarProveedor;
    public javax.swing.JButton btnCrearProveedor;
    public javax.swing.JButton btnEliminarProveedor;
    public javax.swing.JButton btnLimpiarProveedor;
    public javax.swing.JButton btnReporteProveedor;
    public javax.swing.JButton btnSalirProveedor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator8;
    public javax.swing.JOptionPane jopMensajeProveedor;
    public javax.swing.JTable tblProveedores;
    public javax.swing.JTextField txtIdProveedor;
    public javax.swing.JTextField txtNombreProveedor;
    public javax.swing.JTextField txtTelefonoProveedor;
    // End of variables declaration//GEN-END:variables
}
