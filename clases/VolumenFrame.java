package proyecto;
import javax.swing.JFrame;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class VolumenFrame extends javax.swing.JFrame implements ChangeListener{
    public VolumenFrame(Menu owner) {
        initComponents();
        
        setLocationRelativeTo(owner);
        
        int valMusica = (int) (100*ManagerAudio.getInstancia().getMusicVol());
        int valSonido = (int) (100*ManagerAudio.getInstancia().getSonidoVol());
        musicLabel.setText(String.valueOf(valMusica));
        sonidoLabel.setText(String.valueOf(valSonido));
        sliderMusic.setValue(valMusica);
        sliderSonido.setValue(valSonido);
        sliderMusic.addChangeListener(this);
        sliderSonido.addChangeListener(this);
        
        ManagerAudio.getInstancia().agregarSonidoBotones(this, "/proyecto/recursos/audio/click.wav","/proyecto/recursos/audio/hover.wav");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle("Opciones");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new proyecto.Fondo("/proyecto/recursos/imagenes/fondo_volumen.png");
        sliderMusic = new javax.swing.JSlider();
        sliderSonido = new javax.swing.JSlider();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        musicLabel = new javax.swing.JLabel();
        sonidoLabel = new javax.swing.JLabel();
        cancelarBot = new javax.swing.JButton();
        aceptarBot = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(400, 300));
        setUndecorated(true);
        setResizable(false);

        jPanel1.setMaximumSize(new java.awt.Dimension(400, 300));
        jPanel1.setMinimumSize(new java.awt.Dimension(400, 300));
        jPanel1.setOpaque(false);

        sliderMusic.setMajorTickSpacing(50);
        sliderMusic.setValue(100);

        sliderSonido.setMajorTickSpacing(50);
        sliderSonido.setValue(100);

        jLabel1.setFont(new java.awt.Font("Garamond", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(104, 9, 121));
        jLabel1.setText("Music");

        jLabel2.setFont(new java.awt.Font("Garamond", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(104, 9, 121));
        jLabel2.setText("Sound");

        musicLabel.setFont(new java.awt.Font("Garamond", 1, 14)); // NOI18N
        musicLabel.setForeground(new java.awt.Color(104, 9, 121));
        musicLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        musicLabel.setText("80");

        sonidoLabel.setFont(new java.awt.Font("Garamond", 1, 14)); // NOI18N
        sonidoLabel.setForeground(new java.awt.Color(104, 9, 121));
        sonidoLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sonidoLabel.setText("100");

        cancelarBot.setFont(new java.awt.Font("Garamond", 1, 14)); // NOI18N
        cancelarBot.setForeground(new java.awt.Color(104, 9, 121));
        cancelarBot.setText("Cancel");
        cancelarBot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarBotActionPerformed(evt);
            }
        });

        aceptarBot.setFont(new java.awt.Font("Garamond", 1, 14)); // NOI18N
        aceptarBot.setForeground(new java.awt.Color(104, 9, 121));
        aceptarBot.setText("Accept");
        aceptarBot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aceptarBotActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addComponent(cancelarBot, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(aceptarBot, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(musicLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(sonidoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(sliderSonido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(sliderMusic, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(64, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(musicLabel)
                    .addComponent(sliderMusic, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(sonidoLabel))
                    .addComponent(sliderSonido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelarBot, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(aceptarBot, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(59, Short.MAX_VALUE))
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

    private void cancelarBotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarBotActionPerformed
        dispose();
    }//GEN-LAST:event_cancelarBotActionPerformed

    private void aceptarBotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aceptarBotActionPerformed
        ManagerAudio.getInstancia().setSonidoVol(sliderSonido.getValue()/100f);
        ManagerAudio.getInstancia().setMusicaVol(sliderMusic.getValue()/100f);
        dispose();
    }//GEN-LAST:event_aceptarBotActionPerformed
    
    @Override
    public void stateChanged(ChangeEvent e) {
        musicLabel.setText(String.valueOf(sliderMusic.getValue()));
        sonidoLabel.setText(String.valueOf(sliderSonido.getValue()));
    }
    
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton aceptarBot;
    private javax.swing.JButton cancelarBot;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel musicLabel;
    private javax.swing.JSlider sliderMusic;
    private javax.swing.JSlider sliderSonido;
    private javax.swing.JLabel sonidoLabel;
    // End of variables declaration//GEN-END:variables
}
