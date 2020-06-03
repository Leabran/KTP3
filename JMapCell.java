import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

public class JMapCell extends JComponent
{
    private static final Dimension CELL_SIZE = new Dimension(12, 12);

    /** Если истина то ячейка является конечной точкой. **/
    boolean endpoint = false;

    boolean passable = true;

    /** указывает, что эта ячейка является частью пути между началом и концом. **/
    boolean path = false;

    public JMapCell(boolean pass)
    {
        setPreferredSize(CELL_SIZE);

        setPassable(pass);
    }

    public JMapCell()
    {
        this(true);
    }

    /** Помечает эту ячейку как начальную или конечную. **/
    public void setEndpoint(boolean end)
    {
        endpoint = end;
        updateAppearance();
    }

    public void setPassable(boolean pass)
    {
        passable = pass;
        updateAppearance();
    }

    /** Возвращает true, если эта ячейка проходима, или false в противном случае. **/
    public boolean isPassable()
    {
        return passable;
    }

    /** Переключает текущее «проходимое» состояние ячейки карты. **/
    public void togglePassable()
    {
        setPassable(!isPassable());
    }

    /** Помечает эту ячейку как часть пути, обнаруженного алгоритмом A *. **/
    public void setPath(boolean path)
    {
        this.path = path;
        updateAppearance();
    }

    private void updateAppearance()
    {
        if (passable)
        {
            // Passable cell.  Indicate its state with a border.
            setBackground(Color.WHITE);

            if (endpoint)
                setBackground(Color.CYAN);
            else if (path)
                setBackground(Color.GREEN);
        }
        else
        {
            // Impassable cell.  Make it all red.
            setBackground(Color.RED);
        }
    }

    protected void paintComponent(Graphics g)
    {
        g.setColor(getBackground());
        g.fillRect(0, 0, getWidth(), getHeight());
    }
}
