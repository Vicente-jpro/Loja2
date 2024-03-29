/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fornecedor;

import Reportes.GerarRelatorio;
import Words.Words;
import java.awt.Color;
import java.awt.Cursor;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author vicente
 */
public class FornecedorForm extends javax.swing.JFrame {

    private Fornecedor fornecedor;
    private FornecedorConnectiondb fornecedorConnectiondb;
    private Fornecedordb fornecedordb;
    private Words transform;
    private boolean pressionou;
    private int limparCampos = 1;

    /**
     * Creates new form FornecedorForm
     */
    public FornecedorForm() {
        super("Cadastro de Fornecedors");
        initComponents();

        this.setLocationRelativeTo(null);
        getRootPane().setDefaultButton(salvarJB);
        transform = Words.getInstance();

        this.pressionou = false;

        DefaultTableModel modelo = (DefaultTableModel) fornecedortb.getModel();
        fornecedortb.setRowSorter(new TableRowSorter(modelo));

        fornecedorTableView();

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
        jPanel2 = new javax.swing.JPanel();
        salvarJB = new javax.swing.JButton();
        eliminarJB = new javax.swing.JButton();
        actualizarJB = new javax.swing.JButton();
        nomeFornecedorJT = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        enderecoJTA = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        fornecedortb = new javax.swing.JTable();
        emailJT = new javax.swing.JTextField();
        whatsAppJT = new javax.swing.JTextField();
        telemovel2JT = new javax.swing.JTextField();
        telemovel1JT = new javax.swing.JTextField();
        imprimirJB = new javax.swing.JButton();
        filtrarNomeFornecedorJT = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        salvarJB.setBackground(new java.awt.Color(102, 255, 204));
        salvarJB.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        salvarJB.setForeground(java.awt.Color.black);
        salvarJB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/save-32.png"))); // NOI18N
        salvarJB.setText("Salvar");
        salvarJB.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        salvarJB.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        salvarJB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salvarJBActionPerformed(evt);
            }
        });

        eliminarJB.setBackground(new java.awt.Color(255, 51, 51));
        eliminarJB.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        eliminarJB.setForeground(java.awt.Color.black);
        eliminarJB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Delete-black-32.png"))); // NOI18N
        eliminarJB.setText("Eliminar");
        eliminarJB.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        eliminarJB.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        eliminarJB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarJBActionPerformed(evt);
            }
        });

        actualizarJB.setBackground(new java.awt.Color(255, 153, 51));
        actualizarJB.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        actualizarJB.setForeground(java.awt.Color.black);
        actualizarJB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/update-button-32.png"))); // NOI18N
        actualizarJB.setText("Actualizar");
        actualizarJB.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        actualizarJB.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        actualizarJB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actualizarJBActionPerformed(evt);
            }
        });

        nomeFornecedorJT.setFont(new java.awt.Font("DejaVu Serif", 0, 14)); // NOI18N
        nomeFornecedorJT.setText("Nome do Fornecedor");
        nomeFornecedorJT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                nomeFornecedorJTMouseClicked(evt);
            }
        });
        nomeFornecedorJT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nomeFornecedorJTActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("DejaVu Serif", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Cadastro de Fornecedores");

        enderecoJTA.setColumns(20);
        enderecoJTA.setFont(new java.awt.Font("DejaVu Serif", 0, 13)); // NOI18N
        enderecoJTA.setRows(5);
        enderecoJTA.setText("Endereço. Ex: Localização do Fornecedor");
        enderecoJTA.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                enderecoJTAMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(enderecoJTA);

        fornecedortb.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Id", "Nome do Fornecedor", "Endereço", "Telemovel1", "Telemovel2", "Email", "WhatsApp"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        fornecedortb.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                fornecedortbMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                fornecedortbMouseReleased(evt);
            }
        });
        fornecedortb.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                fornecedortbKeyReleased(evt);
            }
        });
        jScrollPane2.setViewportView(fornecedortb);
        if (fornecedortb.getColumnModel().getColumnCount() > 0) {
            fornecedortb.getColumnModel().getColumn(0).setResizable(false);
            fornecedortb.getColumnModel().getColumn(1).setResizable(false);
            fornecedortb.getColumnModel().getColumn(2).setResizable(false);
            fornecedortb.getColumnModel().getColumn(3).setResizable(false);
            fornecedortb.getColumnModel().getColumn(5).setResizable(false);
            fornecedortb.getColumnModel().getColumn(6).setResizable(false);
        }

        emailJT.setFont(new java.awt.Font("DejaVu Serif", 0, 14)); // NOI18N
        emailJT.setText("Email");
        emailJT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                emailJTMouseClicked(evt);
            }
        });
        emailJT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailJTActionPerformed(evt);
            }
        });

        whatsAppJT.setFont(new java.awt.Font("DejaVu Serif", 0, 14)); // NOI18N
        whatsAppJT.setText("WhatsApp");
        whatsAppJT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                whatsAppJTMouseClicked(evt);
            }
        });
        whatsAppJT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                whatsAppJTActionPerformed(evt);
            }
        });

        telemovel2JT.setFont(new java.awt.Font("DejaVu Serif", 0, 14)); // NOI18N
        telemovel2JT.setText("Telemóvel 2");
        telemovel2JT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                telemovel2JTMouseClicked(evt);
            }
        });
        telemovel2JT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                telemovel2JTActionPerformed(evt);
            }
        });

        telemovel1JT.setFont(new java.awt.Font("DejaVu Serif", 0, 14)); // NOI18N
        telemovel1JT.setText("Telemóvel 1");
        telemovel1JT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                telemovel1JTMouseClicked(evt);
            }
        });
        telemovel1JT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                telemovel1JTActionPerformed(evt);
            }
        });

        imprimirJB.setBackground(new java.awt.Color(102, 255, 204));
        imprimirJB.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        imprimirJB.setForeground(java.awt.Color.black);
        imprimirJB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/pdf-32.png"))); // NOI18N
        imprimirJB.setText("imprimir");
        imprimirJB.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        imprimirJB.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        imprimirJB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imprimirJBActionPerformed(evt);
            }
        });

        filtrarNomeFornecedorJT.setFont(new java.awt.Font("DejaVu Serif", 0, 14)); // NOI18N
        filtrarNomeFornecedorJT.setText("Filtrar Nome do Fornecedor");
        filtrarNomeFornecedorJT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                filtrarNomeFornecedorJTMouseClicked(evt);
            }
        });
        filtrarNomeFornecedorJT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filtrarNomeFornecedorJTActionPerformed(evt);
            }
        });
        filtrarNomeFornecedorJT.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                filtrarNomeFornecedorJTKeyTyped(evt);
            }
        });

        jButton1.setText("Imprimir");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 509, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(516, 516, 516))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(nomeFornecedorJT, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                .addComponent(emailJT, javax.swing.GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)
                                .addComponent(whatsAppJT, javax.swing.GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)
                                .addComponent(telemovel2JT, javax.swing.GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)
                                .addComponent(telemovel1JT, javax.swing.GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE))
                            .addComponent(salvarJB, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(actualizarJB, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(eliminarJB, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(imprimirJB, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(filtrarNomeFornecedorJT, javax.swing.GroupLayout.PREFERRED_SIZE, 902, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(nomeFornecedorJT, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(filtrarNomeFornecedorJT, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(telemovel1JT, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(telemovel2JT, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(emailJT, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(whatsAppJT, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(salvarJB, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(actualizarJB, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(eliminarJB, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(imprimirJB)
                        .addGap(0, 21, Short.MAX_VALUE))
                    .addComponent(jScrollPane2))
                .addGap(17, 17, 17))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void eliminarJBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarJBActionPerformed

        // Se o fornecedor da tabela não for selecionado.
        if (!fornecedortb()) {

            JOptionPane.showMessageDialog(null, "Seleciona um elemento para modificar",
                    "TABELA DE FORNECEDOR", JOptionPane.ERROR_MESSAGE);

        } else {

            fornecedorConnectiondb = new FornecedorConnectiondb();

            String idClient = fornecedortb.getValueAt(fornecedortb.getSelectedRow(), 0).toString();
            int idFornecedor = Integer.parseInt(idClient);

            fornecedorConnectiondb.eliminar(idFornecedor);
            fornecedorTableView();

        }

        // TODO add your handling code here:
    }//GEN-LAST:event_eliminarJBActionPerformed

    private void nomeFornecedorJTMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nomeFornecedorJTMouseClicked

        if (!pressionou) {
            nomeFornecedorJT.setText("");
            pressionou = true;
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_nomeFornecedorJTMouseClicked

    private void nomeFornecedorJTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nomeFornecedorJTActionPerformed

// TODO add your handling code here:
    }//GEN-LAST:event_nomeFornecedorJTActionPerformed

    private void salvarJBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salvarJBActionPerformed

        if (campoNomeMoradaVazioJT()) {

            JOptionPane.showMessageDialog(null, "Os campos de texto Nome do Fornecedor e Endereco não pode estar vazios",
                    "SALVAR FORNECEDOR", JOptionPane.ERROR_MESSAGE);

        } else {
            //nome_fornecedor, endereco, telemovel1, telemovel2, email, whats_app

            fornecedordb = new Fornecedordb();
            // pesquisar a nome de produto na lista    
            String nomeFornecedor = nomeFornecedorJT.getText().toUpperCase();

            String endereco = enderecoJTA.getText().toUpperCase();
            String telemovel1 = telemovel1JT.getText();
            String telemovel2 = telemovel2JT.getText();
            String email = emailJT.getText();
            String whatsApp = whatsAppJT.getText();


            fornecedor = new Fornecedor();
            
            fornecedor.setNomeFornecedor(nomeFornecedor);
            fornecedor.setEndereco(endereco);
            fornecedor.setTelemovel2(telemovel2);
            fornecedor.setTelemovel1(telemovel1);
            fornecedor.setEmail(email);
            fornecedor.setWhats_app(whatsApp);
            
            fornecedorConnectiondb = new FornecedorConnectiondb();

            fornecedorConnectiondb.salvar(fornecedor);

            fornecedorTableView();
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_salvarJBActionPerformed

    private void actualizarJBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actualizarJBActionPerformed

        // Se o fornecedor da tabela for selecionado.
        if (fornecedorSelecionado_tb()) {

            fornecedorConnectiondb = new FornecedorConnectiondb();

            String forneced = fornecedortb.getValueAt(fornecedortb.getSelectedRow(), 0).toString();
            int idFornecedor = Integer.parseInt(forneced);

            // pesquisar a nome de produto na lista    
            String nomeFornecedor = nomeFornecedorJT.getText().toUpperCase();

            String endereco = enderecoJTA.getText().toUpperCase();
            String telemovel1 = telemovel1JT.getText();
            String telemovel2 = telemovel2JT.getText();
            String email = emailJT.getText();
            String whatsApp = whatsAppJT.getText();

            fornecedor = new Fornecedor();
            
            fornecedor.setNomeFornecedor(nomeFornecedor);
            fornecedor.setEndereco(endereco);
            fornecedor.setTelemovel2(telemovel2);
            fornecedor.setTelemovel1(telemovel1);
            fornecedor.setEmail(email);
            fornecedor.setWhats_app(whatsApp);
            fornecedor.setIdFornecedor(idFornecedor);
            


            fornecedorConnectiondb.actualizar(fornecedor);
            fornecedorTableView();

        } else if (campoNomeMoradaVazioJT()) {

            JOptionPane.showMessageDialog(null, "Os campos de Texto não pode estar vazios",
                    "ACTUALIZAR FORNECEDOR ", JOptionPane.ERROR_MESSAGE);

        } else {

            JOptionPane.showMessageDialog(null, "Seleciona um elemento para modificar",
                    "TABELA DE FORNECEDOR", JOptionPane.ERROR_MESSAGE);

        }

        // TODO add your handling code here:
    }//GEN-LAST:event_actualizarJBActionPerformed

    private void enderecoJTAMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_enderecoJTAMouseClicked

        // Verifica se o usuário já clicou nos campos de texto
        if (!pressionou) {
            enderecoJTA.setText("");
            pressionou = true;
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_enderecoJTAMouseClicked

    private void fornecedortbMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fornecedortbMouseClicked

        fornecedortb();


    }//GEN-LAST:event_fornecedortbMouseClicked

    private void fornecedortbMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fornecedortbMouseReleased

        // TODO add your handling code here:
    }//GEN-LAST:event_fornecedortbMouseReleased

    private void fornecedortbKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fornecedortbKeyReleased

        fornecedortb();
        // TODO add your handling code here:
    }//GEN-LAST:event_fornecedortbKeyReleased

    private void emailJTMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_emailJTMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_emailJTMouseClicked

    private void emailJTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailJTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailJTActionPerformed

    private void whatsAppJTMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_whatsAppJTMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_whatsAppJTMouseClicked

    private void whatsAppJTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_whatsAppJTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_whatsAppJTActionPerformed

    private void telemovel2JTMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_telemovel2JTMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_telemovel2JTMouseClicked

    private void telemovel2JTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_telemovel2JTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_telemovel2JTActionPerformed

    private void telemovel1JTMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_telemovel1JTMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_telemovel1JTMouseClicked

    private void telemovel1JTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_telemovel1JTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_telemovel1JTActionPerformed

    private void imprimirJBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imprimirJBActionPerformed

        setCursor(Cursor.getPredefinedCursor( Cursor.WAIT_CURSOR ));
        imprimir();
        setCursor(Cursor.getPredefinedCursor( Cursor.DEFAULT_CURSOR ));
        
    }//GEN-LAST:event_imprimirJBActionPerformed

    private void filtrarNomeFornecedorJTMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_filtrarNomeFornecedorJTMouseClicked
       
        filtrarNomeFornecedorJT.setText( "" );
      
        
    }//GEN-LAST:event_filtrarNomeFornecedorJTMouseClicked

    private void filtrarNomeFornecedorJTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filtrarNomeFornecedorJTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_filtrarNomeFornecedorJTActionPerformed

    private void filtrarNomeFornecedorJTKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_filtrarNomeFornecedorJTKeyTyped


          filtrarNomeFornecedorJT.setBackground(Color.green);
        
          DefaultTableModel modelo = (DefaultTableModel) fornecedortb.getModel();

        String elemento = filtrarNomeFornecedorJT.getText().toUpperCase();

        TableRowSorter<DefaultTableModel> tabela = new TableRowSorter<DefaultTableModel>(modelo);

        fornecedortb.setRowSorter(tabela);
        tabela.setRowFilter(javax.swing.RowFilter.regexFilter(elemento));

        // TODO add your handling code here:
    }//GEN-LAST:event_filtrarNomeFornecedorJTKeyTyped

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(FornecedorForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FornecedorForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FornecedorForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FornecedorForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FornecedorForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton actualizarJB;
    private javax.swing.JButton eliminarJB;
    private javax.swing.JTextField emailJT;
    private javax.swing.JTextArea enderecoJTA;
    private javax.swing.JTextField filtrarNomeFornecedorJT;
    private javax.swing.JTable fornecedortb;
    private javax.swing.JButton imprimirJB;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField nomeFornecedorJT;
    private javax.swing.JButton salvarJB;
    private javax.swing.JTextField telemovel1JT;
    private javax.swing.JTextField telemovel2JT;
    private javax.swing.JTextField whatsAppJT;
    // End of variables declaration//GEN-END:variables

    private boolean campoNomeMoradaVazioJT() {

        return nomeFornecedorJT.getText().isEmpty()
                || "Nome do fornecedor".equals(nomeFornecedorJT.getText())
                || enderecoJTA.getText().isEmpty()
                || "Endereço. Ex: Localização do Fornecedor".equals(enderecoJTA.getText()); // true
    }

    private boolean fornecedortb() {

        boolean fornecedorSelecionado = false;

        try {

            if (fornecedortb.getSelectedRow() != -1 && !todosCamposVazios()) {

                String nomeFornecedor = fornecedortb.getValueAt(fornecedortb.getSelectedRow(), 1).toString();
                String endereco = fornecedortb.getValueAt(fornecedortb.getSelectedRow(), 2).toString();
                String telemovel1 = fornecedortb.getValueAt(fornecedortb.getSelectedRow(), 3).toString();
                String telemovel2 = fornecedortb.getValueAt(fornecedortb.getSelectedRow(), 4).toString();
                String email = fornecedortb.getValueAt(fornecedortb.getSelectedRow(), 5).toString();
                String whatsApp = fornecedortb.getValueAt(fornecedortb.getSelectedRow(), 6).toString();

                nomeFornecedorJT.setText(nomeFornecedor);
                enderecoJTA.setText(endereco);
                telemovel1JT.setText(telemovel1);
                telemovel2JT.setText(telemovel2);
                emailJT.setText(email);
                whatsAppJT.setText(whatsApp);

                fornecedorSelecionado = true;

                // Permite que o usuário não elimina os dados dos campos de texto
                pressionou = true;

            }

        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(null, "Elimina e cadastra novamente todos os "
                    + "FORNECEDORES que possuem os dados em branco",
                    "IMPOSSIVEL MANUZEAR CORRECTAMENTE A BARRA AZUL DA TABELA",
                    JOptionPane.INFORMATION_MESSAGE);
        }

        return fornecedorSelecionado;
    }

    private void fornecedorTableView() {

        fornecedordb = new Fornecedordb();

        DefaultTableModel modelo = (DefaultTableModel) fornecedortb.getModel();
        modelo.setNumRows(0);

        for (Fornecedor fr : fornecedordb.read()) {
            modelo.addRow(new Object[]{
                fr.getIdFornecedor(),
                fr.getNomeFornecedor(),
                fr.getEndereco(),
                fr.getTelemovel1(),
                fr.getTelemovel2(),
                fr.getEmail(),
                fr.getWhats_app()

            });

        }

    }

    private boolean fornecedorSelecionado_tb() {

        return fornecedortb.getSelectedRow() != -1;
    }

    private void limparCampos() {

        switch (limparCampos) {

            case 1:
                nomeFornecedorJT.setText("");
                break;

            case 2:
                telemovel1JT.setText("");
                break;
            case 3:
                telemovel2JT.setText("");
                break;
            case 4:
                emailJT.setText("");
                break;
            case 5:
                whatsAppJT.setText("");
                break;
            case 6:
                 enderecoJTA.setText("");
                break;

            default: ;
        }
        limparCampos++;

    }

    private boolean todosCamposVazios() {

        return nomeFornecedorJT.getText().isEmpty()
                || enderecoJTA.getText().isEmpty()
                || telemovel1JT.getText().isEmpty()
                || telemovel2JT.getText().isEmpty()
                || emailJT.getText().isEmpty();

    }

    private void imprimir() {
        
        fornecedordb = new Fornecedordb();
        fornecedordb.updateSequenceNumber();
        new GerarRelatorio("fornecedor.jasper").gerarRelatorio(); //To change body of generated methods, choose Tools | Templates.
    }

}
