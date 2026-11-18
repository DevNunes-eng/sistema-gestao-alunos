/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package crudalunos.view;

import crudalunos.dao.BancoDeDados;
import crudalunos.model.Aluno;
import crudalunos.model.Disciplinas;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class TelaNotas extends javax.swing.JInternalFrame {

    private BancoDeDados banco;
    private List<Double> notas;
    private ArrayList<Disciplinas> disci;

    public TelaNotas(BancoDeDados banco, List<Double> notas, ArrayList<Disciplinas> disci) {
        initComponents();
        this.banco = banco;
        this.notas = notas;
        this.disci = disci;

        ArrayList<Aluno> alunos = banco.getListaAluno();
        for (int i = 0; i < alunos.size(); i++) {
            Aluno objeto = alunos.get(i);
            cmbAluno.addItem(objeto);
        }

        aplicarDesign();
    }

    private void aplicarDesign() {
        Color corFundo = new Color(43, 43, 43);
        jPanel1.setBackground(corFundo);
        getContentPane().setBackground(corFundo);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        cmbAluno = new javax.swing.JComboBox<>();
        cmbDis = new javax.swing.JComboBox<>();
        txtNota = new javax.swing.JTextField();
        btnSalvar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtLinha = new javax.swing.JTextArea();
        jButton3 = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        cmbAluno.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        cmbAluno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbAlunoActionPerformed(evt);
            }
        });

        cmbDis.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Português", "Inglês" }));

        txtNota.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txtNota.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnSalvar.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnSalvar.setText("Salvar Nota");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Nota:");

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Aluno:");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Disciplina:");

        jButton1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton1.setText("Sair");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Adicionar Notas");

        jButton2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton2.setText("Exibir Nota");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        txtLinha.setColumns(20);
        txtLinha.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txtLinha.setRows(5);
        jScrollPane1.setViewportView(txtLinha);

        jButton3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton3.setText("Limpar texto");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel4)
                                                .addGap(95, 95, 95))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel3)
                                                .addGap(18, 18, 18)
                                                .addComponent(cmbDis, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(142, 142, 142))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel1)
                                                        .addComponent(jLabel2))
                                                .addGap(18, 18, 18)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addComponent(txtNota, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(38, 38, 38))
                                                        .addComponent(cmbAluno, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(btnSalvar)
                                                .addGap(35, 35, 35)
                                                .addComponent(jButton2)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jButton1)))
                                .addGap(0, 38, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane1)
                                .addContainerGap())
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(161, 161, 161)
                                .addComponent(jButton3)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel4)
                                .addGap(36, 36, 36)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(cmbAluno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel1))
                                .addGap(44, 44, 44)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtNota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel2))
                                .addGap(34, 34, 34)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(cmbDis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel3))
                                .addGap(42, 42, 42)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnSalvar)
                                        .addComponent(jButton2)
                                        .addComponent(jButton1))
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton3)
                                .addContainerGap(25, Short.MAX_VALUE))
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

    private void cmbAlunoActionPerformed(java.awt.event.ActionEvent evt) {
    }

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {
        String nomeDisciplina = (String) cmbDis.getSelectedItem();
        Aluno objeto = (Aluno) cmbAluno.getSelectedItem();

        if (txtNota.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor, preencha o campo!");
        } else {
            try {
                double nota = Double.parseDouble(txtNota.getText().trim().replace(",", "."));

                Disciplinas disciplina = null;
                for (Disciplinas dis : objeto.getDisci()) {
                    if (dis.getNome().equalsIgnoreCase(nomeDisciplina)) {
                        disciplina = dis;
                        break;
                    }
                }

                if (disciplina != null) {
                    disciplina.AddNota2(nota);
                } else {
                    Disciplinas nova = new Disciplinas();
                    nova.setNome(nomeDisciplina);
                    nova.setAluno(objeto);
                    nova.AddNota2(nota);
                    objeto.getDisci().add(nova);
                }

                JOptionPane.showMessageDialog(null, "Nota salva com sucesso!");
                dispose(); // FECHA A TELA APÓS SALVAR

            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Formato errado! Digite um número válido!");
            }
        }
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        dispose();
    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        String nomeDisciplina = (String) cmbDis.getSelectedItem();
        Aluno objeto = (Aluno) cmbAluno.getSelectedItem();
        txtLinha.append("Notas do Aluno(a) " + objeto.getNome() + " na disciplina " + nomeDisciplina + " \n");

        boolean encontrouDisciplina = false;
        for (Disciplinas disci : objeto.getDisci()) {
            if (disci.getNome().trim().equalsIgnoreCase(nomeDisciplina.trim())) {
                encontrouDisciplina = true;
                List<Double> notas = disci.getNotas();
                StringBuilder linha3 = new StringBuilder();
                for (int i = 0; i < notas.size(); i++) {
                    linha3.append("P" + (i + 1) + " " + notas.get(i) + "\n");
                }
                txtLinha.append(linha3.toString());
            }
        }

        if (!encontrouDisciplina) {
            txtLinha.append("Não tem notas do aluno nessa disciplina!\n");
        }
    }

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
        txtLinha.setText("");
    }

    // Variables declaration - do not modify
    private javax.swing.JButton btnSalvar;
    private javax.swing.JComboBox<Aluno> cmbAluno;
    private javax.swing.JComboBox<String> cmbDis;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txtLinha;
    private javax.swing.JTextField txtNota;
    // End of variables declaration
}