
package compilador;

import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Action;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import gals.*;

/**
 * @author sofialindner
 * @author Marlon-Sbardelatti
 */

public class Frame extends javax.swing.JFrame {

    public Frame() {
        initComponents();
    }

    private void initComponents() {
        mainPanel = new javax.swing.JPanel();
        barraFerramentas = new javax.swing.JToolBar();
        novoBtn = new javax.swing.JButton();
        abrirBtn = new javax.swing.JButton();
        salvarBtn = new javax.swing.JButton();
        copiarBtn = new javax.swing.JButton();
        colarBtn = new javax.swing.JButton();
        recortarBtn = new javax.swing.JButton();
        compilarBtn = new javax.swing.JButton();
        equipeBtn = new javax.swing.JButton();
        barraStatus = new javax.swing.JToolBar();
        arquivoLbl = new javax.swing.JLabel();
        splitPane = new javax.swing.JSplitPane();
        editorPanel = new javax.swing.JScrollPane();
        editorTxtArea = new javax.swing.JTextArea();
        mensagensPanel = new javax.swing.JScrollPane();
        mensagensTxtArea = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(new java.awt.Rectangle(0, 0, 920, 620));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMinimumSize(new java.awt.Dimension(920, 620));
        setSize(new java.awt.Dimension(920, 620));

        mainPanel.setMinimumSize(new java.awt.Dimension(910, 600));
        mainPanel.setName(""); // NOI18N
        mainPanel.setPreferredSize(new java.awt.Dimension(910, 600));

        barraFerramentas.setBorder(null);
        barraFerramentas.setRollover(true);
        barraFerramentas.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        barraFerramentas.setEnabled(false);
        barraFerramentas.setFocusable(false);
        barraFerramentas.setMaximumSize(new java.awt.Dimension(900, 70));
        barraFerramentas.setMinimumSize(new java.awt.Dimension(900, 70));
        barraFerramentas.setPreferredSize(new java.awt.Dimension(900, 70));
        barraFerramentas.setRequestFocusEnabled(false);
        barraFerramentas.setVerifyInputWhenFocusTarget(false);

        novoBtn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        novoBtn.setForeground(new java.awt.Color(95, 94, 99));
        novoBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/compilador/icons/new-file-icon.png"))); // NOI18N
        novoBtn.setText("novo [ctrl-n]");
        novoBtn.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        novoBtn.setFocusable(false);
        novoBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        novoBtn.setMaximumSize(new java.awt.Dimension(110, 70));
        novoBtn.setMinimumSize(new java.awt.Dimension(110, 70));
        novoBtn.setPreferredSize(new java.awt.Dimension(110, 70));
        novoBtn.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        novoBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                novoBtnActionPerformed(evt);
            }
        });
        barraFerramentas.add(novoBtn);

        abrirBtn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        abrirBtn.setForeground(new java.awt.Color(95, 94, 99));
        abrirBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/compilador/icons/open-file-icon.png"))); // NOI18N
        abrirBtn.setText("abrir [ctrl-o]");
        abrirBtn.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        abrirBtn.setFocusPainted(false);
        abrirBtn.setFocusable(false);
        abrirBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        abrirBtn.setMaximumSize(new java.awt.Dimension(110, 70));
        abrirBtn.setMinimumSize(new java.awt.Dimension(110, 70));
        abrirBtn.setPreferredSize(new java.awt.Dimension(110, 70));
        abrirBtn.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        abrirBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                abrirBtnActionPerformed(evt);
            }
        });
        barraFerramentas.add(abrirBtn);

        salvarBtn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        salvarBtn.setForeground(new java.awt.Color(95, 94, 99));
        salvarBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/compilador/icons/save-icon.png"))); // NOI18N
        salvarBtn.setText("salvar [ctrl-s]");
        salvarBtn.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        salvarBtn.setFocusPainted(false);
        salvarBtn.setFocusable(false);
        salvarBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        salvarBtn.setMaximumSize(new java.awt.Dimension(110, 70));
        salvarBtn.setMinimumSize(new java.awt.Dimension(110, 70));
        salvarBtn.setPreferredSize(new java.awt.Dimension(110, 70));
        salvarBtn.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        salvarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salvarBtnActionPerformed(evt);
            }
        });
        barraFerramentas.add(salvarBtn);

        copiarBtn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        copiarBtn.setForeground(new java.awt.Color(95, 94, 99));
        copiarBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/compilador/icons/copy-icon.png"))); // NOI18N
        copiarBtn.setText("copiar [ctrl-c]");
        copiarBtn.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        copiarBtn.setFocusPainted(false);
        copiarBtn.setFocusable(false);
        copiarBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        copiarBtn.setMaximumSize(new java.awt.Dimension(110, 70));
        copiarBtn.setMinimumSize(new java.awt.Dimension(110, 70));
        copiarBtn.setPreferredSize(new java.awt.Dimension(110, 70));
        copiarBtn.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        copiarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                copiarBtnActionPerformed(evt);
            }
        });
        barraFerramentas.add(copiarBtn);

        colarBtn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        colarBtn.setForeground(new java.awt.Color(95, 94, 99));
        colarBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/compilador/icons/paste-icon.png"))); // NOI18N
        colarBtn.setText("colar [ctrl-v]");
        colarBtn.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        colarBtn.setFocusPainted(false);
        colarBtn.setFocusable(false);
        colarBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        colarBtn.setMaximumSize(new java.awt.Dimension(110, 70));
        colarBtn.setMinimumSize(new java.awt.Dimension(110, 70));
        colarBtn.setPreferredSize(new java.awt.Dimension(110, 70));
        colarBtn.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        colarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                colarBtnActionPerformed(evt);
            }
        });
        barraFerramentas.add(colarBtn);

        recortarBtn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        recortarBtn.setForeground(new java.awt.Color(95, 94, 99));
        recortarBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/compilador/icons/cut-icon.png"))); // NOI18N
        recortarBtn.setText("recortar [ctrl-x]");
        recortarBtn.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        recortarBtn.setFocusPainted(false);
        recortarBtn.setFocusable(false);
        recortarBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        recortarBtn.setMaximumSize(new java.awt.Dimension(110, 70));
        recortarBtn.setMinimumSize(new java.awt.Dimension(110, 70));
        recortarBtn.setPreferredSize(new java.awt.Dimension(110, 70));
        recortarBtn.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        recortarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                recortarBtnActionPerformed(evt);
            }
        });
        barraFerramentas.add(recortarBtn);

        compilarBtn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        compilarBtn.setForeground(new java.awt.Color(95, 94, 99));
        compilarBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/compilador/icons/compile-icon.png"))); // NOI18N
        compilarBtn.setText("compilar [F7]");
        compilarBtn.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        compilarBtn.setFocusPainted(false);
        compilarBtn.setFocusable(false);
        compilarBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        compilarBtn.setMaximumSize(new java.awt.Dimension(110, 70));
        compilarBtn.setMinimumSize(new java.awt.Dimension(110, 70));
        compilarBtn.setPreferredSize(new java.awt.Dimension(110, 70));
        compilarBtn.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        compilarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                compilarBtnActionPerformed(evt);
            }
        });
        barraFerramentas.add(compilarBtn);

        equipeBtn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        equipeBtn.setForeground(new java.awt.Color(95, 94, 99));
        equipeBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/compilador/icons/equipe-icon.png"))); // NOI18N
        equipeBtn.setText("equipe [F1]");
        equipeBtn.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        equipeBtn.setFocusPainted(false);
        equipeBtn.setFocusable(false);
        equipeBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        equipeBtn.setMaximumSize(new java.awt.Dimension(110, 70));
        equipeBtn.setMinimumSize(new java.awt.Dimension(110, 70));
        equipeBtn.setPreferredSize(new java.awt.Dimension(110, 70));
        equipeBtn.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        equipeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                equipeBtnActionPerformed(evt);
            }
        });
        barraFerramentas.add(equipeBtn);

        barraStatus.setEnabled(false);
        barraStatus.setFocusable(false);
        barraStatus.setMinimumSize(new java.awt.Dimension(900, 25));
        barraStatus.setPreferredSize(new java.awt.Dimension(900, 25));
        barraStatus.setRequestFocusEnabled(false);
        barraStatus.add(arquivoLbl);

        splitPane.setDividerLocation(350);
        splitPane.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);
        splitPane.setContinuousLayout(false);
        splitPane.setMinimumSize(new java.awt.Dimension(910, 450));
        splitPane.setPreferredSize(new java.awt.Dimension(910, 493));

        editorPanel.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        editorPanel.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        editorTxtArea.setColumns(20);
        editorTxtArea.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
        editorTxtArea.setRows(5);
        editorTxtArea.setBorder(new NumberedBorder());
        editorPanel.setViewportView(editorTxtArea);

        splitPane.setTopComponent(editorPanel);

        mensagensPanel.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        mensagensPanel.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        mensagensTxtArea.setEditable(false);
        mensagensTxtArea.setBackground(new java.awt.Color(255, 255, 255));
        mensagensTxtArea.setColumns(20);
        mensagensTxtArea.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
        mensagensTxtArea.setLineWrap(true);
        mensagensTxtArea.setRows(5);
        mensagensTxtArea.setToolTipText("");
        mensagensTxtArea.setRequestFocusEnabled(false);
        mensagensPanel.setViewportView(mensagensTxtArea);

        splitPane.setRightComponent(mensagensPanel);

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(barraStatus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(splitPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(barraFerramentas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                .addComponent(barraFerramentas, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(splitPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(barraStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        Action equipeAction = new ButtonAction(equipeBtn, "Equipe Action");
        Action compilarAction = new ButtonAction(compilarBtn, "Compilar Action");
        Action abrirAction = new ButtonAction(abrirBtn, "Abrir Action");
        Action novoAction = new ButtonAction(novoBtn, "Novo Action");
        Action salvarAction = new ButtonAction(salvarBtn, "Salvar Action");

        bindAction(mainPanel, KeyStroke.getKeyStroke(KeyEvent.VK_F1, 0), equipeAction);
        bindAction(mainPanel, KeyStroke.getKeyStroke(KeyEvent.VK_F7, 0), compilarAction);
        bindAction(mainPanel, KeyStroke.getKeyStroke(KeyEvent.VK_O, KeyEvent.CTRL_DOWN_MASK), abrirAction);
        bindAction(mainPanel, KeyStroke.getKeyStroke(KeyEvent.VK_N, KeyEvent.CTRL_DOWN_MASK), novoAction);
        bindAction(mainPanel, KeyStroke.getKeyStroke(KeyEvent.VK_S, KeyEvent.CTRL_DOWN_MASK), salvarAction);

        pack();
    }
    
    private void abrirArquivo() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.showOpenDialog(null);
        
        if (fileChooser.getSelectedFile() != null) {
            File arquivo = fileChooser.getSelectedFile();
            String caminho = arquivo.getAbsolutePath();

            if (!caminho.endsWith(".txt")){
                JOptionPane.showMessageDialog(null, "Desculpe, são aceitos apenas arquivos texto (.txt).");

            } else {
                try {
                    mensagensTxtArea.setText("");
                    arquivoLbl.setText(caminho);
                    editorTxtArea.setText(lerArquivo(arquivo));
                } catch (IOException ex) {
                    Logger.getLogger(Frame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    private void salvarArquivo() {
        // Arquivo existente: altera conteúdo do arquivo de caminho especificado na barra de status
        File file = new File(arquivoLbl.getText());
        boolean nomeado = true;
        
        // Arquivo novo: seleção de diretório e nomeação
        if (arquivoLbl.getText().isEmpty()) {
            JFileChooser fileChooser = new JFileChooser();
            int retorno = fileChooser.showSaveDialog(null);
            
            if (retorno == JFileChooser.APPROVE_OPTION) {
                file = fileChooser.getSelectedFile();
               
                if (!isTxt(file))
                    file = new File(file + ".txt");
            } else {
                nomeado = false;
            }
        }

        // Escreve conteúdo do editor no arquivo
        if (nomeado) {
            try {
                FileWriter fw = new FileWriter(file);
                fw.write(editorTxtArea.getText());
                fw.close();

                mensagensTxtArea.setText("");
                arquivoLbl.setText(file.getAbsolutePath());
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
    
    private boolean isTxt(File file) {
        return file.getAbsolutePath().endsWith(".txt");
    }
    
    private void limparCampos() {
        editorTxtArea.setText("");
        mensagensTxtArea.setText("");
        arquivoLbl.setText("");
    }
    
    private String lerArquivo(File arquivo) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(arquivo));

        String arquivoToString = "";
        String linha;
        while ((linha = br.readLine()) != null) {
            arquivoToString += linha + "\n";
        }
        br.close();
        return arquivoToString;
    }
    
    private static void bindAction(JComponent component, KeyStroke keyStroke, Action action) {
        InputMap inputMap = component.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        ActionMap actionMap = component.getActionMap();
        
        inputMap.put(keyStroke, action.getValue(Action.NAME));
        actionMap.put(action.getValue(Action.NAME), action);
    }

    private void novoBtnActionPerformed(java.awt.event.ActionEvent evt) {
        limparCampos();
    }

    private void abrirBtnActionPerformed(java.awt.event.ActionEvent evt) {
        abrirArquivo();
    }
    
    private void salvarBtnActionPerformed(java.awt.event.ActionEvent evt) {
        salvarArquivo();
    }

    private void copiarBtnActionPerformed(java.awt.event.ActionEvent evt) {
        editorTxtArea.copy();
    }

    private void colarBtnActionPerformed(java.awt.event.ActionEvent evt) {
        editorTxtArea.paste();
    }

    private void recortarBtnActionPerformed(java.awt.event.ActionEvent evt) {
        editorTxtArea.cut();
    }

    private void equipeBtnActionPerformed(java.awt.event.ActionEvent evt) {
        mensagensTxtArea.setText("Equipe: Marlon Sbardelatti e Sofia Sousa Lindner");
    }

    private void indexarLinhas() {
        String[] linhasString = editorTxtArea.getText().split("\n");
        int ultimaPosicao = -1; // Posição anterior à do primeiro caracter da linha 1 no GALS, cujo índice é 0

        for (String s : linhasString) {
            ultimaPosicao += s.length() + 1; // Quebra de linha deve ser considerada (ocupa uma posição na contagem do GALS)
            linhas.add(ultimaPosicao);
        }
    }

    private String getClass(Token t) {
        int id = t.getId();
        if (id == 3) {
            return "identificador";
        } else if (id == 4) {
            return "constante_int";
        } else if (id == 5) {
            return "constante_float";
        } else if (id == 6) {
            return "constante_string";
        } else if (id >= 7 && id <= 19) {
            return "palavra reservada";
        } else if (id > 19 && id <= 35) {
            return "símbolo especial";
        }
        return "";
    }

    private int getLinha(int posicao) {
        /*  Se a posição inicial do token pertencer ao intervalo (for menor ou igual à última
            posição da linha), o número da linha é retornado
         */
        for (int i = 0; i < linhas.size(); i++) {
            if (posicao <= linhas.get(i))
                return i + 1; // Incrementa-se um porque a linha 1 é armazenada sob o índice 0
        }
        return 0;
    }

    private String getTokenInvalido(int posicao, String mensagemErro) {
        String sequencia = editorTxtArea.getText().substring(posicao);

        if (mensagemErro.equalsIgnoreCase("símbolo inválido")) {
            return Character.toString(sequencia.charAt(0));
        }
        sequencia = sequencia.replace(")", "");
        sequencia = sequencia.replace(";", "");
        sequencia = sequencia.split(" ")[0];
        sequencia = sequencia.split("\n")[0];
        return sequencia;
    }

    private String formatar(String string, int length) {
        // Retorna a string com o tamanho fixo passado, preenchida com espaços à direita
        return String.format("%-" + length + "s", string);
    }

    private String gerarListaDeTokens() {
        String lista = "";
        for (Token t : tokens) {
            // Para cada token, retorna-se a linha, classe e lexema, respectivamente
            lista +=    formatar(Integer.toString(getLinha(t.getPosition())), 10) +
                    formatar(getClass(t), 25) +
                    t.getLexeme() + "\n";
        }

        if (!lista.isEmpty())
            return formatar("linha", 10) + formatar("classe", 25) + "lexema\n" + lista + "\n";
        return "";
    }

    private String compilar() {
        Lexico lexico = new Lexico();
        Sintatico sintatico = new Sintatico();
        Semantico semantico = new Semantico();

        lexico.setInput(editorTxtArea.getText());

        String tokenInvalido = "";
        try {
            sintatico.parse(lexico, semantico, tokens);

        } catch (LexicalError e) {
            tokenInvalido = getTokenInvalido(e.getPosition(), e.getMessage()) + " ";
            if (tokenInvalido.startsWith("\"") || tokenInvalido.startsWith(">@"))
                tokenInvalido = "";

            return "Erro na linha " + getLinha(e.getPosition()) + " - " + tokenInvalido + e.getMessage();

        } catch (SyntaticError e) {
            tokenInvalido = sintatico.getLastToken().getLexeme();
            if (sintatico.getLastToken().getId() == 1) { // DOLLAR id
                tokenInvalido = "EOF";
            } else if (tokenInvalido.startsWith("\"")) {
                tokenInvalido = "constante_string";
            }

            return "Erro na linha " + getLinha(e.getPosition()) + " - encontrado " + tokenInvalido + "\n"
                    + e.getMessage().indent(18);

        } catch (SemanticError e) {
            return "Erro na linha " + getLinha(e.getPosition()) + " - " + e.getMessage();

            /* Uso de finally permite que a lista de tokens seja impressa mesmo em caso de exceções,
            * de modo a auxiliar no debugging do algoritmo */
        } finally {
            System.out.println(gerarListaDeTokens());
            System.out.println(semantico.getCodigoObjeto().getCodigo());
        }

        // Cria arquivo com código objeto compilado
        try {
            semantico.getCodigoObjeto().gerarArquivoIL(arquivoLbl.getText());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return "programa compilado com sucesso";
    }

    private void compilarBtnActionPerformed(java.awt.event.ActionEvent evt) {
        if (arquivoLbl.getText().isEmpty()) {
            int salvar = JOptionPane.showConfirmDialog(null, "Salvar arquivo?", "Salvar arquivo", JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE);
            if(salvar == JOptionPane.YES_OPTION){
                salvarArquivo();
                compilarBtnActionPerformed(evt);
            }
        } else {
            salvarArquivo();

            // Reinicializa listas de linhas e tokens para uma nova análise
            linhas = new ArrayList<>();
            tokens = new ArrayList<>();

            // Armazena intevalo de posições de cada linha de código
            indexarLinhas();

            // Imprime na área de mensagens o retorno do analisador léxico
            mensagensTxtArea.setText(compilar());
        }
    }

    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Frame().setVisible(true);
            }
        });
    }

    // Estruturas de dados auxiliares
    private ArrayList<Token> tokens = new ArrayList<Token>();
    private ArrayList<Integer> linhas = new ArrayList<Integer>();

    // Variáveis da interface
    private javax.swing.JButton abrirBtn;
    private javax.swing.JLabel arquivoLbl;
    private javax.swing.JToolBar barraFerramentas;
    private javax.swing.JToolBar barraStatus;
    private javax.swing.JButton colarBtn;
    private javax.swing.JButton compilarBtn;
    private javax.swing.JButton copiarBtn;
    private javax.swing.JScrollPane editorPanel;
    private javax.swing.JTextArea editorTxtArea;
    private javax.swing.JButton equipeBtn;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JScrollPane mensagensPanel;
    private javax.swing.JTextArea mensagensTxtArea;
    private javax.swing.JButton novoBtn;
    private javax.swing.JButton recortarBtn;
    private javax.swing.JButton salvarBtn;
    private javax.swing.JSplitPane splitPane;
}
