# Elevator Low Level Design

[![Java](https://img.shields.io/badge/Java-17+-blue)](https://www.oracle.com/java/)
[![License](https://img.shields.io/badge/License-MIT-green)](LICENSE)

## Overview
A brief description of your project.  
Example:
> A low-level design simulation of a multi-elevator system in Java demonstrating OOP, concurrency, and design patterns.

---

## Table of Contents
- [Features](#features)
- [Architecture](#architecture)
- [Setup & Run](#setup--run)
- [Usage Example](#usage-example)
- [Future Enhancements](#future-enhancements)
- [Author](#author)

---

## Features
- Feature 1
- Feature 2
- Feature 3
- Feature 4

---

## Architecture
Briefly describe the main components/classes and their responsibilities:

- **ElevatorSystem** – Central controller managing all elevators.
- **Elevator** – Represents a single elevator with state and request queues.
- **ElevatorState** – Interface for elevator behavior (`IdleState`, `MovingUpState`, `MovingDownState`).
- **Observer** – Updates the display or dashboard on elevator state changes.
- **Strategy** – Chooses the best elevator for a request.
- **Concurrency** – Each elevator runs in its own thread to handle simultaneous requests.

**Design Patter**
