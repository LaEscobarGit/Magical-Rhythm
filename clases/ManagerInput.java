package proyecto;

import java.util.HashSet;
import java.util.Set;

public class ManagerInput {
    private int key1;
    private int key2;
    private int key3;
    private int key4;
    private int blockKey;
    private int escKey;
    private Set<Integer> teclasPresionadas = new HashSet<>();
    private long tiempoActual;
    private GamePanel panel;
    private Jugador jugador;
    private Nivel nivel;
    private HitJuez juez;
    private JuegoEventoListener listener;

    public ManagerInput(GamePanel panel, Jugador jugador, Nivel nivel, JuegoEventoListener listener){
        this.panel = panel;
        this.jugador = jugador;
        this.nivel = nivel;
        this.juez = new JuezNormal();
        this.listener = listener;
        key1 = 68;
        key2 = 70;
        key3 = 74;
        key4 = 75;
        blockKey = 32;
        escKey = 27;
    }
    public boolean setK1(int codigo){
        if(codigo!=key2 && codigo!=key3 && codigo!=key4 && codigo!=blockKey && codigo!=escKey){
            this.key1 = codigo;
            return true;
        }
        return false;
    }
    public boolean setK2(int codigo){
        if(codigo!=key1 && codigo!=key3 && codigo!=key4 && codigo!=blockKey && codigo!=escKey){
            this.key2 = codigo;
            return true;
        }
        return false;
    }
    public boolean setK3(int codigo){
        if(codigo!=key1 && codigo!=key2 && codigo!=key4 && codigo!=blockKey && codigo!=escKey){
            this.key3 = codigo;
            return true;
        }
        return false;
    }
    public boolean setK4(int codigo){
        if(codigo!=key1 && codigo!=key2 && codigo!=key3 && codigo!=blockKey && codigo!=escKey){
            this.key4 = codigo;
            return true;
        }
        return false;
    }
    public boolean setBlock(int codigo){
        if(codigo!=key1 && codigo!=key2 && codigo!=key3 && codigo!=key4 && codigo!=escKey){
            this.blockKey = codigo;
            return true;
        }
        return false;
    }
    public boolean setESC(int codigo){
        if(codigo!=key1 && codigo!=key2 && codigo!=key3 && codigo!=key4 && codigo!=blockKey){
            this.escKey = codigo;
            return true;
        }
        return false;
    }
    public void keyPressed(int codigo, long tiempoActual){
        this.tiempoActual = tiempoActual;
        teclasPresionadas.add(codigo);
        procesar(codigo);
    }
    public void keyReleased(int codigo, long tiempoActual){
        this.tiempoActual = tiempoActual;
        teclasPresionadas.remove(codigo);
        int linea = mapearLinea(codigo);
        NotaHold hold = nivel.getHoldActivo(linea, tiempoActual);
        if(hold != null){
            jugador.terminarAnimacionLoop();
            hold.terminar();
        }
        if(teclasPresionadas.isEmpty() && !jugador.animacionActiva())
            jugador.setEstado("Idle", true, false);
    }
    public int mapearLinea(int codigo){
        if(codigo==key1 || codigo==key2)return 0;
        if(codigo==key3 || codigo==key4)return 1;
        if(codigo==blockKey)return 2;
        return -1;
    }
    public void procesar(int codigo){
        int linea = mapearLinea(codigo);
        if(linea==-1) return;

        Nota nota = nivel.getMejorNota(linea, tiempoActual);
        if(nota!=null && nota.puedePresionar(tiempoActual)){
            animar(nota);
            long diferencia = tiempoActual - nota.getInicio();
            Juicio resultado = juez.juzgar(diferencia);
            if(resultado!=Juicio.MISS){
                listener.onCombo(false);
                panel.hit(nota.getLinea(), resultado);
                if(nota instanceof NotaHold hold)
                    hold.iniciar();
                else
                    nota.consumir();
            }else{
                listener.onCombo(true);
            }
            listener.onNota(resultado);
            if(nota instanceof NotaHold) return;
        }
        
        if(codigo == blockKey){
            jugador.setEstado("Block",false,true);
        }else if(codigo == key1 || codigo == key2){
            jugador.setEstado("TapUp",false,true);
        }else if(codigo == key3 || codigo == key4){
            jugador.setEstado("TapDown",false,true);
        }
    }
    public void procesarHoldMash(int codigo){
        int linea = mapearLinea(codigo);
        if(linea==-1) return;

        Nota nota = nivel.getMejorNota(linea, tiempoActual);
        if(nota instanceof NotaHold hold && hold.estaActivo(tiempoActual)){
            jugador.mantenerAnimacion(true);
        }
    }
    public void animar(Nota nota){
        if(nota instanceof NotaHold){
            if(nota.getLinea()==0)
                jugador.setEstado("HoldUp", true, false);
            else
                jugador.setEstado("HoldDown", true, false);
            jugador.mantenerAnimacion(true);
            return;
        }
        if(nota instanceof NotaTap){
            if(nota.getLinea()==0)
                jugador.setEstado("TapUp",false,true);
            else
                jugador.setEstado("TapDown",false,true);
            nota.consumir();
            return;
        }
        if(nota instanceof NotaBlock){
            jugador.setEstado("Block",false,true);
            return;
        }
    }
    
    public void update(long tiempoActual){
        this.tiempoActual = tiempoActual;
        for(int codigo:teclasPresionadas){
            procesarHoldMash(codigo);
        }
        if(teclasPresionadas.isEmpty()){
            if(!jugador.animacionActiva())
                jugador.setEstado("Idle",true,false);
        }
    }
}
