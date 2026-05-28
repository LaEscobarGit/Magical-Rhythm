package proyecto;
import java.util.HashMap;
import java.util.Map;
import javax.swing.ImageIcon;

public class AnimacionManager {
    private Map<String, Animacion> animaciones;
    private String estadoActual;

    public AnimacionManager() {
        animaciones = new HashMap<>();
        estadoActual = "Idle";
    }

    public void agregarAnimacion(String estado, Animacion animacion) {
        animaciones.put(estado, animacion);
    }

    public void cambiarEstado(String nuevoEstado, boolean forzar) {
        if (forzar || estadoActual==null || !estadoActual.equals(nuevoEstado)) {
            estadoActual = nuevoEstado;
            Animacion animacion = animaciones.get(estadoActual);
            if(animacion!=null) animacion.reset();
        }
    }

    public ImageIcon obtenerFrame() {
        Animacion animacion = animaciones.get(estadoActual);
        if(animacion == null) return null;
        ImageIcon frame = animacion.siguienteFrame();
        if(frame == null){
            cambiarEstado("Idle", false);
            return animaciones.get("Idle").siguienteFrame();
        }
        return frame;
    }
    public String getEstadoActual(){
        return estadoActual;
    }
    public boolean animacionActiva(){
        Animacion animacion = animaciones.get(estadoActual);
        return animacion != null && animacion.estaActiva();
    }
    public void setMantener(boolean mantener){
        Animacion anim = animaciones.get(estadoActual);
        if(anim != null) anim.setMantener(mantener);
    }
    public void terminarLoop() {
        Animacion anim = animaciones.get(estadoActual);
        if(anim != null){
            anim.setMantener(false);
        }
    }
}

class Animacion{
    private ImageIcon[] inicio;
    private ImageIcon[] loop;
    private ImageIcon[] fin;

    private int frame = 0;
    private Fase fase = Fase.INICIO;
    private int delayFrames = 8;
    private int contador = 0;

    private boolean activa = true;
    private boolean mantenerInterno = false;

    public enum Fase {
        INICIO,
        LOOP,
        FIN,
        TERMINADA
    }

    public Animacion(ImageIcon[] inicio, ImageIcon[] loop, ImageIcon[] fin) {
        this.inicio = inicio;
        this.loop = loop;
        this.fin = fin;
        if(inicio == null && loop!=null){
            fase = Fase.LOOP;
        }
    }

    public ImageIcon siguienteFrame() {
        contador++;
        if (contador < delayFrames) {
            return getFrameActual();
        }
        contador = 0;

        switch (fase) {
            case INICIO:if (inicio != null && frame < inicio.length) {
                            return inicio[frame++];
                        } else {
                            frame = 0;

                            if (loop != null) {
                                fase = Fase.LOOP;
                            } else if (fin != null) {
                                fase = Fase.FIN;
                            } else {
                                fase = Fase.TERMINADA;
                                activa = false;
                            }
                        }
            break;
            case LOOP:  if (loop == null) {
                            fase = (fin != null) ? Fase.FIN : Fase.TERMINADA;
                            break;
                        }
                        if (mantenerInterno) {
                            ImageIcon img = loop[frame];
                            frame = (frame + 1) % loop.length;
                            return img;
                        } else {
                            frame = 0;
                            fase = (fin != null) ? Fase.FIN : Fase.TERMINADA;
                            return getFrameActual();
                        }
            //break;
            case FIN:   if (fin != null && frame < fin.length) {
                            return fin[frame++];
                        } else {
                            fase = Fase.TERMINADA;
                            activa = false;
                        }
            break;
            case TERMINADA: return null;
        }

        return getFrameActual();
    }

    private ImageIcon getFrameActual() {
        switch (fase) {
            case INICIO:if (inicio != null && frame < inicio.length) {
                            return inicio[frame];
                        }
            break;
            case LOOP:  if (loop != null) {
                            return loop[frame];
                        }
            break;
            case FIN:   if (fin != null && frame < fin.length) {
                            return fin[frame];
                        }
            break;
        }
        return null;
    }

    public boolean estaActiva() {
        return activa;
    }

    public void reset() {
        mantenerInterno = false;
        contador = 0;
        frame = 0;
        activa = true;
        if(inicio == null && loop!=null){
            fase = Fase.LOOP;
        }else
            fase = Fase.INICIO;
    }

    public void setMantener(boolean mantener){
        this.mantenerInterno = mantener;
    }
}
