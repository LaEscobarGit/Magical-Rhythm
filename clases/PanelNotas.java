package proyecto;

import java.awt.Point;
import javax.swing.JPanel;

public abstract class PanelNotas extends JPanel{
    public abstract Point getCentro(int linea);
}
