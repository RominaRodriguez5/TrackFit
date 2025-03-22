package mosqueira.trackfit.views;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.DefaultListCellRenderer;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.table.*;


/**
 * Clase para gestionar temas claro y oscuro de la aplicación
 */
public class ThemeManager {

    // Aplicar modo oscuro a múltiples componentes
    public static void applyDarkModeToComponents(JComponent... components) {
        Color darkBackground = Color.LIGHT_GRAY;
        Color lightText = Color.WHITE;

        for (JComponent component : components) {
            component.setBackground(darkBackground);
            component.setForeground(lightText);
        }
    }

    // Aplicar modo claro a múltiples componentes
    public static void applyLightModeToComponents(JComponent... components) {
        Color lightBackground = new Color(204, 204, 204);  // Fondo claro
        Color darkText = Color.BLACK;

        for (JComponent component : components) {
            component.setBackground(lightBackground);
            component.setForeground(darkText);
        }
    }

    // Métodos para aplicar modo oscuro a paneles
    public static void applyDarkMode(JPanel... panels) {
        for (JPanel panel : panels) {
            panel.setBackground(Color.DARK_GRAY);
        }
    }

    // Métodos para aplicar modo claro a paneles
    public static void applyLightMode(JPanel... panels) {
        Color lightBackground = new Color(204, 204, 204);
        for (JPanel panel : panels) {
            panel.setBackground(lightBackground);
            panel.setForeground(Color.LIGHT_GRAY);
        }
    }

    // Método para redimensionar iconos
    public static ImageIcon resizeIcon(String path, int width, int height) {
        ImageIcon icon = new ImageIcon(ThemeManager.class.getResource(path));
        Image image = icon.getImage();
        Image newImage = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(newImage);
    }

    // Aplicar modo oscuro a tablas y listas con mejores colores
    public static void applyDarkModeToTablesAndLists(JTable[] tables, JList<?>[] lists) {
        Color tableBackground = new Color(245, 245, 245); // Gris claro
        Color rowColor = new Color(224, 224, 224); // Filas alternas más claras
        Color hoverColor = new Color(211, 211, 211); // Gris suave (Hover)
        Color textColor = Color.BLACK;

        for (JTable table : tables) {
            table.setBackground(tableBackground);
            table.setForeground(textColor);
            table.setGridColor(Color.GRAY);
            table.setSelectionBackground(new Color(100, 100, 100));
            table.setSelectionForeground(Color.WHITE);
            table.setRowHeight(30);

            // Estilo del encabezado de la tabla
            JTableHeader tableHeader = table.getTableHeader();
            tableHeader.setBackground(new Color(30, 58, 95)); // Azul oscuro
            tableHeader.setForeground(Color.WHITE);
            tableHeader.setFont(new Font("Arial", Font.PLAIN, 18));

            // Renderizador con efecto de hover
            HoverTableCellRenderer renderer = new HoverTableCellRenderer(rowColor, tableBackground, hoverColor, textColor);
            table.setDefaultRenderer(Object.class, renderer);

            // Listener para detectar el hover en JTable
            table.addMouseMotionListener(new MouseAdapter() {
                @Override
                public void mouseMoved(MouseEvent e) {
                    int row = table.rowAtPoint(e.getPoint());
                    renderer.setHoveredRow(row);
                    table.repaint();
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    renderer.setHoveredRow(-1);
                    table.repaint();
                }
            });
        }

        //  Aplicar modo oscuro y hover a listas (JList)
        for (JList<?> list : lists) {
            list.setBackground(tableBackground);
            list.setForeground(textColor);
            list.setSelectionBackground(new Color(100, 100, 100));
            list.setSelectionForeground(Color.WHITE);
            list.setFont(new Font("Arial", Font.PLAIN, 18));

            HoverListCellRenderer renderer = new HoverListCellRenderer(tableBackground, hoverColor, textColor);
            list.setCellRenderer(renderer);

            // Listener para el hover en JList
            list.addMouseMotionListener(new MouseAdapter() {
                @Override
                public void mouseMoved(MouseEvent e) {
                    int index = list.locationToIndex(e.getPoint());
                    renderer.setHoveredIndex(index);
                    list.repaint();
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    renderer.setHoveredIndex(-1);
                    list.repaint();
                }
            });
        }
    }

    /**
     * Renderizador de celdas de JTable con efecto hover y colores mejorados
     */
    static class HoverTableCellRenderer extends DefaultTableCellRenderer {

        private final Color rowColor;
        private final Color defaultBackground;
        private final Color hoverColor;
        private final Color textColor;
        private int hoveredRow = -1;

        public HoverTableCellRenderer(Color rowColor, Color defaultBackground, Color hoverColor, Color textColor) {
            this.rowColor = rowColor;
            this.defaultBackground = defaultBackground;
            this.hoverColor = hoverColor;
            this.textColor = textColor;
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            if (isSelected) {
                cell.setBackground(new Color(100, 100, 100));
            } else if (row == hoveredRow) {
                cell.setBackground(hoverColor);
            } else {
                cell.setBackground(row % 2 == 0 ? rowColor : defaultBackground);
            }
            cell.setForeground(textColor);
            return cell;
        }

        public void setHoveredRow(int row) {
            this.hoveredRow = row;
        }
    }

    /**
     * Renderizador de celdas de JList con efecto hover y colores mejorados
     */
    static class HoverListCellRenderer extends DefaultListCellRenderer {

        private final Color defaultBackground;
        private final Color hoverColor;
        private final Color textColor;
        private int hoveredIndex = -1;

        public HoverListCellRenderer(Color defaultBackground, Color hoverColor, Color textColor) {
            this.defaultBackground = defaultBackground;
            this.hoverColor = hoverColor;
            this.textColor = textColor;
        }

        @Override
        public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
            Component renderer = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
            if (isSelected) {
                renderer.setBackground(new Color(100, 100, 100));
            } else if (index == hoveredIndex) {
                renderer.setBackground(hoverColor);
            } else {
                renderer.setBackground(defaultBackground);
            }
            renderer.setForeground(textColor);
            return renderer;
        }

        public void setHoveredIndex(int index) {
            this.hoveredIndex = index;
        }
    }
}
