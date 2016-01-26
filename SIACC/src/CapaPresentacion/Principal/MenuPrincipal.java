
package CapaPresentacion.Principal;

import CapaPresentacion.GestionAcademica.ControlAsignaturas.Asignaturas;
import CapaPresentacion.GestionAcademica.ControlCursos.Cursos;
import CapaPresentacion.GestionAcademica.DistributivoDocentes.DistributivoDocentes;
import CapaPresentacion.GestionAcademica.HorarioClases.Horarios;
import CapaPresentacion.GestionAcademica.MallaCurricular.MallaCurricular;
import CapaPresentacion.GestionAcademica.PeriodoLectivo.PeriodoLectivo;
import CapaPresentacion.GestionAdministrativa.AsignacionCargos.AsignacionCargos;
import CapaPresentacion.GestionAdministrativa.ConfiguracionSecciones.ConfiguracionSecciones;
import CapaPresentacion.GestionAdministrativa.ControlInformacionInstitucional.InformacionInstitucional;
import CapaPresentacion.GestionAdministrativa.ControlPersonal.PersonalAdministrativo;
import CapaPresentacion.GestionCalificaciones.ControlActas.PeriodoAcademico;
import CapaPresentacion.GestionCalificaciones.ControlCalificaciones.Parciales.CalificacionesParciales;
import CapaPresentacion.GestionEstudiantil.ControlRepresentantes.ControlRepresentantes;
import CapaPresentacion.GestionEstudiantil.InscripcionEstudiantil.InscripcionEstudiantil;
import CapaPresentacion.GestionEstudiantil.Matriculacion.Matriculacion;

public class MenuPrincipal extends javax.swing.JFrame {

    public MenuPrincipal() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lypnlMenu = new javax.swing.JLayeredPane();
        pnlFondo = new javax.swing.JPanel();
        lypnlFondo = new javax.swing.JLayeredPane();
        lblLogo = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuGestionAdminitrativa = new javax.swing.JMenu();
        MenuItemInformacionInstitucional = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        MenuItemConfiguracionSecciones = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        MenuItemPersonalAdministrativo = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        MenuItemAsignacionCargos = new javax.swing.JMenuItem();
        menuGestionAdminitrativa1 = new javax.swing.JMenu();
        MenuItemPeriodoLectivo = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JPopupMenu.Separator();
        MenuItemControlAsignaturas = new javax.swing.JMenuItem();
        jSeparator6 = new javax.swing.JPopupMenu.Separator();
        MenuItemMallaCurricular = new javax.swing.JMenuItem();
        jSeparator5 = new javax.swing.JPopupMenu.Separator();
        MenuItemControlCursos = new javax.swing.JMenuItem();
        jSeparator7 = new javax.swing.JPopupMenu.Separator();
        MenuItemDistributivoDocentes = new javax.swing.JMenuItem();
        jSeparator8 = new javax.swing.JPopupMenu.Separator();
        MenuItemHorarioClases = new javax.swing.JMenuItem();
        menuGestionAdminitrativa2 = new javax.swing.JMenu();
        MenuItemInscripcionEstudiantil = new javax.swing.JMenuItem();
        jSeparator9 = new javax.swing.JPopupMenu.Separator();
        MenuItemControlRepresentantes = new javax.swing.JMenuItem();
        jSeparator10 = new javax.swing.JPopupMenu.Separator();
        MenuItemMatriculacion = new javax.swing.JMenuItem();
        menuGestionAdminitrativa3 = new javax.swing.JMenu();
        MenuItemPeriodoAcademico = new javax.swing.JMenuItem();
        jSeparator11 = new javax.swing.JPopupMenu.Separator();
        menuControlCalificaciones = new javax.swing.JMenu();
        MenuItemNotasParcial = new javax.swing.JMenuItem();
        jSeparator12 = new javax.swing.JPopupMenu.Separator();
        MenuItemNotasQuimestre = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SIACC");

        lblLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/CapaPresentacion/Imagenes/Logos/Logo_1.png"))); // NOI18N

