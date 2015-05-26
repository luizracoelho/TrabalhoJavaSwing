/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.reges.contatos.ui;

import br.com.reges.contatos.dao.ContatoDao;
import br.com.reges.contatos.dao.EmailDao;
import br.com.reges.contatos.models.Contato;
import br.com.reges.contatos.models.Email;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author luizricardo
 */
public class FormularioContatoUI extends javax.swing.JFrame {

    //Criacão das opçãoes de Operação
    enum Operacao {

        Incluir,
        Alterar
    }

    //Criação da Operação
    Operacao operacaoAtual = Operacao.Incluir;

    Contato contato = new Contato();
    ArrayList<Contato> contatos = new ArrayList<Contato>();

    DefaultListModel lmEmails = new DefaultListModel();
    DefaultTableModel tmContatos = new DefaultTableModel(new Object[][]{}, new String[]{"Id", "Título", "Nome", "Sobrenome", "Apelido", "Gênero"}) {

        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };

    /**
     * Creates new form FormularioContatoUI
     */
    public FormularioContatoUI() {
        initComponents();

        tableRecords.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bgGenero = new javax.swing.ButtonGroup();
        jMenu3 = new javax.swing.JMenu();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtSobrenome = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtApelido = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        cbTitulo = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        radMasc = new javax.swing.JRadioButton();
        radFem = new javax.swing.JRadioButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstEmails = new javax.swing.JList();
        chkPrincipal = new javax.swing.JCheckBox();
        btnAdd = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnRemover = new javax.swing.JButton();
        btnPadrão = new javax.swing.JButton();
        btnNovo = new javax.swing.JButton();
        btnOk = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableRecords = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuArquivo = new javax.swing.JMenu();
        menuNovo = new javax.swing.JMenuItem();
        menuSalvar = new javax.swing.JMenuItem();

        jMenu3.setText("jMenu3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Dados Pessoais"));

        jLabel1.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel1.setText("Nome:");

        jLabel2.setText("Sobrenome:");

        jLabel3.setText("Apelido:");

        jLabel4.setText("Título:");

        cbTitulo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Sr.", "Sra." }));

        jLabel5.setText("Gênero:");

        bgGenero.add(radMasc);
        radMasc.setSelected(true);
        radMasc.setText("Masculino");
        radMasc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radMascActionPerformed(evt);
            }
        });

        bgGenero.add(radFem);
        radFem.setText("Feminino");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addGap(22, 22, 22))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel3)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(24, 24, 24)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtNome)
                            .addComponent(txtApelido, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(radMasc)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(radFem)
                                .addGap(0, 54, Short.MAX_VALUE))
                            .addComponent(txtSobrenome)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(cbTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(txtSobrenome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtApelido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5)
                    .addComponent(radMasc)
                    .addComponent(radFem))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("E-Mails"));

        jLabel6.setText("E-Mail:");

        lstEmails.setModel(lmEmails);
        jScrollPane1.setViewportView(lstEmails);

        chkPrincipal.setText("Principal");

        btnAdd.setText("Adicionar");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnRemover.setText("Remover");
        btnRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoverActionPerformed(evt);
            }
        });

        btnPadrão.setText("Tornar Padrão");
        btnPadrão.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPadrãoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(txtEmail, javax.swing.GroupLayout.DEFAULT_SIZE, 336, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(chkPrincipal)
                        .addGap(12, 12, 12))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jScrollPane1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(btnPadrão)
                    .addComponent(btnRemover, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEditar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAdd))
                .addContainerGap())
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnAdd, btnEditar, btnPadrão, btnRemover});

        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAdd)
                    .addComponent(chkPrincipal))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnEditar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnRemover)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnPadrão)
                        .addGap(0, 11, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );

        btnNovo.setText("Novo");
        btnNovo.setPreferredSize(new java.awt.Dimension(111, 29));
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });

        btnOk.setText("Salvar");
        btnOk.setPreferredSize(new java.awt.Dimension(111, 29));
        btnOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOkActionPerformed(evt);
            }
        });

        tableRecords.setModel(tmContatos);
        tableRecords.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableRecordsMouseClicked(evt);
            }
        });
        tableRecords.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tableRecordsKeyPressed(evt);
            }
        });
        jScrollPane2.setViewportView(tableRecords);

        jLabel7.setText("Pressione Delete para Excluir Um Contato");

        menuArquivo.setText("Arquivo");

        menuNovo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        menuNovo.setText("Novo");
        menuNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuNovoActionPerformed(evt);
            }
        });
        menuArquivo.add(menuNovo);

        menuSalvar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        menuSalvar.setText("Salvar");
        menuSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuSalvarActionPerformed(evt);
            }
        });
        menuArquivo.add(menuSalvar);

        jMenuBar1.add(menuArquivo);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnOk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnNovo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnNovo, btnOk});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnOk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNovo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void radMascActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radMascActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_radMascActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        if (!"".equals(txtEmail.getText())) {
            //Instanciar o objeto
            Email email = new Email();

            //Inserir o email
            email.setEmail(txtEmail.getText());

            //Caso o email a ser adicionado seja o principal, limpa o email principal atual
            if (chkPrincipal.isSelected()) {
                for (Iterator<Email> it = contato.emails.iterator(); it.hasNext();) {
                    it.next().setPrincipal(false);
                }
            }

            //Seta o e-mail principal
            if (contato.emails.isEmpty()) {
                email.setPrincipal(true);
            } else {
                email.setPrincipal(chkPrincipal.isSelected());
            }

            //Adiciona o e-mail à lista de emails
            contato.emails.add(email);

            //Atualiza a List model
            atualizarListModel();

            //Apaga o campo e-mail e ja posiciona o cursor para uma nova inclusão
            txtEmail.setText(null);
            chkPrincipal.setSelected(false);
            txtEmail.requestFocus();
        } else {
            txtEmail.requestFocus();
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        try {
            //Pegar o email atual
            Email email = contato.emails.get(lstEmails.getSelectedIndex());

            //Excluir o item
            contato.emails.remove(email);

            //Verificar se algum item foi selecionado
            if (contato.emails.size() > 0 && email.isPrincipal()) {
                //Setar Primeiro Email como Principal
                contato.emails.get(0).setPrincipal(true);
            }

            //Preencher os campos no formulário
            txtEmail.setText(email.getEmail());
            chkPrincipal.setSelected(email.isPrincipal());

            //Atualizar o listModel
            atualizarListModel();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Nenhum Item foi Selecionado!", "Erro", 0);
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoverActionPerformed
        try {
            //Pegar o email atual
            Email email = contato.emails.get(lstEmails.getSelectedIndex());

            //Excluir o item
            contato.emails.remove(email);

            //Verificar se algum item foi selecionado
            if (contato.emails.size() > 0 && email.isPrincipal()) {
                //Setar Primeiro Email como Principal
                contato.emails.get(0).setPrincipal(true);
            }

            //Atualizar o listModel
            atualizarListModel();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Nenhum Item foi Selecionado!", "Erro", 0);
        }
    }//GEN-LAST:event_btnRemoverActionPerformed

    private void btnPadrãoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPadrãoActionPerformed

        if (contato.emails.size() > 0) {
            for (Iterator<Email> it = contato.emails.iterator(); it.hasNext();) {
                it.next().setPrincipal(false);
            }

            //Setar o item solicitado
            contato.emails.get(lstEmails.getSelectedIndex()).setPrincipal(true);

            //Atualizar o List Model
            atualizarListModel();
        }
    }//GEN-LAST:event_btnPadrãoActionPerformed

    private void menuNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuNovoActionPerformed
        //Incluir Novo Contato
        novoContato();
    }//GEN-LAST:event_menuNovoActionPerformed

    private void btnOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOkActionPerformed
