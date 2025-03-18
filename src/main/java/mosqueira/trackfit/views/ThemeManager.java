package mosqueira.trackfit.views;

import java.awt.Color;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JList;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 * Clase para gestionar temas claro y oscuro de la aplicación
 */
public class ThemeManager {

    // Aplicar modo oscuro a múltiples componentes
    public static void applyDarkModeToComponents(JComponent... components) {
        Color darkBackground = Color.DARK_GRAY;
        Color lightText = Color.ORANGE;

        for (JComponent component : components) {
            component.setBackground(darkBackground);
            component.setForeground(lightText);
        }
    }

    // Aplicar modo claro a múltiples componentes
    public static void applyLightModeToComponents(JComponent... components) {
        Color lightBackground = new Color(249, 249, 231);  // Fondo claro
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
        Color lightBackground = new Color(249, 249, 231);
        for (JPanel panel : panels) {
            panel.setBackground(lightBackground);
            panel.setForeground(Color.BLACK);
        }
    }

    // Método para redimensionar iconos
    public static ImageIcon resizeIcon(String path, int width, int height) {
        ImageIcon icon = new ImageIcon(ThemeManager.class.getResource(path));
        Image image = icon.getImage();
        Image newImage = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(newImage);
    }

    // Modo oscuro para tablas
    public static void applyDarkModeToTables(JTable... tables) {
        for (JTable table : tables) {
            table.setBackground(Color.DARK_GRAY);
            table.setForeground(Color.ORANGE);
            table.setSelectionBackground(Color.GRAY);
            table.setSelectionForeground(Color.WHITE);
            table.getTableHeader().setBackground(Color.DARK_GRAY);
            table.getTableHeader().setForeground(Color.ORANGE);
        }
    }

    // Modo claro para tablas
    public static void applyLightModeToTables(JTable... tables) {
        for (JTable table : tables) {
            table.setBackground(new Color(249, 249, 231));
            table.setForeground(Color.BLACK);
            table.setSelectionBackground(Color.LIGHT_GRAY);
            table.setSelectionForeground(Color.BLACK);
            table.getTableHeader().setBackground(new Color(249, 249, 231));
            table.getTableHeader().setForeground(Color.BLACK);
        }
    }

    // Modo oscuro para listas
    public static void applyDarkModeToLists(JList<?>... lists) {
        for (JList<?> list : lists) {
            list.setBackground(Color.DARK_GRAY);
            list.setForeground(Color.ORANGE);
            list.setSelectionBackground(Color.GRAY);
            list.setSelectionForeground(Color.WHITE);
        }
    }

    // Modo claro para listas
    public static void applyLightModeToLists(JList<?>... lists) {
        for (JList<?> list : lists) {
            list.setBackground(new Color(249, 249, 231));
            list.setForeground(Color.BLACK);
            list.setSelectionBackground(Color.LIGHT_GRAY);
            list.setSelectionForeground(Color.BLACK);
        }
    }
}
