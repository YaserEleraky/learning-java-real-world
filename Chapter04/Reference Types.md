## Classes create new types

- In Java, you create new (non-primitive) types by defining **classes**.
- Defining a class (e.g., `Car`) implicitly creates a new type named `Car`.
- The type of a value determines how it can be used and where it can be assigned (variables, method parameters, etc.).

## Class hierarchy, subtypes, and polymorphism

- All Java classes exist in a **parent–child hierarchy**.
- A child class (subclass) is a specialized form of its parent class.
- The child’s type is a **subtype** of the parent type.
- Because subclasses inherit parent functionality, an object of the child type can be used anywhere an object of the parent type is expected.
- Example: if `Dog extends Animal`, then `Dog` is a subtype of `Animal`, and a `Dog` is assignable to an `Animal` variable.
- This is **subtype polymorphism**.

## By value (primitives) vs by reference (objects)

- **Primitive types** are used and passed **by value**:
    - assigning/passing a primitive copies the *value*.
- **Reference types** (class types) are accessed **by reference**:
    - a reference is a handle/name for an object
    - a reference-type variable holds a “pointer” to an object of its type (or a subtype)
    - assigning/passing a reference copies the *reference*, not the object
- References are like pointers in C/C++, but Java strictly enforces reference types.
- You can’t manually create/change a reference value; you assign an appropriate object.

## Example: two references to one object

```java
Car myCar = new Car();
Car anotherCar = myCar;
```

- `myCar` and `anotherCar` are two references pointing to the same `Car` object.
- If you modify the object’s state, you’ll observe the change through either reference.

## Type inference with `var` (Java 10+)

- Java can infer types in many cases.
- With Java 10+, you can use `var` when declaring + initializing a local variable:

```java
var myCar3 = new Car2();
```

- The compiler infers the correct type from the initializer.

## Passing references to methods

- When you pass an object reference to a method, the reference value is copied.
- The callee receives its own reference variable pointing to the same object.
- The method *can* mutate the object (through the reference).
- The method *cannot* make the caller’s variable refer to a different object (it can only reassign its local reference).

## `null` defaults & local variable rules

- Reference-typed fields (instance/class variables) default to `null` if not initialized.
- Local reference variables (inside methods) are not automatically initialized; you must set a value before use.

## Arrays and interfaces (special reference types)

- **Arrays** are objects that hold a collection of a base type.
    - Example: `int[]` holds `int` elements; `String[]` holds `String` elements.
    - Declaring an array type implicitly creates a container class type for that base type.
- **Interfaces** define a set of methods and a corresponding type.
    - Any object implementing the interface can be referred to by the interface type, adding flexibility beyond the class hierarchy.

## Generics (parameterized types)

- **Generics** let you specialize a class with type parameters without changing the class’s code.

## A word about Strings

- `String` values are objects (reference types), but have compiler support that makes them feel “literal-friendly”.
- String literals in source (text between double quotes) are turned into `String` objects by the compiler.
- You can use them directly:

```java
System.out.println("Hello, World...");
String s = "I am the walrus...";
String t = "John said: \"I am the walrus...\"";
```

- `+` is overloaded for strings:
    - numbers: addition
    - strings: concatenation