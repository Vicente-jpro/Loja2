/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pacotes;

import RestricoesEmHoras.DataDeRestricaoConnectiondb;
import RestricoesEmHoras.DataDeRestricaodb;
import RestricoesEmHoras.DataHorasDeRestricao;

/**
 *
 * @author vicente
 */
public class EscolhaDoPacote extends javax.swing.JFrame {

    private DataHorasDeRestricao data;
    private DataDeRestricaodb dataDeRestricaodb;
    private DataDeRestricaoConnectiondb dataDeRestricaoConnectiondb;

    private Pacotes pacotes;
    private Pacotesdb pacotesdb;
    private PacotesConnectiondb pacotesConnectiondb;

    public EscolhaDoPacote() {
        initComponents();
        setTitle("Seleçao de pacotes");
        getRootPane().setDefaultButton(salvarPacoteJB);
        visualizarDadosNaJComboBox();

        this.setLocationRelativeTo(null);

    }

    // metodo que serve para escrever os dados na tabela pais
 
    public void visualizarDadosNaJComboBox() {

        pacotesdb = new Pacotesdb();

        for (Pacotes mat : pacotesdb.readPacotes()) {

            pacotesJC.addItem(mat);

        }

    }

    /**
     *
     * @param nomeBotao Deve receber argumento do tipo String . Permite-nos
     * bloquear alguns botões.
     *
     * Os argumentos válidos são "salvar", "editar", "eliminar".
     */
    public void bloqueiarBotao(String nomeBotao) {

        switch (nomeBotao) {

            case "editar":
                salvarPacoteJB.setEnabled(false);
                break;

            default: ;

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
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        salvarPacoteJB = new javax.swing.JButton();
        resetDataJB = new javax.swing.JButton();
        pacotesJC = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));

        jLabel1.setFont(new java.awt.Font("Ubuntu", 0, 20)); // NOI18N
        jLabel1.setForeground(java.awt.Color.white);
        jLabel1.setText("Pacotes Disponiveis");

        jPanel2.setBackground(new java.awt.Color(0, 102, 102));
        jPanel2.setForeground(new java.awt.Color(209, 20, 225));

        salvarPacoteJB.setBackground(new java.awt.Color(252, 148, 3));
        salvarPacoteJB.setFont(new java.awt.Font("Ubuntu", 0, 19)); // NOI18N
        salvarPacoteJB.setForeground(java.awt.Color.black);
        salvarPacoteJB.setText("Salvar Pacote");
        salvarPacoteJB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salvarPacoteJBActionPerformed(evt);
            }
        });

        resetDataJB.setBackground(new java.awt.Color(252, 148, 3));
        resetDataJB.setFont(new java.awt.Font("Ubuntu", 0, 19)); // NOI18N
        resetDataJB.setForeground(java.awt.Color.black);
        resetDataJB.setText("Reset Data");
        resetDataJB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetDataJBActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(salvarPacoteJB, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(resetDataJB, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(61, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(salvarPacoteJB)
                    .addComponent(resetDataJB))
                .addContainerGap())
        );

        pacotesJC.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(160, 160, 160)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(pacotesJC, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel1)
                .addGap(39, 39, 39)
                .addComponent(pacotesJC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 107, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void salvarPacoteJBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salvarPacoteJBActionPerformed

        // Pega o id corespondente ao nome do pacote

            
            pacotesConnectiondb  = new PacotesConnectiondb();
           
            String nomeDoPacote = pacotesJC.getSelectedItem().toString();
            

            int idPacote = pacotesConnectiondb.getIdPacoteEscolhido( nomeDoPacote );
          
            pacotesConnectiondb.inserirPacoteNaDataHoraDeRestricaotb( idPacote );         
            

    }//GEN-LAST:event_salvarPacoteJBActionPerformed

    private void resetDataJBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetDataJBActionPerformed

        dataDeRestricaoConnectiondb = new DataDeRestricaoConnectiondb();

        dataDeRestricaoConnectiondb.deleteList();
        dataDeRestricaoConnectiondb.creatList();


    }//GEN-LAST:event_resetDataJBActionPerformed

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
            java.util.logging.Logger.getLogger(EscolhaDoPacote.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EscolhaDoPacote.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EscolhaDoPacote.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EscolhaDoPacote.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EscolhaDoPacote().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JComboBox<Object> pacotesJC;
    private javax.swing.JButton resetDataJB;
    private javax.swing.JButton salvarPacoteJB;
    // End of variables declaration//GEN-END:variables

}
