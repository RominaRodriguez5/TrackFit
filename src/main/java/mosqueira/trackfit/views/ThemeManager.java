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
 * Clase para gestionar temas claro y oscuro de la aplicación. Esta clase
 * proporciona métodos para aplicar estilos de modo claro y oscuro a componentes
 * gráficos, como paneles, tablas y listas.
 *
 * @author Romina Mosqueira
 */
public class ThemeManager {

    /**
     * Constructor vacío de la clase ThemeManager(). Este constructor crea una
     * nueva instancia de la clase ThemeManager() sin parámetros.
     */
    public ThemeManager() {

    }

    /**
     * Aplica el modo oscuro a una lista de componentes. Establece un fondo
     * oscuro y texto blanco para los componentes proporcionados.
     *
     * @param components los componentes a los que se les aplicará el modo
     * oscuro.
     */
    public static void applyDarkModeToComponents(JComponent... components) {
        Color darkBackground = Color.DARK_GRAY;
        Color lightText = Color.WHITE;

        for (JComponent component : components) {
            component.setBackground(darkBackground);
            component.setForeground(lightText);
        }
    }

    /**
     * Aplica el modo claro a una lista de componentes. Establece un fondo claro
     * y texto oscuro para los componentes proporcionados.
     *
     * @param components los componentes a los que se les aplicará el modo
     * claro.
     */
    public static void applyLightModeToComponents(JComponent... components) {
        Color lightBackground = new Color(204, 204, 204);  // Fondo claro
        Color darkText = Color.BLACK;

        for (JComponent component : components) {
            component.setBackground(lightBackground);
            component.setForeground(darkText);
        }
    }

    /**
     * Aplica el modo oscuro a una lista de paneles. Establece un fondo oscuro
     * para los paneles proporcionados.
     *
     * @param panels los paneles a los que se les aplicará el modo oscuro.
     */
    public static void applyDarkMode(JPanel... panels) {
        for (JPanel panel : panels) {
            if (panel != null) {
                panel.setBackground(Color.DARK_GRAY);
            }
        }
    }

    /**
     * Aplica el modo claro a una lista de paneles. Establece un fondo claro y
     * texto gris para los paneles proporcionados.
     *
     * @param panels los paneles a los que se les aplicará el modo claro.
     */
    public static void applyLightMode(JPanel... panels) {
        Color lightBackground = new Color(204, 204, 204);
        for (JPanel panel : panels) {
            panel.setBackground(lightBackground);
            panel.setForeground(Color.LIGHT_GRAY);
        }
    }

    /**
     * Redimensiona un icono a las dimensiones especificadas.
     *
     * @param path la ruta del icono que se desea redimensionar.
     * @param width el ancho deseado para el icono.
     * @param height la altura deseada para el icono.
     * @return el icono redimensionado.
     */
    public static ImageIcon resizeIcon(String path, int width, int height) {
        java.net.URL imgURL = ThemeManager.class.getResource( path);

        if (imgURL == null) {
            System.err.println("No se pudo cargar la imagen: " + path);
            return null;
        }

        ImageIcon icon = new ImageIcon(imgURL);
        Image image = icon.getImage();
        Image newImage = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(newImage);
    }

    /**
     * Aplica el modo oscuro a tablas y listas, con colores mejorados. Modifica
     * el fondo, los colores de texto, las filas y las selecciones de las tablas
     * y listas.
     *
     * @param tables las tablas a las que se les aplicará el modo oscuro.
     * @param lists las listas a las que se les aplicará el modo oscuro.
     */
    public static void applyDarkModeToTablesAndLists(JTable[] tables, JList<?>[] lists) {
        Color tableBackground = new Color(245, 245, 245); // Gris claro
        Color rowColor = new Color(224, 224, 224); // Filas alternas más claras
        Color hoverColor = new Color(211, 211, 211); // Gris suave (Hover)
        Color textColor = Color.BLACK;

        for (JTable table : tables) {
            table.setBackground(tableBackground);
            table.setForeground(textColor);
            table.setGridColor(Color.DARK_GRAY);
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
            list.setSelectionForeground(Color.LIGHT_GRAY);
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
     * Renderizador de celdas de JTable con efecto hover y colores mejorados.
     * Este renderizador permite que las celdas de la tabla cambien de color al
     * pasar el mouse por encima.
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
     * Renderizador de celdas de JList con efecto hover y colores mejorados.
     * Este renderizador permite que las celdas de la lista cambien de color al
     * pasar el mouse por encima.
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
