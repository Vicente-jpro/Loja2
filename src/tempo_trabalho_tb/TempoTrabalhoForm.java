/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tempo_trabalho_tb;

import Reportes.GerarRelatorio;

import java.awt.Color;
import java.awt.Cursor;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import usuario.Usuariodb;

/**
 *
 * @author vicente
 */
public class TempoTrabalhoForm extends javax.swing.JFrame {

    private TempoTrabalhodb tempoTrabalhodb;
    private TempoTrabalho tempoTrabalho;


    /**
     * Creates new form ProdutoForm
     */
    public TempoTrabalhoForm() {
        super("Horário de Trabalho");
        initComponents();

        this.setLocationRelativeTo(null);
        getRootPane().setDefaultButton(imprimirJB);

        DefaultTableModel modelo = (DefaultTableModel) produtotb.getModel();
        produtotb.setRowSorter(new TableRowSorter(modelo));

        dataInicialView();
        dataFinalView();
        tempoTableView();

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
        jLabel1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        filtrarNomeProdutoJT = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        produtotb = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel2 = new javax.swing.JPanel();
        imprimirJB = new javax.swing.JButton();
        dataInicialJC = new javax.swing.JComboBox<>();
        dataFinalJC = new javax.swing.JComboBox<>();
        Eliminar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));

        jLabel1.setFont(new java.awt.Font("DejaVu Serif", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Horário de Trabalho");

        jPanel4.setBackground(new java.awt.Color(0, 153, 153));

        filtrarNomeProdutoJT.setFont(new java.awt.Font("DejaVu Serif", 0, 14)); // NOI18N
        filtrarNomeProdutoJT.setText("Filtrar Nome do Produto / Fornecedor");
        filtrarNomeProdutoJT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                filtrarNomeProdutoJTMouseClicked(evt);
            }
        });
        filtrarNomeProdutoJT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filtrarNomeProdutoJTActionPerformed(evt);
            }
        });
        filtrarNomeProdutoJT.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                filtrarNomeProdutoJTKeyTyped(evt);
            }
        });

        produtotb.setFont(new java.awt.Font("Dialog", 0, 13)); // NOI18N
        produtotb.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Id do Horário", "Hora de Entrada", "Hora de Saída", "Nome do Funcionário"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(produtotb);
        if (produtotb.getColumnModel().getColumnCount() > 0) {
            produtotb.getColumnModel().getColumn(0).setResizable(false);
            produtotb.getColumnModel().getColumn(1).setResizable(false);
            produtotb.getColumnModel().getColumn(2).setResizable(false);
            produtotb.getColumnModel().getColumn(3).setResizable(false);
        }

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1133, Short.MAX_VALUE)
                    .addComponent(filtrarNomeProdutoJT))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(filtrarNomeProdutoJT, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(0, 153, 153));

        imprimirJB.setBackground(new java.awt.Color(51, 255, 204));
        imprimirJB.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        imprimirJB.setForeground(java.awt.Color.black);
        imprimirJB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/pdf-32.png"))); // NOI18N
        imprimirJB.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        imprimirJB.setLabel("Imprimir");
        imprimirJB.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        imprimirJB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imprimirJBActionPerformed(evt);
            }
        });

        dataInicialJC.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        dataInicialJC.setForeground(java.awt.Color.black);
        dataInicialJC.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Data Inicial" }));

        dataFinalJC.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        dataFinalJC.setForeground(java.awt.Color.black);
        dataFinalJC.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Data Final" }));
        dataFinalJC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dataFinalJCActionPerformed(evt);
            }
        });

        Eliminar.setBackground(new java.awt.Color(255, 51, 51));
        Eliminar.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        Eliminar.setForeground(java.awt.Color.black);
        Eliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Delete-black-32.png"))); // NOI18N
        Eliminar.setText("Eliminar");
        Eliminar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Eliminar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        Eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(dataInicialJC, 0, 265, Short.MAX_VALUE)
                    .addComponent(imprimirJB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(dataFinalJC, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Eliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(107, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dataInicialJC, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dataFinalJC, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(imprimirJB)
                    .addComponent(Eliminar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 1157, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(513, 513, 513))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1159, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void filtrarNomeProdutoJTKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_filtrarNomeProdutoJTKeyTyped

        filtrar();
        // TODO add your handling code here:
    }//GEN-LAST:event_filtrarNomeProdutoJTKeyTyped

    private void filtrarNomeProdutoJTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filtrarNomeProdutoJTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_filtrarNomeProdutoJTActionPerformed

    private void filtrarNomeProdutoJTMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_filtrarNomeProdutoJTMouseClicked

        filtrarNomeProdutoJT.setText("");

    }//GEN-LAST:event_filtrarNomeProdutoJTMouseClicked

    private void EliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminarActionPerformed

  eliminar();


    }//GEN-LAST:event_EliminarActionPerformed

    private void imprimirJBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imprimirJBActionPerformed

        setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        imprimir();
        setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));

    }//GEN-LAST:event_imprimirJBActionPerformed

    private void dataFinalJCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dataFinalJCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dataFinalJCActionPerformed

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
            java.util.logging.Logger.getLogger(TempoTrabalhoForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TempoTrabalhoForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TempoTrabalhoForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TempoTrabalhoForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TempoTrabalhoForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Eliminar;
    private javax.swing.JComboBox<Object> dataFinalJC;
    private javax.swing.JComboBox<Object> dataInicialJC;
    private javax.swing.JTextField filtrarNomeProdutoJT;
    private javax.swing.JButton imprimirJB;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable produtotb;
    // End of variables declaration//GEN-END:variables

    private void tempoTableView() {

        tempoTrabalhodb = new TempoTrabalhodb();

        DefaultTableModel modelo = (DefaultTableModel) produtotb.getModel();
        modelo.setNumRows(0);

        for (TempoTrabalho fr : tempoTrabalhodb.read()) {
            modelo.addRow(new Object[]{
                fr.getId_tempo(),
                fr.getData_hora_entrada(),
                fr.getData_hora_saida(),
                fr.getNome()
            });

        }

    }

    private void dataFinalView() {

        tempoTrabalhodb = new TempoTrabalhodb();
        for (Object tempo : tempoTrabalhodb.filtrarDataTrabalho()) {
            dataInicialJC.addItem(tempo);
        }
    }

    private void dataInicialView() {

        tempoTrabalhodb = new TempoTrabalhodb();
        for (Object tempo : tempoTrabalhodb.filtrarDataTrabalho()) {
            dataFinalJC.addItem(tempo);
        }

    }

    private boolean dataSelecionada() {

        return dataInicialJC.getSelectedIndex() > 0 && dataInicialJC.getSelectedIndex() > 0;
        /*
         
        0 0  0  1
        0 1  0  0
        1 0  0  0
        1 1  1  0
        */
    }

    private void filtrar() {
      
        filtrarNomeProdutoJT.setBackground(Color.green);

        DefaultTableModel modelo = (DefaultTableModel) produtotb.getModel();

        String elemento = filtrarNomeProdutoJT.getText();

        TableRowSorter<DefaultTableModel> tabela = new TableRowSorter<DefaultTableModel>(modelo);

        produtotb.setRowSorter(tabela);
        tabela.setRowFilter(javax.swing.RowFilter.regexFilter(elemento));
//To change body of generated methods, choose Tools | Templates.
    }

    private void eliminar() {
  
          if ( dataSelecionada() ) {
            
            tempoTrabalho = new TempoTrabalho(
                    dataInicialJC.getSelectedItem().toString(),
                    dataFinalJC.getSelectedItem().toString()
            );

            tempoTrabalhodb = new TempoTrabalhodb();
            tempoTrabalhodb.delete(tempoTrabalho);

            tempoTrabalho = null;
            tempoTrabalhodb = null;
            tempoTableView();
        } else {
            
            JOptionPane.showMessageDialog(null, "Seleciona data inicial e final para eliminar",
                    "ELIMINAR HORÁRIO DE TRABALHO", JOptionPane.ERROR_MESSAGE);

        }
    }

    private void imprimir() {
   
        tempoTrabalhodb = new TempoTrabalhodb();
        tempoTrabalhodb.updateSequenceNumber();
    new GerarRelatorio("horas-trabalhadas.jasper").gerarRelatorio();
    
    }

}
