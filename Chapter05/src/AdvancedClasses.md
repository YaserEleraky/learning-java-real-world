<div align="center">

# 🧬 Objects in Java – Part 2 (Enhanced Edition)

### 📦 *Wrappers, Overloading, Constructors, Packages, Inheritance, Interfaces, Inner Classes & More*

[![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)](https://java.com)
[![OOP](https://img.shields.io/badge/OOP-Advanced-blue?style=for-the-badge)](https://github.com)
[![Level](https://img.shields.io/badge/Level-Intermediate--Advanced-brightgreen?style=for-the-badge)](https://github.com)

</div>

---

## 📚 Table of Contents

| Section | Description |
|---------|-------------|
| [Wrappers for Primitive Types](#-wrappers-for-primitive-types) | `Integer`, `Double`, autoboxing |
| [Method Overloading](#-method-overloading) | Multiple methods with same name |
| [Object Creation & Constructors](#-object-creation--constructors) | `new`, default constructors, `this()` |
| [Garbage Collection](#-garbage-collection) | Automatic memory management |
| [Packages](#-packages) | Organising classes |
| [Importing Classes](#-importing-classes) | `import` statements, wildcards |
| [Custom Packages](#-custom-packages) | Creating your own packages |
| [Member Visibility & Access](#-member-visibility--access) | `public`, `private`, `protected`, default |
| [Compiling with Packages](#-compiling-with-packages) | Command‑line examples |
| [Advanced Class Design](#-advanced-class-design) | Subclassing, overriding, abstract classes |
| [Abstract Classes & Methods](#-abstract-classes--methods) | Detailed with example |
| [Interfaces](#-interfaces) | Capability contracts |
| [Inner Classes](#-inner-classes) | Nested classes – all four types |
| [Anonymous Inner Classes](#-anonymous-inner-classes) | One‑time use classes |
| [HelloJava3 – Full Analysis](#-hellojava3--full-analysis) | Real‑world example with anonymous inner class |
| [Organizing Content & Planning for Failure](#-organizing-content--planning-for-failure) | Best practices |

---

## 📦 Wrappers for Primitive Types

> Java provides a **wrapper class** for each primitive type to allow primitives to be used as objects.

| Primitive | Wrapper class |
|-----------|---------------|
| `void` | `java.lang.Void` |
| `boolean` | `java.lang.Boolean` |
| `char` | `java.lang.Character` |
| `byte` | `java.lang.Byte` |
| `short` | `java.lang.Short` |
| `int` | `java.lang.Integer` |
| `long` | `java.lang.Long` |
| `float` | `java.lang.Float` |
| `double` | `java.lang.Double` |

### Creating wrapper objects

```java
Float pi = new Float(3.14);
Float pi2 = new Float("3.14");   // from String
```

> ⚠️ The numeric wrapper constructors throw `NumberFormatException` on bad input.

### Number interface methods

Each numeric wrapper implements `java.lang.Number`:

```java
Double size = new Double(32.76);
double d = size.doubleValue();   // 32.76
float f = size.floatValue();     // 32.76f
long l = size.longValue();       // 32L
int i = size.intValue();         // 32
```

### Using wrappers with collections (manual)

```java
List myNumbers = new ArrayList();
Integer thirtyThree = new Integer(33);
myNumbers.add(thirtyThree);

Integer theNumber = (Integer)myNumbers.get(0);
int n = theNumber.intValue();   // 33
```

### Autoboxing (automatic wrapping/unwrapping)

```java
List<Integer> myNumbers = new ArrayList<Integer>();
myNumbers.add(33);      // autoboxing: int → Integer
int n = myNumbers.get(0); // unboxing: Integer → int
```

| English | العربية |
|---------|---------|
| Autoboxing lets you treat primitives as objects without explicit wrapper code. | Autoboxing يسمح لك بمعاملة الأنواع البدائية ككائنات بدون كود تحويل صريح. |

---

## 🔁 Method Overloading

> **Method overloading** = multiple methods with the **same name** but **different parameters** (number or type).

### Example – `PrintStream.print()`

```java
class PrintStream {
    void print(Object arg) { ... }
    void print(String arg) { ... }
    void print(char[] arg) { ... }
    void print(int arg) { ... }
    // ... and so on
}
```

### How the compiler chooses

- Exact match is preferred.
- Otherwise, the most **specific** assignable match is chosen.
- Overloading is resolved at **compile time**, not runtime.

```java
print("Hi");   // selects String version, not Object version
```

| English | العربية |
|---------|---------|
| Overloaded methods must differ in argument types or count. | الدوال المحملة يجب أن تختلف في عدد أو أنواع المعاملات. |

---

## 🏗️ Object Creation & Constructors

> A **constructor** is a special method with the same name as the class, no return type, called when you use `new`.

### Example constructors

```java
class Date {
    int day;

    Date() {                          // default constructor
        day = currentDay();
    }

    Date(String date) {               // overloaded constructor
        day = parseDay(date);
    }
}
```

**Creating objects:**

```java
Date now = new Date();
Date christmas = new Date("Dec 25, 2022");
```

### Default constructor

If you don’t define **any** constructor, Java provides an empty default constructor automatically.

### Calling one constructor from another – `this()`

```java
class Car {
    String model;
    int doors;

    Car(String model, int doors) {
        this.model = model;
        this.doors = doors;
    }

    Car(String model) {
        this(model, 4);   // delegate to the other constructor
    }
}
```

> ⚠️ `this()` must be the **first statement** in the constructor.

### Restrictions

- Cannot refer to instance variables before `this()` call (they aren’t initialized yet).
- Use **static** constants instead.

```java
class Car {
    static final int DEFAULT_DOORS = 4;
    Car(String m) {
        this(m, DEFAULT_DOORS);   // ✅ OK – static is safe
    }
}
```

| English | العربية |
|---------|---------|
| Constructors can be overloaded like normal methods. | يمكن تحميل الدوال البانية مثل الدوال العادية. |

---

## 🗑️ Garbage Collection

> Java automatically reclaims memory from objects that are **no longer reachable**.

- You **never** explicitly delete objects.
- The garbage collector runs in the background.
- An object becomes unreachable when no references point to it.

### Example

```java
christmas = null;   // now the Date object may be garbage collected
```

### Forcing garbage collection (not guaranteed)

```java
System.gc();
```

| English | العربية |
|---------|---------|
| Garbage collection eliminates manual memory management and most memory leaks. | تجميع القمامة يلغي الحاجة للإدارة اليدوية للذاكرة ومعظم تسريبات الذاكرة. |

---

## 📦 Packages

> A **package** groups related classes. Packages map to folders (directories).

### Package declaration

```java
package ch02.examples;
```

- Must be the first statement in the file (except comments).
- If omitted, class goes into the **default package** (not recommended for real projects).

### Naming conventions

- All **lowercase**.
- Reverse domain name: `com.oreilly.learningjava6e`
- Avoid hyphens; use dots.

---

## 📥 Importing Classes

### Import a single class

```java
import javax.swing.JFrame;
import javax.swing.JLabel;
```

### Import all classes in a package (wildcard `*`)

```java
import javax.swing.*;
```

> ℹ️ Wildcard **does not** import subpackages (e.g., `java.awt.*` does not import `java.awt.event`).

### Fully qualified name (no import)

```java
javax.swing.JFrame frame = new javax.swing.JFrame("Hello");
```

| English | العربية |
|---------|---------|
| Use fully qualified names for one‑off uses; otherwise import. | استخدم الاسم الكامل للاستخدامات النادرة؛ وإلا استخدم `import`. |

---

## 🧩 Custom Packages

### Declare a package

```java
package com.github.myawesomeproject;
```

### Directory structure must match package

```
com/
  github/
    myawesomeproject/
      MyClass.java
```

### Compiling

```bash
javac com/github/myawesomeproject/*.java
```

### Running

```bash
java com.github.myawesomeproject.MyClass
```

> 💡 IDEs manage packages for you. This is one reason they are popular.

---

## 🔒 Member Visibility & Access

| Modifier | Visibility |
|----------|------------|
| `private` | Only the class itself |
| (default / package‑private) | Classes in the same package |
| `protected` | Same package + subclasses (even outside package) |
| `public` | Everyone |

### Visual summary

```
┌─────────────────────────────────────────────────────────┐
│  Class TextArea (in mytools.text)                       │
│  ┌─────────────────────────────────────────────────────┐│
│  │ private String text;          // only TextArea       ││
│  │ int linecount;                // package‑private     ││
│  │ protected void formatText()   // package + subclasses││
│  │ public String getText()       // everyone            ││
│  └─────────────────────────────────────────────────────┘│
└─────────────────────────────────────────────────────────┘
```

| English | العربية |
|---------|---------|
| Default (no modifier) = package‑private. Visible only to classes in the same package. | الافتراضي (بدون معدل) = مرئي فقط داخل نفس الحزمة. |

---

## 🖥️ Compiling with Packages

```bash
# Compile all .java files in the package
javac ch02/examples/*.java

# Run with fully qualified name
java ch02.examples.HelloJava
```

For nested packages:

```bash
javac com/oreilly/learningjava6e/ch02/examples/*.java
java com.oreilly.learningjava6e.ch02.examples.HelloJava
```

> 💡 Real projects use build tools like Maven or Gradle.

---

## 🧬 Advanced Class Design

### Subclassing and Inheritance

```java
class Animal {
    float weight;
    void eat() { ... }
}

class Mammal extends Animal {   // inherits weight and eat()
    int heartRate;
    void breathe() { ... }
}

class Cat extends Mammal {       // inherits everything from Animal and Mammal
    boolean longHair;
    void purr() { ... }
}
```

- Single inheritance – a class can extend **only one** parent class.
- A subclass is a **subtype**: a `Cat` can be assigned to an `Animal` variable.

```java
Cat simon = new Cat();
Animal creature = simon;   // works because Cat is an Animal
```

### Shadowed variables

A subclass can declare a variable with the **same name** as one in its parent → shadows the parent variable.

```java
class IntegerCalculator {
    int sum;
}

class DecimalCalculator extends IntegerCalculator {
    double sum;   // shadows IntegerCalculator.sum
}
```

- Both variables exist.
- To access the parent variable: `super.sum`

> ⚠️ Shadowing is confusing – avoid when possible.

### Overriding methods

A subclass can **override** an inherited method by providing a new implementation with the **same signature**.

```java
class Animal {
    void makeSound() { System.out.println("???"); }
}

class Cat extends Animal {
    @Override
    void makeSound() { System.out.println("Meow!"); }
}
```

- Dynamic lookup: even when accessed via a parent reference, the overridden method in the actual object is called.

```java
Animal a = new Cat();
a.makeSound();   // prints "Meow!" – not "???"
```

| English | العربية |
|---------|---------|
| Overriding is runtime polymorphism (dynamic). | التجاوز هو تعدد الأشكال وقت التنفيذ (ديناميكي). |

---

## 🧩 Abstract Classes & Methods (with example)

> An **abstract method** has no body – it must be overridden in a concrete subclass.  
> An **abstract class** cannot be instantiated and may contain abstract methods.

### Example – Animal abstract class

```java
// Abstract class: cannot be instantiated directly
abstract class Animal {
    
    // Abstract method: no body, forces subclasses to implement
    public abstract void makeSound();

    // Concrete method: inherited as is
    public void sleep() {
        System.out.println("Zzz...");
    }
}

// Concrete subclass
class Dog extends Animal {
    @Override
    public void makeSound() {
        System.out.println("The dog says: Woof Woof");
    }
}

public class Main {
    public static void main(String[] args) {
        // Animal a = new Animal(); // ❌ compile error – abstract class
        Dog myDog = new Dog();
        myDog.makeSound();   // The dog says: Woof Woof
        myDog.sleep();       // Zzz... (inherited)
    }
}
```

| English | العربية |
|---------|---------|
| Abstract classes provide a template. Subclasses must implement abstract methods. | الفئات المجردة توفر قالباً. الفئات الابنة يجب أن تنفذ الدوال المجردة. |

---

## 🧾 Interfaces

> An **interface** defines a set of method signatures – a **contract** that implementing classes must fulfill.

```java
interface Driveable {
    boolean startEngine();
    void stopEngine();
    float accelerate(float acc);
    boolean turn(Direction dir);
}
```

- Methods are implicitly `public` and `abstract`.
- A class implements an interface using `implements`.

```java
class Automobile implements Driveable {
    public boolean startEngine() { ... }
    public void stopEngine() { ... }
    public float accelerate(float acc) { ... }
    public boolean turn(Direction dir) { ... }
}
```

- A class can implement **multiple** interfaces.
- Interface variables can hold any object that implements it.

```java
Driveable vehicle = new Automobile();
vehicle.startEngine();
```

| English | العربية |
|---------|---------|
| Interfaces enable polymorphism without inheritance. | الواجهات تمكن تعدد الأشكال بدون وراثة. |

---

## 🧩 Inner Classes (All Four Types)

An **inner class** is a class defined inside another class. It helps with logical grouping and encapsulation.

### 1. Non‑static Inner Class

```java
class Outer {
    int x = 10;

    class Inner {
        void display() {
            System.out.println("x = " + x); // can access outer members
        }
    }
}

// Creation:
Outer outer = new Outer();
Outer.Inner inner = outer.new Inner();
inner.display();
```

### 2. Static Nested Class

```java
class Outer {
    static int y = 20;

    static class StaticNested {
        void display() {
            System.out.println("y = " + y); // only static members
        }
    }
}

// Creation (no outer instance needed):
Outer.StaticNested nested = new Outer.StaticNested();
nested.display();
```

### 3. Local Class (inside a method)

```java
class Outer {
    void someMethod() {
        class Local {
            void run() { System.out.println("Local class"); }
        }
        Local local = new Local();
        local.run();
    }
}
```

### 4. Anonymous Inner Class (next section)

---

## 🕵️ Anonymous Inner Classes – Detailed

> An **anonymous inner class** is a class with **no name**, defined and instantiated in a single expression. It is used for one‑time overriding of methods, especially for event handling.

### Syntax

```java
new SuperClassOrInterface() {
    // method overrides
};
```

### Example 1 – with an abstract class

```java
abstract class Greeting {
    abstract void greet();
}

public class Main {
    public static void main(String[] args) {
        Greeting englishGreeting = new Greeting() {
            @Override
            void greet() {
                System.out.println("Hello World!");
            }
        };
        englishGreeting.greet(); // Hello World!
    }
}
```

### Example 2 – with an interface (common in GUI and threads)

```java
public class Main {
    public static void main(String[] args) {
        Runnable myTask = new Runnable() {
            @Override
            public void run() {
                System.out.println("Task is running in background thread.");
            }
        };
        Thread thread = new Thread(myTask);
        thread.start();
    }
}
```

> 💡 **Java 8+ note:** For functional interfaces (single abstract method), a **lambda expression** is shorter:  
> `Runnable myTask = () -> System.out.println("Running...");`

---

## 🖼️ HelloJava3 – Full Real‑World Analysis

This example comes from the *Learning Java* book. It creates a window with draggable text – a perfect demonstration of **anonymous inner classes** combined with GUI event handling.

### Complete code

```java
package ch05.examples;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class HelloJava3 extends JFrame {
    public static void main(String[] args) {
        HelloJava3 demo = new HelloJava3();
        demo.setVisible(true);
    }

    public HelloJava3() {
        super("HelloJava3");
        add(new HelloComponent3("Hello, Inner Java!"));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 300);
    }

    // Inner class responsible for drawing and handling mouse drag
    class HelloComponent3 extends JComponent {
        String theMessage;
        int messageX = 125, messageY = 95; // initial coordinates

        public HelloComponent3(String message) {
            theMessage = message;

            // Anonymous inner class implementing MouseMotionListener
            addMouseMotionListener(new MouseMotionListener() {
                public void mouseDragged(MouseEvent e) {
                    messageX = e.getX();
                    messageY = e.getY();
                    repaint();   // force redraw at new position
                }
                public void mouseMoved(MouseEvent e) { } // required but empty
            });
        }

        public void paintComponent(Graphics g) {
            g.drawString(theMessage, messageX, messageY);
        }
    }
}
```

### 🔍 Where is the anonymous inner class?

It is inside the constructor of `HelloComponent3`:

```java
addMouseMotionListener(new MouseMotionListener() {
    public void mouseDragged(MouseEvent e) {
        messageX = e.getX();
        messageY = e.getY();
        repaint();
    }
    public void mouseMoved(MouseEvent e) { }
});
```

- `new MouseMotionListener() { ... }` creates an **anonymous class** that implements the `MouseMotionListener` interface.
- Two methods are overridden: `mouseDragged` (updates coordinates and repaints) and `mouseMoved` (empty, but required).
- The object is passed immediately to `addMouseMotionListener`.

### 🎯 What does the program do?

- A window (300×300) appears with the text **"Hello, Inner Java!"** at position (125,95).
- When you **click and drag** the mouse over the window, the text follows the mouse cursor.
- The `mouseDragged` method updates `messageX` and `messageY` and calls `repaint()` which triggers `paintComponent` to redraw the text at the new location.

### 💡 Why is this design clever?

Without inner classes, you would need a separate `.java` file for the `MouseMotionListener` implementation, making the code less cohesive. The anonymous inner class keeps all logic inside the component constructor, making it **self‑contained** and **easy to read**.

---

## 📐 Organizing Content & Planning for Failure

### Best practices

| Principle | Explanation |
|-----------|-------------|
| **Hide implementation** | Use `private` fields, provide getters/setters. Avoid public variables (except constants). |
| **Composition over inheritance** | Reuse objects by including them as fields, not just by subclassing. |
| **Minimize relationships** | Keep classes loosely coupled. Use packages to hide internal classes. |

### Example – Apple Toss game

The `ch05/examples` folder contains:
- `Apple`, `Tree`, `Physicist` classes implementing `GamePiece` interface.
- `Field` extends `JComponent`.
- `AppleToss` extends `JFrame`.

### Try it yourself

Experiment with the code:
- Add another tree.
- Tweak the `draw()` methods.

---

<div align="center">

---

## 📊 Quick Reference – Visibility & Access

| Modifier | Same class | Same package | Subclass (different package) | Any class |
|----------|------------|--------------|------------------------------|-----------|
| `private` | ✅ | ❌ | ❌ | ❌ |
| (default) | ✅ | ✅ | ❌ | ❌ |
| `protected` | ✅ | ✅ | ✅ | ❌ |
| `public` | ✅ | ✅ | ✅ | ✅ |

---

**🎉 Mastering objects takes practice – keep coding! 🎉**  
**🎉 إتقان الكائنات يحتاج إلى ممارسة – استمر في البرمجة! 🎉**

</div>
```

---