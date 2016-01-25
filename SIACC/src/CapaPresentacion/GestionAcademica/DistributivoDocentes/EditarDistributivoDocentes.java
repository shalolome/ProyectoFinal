package CapaPresentacion.GestionAcademica.DistributivoDocentes;

import CapaDatos.Entidades.GestionAcademica.Asignatura.Asignatura;
import CapaDatos.Entidades.GestionAcademica.Asignatura.Distributivo;
import CapaDatos.Entidades.GestionAcademica.Asignatura.Malla;
import CapaDatos.Entidades.GestionAcademica.Curso.Grado;
import CapaDatos.Entidades.GestionAcademica.Curso.Nivel;
import CapaDatos.Entidades.GestionAcademica.Curso.Paralelo;
import CapaDatos.Entidades.GestionAdministrativa.Categorias.Persona;
import CapaDatos.Entidades.GestionAdministrativa.Institucional.AnioLectivo;
import CapaDatos.Entidades.GestionAdministrativa.Institucional.AsigCargos;
import CapaDatos.Entidades.GestionAdministrativa.Institucional.Institucion;
import CapaDatos.Entidades.GestionAdministrativa.Institucional.Personal;
import CapaDatos.Entidades.GestionAdministrativa.Institucional.Seccion;
import CapaLogica.GestionAcademica.Asignatura.LogicaAsignatura;
import CapaLogica.GestionAcademica.Asignatura.LogicaDistributivo;
import CapaLogica.GestionAcademica.Asignatura.LogicaMallaCurricular;
import CapaLogica.GestionAcademica.Curso.LogicaGrado;
import CapaLogica.GestionAcademica.Curso.LogicaNivel;
import CapaLogica.GestionAcademica.Curso.LogicaParalelo;
import CapaLogica.GestionAdministrativa.Categorias.LogicaPersona;
import CapaLogica.GestionAdministrativa.Institucional.LogicaAnioLectivo;
import CapaLogica.GestionAdministrativa.Institucional.LogicaAsignacionCargos;
import CapaLogica.GestionAdministrativa.Institucional.LogicaInstitucion;
import CapaLogica.GestionAdministrativa.Institucional.LogicaPersonalAdministrativo;
import CapaLogica.GestionAdministrativa.Institucional.LogicaSecciones;
import CapaPresentacion.GestionAcademica.ControlCursos.Cursos;
import CapaPresentacion.Utilidades.Alertas.Mensajes;
import java.awt.Frame;
import javax.swing.table.DefaultTableModel;

public class EditarDistributivoDocentes extends javax.swing.JDialog {

    LogicaInstitucion logicaUnidadEducativa = new LogicaInstitucion();
    Institucion objInstituto = new Institucion();

    String[] tblEtiquetaDocente = new String[]{"CODIGO",
        "PERSONAL ADMINISTRATIVO",
        "CARGO"};

    String[] tblEtiquetaMalla = new String[]{"CODIGO",
        "ASIGNATURA",
        "CURSO"};

    LogicaAsignacionCargos logicaPersonal = new LogicaAsignacionCargos();
    LogicaMallaCurricular logicaMalla = new LogicaMallaCurricular();

    LogicaDistributivo logica = new LogicaDistributivo();
    Distributivo obj = new Distributivo();

    Mensajes mensaje = new Mensajes();

    private long codigo;
    private long codigoDocente;
    private long codigoMalla;
    private long codigoGrado;

    private boolean bandera = false;

    public EditarDistributivoDocentes(java.awt.Frame parent, boolean modal, long cod) {
        super(parent, modal);
        initComponents();

        listaDocente();
        
        MostrarInformacion(cod);

        objInstituto = logicaUnidadEducativa.buscarInsititucionPorCod(1);
        lblInstitucion.setText(objInstituto.getNombre());
    }

