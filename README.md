# 🟡 PAC-MAN EN JAVA 🟡  
### 🎮 Proyecto Final – Programación Orientada a Objetos

---

## 👨‍💻 Autores

- Airann Estiben Yepes Barrera 

- Esteban Enrique Gonzalez Guzman 

---
## 📌 Descripción del Proyecto

Este proyecto consiste en el desarrollo del clásico videojuego **Pac-Man**, implementado en **Java**, aplicando los principios fundamentales de la **Programación Orientada a Objetos (POO)**, arquitectura **MVC**, y manejo de **concurrencia con hilos**.

El objetivo es construir una aplicación **completa, modular y mantenible**, integrando todos los conocimientos adquiridos durante el curso.

---

## 🎯 Objetivos

### 🔹 Objetivo General
Desarrollar un videojuego funcional tipo Pac-Man utilizando Java y buenas prácticas de POO.

### 🔹 Objetivos Específicos
- Aplicar **encapsulamiento, herencia, polimorfismo y abstracción**  
- Implementar arquitectura **Modelo - Vista - Controlador (MVC)**  
- Crear una interfaz gráfica con **Java Swing**  
- Utilizar **hilos (Threads)** para elementos dinámicos  
- Diseñar el sistema con **diagramas UML**  

---

## 🕹️ Funcionalidades del Juego

### 🧭 Menú Principal
- ▶️ Iniciar partida  
- ⏸️ Pausar
- 🔄 Reiniciar  
- ❌ Salir  

### 🧱 Laberinto
- Mapa con paredes  
- Distribución de puntos 
- Movimiento libre dentro del laberinto  

### 😃 Pac-Man
- Control con teclado  
- Movimiento en 4 direcciones  
- Colisiones con paredes  

### 👻 Fantasmas
- 4 enemigos de color: amarillo, rojo, azul, rosado
- Movimiento automático  

### 🏆 Sistema de Puntuación
- Conteo de puntos  
- Visualización en pantalla  
- Condición de victoria  

### ❤️ Vidas
- Sistema de vidas limitadas  
- Reinicio de posición al morir  
- Game Over al perder todas  

### 🎮 Estados del Juego
- Inicio  
- En curso  
- Pausa  
- Victoria  
- Game Over  

---

## 🏗️ Arquitectura del Proyecto (MVC)
```bash
📦 Pacman  
┣ 📂 com.mycompany.pacman  
┃ ┗ 📜 Juego.java  
┣ 📂 com.mycompany.pacman.controlador  
┃ ┣ 📜 ControlTeclado.java  
┃ ┗ 📜 ControladorJuego.java  
┣ 📂 com.mycompany.pacman.modelo  
┃ ┣ 📜 Fantasma.java  
┃ ┣ 📜 Mapa.java  
┃ ┣ 📜 Pacman.java  
┃ ┗ 📜 Personaje.java  
┣ 📂 com.mycompany.pacman.vista  
┃ ┣ 📜 PanelJuego.java  
┃ ┗ 📜 VentanaJuego.java  
```

Para el desarrollo del juego Pac-Man se implementó el patrón de diseño MVC (Modelo - Vista - Controlador), con el objetivo de organizar mejor el código, facilitar el mantenimiento y separar las responsabilidades de cada componente del sistema.

### 🔵 Modelo

El modelo contiene toda la información y la lógica principal del juego. En esta se encuentran las clases:

-	Mapa 

-	Personaje 

-	Pacman 

-	Fantasma 

La clase Mapa se encarga de almacenar la matriz que representa el laberinto, las paredes y la comida. Además, contiene métodos para verificar si existe comida en una posición o si una celda corresponde a una pared.

La clase Personaje es una clase abstracta que sirve como base para los personajes del juego. Contiene atributos comunes como la posición y la velocidad.

Las clases Pacman y Fantasma heredan de Personaje. Pacman administra las vidas, el puntaje y el movimiento del jugador, mientras que Fantasma controla el movimiento automático de los enemigos y las validaciones para evitar atravesar paredes o superponerse con otros fantasmas.

### 🟢 Vista 

La vista es la encargada de mostrar la información al usuario de manera gráfica. En este proyecto la vista está compuesta por:

-	PanelJuego 

-	VentanaJuego 

La clase PanelJuego dibuja todos los elementos visuales del juego, como el mapa, Pac-Man, los fantasmas, el puntaje, las vidas y los mensajes de victoria o derrota.

La clase VentanaJuego crea la ventana principal del programa utilizando Java Swing. Además, contiene la barra de menú con las opciones de iniciar, pausar, reiniciar y salir del juego.

La vista únicamente muestra información y no contiene la lógica principal del juego.}

### 🔴 Controlador

El controlador actúa como intermediario entre el modelo y la vista. Su función es recibir las acciones del usuario y actualizar el estado del juego.
Las clases que pertenecen al controlador son:

-	ControladorJuego 

-	ControlTeclado 

La clase ControlTeclado detecta las teclas presionadas por el jugador y cambia la dirección de movimiento de Pac-Man.

La clase ControladorJuego administra el ciclo principal del juego (Game Loop). También controla el movimiento de los personajes, las colisiones con fantasmas, el sistema de puntuación, la condición de victoria, la condición de derrota y las opciones del menú.

### 🟣 Funcionamiento general

Cuando el jugador presiona una tecla, el controlador recibe la acción y actualiza la dirección de movimiento de Pac-Man. Posteriormente, el modelo procesa los movimientos y las reglas del juego. Finalmente, la vista actualiza la representación gráfica mostrando los cambios realizados.
De esta manera, la arquitectura MVC permite mantener una separación clara entre la lógica del juego, la interfaz gráfica y el control de eventos, logrando un código más organizado y fácil de entender.  

---

## 🧠 Programación Orientada a Objetos

El proyecto implementa:

- ✅ Clases y objetos  
- ✅ Encapsulamiento  
- ✅ Herencia (`Entidad → Pacman/Fantasma`)  
- ✅ Polimorfismo  
- ✅ Abstracción  

---

## 🖥️ Interfaz Gráfica

Desarrollada con **Java Swing**:

- Ventana principal  
- Renderizado del mapa  
- Animaciones básicas  
- Panel de puntuación  
- Mensajes del juego  

---

## ⚙️ Requisitos del Sistema

- Java JDK 8 o superior  
- IDE recomendado: IntelliJ / NetBeans / Eclipse / Visual Studio Code

---

## ▶️ Cómo Ejecutar el Proyecto

```bash
# Clonar repositorio
git clone https://github.com/tu-usuario/pacman-java

# Entrar al proyecto
cd pacman-java

# Compilar
javac Main.java

# Ejecutar
java Main
```

---

## 📅 Entregas
🟡 Avance (70%): 3 de junio 2026
🟢 Final (100%): 10 de junio 2026

---

## 📚 Conclusión

Este proyecto integra múltiples conceptos clave como POO, concurrencia y diseño de software, permitiendo desarrollar una aplicación interactiva completa y estructurada.

---

## 🏁 Estado del Proyecto

🚧 En desarrollo 
