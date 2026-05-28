package proyecto;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.ImageIcon;
import javax.swing.InputMap;
import java.util.ArrayList;
import javax.swing.Timer;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;

public class GamePanel extends PanelNotas {
    private Menu menu;
    private MotorGameplay motor;
    private Beatmap beatmap;
    private DirectorNivelJuego director;
    private Image imagen;
    private ArrayList<NotaView> notasViews;
    
    private long tJuicio = 0;
    private long tImpactTop = 0;
    private long tImpactBott = 0;
    public GamePanel(Beatmap beatmap, int dificultad, Menu menu) {   
        initComponents();
        
        this.beatmap = beatmap;
        this.menu = menu;
        String tipo = "";
        switch (beatmap.getGeneral().getType()) {
            case "Lindo" -> tipo = "lindo";
            case "Creepy" -> tipo = "creepy";
            case "Raro" -> tipo = "raro";
            case "Elegante" -> tipo = "elegante";
            default -> {
            }
        }
        imagen = new ImageIcon(getClass().getResource("/proyecto/recursos/imagenes/fondo_mapa_"+tipo+".png")).getImage();
        
        director = new DirectorNivelJuego();
        Nivel nivel = director.construir(beatmap, dificultad);
        
        ManagerPuntaje managerPuntaje = new ManagerPuntaje(nivel.getNotas().size());
        nivel.setListener(managerPuntaje);
        ManagerInput managerInput = new ManagerInput(this, (Jugador) p1icon, nivel, managerPuntaje);
        motor = new MotorGameplay(managerInput, managerPuntaje, nivel,(Jugador) p1icon, this);
        
        notasPane.removeAll();
        notasPane.setLayout(null);
        notasViews = new ArrayList<>();
        for (Nota n : nivel.getNotas()) {
            NotaView view = new NotaView(n, this);
            notasViews.add(view);
            notasPane.add(view);
        }
        
        pausePane.setVisible(false);
        configurarInput();
        iniciar();   
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
    }
    
