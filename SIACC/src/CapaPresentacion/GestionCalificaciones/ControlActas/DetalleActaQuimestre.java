
package CapaPresentacion.GestionCalificaciones.ControlActas;
import CapaDatos.Entidades.GestionAcademica.Asignatura.Asignatura;
import CapaDatos.Entidades.GestionAcademica.Asignatura.Distributivo;
import CapaDatos.Entidades.GestionAcademica.Asignatura.Malla;
import CapaDatos.Entidades.GestionAcademica.Curso.Grado;
import CapaDatos.Entidades.GestionAcademica.Curso.Nivel;
import CapaDatos.Entidades.GestionAcademica.Curso.Paralelo;
import CapaDatos.Entidades.GestionAdministrativa.Categorias.Persona;
import CapaDatos.Entidades.GestionAdministrativa.Institucional.AnioLectivo;
import CapaDatos.Entidades.GestionAdministrativa.Institucional.AsigCargos;
import CapaPresentacion.GestionCalificaciones.ControlCalificaciones.*;
import CapaPresentacion.GestionAcademica.DistributivoDocentes.*;
import CapaPresentacion.GestionAcademica.ControlCursos.*;
import CapaDatos.Entidades.GestionAdministrativa.Institucional.Institucion;
import CapaDatos.Entidades.GestionAdministrativa.Institucional.Personal;
import CapaDatos.Entidades.GestionAdministrativa.Institucional.Seccion;
import CapaDatos.Entidades.GestionCalificaciones.Acta;
import CapaDatos.Entidades.GestionCalificaciones.PeriodoAcademicos;
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
import CapaLogica.GestionCalificaciones.LogicaActa;
import CapaLogica.GestionCalificaciones.LogicaDetalleParcial;
import CapaLogica.GestionCalificaciones.LogicaDetalleQuimestre;
import CapaLogica.GestionCalificaciones.LogicaPeriodoAcademico;
import CapaPresentacion.Utilidades.Alertas.Mensajes;
import java.awt.Frame;
import javax.swing.table.DefaultTableModel;

public class DetalleActaQuimestre extends javax.swing.JDialog {

    LogicaInstitucion logicaUnidadEducativa = new LogicaInstitucion();
    Institucion objInstituto = new Institucion();
    
    String[] tblEtiquetaNomina = new String[]{"CODIGO",
        "ESTUDIANTE",
        "PARCIAL 1",
        "PARCIAL 2",
        "PARCIAL 3",
        "PROMEDIO",
        "EXAMEN",
        "PROMEDIO FINAL"};
    
    LogicaDetalleQuimestre logica = new LogicaDetalleQuimestre();

    Mensajes mensaje = new Mensajes();
    private boolean bandera = false;
    private long codigo;
    
    public DetalleActaQuimestre(java.awt.Frame parent, boolean modal, long cod) {
        super(parent, modal);
        initComponents();
        
        this.setLocationRelativeTo(null);
        objInstituto = logicaUnidadEducativa.buscarInsititucionPorCod(1);
        lblInstitucion.setText(objInstituto.getNombre());
        listar(cod);
        mostrarInformacion(cod);
    }

