package proyecto;
import com.formdev.flatlaf.FlatLightLaf;
import java.awt.BorderLayout;
import proyecto.*;
import java.awt.CardLayout;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.io.File;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.plaf.basic.BasicButtonUI;


public class Menu extends javax.swing.JFrame {
    CardLayout cardLayout;
    GamePanel gamePanel;
    EditorPane editPanel;
    VolumenFrame volumen;
    ArrayList<Beatmap> beatmaps = new ArrayList<>();
    int indiceCentral = 0;
    int difChosen = -1;
    
    //canciones
    Marco izqPane;
    Marco midPane;
    Marco derPane;

    public Menu() {
        initComponents();
        setLocationRelativeTo(null);
        mainPane.add(menuPane, "menuPane");
        mainPane.add(songPane, "songPane");
        mainPane.add(songsPane, "songsPane");
        mainPane.add(gamePane, "gamePane");
        mainPane.add(editorPane, "editorPane");
        mainPane.add(editorChoosePane, "editorChoosePane");
        mainPane.add(loserPane, "loserPane");
        mainPane.add(winnerPane, "winnerPane");
        
        Component[] components = this.getContentPane().getComponents();
        for(Component component : components){
            if(component instanceof JButton){
                ((JButton) component).setUI(new BasicButtonUI());
                ((JButton) component).setFocusPainted(false);
            }
        }
        cardLayout = (CardLayout)(mainPane.getLayout());

        Component[] componentsSmall = menuPane.getComponents();
        for(Component component : componentsSmall){
            if(component instanceof JButton){
                ((JButton) component).setUI(new BasicButtonUI());
                ((JButton) component).setFocusPainted(false);
            }
        }
        
        jugarBot.addMouseListener(manejadorBot);
        editorBot.addMouseListener(manejadorBot);
        opcionBot.addMouseListener(manejadorBot);
        heartEasy1.addMouseListener(clickDifGame);
        heartMed1.addMouseListener(clickDifGame);
        heartHard1.addMouseListener(clickDifGame);
        easyBot1.addMouseListener(clickDifEditor);
        medBot1.addMouseListener(clickDifEditor);
        hardBot1.addMouseListener(clickDifEditor);
        mPane.addMouseListener(clickCancion);
        ManagerAudio.getInstancia().agregarSonidoBotones(this, "/proyecto/recursos/audio/click.wav","/proyecto/recursos/audio/hover.wav");
        ManagerAudio.getInstancia().playMusica("/proyecto/recursos/audio/menu.wav");
        setFocusable(true);
        requestFocusInWindow();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1024, 576);
        pack();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPane = new javax.swing.JPanel();
        menuPane = new proyecto.Fondo("/proyecto/recursos/imagenes/fondo_menu.png");
        layeredPane = new javax.swing.JLayeredPane();
        esquina = new javax.swing.JLabel();
        jugarBot = new javax.swing.JButton();
        opcionBot = new javax.swing.JButton();
        editorBot = new javax.swing.JButton();
        salirBot = new javax.swing.JButton();
        songPane = new proyecto.Fondo("/proyecto/recursos/imagenes/fondo_opciones.png");
        layerPane5 = new javax.swing.JLayeredPane();
        backBot4 = new javax.swing.JButton();
        marcoPane = new javax.swing.JPanel();
        cortinaPane1 = new proyecto.Fondo("/proyecto/recursos/imagenes/cortinas.png");
        heartEasy1 = new proyecto.Fondo("/proyecto/recursos/imagenes/heart_easy.png");
        easyLabel1 = new javax.swing.JLabel();
        heartMed1 = new proyecto.Fondo("/proyecto/recursos/imagenes/heart_med.png");
        medLabel1 = new javax.swing.JLabel();
        heartHard1 = new proyecto.Fondo("/proyecto/recursos/imagenes/heart_hard.png");
        hardLabel1 = new javax.swing.JLabel();
        playBot = new javax.swing.JButton();
        songsPane = new proyecto.Fondo("/proyecto/recursos/imagenes/fondo_opciones.png");
        layerPane1 = new javax.swing.JLayeredPane();
        backBot = new javax.swing.JButton();
        marcosPane = new javax.swing.JPanel();
        iPane = new javax.swing.JPanel();
        mPane = new javax.swing.JPanel();
        dPane = new javax.swing.JPanel();
        cortinaPane = new proyecto.Fondo("/proyecto/recursos/imagenes/cortinas.png");
        botIzq = new javax.swing.JButton();
        botDer = new javax.swing.JButton();
        infoLabel = new proyecto.Fondo("/proyecto/recursos/imagenes/cancion_info.png");
        artistLabel = new javax.swing.JLabel();
        songLabel = new javax.swing.JLabel();
        heartEasy = new proyecto.Fondo("/proyecto/recursos/imagenes/heart_easy.png");
        easyLabel = new javax.swing.JLabel();
        heartMed = new proyecto.Fondo("/proyecto/recursos/imagenes/heart_med.png");
        medLabel = new javax.swing.JLabel();
        heartHard = new proyecto.Fondo("/proyecto/recursos/imagenes/heart_hard.png");
        hardLabel = new javax.swing.JLabel();
        gamePane = new javax.swing.JPanel();
        loserPane = new proyecto.Fondo("/proyecto/loserScreen.png");
        puntoslose = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        winnerPane = new proyecto.Fondo("/proyecto/recursos/imagenes/fondo_editor.png");
        layerPane = new javax.swing.JLayeredPane();
        continuarBot = new javax.swing.JButton();
        accWin = new javax.swing.JLabel();
        gradoWin = new javax.swing.JLabel();
        gradoPane = new proyecto.Fondo("/proyecto/recursos/imagenes/soulGem.png");
        marcoPane1 = new proyecto.Fondo("/proyecto/recursos/imagenes/editor_marco.png");
        ventana1 = new proyecto.Fondo("/proyecto/recursos/imagenes/ventana.png");
        comboWin = new javax.swing.JLabel();
        goodWin = new javax.swing.JLabel();
        missWin = new javax.swing.JLabel();
        perfectWin = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        ventana2 = new proyecto.Fondo("/proyecto/recursos/imagenes/ventana.png");
        puntosWin = new javax.swing.JLabel();
        puntosWin1 = new javax.swing.JLabel();
        editorChoosePane = new proyecto.Fondo("/proyecto/recursos/imagenes/fondo_opciones.png");
        layerPane2 = new javax.swing.JLayeredPane();
        backBot1 = new javax.swing.JButton();
        cortinaPane2 = new proyecto.Fondo("/proyecto/recursos/imagenes/cortinas.png");
        crearBot = new javax.swing.JButton();
        botIzq1 = new javax.swing.JButton();
        botDer1 = new javax.swing.JButton();
        infoLabel1 = new proyecto.Fondo("/proyecto/recursos/imagenes/cancion_info.png");
        artistLabel1 = new javax.swing.JLabel();
        songLabel1 = new javax.swing.JLabel();
        easyBot1 = new proyecto.Fondo("/proyecto/recursos/imagenes/heart_easy.png");
        easyLabel2 = new javax.swing.JLabel();
        medBot1 = new proyecto.Fondo("/proyecto/recursos/imagenes/heart_med.png");
        medLabel2 = new javax.swing.JLabel();
        hardBot1 = new proyecto.Fondo("/proyecto/recursos/imagenes/heart_hard.png");
        hardLabel2 = new javax.swing.JLabel();
        editorPane = new proyecto.Fondo("/proyecto/recursos/imagenes/fondo_opciones.png");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Magical Rhythm");
        setMinimumSize(new java.awt.Dimension(1024, 576));
        setResizable(false);
        setSize(new java.awt.Dimension(1024, 576));

