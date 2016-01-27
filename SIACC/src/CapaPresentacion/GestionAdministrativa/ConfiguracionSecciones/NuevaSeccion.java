package CapaPresentacion.GestionAdministrativa.ConfiguracionSecciones;

import CapaDatos.Entidades.GestionAdministrativa.Institucional.AsignacionSecciones;
import CapaDatos.Entidades.GestionAdministrativa.Institucional.Institucion;
import CapaDatos.Entidades.GestionAdministrativa.Institucional.Seccion;
import CapaLogica.GestionAdministrativa.Institucional.LogicaAsignacionSeccion;
import CapaLogica.GestionAdministrativa.Institucional.LogicaInstitucion;
import CapaLogica.GestionAdministrativa.Institucional.LogicaSecciones;
import CapaPresentacion.Utilidades.Alertas.Mensajes;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class NuevaSeccion extends javax.swing.JDialog {

    LogicaInstitucion logicaUnidadEducativa = new LogicaInstitucion();
    Institucion objInstituto = new Institucion();
    
    LogicaAsignacionSeccion logica = new LogicaAsignacionSeccion();
    AsignacionSecciones obj = new AsignacionSecciones();
    
    Mensajes mensaje = new Mensajes();
    private boolean bandera = false;

    public NuevaSeccion(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        try {
            objInstituto = logicaUnidadEducativa.buscarInsititucionPorCod(1);
            lblInstitucion.setText(objInstituto.getNombre());
            listarSecciones();
        } catch (SQLException ex) {
            Logger.getLogger(NuevaSeccion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //Metodo para Listar Secciones
    private void listarSecciones() throws SQLException {
        ArrayList<Seccion> lista;
        lista = new LogicaSecciones().listarSecciones();
        cmbSeccion.removeAllItems();
        for (int i = 0; i < lista.size(); i++) {
            cmbSeccion.addItem(lista.get(i));
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lypnlFondo = new javax.swing.JLayeredPane();
        pnlFondo = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        lblLogo = new javax.swing.JLabel();
        lblCodigo = new javax.swing.JLabel();
        lblSeccion = new javax.swing.JLabel();
        lblDescripcion = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        cmbSeccion = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDescripcion = new javax.swing.JTextArea();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        lblInstitucion = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Registro de Configuración de Secciones");

        pnlFondo.setBackground(new java.awt.Color(255, 255, 255));

        lblTitulo.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        lblTitulo.setText("Nueva Configuración de Sección");

        lblLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/CapaPresentacion/Imagenes/GestionAdministrativa/secciones.png"))); // NOI18N

        lblCodigo.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        lblCodigo.setText("Código");

        lblSeccion.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        lblSeccion.setText("Sección");

        lblDescripcion.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        lblDescripcion.setText("Descripción");

        txtCodigo.setEditable(false);
        txtCodigo.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N

        cmbSeccion.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N

        txtDescripcion.setColumns(20);
        txtDescripcion.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        txtDescripcion.setRows(5);
        jScrollPane1.setViewportView(txtDescripcion);

        btnGuardar.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnCancelar.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        lblInstitucion.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        lblInstitucion.setText("Institución");

        javax.swing.GroupLayout pnlFondoLayout = new javax.swing.GroupLayout(pnlFondo);
        pnlFondo.setLayout(pnlFondoLayout);
        pnlFondoLayout.setHorizontalGroup(
            pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlFondoLayout.createSequentialGroup()
                .addComponent(lblLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlFondoLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlFondoLayout.createSequentialGroup()
                                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(61, 61, 61)
                                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlFondoLayout.createSequentialGroup()
                                .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(lblDescripcion, javax.swing.GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE)
                                    .addComponent(lblCodigo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblSeccion, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(6, 6, 6)
                                .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cmbSeccion, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtCodigo)
                                    .addGroup(pnlFondoLayout.createSequentialGroup()
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE)))))
                        .addGap(190, 190, 190))
                    .addGroup(pnlFondoLayout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblInstitucion, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTitulo))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        pnlFondoLayout.setVerticalGroup(
            pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFondoLayout.createSequentialGroup()
                .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlFondoLayout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(lblLogo))
                    .addGroup(pnlFondoLayout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(lblTitulo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblInstitucion)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblCodigo)
                            .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblSeccion)
                            .addComponent(cmbSeccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblDescripcion)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar)
                    .addComponent(btnGuardar))
                .addContainerGap(283, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout lypnlFondoLayout = new javax.swing.GroupLayout(lypnlFondo);
        lypnlFondo.setLayout(lypnlFondoLayout);
        lypnlFondoLayout.setHorizontalGroup(
            lypnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlFondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        lypnlFondoLayout.setVerticalGroup(
            lypnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlFondo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        lypnlFondo.setLayer(pnlFondo, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lypnlFondo, javax.swing.GroupLayout.PREFERRED_SIZE, 635, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lypnlFondo, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        setBandera(true);
        
        obj.setCodigoInstitucion(1);
        obj.setCodigoSeccion(((Seccion) (cmbSeccion.getSelectedItem())).getCodigo());
        obj.setDescripcion(txtDescripcion.getText());
        obj.setEstado('A');
        
        logica.Insertar(obj);
        
        mensaje.MensajeInformacion("Se ha registrado correctamente", "Registrar");
        
        limpiar();
        
        this.dispose();
    }//GEN-LAST:event_btnGuardarActionPerformed

     public void limpiar(){
        txtCodigo.setText("");
        txtDescripcion.setText("");
    }
    
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
            java.util.logging.Logger.getLogger(NuevaSeccion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NuevaSeccion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NuevaSeccion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NuevaSeccion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                NuevaSeccion dialog = new NuevaSeccion(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JComboBox cmbSeccion;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCodigo;
    private javax.swing.JLabel lblDescripcion;
    private javax.swing.JLabel lblInstitucion;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblSeccion;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLayeredPane lypnlFondo;
    private javax.swing.JPanel pnlFondo;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextArea txtDescripcion;
    // End of variables declaration//GEN-END:variables

    public boolean isBandera() {
        return bandera;
    }

    public void setBandera(boolean bandera) {
        this.bandera = bandera;
    }
}
