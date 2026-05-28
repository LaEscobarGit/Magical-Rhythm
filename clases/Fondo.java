package proyecto;

import java.awt.*;
import javax.swing.*;

public class Fondo extends JPanel {
    private Image imagen;

    public Fondo(String ruta) {
        imagen = new ImageIcon(getClass().getResource(ruta)).getImage();
    }

    public void setImagen(Image imagen){
        this.imagen = imagen;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
    }
}
