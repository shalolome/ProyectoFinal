package CapaPresentacion.GestionEstudiantil.InscripcionEstudiantil;

import CapaDatos.Entidades.GestionAdministrativa.Categorias.Canton;
import CapaDatos.Entidades.GestionAdministrativa.Categorias.Genero;
import CapaDatos.Entidades.GestionAdministrativa.Categorias.Parroquia;
import CapaDatos.Entidades.GestionAdministrativa.Categorias.Persona;
import CapaDatos.Entidades.GestionAdministrativa.Categorias.Provincia;
import CapaDatos.Entidades.GestionAdministrativa.Institucional.Institucion;
import CapaDatos.Entidades.GestionEstudiantil.Estudiantes;
import CapaLogica.GestionAdministrativa.Categorias.LogicaCanton;
import CapaLogica.GestionAdministrativa.Categorias.LogicaGenero;
import CapaLogica.GestionAdministrativa.Categorias.LogicaParroquia;
import CapaLogica.GestionAdministrativa.Categorias.LogicaPersona;
import CapaLogica.GestionAdministrativa.Categorias.LogicaProvincia;
import CapaLogica.GestionAdministrativa.Institucional.LogicaInstitucion;
import CapaLogica.GestionEstudiantil.LogicaEstudiante;
import CapaPresentacion.Utilidades.Alertas.Mensajes;
import CapaPresentacion.Utilidades.Validaciones.MetodosBusquedas;
import CapaPresentacion.Utilidades.Validaciones.Validaciones;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class EditarInscripcionEstudiantil extends javax.swing.JDialog {

    LogicaInstitucion logicaUnidadEducativa = new LogicaInstitucion();
    Institucion objInstituto = new Institucion();

    Mensajes mensaje = new Mensajes();
    Validaciones validaciones = new Validaciones();
    MetodosBusquedas buscar = new MetodosBusquedas();

    LogicaEstudiante logica = new LogicaEstudiante();
    Estudiantes obj = new Estudiantes();

    LogicaPersona logicaPersona = new LogicaPersona();

    private boolean bandera = false;
    private long codigo;
    private long codigoPersona;

    public EditarInscripcionEstudiantil(java.awt.Frame parent, boolean modal, long cod) {
        super(parent, modal);
        initComponents();

        objInstituto = logicaUnidadEducativa.buscarInsititucionPorCod(1);
        lblInstitucion.setText(objInstituto.getNombre());

        try {
            listarGenero();
            listarProvincia();

            MostrarInformacion(cod);
        } catch (SQLException ex) {
            Logger.getLogger(EditarInscripcionEstudiantil.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //Metodo para Listar Genero
    private void listarGenero() throws SQLException {
        ArrayList<Genero> lista;
        lista = new LogicaGenero().listarGeneros();
        cmbGenero.removeAllItems();
        for (int i = 0; i < lista.size(); i++) {
            cmbGenero.addItem(lista.get(i));
        }
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

    private void MostrarInformacion(long cod) {

        ///////////////////////////////////////////////////////////////////////////////////
        ///////////////////////////////// Personal Administrativo ////////////////////////
        Estudiantes objBuscar = logica.buscarEstudiantePorCod(cod);

        setCodigo(objBuscar.getCodigoEstudiante());

        Parroquia objParroquia = new LogicaParroquia().buscarParroquia(objBuscar.getCodigoParroquia());
        Canton objCanton = new LogicaCanton().buscarCanton(objParroquia.getCodigoCanton());
        Provincia objProvincia = new LogicaProvincia().buscarProvinciaPorCod(objCanton.getCodigoProvincia());

        cmbProvincia.setSelectedIndex(buscar.retornarIndice(cmbProvincia, objProvincia.getNombreProvincia()));
        cmbCanton.setSelectedIndex(buscar.retornarIndice(cmbCanton, objCanton.getNombreCanton()));
        cmbParroquia.setSelectedIndex(buscar.retornarIndice(cmbParroquia, objParroquia.getNombreParroquia()));

        txtCodigoMagisterio.setText(objBuscar.getCodigoMagisterio());
        dchFechaNacimiento.setDate(ConvertirStringDate(objBuscar.getFechaNacimiento()));

        ///////////////////////////////////////////////////////////////////////////////////
        //////////////////////////////////// Persona /////////////////////////////////////
        Persona objPersona = logicaPersona.buscarPersonaPorCod(objBuscar.getCodigo());
        setCodigoPersona(objPersona.getCodigo());
        txtCedula.setText(objPersona.getCedula());
        txtPrimerNombre.setText(objPersona.getPrimerNombre());
        txtSegundoNombre.setText(objPersona.getSegundoNombre());
        txtApellidoPaterno.setText(objPersona.getApellidoPaterno());
        txtApellidoMaterno.setText(objPersona.getApellidoMaterno());
        Genero objGenero = new LogicaGenero().buscarGeneroPorCod(objPersona.getCodigoGenero());
        cmbGenero.setSelectedIndex(buscar.retornarIndice(cmbGenero, objGenero.getNombre()));
        txtDireccion.setText(objPersona.getDireccion());
    }

    private Date ConvertirStringDate(String fecha) {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Date fechaDate = null;
        try {
            fechaDate = formato.parse(revertirCadena(fecha));
        } catch (ParseException ex) {
            Logger.getLogger(EditarInscripcionEstudiantil.class.getName()).log(Level.SEVERE, null, ex);
        }

        return fechaDate;
    }

    private String revertirCadena(String fecha) {
        String nueva = "";
        String dia, mes, anio;
        dia = fecha.substring(8, 10);
        mes = fecha.substring(5, 7);
        anio = fecha.substring(0, 4);
        nueva = dia + "/" + mes + "/" + anio;

        return nueva;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lypnlFondo = new javax.swing.JLayeredPane();
        pnlFondo = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        lblLogo = new javax.swing.JLabel();
        lblCedula = new javax.swing.JLabel();
        lblProvincia = new javax.swing.JLabel();
        lblDireccion = new javax.swing.JLabel();
        txtCedula = new javax.swing.JTextField();
        cmbProvincia = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDireccion = new javax.swing.JTextArea();
        btnActualizar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        lblInstitucion = new javax.swing.JLabel();
        txtPrimerNombre = new javax.swing.JTextField();
        lblPrimerNombre = new javax.swing.JLabel();
        txtSegundoNombre = new javax.swing.JTextField();
        lblSegundoNombre = new javax.swing.JLabel();
        lblApellidoPaterno = new javax.swing.JLabel();
        txtApellidoPaterno = new javax.swing.JTextField();
        lblApellidoMaterno = new javax.swing.JLabel();
        txtApellidoMaterno = new javax.swing.JTextField();
        lblSexo = new javax.swing.JLabel();
        lblFechaNacimiento = new javax.swing.JLabel();
        lblCanton = new javax.swing.JLabel();
        cmbGenero = new javax.swing.JComboBox();
        lblParroquia = new javax.swing.JLabel();
        cmbParroquia = new javax.swing.JComboBox();
        dchFechaNacimiento = new com.toedter.calendar.JDateChooser();
        cmbCanton = new javax.swing.JComboBox();
        lblCedula1 = new javax.swing.JLabel();
        txtCodigoMagisterio = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Actualización de Inscripción Estudiantil");

        pnlFondo.setBackground(new java.awt.Color(255, 255, 255));

        lblTitulo.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        lblTitulo.setText("Actualización de Inscripción Estudiantil");

        lblLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/CapaPresentacion/Imagenes/GestionEstudiantil/estudiantes.png"))); // NOI18N

        lblCedula.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        lblCedula.setText("Cédula");

        lblProvincia.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        lblProvincia.setText("Provincia");

        lblDireccion.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        lblDireccion.setText("Dirección");

        txtCedula.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        txtCedula.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCedulaKeyTyped(evt);
            }
        });

        cmbProvincia.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        cmbProvincia.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbProvinciaItemStateChanged(evt);
            }
        });

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

        lblInstitucion.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        lblInstitucion.setText("Institución");

        txtPrimerNombre.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        txtPrimerNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPrimerNombreKeyTyped(evt);
            }
        });

        lblPrimerNombre.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        lblPrimerNombre.setText("Primer Nombre");

        txtSegundoNombre.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        txtSegundoNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSegundoNombreKeyTyped(evt);
            }
        });

        lblSegundoNombre.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        lblSegundoNombre.setText("Segundo Nombre");

        lblApellidoPaterno.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        lblApellidoPaterno.setText("Apellido Paterno");

        txtApellidoPaterno.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        txtApellidoPaterno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtApellidoPaternoKeyTyped(evt);
            }
        });

        lblApellidoMaterno.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        lblApellidoMaterno.setText("Apellido Materno");

        txtApellidoMaterno.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        txtApellidoMaterno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtApellidoMaternoKeyTyped(evt);
            }
        });

        lblSexo.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        lblSexo.setText("Genero");

        lblFechaNacimiento.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        lblFechaNacimiento.setText("Fecha Nacimiento");

        lblCanton.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        lblCanton.setText("Cantón");

        cmbGenero.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N

        lblParroquia.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        lblParroquia.setText("Parroquia");

        cmbParroquia.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N

        dchFechaNacimiento.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N

        cmbCanton.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        cmbCanton.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbCantonItemStateChanged(evt);
            }
        });

        lblCedula1.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        lblCedula1.setText("Código");

        txtCodigoMagisterio.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N

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
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(pnlFondoLayout.createSequentialGroup()
                        .addGap(74, 74, 74)
                        .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblInstitucion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pnlFondoLayout.createSequentialGroup()
                        .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlFondoLayout.createSequentialGroup()
                                .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lblSegundoNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)
                                    .addComponent(lblPrimerNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblCedula, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtPrimerNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(txtCedula, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtSegundoNombre, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlFondoLayout.createSequentialGroup()
                                .addComponent(lblApellidoMaterno, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtApellidoMaterno, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlFondoLayout.createSequentialGroup()
                                .addComponent(lblApellidoPaterno, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtApellidoPaterno, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlFondoLayout.createSequentialGroup()
                                .addComponent(lblSexo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbGenero, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlFondoLayout.createSequentialGroup()
                                .addComponent(lblFechaNacimiento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(dchFechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlFondoLayout.createSequentialGroup()
                                .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblDireccion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblProvincia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblParroquia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblCanton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cmbProvincia, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 308, Short.MAX_VALUE)
                                    .addComponent(cmbParroquia, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cmbCanton, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(pnlFondoLayout.createSequentialGroup()
                                .addComponent(lblCedula1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCodigoMagisterio, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(206, 206, 206))))
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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblCedula1)
                            .addComponent(txtCodigoMagisterio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblCedula)
                            .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblPrimerNombre)
                            .addComponent(txtPrimerNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(9, 9, 9)
                        .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblSegundoNombre)
                            .addComponent(txtSegundoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblApellidoPaterno)
                            .addComponent(txtApellidoPaterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblApellidoMaterno)
                            .addComponent(txtApellidoMaterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblSexo)
                            .addComponent(cmbGenero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblFechaNacimiento)
                            .addComponent(dchFechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmbProvincia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblProvincia))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblCanton)
                            .addComponent(cmbCanton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmbParroquia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblParroquia))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblDireccion))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnCancelar)
                            .addComponent(btnActualizar)))
                    .addGroup(pnlFondoLayout.createSequentialGroup()
                        .addComponent(lblLogo)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout lypnlFondoLayout = new javax.swing.GroupLayout(lypnlFondo);
        lypnlFondo.setLayout(lypnlFondoLayout);
        lypnlFondoLayout.setHorizontalGroup(
            lypnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlFondo, javax.swing.GroupLayout.PREFERRED_SIZE, 707, Short.MAX_VALUE)
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

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        setBandera(true);
        SimpleDateFormat fecha = new SimpleDateFormat("yyyy-MM-dd");
        ///////////////////////////////////////////////////////////////////////////////////
        //////////////////////////////////// Persona /////////////////////////////////////
        Persona objPersona = new Persona();
        objPersona.setCodigo(codigoPersona);
        objPersona.setCedula(txtCedula.getText());
        objPersona.setPrimerNombre(txtPrimerNombre.getText());
        objPersona.setSegundoNombre(txtSegundoNombre.getText());
        objPersona.setApellidoPaterno(txtApellidoPaterno.getText());
        objPersona.setApellidoMaterno(txtApellidoMaterno.getText());
        objPersona.setCodigoGenero(((Genero) (cmbGenero.getSelectedItem())).getCodigo());
        objPersona.setDireccion(txtDireccion.getText());

        logicaPersona.Actualizar(objPersona);

        ///////////////////////////////////////////////////////////////////////////////////
        ///////////////////////////////// Estudiantes /////////// ////////////////////////
        obj.setCodigoEstudiante(codigo);
        obj.setCodigo(codigoPersona);
        obj.setCodigoMagisterio(txtCodigoMagisterio.getText());
        obj.setFechaNacimiento(fecha.format(dchFechaNacimiento.getDate()));
        obj.setCodigoParroquia(((Parroquia) (cmbParroquia.getSelectedItem())).getCodigoParroquia());
        mensaje.MensajeInformacion("Se ha editado correctamente", "EDITAR");

        logica.Actualizar(obj);
        
        this.dispose();
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void cmbProvinciaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbProvinciaItemStateChanged
        try {
            if (cmbProvincia.getSelectedIndex() > -1) {
                long codigoProvincia = ((Provincia) cmbProvincia.getSelectedItem()).getCodigoProvincia();
                listarCanton(codigoProvincia);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.toString());
        }
    }//GEN-LAST:event_cmbProvinciaItemStateChanged

    private void cmbCantonItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbCantonItemStateChanged
        try {
            if (cmbCanton.getSelectedIndex() > -1) {
                long codigoCanton = ((Canton) cmbCanton.getSelectedItem()).getCodigoCanton();
                listarParroquia(codigoCanton);
            } else {
                cmbParroquia.removeAllItems();
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.toString());
        }
    }//GEN-LAST:event_cmbCantonItemStateChanged

    private void txtCedulaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCedulaKeyTyped
        validaciones.numerosCedula(evt, txtCedula);
    }//GEN-LAST:event_txtCedulaKeyTyped

    private void txtPrimerNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrimerNombreKeyTyped
        validaciones.validarLetras(evt);
    }//GEN-LAST:event_txtPrimerNombreKeyTyped

    private void txtSegundoNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSegundoNombreKeyTyped
        validaciones.validarLetras(evt);
    }//GEN-LAST:event_txtSegundoNombreKeyTyped

    private void txtApellidoPaternoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApellidoPaternoKeyTyped
        validaciones.validarLetras(evt);
    }//GEN-LAST:event_txtApellidoPaternoKeyTyped

    private void txtApellidoMaternoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApellidoMaternoKeyTyped
        validaciones.validarLetras(evt);
    }//GEN-LAST:event_txtApellidoMaternoKeyTyped

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
            java.util.logging.Logger.getLogger(EditarInscripcionEstudiantil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditarInscripcionEstudiantil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditarInscripcionEstudiantil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditarInscripcionEstudiantil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                EditarInscripcionEstudiantil dialog = new EditarInscripcionEstudiantil(new javax.swing.JFrame(), true, 0);
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
    private javax.swing.JComboBox cmbCanton;
    private javax.swing.JComboBox cmbGenero;
    private javax.swing.JComboBox cmbParroquia;
    private javax.swing.JComboBox cmbProvincia;
    private com.toedter.calendar.JDateChooser dchFechaNacimiento;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblApellidoMaterno;
    private javax.swing.JLabel lblApellidoPaterno;
    private javax.swing.JLabel lblCanton;
    private javax.swing.JLabel lblCedula;
    private javax.swing.JLabel lblCedula1;
    private javax.swing.JLabel lblDireccion;
    private javax.swing.JLabel lblFechaNacimiento;
    private javax.swing.JLabel lblInstitucion;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblParroquia;
    private javax.swing.JLabel lblPrimerNombre;
    private javax.swing.JLabel lblProvincia;
    private javax.swing.JLabel lblSegundoNombre;
    private javax.swing.JLabel lblSexo;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLayeredPane lypnlFondo;
    private javax.swing.JPanel pnlFondo;
    private javax.swing.JTextField txtApellidoMaterno;
    private javax.swing.JTextField txtApellidoPaterno;
    private javax.swing.JTextField txtCedula;
    private javax.swing.JTextField txtCodigoMagisterio;
    private javax.swing.JTextArea txtDireccion;
    private javax.swing.JTextField txtPrimerNombre;
    private javax.swing.JTextField txtSegundoNombre;
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

    public long getCodigoPersona() {
        return codigoPersona;
    }

    public void setCodigoPersona(long codigoPersona) {
        this.codigoPersona = codigoPersona;
    }
}
