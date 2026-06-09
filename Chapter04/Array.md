Here is a **professionally designed Markdown document** for the **Arrays** section, following the same Notion‑style aesthetic: badges, table of contents, bilingual explanations, code blocks, callouts, and a summary table.


<div align="center">

# 📦 Arrays in Java

### 🧩 *Ordered Collections – Bilingual Guide*

[![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)](https://java.com)
[![Level](https://img.shields.io/badge/Level-Intermediate-blue?style=for-the-badge)](https://github.com)
[![jshell](https://img.shields.io/badge/Try_it_in-jshell-important?style=for-the-badge&logo=java)](https://docs.oracle.com/javase/9/jshell/introduction-jshell.htm)

</div>

---

## 📚 Table of Contents

| Section | Description |
|---------|-------------|
| [What is an Array?](#-what-is-an-array) | Definition and key properties |
| [Array Types](#-array-types) | Syntax for declaring array variables |
| [Array Creation & Initialization](#-array-creation--initialization) | `new`, `{}`, and default values |
| [Using Arrays](#-using-arrays) | `length`, access, bounds checking |
| [Copying Arrays](#-copying-arrays) | `System.arraycopy`, `Arrays.copyOf`, `copyOfRange` |
| [Anonymous Arrays](#-anonymous-arrays) | Throwaway arrays for method calls |
| [Summary Table](#-summary-table) | Quick reference |

---

## 🧠 What is an Array?

> An **array** is a special type of object that holds an **ordered collection** of elements.

| English | العربية |
|---------|---------|
| The **base type** is the type of each element. The **length** is the fixed number of elements. | **النوع الأساسي** هو نوع كل عنصر. **الطول** هو عدد العناصر الثابت. |

Java supports arrays of all primitive types and reference types:

```java
byte[]   // array of bytes
String[] // array of Strings
```

### 🔍 How Java Arrays Differ from C/C++

| Feature | Java Arrays | C/C++ Arrays |
|---------|-------------|---------------|
| Are they objects? | ✅ Yes, first‑class objects | ❌ No (raw memory) |
| `length` field | ✅ Available as `array.length` | ❌ No built‑in length |
| Bounds checking | ✅ Runtime check (`ArrayIndexOutOfBoundsException`) | ❌ No bounds checking |
| Default values | ✅ Always zero / null / false | ❌ Garbage values |

> 💡 **Important:** Arrays in Java are **objects** – you declare a reference, then create the array object with `new`.

---

## 📝 Array Types

An array variable is denoted by the **base type** followed by empty brackets `[]`.

### Allowed syntax (equivalent):

```java
int[] arrayOfInts;   // ✅ preferred
int [] arrayOfInts;  // ✅ spacing optional
int arrayOfInts[];   // ✅ C‑style (allowed)
```

| English | العربية |
|---------|---------|
| The size is **not** part of the type. Only the array object itself has a length. | الحجم **ليس** جزءاً من النوع. فقط كائن المصفوفة نفسه له طول. |

Arrays of reference types:

```java
String[] someStrings;
JLabel someLabels[];
```

---

## 🏗️ Array Creation & Initialization

### Using `new` with a length

```java
int number = 10;
arrayOfInts = new int[42];
someStrings = new String[number + 2];
```

Combine declaration and allocation:

```java
double[] someNumbers = new double[20];
Component[] widgets = new Component[12];
```

### 🔢 Default Values

| Base type | Default initial value |
|-----------|----------------------|
| Numeric types (`int`, `double`, etc.) | `0` |
| `boolean` | `false` |
| Reference types (`String`, `Object`, etc.) | `null` |

```java
int[] grades = new int[30];   // all elements are 0
String[] names = new String[42]; // all elements are null
```

> ⚠️ **Important:** An array of objects holds **references**, not the objects themselves. You must assign actual objects to each slot.

### 📸 Visual representation

```
names: [String] -> null
       [String] -> "Alice"
       [String] -> "Bob"
       [String] -> null
```

### 🌟 Curly‑brace initialization (without `new`)

```java
jshell> int[] primes = { 2, 3, 5, 7, 7+4 };
primes ==> int[5] { 2, 3, 5, 7, 11 }
```

With objects:

```java
String[] verbs = { "run", "jump", "hide" };
JLabel[] choices = { yesLabel, noLabel, new JLabel("Maybe") };
Object[] anything = { "run", yesLabel, new Date() };
```

---

## 🛠️ Using Arrays

### The `length` field – **not a method!**

```java
jshell> char[] alphabet = new char[26];
jshell> alphabet.length
$24 ==> 26

jshell> String[] musketeers = { "one", "two", "three" };
jshell> musketeers.length
$25 ==> 3
```

> ❌ `alphabet.length()` – wrong! Compiler will complain.

### Accessing elements (zero‑based index)

```java
System.out.println(musketeers[1]);  // prints "two"
```

### Filling an array with a loop

```java
JButton[] keyPad = new JButton[10];
for (int i = 0; i < keyPad.length; i++)
    keyPad[i] = new JButton("Button " + i);
```

### Enhanced for loop (for‑each)

```java
for (JButton b : keyPad)
    System.out.println(b);
```

### ⚠️ Bounds checking

```java
String[] states = new String[50];
try {
    states[50] = "McDonald's Land";   // Error: index 50 out of bounds
} catch (ArrayIndexOutOfBoundsException err) {
    System.out.println("Handled: " + err.getMessage());
}
```

---

## 📋 Copying Arrays

### Low‑level: `System.arraycopy()`

```java
System.arraycopy(source, sourceStart, destination, destStart, length);
```

**Example – doubling array size:**

```java
String[] tmpVar = new String[2 * names.length];
System.arraycopy(names, 0, tmpVar, 0, names.length);
names = tmpVar;
```

### High‑level: `java.util.Arrays.copyOf()` and `copyOfRange()`

```java
jshell> byte[] bar = { 1, 2, 3, 4, 5 };
jshell> byte[] barCopy = Arrays.copyOf(bar, bar.length);
barCopy ==> byte[5] { 1, 2, 3, 4, 5 }

jshell> byte[] expanded = Arrays.copyOf(bar, bar.length + 2);
expanded ==> byte[7] { 1, 2, 3, 4, 5, 0, 0 }

jshell> byte[] firstThree = Arrays.copyOfRange(bar, 0, 3);
firstThree ==> byte[3] { 1, 2, 3 }

jshell> byte[] lastThree = Arrays.copyOfRange(bar, 2, bar.length);
lastThree ==> byte[3] { 3, 4, 5 }

jshell> byte[] plusTwo = Arrays.copyOfRange(bar, 2, bar.length + 2);
plusTwo ==> byte[5] { 3, 4, 5, 0, 0 }
```

> 📘 `copyOfRange(start, end)` – `start` inclusive, `end` exclusive. Padding with zeros or `null` if target length is larger.

---

## 🙈 Anonymous Arrays

> Sometimes you need a **throwaway array** – used only as an argument and never referenced again.

**Example:** Calling `setPets()` that expects an array of `Animal`.

```java
Dog pete = new Dog("golden");
Dog mj = new Dog("black-and-white");
Cat stash = new Cat("orange");

setPets(new Animal[] { pete, mj, stash });
```

| English | العربية |
|---------|---------|
| You must use `new` and the array type because it’s not a variable declaration. | يجب استخدام `new` ونوع المصفوفة لأنها ليست تعريف متغير. |

---

## 📊 Summary Table

| Concept | Syntax / Example | English Notes | العربية |
|---------|------------------|---------------|---------|
| Array declaration | `int[] arr;` | Reference variable, no size yet | متغير مرجعي، لا حجم بعد |
| Array creation | `arr = new int[10];` | Allocates 10 slots, default zeros | يخصص 10 خانات، القيم صفر |
| Combined | `int[] arr = new int[10];` | Declaration + creation | تعريف + إنشاء |
| Curly‑brace init | `int[] primes = {2,3,5};` | Implicit `new`, size inferred | `new` ضمني، الحجم يُستنتج |
| Length | `arr.length` | Field (not method) | حقل (ليس دالة) |
| Access | `arr[0] = 5;` | Zero‑based index | الفهرس يبدأ من صفر |
| Copy | `Arrays.copyOf(orig, newLen)` | Returns new array | يرجع مصفوفة جديدة |
| Anonymous | `new Animal[]{a,b,c}` | No variable name | بدون اسم متغير |

---

<div align="center">

---

**🎉 Arrays are powerful tools – practice with `jshell`! 🎉**

**المصفوفات أدوات قوية – تدرب عليها باستخدام `jshell`!**

</div>
```

You can save this as `Java_Arrays_NotionStyle.md`. It includes all the original content (array definition, types, creation, usage, copying, anonymous arrays) with added Arabic translations, a clean visual structure, and a summary table.