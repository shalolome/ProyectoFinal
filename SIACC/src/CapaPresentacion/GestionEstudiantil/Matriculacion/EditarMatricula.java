
package CapaPresentacion.GestionEstudiantil.Matriculacion;

import CapaDatos.Entidades.GestionAcademica.Curso.Grado;
import CapaDatos.Entidades.GestionAcademica.Curso.Nivel;
import CapaDatos.Entidades.GestionAcademica.Curso.Paralelo;
import CapaDatos.Entidades.GestionAdministrativa.Categorias.Persona;
import CapaDatos.Entidades.GestionAdministrativa.Institucional.AnioLectivo;
import CapaDatos.Entidades.GestionAdministrativa.Institucional.Institucion;
import CapaDatos.Entidades.GestionAdministrativa.Institucional.Seccion;
import CapaDatos.Entidades.GestionEstudiantil.Estudiantes;
import CapaDatos.Entidades.GestionEstudiantil.Matricula;
import CapaDatos.Entidades.GestionEstudiantil.Representantes;
import CapaLogica.GestionAcademica.Curso.LogicaGrado;
import CapaLogica.GestionAcademica.Curso.LogicaNivel;
import CapaLogica.GestionAcademica.Curso.LogicaParalelo;
import CapaLogica.GestionAdministrativa.Categorias.LogicaPersona;
import CapaLogica.GestionAdministrativa.Institucional.LogicaAnioLectivo;
import CapaLogica.GestionAdministrativa.Institucional.LogicaInstitucion;
import CapaLogica.GestionAdministrativa.Institucional.LogicaSecciones;
import CapaLogica.GestionEstudiantil.LogicaEstudiante;
import CapaLogica.GestionEstudiantil.LogicaMatricula;
import CapaLogica.GestionEstudiantil.LogicaRepresentante;
import CapaPresentacion.Utilidades.Alertas.Mensajes;
import java.awt.Frame;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

public class EditarMatricula extends javax.swing.JDialog {

    LogicaInstitucion logicaUnidadEducativa = new LogicaInstitucion();
    Institucion objInstituto = new Institucion();
    
    LogicaMatricula logica = new LogicaMatricula();
    Matricula obj = new Matricula();
    
    Mensajes mensaje = new Mensajes();
    private boolean bandera = false;
    
    private long codigo;
    private long codigoEstudiante;
    private long codigoGrado;
    private long codigoRepresentante;
    
    public EditarMatricula(java.awt.Frame parent, boolean modal, long cod) {
        super(parent, modal);
        initComponents();
        
        objInstituto = logicaUnidadEducativa.buscarInsititucionPorCod(1);
        lblInstitucion.setText(objInstituto.getNombre());
        
        MostrarInformacion(cod);
    }

