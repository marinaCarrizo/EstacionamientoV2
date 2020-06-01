/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista.abms;

import Expertos.Experto;
import Expertos.ExpertoFactory;
import Expertos.ExpertoPerfil;
import Expertos.ExpertoPersona;
import Expertos.ExpertoTipoVehiculo;
import Expertos.ExpertoTarifa;
import Modelo.Perfil;
import Modelo.Usuario;
import Modelo.Persona;
import Modelo.Tipovehiculo;
import Modelo.Tarifa;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import utils.FunctionsTools;
import utils.UsuarioSingleton;

;

/**
 *
 * @author MARINA
 */
public class TarifaABM extends javax.swing.JFrame {

    /**
     * Creates new form Puestos
     */
    private Experto experto;
    private String operation = "";
    private List<Object> turnos;
    private Tarifa tEdit;

    private List<Tipovehiculo> lista_tipoVehiculo;

    public TarifaABM() {

        initComponents();

        this.setLocationRelativeTo(this);

        ExpertoFactory expertoFactory = new ExpertoFactory();
        experto = expertoFactory.getExperto("Turno");

        cargarTabla(null);
        cargarPerfiles();
        alterView();
    }

    private void cargarPerfiles() {
        lista_tipoVehiculo = new ArrayList<Tipovehiculo>();
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        List lista = new ExpertoTipoVehiculo().search(null);
        for (Object o : lista) {
            Tipovehiculo p = (Tipovehiculo) o;
            lista_tipoVehiculo.add(p);
            model.addElement((p.getTipoVehiculo()));
        }
        this.cbx_tipovehi.setModel(model);
    }

