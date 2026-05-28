package proyecto;

public enum Juicio {
    PERFECTO(1.0), BIEN(0.5), MISS(0.0);
    
    private final double multiplicador;
    Juicio(double multiplicador){
        this.multiplicador = multiplicador;
    }
    public double getMulti(){
        return multiplicador;
    }
}