    public void iniciar(){
        clabel.setText("");
        notasPane.repaint();
        String ruta = "/proyecto/canciones/"+beatmap.getGeneral().getFolderName()+"/"+beatmap.getGeneral().getAudioFileName();
        ManagerAudio.getInstancia().prepararMusica(ruta);
        long inicio = System.currentTimeMillis();
        Timer countdown = new Timer(100, e -> {
            long transcurrido = System.currentTimeMillis() - inicio;
            int numero = (int)(transcurrido / 1000) + 1;
            if(numero <= 3){
                comboLabel.setText(String.valueOf(numero));
            }
            if(transcurrido >= 3000){
                comboLabel.setText("GO!");
            }if(transcurrido >= 4000){
                clabel.setText("COMBO");
                comboLabel.setText("0");
                ((Timer)e.getSource()).stop();
                ManagerAudio.getInstancia().iniciarMusica();
                motor.start();
            }
        });
        countdown.start();
    }
    public void actualizarJuego() {
        long t = motor.getTiempo();
        for (NotaView nv : notasViews) {
            nv.actualizar(t);
        }
        notasPane.repaint();
        comboLabel.setText(String.valueOf(motor.getCombo()));
        puntosLabel.setText(String.valueOf(motor.getPuntaje()));
        if(t> (tImpactTop+100)){
            effTop.setIcon(null);
        }if(t> (tImpactBott+100)){
            effBott.setIcon(null);
        }if(t> (tJuicio+2000)){
            juicioLabel.setText("");
        }
    }
    @Override
    public Point getCentro(int linea){
        JLabel target;
        if(linea==0){
            target = bullseye1;
        }else{
            target = bullseye2;
        }
        Point p = SwingUtilities.convertPoint(target.getParent(),target.getLocation(),notasPane);

        int x = p.x + target.getWidth()/2;
        int y = p.y + target.getHeight()/2;
        return new Point(x,y);
    }
    public void finalizar(){
        ManagerAudio.getInstancia().parar();
        menu.finalizar(motor.getManagerPuntaje());
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        layerPane = new javax.swing.JLayeredPane();
        pausePane = new proyecto.Fondo("/proyecto/recursos/imagenes/fondo_volumen.png");
        continuarBot = new javax.swing.JButton();
        regresarBot = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        clabel = new javax.swing.JLabel();
        comboLabel = new javax.swing.JLabel();
        puntosLabel = new javax.swing.JLabel();
        effPane1 = new javax.swing.JPanel();
        effTop = new javax.swing.JLabel();
        effPane2 = new javax.swing.JPanel();
        effBott = new javax.swing.JLabel();
        juicioPanel = new javax.swing.JPanel();
        juicioLabel = new javax.swing.JLabel();
        notasPane = new javax.swing.JPanel();
        perPane = new javax.swing.JPanel();
        p1icon = new Jugador();
        bullseye1 = new javax.swing.JLabel();
        bullseye2 = new javax.swing.JLabel();
        marcoPane1 = new proyecto.Fondo("/proyecto/recursos/imagenes/mapa_marco.png");
        pauseBot = new javax.swing.JButton();

        setFocusCycleRoot(true);
        setFocusTraversalPolicyProvider(true);

        layerPane.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        continuarBot.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto/recursos/imagenes/continuar.png"))); // NOI18N
        continuarBot.setBorderPainted(false);
        continuarBot.setContentAreaFilled(false);
        continuarBot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                continuarBotActionPerformed(evt);
            }
        });

        regresarBot.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto/recursos/imagenes/salir2.png"))); // NOI18N
        regresarBot.setBorderPainted(false);
        regresarBot.setContentAreaFilled(false);
        regresarBot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                regresarBotActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Garamond", 1, 24)); // NOI18N
        jLabel1.setText("PAUSA");

        javax.swing.GroupLayout pausePaneLayout = new javax.swing.GroupLayout(pausePane);
        pausePane.setLayout(pausePaneLayout);
        pausePaneLayout.setHorizontalGroup(
            pausePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pausePaneLayout.createSequentialGroup()
                .addGroup(pausePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pausePaneLayout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(regresarBot)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(continuarBot))
                    .addGroup(pausePaneLayout.createSequentialGroup()
                        .addGap(159, 159, 159)
                        .addComponent(jLabel1)))
                .addContainerGap(59, Short.MAX_VALUE))
        );
        pausePaneLayout.setVerticalGroup(
            pausePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pausePaneLayout.createSequentialGroup()
                .addContainerGap(50, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(pausePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(regresarBot)
                    .addComponent(continuarBot))
                .addGap(67, 67, 67))
        );

        layerPane.setLayer(pausePane, javax.swing.JLayeredPane.MODAL_LAYER);
        layerPane.add(pausePane, new org.netbeans.lib.awtextra.AbsoluteConstraints(312, 138, 400, 300));

        clabel.setFont(new java.awt.Font("Garamond", 1, 24)); // NOI18N
        clabel.setForeground(new java.awt.Color(86, 0, 86));
        clabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        clabel.setText("COMBO");
        layerPane.setLayer(clabel, javax.swing.JLayeredPane.MODAL_LAYER);
        layerPane.add(clabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 80, 220, 30));

        comboLabel.setFont(new java.awt.Font("Garamond", 1, 55)); // NOI18N
        comboLabel.setForeground(new java.awt.Color(86, 0, 86));
        comboLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        comboLabel.setText("1");
        layerPane.setLayer(comboLabel, javax.swing.JLayeredPane.MODAL_LAYER);
        layerPane.add(comboLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 30, 220, 50));

        puntosLabel.setFont(new java.awt.Font("Garamond", 1, 22)); // NOI18N
        puntosLabel.setForeground(new java.awt.Color(243, 221, 249));
        puntosLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        puntosLabel.setText("000");
        layerPane.setLayer(puntosLabel, javax.swing.JLayeredPane.MODAL_LAYER);
        layerPane.add(puntosLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(807, 30, 180, 40));

        effPane1.setOpaque(false);

        javax.swing.GroupLayout effPane1Layout = new javax.swing.GroupLayout(effPane1);
        effPane1.setLayout(effPane1Layout);
        effPane1Layout.setHorizontalGroup(
            effPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(effTop, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );
        effPane1Layout.setVerticalGroup(
            effPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(effTop, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );

        layerPane.setLayer(effPane1, javax.swing.JLayeredPane.MODAL_LAYER);
        layerPane.add(effPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 230, 100, 100));

        effPane2.setOpaque(false);

        javax.swing.GroupLayout effPane2Layout = new javax.swing.GroupLayout(effPane2);
        effPane2.setLayout(effPane2Layout);
        effPane2Layout.setHorizontalGroup(
            effPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(effBott, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );
        effPane2Layout.setVerticalGroup(
            effPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(effBott, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );

        layerPane.setLayer(effPane2, javax.swing.JLayeredPane.MODAL_LAYER);
        layerPane.add(effPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 340, 100, 100));

        juicioPanel.setOpaque(false);

        juicioLabel.setFont(new java.awt.Font("Garamond", 1, 30)); // NOI18N
        juicioLabel.setForeground(new java.awt.Color(255, 235, 248));
        juicioLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout juicioPanelLayout = new javax.swing.GroupLayout(juicioPanel);
        juicioPanel.setLayout(juicioPanelLayout);
        juicioPanelLayout.setHorizontalGroup(
            juicioPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(juicioLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
        );
        juicioPanelLayout.setVerticalGroup(
            juicioPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(juicioLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
        );

        layerPane.setLayer(juicioPanel, javax.swing.JLayeredPane.PALETTE_LAYER);
        layerPane.add(juicioPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 200, 70));

        notasPane.setMaximumSize(new java.awt.Dimension(737, 390));
        notasPane.setMinimumSize(new java.awt.Dimension(737, 390));
        notasPane.setOpaque(false);
        notasPane.setLayout(null);
        layerPane.add(notasPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(247, 190, 830, 350));

        perPane.setOpaque(false);
        perPane.setPreferredSize(new java.awt.Dimension(192, 272));

        javax.swing.GroupLayout perPaneLayout = new javax.swing.GroupLayout(perPane);
        perPane.setLayout(perPaneLayout);
        perPaneLayout.setHorizontalGroup(
            perPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(p1icon, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
        );
        perPaneLayout.setVerticalGroup(
            perPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(p1icon, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );

        layerPane.add(perPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 142, 240, 400));

        bullseye1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto/recursos/imagenes/bullseye.png"))); // NOI18N
        layerPane.add(bullseye1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 244, 76, 76));

        bullseye2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto/recursos/imagenes/bullseye.png"))); // NOI18N
        layerPane.add(bullseye2, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 350, 76, 80));

        marcoPane1.setOpaque(false);

        pauseBot.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto/recursos/imagenes/pausa.png"))); // NOI18N
        pauseBot.setBorderPainted(false);
        pauseBot.setContentAreaFilled(false);
        pauseBot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pauseBotActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout marcoPane1Layout = new javax.swing.GroupLayout(marcoPane1);
        marcoPane1.setLayout(marcoPane1Layout);
        marcoPane1Layout.setHorizontalGroup(
            marcoPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(marcoPane1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(pauseBot)
                .addContainerGap(948, Short.MAX_VALUE))
        );
        marcoPane1Layout.setVerticalGroup(
            marcoPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(marcoPane1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(pauseBot)
                .addContainerGap(497, Short.MAX_VALUE))
        );

        layerPane.setLayer(marcoPane1, javax.swing.JLayeredPane.PALETTE_LAYER);
        layerPane.add(marcoPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1030, 580));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(layerPane, javax.swing.GroupLayout.PREFERRED_SIZE, 1024, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(layerPane)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void pauseBotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pauseBotActionPerformed
        motor.pausar();
        pausePane.setVisible(true);
    }//GEN-LAST:event_pauseBotActionPerformed

    private void regresarBotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regresarBotActionPerformed
        motor.pausar();
        menu.salirJuego();
    }//GEN-LAST:event_regresarBotActionPerformed

    private void continuarBotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_continuarBotActionPerformed
        pausePane.setVisible(false);
        motor.resumir();
    }//GEN-LAST:event_continuarBotActionPerformed

    private void configurarInput() {
        InputMap im = getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        ActionMap am = getActionMap();

        // D
        im.put(KeyStroke.getKeyStroke("pressed D"), "D_down");
        am.put("D_down", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (motor != null) {
                    motor.keyPressed(68);
                }
            }
        });
        im.put(KeyStroke.getKeyStroke("released D"), "D_up");
        am.put("D_up", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (motor != null) {
                    motor.keyReleased(68);
                }
            }
        });
        // F
        im.put(KeyStroke.getKeyStroke("pressed F"), "F_down");
        am.put("F_down", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (motor != null) {
                    motor.keyPressed(70);
                }
            }
        });
        im.put(KeyStroke.getKeyStroke("released F"), "F_up");
        am.put("F_up", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (motor != null) {
                    motor.keyReleased(70);
                }
            }
        });
        // J
        im.put(KeyStroke.getKeyStroke("pressed J"), "J_down");
        am.put("J_down", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (motor != null) {
                    motor.keyPressed(74);
                }
            }
        });
        im.put(KeyStroke.getKeyStroke("released J"), "J_up");
        am.put("J_up", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (motor != null) {
                    motor.keyReleased(74);
                }
            }
        });
        // K
        im.put(KeyStroke.getKeyStroke("pressed K"), "K_down");
        am.put("K_down", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (motor != null) {
                    motor.keyPressed(75);
                }
            }
        });
        im.put(KeyStroke.getKeyStroke("released K"), "K_up");
        am.put("K_up", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (motor != null) {
                    motor.keyReleased(75);
                }
            }
        });
        //Espacio
        im.put(KeyStroke.getKeyStroke("pressed SPACE"), "space_down");
        am.put("space_down", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (motor != null) {
                    motor.keyPressed(32);
                }
            }
        });
        im.put(KeyStroke.getKeyStroke("released SPACE"), "space_up");
        am.put("space_up", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (motor != null) {
                    motor.keyReleased(32);
                }
            }
        });
        //Esc
        im.put(KeyStroke.getKeyStroke("pressed ESCAPE"), "esc_down");
        am.put("esc_down", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (motor != null) {
                    motor.keyPressed(27);
                }
            }
        });
        im.put(KeyStroke.getKeyStroke("released ESCAPE"), "esc_up");
        am.put("esc_up", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (motor != null) {
                    motor.keyReleased(27);
                }
            }
        });
    }
    
    public void hit(int linea, Juicio juicio){
        ManagerAudio.getInstancia().playSonido("/proyecto/recursos/audio/hit.wav");
        if(linea==0){
            effTop.setIcon(new ImageIcon(getClass().getResource("/proyecto/recursos/imagenes/impact.png")));
            tImpactTop = motor.getTiempo();
        }else if(linea==1){
            effBott.setIcon(new ImageIcon(getClass().getResource("/proyecto/recursos/imagenes/impact.png")));
            tImpactBott = motor.getTiempo();
        }
        if(juicio == Juicio.PERFECTO)
            juicioLabel.setText("PERFECTO");
        else
            juicioLabel.setText("BIEN");
        tJuicio = motor.getTiempo();
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bullseye1;
    private javax.swing.JLabel bullseye2;
    private javax.swing.JLabel clabel;
    private javax.swing.JLabel comboLabel;
    private javax.swing.JButton continuarBot;
    private javax.swing.JLabel effBott;
    private javax.swing.JPanel effPane1;
    private javax.swing.JPanel effPane2;
    private javax.swing.JLabel effTop;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel juicioLabel;
    private javax.swing.JPanel juicioPanel;
    private javax.swing.JLayeredPane layerPane;
    private javax.swing.JPanel marcoPane1;
    private javax.swing.JPanel notasPane;
    private javax.swing.JLabel p1icon;
    private javax.swing.JButton pauseBot;
    private javax.swing.JPanel pausePane;
    private javax.swing.JPanel perPane;
    private javax.swing.JLabel puntosLabel;
    private javax.swing.JButton regresarBot;
    // End of variables declaration//GEN-END:variables
}