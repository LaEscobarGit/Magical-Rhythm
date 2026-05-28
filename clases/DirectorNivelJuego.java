package proyecto;

//Para GamePanel
public class DirectorNivelJuego {
    public Nivel construir(Beatmap beatmap, int dificultad) {
        NivelBuilder builder = new NivelBuilder();
        builder.setBeatmap(beatmap);
        builder.setDificultad(dificultad);
        builder.construirGeneral();
        builder.construirMetadata();
        builder.construirDificultad();
        builder.construirNotas();
        return builder.getNivel();
    }
}

// Para EditorPane
class DirectorNivelEditor {
    private NivelBuilder builder;
    
    public DirectorNivelEditor(Beatmap beatmap) {
        builder = new NivelBuilder();
        builder.setBeatmap(beatmap);
    }

    public void construir(int dificultad) {
        builder.setDificultad(dificultad);
        builder.construirMetadata();
        builder.construirNotas();
    }

    public void cambiarDificultad(int dificultad) {
        builder.setDificultad(dificultad);
        builder.construirNotas();
    }

    public Nivel getNivel() {
        return builder.getNivel();
    }
}