    private void cargarTabla(String param) {

        Vector<String> tableHeaders = new Vector<String>();
        tableHeaders.add("Código");
        tableHeaders.add("Detalle");
        tableHeaders.add("Tipo");
        tableHeaders.add("Precio");
        this.turnos = experto.search(param);
        tbl_turnos.setModel(new DefaultTableModel(this.displayResult(this.turnos), tableHeaders) {
            boolean[] canEdit = new boolean[]{false, false, false, false};

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
    }

    private Vector displayResult(List resultList) {
        Vector tableData = new Vector();

        for (Object o : resultList) {
            Tarifa turno = (Tarifa) o;
            Vector<Object> oneRow = new Vector<Object>();
            oneRow.add(turno.getIdTarifa());
            oneRow.add(turno.getNombreTarifa());
            oneRow.add(turno.getTipovehiculo().getTipoVehiculo());
            oneRow.add("$" + String.format("%.0f", turno.getPrecioHora()));
            tableData.add(oneRow);
        }
        return tableData;
    }

    private void alterView() {
        switch (this.operation) {
            case "add":
            case "edit":
                btn_save.setEnabled(true);
                btn_cancel.setEnabled(true);
                txt_detalle.setEnabled(true);
                txt_inicio.setEnabled(true);
                txt_fin.setEnabled(true);
                cbx_tipovehi.setEnabled(true);
                txt_precio.setEnabled(true);

                btn_add.setEnabled(false);
                btn_edit.setEnabled(false);
                btn_delete.setEnabled(false);
                txt_search.setEnabled(false);
                btn_search.setEnabled(false);
                tbl_turnos.setEnabled(false);
                break;
            case "save":
            case "cancel":
            case "Limpiar":
            default:
                btn_save.setEnabled(false);
                btn_cancel.setEnabled(false);
                txt_detalle.setEnabled(false);
                txt_inicio.setEnabled(false);
                txt_fin.setEnabled(false);
                cbx_tipovehi.setEnabled(false);
                txt_precio.setEnabled(false);

                btn_add.setEnabled(true);
                btn_edit.setEnabled(true);
                btn_delete.setEnabled(true);
                txt_search.setEnabled(true);
                btn_search.setEnabled(true);
                tbl_turnos.setEnabled(true);
                break;
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_turnos = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txt_search = new javax.swing.JTextField();
        btn_search = new javax.swing.JButton();
        btn_add = new javax.swing.JButton();
        btn_edit = new javax.swing.JButton();
        btn_delete = new javax.swing.JButton();
        btn_Limpar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        btn_save = new javax.swing.JButton();
        btn_cancel = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cbx_tipovehi = new javax.swing.JComboBox<>();
        txt_detalle = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txt_precio = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txt_inicio = new javax.swing.JFormattedTextField();
        jLabel3 = new javax.swing.JLabel();
        txt_fin = new javax.swing.JFormattedTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tarifas", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Calibri", 1, 24))); // NOI18N

        tbl_turnos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbl_turnos.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tbl_turnos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tbl_turnosMouseReleased(evt);
            }
        });
        tbl_turnos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tbl_turnosKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_turnos);

        jLabel1.setText("Busqueda:");

        btn_search.setText("Buscar");
        btn_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_searchActionPerformed(evt);
            }
        });

        btn_add.setText("Agregar");
        btn_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addActionPerformed(evt);
            }
        });

        btn_edit.setText("Editar");
        btn_edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_editActionPerformed(evt);
            }
        });

        btn_delete.setText("Eliminar");
        btn_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_deleteActionPerformed(evt);
            }
        });

        btn_Limpar.setText("Limpiar");
        btn_Limpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_LimparActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 481, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(28, 28, 28)
                        .addComponent(txt_search)
                        .addGap(31, 31, 31)
                        .addComponent(btn_search)
                        .addGap(19, 19, 19)
                        .addComponent(btn_Limpar))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btn_add)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_edit)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_delete)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txt_search, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_search)
                    .addComponent(btn_Limpar))
                .addGap(15, 15, 15)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_edit)
                    .addComponent(btn_add)
                    .addComponent(btn_delete))
                .addGap(0, 11, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Detalle"));

        btn_save.setText("Guardar");
        btn_save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_saveActionPerformed(evt);
            }
        });

        btn_cancel.setText("Cancelar");
        btn_cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cancelActionPerformed(evt);
            }
        });

        jLabel4.setText("Tipo de Vehiculo:");

        jLabel5.setText("Nombre Tarifa");

        cbx_tipovehi.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel8.setText("Precio ($):");

        txt_precio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_precioActionPerformed(evt);
            }
        });
        txt_precio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_precioKeyReleased(evt);
            }
        });

        jLabel2.setText("Inicio:");

        txt_inicio.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(java.text.DateFormat.getTimeInstance(java.text.DateFormat.MEDIUM))));
        txt_inicio.setToolTipText("");

        jLabel3.setText("Fin:");

        txt_fin.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(java.text.DateFormat.getTimeInstance(java.text.DateFormat.MEDIUM))));

        jLabel6.setText("00:00:00 hs");

        jLabel7.setText("$0.0");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel8)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txt_precio, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(62, 62, 62)
                        .addComponent(jLabel7))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_inicio)
                            .addComponent(txt_fin, javax.swing.GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE))
                        .addGap(54, 54, 54)
                        .addComponent(jLabel6))
                    .addComponent(txt_detalle, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbx_tipovehi, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btn_save, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_cancel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(cbx_tipovehi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txt_detalle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txt_inicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3)
                                    .addComponent(txt_fin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(jLabel6)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(13, 13, 13)
                                .addComponent(jLabel8))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txt_precio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7)))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btn_save)
                        .addGap(10, 10, 10)
                        .addComponent(btn_cancel)))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_searchActionPerformed
        cargarTabla(txt_search.getText().trim());
        txt_search.setEnabled(false);
    }//GEN-LAST:event_btn_searchActionPerformed

    private void btn_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addActionPerformed

        this.operation = "add";
        alterView();
        clearDetail();

    }//GEN-LAST:event_btn_addActionPerformed

    private void btn_editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editActionPerformed
        if (tbl_turnos.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione un elemento de la tabla", "ERROR!", JOptionPane.ERROR_MESSAGE);

        } else {
            this.operation = "edit";
            alterView();
        }
    }//GEN-LAST:event_btn_editActionPerformed

    private void btn_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deleteActionPerformed
        if (tbl_turnos.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione un elemento de la tabla", "ERROR!", JOptionPane.ERROR_MESSAGE);

        } else {
            tEdit = (Tarifa) turnos.get(tbl_turnos.getSelectedRow());
            loadDetail();// TODO add your handling code here:
            if (experto.delete(tEdit) == 1) {
                JOptionPane.showMessageDialog(this, "Datos borrados correctamente");
            }else {
                JOptionPane.showMessageDialog(this, "No puede eliminar este ítem ya que esta siendo utilizado en el historial de ingresos","ERROR!", JOptionPane.ERROR_MESSAGE);
            }
            clearDetail();
            cargarTabla(null);
        }
    }//GEN-LAST:event_btn_deleteActionPerformed

    private void btn_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_saveActionPerformed

        if (validForm()) {
            if (this.operation == Experto.ADD) {
                try {
                    Tarifa newTurno = new Tarifa();
                    newTurno.setNombreTarifa(txt_detalle.getText());
                    newTurno.setPrecioHora(Float.parseFloat(txt_precio.getText()));
                    newTurno.setInicio(Time.valueOf(txt_inicio.getText()));
                    newTurno.setFin(Time.valueOf(txt_fin.getText()));
                    newTurno.setTipovehiculo(lista_tipoVehiculo.get(cbx_tipovehi.getSelectedIndex()));
                    saveData(newTurno);
                } catch (IllegalArgumentException e) {
                    JOptionPane.showMessageDialog(this, "Para ingresar hora de inicio y fin ingrese numeros con el formato 00:00:00.\n "
                            + "Para ingresar precio ingrese numeros con el formato 0.0 ", "Error!", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                try {
                    tEdit.setNombreTarifa(txt_detalle.getText().trim());
                    tEdit.setPrecioHora(Float.parseFloat(txt_precio.getText()));
                    tEdit.setInicio(Time.valueOf(txt_inicio.getText()));
                    tEdit.setFin(Time.valueOf(txt_fin.getText()));
                    tEdit.setTipovehiculo(lista_tipoVehiculo.get(cbx_tipovehi.getSelectedIndex()));
                    saveData(tEdit);
                } catch (IllegalArgumentException e) {
                    JOptionPane.showMessageDialog(this, "Para ingresar hora de inicio y fin ingrese numeros con el formato 00:00:00.\n "
                            + "Para ingresar precio ingrese numeros con el formato 0.0 ", "Error!", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
        clearDetail();
        cargarTabla(null);
        this.operation = "save";
        alterView();
    }//GEN-LAST:event_btn_saveActionPerformed

    private void btn_cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelActionPerformed

        clearDetail();

        this.operation = "cancel";
        alterView();
    }//GEN-LAST:event_btn_cancelActionPerformed

    private void tbl_turnosKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbl_turnosKeyReleased
        tEdit = (Tarifa) turnos.get(tbl_turnos.getSelectedRow());
        loadDetail();

    }//GEN-LAST:event_tbl_turnosKeyReleased

    private void tbl_turnosMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_turnosMouseReleased
        tEdit = (Tarifa) turnos.get(tbl_turnos.getSelectedRow());
        loadDetail();// TODO add your handling code here:
    }//GEN-LAST:event_tbl_turnosMouseReleased

    private void txt_precioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_precioKeyReleased
        char car = evt.getKeyChar();
        if ((car < '0' || car > '9') && (car < ',' || car > '.')) {
            evt.consume();
        }
    }//GEN-LAST:event_txt_precioKeyReleased

    private void btn_LimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_LimparActionPerformed
        txt_search.setEnabled(true);
        txt_search.setText("");
        clearDetail();
        cargarTabla(null);
        this.operation = "Limpar";
        alterView();        // TODO add your handling code here:
    }//GEN-LAST:event_btn_LimparActionPerformed

    private void txt_precioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_precioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_precioActionPerformed

    private void loadDetail() {
        txt_detalle.setText(tEdit.getNombreTarifa());
        txt_precio.setText("" + tEdit.getPrecioHora());
        txt_inicio.setText(FunctionsTools.formatearHora(tEdit.getInicio().getTime()));
        txt_fin.setText(FunctionsTools.formatearHora(tEdit.getFin().getTime()));
        cbx_tipovehi.setSelectedItem(tEdit.getTipovehiculo().getTipoVehiculo());
    }

    private void clearDetail() {
        txt_precio.setText("");
        txt_detalle.setText("");
        txt_inicio.setText("00:00");
        txt_fin.setText("00:00");
        cbx_tipovehi.setSelectedIndex(0);
    }

    private boolean validForm() {
        if (!txt_detalle.getText().trim().equals("") && !txt_precio.getText().trim().equals("")
                && !txt_inicio.getText().trim().equals("") && !txt_fin.getText().trim().equals("")) {
            return true;
        } else {
            JOptionPane.showMessageDialog(this, "Los campos no deben estar vacios", "Error!", JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }

    private void saveData(Tarifa tv) {
        if (experto.persist(tv, operation) == 1) {
            JOptionPane.showMessageDialog(this, "Datos guardados correctamente");
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TarifaABM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TarifaABM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TarifaABM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TarifaABM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

//        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TarifaABM().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Limpar;
    private javax.swing.JButton btn_add;
    private javax.swing.JButton btn_cancel;
    private javax.swing.JButton btn_delete;
    private javax.swing.JButton btn_edit;
    private javax.swing.JButton btn_save;
    private javax.swing.JButton btn_search;
    private javax.swing.JComboBox<String> cbx_tipovehi;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbl_turnos;
    private javax.swing.JTextField txt_detalle;
    private javax.swing.JFormattedTextField txt_fin;
    private javax.swing.JFormattedTextField txt_inicio;
    private javax.swing.JTextField txt_precio;
    private javax.swing.JTextField txt_search;
    // End of variables declaration//GEN-END:variables
}