//Salvar o Registro
        salvarRegistro();
    }//GEN-LAST:event_btnOkActionPerformed

    private void menuSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuSalvarActionPerformed
        //Salvar o Registro
        salvarRegistro();
    }//GEN-LAST:event_menuSalvarActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        //Atualizar a Table
        atualizarTable();
    }//GEN-LAST:event_formWindowOpened

    private void tableRecordsKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tableRecordsKeyPressed
        //Verificar se o botão pressionado foi o delete
        if (evt.getKeyCode() == 127) {
            int retorno = JOptionPane.showConfirmDialog(rootPane, "Deseja Realmente Excluir o Contato Selecionado?", "Confirmação", JOptionPane.OK_OPTION, JOptionPane.YES_NO_OPTION);
            if (retorno == 0) {

                //Instanciar a classe de acesso à dados
                ContatoDao contatoDao = new ContatoDao();

                try {
                    //Obter a linha selecionada
                    int linhaSelecionada = tableRecords.getSelectedRow();

                    //Preencher o contato
                    contato = contatoDao.getContato(Integer.parseInt(tmContatos.getValueAt(linhaSelecionada, 0).toString()));

                    //Excluir o registro
                    contatoDao.delete(contato);

                    //Mostrar Confirmação
                    JOptionPane.showMessageDialog(this, "Contato Excluído Com Sucesso!", "Confirmação", 1);
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(rootPane, ex.getMessage(), "Erro", 0);
                } finally {
                    //Deixar um novo Contato para ser incluído
                    novoContato();

                    //Atualizar a Table
                    atualizarTable();
                }
            }
        }
    }//GEN-LAST:event_tableRecordsKeyPressed

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        //Incluir novo Contrato
        novoContato();
    }//GEN-LAST:event_btnNovoActionPerformed

    private void tableRecordsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableRecordsMouseClicked
        //Verificar se foi duplo clique
        if (evt.getClickCount() == 2) {
            //Alterar o Contato
            alterarContato();
        }
    }//GEN-LAST:event_tableRecordsMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the GTK+ look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("GTK+".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FormularioContatoUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormularioContatoUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormularioContatoUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormularioContatoUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormularioContatoUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup bgGenero;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnOk;
    private javax.swing.JButton btnPadrão;
    private javax.swing.JButton btnRemover;
    private javax.swing.JComboBox cbTitulo;
    private javax.swing.JCheckBox chkPrincipal;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList lstEmails;
    private javax.swing.JMenu menuArquivo;
    private javax.swing.JMenuItem menuNovo;
    private javax.swing.JMenuItem menuSalvar;
    private javax.swing.JRadioButton radFem;
    private javax.swing.JRadioButton radMasc;
    private javax.swing.JTable tableRecords;
    private javax.swing.JTextField txtApelido;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtSobrenome;
    // End of variables declaration//GEN-END:variables

    private void atualizarListModel() {
        lmEmails.clear();

        for (Email email : contato.emails) {
            lmEmails.addElement(email);
        }

        lstEmails.updateUI();
    }

    private void limparTexts() {
        //Limpar os texts
        txtNome.setText(null);
        txtSobrenome.setText(null);
        txtApelido.setText(null);
        radMasc.setSelected(true);
        radFem.setSelected(false);
        cbTitulo.setSelectedIndex(0);
        txtEmail.setText(null);
        chkPrincipal.setSelected(false);

        //Limpar os e-mail
        contato.emails.clear();

        //Atualizar o listModel
        atualizarListModel();
    }

    private void salvarRegistro() {
        //Verificar se o nome está vazio ou se algum e-mail foi preenchido
        if ("".equals(txtNome.getText())) {
            JOptionPane.showMessageDialog(this, "O Campo Nome é Obrigatório!", "Erro", 0);
        } else if (contato.emails.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nenhum E-mail Foi Adicionado!", "Erro", 0);
        } else {
            //Preencher os dados do contato
            contato.setNome(txtNome.getText());
            contato.setSobrenome(txtSobrenome.getText());
            contato.setApelido(txtApelido.getText());
            contato.setGenero(radMasc.isSelected() ? "M" : "F");
            contato.setTitulo(cbTitulo.getSelectedItem().toString());

            //Instanciar a classe de Acesso à dados
            ContatoDao contatoDao = new ContatoDao();
            EmailDao emailDao = new EmailDao();

            try {

                //Verificar se o registro deverá ser Inserido ou Alterado
                if (operacaoAtual == Operacao.Incluir) {
                    //Inserir o registro
                    contatoDao.insert(contato);
                } else {
                    //Alterar o registro
                    contatoDao.update(contato);

                    //Remover os e-mails existenstes
                    emailDao.delete(contato);
                }

                //Salvar os Emails do Contato
                for (Email email : contato.emails) {
                    //Atribuir valor a classe de acesso à dados
                    emailDao = new EmailDao();

                    //Incluir o Email
                    emailDao.insert(email, contato);
                }

                //Mostrar Confirmação
                JOptionPane.showMessageDialog(this, "Contato Gravado Com Sucesso!", "Confirmação", 1);

                //Adicionar Novo Contato
                novoContato();

                //Atualizar a Table
                atualizarTable();

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(rootPane, ex.getMessage(), "Erro", 0);
            }
        }
    }

    private void atualizarTable() {
        //Limpar TableModel
        tmContatos.getDataVector().removeAllElements();
        
        //Refresh da Table
        tableRecords.updateUI();

        //Instanciar a Classe de Acesso à Dados
        ContatoDao contatoDao = new ContatoDao();

        //Executa o Comando
        try {
            contatos = contatoDao.select();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage(), "Erro", 0);
        }

        for (Contato contato : contatos) {
            tmContatos.addRow(new Object[]{contato.getId(), contato.getTitulo(), contato.getNome(), contato.getSobrenome(), contato.getApelido(), contato.getGenero()});
        }
    }

    private void novoContato() {
        //Setar a Opeção Atual
        operacaoAtual = Operacao.Incluir;

        //Criar uma nova instância do objeto
        contato = new Contato();

        //Limpar os Texts
        limparTexts();

        //Setar o foco
        txtNome.requestFocus();

        //Atualizar ListModel
        atualizarListModel();
    }

    private void alterarContato() {
        //Setar a Opeção Atual
        operacaoAtual = Operacao.Alterar;

        //Instanciar Classe de Acesso à Dados
        ContatoDao contatoDao = new ContatoDao();

        //Obter a linha selecionada
        int linhaSelecionada = tableRecords.getSelectedRow();

        try {
            //Recuperar o Contato
            contato = contatoDao.getContato(Integer.parseInt(tmContatos.getValueAt(linhaSelecionada, 0).toString()));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage());
        }

        //Preencher os campos com o contato
        txtNome.setText(contato.getNome());
        txtSobrenome.setText(contato.getSobrenome());
        txtApelido.setText(contato.getApelido());
        if (contato.getGenero().equals("M")) {
            radMasc.setSelected(true);
        } else {
            radFem.setSelected(true);
        }
        cbTitulo.setSelectedItem(contato.getTitulo());

        //Atualizar os E-mails
        atualizarListModel();
    }
}
