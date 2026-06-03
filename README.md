# 🟡 PAC-MAN EN JAVA 🟡  
### 🎮 Proyecto Final – Programación Orientada a Objetos

---

## 📌 Descripción del Proyecto

Este proyecto consiste en el desarrollo del clásico videojuego **Pac-Man**, implementado en **Java**, aplicando los principios fundamentales de la **Programación Orientada a Objetos (POO)**, arquitectura **MVC**, y manejo de **concurrencia junto con hilos**.

El objetivo es construir una aplicación **completa, modular y mantenible**, ademas de **eficaz y eficiente** integrando todos los conocimientos adquiridos durante el curso.

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
📦 Proyecto
 ┣ 📂 modelo
 ┃ ┣ Entidad.java
 ┃ ┣ Pacman.java
 ┃ ┣ Fantasma.java
 ┃ ┗ Mapa.java
 ┣ 📂 vista
 ┃ ┗ PanelJuego.java
 ┣ 📂 controlador
 ┃ ┗ ControladorJuego.java
 ┗ Main.java

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
