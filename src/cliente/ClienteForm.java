/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente;

import Reportes.GerarRelatorio;
import classificacao_produto.*;
import Words.Words;
import java.awt.Cursor;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author vicente
 */
public class ClienteForm extends javax.swing.JFrame {

    private Cliente cliente;
    private ClienteConnectiondb clienteConnectiondb;
    private Clientedb clientedb;
    private Words transform;
    private boolean pressionou;
    private String idCliente_tb = "Não definido", nomeCliente_tb = "Não defifindo";

    /**
     * Creates new form ClienteForm
     */
    public ClienteForm() {
        super("Cadastro de Clientes");
        initComponents();

        this.setLocationRelativeTo(null);
        getRootPane().setDefaultButton(salvarJB);
        transform = Words.getInstance();

        this.pressionou = false;

        DefaultTableModel modelo = (DefaultTableModel) clientetb.getModel();
        clientetb.setRowSorter(new TableRowSorter(modelo));

        clienteTableView();

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
        nomeClienteJT = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        moradaJTA = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        clientetb = new javax.swing.JTable();
        imprimirJB = new javax.swing.JButton();

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

        actualizarJB.setBackground(new java.awt.Color(102, 255, 102));
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

        nomeClienteJT.setFont(new java.awt.Font("DejaVu Serif", 0, 14)); // NOI18N
        nomeClienteJT.setText("Nome do cliente");

        jLabel1.setFont(new java.awt.Font("DejaVu Serif", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Cadastro de Clientes");

        moradaJTA.setColumns(20);
        moradaJTA.setFont(new java.awt.Font("DejaVu Serif", 0, 13)); // NOI18N
        moradaJTA.setRows(5);
        moradaJTA.setText("Morada");
        jScrollPane1.setViewportView(moradaJTA);

        clientetb.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Id", "Nome do Cliente", "Morada"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        clientetb.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clientetbMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                clientetbMouseReleased(evt);
            }
        });
        clientetb.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                clientetbKeyReleased(evt);
            }
        });
        jScrollPane2.setViewportView(clientetb);
        if (clientetb.getColumnModel().getColumnCount() > 0) {
            clientetb.getColumnModel().getColumn(0).setResizable(false);
            clientetb.getColumnModel().getColumn(1).setResizable(false);
            clientetb.getColumnModel().getColumn(2).setResizable(false);
        }

        imprimirJB.setBackground(new java.awt.Color(102, 255, 204));
        imprimirJB.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        imprimirJB.setForeground(java.awt.Color.black);
        imprimirJB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/pdf-32.png"))); // NOI18N
        imprimirJB.setText("Imprimir");
        imprimirJB.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        imprimirJB.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        imprimirJB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imprimirJBActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(actualizarJB, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(salvarJB, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(nomeClienteJT, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                .addComponent(eliminarJB, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(imprimirJB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(241, 241, 241)
                        .addComponent(jLabel1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(nomeClienteJT, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(salvarJB, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(actualizarJB, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(eliminarJB, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                        .addComponent(imprimirJB)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

        eliminar();

        // TODO add your handling code here:
    }//GEN-LAST:event_eliminarJBActionPerformed

    private void salvarJBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salvarJBActionPerformed
        salvar();
        // TODO add your handling code here:
    }//GEN-LAST:event_salvarJBActionPerformed

    private void actualizarJBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actualizarJBActionPerformed

        actualizar();

        // TODO add your handling code here:
    }//GEN-LAST:event_actualizarJBActionPerformed

    private void clientetbMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clientetbMouseClicked

        clientetb();


    }//GEN-LAST:event_clientetbMouseClicked

    private void clientetbMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clientetbMouseReleased

        // TODO add your handling code here:
    }//GEN-LAST:event_clientetbMouseReleased

    private void clientetbKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_clientetbKeyReleased

        clientetb();
        // TODO add your handling code here:
    }//GEN-LAST:event_clientetbKeyReleased

    private void imprimirJBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imprimirJBActionPerformed

        setCursor(Cursor.getPredefinedCursor( Cursor.WAIT_CURSOR ));
       imprimir();
        
        setCursor(Cursor.getPredefinedCursor( Cursor.DEFAULT_CURSOR ));
        
    }//GEN-LAST:event_imprimirJBActionPerformed

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
            java.util.logging.Logger.getLogger(ClienteForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ClienteForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ClienteForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ClienteForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ClienteForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton actualizarJB;
    private javax.swing.JTable clientetb;
    private javax.swing.JButton eliminarJB;
    private javax.swing.JButton imprimirJB;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea moradaJTA;
    private javax.swing.JTextField nomeClienteJT;
    private javax.swing.JButton salvarJB;
    // End of variables declaration//GEN-END:variables

    private boolean campoNomeMoradaVazioJT() {

        return nomeClienteJT.getText().isEmpty() || "Nome do cliente".equals(nomeClienteJT.getText())
                || moradaJTA.getText().isEmpty() || "Morada".equals(moradaJTA.getText()); // true
    }

    private boolean clientetb() {

        boolean clienteSelecionado = false;

        try {

            if (clientetb.getSelectedRow() != -1) {

                this.nomeCliente_tb = clientetb.getValueAt(clientetb.getSelectedRow(), 1).toString();
                this.idCliente_tb = clientetb.getValueAt(clientetb.getSelectedRow(), 0).toString();
                String morada = clientetb.getValueAt(clientetb.getSelectedRow(), 2).toString();

                nomeClienteJT.setText(nomeCliente_tb);
                moradaJTA.setText(morada);

                clienteSelecionado = true;

                // Permite que o usuário não elimina os dados dos campos de texto
                pressionou = true;

            }

        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(null, "Elimina e cadastra novamente todos os "
                    + "CLIENTES que possuem os dados em branco",
                    "IMPOSSIVEL MANUZEAR CORRECTAMENTE A BARRA AZUL DA TABELA",
                    JOptionPane.INFORMATION_MESSAGE);
        }

        return clienteSelecionado;
    }

    private void clienteTableView() {

        clientedb = new Clientedb();

        DefaultTableModel modelo = (DefaultTableModel) clientetb.getModel();
        modelo.setNumRows(0);

        for (Cliente cli : clientedb.read()) {
            modelo.addRow(new Object[]{
                cli.getIdCliente(),
                cli.getNomeCliente(),
                cli.getMorada()

            });

        }

    }

    private void eliminar() {
        // Se o cliente da tabela não for selecionado.
        if (!clientetb()) {

            JOptionPane.showMessageDialog(null, "Seleciona um cliente para eliminar",
                    "ELIMINAR CLIENTES", JOptionPane.ERROR_MESSAGE);

        } else if (nomeCliente_tb.equalsIgnoreCase("Anônimo")) {
            JOptionPane.showMessageDialog(null, "Não foi possivel eliminar o cliente\n"
                    + "Este cliente não pode ser eliminado",
                    "ELIMINAR CLIENTES", JOptionPane.ERROR_MESSAGE);
        } else {

            // Verificar se o cliente é o Anônimo
//            
//            cliente = new Cliente();
//            cliente.setMorada(nomeCliente_tb);
//            
//            clientedb = new Clientedb();
//            clientedb.contem(cliente)
            clienteConnectiondb = new ClienteConnectiondb();

            cliente = new Cliente();

            cliente.setIdCliente(Integer.parseInt(idCliente_tb));
            cliente.setNomeCliente(nomeCliente_tb);

            clienteConnectiondb.eliminar(cliente);
            clienteTableView();

        }
    }

    private void actualizar() {
        // Se o cliente da tabela for selecionado.
        
            String nomeCliente = nomeClienteJT.getText();
            String morada = moradaJTA.getText();
            
        if (!clientetb()) {
            JOptionPane.showMessageDialog(null, "Seleciona um cliente na tabela \npara poder modificar. ",
                    "ACTUALIZAR CLIENTE", JOptionPane.ERROR_MESSAGE);

        } else if (campoNomeMoradaVazioJT()) {

            JOptionPane.showMessageDialog(null, "Os campos de Texto não pode estar vazios",
                    "ACTUALIZAR CLIENTE", JOptionPane.ERROR_MESSAGE);

        } else if (nomeCliente_tb.equalsIgnoreCase("Anônimo")) {
            JOptionPane.showMessageDialog(null, "Não foi possível actualizar o cliente\n"
                    + "Este cliente não pode ser actualizado.",
                    "ACTUALIZAR CLIENTE", JOptionPane.ERROR_MESSAGE);
        } else {

            clienteConnectiondb = new ClienteConnectiondb();



            String novoNome = transform.toUpperCaseAllFirsLetter(nomeCliente);
            String novaModada = morada.toUpperCase();

            System.out.println("ultimo else"+nomeCliente
                               +"\n"+novaModada);
            
            
            String client = clientetb.getValueAt(clientetb.getSelectedRow(), 0).toString();
            int idCliente = Integer.parseInt(client);
            
            cliente = new Cliente(idCliente, novoNome, novaModada);
            
            clienteConnectiondb.actualizar(cliente);
            clienteTableView();

        } //To change body of generated methods, choose Tools | Templates.
    }

    private void salvar() {

        if (campoNomeMoradaVazioJT()) {

            JOptionPane.showMessageDialog(null, "Os campos de texto não podem estar vazios",
                    "SALVAR CLIENTE", JOptionPane.ERROR_MESSAGE);

        } else {

            clientedb = new Clientedb();
            // pesquisar a nome de produto na lista    
            String nomeCliente = nomeClienteJT.getText();

            String moradaCliente = moradaJTA.getText();

            String nome = transform.toUpperCaseAllFirsLetter(nomeCliente);
            String morada = transform.toUpperCaseAllFirsLetter(moradaCliente);

            cliente = new Cliente(nome, morada);

            clienteConnectiondb = new ClienteConnectiondb();

            clienteConnectiondb.salvar(cliente);

            clienteTableView();
        }
//To change body of generated methods, choose Tools | Templates.
    }

    private void imprimir() {
        
        clientedb = new Clientedb();
        clientedb.updateSequenceNumber();
        new GerarRelatorio("cliente.jasper").gerarRelatorio(); //To change body of generated methods, choose Tools | Templates.
    }

}
