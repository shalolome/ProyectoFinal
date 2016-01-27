
package CapaPresentacion.GestionCalificaciones.ControlActas;

import CapaDatos.Entidades.GestionAcademica.Asignatura.Asignatura;
import CapaDatos.Entidades.GestionAcademica.Asignatura.Distributivo;
import CapaDatos.Entidades.GestionAcademica.Asignatura.Malla;
import CapaDatos.Entidades.GestionAcademica.Curso.Grado;
import CapaDatos.Entidades.GestionAcademica.Curso.Nivel;
import CapaDatos.Entidades.GestionAcademica.Curso.Paralelo;
import CapaDatos.Entidades.GestionAdministrativa.Institucional.AnioLectivo;
import CapaDatos.Entidades.GestionAdministrativa.Institucional.Institucion;
import CapaDatos.Entidades.GestionAdministrativa.Institucional.Seccion;
import CapaDatos.Entidades.GestionCalificaciones.Acta;
import CapaDatos.Entidades.GestionCalificaciones.Calificaciones;
import CapaDatos.Entidades.GestionCalificaciones.DetalleActaParcial;
import CapaDatos.Entidades.GestionCalificaciones.PeriodoAcademicos;
import CapaLogica.GestionAcademica.Asignatura.LogicaAsignatura;
import CapaLogica.GestionAcademica.Asignatura.LogicaDistributivo;
import CapaLogica.GestionAcademica.Asignatura.LogicaMallaCurricular;
import CapaLogica.GestionAcademica.Curso.LogicaGrado;
import CapaLogica.GestionAcademica.Curso.LogicaNivel;
import CapaLogica.GestionAcademica.Curso.LogicaParalelo;
import CapaLogica.GestionAdministrativa.Institucional.LogicaAnioLectivo;
import CapaLogica.GestionAdministrativa.Institucional.LogicaInstitucion;
import CapaLogica.GestionAdministrativa.Institucional.LogicaSecciones;
import CapaLogica.GestionCalificaciones.LogicaActa;
import CapaLogica.GestionCalificaciones.LogicaCalificaciones;
import CapaLogica.GestionCalificaciones.LogicaDetalleParcial;
import CapaLogica.GestionCalificaciones.LogicaPeriodoAcademico;
import CapaLogica.GestionEstudiantil.LogicaMatricula;
import CapaPresentacion.GestionAdministrativa.ConfiguracionSecciones.*;
import CapaPresentacion.Utilidades.Alertas.Mensajes;
import CapaPresentacion.Utilidades.Validaciones.Validaciones;
import java.awt.Frame;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class CalificacionesParciales extends javax.swing.JDialog {

    LogicaInstitucion logicaUnidadEducativa = new LogicaInstitucion();
    Institucion objInstituto = new Institucion();
    
    LogicaDistributivo logicaDistributivo = new LogicaDistributivo();
    LogicaMatricula logicaMatricula = new LogicaMatricula();
    
    Validaciones validar = new Validaciones();
    Mensajes mensaje = new Mensajes();
    
    String[] tblEtiquetaDistributivo = new String[]{"CODIGO",
        "DOCENTE",
        "CURSO",
        "ASIGNATURA"};
    
    String[] tblEtiquetaNomina = new String[]{"CODIGO",
        "ESTUDIANTE",
        "T.A.I.",
        "A.I.C",
        "A.G.C.",
        "L.O.E.",
        "EVALUACION",
        "PROMEDIO"};
    
    private long codigoDistributivo;
    private long codigoGrado;
    
    public CalificacionesParciales(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        try {
            listarQuimestres();
        } catch (SQLException ex) {
            Logger.getLogger(CalificacionesParciales.class.getName()).log(Level.SEVERE, null, ex);
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
        tblListado.setModel(new DefaultTableModel(logicaMatricula.ListarEstudiante(codGrado), tblEtiquetaNomina) {
            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return false;
            }
        });
    }
    
    private void actualizarNotas(){
        
        long codPerid = ((PeriodoAcademicos) cmbParcial.getSelectedItem()).getCodigo();
        
        for (int i = 0; i < tblListado.getRowCount(); i++) {
            long codMatri = Long.parseLong(String.valueOf(tblListado.getValueAt(i, 0)));
            
            Calificaciones objTipoNota = new Calificaciones();
            
            //////////////////////////////////////////////////////////////////////////////////////////////
            objTipoNota = new LogicaCalificaciones().buscarNotaPorTipo(codMatri,codigoDistributivo,codPerid, 1);
            if (objTipoNota != null) {
                tblListado.setValueAt(validar.Redondeo(Float.parseFloat(objTipoNota.getTotalNota())), i, 2);
            }
             //////////////////////////////////////////////////////////////////////////////////////////////
            
            //////////////////////////////////////////////////////////////////////////////////////////////
            objTipoNota = new LogicaCalificaciones().buscarNotaPorTipo(codMatri,codigoDistributivo,codPerid, 2);
            if (objTipoNota != null) {
                tblListado.setValueAt(validar.Redondeo(Float.parseFloat(objTipoNota.getTotalNota())), i, 3);
            }
             //////////////////////////////////////////////////////////////////////////////////////////////
            
            //////////////////////////////////////////////////////////////////////////////////////////////
            objTipoNota = new LogicaCalificaciones().buscarNotaPorTipo(codMatri,codigoDistributivo,codPerid, 3);
            if (objTipoNota != null) {
                tblListado.setValueAt(validar.Redondeo(Float.parseFloat(objTipoNota.getTotalNota())), i, 4);
            }
             //////////////////////////////////////////////////////////////////////////////////////////////
            
            //////////////////////////////////////////////////////////////////////////////////////////////
            objTipoNota = new LogicaCalificaciones().buscarNotaPorTipo(codMatri,codigoDistributivo,codPerid, 4);
            if (objTipoNota != null) {
                tblListado.setValueAt(validar.Redondeo(Float.parseFloat(objTipoNota.getTotalNota())), i, 5);
            }
             //////////////////////////////////////////////////////////////////////////////////////////////
            
            //////////////////////////////////////////////////////////////////////////////////////////////
            objTipoNota = new LogicaCalificaciones().buscarNotaPorTipo(codMatri,codigoDistributivo,codPerid, 5);
            if (objTipoNota != null) {
                tblListado.setValueAt(validar.Redondeo(Float.parseFloat(objTipoNota.getTotalNota())), i, 6);
            }
             //////////////////////////////////////////////////////////////////////////////////////////////
        }
    }
    

    private void generarPromedio(){
        if (tblListado.getRowCount() != 0) {
            float promedio = 0;
            for (int i = 0; i < tblListado.getRowCount(); i++) {
                promedio = promedio + Float.parseFloat(String.valueOf(tblListado.getValueAt(i, 2))) +
                           Float.parseFloat(String.valueOf(tblListado.getValueAt(i, 3))) +
                           Float.parseFloat(String.valueOf(tblListado.getValueAt(i, 4))) +
                           Float.parseFloat(String.valueOf(tblListado.getValueAt(i, 5))) +
                           Float.parseFloat(String.valueOf(tblListado.getValueAt(i, 6)));
                
                tblListado.setValueAt(validar.Redondeo((promedio) / 5), i, 7);
                
                promedio=0;
            }
        }
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

        lypnlFondo = new javax.swing.JLayeredPane();
        pnlFondo = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        lblLogo = new javax.swing.JLabel();
        lblInstitucion = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblListado = new javax.swing.JTable();
        lblParalelo = new javax.swing.JLabel();
        lblParalelo1 = new javax.swing.JLabel();
        txtSeccion = new javax.swing.JTextField();
        txtParalelo = new javax.swing.JTextField();
        txtAsignatura = new javax.swing.JTextField();
        lblAnioLectivo = new javax.swing.JLabel();
        txtAnioLectivo = new javax.swing.JTextField();
        txtCurso = new javax.swing.JTextField();
        btnSeleccionar = new javax.swing.JButton();
        lblCurso = new javax.swing.JLabel();
        lblAsignatura = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblListadoDistributivo = new javax.swing.JTable();
        cmbQuimestre = new javax.swing.JComboBox();
        lblQuimestre = new javax.swing.JLabel();
        lblParcial = new javax.swing.JLabel();
        cmbParcial = new javax.swing.JComboBox();
        btnBuscar = new javax.swing.JButton();
        btnRegistrar = new javax.swing.JButton();
        btnVer = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Acta de Calificaciones Parciales");

        pnlFondo.setBackground(new java.awt.Color(255, 255, 255));

        lblTitulo.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        lblTitulo.setText("Acta de Calificaciones Parciales");

        lblLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/CapaPresentacion/Imagenes/GestionCalificaciones/periodoAcademico.png"))); // NOI18N

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
                "CODIGO", "ESTUDIANTE", "T.A.I.", "A.I.C.", "A.G.C.", "L.O.E.", "EVALUACION", "PROMEDIO"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblListado);

        lblParalelo.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        lblParalelo.setText("Paralelo");

        lblParalelo1.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        lblParalelo1.setText("Sección");

        txtSeccion.setEditable(false);
        txtSeccion.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N

        txtParalelo.setEditable(false);
        txtParalelo.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N

        txtAsignatura.setEditable(false);
        txtAsignatura.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N

        lblAnioLectivo.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        lblAnioLectivo.setText("Año Lectivo");

        txtAnioLectivo.setEditable(false);
        txtAnioLectivo.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N

        txtCurso.setEditable(false);
        txtCurso.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N

        btnSeleccionar.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        btnSeleccionar.setText("Seleccionar");
        btnSeleccionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionarActionPerformed(evt);
            }
        });

        lblCurso.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        lblCurso.setText("Curso");

        lblAsignatura.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        lblAsignatura.setText("Asignatura");

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

        btnBuscar.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        btnRegistrar.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        btnRegistrar.setText("Registrar");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        btnVer.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        btnVer.setText("Actas");
        btnVer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlFondoLayout = new javax.swing.GroupLayout(pnlFondo);
        pnlFondo.setLayout(pnlFondoLayout);
        pnlFondoLayout.setHorizontalGroup(
            pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFondoLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(lblLogo)
                .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlFondoLayout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblInstitucion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlFondoLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(pnlFondoLayout.createSequentialGroup()
                                .addComponent(lblAsignatura, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtAsignatura, javax.swing.GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlFondoLayout.createSequentialGroup()
                                .addComponent(lblParalelo1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtSeccion))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlFondoLayout.createSequentialGroup()
                                .addComponent(lblAnioLectivo, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtAnioLectivo))
                            .addGroup(pnlFondoLayout.createSequentialGroup()
                                .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(lblCurso, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblParalelo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtCurso)
                                    .addComponent(txtParalelo))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblQuimestre, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                            .addComponent(lblParcial, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnBuscar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cmbParcial, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cmbQuimestre, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnSeleccionar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
            .addGroup(pnlFondoLayout.createSequentialGroup()
                .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlFondoLayout.createSequentialGroup()
                        .addGap(169, 169, 169)
                        .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(btnVer, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlFondoLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 725, Short.MAX_VALUE)
                            .addComponent(jScrollPane2))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlFondoLayout.setVerticalGroup(
            pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFondoLayout.createSequentialGroup()
                .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlFondoLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(lblTitulo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblInstitucion)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblCurso)
                            .addComponent(txtCurso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSeleccionar))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblParalelo)
                            .addComponent(txtParalelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblAnioLectivo)
                            .addComponent(txtAnioLectivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbQuimestre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblQuimestre))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblParalelo1)
                    .addComponent(txtSeccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbParcial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblParcial))
                .addGap(7, 7, 7)
                .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAsignatura)
                    .addComponent(txtAsignatura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar)
                    .addComponent(btnRegistrar)
                    .addComponent(btnVer))
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

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        actualizarNotas();
        generarPromedio();
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        LogicaDetalleParcial logicaDetParc = new LogicaDetalleParcial();
        DetalleActaParcial objDetParcial = new DetalleActaParcial();
        
        if (tblListado.getRowCount() != 0) {
            try {
                long codigoActa = registroActa(new Acta());
                
                for (int i = 0; i < tblListado.getRowCount(); i++) {
                    long codMatr = Long.parseLong(String.valueOf(tblListado.getValueAt(i, 0)));
                    
                    objDetParcial.setCodigoActaParcial(codigoActa);
                    objDetParcial.setCodigoMatricula(codMatr);
                    objDetParcial.setNotaTai(Float.valueOf(String.valueOf(tblListado.getValueAt(i, 2))));
                    objDetParcial.setNotaIac(Float.valueOf(String.valueOf(tblListado.getValueAt(i, 3))));
                    objDetParcial.setNotaAgc(Float.valueOf(String.valueOf(tblListado.getValueAt(i, 4))));
                    objDetParcial.setNotaLoe(Float.valueOf(String.valueOf(tblListado.getValueAt(i, 5))));
                    objDetParcial.setEvualuacion(Float.valueOf(String.valueOf(tblListado.getValueAt(i, 6))));
                    objDetParcial.setPromedio(Float.valueOf(String.valueOf(tblListado.getValueAt(i, 7))));
                    objDetParcial.setEstado('A');
                    
                    logicaDetParc.Insertar(objDetParcial);
                }
                
                mensaje.MensajeInformacion("Se ha registrado correctamente", "Registrar");
                
            } catch (SQLException ex) {
                Logger.getLogger(CalificacionesParciales.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnVerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerActionPerformed
        ActasParciales frm = new ActasParciales((Frame) this.getParent(), true);
        frm.setLocationRelativeTo(null);
        frm.setVisible(true);
    }//GEN-LAST:event_btnVerActionPerformed

    private long registroActa(Acta obj) throws SQLException {

        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());   
        Date fechaDate = new Date();
        String fechaActual = formato.format(fechaDate);

        obj.setCodigoPeriodo(((PeriodoAcademicos) (cmbParcial.getSelectedItem())).getCodigo());
        obj.setCodigoDistributivo(codigoDistributivo);
        obj.setFechaRegistro(fechaActual);
        
        obj.setEstado('A');

        return new LogicaActa().InsertGetId(obj);
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
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JButton btnSeleccionar;
    private javax.swing.JButton btnVer;
    private javax.swing.JComboBox cmbParcial;
    private javax.swing.JComboBox cmbQuimestre;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblAnioLectivo;
    private javax.swing.JLabel lblAsignatura;
    private javax.swing.JLabel lblCurso;
    private javax.swing.JLabel lblInstitucion;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblParalelo;
    private javax.swing.JLabel lblParalelo1;
    private javax.swing.JLabel lblParcial;
    private javax.swing.JLabel lblQuimestre;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLayeredPane lypnlFondo;
    private javax.swing.JPanel pnlFondo;
    private javax.swing.JTable tblListado;
    private javax.swing.JTable tblListadoDistributivo;
    private javax.swing.JTextField txtAnioLectivo;
    private javax.swing.JTextField txtAsignatura;
    private javax.swing.JTextField txtCurso;
    private javax.swing.JTextField txtParalelo;
    private javax.swing.JTextField txtSeccion;
    // End of variables declaration//GEN-END:variables

    public long getCodigoDistributivo() {
        return codigoDistributivo;
    }

    public void setCodigoDistributivo(long codigoDistributivo) {
        this.codigoDistributivo = codigoDistributivo;
    }

    public long getCodigoGrado() {
        return codigoGrado;
    }

    public void setCodigoGrado(long codigoGrado) {
        this.codigoGrado = codigoGrado;
    }
}
