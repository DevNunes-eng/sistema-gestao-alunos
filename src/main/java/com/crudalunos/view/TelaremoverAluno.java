package crudalunos.view;

import crudalunos.dao.BancoDeDados;
import crudalunos.model.Aluno;

import java.awt.Color;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class TelaremoverAluno extends javax.swing.JInternalFrame {

    private BancoDeDados banco;
    private TelaAlunoMudança telaMudanca; // Nova variável

    // Recebe a telaMudanca no construtor
    public TelaremoverAluno(BancoDeDados banco, TelaAlunoMudança telaMudanca) {
        initComponents();
        this.banco = banco;
        this.telaMudanca = telaMudanca;

        Aluno alunoSelecionado = banco.getObjeto();
        if (alunoSelecionado != null) {
            lblnome.setText(alunoSelecionado.getNome());
        }

        aplicarDesign();
    }

    private void aplicarDesign() {
        Color corFundo = new Color(43, 43, 43);
        jPanel1.setBackground(corFundo);
        getContentPane().setBackground(corFundo);
        lblnome.setForeground(Color.WHITE);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblnome = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setFont(new java.awt.Font("Times New Roman", 1, 14));

        lblnome.setBackground(new java.awt.Color(0, 0, 0));
        lblnome.setFont(new java.awt.Font("Times New Roman", 1, 24));
        lblnome.setForeground(new java.awt.Color(255, 255, 255));
        lblnome.setText("Remover Aluno");

        jButton1.setText("Remover");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(110, 110, 110)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lblnome)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(34, 34, 34)
                                                .addComponent(jButton1)))
                                .addContainerGap(124, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(lblnome)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 101, Short.MAX_VALUE)
                                .addComponent(jButton1)
                                .addGap(98, 98, 98))
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
    }// </editor-fold>

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        Aluno alunoSelecionado = banco.getObjeto();
        banco.removerAluno(alunoSelecionado);
        JOptionPane.showMessageDialog(null, "Aluno " + alunoSelecionado.getNome() + " removido com sucesso!");

        try {
            banco.exportarAlunos();
            banco.exportarTodasAsNotas();
        } catch (IOException ex) {
            Logger.getLogger(TelaremoverAluno.class.getName()).log(Level.SEVERE, null, ex);
        }

        banco.setObjeto(null);
        dispose(); // Fecha esta janelinha interna
        telaMudanca.dispose(); // Fecha a tela inteira que estava atrás dela!
    }

    // Variables declaration - do not modify
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblnome;
    // End of variables declaration
}