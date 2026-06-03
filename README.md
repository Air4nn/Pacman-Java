# 🟡 PAC-MAN EN JAVA 🟡  
### 🎮 Proyecto Final – Programación Orientada a Objetos

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
- ⏸️ Pausar / Reanudar  
- 🔄 Reiniciar  
- ❌ Salir  

### 🧱 Laberinto
- Mapa con paredes  
- Distribución de puntos (pellets)  
- Movimiento libre dentro del laberinto  

### 😃 Pac-Man
- Control con teclado  
- Movimiento en 4 direcciones  
- Colisiones con paredes  

### 👻 Fantasmas
- Mínimo 2 enemigos  
- Movimiento automático  
- Ejecutados con **hilos independientes**  

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

### 🔵 Modelo
- Lógica del juego  
- Entidades (Pac-Man, Fantasmas, Mapa)  
- Reglas y estado  

### 🟢 Vista
- Renderizado gráfico  
- Interfaz con Swing  

### 🔴 Controlador
- Eventos de teclado  
- Control del flujo del juego  

---

## 🧠 Programación Orientada a Objetos

El proyecto implementa:

- ✅ Clases y objetos  
- ✅ Encapsulamiento  
- ✅ Herencia (`Entidad → Pacman/Fantasma`)  
- ✅ Polimorfismo  
- ✅ Abstracción  

---

## 🧵 Concurrencia (Hilos)

Se utilizan hilos para:

- Movimiento de fantasmas 👻  
- Temporizador del juego ⏱️  
- Animaciones  

---

## 🖥️ Interfaz Gráfica

Desarrollada con **Java Swing**:

- Ventana principal  
- Renderizado del mapa  
- Animaciones básicas  
- Panel de puntuación  
- Mensajes del juego  

---

## 📊 Diagramas UML

### 📌 Incluye:
- Diagrama de clases (obligatorio)  
- Relaciones, herencia y métodos  

### ⭐ Opcional:
- Casos de uso  
- Secuencia  

---

## ⚙️ Requisitos del Sistema

- Java JDK 8 o superior  
- IDE recomendado: IntelliJ / NetBeans / Eclipse  

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

## 👨‍💻 Autores
Nombre: Airann Estiben Yepes Barrera 

Nombre: Esteban Enrique Gonzalez Guzman 

---

## 📚 Conclusión

Este proyecto integra múltiples conceptos clave como POO, concurrencia y diseño de software, permitiendo desarrollar una aplicación interactiva completa y estructurada.

---

## 🏁 Estado del Proyecto

🚧 En desarrollo 
