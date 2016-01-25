package CapaPresentacion.GestionAdministrativa.ControlInformacionInstitucional;

import CapaDatos.Entidades.GestionAdministrativa.Categorias.Canton;
import CapaDatos.Entidades.GestionAdministrativa.Categorias.Parroquia;
import CapaDatos.Entidades.GestionAdministrativa.Categorias.Persona;
import CapaDatos.Entidades.GestionAdministrativa.Categorias.Provincia;
import CapaDatos.Entidades.GestionAdministrativa.Institucional.AsigCargos;
import CapaDatos.Entidades.GestionAdministrativa.Institucional.Institucion;
import CapaDatos.Entidades.GestionAdministrativa.Institucional.Personal;
import CapaLogica.GestionAdministrativa.Categorias.LogicaCanton;
import CapaLogica.GestionAdministrativa.Categorias.LogicaParroquia;
import CapaLogica.GestionAdministrativa.Categorias.LogicaPersona;
import CapaLogica.GestionAdministrativa.Categorias.LogicaProvincia;
import CapaLogica.GestionAdministrativa.Institucional.LogicaAsignacionCargos;
import CapaLogica.GestionAdministrativa.Institucional.LogicaInstitucion;
import CapaLogica.GestionAdministrativa.Institucional.LogicaPersonalAdministrativo;
import java.awt.Frame;

public class InformacionInstitucional extends javax.swing.JDialog {

    LogicaInstitucion logica = new LogicaInstitucion();

    private long codigo;

