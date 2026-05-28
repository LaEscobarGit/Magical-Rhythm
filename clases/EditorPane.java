package proyecto;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class EditorPane extends PanelNotas {
    private DirectorNivelEditor director;
    private NotaFactory notaFactory = new NotaFactory();
    private Menu menu;
    private MotorEditor motor;
    private Image imagen;
    private Beatmap beatmap;
    private int dificultad;
    private ArrayList<NotaView> notasViews;
    private double BPM = 0;
    private int snap = 400;
    private int snapDiv = 1;
    private String notaSeleccionada;
    private NotaView notaMover;
    private int tiempoEditor = 0;
    private boolean reproduciendo = false;
    private boolean actualizandoSlider = false;
    private boolean snapHabilitado = true;
    private double zoom = 1.0;
    private int offset = 0;
    private double pixelsPerMs = 0.1 * zoom;
    
    public EditorPane(Beatmap beatmap, int dificultad, Menu menu) {
        this.beatmap = beatmap;
        this.menu = menu;
        this.dificultad = dificultad;
        initComponents();
        ManagerAudio.getInstancia().agregarSonidoBotones(this, "/proyecto/recursos/audio/click.wav","/proyecto/recursos/audio/hover.wav");
        
        imagen = new ImageIcon(getClass().getResource("/proyecto/recursos/imagenes/fondo_editor.png")).getImage();        
        
        motor = new MotorEditor(this);

        director = new DirectorNivelEditor(beatmap);
        //nivelBuilder = new NivelBuilder();
        //nivelBuilder.setBeatmap(beatmap);
        notasViews = new ArrayList<>();
        
        slider.setMinimum(0);
        slider.setMaximum(1000);
        slider.setValue(0);
        
        if (dificultad != -1){
            inicializar();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
    }

    private void inicializar(){
        director.construir(dificultad);
        Nivel nivel = director.getNivel();
        
        BPM = beatmap.getMetadata().getBPM();
        snap = (int) (60000/BPM);
        offset = beatmap.getGeneral().getAudioLeadIn();
        
        //cargando las notas del beatmap
        notasPane.removeAll();
        notasPane.setLayout(null);
        notasViews.clear();
        for (Nota n : nivel.getNotas()) {
            NotaView view = new NotaView(n, this);
            notasViews.add(view);
            notasPane.add(view);
        }
        
        //slider
        slider.setMaximum((int) beatmap.getMetadata().getDuration());
        slider.setMinorTickSpacing(snap);
        
        //playback
        String ruta = "/proyecto/canciones/"+beatmap.getGeneral().getFolderName()+"/"+beatmap.getGeneral().getAudioFileName();
        ManagerAudio.getInstancia().prepararMusica(ruta);
        
        //datos
        tituloLabel.setText(beatmap.getMetadata().getTitle());
        artistaLabel.setText(beatmap.getMetadata().getArtist());
        creadorLabel.setText(beatmap.getMetadata().getCreator());
        int ms = beatmap.getMetadata().getDuration();
        int min = (ms/1000)/60;
        int seg = (int) ((ms/1000)%60);
        duracionLabel.setText(min+":"+seg);
        BPMLabel.setText(String.valueOf(beatmap.getMetadata().getBPM()));
        ms = beatmap.getMetadata().getPreviewStart();
        min = (ms/1000)/60;
        seg = (int) ((ms/1000)%60);
        previewLabel.setText(min+":"+seg);
        offsetLabel.setText(String.valueOf(offset));
        typeCombo.setSelectedItem(beatmap.getGeneral().getType());
        pistaLabel.setText(beatmap.getGeneral().getAudioFilePath());
        iconoLabel.setText(beatmap.getGeneral().getIconFilePath());
        difCombo.setSelectedItem(beatmap.getDifficulty().get(dificultad).getDifficulty());
        difSpinner.setValue(beatmap.getDifficulty().get(dificultad).getDifficultyValue());
        hpSpinner.setValue(beatmap.getDifficulty().get(dificultad).getHP());
    }
    
    public void actualizarTimeline() {
        if(dificultad==-1) return;
        for (NotaView nv : notasViews) {
            nv.actualizar(tiempoEditor);
        }
        notasPane.repaint();
    }
    @Override
    public Point getCentro(int linea){
        JLabel target;
        if(linea==0){
            target = bullseye1;
        }else if(linea==1){
            target = bullseye2;
        }else{
            Point p1 = SwingUtilities.convertPoint(bullseye1.getParent(),bullseye1.getLocation(),notasPane);
            Point p2 = SwingUtilities.convertPoint(bullseye2.getParent(),bullseye2.getLocation(),notasPane);

            int x = p1.x + bullseye1.getWidth()/2;
            int y1 = p1.y + bullseye1.getHeight()/2;
            int y2 = p2.y + bullseye2.getHeight()/2;

            return new Point(x, (y1 + y2)/2);
        }
        Point p = SwingUtilities.convertPoint(target.getParent(),target.getLocation(),notasPane);

        int x = p.x + target.getWidth()/2;
        int y = p.y + target.getHeight()/2;
        return new Point(x,y);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        layerPane = new javax.swing.JLayeredPane();
        notasPane = new javax.swing.JPanel(){
            @Override
            protected void paintComponent(Graphics g){
                super.paintComponent(g);
                dibujarGrid(g);
            }
        };
        bullseye1 = new javax.swing.JLabel();
        bullseye2 = new javax.swing.JLabel();
        tabPane = new javax.swing.JTabbedPane();
        notaChoosePane = new javax.swing.JPanel();
        tap = new javax.swing.JLabel();
        hold = new javax.swing.JLabel();
        block = new javax.swing.JLabel();
        mapInfoPane = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        offsetLabel = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        typeCombo = new javax.swing.JComboBox<>();
        duracionLabel = new javax.swing.JFormattedTextField();
        jLabel2 = new javax.swing.JLabel();
        BPMLabel = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        iconoLabel = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        buscarBot2 = new javax.swing.JButton();
        pistaLabel = new javax.swing.JTextField();
        previewLabel = new javax.swing.JTextField();
        creadorLabel = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        tituloLabel = new javax.swing.JTextField();
        artistaLabel = new javax.swing.JTextField();
        buscarBot1 = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        difPane = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        difCombo = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        difSpinner = new javax.swing.JSpinner();
        jLabel10 = new javax.swing.JLabel();
        hpSpinner = new javax.swing.JSpinner();
        bottomPanel = new javax.swing.JPanel();
        playBot = new javax.swing.JButton();
        stopBot = new javax.swing.JButton();
        slider = new javax.swing.JSlider();
        snapBot = new javax.swing.JButton();
        divCombo = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        guardarBot = new javax.swing.JButton();
        publicarBot = new javax.swing.JButton();
        marcoPane1 = new proyecto.Fondo("/proyecto/recursos/imagenes/editor_marco.png");
        pauseBot = new javax.swing.JButton();

        addMouseWheelListener(new java.awt.event.MouseWheelListener() {
            public void mouseWheelMoved(java.awt.event.MouseWheelEvent evt) {
                formMouseWheelMoved(evt);
            }
        });

        layerPane.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        notasPane.setMaximumSize(new java.awt.Dimension(737, 390));
        notasPane.setMinimumSize(new java.awt.Dimension(737, 390));
        notasPane.setOpaque(false);
        notasPane.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                notaPanePressed(evt);
            }
        });
        notasPane.setLayout(null);
        layerPane.add(notasPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(237, 100, 840, 350));

        bullseye1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto/recursos/imagenes/bullseye.png"))); // NOI18N
        layerPane.add(bullseye1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 150, 76, -1));

        bullseye2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto/recursos/imagenes/bullseye.png"))); // NOI18N
        layerPane.add(bullseye2, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 260, 76, -1));

        tap.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto/recursos/imagenes/tap.png"))); // NOI18N
        tap.setName("tap"); // NOI18N
        tap.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                notaPressed(evt);
            }
        });

        hold.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto/recursos/imagenes/hold_start.png"))); // NOI18N
        hold.setName("hold"); // NOI18N
        hold.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                notaPressed(evt);
            }
        });

        block.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto/recursos/imagenes/block.png"))); // NOI18N
        block.setName("block"); // NOI18N
        block.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                notaPressed(evt);
            }
        });

        javax.swing.GroupLayout notaChoosePaneLayout = new javax.swing.GroupLayout(notaChoosePane);
        notaChoosePane.setLayout(notaChoosePaneLayout);
        notaChoosePaneLayout.setHorizontalGroup(
            notaChoosePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(notaChoosePaneLayout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addGroup(notaChoosePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(block)
                    .addComponent(tap)
                    .addComponent(hold))
                .addContainerGap(74, Short.MAX_VALUE))
        );
        notaChoosePaneLayout.setVerticalGroup(
            notaChoosePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(notaChoosePaneLayout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addComponent(tap)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(hold)
                .addGap(18, 18, 18)
                .addComponent(block)
                .addContainerGap(75, Short.MAX_VALUE))
        );

        tabPane.addTab("Notas", notaChoosePane);

        jPanel2.setMaximumSize(new java.awt.Dimension(182, 487));
        jPanel2.setOpaque(false);

        jLabel7.setFont(new java.awt.Font("Garamond", 0, 12)); // NOI18N
        jLabel7.setText("Pista de audio");

        offsetLabel.setFont(new java.awt.Font("Garamond", 0, 12)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Garamond", 0, 12)); // NOI18N
        jLabel4.setText("Duracion");

        jLabel3.setFont(new java.awt.Font("Garamond", 0, 12)); // NOI18N
        jLabel3.setText("Creador");

        jLabel1.setFont(new java.awt.Font("Garamond", 0, 12)); // NOI18N
        jLabel1.setText("Titulo");

        typeCombo.setFont(new java.awt.Font("Garamond", 0, 12)); // NOI18N
        typeCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Lindo", "Raro", "Creepy", "Elegante" }));

        duracionLabel.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("mm:ss"))));
        duracionLabel.setFont(new java.awt.Font("Garamond", 0, 12)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Garamond", 0, 12)); // NOI18N
        jLabel2.setText("Artista");

        BPMLabel.setFont(new java.awt.Font("Garamond", 0, 12)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Garamond", 0, 12)); // NOI18N
        jLabel5.setText("BPM");

        jLabel11.setFont(new java.awt.Font("Garamond", 0, 12)); // NOI18N
        jLabel11.setText("Estética");

        iconoLabel.setFont(new java.awt.Font("Garamond", 0, 12)); // NOI18N
        iconoLabel.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        iconoLabel.setEnabled(false);

        jLabel6.setFont(new java.awt.Font("Garamond", 0, 12)); // NOI18N
        jLabel6.setText("Preview Inicio");

        buscarBot2.setFont(new java.awt.Font("Garamond", 0, 12)); // NOI18N
        buscarBot2.setText("Buscar Icono");
        buscarBot2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        buscarBot2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        buscarBot2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarBot2ActionPerformed(evt);
            }
        });

        pistaLabel.setFont(new java.awt.Font("Garamond", 0, 12)); // NOI18N
        pistaLabel.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        pistaLabel.setEnabled(false);

        previewLabel.setFont(new java.awt.Font("Garamond", 0, 12)); // NOI18N

        creadorLabel.setFont(new java.awt.Font("Garamond", 0, 12)); // NOI18N

        jLabel12.setFont(new java.awt.Font("Garamond", 0, 12)); // NOI18N
        jLabel12.setText("Inicio canción (ms)");

        tituloLabel.setFont(new java.awt.Font("Garamond", 0, 12)); // NOI18N

        artistaLabel.setFont(new java.awt.Font("Garamond", 0, 12)); // NOI18N

        buscarBot1.setFont(new java.awt.Font("Garamond", 0, 12)); // NOI18N
        buscarBot1.setText("Buscar Pista");
        buscarBot1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        buscarBot1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        buscarBot1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarBot1ActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Garamond", 0, 12)); // NOI18N
        jLabel13.setText("Icono");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(typeCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(offsetLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(previewLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(BPMLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(duracionLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tituloLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(creadorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pistaLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(artistaLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(buscarBot1, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(iconoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(buscarBot2, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tituloLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addGap(8, 8, 8)
                .addComponent(artistaLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(creadorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(duracionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BPMLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(12, 12, 12)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(previewLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(offsetLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addGap(12, 12, 12)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(typeCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pistaLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buscarBot1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(iconoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buscarBot2))
        );

        javax.swing.GroupLayout mapInfoPaneLayout = new javax.swing.GroupLayout(mapInfoPane);
        mapInfoPane.setLayout(mapInfoPaneLayout);
        mapInfoPaneLayout.setHorizontalGroup(
            mapInfoPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mapInfoPaneLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );
        mapInfoPaneLayout.setVerticalGroup(
            mapInfoPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mapInfoPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        tabPane.addTab("Mapa info", mapInfoPane);

        jLabel8.setFont(new java.awt.Font("Garamond", 0, 12)); // NOI18N
        jLabel8.setText("Dificultad");

        difCombo.setFont(new java.awt.Font("Garamond", 0, 12)); // NOI18N
        difCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Easy", "Normal", "Hard" }));

        jLabel9.setFont(new java.awt.Font("Garamond", 0, 12)); // NOI18N
        jLabel9.setText("Valor dificultad");

        difSpinner.setFont(new java.awt.Font("Garamond", 0, 12)); // NOI18N
        difSpinner.setModel(new javax.swing.SpinnerNumberModel(1, 1, 10, 1));

        jLabel10.setFont(new java.awt.Font("Garamond", 0, 12)); // NOI18N
        jLabel10.setText("HP");

        hpSpinner.setFont(new java.awt.Font("Garamond", 0, 12)); // NOI18N
        hpSpinner.setModel(new javax.swing.SpinnerNumberModel(200, 50, 250, 50));

        javax.swing.GroupLayout difPaneLayout = new javax.swing.GroupLayout(difPane);
        difPane.setLayout(difPaneLayout);
        difPaneLayout.setHorizontalGroup(
            difPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(difPaneLayout.createSequentialGroup()
                .addGroup(difPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(difPaneLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(difCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, difPaneLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(difPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(difSpinner, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
                            .addComponent(hpSpinner))))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        difPaneLayout.setVerticalGroup(
            difPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(difPaneLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(difCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(jLabel9)
                .addGap(7, 7, 7)
                .addComponent(difSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(hpSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(347, Short.MAX_VALUE))
        );

        tabPane.addTab("Dificultad", difPane);

        layerPane.add(tabPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 220, 560));

        playBot.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto/recursos/imagenes/play.png"))); // NOI18N
        playBot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playBotActionPerformed(evt);
            }
        });

        stopBot.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto/recursos/imagenes/pause.png"))); // NOI18N
        stopBot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stopBotActionPerformed(evt);
            }
        });

        slider.setSnapToTicks(true);
        slider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sliderStateChanged(evt);
            }
        });

        snapBot.setFont(new java.awt.Font("Garamond", 1, 12)); // NOI18N
        snapBot.setText("Deshabilitar Snap");
        snapBot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                snapBotActionPerformed(evt);
            }
        });

        divCombo.setFont(new java.awt.Font("Garamond", 0, 12)); // NOI18N
        divCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1/4", "1/8", "1/16" }));
        divCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                divComboActionPerformed(evt);
            }
        });

        guardarBot.setFont(new java.awt.Font("Garamond", 1, 12)); // NOI18N
        guardarBot.setText("Guardar mapa");
        guardarBot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarBotActionPerformed(evt);
            }
        });

        publicarBot.setFont(new java.awt.Font("Garamond", 1, 12)); // NOI18N
        publicarBot.setText("Publicar");
        publicarBot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                publicarBotActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 113, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(publicarBot, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(guardarBot))
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(guardarBot, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(publicarBot, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );

        javax.swing.GroupLayout bottomPanelLayout = new javax.swing.GroupLayout(bottomPanel);
        bottomPanel.setLayout(bottomPanelLayout);
        bottomPanelLayout.setHorizontalGroup(
            bottomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bottomPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(bottomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bottomPanelLayout.createSequentialGroup()
                        .addComponent(snapBot)
                        .addGap(18, 18, 18)
                        .addComponent(divCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(bottomPanelLayout.createSequentialGroup()
                        .addComponent(slider, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(playBot, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(stopBot, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 77, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60))
        );
        bottomPanelLayout.setVerticalGroup(
            bottomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bottomPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(bottomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(slider, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(playBot, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(stopBot, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(bottomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(snapBot, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                    .addComponent(divCombo))
                .addGap(48, 48, 48))
            .addGroup(bottomPanelLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        layerPane.add(bottomPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 450, 840, 130));

        marcoPane1.setOpaque(false);

        pauseBot.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto/recursos/imagenes/salir.png"))); // NOI18N
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, marcoPane1Layout.createSequentialGroup()
                .addContainerGap(986, Short.MAX_VALUE)
                .addComponent(pauseBot)
                .addGap(50, 50, 50))
        );
        marcoPane1Layout.setVerticalGroup(
            marcoPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(marcoPane1Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(pauseBot)
                .addContainerGap(498, Short.MAX_VALUE))
        );

        layerPane.setLayer(marcoPane1, javax.swing.JLayeredPane.PALETTE_LAYER);
        layerPane.add(marcoPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1080, 580));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(layerPane, javax.swing.GroupLayout.PREFERRED_SIZE, 1074, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(layerPane)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void pauseBotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pauseBotActionPerformed
        int res = JOptionPane.showConfirmDialog(null,"¿Deseas salir del editor?", "Confirmación", JOptionPane.YES_NO_OPTION);
        if(res==JOptionPane.YES_OPTION){
            motor.stop();
            menu.showMenu();
        }
    }//GEN-LAST:event_pauseBotActionPerformed

    private void formMouseWheelMoved(java.awt.event.MouseWheelEvent evt) {//GEN-FIRST:event_formMouseWheelMoved
        if(evt.isControlDown()){
            if(evt.getWheelRotation() < 0)
                zoom *= 1.1;
            else
                zoom /= 1.1;
            zoom = Math.max(0.2, Math.min(zoom, 5));
            actualizarTimeline();
            return;
        }
        if(!reproduciendo){
            int nuevo = tiempoEditor + evt.getWheelRotation() * getSnap();
            if(nuevo < 0)
                nuevo = 0;
            if(nuevo > slider.getMaximum())
                nuevo = slider.getMaximum();
            tiempoEditor = nuevo;
            slider.setValue(tiempoEditor);
            actualizarTimeline();
        }
    }//GEN-LAST:event_formMouseWheelMoved

    private void sliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sliderStateChanged
        if(dificultad==-1) return;
        if(actualizandoSlider) return;
        tiempoEditor = slider.getValue();
        actualizarTimeline();
    }//GEN-LAST:event_sliderStateChanged

    private void notaPressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_notaPressed
        notaSeleccionada = switch (evt.getComponent().getName()) {
            case "tap" -> "tap";
            case "hold" -> "hold";
            case "mash" -> "mash";
            case "block" -> "block";
            default -> "";
        };
    }//GEN-LAST:event_notaPressed

    private void notaPanePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_notaPanePressed
        if(notaSeleccionada == null || notaSeleccionada.isEmpty())
            return;

        int linea = getLineaPorMouse(evt);
        int tiempoNota = xATiempo(evt.getX());

        if(snapHabilitado){
            int snap = getSnap();
            tiempoNota = offset + Math.round((float)(tiempoNota - offset) / snap) * snap;
        }

        Nota nota = notaFactory.crearNota(notaSeleccionada, linea, tiempoNota);
        director.getNivel().agregarNota(nota);
        NotaView nv = new NotaView(nota, this);
        notasViews.add(nv);
        notasPane.add(nv);
        actualizarTimeline();
        notasPane.repaint();
        notaSeleccionada = null;
    }//GEN-LAST:event_notaPanePressed

    private void playBotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_playBotActionPerformed
        if(!reproduciendo){
            ManagerAudio.getInstancia().pausarMusica();
            ManagerAudio.getInstancia().setTiempo(tiempoEditor);
            ManagerAudio.getInstancia().iniciarMusica(tiempoEditor);
            motor.start(tiempoEditor);
            reproduciendo = true;
        }
    }//GEN-LAST:event_playBotActionPerformed

    private void stopBotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stopBotActionPerformed
        if(reproduciendo){
            motor.stop();
            ManagerAudio.getInstancia().pausarMusica();
            reproduciendo = false;
        }
    }//GEN-LAST:event_stopBotActionPerformed

    private void buscarBot1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarBot1ActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Pista de audio");
        int seleccion = fileChooser.showOpenDialog(this);
        if (seleccion == JFileChooser.APPROVE_OPTION) {
            File archivo = fileChooser.getSelectedFile();
            pistaLabel.setText(archivo.getAbsolutePath());
        } else {
            System.out.println("Cancelado");
        }
    }//GEN-LAST:event_buscarBot1ActionPerformed

    private void snapBotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_snapBotActionPerformed
        if(!snapHabilitado){
            snapBot.setText("Deshabilitar snap");
            snapHabilitado = true;
        }else{
            snapBot.setText("Habilitar snap");
            snapHabilitado = false;
        }
    }//GEN-LAST:event_snapBotActionPerformed

    private void divComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_divComboActionPerformed
        snapDiv = switch ((String) divCombo.getSelectedItem()) {
            case "1/4" -> 1;
            case "1/8" -> 2;
            case "1/16" -> 4;
            default -> -1;
        };
        notasPane.repaint();
    }//GEN-LAST:event_divComboActionPerformed

    private void buscarBot2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarBot2ActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Icono de canción");
        int seleccion = fileChooser.showOpenDialog(this);
        if (seleccion == JFileChooser.APPROVE_OPTION) {
            File archivo = fileChooser.getSelectedFile();
            iconoLabel.setText(archivo.getAbsolutePath());
        } else {
            System.out.println("Cancelado");
        }
    }//GEN-LAST:event_buscarBot2ActionPerformed

    private void guardarBotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarBotActionPerformed
        beatmap.getMetadata().setStatus("Draft");
        guardar();
    }//GEN-LAST:event_guardarBotActionPerformed

    private void publicarBotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_publicarBotActionPerformed
        beatmap.getMetadata().setStatus("Published");
        guardar();
    }//GEN-LAST:event_publicarBotActionPerformed

    private void guardar(){
        // metadata
        beatmap.getMetadata().setTitle(tituloLabel.getText());
        beatmap.getMetadata().setArtist(artistaLabel.getText());
        beatmap.getMetadata().setCreator(creadorLabel.getText());
        String[] tiempoStr = duracionLabel.getText().split(":");
        int seg = Integer.parseInt(tiempoStr[0])*60 + Integer.parseInt(tiempoStr[1]);
        beatmap.getMetadata().setDuration(seg*1000);
        beatmap.getMetadata().setBPM(Double.parseDouble(BPMLabel.getText()));
        tiempoStr = previewLabel.getText().split(":");
        seg = Integer.parseInt(tiempoStr[0])*60 + Integer.parseInt(tiempoStr[1]);
        beatmap.getMetadata().setPreviewStart(seg*1000);
        
        // general
        beatmap.getGeneral().setType((String) typeCombo.getSelectedItem());
        beatmap.getGeneral().setAudioLeadIn(Integer.parseInt(offsetLabel.getText()));

        // dificultad actual
        if(dificultad==-1){
            dificultad = 0;
        }
        beatmap.getDifficulty().get(dificultad).setDifficulty((String) difCombo.getSelectedItem());
        beatmap.getDifficulty().get(dificultad).setDifficultyValue((int) difSpinner.getValue());
        beatmap.getDifficulty().get(dificultad).setHP((int) hpSpinner.getValue());

        // archivos
        beatmap.getGeneral().setAudioFileName(new File(pistaLabel.getText()).getName());
        beatmap.getGeneral().setAudioFilePath(pistaLabel.getText());
        beatmap.getGeneral().setIconFileName(new File(iconoLabel.getText()).getName());
        beatmap.getGeneral().setIconFilePath(iconoLabel.getText());
        if(beatmap.getGeneral().getFolderName()==null || beatmap.getGeneral().getFolderName().isEmpty())
            beatmap.getGeneral().setFolderName(beatmap.getMetadata().getTitle());
        String folder = beatmap.getGeneral().getFolderName();
        
        List<Nota> notas = director.getNivel().getNotas();
        int[][] datos = new int[notas.size()][4];
        for (int i = 0; i < notas.size(); i++) {
            Nota n = notas.get(i);
            datos[i][0] = n.getLinea();
            if(n instanceof NotaTap){
                datos[i][1] = 0;
                datos[i][3] = -1;
            }else if(n instanceof NotaHold){
                datos[i][1] = 1;
                datos[i][3] = (int) n.getFin();
                
            }else if(n instanceof NotaBlock){
                datos[i][1] = 3;
                datos[i][3] = -1;
            }
            datos[i][2] = (int) n.getInicio();
        }
        beatmap.getDifficulty().get(dificultad).setHitObjects(datos);
        
        BeatmapLoader.guardar(beatmap, folder);
        inicializar();
    }
    
    public int getLineaPorY(int y){
        int yTop = getCentro(0).y;
        int yBottom = getCentro(1).y;
        int distTop = Math.abs(y - yTop);
        int distBottom = Math.abs(y - yBottom);
        return distTop < distBottom ? 0 : 1;
    }
    private int getLineaPorMouse(MouseEvent evt){
        Point p = SwingUtilities.convertPoint(evt.getComponent(),evt.getPoint(),notasPane);

        Point up = getCentro(0);
        Point down = getCentro(1);

        int distUp = Math.abs(p.y - up.y);
        int distDown = Math.abs(p.y - down.y);

        return distUp < distDown ? 0 : 1;
    }

    public void eliminarNota(NotaView nv){
        notasPane.remove(nv);
        notasViews.remove(nv);
        director.getNivel().getNotas().remove(nv.getNota());
        notasPane.repaint();
        notasPane.revalidate();
    }
    public void iniciarDragNota(NotaView nv, MouseEvent evt){
        notaMover = nv;
    }

    public void dragNota(NotaView nv, MouseEvent evt){
            Point p = SwingUtilities.convertPoint(nv,evt.getPoint(),notasPane);

            int linea = getLineaPorY(p.y);
            int tiempo = xATiempo(p.x);
            if(snapHabilitado){
                int snap = getSnap();
                tiempo = offset + Math.round((float)(tiempo - offset) / snap) * snap;
            }
                
            Nota nota = nv.getNota();
            if(nota instanceof NotaHold hold){
                if(nv.isDragInicio()){
                    if(tiempo >= hold.getFin())
                        tiempo = (int)hold.getFin() - 1;
                    hold.setInicio(tiempo);
                }
                else if(nv.isDragFin()){
                    if(tiempo <= hold.getInicio())
                        tiempo = (int)hold.getInicio() + 1;
                    hold.setFin(tiempo);
                }
                else{
                    long duracion = hold.getFin() - hold.getInicio();
                    hold.setLinea(linea);
                    hold.setInicio(tiempo);
                    hold.setFin((int)(tiempo + duracion));
                }
            }else{
                nota.setLinea(linea);
                nota.setInicio(tiempo);
            }
            actualizarTimeline();
    }

    public void soltarDragNota(NotaView nv, MouseEvent evt){
        if(notaMover == null)
            return;

        Point p = SwingUtilities.convertPoint(nv,evt.getPoint(),notasPane);
        int linea = getLineaPorY(p.y);
        int tiempo = xATiempo(p.x);
        if(snapHabilitado){
            int snap = getSnap();
            tiempo = offset + Math.round((float)(tiempo - offset) / snap) * snap;
        }
        nv.getNota().setLinea(linea);
        nv.getNota().setInicio(tiempo);
        actualizarTimeline();
        notaMover = null;
    }
    private int xATiempo(int x){
        int centroX = getCentro(0).x;
        int distancia = x - centroX;
        return tiempoEditor + (int)(distancia * 2.0 / zoom);
    }
    private int tiempoAX(int tiempo){
        int centroX = getCentro(0).x;
        return centroX + (int)((tiempo - tiempoEditor) * zoom / 2.0);
    }
    public double getZoom(){
        return zoom;
    }

    public void update(){
        if(!reproduciendo)
            return;
        tiempoEditor = (int) motor.getTiempo();
        actualizarTimeline();
        actualizandoSlider = true;
        slider.setValue(tiempoEditor);
        actualizandoSlider = false;
    }
    
    //timeline
    public int getSnap(){
        return snap/snapDiv;
    }
    public void dibujarGrid(Graphics g){
        g.setColor(java.awt.Color.red);
        int duracion = slider.getMaximum();
        for(int t = offset; t < duracion; t += getSnap()){
            int x = tiempoAX(t);
            g.drawLine(x, 100, x, getHeight());
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField BPMLabel;
    private javax.swing.JTextField artistaLabel;
    private javax.swing.JLabel block;
    private javax.swing.JPanel bottomPanel;
    private javax.swing.JLabel bullseye1;
    private javax.swing.JLabel bullseye2;
    private javax.swing.JButton buscarBot1;
    private javax.swing.JButton buscarBot2;
    private javax.swing.JTextField creadorLabel;
    private javax.swing.JComboBox<String> difCombo;
    private javax.swing.JPanel difPane;
    private javax.swing.JSpinner difSpinner;
    private javax.swing.JComboBox<String> divCombo;
    private javax.swing.JFormattedTextField duracionLabel;
    private javax.swing.JButton guardarBot;
    private javax.swing.JLabel hold;
    private javax.swing.JSpinner hpSpinner;
    private javax.swing.JTextField iconoLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLayeredPane layerPane;
    private javax.swing.JPanel mapInfoPane;
    private javax.swing.JPanel marcoPane1;
    private javax.swing.JPanel notaChoosePane;
    private javax.swing.JPanel notasPane;
    private javax.swing.JTextField offsetLabel;
    private javax.swing.JButton pauseBot;
    private javax.swing.JTextField pistaLabel;
    private javax.swing.JButton playBot;
    private javax.swing.JTextField previewLabel;
    private javax.swing.JButton publicarBot;
    private javax.swing.JSlider slider;
    private javax.swing.JButton snapBot;
    private javax.swing.JButton stopBot;
    private javax.swing.JTabbedPane tabPane;
    private javax.swing.JLabel tap;
    private javax.swing.JTextField tituloLabel;
    private javax.swing.JComboBox<String> typeCombo;
    // End of variables declaration//GEN-END:variables
}