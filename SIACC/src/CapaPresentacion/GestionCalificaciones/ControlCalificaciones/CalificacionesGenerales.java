package CapaPresentacion.GestionCalificaciones.ControlCalificaciones;

import CapaDatos.Entidades.GestionAcademica.Asignatura.Asignatura;
import CapaDatos.Entidades.GestionAcademica.Asignatura.Distributivo;
import CapaDatos.Entidades.GestionAcademica.Asignatura.Malla;
import CapaDatos.Entidades.GestionAcademica.Curso.Grado;
import CapaDatos.Entidades.GestionAcademica.Curso.Nivel;
import CapaDatos.Entidades.GestionAcademica.Curso.Paralelo;
import CapaDatos.Entidades.GestionAdministrativa.Institucional.AnioLectivo;
import CapaDatos.Entidades.GestionAdministrativa.Institucional.Institucion;
import CapaDatos.Entidades.GestionAdministrativa.Institucional.Seccion;
import CapaDatos.Entidades.GestionCalificaciones.Calificaciones;
import CapaDatos.Entidades.GestionCalificaciones.PeriodoAcademicos;
import CapaDatos.Entidades.GestionCalificaciones.TipoNota;
import CapaLogica.GestionAcademica.Asignatura.LogicaAsignatura;
import CapaLogica.GestionAcademica.Asignatura.LogicaDistributivo;
import CapaLogica.GestionAcademica.Asignatura.LogicaMallaCurricular;
import CapaLogica.GestionAcademica.Curso.LogicaGrado;
import CapaLogica.GestionAcademica.Curso.LogicaNivel;
import CapaLogica.GestionAcademica.Curso.LogicaParalelo;
import CapaLogica.GestionAdministrativa.Institucional.LogicaAnioLectivo;
import CapaLogica.GestionAdministrativa.Institucional.LogicaInstitucion;
import CapaLogica.GestionAdministrativa.Institucional.LogicaSecciones;
import CapaLogica.GestionCalificaciones.LogicaCalificaciones;
import CapaLogica.GestionCalificaciones.LogicaPeriodoAcademico;
import CapaLogica.GestionCalificaciones.LogicaTipoNota;
import CapaLogica.GestionEstudiantil.LogicaMatricula;
import CapaPresentacion.GestionAdministrativa.ConfiguracionSecciones.*;
import CapaPresentacion.Utilidades.Alertas.Mensajes;
import java.awt.Frame;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class CalificacionesGenerales extends javax.swing.JDialog {

    LogicaInstitucion logicaUnidadEducativa = new LogicaInstitucion();
    Institucion objInstituto = new Institucion();

    LogicaDistributivo logicaDistributivo = new LogicaDistributivo();
    LogicaMatricula logicaMatricula = new LogicaMatricula();

    LogicaCalificaciones logica = new LogicaCalificaciones();
    Calificaciones obj = new Calificaciones();
    
    String[] tblEtiquetaDistributivo = new String[]{"CODIGO",
        "DOCENTE",
        "CURSO",
        "ASIGNATURA"};

    String[] tblEtiquetaNomina = new String[]{"CODIGO",
        "CEDULA",
        "PRIMER NOMBRE",
        "SEGUNDO NOMBRE",
        "APELLIDO PATERNO",
        "APELLIDO MATERNO",
        "CURSO",
        "PARALELO",
        "SECCION"};

    Mensajes mensaje = new Mensajes();
    
    private long codigoGrado;
    private long codigoDistributivo;
    private long codigoPeriodo;
    private long codigoMatricula;

    public CalificacionesGenerales(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        try {
            listarQuimestres();
            listarTipoNota();

            if (rbtnQuimestre.isSelected()) {
                setCodigoPeriodo(((PeriodoAcademicos) cmbQuimestre.getSelectedItem()).getCodigo());
            }

            if (rbtnParcial.isSelected()) {
                setCodigoPeriodo(((PeriodoAcademicos) cmbParcial.getSelectedItem()).getCodigo());
            }

        } catch (SQLException ex) {
            Logger.getLogger(CalificacionesGenerales.class.getName()).log(Level.SEVERE, null, ex);
        }

        objInstituto = logicaUnidadEducativa.buscarInsititucionPorCod(1);
        lblInstitucion.setText(objInstituto.getNombre());
    }

    public void listarDistPorGrado(long codGrado) {
        tblListadoDistributivo.setModel(new DefaultTableModel(logicaDistributivo.ListarPorGrado(codGrado), tblEtiquetaDistributivo) {
            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return false;
            }
        });
    }

    public void listarMatrPorGrado(long codGrado) {
        tblListado.setModel(new DefaultTableModel(logicaMatricula.ListarPorGrado(codGrado), tblEtiquetaNomina) {
            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return false;
            }
        });
    }

    //Metodo para Listar Quimestres
    private void listarQuimestres() throws SQLException {
        ArrayList<PeriodoAcademicos> lista;
        lista = new LogicaPeriodoAcademico().listarQuimestres();
        cmbQuimestre.removeAllItems();
        for (int i = 0; i < lista.size(); i++) {
            cmbQuimestre.addItem(lista.get(i));
        }
    }

    //Metodo para Listar Tipo de Nota
    private void listarTipoNota() throws SQLException {
        ArrayList<TipoNota> lista;
        lista = new LogicaTipoNota().listarTipoNota();
        cmbTipoNota.removeAllItems();
        for (int i = 0; i < lista.size(); i++) {
            cmbTipoNota.addItem(lista.get(i));
        }
    }

    //Metodo para Listar Parciales
    private void listarParciales(long cod) throws SQLException {
        ArrayList<PeriodoAcademicos> lista;
        lista = new LogicaPeriodoAcademico().listarParciales(cod);
        cmbParcial.removeAllItems();
        for (int i = 0; i < lista.size(); i++) {
            cmbParcial.addItem(lista.get(i));
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGrpPeriodo = new javax.swing.ButtonGroup();
        lypnlFondo = new javax.swing.JLayeredPane();
        pnlFondo = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        lblInstitucion = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblListado = new javax.swing.JTable();
        tpnlPrincipal = new javax.swing.JTabbedPane();
        pnlCalificaciones = new javax.swing.JPanel();
        jLayeredPane2 = new javax.swing.JLayeredPane();
        cmbQuimestre = new javax.swing.JComboBox();
        lblQuimestre = new javax.swing.JLabel();
        lblParcial = new javax.swing.JLabel();
        cmbParcial = new javax.swing.JComboBox();
        btnAgregar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        lblParcial1 = new javax.swing.JLabel();
        cmbTipoNota = new javax.swing.JComboBox();
        lblCedula = new javax.swing.JLabel();
        txtNota = new javax.swing.JTextField();
        rbtnParcial = new javax.swing.JRadioButton();
        rbtnQuimestre = new javax.swing.JRadioButton();
        lblLogo = new javax.swing.JLabel();
        lblDocente = new javax.swing.JLabel();
        txtDocente = new javax.swing.JTextField();
        pnlGrado = new javax.swing.JPanel();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        lblCurso = new javax.swing.JLabel();
        txtCurso = new javax.swing.JTextField();
        lblParalelo = new javax.swing.JLabel();
        txtParalelo = new javax.swing.JTextField();
        lblAnioLectivo = new javax.swing.JLabel();
        txtAnioLectivo = new javax.swing.JTextField();
        txtAsignatura = new javax.swing.JTextField();
        lblAsignatura = new javax.swing.JLabel();
        lblParalelo1 = new javax.swing.JLabel();
        txtSeccion = new javax.swing.JTextField();
        btnSeleccionar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblListadoDistributivo = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Control de Calificaciones");

        pnlFondo.setBackground(new java.awt.Color(255, 255, 255));

        lblTitulo.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        lblTitulo.setText("Control de Calificaciones");

        lblInstitucion.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        lblInstitucion.setText("Institución");

        btnCancelar.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        tblListado.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        tblListado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CODIGO", "CEDULA", "PRIMER NOMBRE", "SEGUNDO NOMBRE", "APELLIDO PATERNO", "APELLIDO MATERNO", "CURSO", "PARALELO", "SECCION"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblListado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tblListadoMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tblListado);

        tpnlPrincipal.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N

        cmbQuimestre.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        cmbQuimestre.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbQuimestreItemStateChanged(evt);
            }
        });

        lblQuimestre.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        lblQuimestre.setText("Quimestre");

        lblParcial.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        lblParcial.setText("Parcial");

        cmbParcial.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N

        btnAgregar.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btnActualizar.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        lblParcial1.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        lblParcial1.setText("Tipo de Nota");

        cmbTipoNota.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N

        lblCedula.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        lblCedula.setText("Nota");

        txtNota.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N

        btnGrpPeriodo.add(rbtnParcial);
        rbtnParcial.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        rbtnParcial.setSelected(true);
        rbtnParcial.setText("Parcial");
        rbtnParcial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnParcialActionPerformed(evt);
            }
        });

        btnGrpPeriodo.add(rbtnQuimestre);
        rbtnQuimestre.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        rbtnQuimestre.setText("Quimestre");
        rbtnQuimestre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnQuimestreActionPerformed(evt);
            }
        });

        lblLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/CapaPresentacion/Imagenes/GestionCalificaciones/periodoAcademico.png"))); // NOI18N

        lblDocente.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        lblDocente.setText("Asignatura");

        txtDocente.setEditable(false);
        txtDocente.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N

        javax.swing.GroupLayout jLayeredPane2Layout = new javax.swing.GroupLayout(jLayeredPane2);
        jLayeredPane2.setLayout(jLayeredPane2Layout);
        jLayeredPane2Layout.setHorizontalGroup(
            jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(lblParcial1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
                    .addComponent(lblParcial, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblQuimestre, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblCedula, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblDocente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jLayeredPane2Layout.createSequentialGroup()
                        .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jLayeredPane2Layout.createSequentialGroup()
                        .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cmbQuimestre, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cmbParcial, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jLayeredPane2Layout.createSequentialGroup()
                                .addComponent(rbtnQuimestre)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE))
                            .addGroup(jLayeredPane2Layout.createSequentialGroup()
                                .addComponent(rbtnParcial, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addComponent(txtNota)
                    .addComponent(cmbTipoNota, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtDocente))
                .addGap(148, 148, 148)
                .addComponent(lblLogo)
                .addGap(86, 86, 86))
        );
        jLayeredPane2Layout.setVerticalGroup(
            jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jLayeredPane2Layout.createSequentialGroup()
                        .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmbQuimestre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblQuimestre)
                            .addComponent(rbtnQuimestre))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmbParcial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblParcial)
                            .addComponent(rbtnParcial))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmbTipoNota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblParcial1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblDocente)
                            .addComponent(txtDocente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(5, 5, 5)
                        .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblCedula)
                            .addComponent(txtNota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnActualizar)
                            .addComponent(btnAgregar))))
                .addContainerGap(82, Short.MAX_VALUE))
        );
        jLayeredPane2.setLayer(cmbQuimestre, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(lblQuimestre, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(lblParcial, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(cmbParcial, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(btnAgregar, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(btnActualizar, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(lblParcial1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(cmbTipoNota, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(lblCedula, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(txtNota, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(rbtnParcial, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(rbtnQuimestre, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(lblLogo, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(lblDocente, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(txtDocente, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout pnlCalificacionesLayout = new javax.swing.GroupLayout(pnlCalificaciones);
        pnlCalificaciones.setLayout(pnlCalificacionesLayout);
        pnlCalificacionesLayout.setHorizontalGroup(
            pnlCalificacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane2)
        );
        pnlCalificacionesLayout.setVerticalGroup(
            pnlCalificacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane2)
        );

        tpnlPrincipal.addTab("Calificaciones", pnlCalificaciones);

        lblCurso.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        lblCurso.setText("Curso");

        txtCurso.setEditable(false);
        txtCurso.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N

        lblParalelo.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        lblParalelo.setText("Paralelo");

        txtParalelo.setEditable(false);
        txtParalelo.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N

        lblAnioLectivo.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        lblAnioLectivo.setText("Año Lectivo");

        txtAnioLectivo.setEditable(false);
        txtAnioLectivo.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N

        txtAsignatura.setEditable(false);
        txtAsignatura.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N

        lblAsignatura.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        lblAsignatura.setText("Asignatura");

        lblParalelo1.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        lblParalelo1.setText("Sección");

        txtSeccion.setEditable(false);
        txtSeccion.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N

        btnSeleccionar.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        btnSeleccionar.setText("Seleccionar");
        btnSeleccionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionarActionPerformed(evt);
            }
        });

        tblListadoDistributivo.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        tblListadoDistributivo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CODIGO", "DOCENTE", "CURSO", "ASIGNATURA"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblListadoDistributivo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tblListadoDistributivoMouseReleased(evt);
            }
        });
        jScrollPane2.setViewportView(tblListadoDistributivo);

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane1Layout.createSequentialGroup()
                .addContainerGap(116, Short.MAX_VALUE)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jLayeredPane1Layout.createSequentialGroup()
                        .addComponent(lblAsignatura, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtAsignatura))
                    .addGroup(jLayeredPane1Layout.createSequentialGroup()
                        .addComponent(lblAnioLectivo, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtAnioLectivo))
                    .addGroup(jLayeredPane1Layout.createSequentialGroup()
                        .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(lblCurso, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblParalelo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtCurso)
                            .addComponent(txtParalelo, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblParalelo1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnSeleccionar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtSeccion, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(77, 77, 77))
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jLayeredPane1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 770, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCurso)
                    .addComponent(txtCurso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblParalelo)
                    .addComponent(txtParalelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblParalelo1)
                    .addComponent(txtSeccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAnioLectivo)
                    .addComponent(txtAnioLectivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSeleccionar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAsignatura)
                    .addComponent(txtAsignatura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(149, Short.MAX_VALUE))
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane1Layout.createSequentialGroup()
                    .addContainerGap(139, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );
        jLayeredPane1.setLayer(lblCurso, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(txtCurso, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(lblParalelo, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(txtParalelo, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(lblAnioLectivo, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(txtAnioLectivo, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(txtAsignatura, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(lblAsignatura, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(lblParalelo1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(txtSeccion, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(btnSeleccionar, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jScrollPane2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout pnlGradoLayout = new javax.swing.GroupLayout(pnlGrado);
        pnlGrado.setLayout(pnlGradoLayout);
        pnlGradoLayout.setHorizontalGroup(
            pnlGradoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1)
        );
        pnlGradoLayout.setVerticalGroup(
            pnlGradoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1)
        );

        tpnlPrincipal.addTab("Grado", pnlGrado);

        javax.swing.GroupLayout pnlFondoLayout = new javax.swing.GroupLayout(pnlFondo);
        pnlFondo.setLayout(pnlFondoLayout);
        pnlFondoLayout.setHorizontalGroup(
            pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFondoLayout.createSequentialGroup()
                .addGap(338, 338, 338)
                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(pnlFondoLayout.createSequentialGroup()
                .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlFondoLayout.createSequentialGroup()
                        .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlFondoLayout.createSequentialGroup()
                                .addGap(319, 319, 319)
                                .addComponent(lblTitulo))
                            .addGroup(pnlFondoLayout.createSequentialGroup()
                                .addGap(304, 304, 304)
                                .addComponent(lblInstitucion, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(pnlFondoLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tpnlPrincipal, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1))))
                .addContainerGap())
        );
        pnlFondoLayout.setVerticalGroup(
            pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFondoLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(lblTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblInstitucion)
                .addGap(11, 11, 11)
                .addComponent(tpnlPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCancelar)
                .addContainerGap(61, Short.MAX_VALUE))
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
            .addComponent(lypnlFondo, javax.swing.GroupLayout.PREFERRED_SIZE, 573, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        if (rbtnQuimestre.isSelected()) {
            setCodigoPeriodo(((PeriodoAcademicos) cmbQuimestre.getSelectedItem()).getCodigo());
        }

        if (rbtnParcial.isSelected()) {
            setCodigoPeriodo(((PeriodoAcademicos) cmbParcial.getSelectedItem()).getCodigo());
        }
        
        obj.setCodigoMatricula(codigoMatricula);
        obj.setCodigoDistributivo(codigoDistributivo);
        obj.setCodigoTipoNota(((TipoNota) cmbTipoNota.getSelectedItem()).getCodigo());
        obj.setCodigoPeriodoAcedemico(codigoPeriodo);
        obj.setNota(Float.parseFloat(txtNota.getText()));
        obj.setEstado('A');
        
        logica.Insertar(obj);

        mensaje.MensajeInformacion("Se ha registrado correctamente", "Registrar");
        
        txtNota.setText("0.00");
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed

    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnSeleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionarActionPerformed
        SeleccionGrado frm = new SeleccionGrado((Frame) this.getParent(), true);
        frm.setVisible(true);
        frm.setLocationRelativeTo(null);

        if (frm.isBandera() == true) {
            Grado obj = new LogicaGrado().buscarGradoPorCod(frm.getCodigo());
            Nivel nivel = new LogicaNivel().buscarNivelPorCod(obj.getCodigoNivel());
            txtCurso.setText(nivel.getNombre());
            Paralelo paralelo = new LogicaParalelo().buscarParaleloPorCod(obj.getCodigoParalelo());
            txtParalelo.setText(paralelo.getNombre());
            Seccion seccion = new LogicaSecciones().buscarSeccionPorCod(obj.getCodigoSeccion());
            txtSeccion.setText(seccion.getNombre());
            AnioLectivo anioLectivo = new LogicaAnioLectivo().buscarAnioLectivoPorCod(obj.getCodigoAnioLectivo());
            txtAnioLectivo.setText(anioLectivo.getAnioInicio() + " - " + anioLectivo.getAnioFin());

            setCodigoGrado(obj.getCodigo());

            listarDistPorGrado(obj.getCodigo());

            txtAsignatura.setText("");

            listarMatrPorGrado(obj.getCodigo());
        }
    }//GEN-LAST:event_btnSeleccionarActionPerformed

    private void tblListadoDistributivoMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblListadoDistributivoMouseReleased
        if (evt.getClickCount() == 2) {

            int fila = tblListadoDistributivo.getSelectedRow();
            long codigo = Long.parseLong((tblListadoDistributivo.getValueAt(fila, 0)).toString());

            setCodigoDistributivo(codigo);

            Distributivo obj = new LogicaDistributivo().buscarDistributivoPorCod(codigo);
            Malla objMalla = new LogicaMallaCurricular().buscarMallaPorCod(obj.getCodigoMallaCurricular());
            Asignatura asignatura = new LogicaAsignatura().buscarAsignaturaPorCod(objMalla.getCodigoAsignatura());
            txtAsignatura.setText(asignatura.getNombre());

            txtDocente.setText(asignatura.getNombre());
        }
    }//GEN-LAST:event_tblListadoDistributivoMouseReleased

    private void cmbQuimestreItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbQuimestreItemStateChanged

        try {
            if (cmbQuimestre.getSelectedIndex() > -1) {
                long codigoQuimestre = ((PeriodoAcademicos) cmbQuimestre.getSelectedItem()).getCodigo();
                listarParciales(codigoQuimestre);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.toString());
        }
    }//GEN-LAST:event_cmbQuimestreItemStateChanged

    private void rbtnQuimestreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnQuimestreActionPerformed
        System.out.println("Quimestre");
    }//GEN-LAST:event_rbtnQuimestreActionPerformed

    private void rbtnParcialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnParcialActionPerformed
        System.out.println("Parcial");
    }//GEN-LAST:event_rbtnParcialActionPerformed

    private void tblListadoMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblListadoMouseReleased
        if (evt.getClickCount() == 2) {

            int fila = tblListado.getSelectedRow();
            long codigo = Long.parseLong((tblListado.getValueAt(fila, 0)).toString());

            setCodigoMatricula(codigo);
        }
    }//GEN-LAST:event_tblListadoMouseReleased

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
            java.util.logging.Logger.getLogger(ConfiguracionSecciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConfiguracionSecciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConfiguracionSecciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConfiguracionSecciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ConfiguracionSecciones dialog = new ConfiguracionSecciones(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.ButtonGroup btnGrpPeriodo;
    private javax.swing.JButton btnSeleccionar;
    private javax.swing.JComboBox cmbParcial;
    private javax.swing.JComboBox cmbQuimestre;
    private javax.swing.JComboBox cmbTipoNota;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JLayeredPane jLayeredPane2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblAnioLectivo;
    private javax.swing.JLabel lblAsignatura;
    private javax.swing.JLabel lblCedula;
    private javax.swing.JLabel lblCurso;
    private javax.swing.JLabel lblDocente;
    private javax.swing.JLabel lblInstitucion;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblParalelo;
    private javax.swing.JLabel lblParalelo1;
    private javax.swing.JLabel lblParcial;
    private javax.swing.JLabel lblParcial1;
    private javax.swing.JLabel lblQuimestre;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLayeredPane lypnlFondo;
    private javax.swing.JPanel pnlCalificaciones;
    private javax.swing.JPanel pnlFondo;
    private javax.swing.JPanel pnlGrado;
    private javax.swing.JRadioButton rbtnParcial;
    private javax.swing.JRadioButton rbtnQuimestre;
    private javax.swing.JTable tblListado;
    private javax.swing.JTable tblListadoDistributivo;
    private javax.swing.JTabbedPane tpnlPrincipal;
    private javax.swing.JTextField txtAnioLectivo;
    private javax.swing.JTextField txtAsignatura;
    private javax.swing.JTextField txtCurso;
    private javax.swing.JTextField txtDocente;
    private javax.swing.JTextField txtNota;
    private javax.swing.JTextField txtParalelo;
    private javax.swing.JTextField txtSeccion;
    // End of variables declaration//GEN-END:variables

    public long getCodigoGrado() {
        return codigoGrado;
    }

    public void setCodigoGrado(long codigoGrado) {
        this.codigoGrado = codigoGrado;
    }

    public long getCodigoDistributivo() {
        return codigoDistributivo;
    }

    public void setCodigoDistributivo(long codigoDistributivo) {
        this.codigoDistributivo = codigoDistributivo;
    }

    public long getCodigoPeriodo() {
        return codigoPeriodo;
    }

    public void setCodigoPeriodo(long codigoPeriodo) {
        this.codigoPeriodo = codigoPeriodo;
    }

    public long getCodigoMatricula() {
        return codigoMatricula;
    }

    public void setCodigoMatricula(long codigoMatricula) {
        this.codigoMatricula = codigoMatricula;
    }
}
