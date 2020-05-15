/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista.cruds;

import Expertos.Experto;
import Expertos.ExpertoFactory;
import Expertos.ExpertoPerfil;
import Expertos.ExpertoPersona;
import Expertos.ExpertoUsuario;
import Modelo.Perfil;
import Modelo.Usuario;
import Modelo.Persona;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.ListModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

;

/**
 *
 * @author MARINA
 */
public class UsuariosABM extends javax.swing.JFrame {

    /**
     * Creates new form Puestos
     */
    private Experto experto;
    private String operation = "";
    private List<Object> usuarios;
    private Usuario uEdit;

    private List<Object> personas;
    private Persona person_select;
    private List<Perfil> perfiles;

    public UsuariosABM() {

        initComponents();

        this.setLocationRelativeTo(this);

        ExpertoFactory expertoFactory = new ExpertoFactory();
        experto = expertoFactory.getExperto("Usuario");

        cargarTabla(null);
        cargarPerfiles();
        cargarPersonas(null);
        alterView();
    }

    private void cargarPerfiles() {
        perfiles = new ArrayList<Perfil>();
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        List lista = new ExpertoPerfil().search(null);
        for (Object o : lista) {
            Perfil p = (Perfil) o;
            perfiles.add(p);
            model.addElement((p.getNombrePerfil()));
        }
        this.cbx_perfil.setModel(model);
    }

    private void cargarPersonas(String param) {
        Vector<String> titlesTable = new Vector<String>();
        titlesTable.add("DNI");
        titlesTable.add("Nombre");
        this.personas = new ExpertoPersona().search(param);
        Vector dataTable = new Vector();
        for (Object o : this.personas) {
            Persona p = (Persona) o;
            Vector<Object> row = new Vector<Object>();
            row.add(String.format("%.0f", p.getDniPersona()));
            row.add(p.getNombrePersona());
            dataTable.add(row);
        }
        DefaultTableModel model = new DefaultTableModel(dataTable, titlesTable) {
            boolean[] canEdit = new boolean[]{false, false};

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        };

        tbl_person.setModel(model);

    }

    private void cargarTabla(String param) {

        Vector<String> tableHeaders = new Vector<String>();
        tableHeaders.add("Usuario");
        tableHeaders.add("Persona");
        tableHeaders.add("Perfil");
        this.usuarios = experto.search(param);
        tbl_users.setModel(new DefaultTableModel(this.displayResult(this.usuarios), tableHeaders) {
            boolean[] canEdit = new boolean[]{false, false, false};

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
    }

    private Vector displayResult(List resultList) {
        Vector tableData = new Vector();

        for (Object o : resultList) {
            Usuario usuario = (Usuario) o;
            Vector<Object> oneRow = new Vector<Object>();
            oneRow.add(usuario.getNombreUsuario());
            oneRow.add(usuario.getPersona().getNombrePersona());
            oneRow.add(usuario.getPerfil().getNombrePerfil());
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
                txt_username.setEnabled(true);
                cbx_perfil.setEnabled(true);
                btn_search_person.setEnabled(true);

                btn_add.setEnabled(false);
                btn_edit.setEnabled(false);
                btn_delete.setEnabled(false);
                txt_search.setEnabled(false);
                btn_search.setEnabled(false);
                tbl_users.setEnabled(false);
                break;
            case "save":
            case "cancel":
            default:
                btn_save.setEnabled(false);
                btn_cancel.setEnabled(false);
                txt_username.setEnabled(false);
                cbx_perfil.setEnabled(false);
                btn_search_person.setEnabled(false);

                btn_add.setEnabled(true);
                btn_edit.setEnabled(true);
                btn_delete.setEnabled(true);
                txt_search.setEnabled(true);
                btn_search.setEnabled(true);
                tbl_users.setEnabled(true);
                break;
        }

        if (this.operation.equals("add")) {
            btn_search_person.setEnabled(true);
        } else {
            btn_search_person.setEnabled(false);
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

        dlg_search_person = new javax.swing.JDialog();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_person = new javax.swing.JTable();
        txt_dlg_search_person = new javax.swing.JTextField();
        btn_dlg_search_person = new javax.swing.JButton();
        btn_select_person = new javax.swing.JButton();
        dlg_change_password = new javax.swing.JDialog();
        jPanel4 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        psw_new_pass = new javax.swing.JPasswordField();
        jLabel7 = new javax.swing.JLabel();
        psw_repeat_pass = new javax.swing.JPasswordField();
        btn_cancel_pass = new javax.swing.JButton();
        btn_save_pass = new javax.swing.JButton();
        lbl_message_psw = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_users = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txt_search = new javax.swing.JTextField();
        btn_search = new javax.swing.JButton();
        btn_add = new javax.swing.JButton();
        btn_edit = new javax.swing.JButton();
        btn_delete = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        btn_save = new javax.swing.JButton();
        btn_cancel = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txt_name_person = new javax.swing.JTextField();
        cbx_perfil = new javax.swing.JComboBox<>();
        btn_search_person = new javax.swing.JButton();
        txt_username = new javax.swing.JTextField();

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Panel de busqueda"));

        tbl_person.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tbl_person);

        btn_dlg_search_person.setText("Buscar");
        btn_dlg_search_person.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_dlg_search_personActionPerformed(evt);
            }
        });

