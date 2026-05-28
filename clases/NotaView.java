package proyecto;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

public class NotaView extends JLabel {
    private Nota nota;
    private PanelNotas panel;
    private Image inicioHold;
    private Image finHold;
    private int xInicio;
    private int xFin;
    private boolean dragInicio = false;
    private boolean dragFin = false;
    private boolean dragCompleto = false;

    public NotaView(Nota nota, PanelNotas panel) {
        this.nota = nota;
        this.panel = panel;

        if(nota instanceof NotaHold){
            inicioHold = new ImageIcon(getClass().getResource("/proyecto/recursos/imagenes/hold_start.png")).getImage();
            finHold = new ImageIcon(getClass().getResource("/proyecto/recursos/imagenes/hold_end.png")).getImage();
            setOpaque(false);
            setSize(2000, Math.max(inicioHold.getHeight(this), 100));
        }else if(nota instanceof NotaBlock){
            ImageIcon icon = new ImageIcon(getClass().getResource("/proyecto/recursos/imagenes/block.png"));
            setIcon(icon);
            setSize(icon.getIconWidth(),icon.getIconHeight());
        }else{
            ImageIcon icon = new ImageIcon(getClass().getResource("/proyecto/recursos/imagenes/tap.png"));
            setIcon(icon);
            setSize(icon.getIconWidth(), icon.getIconHeight());
        }

        //para el editor
        if(panel instanceof EditorPane editor){
            addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    if(SwingUtilities.isRightMouseButton(e)){
                        editor.eliminarNota(NotaView.this);
                        return;
                    }
                    if(nota instanceof NotaHold){
                        int mouseX = e.getX();
                        if(mouseX < 40)
                            dragInicio = true;
                        else if(mouseX > getWidth() - 40)
                            dragFin = true;
                        else
                            dragCompleto = true;
                    }else
                        dragCompleto = true;
                    editor.iniciarDragNota(NotaView.this, e);
                }

                @Override
                public void mouseReleased(MouseEvent e) {
                    editor.soltarDragNota(NotaView.this, e);
                    dragInicio = false;
                    dragFin = false;
                    dragCompleto = false;
                }
            });

            addMouseMotionListener(new MouseMotionAdapter() {
                @Override
                public void mouseDragged(MouseEvent e) {
                    editor.dragNota(NotaView.this, e);
                }
            });
        }
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);    
        if(!(nota instanceof NotaHold))
            return;
        
        int inicioX = xInicio - getX();
        int finX = xFin - getX();
        int left = Math.min(inicioX, finX);
        int right = Math.max(inicioX, finX);
        int inicioW = inicioHold.getWidth(this);
        int inicioH = inicioHold.getHeight(this);
        int finW = finHold.getWidth(this);
        int finH = finHold.getHeight(this);
        int inicioY = (getHeight()/2) - (inicioH/2);
        int finY = (getHeight()/2) - (finH/2);
        int barraH = 44;
        int barraY = (getHeight()/2) - (barraH/2);
        // centro
        g.setColor(java.awt.Color.BLACK);
        g.fillRect(left + inicioW,barraY,(right - left) - inicioW - finW,barraH);
        // inicio
        g.drawImage(inicioHold,left,inicioY,this);
        // fin
        g.drawImage(finHold,right - finW,finY,this);
    }
    public void actualizar(long tiempoActual) {
        Point centro = panel.getCentro(nota.getLinea());
        if(nota instanceof NotaBlock){
            int x;
            if(panel instanceof EditorPane editor){
                x = panel.getCentro(nota.getLinea()).x + (int)((nota.getInicio() - tiempoActual) * editor.getZoom() / 2.0);
                x -= getWidth()/2;
            }else{
                int centroX = centro.x;
                x = (int) nota.getX(tiempoActual, centroX);
                x -= getWidth()/2;
            }
            Point up = panel.getCentro(0);
            Point down = panel.getCentro(1);
            int espacio = down.y - up.y;
            int y = up.y - (getHeight() - espacio)/2;
            setLocation(x, y);
            return;
        }if(nota instanceof NotaHold){
            int y = centro.y - 40;
            if(panel instanceof EditorPane editor){
                xInicio = centro.x + (int)((nota.getInicio() - tiempoActual) * editor.getZoom() / 2.0);
                xFin = centro.x + (int)((nota.getFin() - tiempoActual) * editor.getZoom() / 2.0);
            }else{
                int centroX = centro.x;
                xInicio = (int) nota.getX(tiempoActual, centroX);
                long duracion = nota.getFin() - nota.getInicio();
                xFin = (int) nota.getX(tiempoActual - duracion, centroX);
            }
            int inicioW = inicioHold.getWidth(this);
            int finW = finHold.getWidth(this);
            int left = Math.min(xInicio, xFin) - inicioW/2;
            int right = Math.max(xInicio, xFin) + finW/2;
            setBounds(left, y, right - left, 80);
        }else{
            int x;
            if(panel instanceof EditorPane editor){
                x = panel.getCentro(nota.getLinea()).x + (int)((nota.getInicio() - tiempoActual) * editor.getZoom() / 2.0);
                x -= getWidth()/2;
            }else{
                int centroX = centro.x;
                x = (int) nota.getX(tiempoActual, centroX);
                x -= getWidth()/2;
            }
            int y = centro.y - getHeight()/2;
            setLocation(x, y);
        }
    }

    public Nota getNota(){
        return nota;
    }
    public boolean isDragInicio(){
        return dragInicio;
    }
    public boolean isDragFin(){
        return dragFin;
    }
    public boolean isDragCompleto(){
        return dragCompleto;
    }
    public int getXInicio(){
        return xInicio;
    }

    public int getXFin(){
        return xFin;
    }
}

