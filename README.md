# TrackFit
![Diagrama 1](https://github.com/user-attachments/assets/932ead64-ac80-4a71-8245-df723d936a09)


![bocetoActualizado drawio](https://github.com/user-attachments/assets/79e8306e-c768-477e-b6c3-37c5483a5581)


![bocetoActualizado del diagrama de la Aplicacion](https://github.com/user-attachments/assets/e44d1299-eb0e-41c0-92bd-516b021823f8)



##  Clase `Main`
Se encarga de gestionar la interfaz gráfica del usuario (GUI), el inicio de sesión del instructor, la visualización de usuarios asignados y el manejo de la apariencia de la aplicación con un tema claro y oscuro.
## Funcionalidades:
- **Gestión de la ventana principal**: Controla la disposición de los componentes y la visualización de los usuarios asignados al instructor.
- **Tema oscuro y claro**: Permite alternar entre un tema oscuro y claro a través de un checkbox en el menú.
- **Cierre de sesión**: Permite cerrar sesión y regresar a la pantalla inicial de inicio de sesión.
- **Confirmación de salida**: Muestra un cuadro de confirmación cuando se intenta cerrar la aplicación.

## Métodos importantes:

- **`setupWindow()`**: Configura la ventana y sus componentes.
- **`setupIconsAndMenus()`**: Configura los íconos y el menú de la aplicación.
- **`showListFrame(Usuaris u)`**: Muestra la lista de usuarios asignados al instructor.
- **`toggleTheme()`**: Alterna entre el modo oscuro y el modo claro.
- **`applyTheme(boolean isDarkMode)`**: Aplica el tema (oscuro o claro) a la interfaz.
- **`logoutActionPerformed()`**: Cierra sesión y muestra la ventana de inicio de sesión.

## Dependencias:
- **`PanelUsuariosAsignados`**: Panel que muestra los usuarios asignados al instructor.
- **`Usuaris`**: Clase que contiene los datos del instructor.
- **`DialogLogin`**: Cuadro de diálogo para el inicio de sesión.

## Cómo usar:
1. El instructor inicia sesión a través del cuadro de diálogo de acceso.
2. Una vez dentro, puede ver la lista de usuarios asignados.
3. El instructor puede alternar entre el modo oscuro y claro desde el menú de ayuda.
4. Para cerrar sesión, puede utilizar el menú correspondiente.

![Ventana principal de la aplicación ](https://github.com/user-attachments/assets/1e2157e8-95e8-4119-a304-1e97d78f905b)


