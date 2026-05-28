package proyecto;

public class ManagerPuntaje implements JuegoEventoListener{
    private int combo = 0;
    private int maxCombo = 0;
    private double comboMult = 1.0;
    private int notas = 0;
    private int puntaje = 0;
    private int perfecto = 0;
    private int bien = 0;
    
    public ManagerPuntaje(int notas){
        this.notas = notas;
    }
    
    @Override
    public void onCombo(boolean miss) {
        setCombo(miss);
    }
    @Override
    public void onNota(Juicio juicio) {
        calcularPuntos(juicio);
    }
    
    public int getPuntaje(){
        return puntaje;
    }
    public int getCombo(){
        return combo;
    }
    public int getMaxCombo(){
        return maxCombo;
    }
    public double getAcc(){
        double valor = (double)(100.00/notas);
        System.out.println("valor: "+valor);
        System.out.println("notas: "+notas);
        return ((perfecto*valor) + ((bien*valor)/2));
    }
    public String getGrado(){
        double acc = getAcc();
        System.out.println("acc: "+acc);
        if(acc==100.00)
            return "SSS";
        else if(acc>=95.00)
            return "SS";
        else if(acc>=90.00)
            return "S";
        else if(acc>=85.00)
            return "A";
        else if(acc>=75.00)
            return "B";
        else if(acc>=60.00)
            return "C";
        return "D";
    }
    public int getPerfect(){
        return perfecto;
    }
    public int getBien(){
        return bien;
    }
    public int getMiss(){
        return notas - (perfecto+bien);
    }
    public void setCombo(boolean miss){
        if(miss){
            combo = 0;
            comboMult=1.0;
        }else{
            combo++;
            if(combo%10==0 && combo<=90)
                comboMult+=0.1;    
        }
        if(combo>maxCombo)
            maxCombo = combo;
    }
    public int calcularPuntos(Juicio juicio){
        puntaje += (int)(200*comboMult*(juicio.getMulti()));
        if(juicio == Juicio.PERFECTO)
            perfecto++;
        else if (juicio == Juicio.BIEN)
            bien++;
        return puntaje;
    }
}

