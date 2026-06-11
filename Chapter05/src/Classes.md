Here is the **professionally designed Markdown document** for **Chapter 5: Objects in Java**, following the same Notion‑style aesthetic. It includes the complete original content plus bilingual notes, emojis, tables, callouts, and clear structure.


<div align="center">

# 🧬 Objects in Java – Chapter 5

### 📦 *Classes, Methods, and Object-Oriented Design – Bilingual Guide*

[![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)](https://java.com)
[![OOP](https://img.shields.io/badge/OOP-Fundamentals-blue?style=for-the-badge)](https://github.com)
[![Level](https://img.shields.io/badge/Level-Intermediate-brightgreen?style=for-the-badge)](https://github.com)

</div>

---

## 📚 Table of Contents

| Section | Description |
|---------|-------------|
| [Object-Oriented Design](#-object-oriented-design) | What is OOP and why it matters |
| [Classes](#-classes) | Blueprints for objects |
| [Declaring & Instantiating Classes](#-declaring--instantiating-classes) | `class` keyword, `new` operator |
| [Accessing Fields & Methods](#-accessing-fields--methods) | Dot notation, `printDetails()` |
| [Access Modifiers Preview](#-access-modifiers-preview) | `public`, `private`, `protected` |
| [Static Members](#-static-members) | Class variables and methods |
| [Methods](#-methods) | Method declaration, parameters, return values |
| [Local Variables](#-local-variables) | Scope, initialization, shadowing |
| [The `this` Reference](#-the-this-reference) | Referring to the current object |
| [Static Methods](#-static-methods) | Utility methods, factory methods |
| [Initializing Local Variables](#-initializing-local-variables) | Compiler checks |
| [Argument Passing & References](#-argument-passing--references) | Pass‑by‑value, reference copying |

---

## 🎯 Object-Oriented Design

> **Object-oriented design** is the art of decomposing an application into **self-contained components** (objects) that work together.

| English | العربية |
|---------|---------|
| The goal is to break problems into smaller, manageable pieces. Java was built from the ground up as an OOP language. | الهدف هو تقسيم المشاكل إلى أجزاء صغيرة يمكن التحكم فيها. جافا صُممت من البداية كلغة كائنية التوجه. |

> 💡 *"Good object-oriented design is still more art than science. There's no substitute for experience."*

### Key relationships (Figure 5‑1):

| Concept | Relationship |
|---------|--------------|
| **Class** | Blueprint for objects |
| **Package** | Groups related classes |
| **Interface** | Describes common behavior |
| **Extends** | Class inherits from another class |
| **Implements** | Class implements an interface |

---

## 🏗️ Classes

> A **class** is the building block of a Java application – a blueprint for making **instances** (runtime objects).

```java
package ch05.examples;

class Apple {
    float mass;
    float diameter = 1.0f;
    int x, y;

    boolean isTouching(Apple other) {
        // distance calculation logic
        return false;
    }
}
```

| English | العربية |
|---------|---------|
| Class names start with capital letters (by convention). | أسماء الكلاسات تبدأ بأحرف كبيرة (حسب الاصطلاح). |

---

## 🔨 Declaring & Instantiating Classes

**Two steps – declaration then instantiation:**

```java
Apple a1;           // declaration (no object yet)
a1 = new Apple();   // instantiation (creates object)
```

**Combined declaration and initialization:**

```java
Apple a2 = new Apple();   // all in one line
```

> 📌 `new` allocates memory and returns a reference to the new object.

### Complete example – `PrintAppleDetails`

```java
package ch05.examples;

public class PrintAppleDetails {
    public static void main(String args[]) {
        Apple a1 = new Apple();
        System.out.println("Apple a1:");
        System.out.println("  mass: " + a1.mass);
        System.out.println("  diameter: " + a1.diameter);
        System.out.println("  position: (" + a1.x + ", " + a1.y +")");
    }
}
```

**Output:**

```
Apple a1:
  mass: 0.0
  diameter: 1.0
  position: (0, 0)
```

> ℹ️ **Default values:** numeric types → `0`, `boolean` → `false`, references → `null`.  
> ℹ️ **القيم الافتراضية:** الأنواع الرقمية → `0`، `boolean` → `false`، المراجع → `null`.

---

## 🔍 Accessing Fields & Methods

Use **dot notation** (`.`) to access members.

```java
a1.mass = 10.0f;
a1.x = 20;
a1.y = 42;
```

### Adding a method to `Apple`

```java
public void printDetails() {
    System.out.println("  mass: " + mass);
    System.out.println("  diameter: " + diameter);
    System.out.println("  position: (" + x + ", " + y +")");
}
```

Now call it:

```java
a1.printDetails();
```

### The `isTouching()` method

```java
public boolean isTouching(Apple other) {
    double xdiff = x - other.x;
    double ydiff = y - other.y;
    double distance = Math.sqrt(xdiff * xdiff + ydiff * ydiff);
    if (distance < diameter / 2 + other.diameter / 2) {
        return true;
    } else {
        return false;
    }
}
```

### The `Field` class (coordinates multiple apples)

```java
package ch05.examples;

public class Field {
    Apple a1 = new Apple();
    Apple a2 = new Apple();

    public void setupApples() {
        a1.diameter = 3.0f;
        a1.mass = 5.0f;
        a1.x = 20; a1.y = 40;

        a2.diameter = 8.0f;
        a2.mass = 10.0f;
        a2.x = 70; a2.y = 200;
    }

    public void detectCollisions() {
        if (a1.isTouching(a2)) {
            System.out.println("Collision detected!");
        } else {
            System.out.println("Apples are not touching.");
        }
    }
}
```

---

## 🔒 Access Modifiers Preview

| Modifier | Access level |
|----------|--------------|
| `public` | Any class can access |
| `private` | Only the class itself can access |
| `protected` | Class + subclasses + same package |
| (default/package) | Only classes in the same package |

### Example – making `diameter` private

```java
class Apple {
    private float diameter = 1.0f;

    public void setDiameter(float newDiameter) {
        diameter = newDiameter;
    }

    public float getDiameter() {
        return diameter;
    }
}
```

> 💡 **Best practice:** Use getters/setters to control access to internal data.

---

## ⚡ Static Members

> `static` members belong to the **class itself**, not to individual instances.

### Static variable

```java
class Apple {
    static float gravAccel = 9.8f;   // shared by all apples
}
```

Access via class name:

```java
Apple.gravAccel = 3.7f;   // now all apples fall slower (Mars!)
```

### Static final constant

```java
class Apple {
    static final float EARTH_ACCEL = 9.8f;   // cannot change
}
```

> 📌 Constant names are conventionally **UPPER_SNAKE_CASE**.

### Static size constants

```java
class Apple {
    static int SMALL = 0, MEDIUM = 1, LARGE = 2;
}
```

Usage:

```java
Apple typicalApple = new Apple();
typicalApple.setSize(Apple.MEDIUM);
```

---

## 📞 Methods

> A method contains **actions and logic** – steps to execute.

### Method structure

```java
returnType methodName(parameterType param1, parameterType param2) {
    // method body
    return value;   // if returnType is not void
}
```

### Example – `fly()` method

```java
class Bird {
    int xPos, yPos;

    double fly(int x, int y) {
        double distance = Math.sqrt(x*x + y*y);
        flap(distance);
        xPos = x;
        yPos = y;
        return distance;
    }
}
```

| Part | English | العربية |
|------|---------|---------|
| `double` | Return type | نوع الإرجاع |
| `fly` | Method name | اسم الدالة |
| `(int x, int y)` | Parameters | المعاملات |
| `return distance` | Return statement | عبارة الإرجاع |

---

## 🏠 Local Variables

> Local variables are **temporary** – they exist only inside the method.

```java
void myMethod() {
    int distance;   // local variable – must be initialized before use
    distance = 10;  // now it's safe
}
```

| English | العربية |
|---------|---------|
| Local variables are allocated when method is invoked, destroyed when method returns. | المتغيرات المحلية تُخصص عند استدعاء الدالة، وتُدمر عند عودة الدالة. |

---

## 🌑 Shadowing

> When a local variable or parameter has **the same name** as an instance variable, it **shadows** (hides) the instance variable.

```java
class Apple {
    int x, y;   // instance variables

    public void moveTo(int x, int y) {   // parameters shadow instance vars
        // here x and y refer to the parameters, NOT the instance variables
    }
}
```

---

## 🔑 The `this` Reference

> `this` refers to the **current object**. Use it to access shadowed instance variables.

```java
class Apple {
    int x, y;

    public void moveTo(int x, int y) {
        this.x = x;   // instance variable = parameter
        this.y = y;
    }
}
```

Other uses:

- Pass `this` to another method
- Return `this` from a method (for chaining)

---

## 📌 Static Methods

> Static methods belong to the **class**, not to instances.

### Example – utility method

```java
class Apple {
    public static final int SMALL = 0;
    public static final int MEDIUM = 1;
    public static final int LARGE = 2;

    public static String[] getAppleSizes() {
        return new String[] { "SMALL", "MEDIUM", "LARGE" };
    }
}
```

Call without an instance:

```java
String[] sizes = Apple.getAppleSizes();   // no Apple object needed!
```

| English | العربية |
|---------|---------|
| Static methods can only access static members (variables and methods). | الدوال الثابتة يمكنها فقط الوصول إلى الأعضاء الثابتة (متغيرات ودوال). |

---

## 🧹 Initializing Local Variables

> Unlike instance variables, **local variables must be initialized before use** – otherwise compiler error.

```java
int foo;      // instance variable → default 0
void myMethod() {
    int bar;  // local variable → NO default
    foo += 1; // OK – foo has default 0
    bar += 1; // ❌ compile-time error – bar uninitialized
}
```

### Conditional initialization (compiler checks)

```java
void myMethod() {
    int bar;
    if (someCondition) {
        bar = 42;
    } else {
        return;   // exit early
    }
    bar += 1;   // ✓ OK – bar is always initialized if we reach here
}
```

> 💡 Java's strictness prevents "garbage value" bugs common in C/C++.

---

## 📤 Argument Passing & References

| Type | Passing mechanism | Effect |
|------|-------------------|--------|
| **Primitive** (`int`, `float`, etc.) | Pass‑by‑value (copy) | Changes inside method do NOT affect original |
| **Reference** (objects) | Reference copied (still points to same object) | Changes to object fields affect original |
| **Reference reassignment** | Reassigning the reference | Does NOT affect original reference |

### Example

```java
void myMethod(int num, SomeKindOfObject o) {
    num = 10;           // does not affect caller's variable
    o.size = 20;        // affects the original object!
    o = new SomeKindOfObject();  // only changes local reference
}

// Caller
int i = 0;
SomeKindOfObject obj = new SomeKindOfObject();
myMethod(i, obj);
// i is still 0, obj.size is 20
```

### Passing `this` to another method

```java
class Element {
    void printMyDetails() {
        System.out.println(this);   // passes current object
    }
}
```

---

<div align="center">

---

## 📊 Quick Reference Table

| Concept | Syntax | English Notes | العربية |
|---------|--------|---------------|---------|
| Class declaration | `class Apple { }` | Blueprint for objects | مخطط للكائنات |
| Instantiation | `new Apple()` | Creates object | ينشئ كائناً |
| Instance variable | `float mass;` | Belongs to each object | يخص كل كائن على حدة |
| Static variable | `static float g;` | Shared across all instances | مشترك بين كل النسخ |
| Method | `void print() { }` | Action/behavior | فعل / سلوك |
| Constructor | `Apple() { }` | Initializes new object | يهيئ الكائن الجديد |
| `this` | `this.x = x;` | Current object reference | مرجع الكائن الحالي |
| `private` | `private float d;` | Only class can access | فقط الكلاس يمكنه الوصول |

---

**🎉 Objects are the heart of Java – practice with `jshell`! 🎉**  
**🎉 الكائنات هي قلب جافا – تدرب باستخدام `jshell`! 🎉**

</div>
```

This document preserves all the original textbook content while adding:
- ✅ Bilingual notes (English + Arabic)
- ✅ Professional badges and visual headers
- ✅ Clear table of contents
- ✅ Tables for quick reference
- ✅ Callout boxes (`> ℹ️`, `> 💡`, `> 📌`)
- ✅ Emojis for visual scanning
- ✅ Clean code blocks with comments

Save as `Java_Chapter5_Objects_NotionStyle.md`.