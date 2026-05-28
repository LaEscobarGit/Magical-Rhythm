package proyecto;

import javax.swing.Timer;

public class MotorGameplay {
    private ManagerTiempo managerTiempo = new ManagerTiempo();
    private Timer timer;
    private boolean pausado;
    private ManagerInput managerInput;
    private ManagerPuntaje managerPuntaje;
    private Nivel nivel;
    private Jugador jugador;
    private GamePanel gamePanel;
    
    public MotorGameplay(ManagerInput managerInput, ManagerPuntaje managerPuntaje, Nivel nivel, Jugador jugador, GamePanel gamePanel){
        this.managerInput = managerInput;
        this.managerPuntaje = managerPuntaje;
        this.nivel = nivel;
        this.jugador = jugador;
        this.gamePanel = gamePanel;
    }

    public void start() {
        int delay = 8;
        managerTiempo.iniciar();   
        timer = new javax.swing.Timer(delay, e -> {
            update();
        });
        timer.start();
    }
    public void update(){
        if(pausado)
            return;
        long tiempoActual = managerTiempo.getTiempo();
        managerInput.update(tiempoActual);
        jugador.update();
        nivel.update(tiempoActual);
        gamePanel.actualizarJuego();
        if(nivel.getMetadata().getDuration()<=tiempoActual) finalizar();
    }
    public void finalizar(){
        timer.stop();
        gamePanel.finalizar();
    }
    public long getTiempo(){
        return managerTiempo.getTiempo();
    }
    public ManagerInput getInput() {
        return managerInput;
    }
    public Nivel getNivel(){
        return nivel;
    }
    public void pausar(){
        if(pausado)
            return;
        pausado = true;
        managerTiempo.pausar();
        ManagerAudio.getInstancia().pausarMusica();
    }
    public void resumir(){
        pausado = false;
        managerTiempo.resumir();
        ManagerAudio.getInstancia().resumirMusica();
    }


    //funciones fachada
    public int getPuntaje() { return managerPuntaje.getPuntaje(); }
    public int getCombo()   { return managerPuntaje.getCombo(); }
    public ManagerPuntaje getManagerPuntaje(){ return managerPuntaje; }
    public void keyPressed(int codigo) {
        managerInput.keyPressed(codigo, managerTiempo.getTiempo());
    }
    public void keyReleased(int codigo) {
        managerInput.keyReleased(codigo, managerTiempo.getTiempo());
    }
}