    public void listaDocente() {
        tblListadoDocente.setModel(new DefaultTableModel(logicaPersonal.Docentes(), tblEtiquetaDocente) {
            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return false;
            }
        });
    }

    public void listarMallaPorCurso(long codCurso) {
        tblListadoMalla.setModel(new DefaultTableModel(logicaMalla.ListarPorCod(codCurso), tblEtiquetaMalla) {
            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return false;
            }
        });
    }

    private void MostrarInformacion(long cod) {

        Distributivo objBuscar = logica.buscarDistributivoPorCod(cod);

        setCodigo(objBuscar.getCodigo());

        AsigCargos objAsigCarg = new LogicaAsignacionCargos().buscarAsigCargoPorCod(objBuscar.getAsignacionCargo());
        Personal obj = new LogicaPersonalAdministrativo().buscarPersonalPorCod(objAsigCarg.getCodigoPersona());
        Persona persona = new LogicaPersona().buscarPersonaPorCod(obj.getCodigo());
        txtCodigo.setText(String.valueOf(obj.getCodigoPersonal()));
        txtDocente.setText(persona.getPrimerNombre() + " " + persona.getSegundoNombre() + " "
                + persona.getApellidoPaterno() + " " + persona.getApellidoMaterno());
        
        setCodigoDocente(objBuscar.getAsignacionCargo());
        
        Grado objGrado = new LogicaGrado().buscarGradoPorCod(objBuscar.getCodigoGrado());
        Nivel objNivel = new LogicaNivel().buscarNivelPorCod(objGrado.getCodigoNivel());
        txtCurso.setText(objNivel.getNombre());
        Paralelo objParalelo = new LogicaParalelo().buscarParaleloPorCod(objGrado.getCodigoParalelo());
        txtParalelo.setText(objParalelo.getNombre());
        Seccion objSeccion = new LogicaSecciones().buscarSeccionPorCod(objGrado.getCodigoSeccion());
        txtSeccion.setText(objSeccion.getNombre());
        AnioLectivo objAnioLectivo = new LogicaAnioLectivo().buscarAnioLectivoPorCod(objGrado.getCodigoAnioLectivo());
        txtAnioLectivo.setText(objAnioLectivo.getAnioInicio()+" - "+objAnioLectivo.getAnioFin());
        
        setCodigoGrado(objBuscar.getCodigoGrado());
        
        Malla objMalla = new LogicaMallaCurricular().buscarMallaPorCod(objBuscar.getCodigoMallaCurricular());
        Asignatura objAsignatura = new LogicaAsignatura().buscarAsignaturaPorCod(objMalla.getCodigoAsignatura());
        txtAsignatura.setText(objAsignatura.getNombre());
        
        setCodigoMalla(objBuscar.getCodigoMallaCurricular());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lypnlFondo = new javax.swing.JLayeredPane();
        pnlFondo = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        lblLogo = new javax.swing.JLabel();
        btnActualizar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        lblInstitucion = new javax.swing.JLabel();
        tbpnlPrincipal = new javax.swing.JTabbedPane();
        pnlDocente = new javax.swing.JPanel();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        lblCodigo = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        lblDocente = new javax.swing.JLabel();
        txtDocente = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblListadoDocente = new javax.swing.JTable();
        pnlGrado = new javax.swing.JPanel();
        jLayeredPane2 = new javax.swing.JLayeredPane();
        lblCurso = new javax.swing.JLabel();
        txtCurso = new javax.swing.JTextField();
        txtParalelo = new javax.swing.JTextField();
        lblParalelo = new javax.swing.JLabel();
        btnSeleccionar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblListadoMalla = new javax.swing.JTable();
        lblAnioLectivo = new javax.swing.JLabel();
        txtAnioLectivo = new javax.swing.JTextField();
        lblAsignatura = new javax.swing.JLabel();
        txtAsignatura = new javax.swing.JTextField();
        lblParalelo1 = new javax.swing.JLabel();
        txtSeccion = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Actualización de Distributivo de Docente");

        pnlFondo.setBackground(new java.awt.Color(255, 255, 255));

        lblTitulo.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        lblTitulo.setText("Actualización Distributivo de Docente");

        lblLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/CapaPresentacion/Imagenes/GestionAcademica/docentes.png"))); // NOI18N

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

        tbpnlPrincipal.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N

        lblCodigo.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        lblCodigo.setText("Código");

        txtCodigo.setEditable(false);
        txtCodigo.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N

        lblDocente.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        lblDocente.setText("Docente");

        txtDocente.setEditable(false);
        txtDocente.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N

        tblListadoDocente.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        tblListadoDocente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CODIGO", "PERSONAL ADMINISTRATIVO", "CARGO"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblListadoDocente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tblListadoDocenteMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tblListadoDocente);

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jLayeredPane1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 597, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jLayeredPane1Layout.createSequentialGroup()
                        .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(lblDocente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblCodigo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                                .addComponent(txtDocente)
                                .addGap(10, 10, 10))
                            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                                .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCodigo)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDocente)
                    .addComponent(txtDocente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)
                .addContainerGap())
        );
        jLayeredPane1.setLayer(lblCodigo, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(txtCodigo, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(lblDocente, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(txtDocente, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jScrollPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout pnlDocenteLayout = new javax.swing.GroupLayout(pnlDocente);
        pnlDocente.setLayout(pnlDocenteLayout);
        pnlDocenteLayout.setHorizontalGroup(
            pnlDocenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1)
        );
        pnlDocenteLayout.setVerticalGroup(
            pnlDocenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1)
        );

        tbpnlPrincipal.addTab("Docente", pnlDocente);

        lblCurso.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        lblCurso.setText("Curso");

        txtCurso.setEditable(false);
        txtCurso.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N

        txtParalelo.setEditable(false);
        txtParalelo.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N

        lblParalelo.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        lblParalelo.setText("Paralelo");

        btnSeleccionar.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        btnSeleccionar.setText("Seleccionar");
        btnSeleccionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionarActionPerformed(evt);
            }
        });

        tblListadoMalla.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        tblListadoMalla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CODIGO", "ASIGNATURA", "CURSO"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblListadoMalla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tblListadoMallaMouseReleased(evt);
            }
        });
        jScrollPane2.setViewportView(tblListadoMalla);

        lblAnioLectivo.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        lblAnioLectivo.setText("Año Lectivo");

        txtAnioLectivo.setEditable(false);
        txtAnioLectivo.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N

        lblAsignatura.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        lblAsignatura.setText("Asignatura");

        txtAsignatura.setEditable(false);
        txtAsignatura.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N

        lblParalelo1.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        lblParalelo1.setText("Sección");

        txtSeccion.setEditable(false);
        txtSeccion.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N

        javax.swing.GroupLayout jLayeredPane2Layout = new javax.swing.GroupLayout(jLayeredPane2);
        jLayeredPane2.setLayout(jLayeredPane2Layout);
        jLayeredPane2Layout.setHorizontalGroup(
            jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(jLayeredPane2Layout.createSequentialGroup()
                        .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jLayeredPane2Layout.createSequentialGroup()
                                .addComponent(lblAsignatura, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtAsignatura))
                            .addGroup(jLayeredPane2Layout.createSequentialGroup()
                                .addComponent(lblAnioLectivo, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtAnioLectivo))
                            .addGroup(jLayeredPane2Layout.createSequentialGroup()
                                .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(lblCurso, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblParalelo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtCurso, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                                    .addComponent(txtParalelo))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblParalelo1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnSeleccionar, javax.swing.GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)
                            .addComponent(txtSeccion))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jLayeredPane2Layout.setVerticalGroup(
            jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCurso)
                    .addComponent(txtCurso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblParalelo)
                    .addComponent(txtParalelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblParalelo1)
                    .addComponent(txtSeccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAnioLectivo)
                    .addComponent(txtAnioLectivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSeleccionar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAsignatura)
                    .addComponent(txtAsignatura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jLayeredPane2.setLayer(lblCurso, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(txtCurso, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(txtParalelo, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(lblParalelo, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(btnSeleccionar, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(jScrollPane2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(lblAnioLectivo, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(txtAnioLectivo, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(lblAsignatura, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(txtAsignatura, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(lblParalelo1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(txtSeccion, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout pnlGradoLayout = new javax.swing.GroupLayout(pnlGrado);
        pnlGrado.setLayout(pnlGradoLayout);
        pnlGradoLayout.setHorizontalGroup(
            pnlGradoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane2)
        );
        pnlGradoLayout.setVerticalGroup(
            pnlGradoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane2)
        );

        tbpnlPrincipal.addTab("Grado", pnlGrado);

        javax.swing.GroupLayout pnlFondoLayout = new javax.swing.GroupLayout(pnlFondo);
        pnlFondo.setLayout(pnlFondoLayout);
        pnlFondoLayout.setHorizontalGroup(
            pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFondoLayout.createSequentialGroup()
                .addComponent(lblLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlFondoLayout.createSequentialGroup()
                        .addGap(103, 103, 103)
                        .addComponent(lblInstitucion, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pnlFondoLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tbpnlPrincipal)
                        .addContainerGap())))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlFondoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTitulo)
                .addGap(212, 212, 212))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlFondoLayout.createSequentialGroup()
                .addGap(180, 180, 180)
                .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41))
        );
        pnlFondoLayout.setVerticalGroup(
            pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFondoLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(lblTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblLogo)
                    .addGroup(pnlFondoLayout.createSequentialGroup()
                        .addComponent(lblInstitucion)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tbpnlPrincipal)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnActualizar)
                    .addComponent(btnCancelar))
                .addContainerGap())
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

    private void tblListadoDocenteMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblListadoDocenteMouseReleased
        if (evt.getClickCount() == 2) {

            int fila = tblListadoDocente.getSelectedRow();
            long codigo = Long.parseLong((tblListadoDocente.getValueAt(fila, 0)).toString());

            setCodigoDocente(codigo);

            Personal obj = new LogicaPersonalAdministrativo().buscarPersonalPorCod(codigo);
            Persona persona = new LogicaPersona().buscarPersonaPorCod(obj.getCodigo());
            txtCodigo.setText(String.valueOf(obj.getCodigoPersonal()));
            txtDocente.setText(persona.getPrimerNombre() + " " + persona.getSegundoNombre() + " "
                    + persona.getApellidoPaterno() + " " + persona.getApellidoMaterno());
        }
    }//GEN-LAST:event_tblListadoDocenteMouseReleased

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

            listarMallaPorCurso(obj.getCodigoNivel());

            txtAsignatura.setText("");
        }
    }//GEN-LAST:event_btnSeleccionarActionPerformed

    private void tblListadoMallaMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblListadoMallaMouseReleased
        if (evt.getClickCount() == 2) {

            int fila = tblListadoMalla.getSelectedRow();
            long codigo = Long.parseLong((tblListadoMalla.getValueAt(fila, 0)).toString());

            setCodigoMalla(codigo);

            Malla obj = new LogicaMallaCurricular().buscarMallaPorCod(codigo);
            Asignatura asignatura = new LogicaAsignatura().buscarAsignaturaPorCod(obj.getCodigoAsignatura());
            txtAsignatura.setText(asignatura.getNombre());
        }
    }//GEN-LAST:event_tblListadoMallaMouseReleased

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        setBandera(true);

        obj.setCodigo(codigo);
        obj.setCodigoMallaCurricular(codigoMalla);
        obj.setCodigoGrado(codigoGrado);
        obj.setAsignacionCargo(codigoDocente);

        logica.Actualizar(obj);

        mensaje.MensajeInformacion("Se ha editado correctamente", "EDITAR");

        this.dispose();
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
            java.util.logging.Logger.getLogger(EditarDistributivoDocentes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditarDistributivoDocentes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditarDistributivoDocentes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditarDistributivoDocentes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                EditarDistributivoDocentes dialog = new EditarDistributivoDocentes(new javax.swing.JFrame(), true, 0);
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
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JLayeredPane jLayeredPane2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblAnioLectivo;
    private javax.swing.JLabel lblAsignatura;
    private javax.swing.JLabel lblCodigo;
    private javax.swing.JLabel lblCurso;
    private javax.swing.JLabel lblDocente;
    private javax.swing.JLabel lblInstitucion;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblParalelo;
    private javax.swing.JLabel lblParalelo1;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLayeredPane lypnlFondo;
    private javax.swing.JPanel pnlDocente;
    private javax.swing.JPanel pnlFondo;
    private javax.swing.JPanel pnlGrado;
    private javax.swing.JTable tblListadoDocente;
    private javax.swing.JTable tblListadoMalla;
    private javax.swing.JTabbedPane tbpnlPrincipal;
    private javax.swing.JTextField txtAnioLectivo;
    private javax.swing.JTextField txtAsignatura;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtCurso;
    private javax.swing.JTextField txtDocente;
    private javax.swing.JTextField txtParalelo;
    private javax.swing.JTextField txtSeccion;
    // End of variables declaration//GEN-END:variables

    public long getCodigoDocente() {
        return codigoDocente;
    }

    public void setCodigoDocente(long codigoDocente) {
        this.codigoDocente = codigoDocente;
    }

    public long getCodigoMalla() {
        return codigoMalla;
    }

    public void setCodigoMalla(long codigoMalla) {
        this.codigoMalla = codigoMalla;
    }

    public long getCodigoGrado() {
        return codigoGrado;
    }

    public void setCodigoGrado(long codigoGrado) {
        this.codigoGrado = codigoGrado;
    }

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