    public InformacionInstitucional(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        MostrarInformacion(1);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lypnlFondo = new javax.swing.JLayeredPane();
        pnlFondo = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        lblLogo = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        lblCodigoDistrito = new javax.swing.JLabel();
        lblRepresentante = new javax.swing.JLabel();
        lblProvincia = new javax.swing.JLabel();
        lblCanton = new javax.swing.JLabel();
        lblParroquia = new javax.swing.JLabel();
        lblTelefono1 = new javax.swing.JLabel();
        lblTelefono2 = new javax.swing.JLabel();
        lblCelular1 = new javax.swing.JLabel();
        lblCelular2 = new javax.swing.JLabel();
        lblFax = new javax.swing.JLabel();
        lblEmail = new javax.swing.JLabel();
        lblDireccion = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDireccion = new javax.swing.JTextArea();
        btnActualizar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        txtNombre = new javax.swing.JLabel();
        txtCodigoDistrito = new javax.swing.JLabel();
        txtRepresentante = new javax.swing.JLabel();
        txtProvincia = new javax.swing.JLabel();
        txtCanton = new javax.swing.JLabel();
        txtParroquia = new javax.swing.JLabel();
        txtTelefono1 = new javax.swing.JLabel();
        txtTelefono2 = new javax.swing.JLabel();
        txtCelular1 = new javax.swing.JLabel();
        txtCelular2 = new javax.swing.JLabel();
        txtFax = new javax.swing.JLabel();
        txtEmail = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Información Institucional");

        pnlFondo.setBackground(new java.awt.Color(255, 255, 255));

        lblTitulo.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        lblTitulo.setText("Información Institucional");

        lblLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/CapaPresentacion/Imagenes/GestionAdministrativa/institucion.png"))); // NOI18N

        lblNombre.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        lblNombre.setText("Nombre");

        lblCodigoDistrito.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        lblCodigoDistrito.setText("Código del Distrito");

        lblRepresentante.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        lblRepresentante.setText("Representante");

        lblProvincia.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        lblProvincia.setText("Provincia");

        lblCanton.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        lblCanton.setText("Cantón");

        lblParroquia.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        lblParroquia.setText("Parroquia");

        lblTelefono1.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        lblTelefono1.setText("Teléfono 1");

        lblTelefono2.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        lblTelefono2.setText("Teléfono 2");

        lblCelular1.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        lblCelular1.setText("Celular 1");

        lblCelular2.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        lblCelular2.setText("Celular 2");

        lblFax.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        lblFax.setText("Fax");

        lblEmail.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        lblEmail.setText("Email");

        lblDireccion.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        lblDireccion.setText("Dirección");

        txtDireccion.setEditable(false);
        txtDireccion.setColumns(20);
        txtDireccion.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        txtDireccion.setRows(5);
        jScrollPane1.setViewportView(txtDireccion);

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

        txtNombre.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        txtNombre.setText("Nombre");

        txtCodigoDistrito.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        txtCodigoDistrito.setText("Código del Distrito");

        txtRepresentante.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        txtRepresentante.setText("Representante");

        txtProvincia.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        txtProvincia.setText("Provincia");

        txtCanton.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        txtCanton.setText("Cantón");

        txtParroquia.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        txtParroquia.setText("Parroquia");

        txtTelefono1.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        txtTelefono1.setText("Telefono 1");

        txtTelefono2.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        txtTelefono2.setText("Telefono 2");

        txtCelular1.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        txtCelular1.setText("Celular 1");

        txtCelular2.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        txtCelular2.setText("Celular 2");

        txtFax.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        txtFax.setText("Fax");

        txtEmail.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        txtEmail.setText("Email");

        javax.swing.GroupLayout pnlFondoLayout = new javax.swing.GroupLayout(pnlFondo);
        pnlFondo.setLayout(pnlFondoLayout);
        pnlFondoLayout.setHorizontalGroup(
            pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFondoLayout.createSequentialGroup()
                .addComponent(lblLogo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblCodigoDistrito, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblRepresentante, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblProvincia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblCanton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblParroquia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTelefono1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTelefono2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblCelular1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblCelular2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblFax, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblEmail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblDireccion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(txtNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtCodigoDistrito, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtRepresentante, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtProvincia, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtCanton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtParroquia, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtTelefono1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtTelefono2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtCelular1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtCelular2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtFax, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtEmail, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(pnlFondoLayout.createSequentialGroup()
                .addGap(150, 150, 150)
                .addComponent(btnActualizar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCancelar)
                .addGap(158, 158, 158))
            .addGroup(pnlFondoLayout.createSequentialGroup()
                .addGap(219, 219, 219)
                .addComponent(lblTitulo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlFondoLayout.setVerticalGroup(
            pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFondoLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(lblTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlFondoLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblNombre)
                            .addComponent(txtNombre))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblCodigoDistrito)
                            .addComponent(txtCodigoDistrito))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblRepresentante)
                            .addComponent(txtRepresentante))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblProvincia)
                            .addComponent(txtProvincia))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblCanton)
                            .addComponent(txtCanton))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblParroquia)
                            .addComponent(txtParroquia))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblTelefono1)
                            .addComponent(txtTelefono1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblTelefono2)
                            .addComponent(txtTelefono2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblCelular1)
                            .addComponent(txtCelular1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblCelular2)
                            .addComponent(txtCelular2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblFax)
                            .addComponent(txtFax))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblEmail)
                            .addComponent(txtEmail))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblDireccion)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCancelar)
                    .addComponent(btnActualizar))
                .addContainerGap(14, Short.MAX_VALUE))
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
            .addComponent(lypnlFondo)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lypnlFondo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void MostrarInformacion(long cod) {

        Institucion objBuscar = logica.buscarInsititucionPorCod(cod);

        setCodigo(objBuscar.getCodigo());
        txtNombre.setText(objBuscar.getNombre());
        txtCodigoDistrito.setText(objBuscar.getCodigoDistrito());

        AsigCargos objAsigCargos = new LogicaAsignacionCargos().buscarAsigCargoPorCod(objBuscar.getCodigoRepresentante());
        Personal objPersonal = new LogicaPersonalAdministrativo().buscarPersonalPorCod(objAsigCargos.getCodigoPersona());
        Persona objPersona = new LogicaPersona().buscarPersonaPorCod(objPersonal.getCodigo());
        txtRepresentante.setText(objPersona.getPrimerNombre() + " " + objPersona.getSegundoNombre()
                + " " + objPersona.getApellidoPaterno() + " " + objPersona.getApellidoMaterno());

        Parroquia objParroquia = new LogicaParroquia().buscarParroquia(objBuscar.getCodigoParroquia());
        txtParroquia.setText(objParroquia.getNombreParroquia());
        Canton objCanton = new LogicaCanton().buscarCanton(objParroquia.getCodigoCanton());
        txtCanton.setText(objCanton.getNombreCanton());
        Provincia objProvincia = new LogicaProvincia().buscarProvinciaPorCod(objCanton.getCodigoProvincia());
        txtProvincia.setText(objProvincia.getNombreProvincia());

        txtTelefono1.setText(objBuscar.getTelefono1());
        txtTelefono2.setText(objBuscar.getTelefono2());
        txtCelular1.setText(objBuscar.getCelular1());
        txtCelular2.setText(objBuscar.getCelular2());
        txtFax.setText(objBuscar.getFax());
        txtEmail.setText(objBuscar.getCorreo());
        txtDireccion.setText(objBuscar.getDireccion());
    }

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        EditarInfoInstitucional frm = new EditarInfoInstitucional((Frame) this.getParent(), true);
        frm.setLocationRelativeTo(null);
        frm.setVisible(true);

        if (frm.isBandera() == true) {
            MostrarInformacion(codigo);
        }
    }//GEN-LAST:event_btnActualizarActionPerformed

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
            java.util.logging.Logger.getLogger(InformacionInstitucional.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InformacionInstitucional.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InformacionInstitucional.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InformacionInstitucional.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                InformacionInstitucional dialog = new InformacionInstitucional(new javax.swing.JFrame(), true);
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCanton;
    private javax.swing.JLabel lblCelular1;
    private javax.swing.JLabel lblCelular2;
    private javax.swing.JLabel lblCodigoDistrito;
    private javax.swing.JLabel lblDireccion;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblFax;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblParroquia;
    private javax.swing.JLabel lblProvincia;
    private javax.swing.JLabel lblRepresentante;
    private javax.swing.JLabel lblTelefono1;
    private javax.swing.JLabel lblTelefono2;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLayeredPane lypnlFondo;
    private javax.swing.JPanel pnlFondo;
    private javax.swing.JLabel txtCanton;
    private javax.swing.JLabel txtCelular1;
    private javax.swing.JLabel txtCelular2;
    private javax.swing.JLabel txtCodigoDistrito;
    private javax.swing.JTextArea txtDireccion;
    private javax.swing.JLabel txtEmail;
    private javax.swing.JLabel txtFax;
    private javax.swing.JLabel txtNombre;
    private javax.swing.JLabel txtParroquia;
    private javax.swing.JLabel txtProvincia;
    private javax.swing.JLabel txtRepresentante;
    private javax.swing.JLabel txtTelefono1;
    private javax.swing.JLabel txtTelefono2;
    // End of variables declaration//GEN-END:variables

    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }
}