    public void listar(long codActa) {
        tblListado.setModel(new DefaultTableModel(logica.ListarPorActa(codActa), tblEtiquetaNomina) {
            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return false;
            }
        });
    }
    
    private void mostrarInformacion(long cod){
        
        Acta objBuscar = new LogicaActa().buscarActaPorCod(cod);
        
        Distributivo objDistr = new LogicaDistributivo().buscarDistributivoPorCod(objBuscar.getCodigoDistributivo());
        
        Grado objGrado = new LogicaGrado().buscarGradoPorCod(objDistr.getCodigoGrado());
        Nivel objNivel = new LogicaNivel().buscarNivelPorCod(objGrado.getCodigoNivel());
        txtCurso.setText(objNivel.getNombre());
        Paralelo objParalelo = new LogicaParalelo().buscarParaleloPorCod(objGrado.getCodigoParalelo());
        txtParalelo.setText(objParalelo.getNombre());
        Seccion objSeccion = new LogicaSecciones().buscarSeccionPorCod(objGrado.getCodigoSeccion());
        txtSeccion.setText(objSeccion.getNombre());
        AnioLectivo objAnioLectivo = new LogicaAnioLectivo().buscarAnioLectivoPorCod(objGrado.getCodigoAnioLectivo());
        txtAnioLectivo.setText(objAnioLectivo.getAnioInicio()+" - "+objAnioLectivo.getAnioFin());
        
        Malla objMalla = new LogicaMallaCurricular().buscarMallaPorCod(objDistr.getCodigoMallaCurricular());
        Asignatura objAsignatura = new LogicaAsignatura().buscarAsignaturaPorCod(objMalla.getCodigoAsignatura());
        txtAsignatura.setText(objAsignatura.getNombre());
        
        AsigCargos objAsigCarg = new LogicaAsignacionCargos().buscarAsigCargoPorCod(objDistr.getAsignacionCargo());
        Personal obj = new LogicaPersonalAdministrativo().buscarPersonalPorCod(objAsigCarg.getCodigoPersona());
        Persona persona = new LogicaPersona().buscarPersonaPorCod(obj.getCodigo());
        txtDocente.setText(persona.getPrimerNombre() + " " + persona.getSegundoNombre() + " "
                + persona.getApellidoPaterno() + " " + persona.getApellidoMaterno());
        
        PeriodoAcademicos objPeriodo = new LogicaPeriodoAcademico().buscarPeriodoAcademicoPorCod(objBuscar.getCodigoPeriodo());
        txtPeriodo.setText(objPeriodo.getNombre());
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
        lblCurso = new javax.swing.JLabel();
        txtCurso = new javax.swing.JTextField();
        txtParalelo = new javax.swing.JTextField();
        lblParalelo = new javax.swing.JLabel();
        lblAnioLectivo = new javax.swing.JLabel();
        txtAnioLectivo = new javax.swing.JTextField();
        txtSeccion = new javax.swing.JTextField();
        lblParalelo1 = new javax.swing.JLabel();
        lblAsignatura = new javax.swing.JLabel();
        txtAsignatura = new javax.swing.JTextField();
        lblDocente = new javax.swing.JLabel();
        txtDocente = new javax.swing.JTextField();
        lblPeriodo = new javax.swing.JLabel();
        txtPeriodo = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Detalle Actas Quimestres");

        pnlFondo.setBackground(new java.awt.Color(255, 255, 255));

        lblTitulo.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        lblTitulo.setText("Detalle Actas de Quimestres");

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
                "CODIGO", "ESTUDIANTE", "PARCIAL 1", "PARCIAL 2", "PARCIAL 3", "PROMEDIO", "EXAMEN", "PROMEDIO FINAL"
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

        lblCurso.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        lblCurso.setText("Curso");

        txtCurso.setEditable(false);
        txtCurso.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N

        txtParalelo.setEditable(false);
        txtParalelo.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N

        lblParalelo.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        lblParalelo.setText("Paralelo");

        lblAnioLectivo.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        lblAnioLectivo.setText("Año Lectivo");

        txtAnioLectivo.setEditable(false);
        txtAnioLectivo.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N

        txtSeccion.setEditable(false);
        txtSeccion.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N

        lblParalelo1.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        lblParalelo1.setText("Sección");

        lblAsignatura.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        lblAsignatura.setText("Asignatura");

        txtAsignatura.setEditable(false);
        txtAsignatura.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N

        lblDocente.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        lblDocente.setText("Docente");

        txtDocente.setEditable(false);
        txtDocente.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N

        lblPeriodo.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        lblPeriodo.setText("Periodo");

        txtPeriodo.setEditable(false);
        txtPeriodo.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N

        javax.swing.GroupLayout pnlFondoLayout = new javax.swing.GroupLayout(pnlFondo);
        pnlFondo.setLayout(pnlFondoLayout);
        pnlFondoLayout.setHorizontalGroup(
            pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFondoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLogo)
                .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlFondoLayout.createSequentialGroup()
                        .addGap(81, 81, 81)
                        .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblInstitucion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(pnlFondoLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(pnlFondoLayout.createSequentialGroup()
                                .addComponent(lblParalelo1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtSeccion))
                            .addGroup(pnlFondoLayout.createSequentialGroup()
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
                                    .addComponent(txtParalelo)))
                            .addGroup(pnlFondoLayout.createSequentialGroup()
                                .addComponent(lblAsignatura, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pnlFondoLayout.createSequentialGroup()
                                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 106, Short.MAX_VALUE))
                                    .addComponent(txtAsignatura)))
                            .addGroup(pnlFondoLayout.createSequentialGroup()
                                .addComponent(lblDocente, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtDocente))
                            .addGroup(pnlFondoLayout.createSequentialGroup()
                                .addComponent(lblPeriodo, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtPeriodo)))))
                .addContainerGap(122, Short.MAX_VALUE))
            .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlFondoLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 583, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        pnlFondoLayout.setVerticalGroup(
            pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFondoLayout.createSequentialGroup()
                .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlFondoLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(lblTitulo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblInstitucion)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblCurso)
                            .addComponent(txtCurso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblParalelo)
                            .addComponent(txtParalelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblAnioLectivo)
                            .addComponent(txtAnioLectivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblParalelo1)
                            .addComponent(txtSeccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(7, 7, 7)
                        .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblAsignatura)
                            .addComponent(txtAsignatura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDocente)
                    .addComponent(txtDocente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPeriodo)
                    .addComponent(txtPeriodo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 185, Short.MAX_VALUE)
                .addComponent(btnCancelar)
                .addContainerGap())
            .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlFondoLayout.createSequentialGroup()
                    .addGap(301, 301, 301)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(48, Short.MAX_VALUE)))
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
            java.util.logging.Logger.getLogger(Cursos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Cursos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Cursos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Cursos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Cursos dialog = new Cursos(new javax.swing.JFrame(), true);
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAnioLectivo;
    private javax.swing.JLabel lblAsignatura;
    private javax.swing.JLabel lblCurso;
    private javax.swing.JLabel lblDocente;
    private javax.swing.JLabel lblInstitucion;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblParalelo;
    private javax.swing.JLabel lblParalelo1;
    private javax.swing.JLabel lblPeriodo;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLayeredPane lypnlFondo;
    private javax.swing.JPanel pnlFondo;
    private javax.swing.JTable tblListado;
    private javax.swing.JTextField txtAnioLectivo;
    private javax.swing.JTextField txtAsignatura;
    private javax.swing.JTextField txtCurso;
    private javax.swing.JTextField txtDocente;
    private javax.swing.JTextField txtParalelo;
    private javax.swing.JTextField txtPeriodo;
    private javax.swing.JTextField txtSeccion;
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
