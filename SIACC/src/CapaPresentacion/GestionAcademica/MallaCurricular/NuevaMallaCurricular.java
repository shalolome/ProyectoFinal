package CapaPresentacion.GestionAcademica.MallaCurricular;

import CapaDatos.Entidades.GestionAcademica.Asignatura.Asignatura;
import CapaDatos.Entidades.GestionAcademica.Asignatura.Malla;
import CapaDatos.Entidades.GestionAcademica.Curso.Nivel;
import CapaDatos.Entidades.GestionAdministrativa.Institucional.Institucion;
import CapaLogica.GestionAcademica.Asignatura.LogicaAsignatura;
import CapaLogica.GestionAcademica.Asignatura.LogicaMallaCurricular;
import CapaLogica.GestionAcademica.Curso.LogicaNivel;
import CapaLogica.GestionAdministrativa.Institucional.LogicaInstitucion;
import CapaPresentacion.Utilidades.Alertas.Mensajes;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class NuevaMallaCurricular extends javax.swing.JDialog {

    LogicaMallaCurricular logica = new LogicaMallaCurricular();
    Malla obj = new Malla();
    
    LogicaInstitucion logicaUnidadEducativa = new LogicaInstitucion();
    Institucion objInstituto = new Institucion();

    Mensajes mensaje = new Mensajes();
    private boolean bandera = false;
    
    public NuevaMallaCurricular(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        try {
            objInstituto = logicaUnidadEducativa.buscarInsititucionPorCod(1);
            lblInstitucion.setText(objInstituto.getNombre());
            listarAsignatura();
            listarNivel();
        } catch (SQLException ex) {
            Logger.getLogger(NuevaMallaCurricular.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //Metodo para Listar Asignaturas
    private void listarAsignatura() throws SQLException {
        ArrayList<Asignatura> lista;
        lista = new LogicaAsignatura().listarAsignatura();
        cmbAsignatura.removeAllItems();
        for (int i = 0; i < lista.size(); i++) {
            cmbAsignatura.addItem(lista.get(i));
        }
    }

    //Metodo para Listar Niveles o Cursos
    private void listarNivel() throws SQLException {
        ArrayList<Nivel> lista;
        lista = new LogicaNivel().listarNiveles();
        cmbCurso.removeAllItems();
        for (int i = 0; i < lista.size(); i++) {
            cmbCurso.addItem(lista.get(i));
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
        lblCurso = new javax.swing.JLabel();
        lblVigencia = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        cmbCurso = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtVigencia = new javax.swing.JTextArea();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        lblInstitucion = new javax.swing.JLabel();
        cmbAsignatura = new javax.swing.JComboBox();
        lblAsignatura = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Registro de Malla Curricular");

        pnlFondo.setBackground(new java.awt.Color(255, 255, 255));

        lblTitulo.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        lblTitulo.setText("Nueva Malla Curricular");

        lblLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/CapaPresentacion/Imagenes/GestionAcademica/mallaCurricular.png"))); // NOI18N

        lblCodigo.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        lblCodigo.setText("Referencia");

        lblCurso.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        lblCurso.setText("Curso");

        lblVigencia.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        lblVigencia.setText("Descripción");

        txtCodigo.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N

        cmbCurso.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N

        txtVigencia.setColumns(20);
        txtVigencia.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        txtVigencia.setRows(5);
        jScrollPane1.setViewportView(txtVigencia);

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

        cmbAsignatura.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N

        lblAsignatura.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        lblAsignatura.setText("Asignatura");

        javax.swing.GroupLayout pnlFondoLayout = new javax.swing.GroupLayout(pnlFondo);
        pnlFondo.setLayout(pnlFondoLayout);
        pnlFondoLayout.setHorizontalGroup(
            pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFondoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlFondoLayout.createSequentialGroup()
                        .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlFondoLayout.createSequentialGroup()
                                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(61, 61, 61)
                                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlFondoLayout.createSequentialGroup()
                                .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(lblVigencia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblCodigo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblCurso, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblAsignatura, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cmbCurso, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtCodigo)
                                    .addGroup(pnlFondoLayout.createSequentialGroup()
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(cmbAsignatura, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(190, 190, 190))
                    .addGroup(pnlFondoLayout.createSequentialGroup()
                        .addGap(74, 74, 74)
                        .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblInstitucion, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTitulo))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        pnlFondoLayout.setVerticalGroup(
            pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFondoLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(lblTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlFondoLayout.createSequentialGroup()
                        .addComponent(lblInstitucion)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblCodigo)
                            .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblCurso)
                            .addComponent(cmbCurso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblAsignatura)
                            .addComponent(cmbAsignatura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblVigencia)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(lblLogo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar)
                    .addComponent(btnGuardar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout lypnlFondoLayout = new javax.swing.GroupLayout(lypnlFondo);
        lypnlFondo.setLayout(lypnlFondoLayout);
        lypnlFondoLayout.setHorizontalGroup(
            lypnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlFondo, javax.swing.GroupLayout.PREFERRED_SIZE, 692, Short.MAX_VALUE)
        );
        lypnlFondoLayout.setVerticalGroup(
            lypnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlFondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        lypnlFondo.setLayer(pnlFondo, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lypnlFondo)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lypnlFondo)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        setBandera(true);

        obj.setNombre(txtCodigo.getText());
        obj.setCodigoCurso(((Nivel) (cmbCurso.getSelectedItem())).getCodigo());
        obj.setCodigoAsignatura(((Asignatura) (cmbAsignatura.getSelectedItem())).getCodigo());
        obj.setDescripcion(txtVigencia.getText());
        obj.setEstado('A');

        logica.Insertar(obj);

        mensaje.MensajeInformacion("Se ha registrado correctamente", "Registrar");

        limpiar();

        this.dispose();
    }//GEN-LAST:event_btnGuardarActionPerformed

    public void limpiar() {
        txtCodigo.setText("");
        txtVigencia.setText("");
        try {
            listarAsignatura();
            listarNivel();
        } catch (SQLException ex) {
            Logger.getLogger(NuevaMallaCurricular.class.getName()).log(Level.SEVERE, null, ex);
        }
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
            java.util.logging.Logger.getLogger(NuevaMallaCurricular.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NuevaMallaCurricular.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NuevaMallaCurricular.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NuevaMallaCurricular.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                NuevaMallaCurricular dialog = new NuevaMallaCurricular(new javax.swing.JFrame(), true);
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
    private javax.swing.JComboBox cmbAsignatura;
    private javax.swing.JComboBox cmbCurso;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAsignatura;
    private javax.swing.JLabel lblCodigo;
    private javax.swing.JLabel lblCurso;
    private javax.swing.JLabel lblInstitucion;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblVigencia;
    private javax.swing.JLayeredPane lypnlFondo;
    private javax.swing.JPanel pnlFondo;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextArea txtVigencia;
    // End of variables declaration//GEN-END:variables

    public boolean isBandera() {
        return bandera;
    }

    public void setBandera(boolean bandera) {
        this.bandera = bandera;
    }
}
