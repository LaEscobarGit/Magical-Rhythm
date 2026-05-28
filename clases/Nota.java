package proyecto;

public abstract class Nota {
    private int linea;
    private long inicio;
    private long fin;
    private boolean activada = false;
    private long tiempoAparicion = 2000;
    private double margen = 150;
    private boolean consumida = false;

    public Nota(int linea, int inicio, int fin){
        this.linea = linea;
        this.inicio = (long) inicio;
        this.fin = (long) fin;
    }
    public void update(long tiempoActual) {
        if (!activada && tiempoActual >= (inicio - tiempoAparicion)) {
            activada = true;
        }
    }
    public boolean esVisible(long tiempoActual) {
        return activada && !consumida && !yaPaso(tiempoActual);
    }
    public boolean debeAparecer(long tiempoActual){
        return tiempoActual>=(inicio - tiempoAparicion);
    }
    public boolean yaPaso(long tiempoActual){
        return tiempoActual>(inicio + margen);
    }
    public double getX(long tiempoActual, double hitX){
        double velocidad = 0.5;
        long tiempoRestante = inicio - tiempoActual;
        return hitX + (tiempoRestante * velocidad);
    }
    public boolean puedePresionar(long tiempoActual){
        return !consumida && Math.abs(inicio - tiempoActual) <= margen;
    }
    public void consumir(){
        consumida = true;
    }
    
    //setters y getters
    public int getLinea(){
        return linea;
    }
    public void setLinea(int linea){
        this.linea = linea;
    }
    public long getInicio(){
        return inicio;
    }
    public void setInicio(int inicio){
        this.inicio = (long) inicio;
    }
    public long getFin(){
        return fin;
    }
    public void setFin(int fin){
        this.fin = (long) fin;
    }
    public boolean getConsumida(){
        return consumida;
    }
}
class NotaTap extends Nota{
    public NotaTap(int linea, int inicio, int fin){
        super(linea,inicio, fin);
    }
}
class NotaHold extends Nota{
    private boolean iniciado = false;
    public NotaHold(int linea, int inicio, int fin){
        super(linea, inicio, fin);
    }
    
    @Override
    public boolean puedePresionar(long tiempoActual){
        if(iniciado)
            return !getConsumida() && tiempoActual <= getFin();
        return !getConsumida() && Math.abs(getInicio() - tiempoActual) <= 150;
    }
    @Override
    public boolean yaPaso(long tiempoActual){
        return tiempoActual > (getFin() + 150);
    }
    public boolean estaActivo(long tiempoActual) {
        return iniciado && !getConsumida() && tiempoActual <= getFin();
    }
    public void iniciar() {
        iniciado = true;
    }
    public void terminar() {
        consumir();
    }
}

class NotaBlock extends Nota{
    public NotaBlock(int linea, int inicio, int fin){
        super(linea,inicio, fin);
    }
}

class NotaFactory{
    public NotaFactory(){}
    public Nota crearNota(int[] datos){
        int tipo = datos[1];
        if(tipo == 0)
            return new NotaTap(datos[0], datos[2], -1);
        else if(tipo == 1)
            return new NotaHold(datos[0], datos[2], datos[3]);
        return new NotaBlock(2, datos[2], -1);
    }
    public Nota crearNota(String tipo, int linea, int tiempo) {
        return switch(tipo) {
            case "tap"   -> new NotaTap(linea, tiempo, -1);
            case "hold"  -> new NotaHold(linea, tiempo, tiempo + 1000);
            case "block" -> new NotaBlock(2, tiempo, -1);
            default      -> null;
        };
    }
}
