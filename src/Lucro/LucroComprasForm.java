/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lucro;

import Reportes.GerarRelatorio;
import compra_historico.CompraHistoricodb;
import java.awt.Cursor;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

import javax.swing.JOptionPane;

/**
 *
 * @author vicente
 */
public class LucroComprasForm extends javax.swing.JFrame {

    private CompraHistoricodb compraHistoricodb;

    /**
     * Creates new form ClassificacaoProdutoForm
     */
    public LucroComprasForm() {
        super("Cadastro de Classes de Produtos");
        initComponents();

        this.setLocationRelativeTo(null);
        getRootPane().setDefaultButton(obterLucroJB);
        dataInicialCombobox();

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
        obterLucroJB = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        dataInicialJC = new javax.swing.JComboBox<>();
        dataFinalJC = new javax.swing.JComboBox<>();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        lucroDiaJTA = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));

        obterLucroJB.setBackground(new java.awt.Color(102, 255, 204));
        obterLucroJB.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        obterLucroJB.setForeground(java.awt.Color.black);
        obterLucroJB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/pdf-32.png"))); // NOI18N
        obterLucroJB.setText("Obter Lucro e Imprimir");
        obterLucroJB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                obterLucroJBActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("DejaVu Serif", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Lucro do dia");

        jPanel3.setBackground(new java.awt.Color(0, 153, 153));

        dataInicialJC.setFont(new java.awt.Font("DejaVu Serif", 0, 14)); // NOI18N
        dataInicialJC.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Data Inicial" }));

        dataFinalJC.setFont(new java.awt.Font("DejaVu Serif", 0, 14)); // NOI18N
        dataFinalJC.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Data Final" }));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(dataInicialJC, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dataFinalJC, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 41, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dataInicialJC, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dataFinalJC, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        lucroDiaJTA.setColumns(20);
        lucroDiaJTA.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lucroDiaJTA.setForeground(java.awt.Color.black);
        lucroDiaJTA.setRows(1);
        lucroDiaJTA.setText("$$$$$$$   Lucro do dia    $$$$$$$");
        jScrollPane1.setViewportView(lucroDiaJTA);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(obterLucroJB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 43, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(77, 77, 77))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(196, 196, 196))))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                .addComponent(obterLucroJB, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void obterLucroJBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_obterLucroJBActionPerformed
       
        setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        obterLucro();
        new GerarRelatorio("lucro.jasper").gerarRelatorio();

        setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
        // obterLucro();

        // TODO add your handling code here:
    }//GEN-LAST:event_obterLucroJBActionPerformed

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
            java.util.logging.Logger.getLogger(LucroComprasForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LucroComprasForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LucroComprasForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LucroComprasForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LucroComprasForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<Object> dataFinalJC;
    private javax.swing.JComboBox<Object> dataInicialJC;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextArea lucroDiaJTA;
    private javax.swing.JButton obterLucroJB;
    // End of variables declaration//GEN-END:variables

    public void dataInicialCombobox() {

        compraHistoricodb = new CompraHistoricodb();

        for (String element : compraHistoricodb.readData()) {

            dataInicialJC.addItem(element);
            dataFinalJC.addItem(element);
        }

    }

    private void setTextArea(Double lucro) {

        lucroDiaJTA.setText("$$$$$$$   Lucro do dia    $$$$$$$\n"
                + "\t" + lucro + " Kz");

    }

    private void obterLucro() {
        try {

            compraHistoricodb = new CompraHistoricodb();

            String data1 = dataInicialJC.getSelectedItem().toString();
            String data2 = dataFinalJC.getSelectedItem().toString();
            LocalDate dataInicial = LocalDate.parse((CharSequence) data1);
            LocalDate dataFinal = LocalDate.parse((CharSequence) data2);

            Double lucro = compraHistoricodb.getLucroTotal(dataInicial, dataFinal);

            setTextArea(lucro);

        } catch (DateTimeParseException ex) {

            JOptionPane.showMessageDialog(null, "Seleciona uma data inicial e uma \n final para obter o lucro do dia\n",
                     "ERRO AO OBTER O LUCRO", JOptionPane.ERROR_MESSAGE);
        }

    }

}
