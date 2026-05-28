package proyecto;

public class ManagerTiempo {
    private long tiempoInicial;
    private long tiempoPausa;
    private long tiempoPausaTotal = 0;
    private boolean pausado;
    
    public ManagerTiempo(){}
    
    public void iniciar(){
        this.tiempoInicial = System.nanoTime();
    }
    public long getTiempo(){
        if(pausado){
            return (tiempoPausa - tiempoInicial - tiempoPausaTotal) / 1_000_000;
        }
        return (System.nanoTime() - tiempoInicial - tiempoPausaTotal) / 1_000_000;
    }
    public void pausar(){
        if(pausado)
            return;
        pausado = true;
        tiempoPausa = System.nanoTime();
    }
    public void resumir(){
        pausado = false;
        tiempoPausaTotal += System.nanoTime() - tiempoPausa;
    }
    
    //metodo para el editor
    public void setTiempo(long ms){
        tiempoInicial = System.nanoTime() - ms * 1_000_000;
    }
}
