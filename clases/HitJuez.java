package proyecto;

public interface HitJuez {
    Juicio juzgar(long diferencia);
}

class JuezNormal implements HitJuez{
    public JuezNormal(){}
    @Override
    public Juicio juzgar(long diferencia){
        diferencia = Math.abs(diferencia);
        if(diferencia <= 50) return Juicio.PERFECTO;
        if(diferencia <= 130) return Juicio.BIEN;
        return Juicio.MISS;
    }
}