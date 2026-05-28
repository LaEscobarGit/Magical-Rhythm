package proyecto;
import java.awt.Container;
import java.io.File;
import java.io.IOException;
import javax.sound.sampled.*;
import javax.swing.Timer;

public class ManagerAudio {
    private static final ManagerAudio instancia = new ManagerAudio();
    private Clip musicClip;
    private float musicVol = 0.8f;
    private float sfxVol = 1f;
    private Clip previewClip;
    private Timer previewTimer;

    private ManagerAudio() {}
    public static ManagerAudio getInstancia() {
        return instancia;
    }

    public float getMusicVol(){
        return musicVol;
    }
    public float getSonidoVol(){
        return sfxVol;
    }
    
   //cargar
   public Clip cargarFile(String ruta) {
        try {
            if (ruta.startsWith("/proyecto/")) {
                ruta = "src" + ruta;
            }

            File file = new File(ruta);

            if (!file.exists()) {
                throw new RuntimeException("Archivo no encontrado: " + file.getAbsolutePath());
            }

            AudioInputStream ais = AudioSystem.getAudioInputStream(file);
            Clip clip = AudioSystem.getClip();
            clip.open(ais);
            return clip;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public Clip cargarResource(String ruta) {
        try {
            java.net.URL url = ManagerAudio.class.getResource(ruta);

            if (url == null) {
                throw new RuntimeException("Resource no encontrado: " + ruta);
            }

            AudioInputStream ais = AudioSystem.getAudioInputStream(url);
            Clip clip = AudioSystem.getClip();
            clip.open(ais);
            return clip;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // musiquita
    public void prepararMusica(String ruta){
        if (musicClip != null) {
            musicClip.stop();
            musicClip.close();
        }
        musicClip = cargarFile(ruta);
        if(musicClip != null){
            setVolume(musicClip, musicVol);
        }
    }
    public void iniciarMusica(){
        if(musicClip != null){
            musicClip.setFramePosition(0);
            musicClip.start();
        }
    }
    public void iniciarMusica(int ms){
        if(musicClip != null){
            musicClip.setMicrosecondPosition(ms * 1000L);
            musicClip.start();
        }
    }
    public void playMusica(String ruta) {
        if (musicClip != null && musicClip.isRunning()) musicClip.stop();
        musicClip = cargarResource(ruta);
        if (musicClip != null) {
            setVolume(musicClip, musicVol);
            musicClip.loop(Clip.LOOP_CONTINUOUSLY);
            musicClip.start();
        }
    }
    public void pausarMusica(){
        if (musicClip != null) {
            musicClip.stop();
        }
    }
    public void resumirMusica(){
        if (musicClip != null) {
            musicClip.start();
        }
    }
    public void parar() {
        if (musicClip != null && musicClip.isRunning()) {
            musicClip.stop();
            musicClip.close();
        }
    }
    public void setMusicaVol(float vol) {
        musicVol = vol;
        setVolume(musicClip, vol);
    }
    //preview
    public void playPreview(String ruta, int inicio){
        try{
            if(previewTimer != null){
                previewTimer.stop();
            }
            if(previewClip != null){
                previewClip.stop();
                previewClip.close();
            }
            previewClip = cargarFile(ruta);
            if(previewClip == null) return;
            setVolume(previewClip, musicVol);
            long inicioMicro = inicio * 1_000L;
            previewClip.setMicrosecondPosition(inicioMicro);
            previewClip.start();
            previewTimer = new Timer(
                20000,
                e -> {
                    if(previewClip != null){
                        previewClip.stop();
                        previewClip.setMicrosecondPosition(inicioMicro);
                        previewClip.start();
                    }
                }
            );
            previewTimer.start();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public void stopPreview(){
        if(previewTimer != null){
            previewTimer.stop();
        }
        if(previewClip != null){
            previewClip.stop();
            previewClip.close();
        }
    }
    //editor
    public void setTiempo(long ms){
        if(musicClip == null)
            return;
        musicClip.setMicrosecondPosition(ms * 1000);
    }
    public long getTiempo(){
        if(musicClip == null)
            return 0;
        return musicClip.getMicrosecondPosition() / 1000;
    }

    // sonidos
    public void playSonido(String ruta) {
        Clip sfx = cargarResource(ruta);
        if (sfx != null) {
            setVolume(sfx, sfxVol);
            sfx.start();
        }
    }

    public void setSonidoVol(float vol) {
        sfxVol = vol;
    }

    // control de volumen
    private void setVolume(Clip clip, float volume) {
        if (clip == null) return;
        if (!clip.isControlSupported(FloatControl.Type.MASTER_GAIN)) return;

        FloatControl gain = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);

        float min = gain.getMinimum();
        float max = gain.getMaximum();

        float dB = min + (max - min) * volume;
        gain.setValue(dB);
    }
    
    //para darle a todos los botones
    public void agregarSonidoBotones(Container contenedor, String audioClick, String audioHover){
        for (java.awt.Component c : contenedor.getComponents()) {
            if (c instanceof javax.swing.AbstractButton boton) {
                if (audioClick != null) {
                    boton.addActionListener(e -> ManagerAudio.getInstancia().playSonido(audioClick));
                }
                if (audioHover != null) {
                    boton.addMouseListener(new java.awt.event.MouseAdapter() {
                        @Override
                        public void mouseEntered(java.awt.event.MouseEvent e) {
                            ManagerAudio.getInstancia().playSonido(audioHover);
                        }
                    });
                }
            }
            if (c instanceof java.awt.Container sub) {
                agregarSonidoBotones(sub, audioClick, audioHover);
            }
        }
    }
}
