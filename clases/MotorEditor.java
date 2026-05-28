package proyecto;

import javax.swing.Timer;

public class MotorEditor{
    private ManagerTiempo managerTiempo = new ManagerTiempo();
    private Timer timer;
    private boolean pausado;
    private EditorPane editor;
    private boolean iniciado = false;

    public MotorEditor(EditorPane editor){
        this.editor = editor;
    }
    public void start(int tiempoInicial) {
        stop();
        pausado = false;
        int delay = 8;
        managerTiempo.setTiempo(tiempoInicial);
        if(!iniciado){
            managerTiempo.iniciar();
            iniciado = true;
        }
        timer = new javax.swing.Timer(delay, e -> {
            update();
        });
        timer.start();
    }
    public void update(){
        if(pausado)
            return;
        editor.update();
    }
    public void stop(){
        pausado = true;

        if (timer != null) {
            timer.stop();
            timer = null;
        }
    }
    public long getTiempo(){
        return managerTiempo.getTiempo();
    }
}
