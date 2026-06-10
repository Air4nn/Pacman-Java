# 🟡 PAC-MAN EN JAVA 🟡  
### 🎮 Proyecto Final – Programación Orientada a Objetos

Informe Tecnico del proyecto en formato PDF:

https://docs.google.com/document/d/1gWd4hpk6GUwlcqSvIQufwGmtQs2k2Lh_E8RApbdUsnE/edit?usp=sharing

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
- Utilizar **hilos** para elementos dinámicos  
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
- 4 enemigos de color: naranja, rojo, azul y rosado
- Movimiento aleatorio y automatico 

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
┃ ┗ 📜 HiloFantasma.java  
┣ 📂 com.mycompany.pacman.modelo  
┃ ┣ 📜 Fantasma.java  
┃ ┣ 📜 Mapa.java  
┃ ┣ 📜 Pacman.java  
┃ ┗ 📜 Personaje.java  
┣ 📂 com.mycompany.pacman.vista  
┃ ┣ 📜 PanelJuego.java  
┃ ┗ 📜 VentanaJuego.java  
```
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

🟡 Avance (70%): 3 de junio 2026  ✅

🟢 Final (100%): 10 de junio 2026

---

## 📚 Conclusión

Este proyecto integra múltiples conceptos clave como POO, concurrencia y diseño de software, permitiendo desarrollar una aplicación interactiva completa y estructurada.

---

## 🏁 Estado del Proyecto

🚧 En desarrollo 
