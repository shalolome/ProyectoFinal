
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
import CapaPresentacion.Utilidades.Alertas.Mensajes;
import CapaPresentacion.Utilidades.Validaciones.MetodosBusquedas;
import java.awt.Frame;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class EditarInfoInstitucional extends javax.swing.JDialog {

    LogicaInstitucion logica = new LogicaInstitucion();
    Institucion obj = new Institucion();

    Mensajes mensaje = new Mensajes();
    MetodosBusquedas buscar = new MetodosBusquedas();
    private boolean bandera = false;
    private long codigo;
    private long codigoPersonal;
    
    public EditarInfoInstitucional(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        try {
            listarProvincia();
        } catch (SQLException ex) {
            Logger.getLogger(EditarInfoInstitucional.class.getName()).log(Level.SEVERE, null, ex);
        }
        MostrarInformacion(1);
    }

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
        Canton objCanton = new LogicaCanton().buscarCanton(objParroquia.getCodigoCanton());
        Provincia objProvincia = new LogicaProvincia().buscarProvinciaPorCod(objCanton.getCodigoProvincia());
        
        cmbProvincia.setSelectedIndex(buscar.retornarIndice(cmbProvincia, objProvincia.getNombreProvincia()));
        cmbCanton.setSelectedIndex(buscar.retornarIndice(cmbCanton, objCanton.getNombreCanton()));
        cmbParroquia.setSelectedIndex(buscar.retornarIndice(cmbParroquia, objParroquia.getNombreParroquia()));

        txtTelefono1.setText(objBuscar.getTelefono1());
        txtTelefono2.setText(objBuscar.getTelefono2());
        txtCelular1.setText(objBuscar.getCelular1());
        txtCelular2.setText(objBuscar.getCelular2());
        txtFax.setText(objBuscar.getFax());
        txtEmail.setText(objBuscar.getCorreo());
        txtDireccion.setText(objBuscar.getDireccion());
    }
    
    //Metodo para Listar Provincias
    private void listarProvincia() throws SQLException {
        ArrayList<Provincia> lista;
        lista = new LogicaProvincia().listarProvincias();
        cmbProvincia.removeAllItems();
        for (int i = 0; i < lista.size(); i++) {
            cmbProvincia.addItem(lista.get(i));
        }
    }

    //Metodo para Listar Cantones
    private void listarCanton(long cod) throws SQLException {
        ArrayList<Canton> lista;
        lista = new LogicaCanton().listarCantones(cod);
        cmbCanton.removeAllItems();
        for (int i = 0; i < lista.size(); i++) {
            cmbCanton.addItem(lista.get(i));
        }
    }

    //Metodo para Listar Parroquias
    private void listarParroquia(long cod) throws SQLException {
        ArrayList<Parroquia> lista;
        lista = new LogicaParroquia().listarParroquias(cod);
        cmbParroquia.removeAllItems();
        for (int i = 0; i < lista.size(); i++) {
            cmbParroquia.addItem(lista.get(i));
        }
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
        txtNombre = new javax.swing.JTextField();
        txtCodigoDistrito = new javax.swing.JTextField();
        txtRepresentante = new javax.swing.JTextField();
        cmbProvincia = new javax.swing.JComboBox();
        cmbCanton = new javax.swing.JComboBox();
        cmbParroquia = new javax.swing.JComboBox();
        txtTelefono1 = new javax.swing.JTextField();
        txtTelefono2 = new javax.swing.JTextField();
        txtCelular1 = new javax.swing.JTextField();
        txtCelular2 = new javax.swing.JTextField();
        txtFax = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDireccion = new javax.swing.JTextArea();
        btnActualizar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnSeleccionar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Actualización de Información Institucional");

        pnlFondo.setBackground(new java.awt.Color(255, 255, 255));

        lblTitulo.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        lblTitulo.setText("Actualización de Información Institucional");

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

        txtNombre.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N

        txtCodigoDistrito.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N

        txtRepresentante.setEditable(false);
        txtRepresentante.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N

        cmbProvincia.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        cmbProvincia.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbProvinciaItemStateChanged(evt);
            }
        });

        cmbCanton.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        cmbCanton.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbCantonItemStateChanged(evt);
            }
        });

        cmbParroquia.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N

        txtTelefono1.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N

        txtTelefono2.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N

        txtCelular1.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N

        txtCelular2.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N

        txtFax.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N

        txtEmail.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N

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

        btnSeleccionar.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        btnSeleccionar.setText("Seleccionar");
        btnSeleccionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlFondoLayout = new javax.swing.GroupLayout(pnlFondo);
        pnlFondo.setLayout(pnlFondoLayout);
        pnlFondoLayout.setHorizontalGroup(
            pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFondoLayout.createSequentialGroup()
                .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                            .addComponent(txtNombre)
                            .addComponent(txtCodigoDistrito, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtTelefono1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtTelefono2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtCelular1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtCelular2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtFax, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtEmail, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1)
                            .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(cmbParroquia, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cmbCanton, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cmbProvincia, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlFondoLayout.createSequentialGroup()
                                    .addComponent(txtRepresentante, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnSeleccionar)))))
                    .addGroup(pnlFondoLayout.createSequentialGroup()
                        .addGap(127, 127, 127)
                        .addComponent(lblTitulo)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(pnlFondoLayout.createSequentialGroup()
                        .addGap(169, 169, 169)
                        .addComponent(btnActualizar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCancelar)
                        .addGap(148, 148, 148)))
                .addContainerGap())
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
                        .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblNombre)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblCodigoDistrito)
                            .addComponent(txtCodigoDistrito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblRepresentante)
                            .addComponent(txtRepresentante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSeleccionar))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblProvincia)
                            .addComponent(cmbProvincia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblCanton)
                            .addComponent(cmbCanton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblParroquia)
                            .addComponent(cmbParroquia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblTelefono1)
                            .addComponent(txtTelefono1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblTelefono2)
                            .addComponent(txtTelefono2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblCelular1)
                            .addComponent(txtCelular1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblCelular2)
                            .addComponent(txtCelular2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblFax)
                            .addComponent(txtFax, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblEmail)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblDireccion)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
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

    private void cmbProvinciaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbProvinciaItemStateChanged
        try {
            if(cmbProvincia.getSelectedIndex()>-1){
                long codigoProvincia = ((Provincia) cmbProvincia.getSelectedItem()).getCodigoProvincia();
                listarCanton(codigoProvincia);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.toString());
        }
    }//GEN-LAST:event_cmbProvinciaItemStateChanged

    private void cmbCantonItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbCantonItemStateChanged
        try {
            if(cmbCanton.getSelectedIndex()>-1){
                long codigoCanton = ((Canton) cmbCanton.getSelectedItem()).getCodigoCanton();
                listarParroquia(codigoCanton);
            }else{
                cmbParroquia.removeAllItems();
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.toString());
        }
    }//GEN-LAST:event_cmbCantonItemStateChanged

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        setBandera(true);

        obj.setCodigo(codigo);
        obj.setCodigoRepresentante(1);
        obj.setCodigoParroquia(((Parroquia) cmbParroquia.getSelectedItem()).getCodigoParroquia());
        obj.setNombre(txtNombre.getText());
        obj.setCodigoDistrito(txtCodigoDistrito.getText());
        obj.setTelefono1(txtTelefono1.getText());
        obj.setTelefono2(txtTelefono2.getText());
        obj.setCelular1(txtCelular1.getText());
        obj.setCelular2(txtCelular2.getText());
        obj.setFax(txtFax.getText());
        obj.setCorreo(txtEmail.getText());
        obj.setDireccion(txtDireccion.getText());

        logica.Actualizar(obj);

        mensaje.MensajeInformacion("Se ha editado correctamente", "EDITAR");
        this.dispose();
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnSeleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionarActionPerformed
        SeleccionAsigCargos frm = new SeleccionAsigCargos((Frame) this.getParent(), true);
        frm.setVisible(true);
        frm.setLocationRelativeTo(null);

        if (frm.isBandera()) {
            //yum -y install paquete 
            Personal obj = new LogicaPersonalAdministrativo().buscarPersonalPorCod(frm.getCodigo());
            Persona persona = new LogicaPersona().buscarPersonaPorCod(obj.getCodigo());
            setCodigoPersonal(frm.getCodigo());
            txtRepresentante.setText(persona.getPrimerNombre()+" "+persona.getSegundoNombre()+" "+
                                persona.getApellidoPaterno()+" "+persona.getApellidoMaterno());
        }
    }//GEN-LAST:event_btnSeleccionarActionPerformed

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
            java.util.logging.Logger.getLogger(EditarInfoInstitucional.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditarInfoInstitucional.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditarInfoInstitucional.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditarInfoInstitucional.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                EditarInfoInstitucional dialog = new EditarInfoInstitucional(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnSeleccionar;
    private javax.swing.JComboBox cmbCanton;
    private javax.swing.JComboBox cmbParroquia;
    private javax.swing.JComboBox cmbProvincia;
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
    private javax.swing.JTextField txtCelular1;
    private javax.swing.JTextField txtCelular2;
    private javax.swing.JTextField txtCodigoDistrito;
    private javax.swing.JTextArea txtDireccion;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtFax;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtRepresentante;
    private javax.swing.JTextField txtTelefono1;
    private javax.swing.JTextField txtTelefono2;
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

    public long getCodigoPersonal() {
        return codigoPersonal;
    }

    public void setCodigoPersonal(long codigoPersonal) {
        this.codigoPersonal = codigoPersonal;
    }
}
