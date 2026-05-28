package proyecto;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.Timer;

public class Jugador extends JLabel{
    AnimacionManager animManager;
    private boolean mantener = false;
    public Jugador() {
        animManager = new AnimacionManager();
        animManager.agregarAnimacion("Idle", new Animacion(null,new ImageIcon[]{
            new ImageIcon(getClass().getResource("/proyecto/recursos/imagenes/madoka/madoka_idle_1.png")),
            new ImageIcon(getClass().getResource("/proyecto/recursos/imagenes/madoka/madoka_idle_2.png")),
            new ImageIcon(getClass().getResource("/proyecto/recursos/imagenes/madoka/madoka_idle_3.png")),
            new ImageIcon(getClass().getResource("/proyecto/recursos/imagenes/madoka/madoka_idle_4.png")),
            new ImageIcon(getClass().getResource("/proyecto/recursos/imagenes/madoka/madoka_idle_5.png")),
            new ImageIcon(getClass().getResource("/proyecto/recursos/imagenes/madoka/madoka_idle_6.png")),
            new ImageIcon(getClass().getResource("/proyecto/recursos/imagenes/madoka/madoka_idle_7.png")),
            new ImageIcon(getClass().getResource("/proyecto/recursos/imagenes/madoka/madoka_idle_8.png"))
        },null));
        animManager.agregarAnimacion("TapUp", new Animacion(new ImageIcon[]{
            //new ImageIcon(getClass().getResource("/proyecto/recursos/imagenes/madoka/madoka_up_1.png")),
            //new ImageIcon(getClass().getResource("/proyecto/recursos/imagenes/madoka/madoka_up_2.png")),
            //new ImageIcon(getClass().getResource("/proyecto/recursos/imagenes/madoka/madoka_up_3.png")),
            new ImageIcon(getClass().getResource("/proyecto/recursos/imagenes/madoka/madoka_up_4.png")),
            new ImageIcon(getClass().getResource("/proyecto/recursos/imagenes/madoka/madoka_up_5.png")),
            new ImageIcon(getClass().getResource("/proyecto/recursos/imagenes/madoka/madoka_up_6.png")),
            new ImageIcon(getClass().getResource("/proyecto/recursos/imagenes/madoka/madoka_up_7.png")),
            new ImageIcon(getClass().getResource("/proyecto/recursos/imagenes/madoka/madoka_up_8.png"))
        },null,null));
        animManager.agregarAnimacion("TapDown", new Animacion(new ImageIcon[]{
            //new ImageIcon(getClass().getResource("/proyecto/recursos/imagenes/madoka/madoka_down_1.png")),
            //new ImageIcon(getClass().getResource("/proyecto/recursos/imagenes/madoka/madoka_down_2.png")),
            //new ImageIcon(getClass().getResource("/proyecto/recursos/imagenes/madoka/madoka_down_3.png")),
            //new ImageIcon(getClass().getResource("/proyecto/recursos/imagenes/madoka/madoka_down_4.png")),
            new ImageIcon(getClass().getResource("/proyecto/recursos/imagenes/madoka/madoka_down_5.png")),
            new ImageIcon(getClass().getResource("/proyecto/recursos/imagenes/madoka/madoka_down_6.png")),
            new ImageIcon(getClass().getResource("/proyecto/recursos/imagenes/madoka/madoka_down_7.png")),
            new ImageIcon(getClass().getResource("/proyecto/recursos/imagenes/madoka/madoka_down_8.png")),
            new ImageIcon(getClass().getResource("/proyecto/recursos/imagenes/madoka/madoka_down_9.png"))
        },null,null));
        animManager.agregarAnimacion("HoldUp", new Animacion(null,
            new ImageIcon[]{new ImageIcon(getClass().getResource("/proyecto/recursos/imagenes/madoka/madoka_holdup_5.png")),
            new ImageIcon(getClass().getResource("/proyecto/recursos/imagenes/madoka/madoka_holdup_6.png"))},
            new ImageIcon[]{new ImageIcon(getClass().getResource("/proyecto/recursos/imagenes/madoka/madoka_hold_7.png"))}
            //new ImageIcon(getClass().getResource("/proyecto/recursos/imagenes/madoka/madoka_hold_8.png"))}
        ));
        animManager.agregarAnimacion("HoldDown", new Animacion(null,
            new ImageIcon[]{new ImageIcon(getClass().getResource("/proyecto/recursos/imagenes/madoka/madoka_holddown_5.png")),
            new ImageIcon(getClass().getResource("/proyecto/recursos/imagenes/madoka/madoka_holddown_6.png"))},
            new ImageIcon[]{new ImageIcon(getClass().getResource("/proyecto/recursos/imagenes/madoka/madoka_hold_7.png"))}
            //new ImageIcon(getClass().getResource("/proyecto/recursos/imagenes/madoka/madoka_hold_8.png"))}      
        ));
        animManager.agregarAnimacion("Block", new Animacion(new ImageIcon[]{
            //new ImageIcon(getClass().getResource("/proyecto/recursos/imagenes/madoka/madoka_block_1.png")),
            //new ImageIcon(getClass().getResource("/proyecto/recursos/imagenes/madoka/madoka_block_2.png")),
            //new ImageIcon(getClass().getResource("/proyecto/recursos/imagenes/madoka/madoka_block_3.png")),
            new ImageIcon(getClass().getResource("/proyecto/recursos/imagenes/madoka/madoka_block_4.png")),
            new ImageIcon(getClass().getResource("/proyecto/recursos/imagenes/madoka/madoka_block_5.png")),
            new ImageIcon(getClass().getResource("/proyecto/recursos/imagenes/madoka/madoka_block_6.png")),
            new ImageIcon(getClass().getResource("/proyecto/recursos/imagenes/madoka/madoka_block_7.png")),
            new ImageIcon(getClass().getResource("/proyecto/recursos/imagenes/madoka/madoka_block_8.png")),
            new ImageIcon(getClass().getResource("/proyecto/recursos/imagenes/madoka/madoka_block_9.png")),
            new ImageIcon(getClass().getResource("/proyecto/recursos/imagenes/madoka/madoka_block_10.png"))
        },null,null));

        animManager.cambiarEstado("Idle", false);
        mantener = true;

        new Timer(16, e -> update()).start();
    }
    
    public void update() {
        ImageIcon frame = animManager.obtenerFrame();
        if(frame != null)
            setIcon(frame);
    }

    public void setEstado(String estado, boolean mantener, boolean forzar) {
        animManager.cambiarEstado(estado, forzar);
        animManager.setMantener(mantener);
        this.mantener = mantener;
    }
    public String getEstado(){
        return animManager.getEstadoActual();
    }
    public boolean animacionActiva(){
        return animManager != null && animManager.animacionActiva();
    }
    public void mantenerAnimacion(boolean mantener){
        animManager.setMantener(mantener);
    }
    public void terminarAnimacionLoop(){
        animManager.terminarLoop();
    }
}