        mainPane.setLayout(new java.awt.CardLayout());

        menuPane.setMaximumSize(new java.awt.Dimension(1024, 576));
        menuPane.setMinimumSize(new java.awt.Dimension(1024, 576));
        menuPane.setPreferredSize(new java.awt.Dimension(1024, 576));

        layeredPane.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        esquina.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto/recursos/imagenes/esquina.png"))); // NOI18N
        layeredPane.setLayer(esquina, javax.swing.JLayeredPane.PALETTE_LAYER);
        layeredPane.add(esquina, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, -1, -1));

        jugarBot.setFont(new java.awt.Font("PixelMplus10", 0, 18)); // NOI18N
        jugarBot.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto/recursos/imagenes/boton_jugar_fondo.png"))); // NOI18N
        jugarBot.setBorderPainted(false);
        jugarBot.setContentAreaFilled(false);
        jugarBot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jugarBotActionPerformed(evt);
            }
        });
        layeredPane.add(jugarBot, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 290, 50));

        opcionBot.setFont(new java.awt.Font("PixelMplus10", 0, 18)); // NOI18N
        opcionBot.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto/recursos/imagenes/boton_opciones_fondo.png"))); // NOI18N
        opcionBot.setBorderPainted(false);
        opcionBot.setContentAreaFilled(false);
        opcionBot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opcionBotActionPerformed(evt);
            }
        });
        layeredPane.add(opcionBot, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 170, 290, 50));

        editorBot.setFont(new java.awt.Font("PixelMplus10", 0, 18)); // NOI18N
        editorBot.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto/recursos/imagenes/boton_editor_fondo.png"))); // NOI18N
        editorBot.setBorderPainted(false);
        editorBot.setContentAreaFilled(false);
        editorBot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editorBotActionPerformed(evt);
            }
        });
        layeredPane.add(editorBot, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 110, 290, 50));

        salirBot.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto/recursos/imagenes/salir.png"))); // NOI18N
        salirBot.setBorderPainted(false);
        salirBot.setContentAreaFilled(false);
        salirBot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirBotActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout menuPaneLayout = new javax.swing.GroupLayout(menuPane);
        menuPane.setLayout(menuPaneLayout);
        menuPaneLayout.setHorizontalGroup(
            menuPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuPaneLayout.createSequentialGroup()
                .addComponent(layeredPane, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 584, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, menuPaneLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(salirBot)
                .addGap(27, 27, 27))
        );
        menuPaneLayout.setVerticalGroup(
            menuPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, menuPaneLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(salirBot)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 254, Short.MAX_VALUE)
                .addComponent(layeredPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        mainPane.add(menuPane, "card3");

        songPane.setMaximumSize(new java.awt.Dimension(1024, 576));
        songPane.setMinimumSize(new java.awt.Dimension(1024, 576));
        songPane.setPreferredSize(new java.awt.Dimension(1024, 576));

        backBot4.setFont(new java.awt.Font("PixelMplus10", 0, 18)); // NOI18N
        backBot4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto/recursos/imagenes/back.png"))); // NOI18N
        backBot4.setBorderPainted(false);
        backBot4.setContentAreaFilled(false);
        backBot4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBot4ActionPerformed(evt);
            }
        });

        marcoPane.setOpaque(false);

        javax.swing.GroupLayout marcoPaneLayout = new javax.swing.GroupLayout(marcoPane);
        marcoPane.setLayout(marcoPaneLayout);
        marcoPaneLayout.setHorizontalGroup(
            marcoPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 270, Short.MAX_VALUE)
        );
        marcoPaneLayout.setVerticalGroup(
            marcoPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 266, Short.MAX_VALUE)
        );

        cortinaPane1.setOpaque(false);

        heartEasy1.setOpaque(false);

        easyLabel1.setFont(new java.awt.Font("Garamond", 1, 16)); // NOI18N
        easyLabel1.setForeground(new java.awt.Color(255, 241, 255));
        easyLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        easyLabel1.setText("4");

        javax.swing.GroupLayout heartEasy1Layout = new javax.swing.GroupLayout(heartEasy1);
        heartEasy1.setLayout(heartEasy1Layout);
        heartEasy1Layout.setHorizontalGroup(
            heartEasy1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(heartEasy1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(easyLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );
        heartEasy1Layout.setVerticalGroup(
            heartEasy1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(heartEasy1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(easyLabel1)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        heartMed1.setOpaque(false);

        medLabel1.setFont(new java.awt.Font("Garamond", 1, 16)); // NOI18N
        medLabel1.setForeground(new java.awt.Color(255, 241, 255));
        medLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        medLabel1.setText("4");

        javax.swing.GroupLayout heartMed1Layout = new javax.swing.GroupLayout(heartMed1);
        heartMed1.setLayout(heartMed1Layout);
        heartMed1Layout.setHorizontalGroup(
            heartMed1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(heartMed1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(medLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );
        heartMed1Layout.setVerticalGroup(
            heartMed1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(heartMed1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(medLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        heartHard1.setOpaque(false);

        hardLabel1.setFont(new java.awt.Font("Garamond", 1, 16)); // NOI18N
        hardLabel1.setForeground(new java.awt.Color(255, 241, 255));
        hardLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        hardLabel1.setText("4");

        javax.swing.GroupLayout heartHard1Layout = new javax.swing.GroupLayout(heartHard1);
        heartHard1.setLayout(heartHard1Layout);
        heartHard1Layout.setHorizontalGroup(
            heartHard1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(heartHard1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(hardLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );
        heartHard1Layout.setVerticalGroup(
            heartHard1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(heartHard1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(hardLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        playBot.setFont(new java.awt.Font("Garamond", 1, 18)); // NOI18N
        playBot.setText("Jugar");
        playBot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playBotActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout cortinaPane1Layout = new javax.swing.GroupLayout(cortinaPane1);
        cortinaPane1.setLayout(cortinaPane1Layout);
        cortinaPane1Layout.setHorizontalGroup(
            cortinaPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cortinaPane1Layout.createSequentialGroup()
                .addGroup(cortinaPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(cortinaPane1Layout.createSequentialGroup()
                        .addGap(402, 402, 402)
                        .addComponent(heartEasy1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(heartMed1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(heartHard1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(cortinaPane1Layout.createSequentialGroup()
                        .addGap(452, 452, 452)
                        .addComponent(playBot, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        cortinaPane1Layout.setVerticalGroup(
            cortinaPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, cortinaPane1Layout.createSequentialGroup()
                .addContainerGap(441, Short.MAX_VALUE)
                .addGroup(cortinaPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(heartMed1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(heartHard1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(heartEasy1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(playBot, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );

        layerPane5.setLayer(backBot4, javax.swing.JLayeredPane.MODAL_LAYER);
        layerPane5.setLayer(marcoPane, javax.swing.JLayeredPane.DRAG_LAYER);
        layerPane5.setLayer(cortinaPane1, javax.swing.JLayeredPane.PALETTE_LAYER);

        javax.swing.GroupLayout layerPane5Layout = new javax.swing.GroupLayout(layerPane5);
        layerPane5.setLayout(layerPane5Layout);
        layerPane5Layout.setHorizontalGroup(
            layerPane5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layerPane5Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(backBot4)
                .addContainerGap(956, Short.MAX_VALUE))
            .addComponent(cortinaPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layerPane5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layerPane5Layout.createSequentialGroup()
                    .addGap(357, 357, 357)
                    .addComponent(marcoPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(397, Short.MAX_VALUE)))
        );
        layerPane5Layout.setVerticalGroup(
            layerPane5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layerPane5Layout.createSequentialGroup()
                .addGroup(layerPane5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layerPane5Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(backBot4))
                    .addComponent(cortinaPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layerPane5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layerPane5Layout.createSequentialGroup()
                    .addGap(158, 158, 158)
                    .addComponent(marcoPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(158, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout songPaneLayout = new javax.swing.GroupLayout(songPane);
        songPane.setLayout(songPaneLayout);
        songPaneLayout.setHorizontalGroup(
            songPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(layerPane5)
        );
        songPaneLayout.setVerticalGroup(
            songPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, songPaneLayout.createSequentialGroup()
                .addComponent(layerPane5)
                .addContainerGap())
        );

        mainPane.add(songPane, "card2");

        songsPane.setMaximumSize(new java.awt.Dimension(1024, 576));
        songsPane.setMinimumSize(new java.awt.Dimension(1024, 576));
        songsPane.setPreferredSize(new java.awt.Dimension(1024, 576));

        layerPane1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        backBot.setFont(new java.awt.Font("PixelMplus10", 0, 18)); // NOI18N
        backBot.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto/recursos/imagenes/back.png"))); // NOI18N
        backBot.setBorderPainted(false);
        backBot.setContentAreaFilled(false);
        backBot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBotActionPerformed(evt);
            }
        });
        layerPane1.setLayer(backBot, javax.swing.JLayeredPane.MODAL_LAYER);
        layerPane1.add(backBot, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 60, -1));

        marcosPane.setOpaque(false);

        iPane.setOpaque(false);

        javax.swing.GroupLayout iPaneLayout = new javax.swing.GroupLayout(iPane);
        iPane.setLayout(iPaneLayout);
        iPaneLayout.setHorizontalGroup(
            iPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 265, Short.MAX_VALUE)
        );
        iPaneLayout.setVerticalGroup(
            iPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 255, Short.MAX_VALUE)
        );

        mPane.setOpaque(false);

        javax.swing.GroupLayout mPaneLayout = new javax.swing.GroupLayout(mPane);
        mPane.setLayout(mPaneLayout);
        mPaneLayout.setHorizontalGroup(
            mPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 265, Short.MAX_VALUE)
        );
        mPaneLayout.setVerticalGroup(
            mPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 255, Short.MAX_VALUE)
        );

        dPane.setOpaque(false);

        javax.swing.GroupLayout dPaneLayout = new javax.swing.GroupLayout(dPane);
        dPane.setLayout(dPaneLayout);
        dPaneLayout.setHorizontalGroup(
            dPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 265, Short.MAX_VALUE)
        );
        dPaneLayout.setVerticalGroup(
            dPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 255, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout marcosPaneLayout = new javax.swing.GroupLayout(marcosPane);
        marcosPane.setLayout(marcosPaneLayout);
        marcosPaneLayout.setHorizontalGroup(
            marcosPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(marcosPaneLayout.createSequentialGroup()
                .addComponent(iPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(mPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(dPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        marcosPaneLayout.setVerticalGroup(
            marcosPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(iPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(mPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(dPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        layerPane1.add(marcosPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(125, 145, 840, 270));

        cortinaPane.setOpaque(false);

        botIzq.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto/recursos/imagenes/flecha_izq.png"))); // NOI18N
        botIzq.setBorderPainted(false);
        botIzq.setContentAreaFilled(false);
        botIzq.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botIzqActionPerformed(evt);
            }
        });

        botDer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto/recursos/imagenes/flecha_der.png"))); // NOI18N
        botDer.setBorderPainted(false);
        botDer.setContentAreaFilled(false);
        botDer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botDerActionPerformed(evt);
            }
        });

        infoLabel.setOpaque(false);

        artistLabel.setFont(new java.awt.Font("Garamond", 0, 18)); // NOI18N
        artistLabel.setForeground(new java.awt.Color(58, 0, 68));
        artistLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        artistLabel.setText("xi");

        songLabel.setFont(new java.awt.Font("Garamond", 1, 18)); // NOI18N
        songLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        songLabel.setText("FREEDOM DiVE");

        heartEasy.setOpaque(false);

        easyLabel.setFont(new java.awt.Font("Garamond", 1, 16)); // NOI18N
        easyLabel.setForeground(new java.awt.Color(255, 241, 255));
        easyLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        easyLabel.setText("4");

        javax.swing.GroupLayout heartEasyLayout = new javax.swing.GroupLayout(heartEasy);
        heartEasy.setLayout(heartEasyLayout);
        heartEasyLayout.setHorizontalGroup(
            heartEasyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(heartEasyLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(easyLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );
        heartEasyLayout.setVerticalGroup(
            heartEasyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(heartEasyLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(easyLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        heartMed.setOpaque(false);

        medLabel.setFont(new java.awt.Font("Garamond", 1, 16)); // NOI18N
        medLabel.setForeground(new java.awt.Color(255, 241, 255));
        medLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        medLabel.setText("4");

        javax.swing.GroupLayout heartMedLayout = new javax.swing.GroupLayout(heartMed);
        heartMed.setLayout(heartMedLayout);
        heartMedLayout.setHorizontalGroup(
            heartMedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(heartMedLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(medLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );
        heartMedLayout.setVerticalGroup(
            heartMedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(heartMedLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(medLabel)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        heartHard.setOpaque(false);

        hardLabel.setFont(new java.awt.Font("Garamond", 1, 16)); // NOI18N
        hardLabel.setForeground(new java.awt.Color(255, 241, 255));
        hardLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        hardLabel.setText("4");

        javax.swing.GroupLayout heartHardLayout = new javax.swing.GroupLayout(heartHard);
        heartHard.setLayout(heartHardLayout);
        heartHardLayout.setHorizontalGroup(
            heartHardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(heartHardLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(hardLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );
        heartHardLayout.setVerticalGroup(
            heartHardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(heartHardLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(hardLabel)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout infoLabelLayout = new javax.swing.GroupLayout(infoLabel);
        infoLabel.setLayout(infoLabelLayout);
        infoLabelLayout.setHorizontalGroup(
            infoLabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(infoLabelLayout.createSequentialGroup()
                .addGroup(infoLabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(infoLabelLayout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(infoLabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(songLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 509, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(artistLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 509, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(infoLabelLayout.createSequentialGroup()
                        .addGap(197, 197, 197)
                        .addComponent(heartEasy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(heartMed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(heartHard, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(39, Short.MAX_VALUE))
        );
        infoLabelLayout.setVerticalGroup(
            infoLabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, infoLabelLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(songLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(artistLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(infoLabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(heartMed, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(heartHard, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(heartEasy, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(8, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout cortinaPaneLayout = new javax.swing.GroupLayout(cortinaPane);
        cortinaPane.setLayout(cortinaPaneLayout);
        cortinaPaneLayout.setHorizontalGroup(
            cortinaPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cortinaPaneLayout.createSequentialGroup()
                .addGap(118, 118, 118)
                .addComponent(botIzq)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(infoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botDer)
                .addContainerGap(117, Short.MAX_VALUE))
        );
        cortinaPaneLayout.setVerticalGroup(
            cortinaPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, cortinaPaneLayout.createSequentialGroup()
                .addContainerGap(422, Short.MAX_VALUE)
                .addGroup(cortinaPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, cortinaPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(infoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(cortinaPaneLayout.createSequentialGroup()
                            .addGap(20, 20, 20)
                            .addComponent(botDer)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, cortinaPaneLayout.createSequentialGroup()
                        .addComponent(botIzq)
                        .addGap(16, 16, 16)))
                .addGap(16, 16, 16))
        );

        layerPane1.setLayer(cortinaPane, javax.swing.JLayeredPane.PALETTE_LAYER);
        layerPane1.add(cortinaPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1030, 580));

        javax.swing.GroupLayout songsPaneLayout = new javax.swing.GroupLayout(songsPane);
        songsPane.setLayout(songsPaneLayout);
        songsPaneLayout.setHorizontalGroup(
            songsPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(layerPane1)
        );
        songsPaneLayout.setVerticalGroup(
            songsPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(layerPane1)
        );

        mainPane.add(songsPane, "card3");

        gamePane.setMaximumSize(new java.awt.Dimension(1024, 576));
        gamePane.setMinimumSize(new java.awt.Dimension(1024, 576));

        javax.swing.GroupLayout gamePaneLayout = new javax.swing.GroupLayout(gamePane);
        gamePane.setLayout(gamePaneLayout);
        gamePaneLayout.setHorizontalGroup(
            gamePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1024, Short.MAX_VALUE)
        );
        gamePaneLayout.setVerticalGroup(
            gamePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 580, Short.MAX_VALUE)
        );

        mainPane.add(gamePane, "card2");

        loserPane.setMaximumSize(new java.awt.Dimension(1024, 576));
        loserPane.setMinimumSize(new java.awt.Dimension(1024, 576));
        loserPane.setPreferredSize(new java.awt.Dimension(1024, 576));

        puntoslose.setFont(new java.awt.Font("PixelMplus10", 0, 24)); // NOI18N
        puntoslose.setForeground(new java.awt.Color(255, 255, 255));
        puntoslose.setText("000");

        jButton2.setFont(new java.awt.Font("PixelMplus10", 0, 18)); // NOI18N
        jButton2.setText("BACK");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout loserPaneLayout = new javax.swing.GroupLayout(loserPane);
        loserPane.setLayout(loserPaneLayout);
        loserPaneLayout.setHorizontalGroup(
            loserPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loserPaneLayout.createSequentialGroup()
                .addGroup(loserPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(loserPaneLayout.createSequentialGroup()
                        .addGap(789, 789, 789)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(loserPaneLayout.createSequentialGroup()
                        .addGap(273, 273, 273)
                        .addComponent(puntoslose, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        loserPaneLayout.setVerticalGroup(
            loserPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loserPaneLayout.createSequentialGroup()
                .addGap(308, 308, 308)
                .addComponent(puntoslose)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 156, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addGap(57, 57, 57))
        );

        mainPane.add(loserPane, "card9");

        winnerPane.setMaximumSize(new java.awt.Dimension(1024, 576));
        winnerPane.setMinimumSize(new java.awt.Dimension(1024, 576));

        layerPane.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        continuarBot.setFont(new java.awt.Font("PixelMplus10", 0, 18)); // NOI18N
        continuarBot.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto/recursos/imagenes/boton_continuar.png"))); // NOI18N
        continuarBot.setBorderPainted(false);
        continuarBot.setContentAreaFilled(false);
        continuarBot.setMaximumSize(new java.awt.Dimension(75, 28));
        continuarBot.setMinimumSize(new java.awt.Dimension(75, 28));
        continuarBot.setPreferredSize(new java.awt.Dimension(75, 28));
        continuarBot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                continuarBotActionPerformed(evt);
            }
        });
        layerPane.setLayer(continuarBot, javax.swing.JLayeredPane.MODAL_LAYER);
        layerPane.add(continuarBot, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 470, 300, 60));

        accWin.setFont(new java.awt.Font("Garamond", 1, 24)); // NOI18N
        accWin.setForeground(new java.awt.Color(253, 228, 253));
        accWin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        accWin.setText("000");
        layerPane.setLayer(accWin, javax.swing.JLayeredPane.PALETTE_LAYER);
        layerPane.add(accWin, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 350, 280, 30));

        gradoWin.setFont(new java.awt.Font("Garamond", 1, 48)); // NOI18N
        gradoWin.setForeground(new java.awt.Color(253, 228, 253));
        gradoWin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        gradoWin.setText("000");
        layerPane.setLayer(gradoWin, javax.swing.JLayeredPane.PALETTE_LAYER);
        layerPane.add(gradoWin, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 300, 220, 50));

        gradoPane.setOpaque(false);

        javax.swing.GroupLayout gradoPaneLayout = new javax.swing.GroupLayout(gradoPane);
        gradoPane.setLayout(gradoPaneLayout);
        gradoPaneLayout.setHorizontalGroup(
            gradoPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 280, Short.MAX_VALUE)
        );
        gradoPaneLayout.setVerticalGroup(
            gradoPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 479, Short.MAX_VALUE)
        );

        layerPane.add(gradoPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 90, 280, 479));

        marcoPane1.setOpaque(false);

        ventana1.setOpaque(false);

        comboWin.setFont(new java.awt.Font("Garamond", 1, 42)); // NOI18N
        comboWin.setForeground(new java.awt.Color(86, 0, 86));
        comboWin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        comboWin.setText("000");

        goodWin.setFont(new java.awt.Font("Garamond", 1, 24)); // NOI18N
        goodWin.setForeground(new java.awt.Color(86, 0, 86));
        goodWin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        goodWin.setText("000");

        missWin.setFont(new java.awt.Font("Garamond", 1, 24)); // NOI18N
        missWin.setForeground(new java.awt.Color(86, 0, 86));
        missWin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        missWin.setText("000");

        perfectWin.setFont(new java.awt.Font("Garamond", 1, 24)); // NOI18N
        perfectWin.setForeground(new java.awt.Color(86, 0, 86));
        perfectWin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        perfectWin.setText("000");

        jLabel1.setFont(new java.awt.Font("Garamond", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Perfecto");

        jLabel2.setFont(new java.awt.Font("Garamond", 1, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Bien");

        jLabel3.setFont(new java.awt.Font("Garamond", 1, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Miss");

        jLabel4.setFont(new java.awt.Font("Garamond", 1, 18)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Max Combo");

        javax.swing.GroupLayout ventana1Layout = new javax.swing.GroupLayout(ventana1);
        ventana1.setLayout(ventana1Layout);
        ventana1Layout.setHorizontalGroup(
            ventana1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ventana1Layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addGroup(ventana1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(ventana1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(ventana1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(ventana1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(goodWin, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                            .addComponent(missWin, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(perfectWin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(comboWin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(66, Short.MAX_VALUE))
        );
        ventana1Layout.setVerticalGroup(
            ventana1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ventana1Layout.createSequentialGroup()
                .addContainerGap(248, Short.MAX_VALUE)
                .addComponent(comboWin)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(ventana1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(perfectWin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ventana1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(goodWin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ventana1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(missWin)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(82, 82, 82))
        );

        ventana2.setOpaque(false);

        puntosWin.setFont(new java.awt.Font("Garamond", 1, 42)); // NOI18N
        puntosWin.setForeground(new java.awt.Color(86, 0, 86));
        puntosWin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        puntosWin.setText("000");

        puntosWin1.setFont(new java.awt.Font("Garamond", 1, 24)); // NOI18N
        puntosWin1.setForeground(new java.awt.Color(86, 0, 86));
        puntosWin1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        puntosWin1.setText("Puntos");

        javax.swing.GroupLayout ventana2Layout = new javax.swing.GroupLayout(ventana2);
        ventana2.setLayout(ventana2Layout);
        ventana2Layout.setHorizontalGroup(
            ventana2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ventana2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(ventana2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(puntosWin, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(puntosWin1, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        ventana2Layout.setVerticalGroup(
            ventana2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ventana2Layout.createSequentialGroup()
                .addContainerGap(321, Short.MAX_VALUE)
                .addComponent(puntosWin)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(puntosWin1)
                .addGap(111, 111, 111))
        );

        javax.swing.GroupLayout marcoPane1Layout = new javax.swing.GroupLayout(marcoPane1);
        marcoPane1.setLayout(marcoPane1Layout);
        marcoPane1Layout.setHorizontalGroup(
            marcoPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(marcoPane1Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(ventana1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 335, Short.MAX_VALUE)
                .addComponent(ventana2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39))
        );
        marcoPane1Layout.setVerticalGroup(
            marcoPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, marcoPane1Layout.createSequentialGroup()
                .addContainerGap(34, Short.MAX_VALUE)
                .addGroup(marcoPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(ventana2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ventana1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(31, 31, 31))
        );

        layerPane.setLayer(marcoPane1, javax.swing.JLayeredPane.PALETTE_LAYER);
        layerPane.add(marcoPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1030, 580));

        javax.swing.GroupLayout winnerPaneLayout = new javax.swing.GroupLayout(winnerPane);
        winnerPane.setLayout(winnerPaneLayout);
        winnerPaneLayout.setHorizontalGroup(
            winnerPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(layerPane)
        );
        winnerPaneLayout.setVerticalGroup(
            winnerPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, winnerPaneLayout.createSequentialGroup()
                .addComponent(layerPane)
                .addContainerGap())
        );

        mainPane.add(winnerPane, "card10");

        editorChoosePane.setMaximumSize(new java.awt.Dimension(1024, 576));
        editorChoosePane.setMinimumSize(new java.awt.Dimension(1024, 576));

        layerPane2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        backBot1.setFont(new java.awt.Font("PixelMplus10", 0, 18)); // NOI18N
        backBot1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto/recursos/imagenes/back.png"))); // NOI18N
        backBot1.setBorderPainted(false);
        backBot1.setContentAreaFilled(false);
        backBot1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBot1ActionPerformed(evt);
            }
        });
        layerPane2.setLayer(backBot1, javax.swing.JLayeredPane.MODAL_LAYER);
        layerPane2.add(backBot1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 60, -1));

        cortinaPane2.setOpaque(false);

        crearBot.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto/recursos/imagenes/boton_crear.png"))); // NOI18N
        crearBot.setBorderPainted(false);
        crearBot.setContentAreaFilled(false);
        crearBot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                crearBotActionPerformed(evt);
            }
        });

        botIzq1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto/recursos/imagenes/flecha_izq.png"))); // NOI18N
        botIzq1.setBorderPainted(false);
        botIzq1.setContentAreaFilled(false);
        botIzq1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botIzq1ActionPerformed(evt);
            }
        });

        botDer1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto/recursos/imagenes/flecha_der.png"))); // NOI18N
        botDer1.setBorderPainted(false);
        botDer1.setContentAreaFilled(false);
        botDer1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botDer1ActionPerformed(evt);
            }
        });

        infoLabel1.setOpaque(false);

        artistLabel1.setFont(new java.awt.Font("Garamond", 0, 18)); // NOI18N
        artistLabel1.setForeground(new java.awt.Color(58, 0, 68));
        artistLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        artistLabel1.setText("xi");

        songLabel1.setFont(new java.awt.Font("Garamond", 1, 18)); // NOI18N
        songLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        songLabel1.setText("FREEDOM DiVE");

        easyBot1.setOpaque(false);

        easyLabel2.setFont(new java.awt.Font("Garamond", 1, 14)); // NOI18N
        easyLabel2.setForeground(new java.awt.Color(255, 241, 255));
        easyLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        easyLabel2.setText("4");

        javax.swing.GroupLayout easyBot1Layout = new javax.swing.GroupLayout(easyBot1);
        easyBot1.setLayout(easyBot1Layout);
        easyBot1Layout.setHorizontalGroup(
            easyBot1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(easyBot1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(easyLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );
        easyBot1Layout.setVerticalGroup(
            easyBot1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(easyBot1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(easyLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        medBot1.setOpaque(false);

        medLabel2.setFont(new java.awt.Font("Garamond", 1, 14)); // NOI18N
        medLabel2.setForeground(new java.awt.Color(255, 241, 255));
        medLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        medLabel2.setText("4");

        javax.swing.GroupLayout medBot1Layout = new javax.swing.GroupLayout(medBot1);
        medBot1.setLayout(medBot1Layout);
        medBot1Layout.setHorizontalGroup(
            medBot1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(medBot1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(medLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );
        medBot1Layout.setVerticalGroup(
            medBot1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(medBot1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(medLabel2)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        hardBot1.setOpaque(false);

        hardLabel2.setFont(new java.awt.Font("Garamond", 1, 14)); // NOI18N
        hardLabel2.setForeground(new java.awt.Color(255, 241, 255));
        hardLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        hardLabel2.setText("4");

        javax.swing.GroupLayout hardBot1Layout = new javax.swing.GroupLayout(hardBot1);
        hardBot1.setLayout(hardBot1Layout);
        hardBot1Layout.setHorizontalGroup(
            hardBot1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(hardBot1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(hardLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );
        hardBot1Layout.setVerticalGroup(
            hardBot1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(hardBot1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(hardLabel2)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout infoLabel1Layout = new javax.swing.GroupLayout(infoLabel1);
        infoLabel1.setLayout(infoLabel1Layout);
        infoLabel1Layout.setHorizontalGroup(
            infoLabel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(infoLabel1Layout.createSequentialGroup()
                .addGroup(infoLabel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(infoLabel1Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(infoLabel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(songLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 509, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(artistLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 509, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(infoLabel1Layout.createSequentialGroup()
                        .addGap(197, 197, 197)
                        .addComponent(easyBot1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(medBot1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(hardBot1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(39, Short.MAX_VALUE))
        );
        infoLabel1Layout.setVerticalGroup(
            infoLabel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, infoLabel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(songLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(artistLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(infoLabel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(medBot1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(hardBot1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(easyBot1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(8, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout cortinaPane2Layout = new javax.swing.GroupLayout(cortinaPane2);
        cortinaPane2.setLayout(cortinaPane2Layout);
        cortinaPane2Layout.setHorizontalGroup(
            cortinaPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cortinaPane2Layout.createSequentialGroup()
                .addGroup(cortinaPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(cortinaPane2Layout.createSequentialGroup()
                        .addGap(369, 369, 369)
                        .addComponent(crearBot, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(cortinaPane2Layout.createSequentialGroup()
                        .addGap(115, 115, 115)
                        .addComponent(botIzq1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(infoLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botDer1)))
                .addContainerGap(120, Short.MAX_VALUE))
        );
        cortinaPane2Layout.setVerticalGroup(
            cortinaPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, cortinaPane2Layout.createSequentialGroup()
                .addGap(81, 81, 81)
                .addComponent(crearBot, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(123, 123, 123)
                .addGroup(cortinaPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, cortinaPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(infoLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(cortinaPane2Layout.createSequentialGroup()
                            .addGap(20, 20, 20)
                            .addComponent(botDer1)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, cortinaPane2Layout.createSequentialGroup()
                        .addComponent(botIzq1)
                        .addGap(16, 16, 16)))
                .addContainerGap(178, Short.MAX_VALUE))
        );

        layerPane2.setLayer(cortinaPane2, javax.swing.JLayeredPane.PALETTE_LAYER);
        layerPane2.add(cortinaPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1030, 580));

        javax.swing.GroupLayout editorChoosePaneLayout = new javax.swing.GroupLayout(editorChoosePane);
        editorChoosePane.setLayout(editorChoosePaneLayout);
        editorChoosePaneLayout.setHorizontalGroup(
            editorChoosePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(layerPane2)
        );
        editorChoosePaneLayout.setVerticalGroup(
            editorChoosePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(layerPane2)
        );

        mainPane.add(editorChoosePane, "card3");

        editorPane.setMaximumSize(new java.awt.Dimension(1024, 576));
        editorPane.setMinimumSize(new java.awt.Dimension(1024, 576));

        javax.swing.GroupLayout editorPaneLayout = new javax.swing.GroupLayout(editorPane);
        editorPane.setLayout(editorPaneLayout);
        editorPaneLayout.setHorizontalGroup(
            editorPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1024, Short.MAX_VALUE)
        );
        editorPaneLayout.setVerticalGroup(
            editorPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 580, Short.MAX_VALUE)
        );

        mainPane.add(editorPane, "card3");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPane, javax.swing.GroupLayout.DEFAULT_SIZE, 1024, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPane, javax.swing.GroupLayout.PREFERRED_SIZE, 576, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void backBotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBotActionPerformed
        cardLayout.show(mainPane, "menuPane");
        ManagerAudio.getInstancia().stopPreview();
        ManagerAudio.getInstancia().parar();
        ManagerAudio.getInstancia().playMusica("/proyecto/recursos/audio/menu.wav");
    }//GEN-LAST:event_backBotActionPerformed

    private void playBotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_playBotActionPerformed
        if(difChosen==-1) return;
        gamePane.removeAll();
        gamePanel = new GamePanel(beatmaps.get(wrap(indiceCentral)),difChosen,this);
        gamePane.setLayout(new BorderLayout());
        gamePane.add(gamePanel, BorderLayout.CENTER);
        gamePane.revalidate();
        gamePane.repaint();
        cardLayout.show(mainPane, "gamePane");
        ManagerAudio.getInstancia().parar();
        ManagerAudio.getInstancia().stopPreview();
    }//GEN-LAST:event_playBotActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        cardLayout.show(mainPane, "menuPane");
        ManagerAudio.getInstancia().parar();
        ManagerAudio.getInstancia().playMusica("/proyecto/recursos/audio/menu.wav");
    }//GEN-LAST:event_jButton2ActionPerformed

    private void continuarBotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_continuarBotActionPerformed
        cardLayout.show(mainPane, "menuPane");
        ManagerAudio.getInstancia().parar();
        ManagerAudio.getInstancia().playMusica("/proyecto/recursos/audio/menu.wav");
    }//GEN-LAST:event_continuarBotActionPerformed

    private void opcionBotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opcionBotActionPerformed
        volumen = new VolumenFrame(this);
        volumen.setVisible(true);
        ManagerAudio.getInstancia().playSonido("/proyecto/recursos/audio/info.wav");
    }//GEN-LAST:event_opcionBotActionPerformed

    private void jugarBotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jugarBotActionPerformed
        ManagerAudio.getInstancia().parar();
        cardLayout.show(mainPane, "songsPane");
        iPane.removeAll();
        mPane.removeAll();
        dPane.removeAll();
        izqPane = new Marco();
        derPane = new Marco();
        midPane = new Marco();
        iPane.setLayout(new BorderLayout());
        iPane.add(izqPane, BorderLayout.CENTER);
        iPane.revalidate();
        iPane.repaint();
        mPane.setLayout(new BorderLayout());
        mPane.add(midPane, BorderLayout.CENTER);
        mPane.revalidate();
        mPane.repaint();
        dPane.setLayout(new BorderLayout());
        dPane.add(derPane, BorderLayout.CENTER);
        dPane.revalidate();
        dPane.repaint();

        cargarBeatmaps();
        indiceCentral = 0;
        actualizarCarrusel();
    }//GEN-LAST:event_jugarBotActionPerformed

    private void editorBotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editorBotActionPerformed
        ManagerAudio.getInstancia().parar();
        cardLayout.show(mainPane, "editorChoosePane");
        cargarBeatmapsEditor();
        indiceCentral = 0;
        actualizarCarruselEditor();
    }//GEN-LAST:event_editorBotActionPerformed

    private void salirBotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirBotActionPerformed
        int res = JOptionPane.showConfirmDialog(null,"¿Deseas salir?", "Confirmación", JOptionPane.YES_NO_OPTION);
        if(res==JOptionPane.YES_OPTION){
            System.exit(0);
        }
    }//GEN-LAST:event_salirBotActionPerformed

    private void botDerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botDerActionPerformed
        indiceCentral = wrap(indiceCentral + 1);
        actualizarCarrusel();
    }//GEN-LAST:event_botDerActionPerformed

    private void botIzqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botIzqActionPerformed
        indiceCentral = wrap(indiceCentral - 1);
        actualizarCarrusel();
    }//GEN-LAST:event_botIzqActionPerformed

    private void backBot4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBot4ActionPerformed
        ManagerAudio.getInstancia().parar();
        cardLayout.show(mainPane, "songsPane");
    }//GEN-LAST:event_backBot4ActionPerformed

    private void backBot1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBot1ActionPerformed
        cardLayout.show(mainPane, "menuPane");
        ManagerAudio.getInstancia().parar();
        ManagerAudio.getInstancia().stopPreview();
        ManagerAudio.getInstancia().playMusica("/proyecto/recursos/audio/menu.wav");
    }//GEN-LAST:event_backBot1ActionPerformed

    private void botIzq1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botIzq1ActionPerformed
        indiceCentral = wrap(indiceCentral - 1);
        actualizarCarruselEditor();
    }//GEN-LAST:event_botIzq1ActionPerformed

    private void botDer1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botDer1ActionPerformed
        indiceCentral = wrap(indiceCentral + 1);
        actualizarCarruselEditor();
    }//GEN-LAST:event_botDer1ActionPerformed

    private void crearBotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_crearBotActionPerformed
        editorPane.removeAll();
        editPanel = new EditorPane(new Beatmap(),-1,this);
        editorPane.setLayout(new BorderLayout());
        editorPane.add(editPanel, BorderLayout.CENTER);
        editorPane.revalidate();
        editorPane.repaint();
        cardLayout.show(mainPane, "editorPane");
        ManagerAudio.getInstancia().parar();
        ManagerAudio.getInstancia().stopPreview();
    }//GEN-LAST:event_crearBotActionPerformed
    MouseAdapter manejadorBot = new MouseAdapter(){
        @Override
        public void mouseEntered(java.awt.event.MouseEvent evt) { 
            javax.swing.JComponent boton = (javax.swing.JComponent) evt.getSource();    

            int inicio = boton.getX();
            int[] posBot = {inicio};

            Timer timer = new Timer(5, e -> {
                posBot[0]++;
                boton.setLocation(posBot[0], boton.getY());

                if (posBot[0] >= inicio + 20) {
                    ((Timer) e.getSource()).stop();
                }
            });
            timer.start();
        }
        @Override
        public void mouseExited(java.awt.event.MouseEvent evt) {
            javax.swing.JComponent boton = (javax.swing.JComponent) evt.getSource();                               
            int inicio = boton.getX();
            int[] posBot = {inicio};

            Timer timer = new Timer(5, e -> {
                posBot[0]--;
                boton.setLocation(posBot[0], boton.getY());

                if (posBot[0] <= inicio - 20) {
                    ((Timer) e.getSource()).stop();
                }
            });
            timer.start();
        }
    };
    MouseAdapter clickCancion = new MouseAdapter(){
        @Override
        public void mouseClicked(java.awt.event.MouseEvent evt) { 
            cardLayout.show(mainPane, "songPane");
            Beatmap beatmap = beatmaps.get(wrap(indiceCentral));
            marcoPane.removeAll();
            Marco marco = new Marco();
            marco.setBeatmap(beatmap);
            marcoPane.setLayout(new BorderLayout());
            marcoPane.add(marco, BorderLayout.CENTER);
            marcoPane.revalidate();
            marcoPane.repaint();
            //dif
            heartEasy1.setVisible(false);
            heartMed1.setVisible(false);
            heartHard1.setVisible(false);
            for(int i=0;i<beatmap.getDifficulty().size();i++){
                if(beatmap.getDifficulty().get(i)!=null){
                    String dif = beatmap.getDifficulty().get(i).getDifficulty();
                    if(dif.equals("Easy")){
                        easyLabel1.setText(String.valueOf(beatmap.getDifficulty().get(i).getDifficultyValue()));
                        heartEasy1.setVisible(true);
                    }else if(dif.equals("Normal")){
                        medLabel1.setText(String.valueOf(beatmap.getDifficulty().get(i).getDifficultyValue()));
                        heartMed1.setVisible(true);
                    }else if(dif.equals("Hard")){
                        hardLabel1.setText(String.valueOf(beatmap.getDifficulty().get(i).getDifficultyValue()));
                        heartHard1.setVisible(true);
                    }
                }
            }
        }
    };
    MouseAdapter clickDifGame = new MouseAdapter(){
        @Override
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            JPanel bot = (JPanel) evt.getSource();
            int dif = -1;
            Component comp = bot.getComponent(0);
            if (comp instanceof JLabel) {
               dif = Integer.parseInt(((JLabel) comp).getText());
            }
            difChosen = getIndex(dif,beatmaps.get(wrap(indiceCentral)));
        }
    };
    MouseAdapter clickDifEditor = new MouseAdapter(){
        @Override
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            JPanel bot = (JPanel) evt.getSource();
            int dif = -1;
            Component comp = bot.getComponent(0);
            if (comp instanceof JLabel) {
               dif = Integer.parseInt(((JLabel) comp).getText());
            }
            
            crearEditor(getIndex(dif,beatmaps.get(wrap(indiceCentral))));
        }
    };

    public void crearEditor(int dif){
        if(dif==-1) return;
        editorPane.removeAll();
        editPanel = new EditorPane(beatmaps.get(wrap(indiceCentral)),dif,this);
        editorPane.setLayout(new BorderLayout());
        editorPane.add(editPanel, BorderLayout.CENTER);
        editorPane.revalidate();
        editorPane.repaint();
        cardLayout.show(mainPane, "editorPane");
        ManagerAudio.getInstancia().stopPreview();
    }
    private void cargarBeatmaps(){
        beatmaps = new ArrayList<>();
        File carpeta = new File("src/proyecto/canciones");
        
        for(File folder : carpeta.listFiles()){
            if(folder.isDirectory()){
                Beatmap beatmap = BeatmapLoader.cargar(folder);
                if(beatmap.getMetadata().getStatus().equals("Published"))
                    beatmaps.add(beatmap);
            }
        }
    }
    private void cargarBeatmapsEditor(){
        beatmaps = new ArrayList<>();
        File carpeta = new File("src/proyecto/canciones");
        
        for(File folder : carpeta.listFiles()){
            if(folder.isDirectory()){
                Beatmap beatmap = BeatmapLoader.cargar(folder);
                beatmaps.add(beatmap);
            }
        }
    }
    private int wrap(int index){
        return (index + beatmaps.size()) % beatmaps.size();
    }
    private void actualizarCarrusel(){
        int total = beatmaps.size();
        if(total == 0){
            return;
        }
        if(total == 1){
            midPane.setVisible(true);
            mPane.setVisible(true);
            midPane.setBeatmap(beatmaps.get(0));
            izqPane.setVisible(false);
            iPane.setVisible(false);
            derPane.setVisible(false);
            dPane.setVisible(false);
        }else{
            izqPane.setBeatmap(beatmaps.get(wrap(indiceCentral - 1)));
            midPane.setBeatmap(beatmaps.get(wrap(indiceCentral)));
            derPane.setBeatmap(beatmaps.get(wrap(indiceCentral + 1)));
        }
        actualizarInfo(beatmaps.get(wrap(indiceCentral)));
    }
    private void actualizarCarruselEditor(){
        int total = beatmaps.size();
        if(total == 0){
            songLabel1.setText("No hay mapas...");
            artistLabel1.setText("");
            easyBot1.setVisible(false);
            medBot1.setVisible(false);
            hardBot1.setVisible(false);
            return;
        }
        actualizarInfoEditor(beatmaps.get(wrap(indiceCentral)));
    }
    private void actualizarInfo(Beatmap beatmap){
        songLabel.setText(beatmap.getMetadata().getTitle());
        artistLabel.setText(beatmap.getMetadata().getArtist());
        ManagerAudio.getInstancia().stopPreview();
        ManagerAudio.getInstancia().playPreview("/proyecto/canciones/"+beatmap.getGeneral().getFolderName()+
                "/"+beatmap.getGeneral().getAudioFileName(), beatmap.getMetadata().getPreviewStart());
        heartEasy.setVisible(false);
        heartMed.setVisible(false);
        heartHard.setVisible(false);
        for(int i=0;i<beatmap.getDifficulty().size();i++){
            if(beatmap.getDifficulty().get(i)!=null){
                String dif = beatmap.getDifficulty().get(i).getDifficulty();
                if(dif.equals("Easy")){
                    easyLabel.setText(String.valueOf(beatmap.getDifficulty().get(i).getDifficultyValue()));
                    heartEasy.setVisible(true);
                }else if(dif.equals("Normal")){
                    medLabel.setText(String.valueOf(beatmap.getDifficulty().get(i).getDifficultyValue()));
                    heartMed.setVisible(true);
                }else if(dif.equals("Hard")){
                    hardLabel.setText(String.valueOf(beatmap.getDifficulty().get(i).getDifficultyValue()));
                    heartHard.setVisible(true);
                }
            }
        }
    }
    private void actualizarInfoEditor(Beatmap beatmap){
        songLabel1.setText(beatmap.getMetadata().getTitle());
        artistLabel1.setText(beatmap.getMetadata().getArtist());
        ManagerAudio.getInstancia().stopPreview();
        ManagerAudio.getInstancia().playPreview("/proyecto/canciones/"+beatmap.getGeneral().getFolderName()+
                "/"+beatmap.getGeneral().getAudioFileName(), beatmap.getMetadata().getPreviewStart());
        easyBot1.setVisible(false);
        medBot1.setVisible(false);
        hardBot1.setVisible(false);
        for(int i=0;i<beatmap.getDifficulty().size();i++){
            if(beatmap.getDifficulty().get(i)!=null){
                String dif = beatmap.getDifficulty().get(i).getDifficulty();
                if(dif.equals("Easy")){
                    easyLabel2.setText(String.valueOf(beatmap.getDifficulty().get(i).getDifficultyValue()));
                    easyBot1.setVisible(true);
                }else if(dif.equals("Normal")){
                    medLabel2.setText(String.valueOf(beatmap.getDifficulty().get(i).getDifficultyValue()));
                    medBot1.setVisible(true);
                }else if(dif.equals("Hard")){
                    hardLabel2.setText(String.valueOf(beatmap.getDifficulty().get(i).getDifficultyValue()));
                    hardBot1.setVisible(true);
                }
            }
        }
    }
    private int getIndex(int dif, Beatmap beatmap){
        for(int i=0;i<beatmap.getDifficulty().size();i++){
            if(beatmap.getDifficulty().get(i).getDifficultyValue()==dif){
                return i;
            }
        }
        return -1;
    }
    
    public void finalizar(ManagerPuntaje puntaje){
        double acc = puntaje.getAcc();
        accWin.setText(String.format("%.2f", acc)+"% ACC");
        puntosWin.setText(String.valueOf(puntaje.getPuntaje()));
        gradoWin.setText(puntaje.getGrado());
        goodWin.setText(String.valueOf(puntaje.getPerfect()));
        missWin.setText(String.valueOf(puntaje.getBien()));
        perfectWin.setText(String.valueOf(puntaje.getMiss()));
        comboWin.setText(String.valueOf(puntaje.getMaxCombo()));
        cardLayout.show(mainPane, "winnerPane");
        ManagerAudio.getInstancia().parar();
        ManagerAudio.getInstancia().playMusica("/proyecto/recursos/audio/win.wav");
    }
    public void salirJuego(){
        ManagerAudio.getInstancia().pausarMusica();
        cardLayout.show(mainPane, "songsPane");
    }
    public void showMenu(){
        cardLayout.show(mainPane, "editorChoosePane");
        ManagerAudio.getInstancia().stopPreview();             
    }
    ///////////////////////////////////////////////////////////////////////
    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    FlatLightLaf.registerCustomDefaultsSource( "proyecto.recursos" );
                    UIManager.setLookAndFeel( new FlatLightLaf() );
                } catch( Exception ex ) {
                    System.err.println( "Failed to initialize Look and Feel" );
                }
                
                new Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel accWin;
    private javax.swing.JLabel artistLabel;
    private javax.swing.JLabel artistLabel1;
    private javax.swing.JButton backBot;
    private javax.swing.JButton backBot1;
    private javax.swing.JButton backBot4;
    private javax.swing.JButton botDer;
    private javax.swing.JButton botDer1;
    private javax.swing.JButton botIzq;
    private javax.swing.JButton botIzq1;
    private javax.swing.JLabel comboWin;
    private javax.swing.JButton continuarBot;
    private javax.swing.JPanel cortinaPane;
    private javax.swing.JPanel cortinaPane1;
    private javax.swing.JPanel cortinaPane2;
    private javax.swing.JButton crearBot;
    private javax.swing.JPanel dPane;
    private javax.swing.JPanel easyBot1;
    private javax.swing.JLabel easyLabel;
    private javax.swing.JLabel easyLabel1;
    private javax.swing.JLabel easyLabel2;
    private javax.swing.JButton editorBot;
    private javax.swing.JPanel editorChoosePane;
    private javax.swing.JPanel editorPane;
    private javax.swing.JLabel esquina;
    private javax.swing.JPanel gamePane;
    private javax.swing.JLabel goodWin;
    private javax.swing.JPanel gradoPane;
    private javax.swing.JLabel gradoWin;
    private javax.swing.JPanel hardBot1;
    private javax.swing.JLabel hardLabel;
    private javax.swing.JLabel hardLabel1;
    private javax.swing.JLabel hardLabel2;
    private javax.swing.JPanel heartEasy;
    private javax.swing.JPanel heartEasy1;
    private javax.swing.JPanel heartHard;
    private javax.swing.JPanel heartHard1;
    private javax.swing.JPanel heartMed;
    private javax.swing.JPanel heartMed1;
    private javax.swing.JPanel iPane;
    private javax.swing.JPanel infoLabel;
    private javax.swing.JPanel infoLabel1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JButton jugarBot;
    private javax.swing.JLayeredPane layerPane;
    private javax.swing.JLayeredPane layerPane1;
    private javax.swing.JLayeredPane layerPane2;
    private javax.swing.JLayeredPane layerPane5;
    private javax.swing.JLayeredPane layeredPane;
    private javax.swing.JPanel loserPane;
    private javax.swing.JPanel mPane;
    private javax.swing.JPanel mainPane;
    private javax.swing.JPanel marcoPane;
    private javax.swing.JPanel marcoPane1;
    private javax.swing.JPanel marcosPane;
    private javax.swing.JPanel medBot1;
    private javax.swing.JLabel medLabel;
    private javax.swing.JLabel medLabel1;
    private javax.swing.JLabel medLabel2;
    private javax.swing.JPanel menuPane;
    private javax.swing.JLabel missWin;
    private javax.swing.JButton opcionBot;
    private javax.swing.JLabel perfectWin;
    private javax.swing.JButton playBot;
    private javax.swing.JLabel puntosWin;
    private javax.swing.JLabel puntosWin1;
    private javax.swing.JLabel puntoslose;
    private javax.swing.JButton salirBot;
    private javax.swing.JLabel songLabel;
    private javax.swing.JLabel songLabel1;
    private javax.swing.JPanel songPane;
    private javax.swing.JPanel songsPane;
    private javax.swing.JPanel ventana1;
    private javax.swing.JPanel ventana2;
    private javax.swing.JPanel winnerPane;
    // End of variables declaration//GEN-END:variables
}