        javax.swing.GroupLayout lypnlFondoLayout = new javax.swing.GroupLayout(lypnlFondo);
        lypnlFondo.setLayout(lypnlFondoLayout);
        lypnlFondoLayout.setHorizontalGroup(
            lypnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lypnlFondoLayout.createSequentialGroup()
                .addContainerGap(380, Short.MAX_VALUE)
                .addComponent(lblLogo)
                .addGap(214, 214, 214))
        );
        lypnlFondoLayout.setVerticalGroup(
            lypnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lypnlFondoLayout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addComponent(lblLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(116, Short.MAX_VALUE))
        );
        lypnlFondo.setLayer(lblLogo, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout pnlFondoLayout = new javax.swing.GroupLayout(pnlFondo);
        pnlFondo.setLayout(pnlFondoLayout);
        pnlFondoLayout.setHorizontalGroup(
            pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lypnlFondo)
        );
        pnlFondoLayout.setVerticalGroup(
            pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lypnlFondo)
        );

        javax.swing.GroupLayout lypnlMenuLayout = new javax.swing.GroupLayout(lypnlMenu);
        lypnlMenu.setLayout(lypnlMenuLayout);
        lypnlMenuLayout.setHorizontalGroup(
            lypnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlFondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        lypnlMenuLayout.setVerticalGroup(
            lypnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlFondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        lypnlMenu.setLayer(pnlFondo, javax.swing.JLayeredPane.DEFAULT_LAYER);

        menuGestionAdminitrativa.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        menuGestionAdminitrativa.setText("Gestión Administrativa");
        menuGestionAdminitrativa.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N

        MenuItemInformacionInstitucional.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        MenuItemInformacionInstitucional.setText("Control de Información Institucional");
        MenuItemInformacionInstitucional.setBorder(null);
        MenuItemInformacionInstitucional.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuItemInformacionInstitucionalActionPerformed(evt);
            }
        });
        menuGestionAdminitrativa.add(MenuItemInformacionInstitucional);
        menuGestionAdminitrativa.add(jSeparator1);

        MenuItemConfiguracionSecciones.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        MenuItemConfiguracionSecciones.setText("Configuración de Secciones");
        MenuItemConfiguracionSecciones.setBorder(null);
        MenuItemConfiguracionSecciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuItemConfiguracionSeccionesActionPerformed(evt);
            }
        });
        menuGestionAdminitrativa.add(MenuItemConfiguracionSecciones);
        menuGestionAdminitrativa.add(jSeparator2);

        MenuItemPersonalAdministrativo.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        MenuItemPersonalAdministrativo.setText("Control de Personal Administrativo");
        MenuItemPersonalAdministrativo.setBorder(null);
        MenuItemPersonalAdministrativo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuItemPersonalAdministrativoActionPerformed(evt);
            }
        });
        menuGestionAdminitrativa.add(MenuItemPersonalAdministrativo);
        menuGestionAdminitrativa.add(jSeparator3);

        MenuItemAsignacionCargos.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        MenuItemAsignacionCargos.setText("Asignación de Cargos");
        MenuItemAsignacionCargos.setBorder(null);
        MenuItemAsignacionCargos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuItemAsignacionCargosActionPerformed(evt);
            }
        });
        menuGestionAdminitrativa.add(MenuItemAsignacionCargos);

        jMenuBar1.add(menuGestionAdminitrativa);

        menuGestionAdminitrativa1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        menuGestionAdminitrativa1.setText("Gestión Académica");
        menuGestionAdminitrativa1.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N

        MenuItemPeriodoLectivo.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        MenuItemPeriodoLectivo.setText("Período Lectivo");
        MenuItemPeriodoLectivo.setBorder(null);
        MenuItemPeriodoLectivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuItemPeriodoLectivoActionPerformed(evt);
            }
        });
        menuGestionAdminitrativa1.add(MenuItemPeriodoLectivo);
        menuGestionAdminitrativa1.add(jSeparator4);

        MenuItemControlAsignaturas.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        MenuItemControlAsignaturas.setText("Control de Asignaturas");
        MenuItemControlAsignaturas.setBorder(null);
        MenuItemControlAsignaturas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuItemControlAsignaturasActionPerformed(evt);
            }
        });
        menuGestionAdminitrativa1.add(MenuItemControlAsignaturas);
        menuGestionAdminitrativa1.add(jSeparator6);

        MenuItemMallaCurricular.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        MenuItemMallaCurricular.setText("Malla Curricular");
        MenuItemMallaCurricular.setBorder(null);
        MenuItemMallaCurricular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuItemMallaCurricularActionPerformed(evt);
            }
        });
        menuGestionAdminitrativa1.add(MenuItemMallaCurricular);
        menuGestionAdminitrativa1.add(jSeparator5);

        MenuItemControlCursos.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        MenuItemControlCursos.setText("Control de Cursos");
        MenuItemControlCursos.setBorder(null);
        MenuItemControlCursos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuItemControlCursosActionPerformed(evt);
            }
        });
        menuGestionAdminitrativa1.add(MenuItemControlCursos);
        menuGestionAdminitrativa1.add(jSeparator7);

        MenuItemDistributivoDocentes.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        MenuItemDistributivoDocentes.setText("Distributivo de Docentes");
        MenuItemDistributivoDocentes.setBorder(null);
        MenuItemDistributivoDocentes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuItemDistributivoDocentesActionPerformed(evt);
            }
        });
        menuGestionAdminitrativa1.add(MenuItemDistributivoDocentes);
        menuGestionAdminitrativa1.add(jSeparator8);

        MenuItemHorarioClases.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        MenuItemHorarioClases.setText("Horarios de Clases");
        MenuItemHorarioClases.setBorder(null);
        MenuItemHorarioClases.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuItemHorarioClasesActionPerformed(evt);
            }
        });
        menuGestionAdminitrativa1.add(MenuItemHorarioClases);

        jMenuBar1.add(menuGestionAdminitrativa1);

        menuGestionAdminitrativa2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        menuGestionAdminitrativa2.setText("Gestión Estudiantil");
        menuGestionAdminitrativa2.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N

        MenuItemInscripcionEstudiantil.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        MenuItemInscripcionEstudiantil.setText("Inscripción Estudiantil");
        MenuItemInscripcionEstudiantil.setBorder(null);
        MenuItemInscripcionEstudiantil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuItemInscripcionEstudiantilActionPerformed(evt);
            }
        });
        menuGestionAdminitrativa2.add(MenuItemInscripcionEstudiantil);
        menuGestionAdminitrativa2.add(jSeparator9);

        MenuItemControlRepresentantes.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        MenuItemControlRepresentantes.setText("Control de Representantes");
        MenuItemControlRepresentantes.setBorder(null);
        MenuItemControlRepresentantes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuItemControlRepresentantesActionPerformed(evt);
            }
        });
        menuGestionAdminitrativa2.add(MenuItemControlRepresentantes);
        menuGestionAdminitrativa2.add(jSeparator10);

        MenuItemMatriculacion.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        MenuItemMatriculacion.setText("Matriculación");
        MenuItemMatriculacion.setBorder(null);
        MenuItemMatriculacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuItemMatriculacionActionPerformed(evt);
            }
        });
        menuGestionAdminitrativa2.add(MenuItemMatriculacion);

        jMenuBar1.add(menuGestionAdminitrativa2);

        menuGestionAdminitrativa3.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        menuGestionAdminitrativa3.setText("Gestión de Calificaciones");
        menuGestionAdminitrativa3.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N

        MenuItemPeriodoAcademico.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        MenuItemPeriodoAcademico.setText("Control de Actas ");
        MenuItemPeriodoAcademico.setBorder(null);
        MenuItemPeriodoAcademico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuItemPeriodoAcademicoActionPerformed(evt);
            }
        });
        menuGestionAdminitrativa3.add(MenuItemPeriodoAcademico);
        menuGestionAdminitrativa3.add(jSeparator11);

        menuControlCalificaciones.setText("Control de Calificaciones");
        menuControlCalificaciones.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N

        MenuItemNotasParcial.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        MenuItemNotasParcial.setText("Control de Parciales");
        MenuItemNotasParcial.setBorder(null);
        MenuItemNotasParcial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuItemNotasParcialActionPerformed(evt);
            }
        });
        menuControlCalificaciones.add(MenuItemNotasParcial);
        menuControlCalificaciones.add(jSeparator12);

        MenuItemNotasQuimestre.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        MenuItemNotasQuimestre.setText("Control de Quimestres");
        MenuItemNotasQuimestre.setActionCommand("Control de Quimestres");
        MenuItemNotasQuimestre.setBorder(null);
        MenuItemNotasQuimestre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuItemNotasQuimestreActionPerformed(evt);
            }
        });
        menuControlCalificaciones.add(MenuItemNotasQuimestre);

        menuGestionAdminitrativa3.add(menuControlCalificaciones);

        jMenuBar1.add(menuGestionAdminitrativa3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lypnlMenu)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lypnlMenu)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void MenuItemInformacionInstitucionalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuItemInformacionInstitucionalActionPerformed
        InformacionInstitucional frm = new InformacionInstitucional(this, true);
        frm.setLocationRelativeTo(null);
        frm.setVisible(true);
    }//GEN-LAST:event_MenuItemInformacionInstitucionalActionPerformed

    private void MenuItemConfiguracionSeccionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuItemConfiguracionSeccionesActionPerformed
        ConfiguracionSecciones frm = new ConfiguracionSecciones(this, true);
        frm.setLocationRelativeTo(null);
        frm.setVisible(true);
    }//GEN-LAST:event_MenuItemConfiguracionSeccionesActionPerformed

    private void MenuItemAsignacionCargosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuItemAsignacionCargosActionPerformed
        AsignacionCargos frm = new AsignacionCargos(this, true);
        frm.setLocationRelativeTo(null);
        frm.setVisible(true);
    }//GEN-LAST:event_MenuItemAsignacionCargosActionPerformed

    private void MenuItemPersonalAdministrativoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuItemPersonalAdministrativoActionPerformed
        PersonalAdministrativo frm = new PersonalAdministrativo(this, true);
        frm.setLocationRelativeTo(null);
        frm.setVisible(true);
    }//GEN-LAST:event_MenuItemPersonalAdministrativoActionPerformed

    private void MenuItemPeriodoLectivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuItemPeriodoLectivoActionPerformed
        PeriodoLectivo frm = new PeriodoLectivo(this, true);
        frm.setLocationRelativeTo(null);
        frm.setVisible(true);
    }//GEN-LAST:event_MenuItemPeriodoLectivoActionPerformed

    private void MenuItemControlAsignaturasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuItemControlAsignaturasActionPerformed
        Asignaturas frm = new Asignaturas(this, true);
        frm.setLocationRelativeTo(null);
        frm.setVisible(true);
    }//GEN-LAST:event_MenuItemControlAsignaturasActionPerformed

    private void MenuItemMallaCurricularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuItemMallaCurricularActionPerformed
        MallaCurricular frm = new MallaCurricular(this, true);
        frm.setLocationRelativeTo(null);
        frm.setVisible(true);
    }//GEN-LAST:event_MenuItemMallaCurricularActionPerformed

    private void MenuItemControlCursosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuItemControlCursosActionPerformed
        Cursos frm = new Cursos(this, true);
        frm.setLocationRelativeTo(null);
        frm.setVisible(true);
    }//GEN-LAST:event_MenuItemControlCursosActionPerformed

    private void MenuItemDistributivoDocentesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuItemDistributivoDocentesActionPerformed
        DistributivoDocentes frm = new DistributivoDocentes(this, true);
        frm.setLocationRelativeTo(null);
        frm.setVisible(true);
    }//GEN-LAST:event_MenuItemDistributivoDocentesActionPerformed

    private void MenuItemHorarioClasesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuItemHorarioClasesActionPerformed
        Horarios frm = new Horarios(this, true);
        frm.setLocationRelativeTo(null);
        frm.setVisible(true);
    }//GEN-LAST:event_MenuItemHorarioClasesActionPerformed

    private void MenuItemInscripcionEstudiantilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuItemInscripcionEstudiantilActionPerformed
        InscripcionEstudiantil frm = new InscripcionEstudiantil(this, true);
        frm.setLocationRelativeTo(null);
        frm.setVisible(true);
    }//GEN-LAST:event_MenuItemInscripcionEstudiantilActionPerformed

    private void MenuItemMatriculacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuItemMatriculacionActionPerformed
        Matriculacion frm = new Matriculacion(this, true);
        frm.setLocationRelativeTo(null);
        frm.setVisible(true);
    }//GEN-LAST:event_MenuItemMatriculacionActionPerformed

    private void MenuItemControlRepresentantesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuItemControlRepresentantesActionPerformed
        ControlRepresentantes frm = new ControlRepresentantes(this, true);
        frm.setLocationRelativeTo(null);
        frm.setVisible(true);
    }//GEN-LAST:event_MenuItemControlRepresentantesActionPerformed

    private void MenuItemPeriodoAcademicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuItemPeriodoAcademicoActionPerformed
        PeriodoAcademico frm = new PeriodoAcademico(this, true);
        frm.setLocationRelativeTo(null);
        frm.setVisible(true);
    }//GEN-LAST:event_MenuItemPeriodoAcademicoActionPerformed

    private void MenuItemNotasParcialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuItemNotasParcialActionPerformed
        CalificacionesParciales frm = new CalificacionesParciales(this, true);
        frm.setLocationRelativeTo(null);
        frm.setVisible(true);
    }//GEN-LAST:event_MenuItemNotasParcialActionPerformed

    private void MenuItemNotasQuimestreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuItemNotasQuimestreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MenuItemNotasQuimestreActionPerformed

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
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem MenuItemAsignacionCargos;
    private javax.swing.JMenuItem MenuItemConfiguracionSecciones;
    private javax.swing.JMenuItem MenuItemControlAsignaturas;
    private javax.swing.JMenuItem MenuItemControlCursos;
    private javax.swing.JMenuItem MenuItemControlRepresentantes;
    private javax.swing.JMenuItem MenuItemDistributivoDocentes;
    private javax.swing.JMenuItem MenuItemHorarioClases;
    private javax.swing.JMenuItem MenuItemInformacionInstitucional;
    private javax.swing.JMenuItem MenuItemInscripcionEstudiantil;
    private javax.swing.JMenuItem MenuItemMallaCurricular;
    private javax.swing.JMenuItem MenuItemMatriculacion;
    private javax.swing.JMenuItem MenuItemNotasParcial;
    private javax.swing.JMenuItem MenuItemNotasQuimestre;
    private javax.swing.JMenuItem MenuItemPeriodoAcademico;
    private javax.swing.JMenuItem MenuItemPeriodoLectivo;
    private javax.swing.JMenuItem MenuItemPersonalAdministrativo;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator10;
    private javax.swing.JPopupMenu.Separator jSeparator11;
    private javax.swing.JSeparator jSeparator12;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JPopupMenu.Separator jSeparator4;
    private javax.swing.JPopupMenu.Separator jSeparator5;
    private javax.swing.JPopupMenu.Separator jSeparator6;
    private javax.swing.JPopupMenu.Separator jSeparator7;
    private javax.swing.JPopupMenu.Separator jSeparator8;
    private javax.swing.JPopupMenu.Separator jSeparator9;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLayeredPane lypnlFondo;
    private javax.swing.JLayeredPane lypnlMenu;
    private javax.swing.JMenu menuControlCalificaciones;
    private javax.swing.JMenu menuGestionAdminitrativa;
    private javax.swing.JMenu menuGestionAdminitrativa1;
    private javax.swing.JMenu menuGestionAdminitrativa2;
    private javax.swing.JMenu menuGestionAdminitrativa3;
    private javax.swing.JPanel pnlFondo;
    // End of variables declaration//GEN-END:variables
}