    private void MostrarInformacion(long cod) {

        Matricula objBuscar = logica.buscarMatriculaPorCod(cod);

        setCodigo(objBuscar.getCodigo());

        Estudiantes objEstudiante = new LogicaEstudiante().buscarEstudiantePorCod(objBuscar.getCodigoEstudiante());
        Persona persona = new LogicaPersona().buscarPersonaPorCod(objEstudiante.getCodigo());
        txtCodigoMagisterio.setText(objEstudiante.getCodigoMagisterio());
        txtCedula.setText(persona.getCedula());
        txtPrimerNombre.setText(persona.getPrimerNombre());
        txtSegundoNombre.setText(persona.getSegundoNombre());
        txtApellidoPaterno.setText(persona.getApellidoPaterno());
        txtApellidoMaterno.setText(persona.getApellidoMaterno());
        
        setCodigoEstudiante(objBuscar.getCodigoEstudiante());
        
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
        
        Representantes objRepresentante = new LogicaRepresentante().buscarReprentantePorCod(objBuscar.getCodigoRepresentante());
        Persona personaRepresentante = new LogicaPersona().buscarPersonaPorCod(objRepresentante.getCodigo());
        txtCodigoRepresentante.setText(String.valueOf(objRepresentante.getCodigoRepresentante()));
        txtCedulaRepresentante.setText(personaRepresentante.getCedula());
        txtPrimerNombreRepresentante.setText(personaRepresentante.getPrimerNombre());
        txtSegundoNombreRepresentante.setText(personaRepresentante.getSegundoNombre());
        txtApellidoPaternoRepresentante.setText(personaRepresentante.getApellidoPaterno());
        txtApellidoMaternoRepresentante.setText(personaRepresentante.getApellidoMaterno());
        
        setCodigoRepresentante(objBuscar.getCodigoRepresentante());
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
        pnlEstudiante = new javax.swing.JPanel();
        lypnlEstudiante = new javax.swing.JLayeredPane();
        lblCodigo = new javax.swing.JLabel();
        txtCodigoMagisterio = new javax.swing.JTextField();
        lblCedula = new javax.swing.JLabel();
        txtCedula = new javax.swing.JTextField();
        lblPrimerNombre = new javax.swing.JLabel();
        txtPrimerNombre = new javax.swing.JTextField();
        lblSegundoNombre = new javax.swing.JLabel();
        txtSegundoNombre = new javax.swing.JTextField();
        lblApellidoPaterno = new javax.swing.JLabel();
        txtApellidoPaterno = new javax.swing.JTextField();
        lblApellidoMaterno = new javax.swing.JLabel();
        txtApellidoMaterno = new javax.swing.JTextField();
        btnEstudiante = new javax.swing.JButton();
        pnlGrado = new javax.swing.JPanel();
        lypnlGrado = new javax.swing.JLayeredPane();
        lblCurso = new javax.swing.JLabel();
        txtCurso = new javax.swing.JTextField();
        txtParalelo = new javax.swing.JTextField();
        lblParalelo = new javax.swing.JLabel();
        lblProvincia = new javax.swing.JLabel();
        txtSeccion = new javax.swing.JTextField();
        txtAnioLectivo = new javax.swing.JTextField();
        lblCanton = new javax.swing.JLabel();
        btnGrado = new javax.swing.JButton();
        pnlRepresentante = new javax.swing.JPanel();
        lblCodigoRepresentante = new javax.swing.JLabel();
        txtCodigoRepresentante = new javax.swing.JTextField();
        txtCedulaRepresentante = new javax.swing.JTextField();
        lblCedulaRepresentante = new javax.swing.JLabel();
        lblPrimerNombreRepresentante = new javax.swing.JLabel();
        txtPrimerNombreRepresentante = new javax.swing.JTextField();
        txtSegundoNombreRepresentante = new javax.swing.JTextField();
        lblSegundoNombreRepresentante = new javax.swing.JLabel();
        lblApellidoPaternoRepresentante = new javax.swing.JLabel();
        txtApellidoPaternoRepresentante = new javax.swing.JTextField();
        lblApellidoMaternoRepresentante = new javax.swing.JLabel();
        txtApellidoMaternoRepresentante = new javax.swing.JTextField();
        btnRepresentante = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Actualización de Matricula Estudiantil");

        pnlFondo.setBackground(new java.awt.Color(255, 255, 255));

        lblTitulo.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        lblTitulo.setText("Actualización de Matricula Estudiantil");

        lblLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/CapaPresentacion/Imagenes/GestionEstudiantil/matriculacion.png"))); // NOI18N

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

        txtCodigoMagisterio.setEditable(false);
        txtCodigoMagisterio.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N

        lblCedula.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        lblCedula.setText("Cédula");

        txtCedula.setEditable(false);
        txtCedula.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N

        lblPrimerNombre.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        lblPrimerNombre.setText("Primer Nombre");

        txtPrimerNombre.setEditable(false);
        txtPrimerNombre.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N

        lblSegundoNombre.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        lblSegundoNombre.setText("Segundo Nombre");

        txtSegundoNombre.setEditable(false);
        txtSegundoNombre.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N

        lblApellidoPaterno.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        lblApellidoPaterno.setText("Apellido Paterno");

        txtApellidoPaterno.setEditable(false);
        txtApellidoPaterno.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N

        lblApellidoMaterno.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        lblApellidoMaterno.setText("Apellido Materno");

        txtApellidoMaterno.setEditable(false);
        txtApellidoMaterno.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N

        btnEstudiante.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        btnEstudiante.setText("Buscar");
        btnEstudiante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEstudianteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout lypnlEstudianteLayout = new javax.swing.GroupLayout(lypnlEstudiante);
        lypnlEstudiante.setLayout(lypnlEstudianteLayout);
        lypnlEstudianteLayout.setHorizontalGroup(
            lypnlEstudianteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lypnlEstudianteLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(lypnlEstudianteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(lblApellidoMaterno, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblApellidoPaterno, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblSegundoNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblPrimerNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblCedula, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblCodigo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(lypnlEstudianteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, lypnlEstudianteLayout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(txtCodigoMagisterio, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(lypnlEstudianteLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(lypnlEstudianteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtApellidoPaterno, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtApellidoMaterno, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSegundoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPrimerNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEstudiante, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        lypnlEstudianteLayout.setVerticalGroup(
            lypnlEstudianteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lypnlEstudianteLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(lypnlEstudianteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCodigo)
                    .addComponent(txtCodigoMagisterio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(lypnlEstudianteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCedula)
                    .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(lypnlEstudianteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPrimerNombre)
                    .addComponent(txtPrimerNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(lypnlEstudianteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSegundoNombre)
                    .addComponent(txtSegundoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(lypnlEstudianteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblApellidoPaterno)
                    .addComponent(txtApellidoPaterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(lypnlEstudianteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblApellidoMaterno)
                    .addGroup(lypnlEstudianteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtApellidoMaterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnEstudiante)))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        lypnlEstudiante.setLayer(lblCodigo, javax.swing.JLayeredPane.DEFAULT_LAYER);
        lypnlEstudiante.setLayer(txtCodigoMagisterio, javax.swing.JLayeredPane.DEFAULT_LAYER);
        lypnlEstudiante.setLayer(lblCedula, javax.swing.JLayeredPane.DEFAULT_LAYER);
        lypnlEstudiante.setLayer(txtCedula, javax.swing.JLayeredPane.DEFAULT_LAYER);
        lypnlEstudiante.setLayer(lblPrimerNombre, javax.swing.JLayeredPane.DEFAULT_LAYER);
        lypnlEstudiante.setLayer(txtPrimerNombre, javax.swing.JLayeredPane.DEFAULT_LAYER);
        lypnlEstudiante.setLayer(lblSegundoNombre, javax.swing.JLayeredPane.DEFAULT_LAYER);
        lypnlEstudiante.setLayer(txtSegundoNombre, javax.swing.JLayeredPane.DEFAULT_LAYER);
        lypnlEstudiante.setLayer(lblApellidoPaterno, javax.swing.JLayeredPane.DEFAULT_LAYER);
        lypnlEstudiante.setLayer(txtApellidoPaterno, javax.swing.JLayeredPane.DEFAULT_LAYER);
        lypnlEstudiante.setLayer(lblApellidoMaterno, javax.swing.JLayeredPane.DEFAULT_LAYER);
        lypnlEstudiante.setLayer(txtApellidoMaterno, javax.swing.JLayeredPane.DEFAULT_LAYER);
        lypnlEstudiante.setLayer(btnEstudiante, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout pnlEstudianteLayout = new javax.swing.GroupLayout(pnlEstudiante);
        pnlEstudiante.setLayout(pnlEstudianteLayout);
        pnlEstudianteLayout.setHorizontalGroup(
            pnlEstudianteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lypnlEstudiante)
        );
        pnlEstudianteLayout.setVerticalGroup(
            pnlEstudianteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lypnlEstudiante)
        );

        tbpnlPrincipal.addTab("Estudiante", pnlEstudiante);

        lblCurso.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        lblCurso.setText("Curso");

        txtCurso.setEditable(false);
        txtCurso.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N

        txtParalelo.setEditable(false);
        txtParalelo.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N

        lblParalelo.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        lblParalelo.setText("Paralelo");

        lblProvincia.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        lblProvincia.setText("Sección");

        txtSeccion.setEditable(false);
        txtSeccion.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N

        txtAnioLectivo.setEditable(false);
        txtAnioLectivo.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N

        lblCanton.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        lblCanton.setText("Año Lectivo");

        btnGrado.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        btnGrado.setText("Buscar");
        btnGrado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGradoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout lypnlGradoLayout = new javax.swing.GroupLayout(lypnlGrado);
        lypnlGrado.setLayout(lypnlGradoLayout);
        lypnlGradoLayout.setHorizontalGroup(
            lypnlGradoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, lypnlGradoLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(lypnlGradoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblProvincia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblCanton, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                    .addGroup(lypnlGradoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(lblParalelo, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                        .addComponent(lblCurso, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(lypnlGradoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnGrado, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(lypnlGradoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, lypnlGradoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtSeccion, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtAnioLectivo, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(lypnlGradoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCurso, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtParalelo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(114, 114, 114))
        );
        lypnlGradoLayout.setVerticalGroup(
            lypnlGradoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lypnlGradoLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(lypnlGradoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCurso)
                    .addComponent(txtCurso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addGroup(lypnlGradoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblParalelo)
                    .addComponent(txtParalelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(lypnlGradoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblProvincia)
                    .addComponent(txtSeccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(lypnlGradoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCanton)
                    .addComponent(txtAnioLectivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnGrado)
                .addContainerGap(62, Short.MAX_VALUE))
        );
        lypnlGrado.setLayer(lblCurso, javax.swing.JLayeredPane.DEFAULT_LAYER);
        lypnlGrado.setLayer(txtCurso, javax.swing.JLayeredPane.DEFAULT_LAYER);
        lypnlGrado.setLayer(txtParalelo, javax.swing.JLayeredPane.DEFAULT_LAYER);
        lypnlGrado.setLayer(lblParalelo, javax.swing.JLayeredPane.DEFAULT_LAYER);
        lypnlGrado.setLayer(lblProvincia, javax.swing.JLayeredPane.DEFAULT_LAYER);
        lypnlGrado.setLayer(txtSeccion, javax.swing.JLayeredPane.DEFAULT_LAYER);
        lypnlGrado.setLayer(txtAnioLectivo, javax.swing.JLayeredPane.DEFAULT_LAYER);
        lypnlGrado.setLayer(lblCanton, javax.swing.JLayeredPane.DEFAULT_LAYER);
        lypnlGrado.setLayer(btnGrado, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout pnlGradoLayout = new javax.swing.GroupLayout(pnlGrado);
        pnlGrado.setLayout(pnlGradoLayout);
        pnlGradoLayout.setHorizontalGroup(
            pnlGradoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lypnlGrado)
        );
        pnlGradoLayout.setVerticalGroup(
            pnlGradoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lypnlGrado)
        );

        tbpnlPrincipal.addTab("Grado", pnlGrado);

        lblCodigoRepresentante.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        lblCodigoRepresentante.setText("Código");

        txtCodigoRepresentante.setEditable(false);
        txtCodigoRepresentante.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N

        txtCedulaRepresentante.setEditable(false);
        txtCedulaRepresentante.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N

        lblCedulaRepresentante.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        lblCedulaRepresentante.setText("Cédula");

        lblPrimerNombreRepresentante.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        lblPrimerNombreRepresentante.setText("Primer Nombre");

        txtPrimerNombreRepresentante.setEditable(false);
        txtPrimerNombreRepresentante.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N

        txtSegundoNombreRepresentante.setEditable(false);
        txtSegundoNombreRepresentante.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N

        lblSegundoNombreRepresentante.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        lblSegundoNombreRepresentante.setText("Segundo Nombre");

        lblApellidoPaternoRepresentante.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        lblApellidoPaternoRepresentante.setText("Apellido Paterno");

        txtApellidoPaternoRepresentante.setEditable(false);
        txtApellidoPaternoRepresentante.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N

        lblApellidoMaternoRepresentante.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        lblApellidoMaternoRepresentante.setText("Apellido Materno");

        txtApellidoMaternoRepresentante.setEditable(false);
        txtApellidoMaternoRepresentante.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N

        btnRepresentante.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        btnRepresentante.setText("Buscar");
        btnRepresentante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRepresentanteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlRepresentanteLayout = new javax.swing.GroupLayout(pnlRepresentante);
        pnlRepresentante.setLayout(pnlRepresentanteLayout);
        pnlRepresentanteLayout.setHorizontalGroup(
            pnlRepresentanteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRepresentanteLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(pnlRepresentanteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(lblApellidoMaternoRepresentante, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblApellidoPaternoRepresentante, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblSegundoNombreRepresentante, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblPrimerNombreRepresentante, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblCedulaRepresentante, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblCodigoRepresentante, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(pnlRepresentanteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlRepresentanteLayout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(txtCodigoRepresentante, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlRepresentanteLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlRepresentanteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCedulaRepresentante, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtApellidoPaternoRepresentante, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtApellidoMaternoRepresentante, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSegundoNombreRepresentante, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPrimerNombreRepresentante, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnRepresentante, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlRepresentanteLayout.setVerticalGroup(
            pnlRepresentanteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRepresentanteLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(pnlRepresentanteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCodigoRepresentante)
                    .addComponent(txtCodigoRepresentante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlRepresentanteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCedulaRepresentante)
                    .addComponent(txtCedulaRepresentante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlRepresentanteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPrimerNombreRepresentante)
                    .addComponent(txtPrimerNombreRepresentante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlRepresentanteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSegundoNombreRepresentante)
                    .addComponent(txtSegundoNombreRepresentante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlRepresentanteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblApellidoPaternoRepresentante)
                    .addComponent(txtApellidoPaternoRepresentante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlRepresentanteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblApellidoMaternoRepresentante)
                    .addGroup(pnlRepresentanteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtApellidoMaternoRepresentante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnRepresentante)))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        tbpnlPrincipal.addTab("Representante", pnlRepresentante);

        javax.swing.GroupLayout pnlFondoLayout = new javax.swing.GroupLayout(pnlFondo);
        pnlFondo.setLayout(pnlFondoLayout);
        pnlFondoLayout.setHorizontalGroup(
            pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFondoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlFondoLayout.createSequentialGroup()
                        .addGap(120, 120, 120)
                        .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblInstitucion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(pnlFondoLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tbpnlPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlFondoLayout.createSequentialGroup()
                .addGap(219, 219, 219)
                .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51))
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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tbpnlPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnActualizar)
                            .addComponent(btnCancelar))))
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
            .addComponent(lypnlFondo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void btnEstudianteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEstudianteActionPerformed
        SeleccionEstudiante frm = new SeleccionEstudiante((Frame) this.getParent(), true);
        frm.setVisible(true);
        frm.setLocationRelativeTo(null);

        if (frm.isBandera()) {
            Estudiantes obj = new LogicaEstudiante().buscarEstudiantePorCod(frm.getCodigo());
            Persona persona = new LogicaPersona().buscarPersonaPorCod(obj.getCodigo());
            txtCodigoMagisterio.setText(String.valueOf(obj.getCodigoMagisterio()));
            txtCedula.setText(persona.getCedula());
            txtPrimerNombre.setText(persona.getPrimerNombre());
            txtSegundoNombre.setText(persona.getSegundoNombre());
            txtApellidoPaterno.setText(persona.getApellidoPaterno());
            txtApellidoMaterno.setText(persona.getApellidoMaterno());
            
            setCodigoEstudiante(obj.getCodigoEstudiante());
        }
    }//GEN-LAST:event_btnEstudianteActionPerformed

    private void btnGradoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGradoActionPerformed
        SeleccionGrado frm = new SeleccionGrado((Frame) this.getParent(), true);
        frm.setVisible(true);
        frm.setLocationRelativeTo(null);

        if (frm.isBandera()) {
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
        }
    }//GEN-LAST:event_btnGradoActionPerformed

    private void btnRepresentanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRepresentanteActionPerformed
        SeleccionRepresentante frm = new SeleccionRepresentante((Frame) this.getParent(), true);
        frm.setVisible(true);
        frm.setLocationRelativeTo(null);

        if (frm.isBandera()) {
            Representantes obj = new LogicaRepresentante().buscarReprentantePorCod(frm.getCodigo());
            Persona persona = new LogicaPersona().buscarPersonaPorCod(obj.getCodigo());
            txtCodigoRepresentante.setText(String.valueOf(obj.getCodigoRepresentante()));
            txtCedulaRepresentante.setText(persona.getCedula());
            txtPrimerNombreRepresentante.setText(persona.getPrimerNombre());
            txtSegundoNombreRepresentante.setText(persona.getSegundoNombre());
            txtApellidoPaternoRepresentante.setText(persona.getApellidoPaterno());
            txtApellidoMaternoRepresentante.setText(persona.getApellidoMaterno());
            
            setCodigoRepresentante(obj.getCodigoRepresentante());
        }
    }//GEN-LAST:event_btnRepresentanteActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
       
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());   
        Date fechaDate = new Date();
        String fechaActual = formato.format(fechaDate);
        
        setBandera(true);

        obj.setCodigo(codigo);
        
        obj.setCodigoEstudiante(codigoEstudiante);
        obj.setCodigoGrado(codigoGrado);
        obj.setCodigoRepresentante(codigoRepresentante);
        obj.setFechaRegistro(fechaActual);

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
            java.util.logging.Logger.getLogger(EditarMatricula.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditarMatricula.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditarMatricula.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditarMatricula.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                EditarMatricula dialog = new EditarMatricula(new javax.swing.JFrame(), true,0);
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
    private javax.swing.JButton btnEstudiante;
    private javax.swing.JButton btnGrado;
    private javax.swing.JButton btnRepresentante;
    private javax.swing.JLabel lblApellidoMaterno;
    private javax.swing.JLabel lblApellidoMaternoRepresentante;
    private javax.swing.JLabel lblApellidoPaterno;
    private javax.swing.JLabel lblApellidoPaternoRepresentante;
    private javax.swing.JLabel lblCanton;
    private javax.swing.JLabel lblCedula;
    private javax.swing.JLabel lblCedulaRepresentante;
    private javax.swing.JLabel lblCodigo;
    private javax.swing.JLabel lblCodigoRepresentante;
    private javax.swing.JLabel lblCurso;
    private javax.swing.JLabel lblInstitucion;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblParalelo;
    private javax.swing.JLabel lblPrimerNombre;
    private javax.swing.JLabel lblPrimerNombreRepresentante;
    private javax.swing.JLabel lblProvincia;
    private javax.swing.JLabel lblSegundoNombre;
    private javax.swing.JLabel lblSegundoNombreRepresentante;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLayeredPane lypnlEstudiante;
    private javax.swing.JLayeredPane lypnlFondo;
    private javax.swing.JLayeredPane lypnlGrado;
    private javax.swing.JPanel pnlEstudiante;
    private javax.swing.JPanel pnlFondo;
    private javax.swing.JPanel pnlGrado;
    private javax.swing.JPanel pnlRepresentante;
    private javax.swing.JTabbedPane tbpnlPrincipal;
    private javax.swing.JTextField txtAnioLectivo;
    private javax.swing.JTextField txtApellidoMaterno;
    private javax.swing.JTextField txtApellidoMaternoRepresentante;
    private javax.swing.JTextField txtApellidoPaterno;
    private javax.swing.JTextField txtApellidoPaternoRepresentante;
    private javax.swing.JTextField txtCedula;
    private javax.swing.JTextField txtCedulaRepresentante;
    private javax.swing.JTextField txtCodigoMagisterio;
    private javax.swing.JTextField txtCodigoRepresentante;
    private javax.swing.JTextField txtCurso;
    private javax.swing.JTextField txtParalelo;
    private javax.swing.JTextField txtPrimerNombre;
    private javax.swing.JTextField txtPrimerNombreRepresentante;
    private javax.swing.JTextField txtSeccion;
    private javax.swing.JTextField txtSegundoNombre;
    private javax.swing.JTextField txtSegundoNombreRepresentante;
    // End of variables declaration//GEN-END:variables

    public long getCodigoEstudiante() {
        return codigoEstudiante;
    }

    public void setCodigoEstudiante(long codigoEstudiante) {
        this.codigoEstudiante = codigoEstudiante;
    }

    public long getCodigoGrado() {
        return codigoGrado;
    }

    public void setCodigoGrado(long codigoGrado) {
        this.codigoGrado = codigoGrado;
    }

    public long getCodigoRepresentante() {
        return codigoRepresentante;
    }

    public void setCodigoRepresentante(long codigoRepresentante) {
        this.codigoRepresentante = codigoRepresentante;
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
