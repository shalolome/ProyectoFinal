package CapaPresentacion.GestionAcademica.ControlCursos;

import CapaDatos.Entidades.GestionAcademica.Curso.Grado;
import CapaDatos.Entidades.GestionAcademica.Curso.Nivel;
import CapaDatos.Entidades.GestionAcademica.Curso.Paralelo;
import CapaDatos.Entidades.GestionAdministrativa.Institucional.AnioLectivo;
import CapaDatos.Entidades.GestionAdministrativa.Institucional.Institucion;
import CapaDatos.Entidades.GestionAdministrativa.Institucional.Seccion;
import CapaLogica.GestionAcademica.Curso.LogicaGrado;
import CapaLogica.GestionAcademica.Curso.LogicaNivel;
import CapaLogica.GestionAcademica.Curso.LogicaParalelo;
import CapaLogica.GestionAdministrativa.Institucional.LogicaAnioLectivo;
import CapaLogica.GestionAdministrativa.Institucional.LogicaInstitucion;
import CapaLogica.GestionAdministrativa.Institucional.LogicaSecciones;
import CapaPresentacion.Utilidades.Alertas.Mensajes;
import CapaPresentacion.Utilidades.Validaciones.MetodosBusquedas;
import CapaPresentacion.Utilidades.Validaciones.Validaciones;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EditarCurso extends javax.swing.JDialog {

    LogicaGrado logica = new LogicaGrado();
    Grado obj = new Grado();

    LogicaInstitucion logicaUnidadEducativa = new LogicaInstitucion();
    Institucion objInstituto = new Institucion();

    Mensajes mensaje = new Mensajes();
    MetodosBusquedas buscar = new MetodosBusquedas();
    Validaciones validar = new Validaciones();
    
    private boolean bandera = false;
    private long codigo;

    public EditarCurso(java.awt.Frame parent, boolean modal, long cod) {
        super(parent, modal);
        initComponents();

        objInstituto = logicaUnidadEducativa.buscarInsititucionPorCod(1);
        lblInstitucion.setText(objInstituto.getNombre());
        try {
            listarNivel();
            listarSeccion();
            listarParalelo();
            listarAnioLectivo();
            
            MostrarInformacion(cod);
        } catch (SQLException ex) {
            Logger.getLogger(EditarCurso.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //Metodo para Listar Secciones
    private void listarSeccion() throws SQLException {
        ArrayList<Seccion> lista;
        lista = new LogicaSecciones().listarSecciones();
        cmbSeccion.removeAllItems();
        for (int i = 0; i < lista.size(); i++) {
            cmbSeccion.addItem(lista.get(i));
        }
    }

    //Metodo para Listar Cursos o Niveles
    private void listarNivel() throws SQLException {
        ArrayList<Nivel> lista;
        lista = new LogicaNivel().listarNiveles();
        cmbCurso.removeAllItems();
        for (int i = 0; i < lista.size(); i++) {
            cmbCurso.addItem(lista.get(i));
        }
    }

    //Metodo para Listar Paralelos
    private void listarParalelo() throws SQLException {
        ArrayList<Paralelo> lista;
        lista = new LogicaParalelo().listarParalelo();
        cmbParalelo.removeAllItems();
        for (int i = 0; i < lista.size(); i++) {
            cmbParalelo.addItem(lista.get(i));
        }
    }

    //Metodo para Listar Año Lectivo
    private void listarAnioLectivo() throws SQLException {
        ArrayList<AnioLectivo> lista;
        lista = new LogicaAnioLectivo().listarAnioLectivo();
        cmbAnioLectivo.removeAllItems();
        for (int i = 0; i < lista.size(); i++) {
            cmbAnioLectivo.addItem(lista.get(i));
        }
    }
    
    private void MostrarInformacion(long cod) {

        Grado objBuscar = logica.buscarGradoPorCod(cod);

        setCodigo(objBuscar.getCodigo());

        txtCodigo.setText(objBuscar.getNombre());

        Nivel objNivel = new LogicaNivel().buscarNivelPorCod(objBuscar.getCodigoNivel());
        cmbCurso.setSelectedIndex(buscar.retornarIndice(cmbCurso, objNivel.getNombre()));
        Seccion objSeccion = new LogicaSecciones().buscarSeccionPorCod(objBuscar.getCodigoSeccion());
        cmbSeccion.setSelectedIndex(buscar.retornarIndice(cmbSeccion, objSeccion.getNombre()));
        Paralelo objParalelo = new LogicaParalelo().buscarParaleloPorCod(objBuscar.getCodigoParalelo());
        cmbParalelo.setSelectedIndex(buscar.retornarIndice(cmbParalelo, objParalelo.getNombre()));
        AnioLectivo objAnioLect = new LogicaAnioLectivo().buscarAnioLectivoPorCod(objBuscar.getCodigoAnioLectivo());
        String periodo = objAnioLect.getAnioInicio()+" - " + objAnioLect.getAnioFin();
        cmbAnioLectivo.setSelectedIndex(buscar.retornarIndice(cmbAnioLectivo, periodo));
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
        txtCodigo = new javax.swing.JTextField();
        cmbCurso = new javax.swing.JComboBox();
        btnActualizar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        lblInstitucion = new javax.swing.JLabel();
        cmbParalelo = new javax.swing.JComboBox();
        lblParalelo = new javax.swing.JLabel();
        lblCurso1 = new javax.swing.JLabel();
        cmbSeccion = new javax.swing.JComboBox();
        lblAsignatura1 = new javax.swing.JLabel();
        cmbAnioLectivo = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Actualización de Curso");

        pnlFondo.setBackground(new java.awt.Color(255, 255, 255));

        lblTitulo.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        lblTitulo.setText("Actualización de Curso");

        lblLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/CapaPresentacion/Imagenes/GestionAcademica/cursos.png"))); // NOI18N

        lblCodigo.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        lblCodigo.setText("Referencia");

        lblCurso.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        lblCurso.setText("Curso");

        txtCodigo.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        txtCodigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCodigoKeyTyped(evt);
            }
        });

        cmbCurso.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N

        btnActualizar.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
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

        cmbParalelo.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N

        lblParalelo.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        lblParalelo.setText("Paralelo");

        lblCurso1.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        lblCurso1.setText("Sección");

        cmbSeccion.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N

        lblAsignatura1.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        lblAsignatura1.setText("Año Lectivo");

        cmbAnioLectivo.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N

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
                        .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(61, 61, 61)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(190, 190, 190))
                    .addGroup(pnlFondoLayout.createSequentialGroup()
                        .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlFondoLayout.createSequentialGroup()
                                .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(lblAsignatura1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblCodigo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblCurso, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblParalelo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE)
                                    .addComponent(lblCurso1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cmbSeccion, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cmbCurso, 0, 386, Short.MAX_VALUE)
                                    .addComponent(cmbParalelo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cmbAnioLectivo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(pnlFondoLayout.createSequentialGroup()
                                        .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))))
                            .addGroup(pnlFondoLayout.createSequentialGroup()
                                .addGap(74, 74, 74)
                                .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lblTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblInstitucion, javax.swing.GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE))))
                        .addContainerGap())))
        );
        pnlFondoLayout.setVerticalGroup(
            pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFondoLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(lblTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnlFondoLayout.createSequentialGroup()
                        .addComponent(lblInstitucion)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblCodigo)
                            .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblCurso1)
                            .addComponent(cmbSeccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblCurso)
                            .addComponent(cmbCurso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblParalelo)
                            .addComponent(cmbParalelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(lblLogo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAsignatura1)
                    .addComponent(cmbAnioLectivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar)
                    .addComponent(btnActualizar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout lypnlFondoLayout = new javax.swing.GroupLayout(lypnlFondo);
        lypnlFondo.setLayout(lypnlFondoLayout);
        lypnlFondoLayout.setHorizontalGroup(
            lypnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlFondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        setBandera(true);

        obj.setCodigo(codigo);
        
        obj.setNombre(txtCodigo.getText());
        obj.setCodigoNivel(((Nivel) (cmbCurso.getSelectedItem())).getCodigo());
        obj.setCodigoSeccion(((Seccion) (cmbSeccion.getSelectedItem())).getCodigo());
        obj.setCodigoParalelo(((Paralelo) (cmbParalelo.getSelectedItem())).getCodigo());
        obj.setCodigoAnioLectivo(((AnioLectivo) (cmbAnioLectivo.getSelectedItem())).getCodigo());

        logica.Actualizar(obj);

        mensaje.MensajeInformacion("Se ha editado correctamente", "EDITAR");

        limpiar();

        this.dispose();
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void txtCodigoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoKeyTyped
        validar.convMayNumEscap(evt);
    }//GEN-LAST:event_txtCodigoKeyTyped

    public void limpiar() {
        txtCodigo.setText("");
        try {       
            listarNivel();
            listarSeccion();
            listarParalelo();
            listarAnioLectivo();
        } catch (SQLException ex) {
            Logger.getLogger(EditarCurso.class.getName()).log(Level.SEVERE, null, ex);
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
            java.util.logging.Logger.getLogger(EditarCurso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditarCurso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditarCurso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditarCurso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                EditarCurso dialog = new EditarCurso(new javax.swing.JFrame(), true, 0);
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
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JComboBox cmbAnioLectivo;
    private javax.swing.JComboBox cmbCurso;
    private javax.swing.JComboBox cmbParalelo;
    private javax.swing.JComboBox cmbSeccion;
    private javax.swing.JLabel lblAsignatura1;
    private javax.swing.JLabel lblCodigo;
    private javax.swing.JLabel lblCurso;
    private javax.swing.JLabel lblCurso1;
    private javax.swing.JLabel lblInstitucion;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblParalelo;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLayeredPane lypnlFondo;
    private javax.swing.JPanel pnlFondo;
    private javax.swing.JTextField txtCodigo;
    // End of variables declaration//GEN-END:variables

    public boolean isBandera() {
        return bandera;
    }

    public void setBandera(boolean bandera) {
        this.bandera = bandera;
    }

    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }
}