        btn_select_person.setText("Aceptar");
        btn_select_person.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_select_personActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(txt_dlg_search_person, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_dlg_search_person)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_select_person)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_dlg_search_person, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_dlg_search_person))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_select_person)
                .addGap(14, 14, 14))
        );

        javax.swing.GroupLayout dlg_search_personLayout = new javax.swing.GroupLayout(dlg_search_person.getContentPane());
        dlg_search_person.getContentPane().setLayout(dlg_search_personLayout);
        dlg_search_personLayout.setHorizontalGroup(
            dlg_search_personLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dlg_search_personLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        dlg_search_personLayout.setVerticalGroup(
            dlg_search_personLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dlg_search_personLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Cambiar Clave"));

        jLabel6.setText("Nueva clave:");

        psw_new_pass.setText("jPasswordField2");

        jLabel7.setText("Confirmar:");

        psw_repeat_pass.setText("jPasswordField3");
        psw_repeat_pass.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                psw_repeat_passKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                psw_repeat_passKeyTyped(evt);
            }
        });

        btn_cancel_pass.setText("Cancelar");
        btn_cancel_pass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cancel_passActionPerformed(evt);
            }
        });

        btn_save_pass.setText("Guardar");
        btn_save_pass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_save_passActionPerformed(evt);
            }
        });

        lbl_message_psw.setForeground(new java.awt.Color(255, 51, 51));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_message_psw, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(psw_repeat_pass, javax.swing.GroupLayout.DEFAULT_SIZE, 281, Short.MAX_VALUE)
                            .addComponent(psw_new_pass)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btn_save_pass)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_cancel_pass)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(psw_new_pass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(psw_repeat_pass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbl_message_psw)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_cancel_pass)
                    .addComponent(btn_save_pass))
                .addContainerGap())
        );

        javax.swing.GroupLayout dlg_change_passwordLayout = new javax.swing.GroupLayout(dlg_change_password.getContentPane());
        dlg_change_password.getContentPane().setLayout(dlg_change_passwordLayout);
        dlg_change_passwordLayout.setHorizontalGroup(
            dlg_change_passwordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dlg_change_passwordLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        dlg_change_passwordLayout.setVerticalGroup(
            dlg_change_passwordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dlg_change_passwordLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Usuarios", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Calibri", 1, 24))); // NOI18N

        tbl_users.setModel(new javax.swing.table.DefaultTableModel(
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
        tbl_users.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tbl_users.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tbl_usersMouseReleased(evt);
            }
        });
        tbl_users.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tbl_usersKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_users);

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

        jButton2.setText("Cambiar Clave");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

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
                        .addGap(133, 133, 133)
                        .addComponent(txt_search)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_search))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btn_add)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_edit)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_delete)
                        .addGap(18, 18, 18)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton2)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txt_search, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_search))
                .addGap(15, 15, 15)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btn_edit)
                        .addComponent(btn_add)
                        .addComponent(btn_delete)
                        .addComponent(jButton2)))
                .addGap(0, 11, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Detalle"));

        jLabel2.setText("Persona:");

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

        jLabel4.setText("Perfil:");

        jLabel5.setText("Usaurio:");

        txt_name_person.setEditable(false);

        cbx_perfil.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btn_search_person.setText("Buscar");
        btn_search_person.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_search_personActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(1, 1, 1)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(txt_name_person, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_search_person))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(txt_username))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(cbx_perfil, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
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
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_save)
                    .addComponent(jLabel2)
                    .addComponent(txt_name_person, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_search_person))
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cbx_perfil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_cancel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txt_username, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(32, Short.MAX_VALUE))
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
    }//GEN-LAST:event_btn_searchActionPerformed

    private void btn_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addActionPerformed
        this.operation = "add";
        alterView();
        clearDetail();
    }//GEN-LAST:event_btn_addActionPerformed

    private void btn_editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editActionPerformed
        this.operation = "edit";
        alterView();
    }//GEN-LAST:event_btn_editActionPerformed

    private void btn_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deleteActionPerformed
        uEdit = (Usuario) usuarios.get(tbl_users.getSelectedRow());
        loadDetail();// TODO add your handling code here:
        if (experto.delete(uEdit) == 1) {
            JOptionPane.showMessageDialog(this, "Datos borrados correctamente");
        }
        cargarTabla(null);
    }//GEN-LAST:event_btn_deleteActionPerformed

    private void btn_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_saveActionPerformed

        if (validForm()) {
            if (this.operation == "add") {
                Usuario newU = new Usuario();
                newU.setIdPersona(person_select.getIdPersona());
                newU.setPersona(person_select);
                newU.setNombreUsuario(txt_username.getText());
                newU.setContrasenia("");
                newU.setPerfil(perfiles.get(cbx_perfil.getSelectedIndex()));
                saveData(newU);
            } else {
                uEdit.setNombreUsuario(txt_username.getText().trim());
                uEdit.setPerfil(perfiles.get(cbx_perfil.getSelectedIndex()));
                saveData(uEdit);
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

    private void tbl_usersKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbl_usersKeyReleased
        uEdit = (Usuario) usuarios.get(tbl_users.getSelectedRow());
        loadDetail();

    }//GEN-LAST:event_tbl_usersKeyReleased

    private void tbl_usersMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_usersMouseReleased
        if (tbl_users.getSelectedRow() > -1) {
            uEdit = (Usuario) usuarios.get(tbl_users.getSelectedRow());
            loadDetail();// TODO add your handling code here:
        }
    }//GEN-LAST:event_tbl_usersMouseReleased

    private void btn_dlg_search_personActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_dlg_search_personActionPerformed
        cargarPersonas(txt_dlg_search_person.getText().trim());
    }//GEN-LAST:event_btn_dlg_search_personActionPerformed

    private void btn_select_personActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_select_personActionPerformed
        person_select = (Persona) personas.get(tbl_person.getSelectedRow());// TODO add your handling code here:
        txt_name_person.setText(person_select.getNombrePersona());
        dlg_search_person.dispose();
    }//GEN-LAST:event_btn_select_personActionPerformed

    private void btn_search_personActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_search_personActionPerformed
        cargarPersonas(null);
        dlg_search_person.setSize(450, 350);
        dlg_search_person.setVisible(true);
        dlg_search_person.setLocationRelativeTo(this);
        dlg_search_person.setModal(true);
    }//GEN-LAST:event_btn_search_personActionPerformed

    private void psw_repeat_passKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_psw_repeat_passKeyReleased

    }//GEN-LAST:event_psw_repeat_passKeyReleased

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (tbl_users.getSelectedRow() > -1) {
            uEdit = (Usuario) usuarios.get(tbl_users.getSelectedRow());
            this.operation = "edit";

            dlg_change_password.setSize(450, 275);
            dlg_change_password.setVisible(true);
            dlg_change_password.setLocationRelativeTo(this);
            dlg_change_password.setModal(true);
            clearPasswords();
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btn_save_passActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_save_passActionPerformed
        System.out.println("new pass: " + psw_new_pass.getText());
        System.out.println("repeat pass: " + psw_repeat_pass.getText());
        if (psw_repeat_pass.getText().equals(psw_new_pass.getText()) && !psw_new_pass.getText().trim().equals("")) {
            uEdit.setContrasenia(psw_new_pass.getText());
            dlg_change_password.dispose();
            saveData(uEdit);
        } else {
            JOptionPane.showMessageDialog(this, "Las contraseñas no coinciden", "ERROR!", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btn_save_passActionPerformed

    private void psw_repeat_passKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_psw_repeat_passKeyTyped

    }//GEN-LAST:event_psw_repeat_passKeyTyped

    private void btn_cancel_passActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancel_passActionPerformed
        dlg_change_password.dispose();// TODO add your handling code here:
    }//GEN-LAST:event_btn_cancel_passActionPerformed

    private void loadDetail() {
        person_select = uEdit.getPersona();
        txt_name_person.setText(uEdit.getPersona().getNombrePersona());
        txt_username.setText(uEdit.getNombreUsuario());
        cbx_perfil.setSelectedItem(uEdit.getPerfil().getNombrePerfil());
    }

    private void clearDetail() {
        person_select = null;
        txt_name_person.setText("");
        txt_username.setText("");
        cbx_perfil.setSelectedIndex(0);
        txt_name_person.setText("");
    }

    private void clearPasswords() {
        psw_new_pass.setText("");
        psw_repeat_pass.setText("");
    }

    private boolean validForm() {
        if (!txt_username.getText().trim().equals("") && !txt_name_person.getText().trim().equals("")) {
            return true;
        } else {
            JOptionPane.showMessageDialog(this, "El nombre no debe ser vacio", "Error!", JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }

    private void saveData(Usuario u) {
        if (experto.persist(u, operation) == 1) {
            JOptionPane.showMessageDialog(this, "Datos guardados correctamente");
        }
    }

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Windows".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(UsuariosABM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(UsuariosABM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(UsuariosABM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(UsuariosABM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new UsuariosABM().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_add;
    private javax.swing.JButton btn_cancel;
    private javax.swing.JButton btn_cancel_pass;
    private javax.swing.JButton btn_delete;
    private javax.swing.JButton btn_dlg_search_person;
    private javax.swing.JButton btn_edit;
    private javax.swing.JButton btn_save;
    private javax.swing.JButton btn_save_pass;
    private javax.swing.JButton btn_search;
    private javax.swing.JButton btn_search_person;
    private javax.swing.JButton btn_select_person;
    private javax.swing.JComboBox<String> cbx_perfil;
    private javax.swing.JDialog dlg_change_password;
    private javax.swing.JDialog dlg_search_person;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lbl_message_psw;
    private javax.swing.JPasswordField psw_new_pass;
    private javax.swing.JPasswordField psw_repeat_pass;
    private javax.swing.JTable tbl_person;
    private javax.swing.JTable tbl_users;
    private javax.swing.JTextField txt_dlg_search_person;
    private javax.swing.JTextField txt_name_person;
    private javax.swing.JTextField txt_search;
    private javax.swing.JTextField txt_username;
    // End of variables declaration//GEN-END:variables
}
