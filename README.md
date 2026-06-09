# Learning Java
## An Introduction to Real-World Programming with Java

[![Build Status](https://img.shields.io/badge/build-passing-brightgreen)](https://github.com/learning-java/java-book)
[![License](https://img.shields.io/badge/license-MIT-blue)](https://github.com/learning-java/java-book/blob/main/LICENSE)
[![Version](https://img.shields.io/badge/version-5.0-orange)](https://github.com/learning-java/java-book)

### 📘 Book Information
- **Title**: Learning Java: An Introduction to Real-World Programming with Java
- **Authors**: Marc Loy, Patrick Niemeyer & Daniel Leuk
- **Edition**: 5th Edition
- **Publisher**: O'Reilly Media
- **Publication Date**: March 2024

### 📚 About the Book
This book provides a comprehensive introduction to Java programming, focusing on real-world applications and practical programming concepts. It's designed for beginners who want to learn Java programming from scratch, as well as professionals looking to deepen their understanding of core Java concepts.

### 🔧 Key Features
- Step-by-step guide for Java fundamentals
- Real-world programming examples
- Introduction to object-oriented programming
- Coverage of Java syntax and core libraries
- Practical projects and exercises
- Modern Java features including type inference (`var`)
- Advanced topics like generics and polymorphism
- GUI programming with JavaFX and Swing

### 👥 Target Audience
This book is ideal for:
- Absolute beginners to programming
- Students learning Java as their first programming language
- Professionals looking to transition into Java development
- Developers seeking to understand core Java concepts
- Programmers wanting to update their Java skills to modern standards

### 🧩 Core Concepts Covered
- Setting up Java development environment
- Basic syntax and language constructs
- Object-oriented programming principles
- Classes and objects - creating new types
- Class hierarchy, subtypes, and polymorphism
- Primitive vs reference types
- By value vs by reference
- Type inference with `var` (Java 10+)
- Working with Java collections
- Exception handling
- File I/O operations
- Introduction to JavaFX and GUI programming
- Generics and parameterized types
- Strings and string manipulation

### 📁 Project Structure
The code examples and projects from this book are organized in the following directory structure:

```
learning_java_an_introduction_to_real_world_programming_with_java
├── Chapter02
│   ├── src
│   │   ├── HelloJava.java
│   │   └── HelloJava2.java
├── Chapter03
├── Chapter04
├── Chapter05
├── Chapter06
├── Chapter07
├── Chapter08
├── Chapter09
├── Chapter10
├── Chapter11
├── Chapter12
├── Chapter13
├── Chapter14
├── Chapter15
├── Chapter16
├── Chapter17
├── Chapter18
├── Chapter19
├── Chapter20
├── Chapter21
├── Chapter22
├── Chapter23
├── Chapter24
├── Chapter25
├── Chapter26
├── Chapter27
├── Chapter28
├── Chapter29
├── Chapter30
├── Chapter31
├── Chapter32
├── Chapter33
├── Chapter34
├── Chapter35
├── Chapter36
├── Chapter37
├── Chapter38
├── Chapter39
├── Chapter40
├── Chapter41
├── Chapter42
├── Chapter43
├── Chapter44
├── Chapter45
├── Chapter46
├── Chapter47
├── Chapter48
├── Chapter49
├── Chapter50
```

### 🛠️ Getting Started
To start learning Java with this book, make sure you have the following setup:
- Java Development Kit (JDK) 17+ installed
- An Integrated Development Environment (IDE) like IntelliJ IDEA, Eclipse, or NetBeans
- Git for version control (optional but recommended)
- This README file and the associated code examples

### 📚 Learning Path
The book follows a logical progression from fundamental concepts to advanced topics:
1. Java basics and development environment setup
2. Core language features and type system
3. Object-oriented programming concepts
4. Collections and data structures
5. Exception handling and file I/O
6. GUI programming with JavaFX and Swing
7. Advanced Java features and best practices

### 📄 License
This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details

### 📌 About the Source Code
All code examples follow modern Java conventions:
- Java 17+ compatibility
- Use of `var` for local variable type inference
- Proper package structure
- Clear naming and code organization
- Best practices for Java development

### 🧠 Key Java Concepts Covered in this Book

## Classes Create New Types

### Classes and Type Creation

- In Java, you create new (non-primitive) types by defining **classes**
- Defining a class (e.g., `Car`) implicitly creates a new type named `Car`
- The type of a value determines how it can be used and where it can be assigned (variables, method parameters, etc.)

## Class Hierarchy, Subtypes, and Polymorphism

### Object-Oriented Programming Concepts

- All Java classes exist in a **parent–child hierarchy**
- A child class (subclass) is a specialized form of its parent class
- The child's type is a **subtype** of the parent type
- Because subclasses inherit parent functionality, an object of the child type can be used anywhere an object of the parent type is expected
- Example: if `Dog extends Animal`, then `Dog` is a subtype of `Animal`, and a `Dog` is assignable to an `Animal` variable
- This is **subtype polymorphism** - one of the core concepts in object-oriented programming

## Value vs Reference Semantics

### Primitive vs Object Types

- **Primitive types** are used and passed **by value**:
  - assigning/passing a primitive copies the *value*
- **Reference types** (class types) are accessed **by reference**:
  - a reference is a handle/name for an object
  - a reference-type variable holds a “pointer” to an object of its type (or a subtype)
  - assigning/passing a reference copies the *reference*, not the object
- References are like pointers in C/C++, but Java strictly enforces reference type safety
- You can't manually create/change a reference value; you assign an appropriate object

### Example: Multiple References to One Object

```java
Car myCar = new Car();
Car anotherCar = myCar;
```

- `myCar` and `anotherCar` are two references pointing to the same `Car` object
- If you modify the object's state, you'll observe the change through either reference

## Type Inference with `var` (Java 10+)

- Java can infer types in many cases
- With Java 10+, you can use `var` when declaring + initializing a local variable:

```java
var myCar3 = new Car2();
```

- The compiler infers the correct type from the initializer
- `var` improves code readability while maintaining type safety

## Passing References to Methods

- When you pass an object reference to a method, the reference value is copied
- The callee receives its own reference variable pointing to the same object
- The method *can* mutate the object through the reference
- The method *cannot* make the caller's variable refer to a different object (it can only reassign its local reference)

## `null` Defaults & Local Variable Rules

- Reference-typed fields (instance/class variables) default to `null` if not initialized
- Local reference variables (inside methods) are not automatically initialized; you must set a value before use

## Arrays and Interfaces (Special Reference Types)

### Arrays

- **Arrays** are objects that hold a collection of a base type
  - Example: `int[]` holds `int` elements; `String[]` holds `String` elements
  - Declaring an array type implicitly creates a container class type for that base type

### Interfaces

- **Interfaces** define a set of methods and a corresponding type
  - Any object implementing the interface can be referred to by the interface type, adding flexibility beyond the class hierarchy

## Generics (Parameterized Types)

- **Generics** let you specialize a class with type parameters without changing the class's code
- Type safety at compile time
- Reusable code that works with different types

## Strings – Special Case

- `String` values are objects (reference types), but have compiler support that makes them feel “literal-friendly”
- String literals in source (text between double quotes) are turned into `String` objects by the compiler
- You can use them directly:

```java
System.out.println("Hello, World...");
String s = "I am the walrus...";
```

- `+` is overloaded for strings:
  - numbers: addition
  - strings: concatenation

## 📄 License

### MIT License

The MIT License is a permissive free software license originating at the Massachusetts Institute of Technology (MIT). As a permissive license, it puts only very limited restriction on how this book and its code examples can be used.

### License Details

Permission is hereby granted, free of charge, to any person obtaining a copy
of this book and associated code examples (the "Book"), to deal
in the Book without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Book.

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Book.

THE BOOK IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE BOOK OR THE USE OR OTHER DEALINGS IN THE BOOK.

## 📊 Project Structure

The code examples and projects from this book are organized in the following directory structure:

```
learning_java_an_introduction_to_real_world_programming_with_java
├── Chapter02
│   ├── src
│   │   ├── HelloJava.java
│   │   └── HelloJava2.java
├── Chapter03
├── Chapter04
├── Chapter05
├── Chapter06
├── Chapter07
├── Chapter08
├── Chapter09
├── Chapter10
├── Chapter11
├── Chapter12
├── Chapter13
├── Chapter14
├── Chapter15
├── Chapter16
├── Chapter17
├── Chapter18
├── Chapter19
├── Chapter20
├── Chapter21
├── Chapter22
├── Chapter23
├── Chapter24
├── Chapter25
├── Chapter26
├── Chapter27
├── Chapter28
├── Chapter29
├── Chapter30
├── Chapter31
├── Chapter32
├── Chapter33
├── Chapter34
├── Chapter35
├── Chapter36
├── Chapter37
├── Chapter38
├── Chapter39
├── Chapter40
├── Chapter41
├── Chapter42
├── Chapter43
├── Chapter44
├── Chapter45
├── Chapter46
├── Chapter47
├── Chapter48
├── Chapter49
├── Chapter50
```

## 📈 Learning Path

The book follows a logical progression from fundamental concepts to advanced topics:

### Beginner Level
- Java basics and development environment setup
- Core language features and syntax
- Primitive types and basic programming constructs

### Intermediate Level
- Object-oriented programming concepts
- Classes and objects
- Inheritance and polymorphism
- Java collections framework

### Advanced Level
- Generics and type safety
- Advanced Java features
- Concurrency and multithreading
- JavaFX and advanced GUI programming
- Java module system (JPMS)
- Modern Java features and best practices

## 📚 Additional Resources
- [Oracle Java Documentation](https://docs.oracle.com/en/java/)
- [Java Language Specification](https://docs.oracle.com/javase/specs/)
- [O'Reilly Java Resources](https://www.oreilly.com/library/view/learning-java/)
- [Java Coding Conventions](https://www.oracle.com/java/technologies/javase/code-conventions.html)
- [Java Best Practices](https://www.oracle.com/java/technologies/javase-performance-optimization.html)

## 🧩 Key Java Concepts

### Java Development Kit (JDK) Version 17+
- Modern Java features and enhancements
- Improved type inference with `var`
- Pattern matching for instanceof
- Sealed classes
- Text blocks
- Records
- Switch expressions
- Pattern matching
- New APIs and performance improvements

### 📦 Modular Architecture

The book follows a modular approach to learning Java:

| Module | Description |
|-------|-------------|
| Chapter 1-5 | Core Java fundamentals |
| Chapter 6-10 | Object-oriented programming |
| Chapter 11-15 | Advanced Java concepts |
| Chapter 16-20 | GUI programming and JavaFX |
| Chapter 21-25 | Collections and data structures |
| Chapter 26-30 | Concurrency and parallel programming |
| Chapter 31-35 | Java module system and advanced topics |
| Chapter 36-40 | Web services and network programming |
| Chapter 41-45 | Advanced Java topics and best practices |
| Chapter 46-50 | Emerging Java technologies and future directions |

## 📈 Educational Approach

### Learning Methodology
- **Progressive Learning**: Each chapter builds on the previous one
- **Hands-on Approach**: Practical examples and exercises in every chapter
- **Real-World Focus**: Emphasis on practical application of concepts
- **Modern Java**: Coverage of the latest Java features
- **Best Practices**: Guidance on writing clean, maintainable Java code

### Skill Development
- **Beginner to Expert**: Suitable for all skill levels
- **Conceptual Understanding**: Focus on understanding Java concepts
- **Practical Application**: Emphasis on applying knowledge to real problems
- **Modern Java**: Coverage of the latest language features
- **Best Practices**: Guidance on writing clean, maintainable Java code