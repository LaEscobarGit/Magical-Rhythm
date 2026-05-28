package proyecto;
import java.util.ArrayList;
import java.util.List;

public class Nivel {
    private General general;
    private Difficulty dificultad;
    private Metadata metadata;
    private List<Nota> notas;
    private JuegoEventoListener listener;
    private int cont=0;

    public Nivel(){
        notas = new ArrayList<>();
    }

    public void setListener(JuegoEventoListener listener) {
        this.listener = listener;
    }
    public void setGeneral(General general){
        this.general = general;
    }
    public void setMetadata(Metadata metadata){
        this.metadata = metadata;
    }
    public void setDificultad(Difficulty dificultad){
        this.dificultad = dificultad;
    }
    public void agregarNota(Nota nota){
        notas.add(nota);
    }
    public void update(long tiempoActual){
        for (Nota n : notas) {
            n.update(tiempoActual);
            if (!n.getConsumida() && n.yaPaso(tiempoActual)) {
                n.consumir();
                listener.onCombo(true);
                listener.onNota(Juicio.MISS);
            }
        }

        notas.removeIf(n -> n.getConsumida() && n.yaPaso(tiempoActual));
    }
    public List<Nota> getNotasVisibles(long tiempoActual){
        List<Nota> visibles = new ArrayList<>();
        for (Nota n : notas) {
            if (n.esVisible(tiempoActual)) {
                visibles.add(n);
            }
        }
        return visibles;
    }
    public Nota getMejorNota(int linea, long tiempoActual) {
        Nota mejor = null;
        double mejorDistancia = Double.MAX_VALUE;

        for (Nota n : notas) {
            if (n.getLinea() != linea) continue;
            if (n.getConsumida()) continue;
            if(n instanceof NotaHold hold && hold.estaActivo(tiempoActual)) continue;
            double distancia = Math.abs(n.getInicio() - tiempoActual);
            if (distancia < mejorDistancia && n.puedePresionar(tiempoActual)) {
                mejorDistancia = distancia;
                mejor = n;
            }
        }
        return mejor;
    }
    public NotaHold getHoldActivo(int linea, long tiempoActual){
        for(Nota n : notas){
            if(n instanceof NotaHold hold && n.getLinea()==linea 
            && !n.getConsumida() && hold.estaActivo(tiempoActual))
                return hold;
        }
        return null;
    }
    public Metadata getMetadata(){
        return metadata;
    }
    public List<Nota> getNotas(){
        return notas;
    }
}
class NivelBuilder{
    private Nivel nivel;
    Beatmap beatmap;
    int dificultad;
    public NivelBuilder(){
        reset();
    }
    public void setBeatmap(Beatmap beatmap){
        this.beatmap = beatmap;
    }
    public void setDificultad(int dificultad){
        this.dificultad = dificultad;
    }
    public void construirGeneral(){
        nivel.setGeneral(beatmap.getGeneral());
    }
    public void construirMetadata(){
        nivel.setMetadata(beatmap.getMetadata());
    }
    public void construirDificultad(){
        nivel.setDificultad(beatmap.getDifficulty().get(dificultad));
    }
    public void construirNotas(){
        nivel.getNotas().clear();
        NotaFactory notaF = new NotaFactory();
        int[][] datos = beatmap.getDifficulty().get(dificultad).getHitObjects();
        for(int i=0; i<datos.length;i++){
            nivel.agregarNota(notaF.crearNota(datos[i]));
        }
    }
    public Nivel getNivel(){
        return nivel;
    }
    public void reset(){
        nivel = new Nivel();
    }
}

