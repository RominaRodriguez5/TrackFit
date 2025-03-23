# TrackFit


#Diagrama inicial 

![Diagrama 1](https://github.com/user-attachments/assets/932ead64-ac80-4a71-8245-df723d936a09)


#Diagrama actualizado 

![bocetoActualizado drawio](https://github.com/user-attachments/assets/79e8306e-c768-477e-b6c3-37c5483a5581)

#Diagrama final

![bocetoActualizado del diagrama de la Aplicacion](https://github.com/user-attachments/assets/e44d1299-eb0e-41c0-92bd-516b021823f8)


# Clase `Main`
Se encarga de gestionar la interfaz gráfica del usuario (GUI), el inicio de sesión del instructor, la visualización de usuarios asignados y el manejo de la apariencia de la aplicación con un tema claro y oscuro.
## Funcionalidades:
- **Gestión de la ventana principal**: Controla la disposición de los componentes y la visualización de los usuarios asignados al instructor.
- **Tema oscuro y claro**: Permite alternar entre un tema oscuro y claro a través de un checkbox en el menú.
- **Cierre de sesión**: Permite cerrar sesión y regresar a la pantalla inicial de inicio de sesión.
- **Confirmación de salida**: Muestra un cuadro de confirmación cuando se intenta cerrar la aplicación.


![Ventana principal de la aplicación ](https://github.com/user-attachments/assets/1e2157e8-95e8-4119-a304-1e97d78f905b)

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



# Clase `DialogLogin`
La clase `DialogLogin` es una ventana emergente (diálogo modal) que permite a un instructor iniciar sesión en la aplicación. Ofrece campos para ingresar el correo electrónico y la contraseña, junto con una opción para alternar entre modo oscuro y claro. Si las credenciales son correctas, el instructor accede a la ventana principal de la aplicación. 

## Funcionalidades:
- **Inicio de sesión**: Permite al instructor iniciar sesión con su correo electrónico y contraseña.
- **Modo oscuro**: Permite alternar entre modo oscuro y claro mediante un checkbox en el menú de la interfaz.
- **Mostrar/ocultar contraseña**: Permite al usuario ver o esconder la contraseña ingresada.

![Ventana Login donde se incia sesion](https://github.com/user-attachments/assets/29cb9b9d-0827-48b6-9da9-4d48303a8f51)

## Métodos importantes:

- **`applyDarkMode(boolean isDarkMode)`**: Cambia el tema de la interfaz entre modo oscuro y claro.
- **`addIcons()`**: Añade íconos a los campos de texto y botones.
- **`botonAccesoActionPerformed()`**: Valida el inicio de sesión mediante el correo electrónico y la contraseña.
- **`jMenuReturnActionPerformed()`**: Cierra el cuadro de diálogo de inicio de sesión.
- **`jMenufileActionPerformed()`**: Agrega la opción de "modo oscuro" al menú de la aplicación.

## Dependencias:
- **`Main`**: Ventana principal de la aplicación que interactúa con `DialogLogin` para gestionar el inicio de sesión.
- **`DataAccess`**: Proporciona el acceso a la base de datos para verificar las credenciales del usuario.
- **`Usuaris`**: Clase que representa al usuario (en este caso, al instructor) que está intentando iniciar sesión.

## Cómo usar:
1. El instructor ingresa su correo electrónico y contraseña.
2. El sistema valida las credenciales.
3. Si las credenciales son correctas, el instructor accede a la siguiente ventana .
4. El instructor puede alternar entre el modo oscuro y claro utilizando el menú.



# Clase PanelUsuariosAsignados
Es una clase en Java Swing que permite gestionar los entrenamientos y ejercicios asignados a un usuario en un sistema de gestión de entrenamientos. Proporciona funcionalidades para visualizar, agregar, editar y eliminar entrenamientos y ejercicios, así como asignar ejercicios a un entrenamiento específico.

## Funcionalidades
- Mostrar la lista de entrenamientos asignados a un usuario.
- Mostrar los ejercicios disponibles en el sistema.
- Asignar ejercicios a entrenamientos.
- Agregar nuevos ejercicios.
- Editar ejercicios existentes.
- Eliminar ejercicios de la base de datos.

![Ventana de interaccion del instructor con la aplicacion](https://github.com/user-attachments/assets/37fa384f-a0b3-4e33-9c23-9e224525a695)

## Estructura de la Clase
### Métodos Principales:
- **`addWorkoutsButtonActionPerformed(evt)`**  
  Abre un diálogo que muestra los entrenamientos asignados a un usuario.

- **`listExercicisAssignedWorkouts(listExercicis)`**  
  Muestra la lista de ejercicios asignados a un entrenamiento en un `JList`.

- **`inicializarTablaWorkouts()`**  
  Inicializa la tabla de entrenamientos con columnas predefinidas (`Workout`, `ForDate`, `Comments`).

- **`updateTableWorkouts(userId)`**  
  Carga y actualiza la lista de entrenamientos de un usuario desde la base de datos.

- **`inicializarTablaListaExercicis()`**  
  Inicializa la tabla de ejercicios con datos de la base de datos.

- **`updateTableExercicis(exercici)`**  
  Actualiza la tabla de ejercicios con la información proporcionada.

- **`showExerciseButtonActionPerformed(evt)`**  
  Carga y muestra todos los ejercicios disponibles en la base de datos.

- **`addExerciseButtonActionPerformed(evt)`**  
  Muestra un diálogo para agregar un nuevo ejercicio.

- **`exercisesTableMouseClicked(evt)`**  
  Maneja la selección de un ejercicio en la tabla y habilita el botón de edición.

- **`editExerciseButtonActionPerformed(evt)`**  
  Abre un diálogo para editar un ejercicio seleccionado.

- **`deleteExerciseButtonActionPerformed(evt)`**  
  Permite eliminar un ejercicio de la base de datos tras confirmación del usuario.

- **`addExerciseToWorkoutButtonActionPerformed(evt)`**  
  Asigna ejercicios seleccionados a un entrenamiento específico en la base de datos.

## Uso
1. Seleccionar un usuario en la interfaz principal.
2. Ver entrenamientos asignados y agregar nuevos si es necesario.
3. Ver la lista de ejercicios disponibles.
4. Asignar ejercicios a entrenamientos.
5. Editar o eliminar ejercicios según sea necesario.
6.  Uso del Componente Calendar
Se puede descargar el JAR del Componente Calendar desde los tags del repositorio y agregarlo manualmente a tu proyecto.
El **Componente Calendar** se utiliza para visualizar y seleccionar fechas en las que se han programado entrenamientos.
### Instalación
Para utilizar este componente, debes incluir la siguiente dependencia en tu archivo **pom.xml** (si usas Maven):

```xml
<dependency>
    <groupId>mosqueira</groupId>
    <artifactId>ComponenteCalendar</artifactId>
    <version>1.0-SNAPSHOT</version>
</dependency>

# Después de añadir la dependencia, importa el componente en tu clase:
