Here is a **professionally designed Markdown document** for the **Assignment, null, variable access, method invocation, object creation, and instanceof** sections. It follows the same Notion‑style aesthetic: badges, collapsible sections, bilingual notes, code blocks, tables, and callouts.

<div align="center">

# 📝 Assignment & Member Access in Java

### 🧩 *Statements, Expressions, and Object Operations – Bilingual Guide*

[![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)](https://java.com)
[![Level](https://img.shields.io/badge/Level-Intermediate-blue?style=for-the-badge)](https://github.com)
[![jshell](https://img.shields.io/badge/Try_it_in-jshell-important?style=for-the-badge&logo=java)](https://docs.oracle.com/javase/9/jshell/introduction-jshell.htm)

</div>

---

## 📚 Table of Contents

| Section | Description |
|---------|-------------|
| [Assignment as Expression](#-assignment-as-expression) | How `=` can return a value |
| [The `null` Value](#-the-null-value) | No reference – and its dangers |
| [Variable Access (Dot Operator)](#-variable-access-dot-operator) | Selecting members with `.` |
| [Method Invocation](#-method-invocation) | Calling functions, returning values |
| [Object Creation](#-object-creation) | Using `new` and chaining |
| [The `instanceof` Operator](#-the-instanceof-operator) | Runtime type checking |
| [Euclid’s GCD Algorithm](#-euclids-gcd-algorithm) | Putting it all together |

---

## 🔄 Assignment as Expression

> While declaring and initializing a variable is considered a **statement** with no resulting value, **variable assignment alone** is, in fact, an **expression**.

```java
int i, j;   // statement with no resulting value
int k = 6;  // also a statement with no result
i = 5;      // both a statement and an expression ✅
```

| English | العربية |
|---------|---------|
| Declaration + initialization is a statement (no value). Assignment alone is an expression (it produces a value). | التعريف + التهيئة عبارة ليس لها قيمة. التخصيص وحده هو تعبير (له قيمة). |

Normally we rely on assignment for its **side effects** alone, but an assignment can be used as a **value** in another part of an expression:

```java
j = (i = 5);   // both j and i are now 5
```

> ⚠️ **Caution:** Relying on order of evaluation extensively (compound assignments) can make code obscure. Not recommended for readability, but you’ll see it in online examples.  
> ⚠️ **تنبيه:** الاعتماد على ترتيب التقييم بكثرة يجعل الكود غامضاً. لا يُنصح به، لكن قد تراه في الأمثلة على الإنترنت.

---

## 🚫 The `null` Value

> The expression **`null`** can be assigned to any reference type. It means **“no reference”**.

| English | العربية |
|---------|---------|
| A `null` reference cannot be used to reference anything. Attempting to do so throws a `NullPointerException` at runtime. | المرجع `null` لا يمكن استخدامه للإشارة إلى أي شيء. محاولة استخدامه تسبب `NullPointerException` وقت التنفيذ. |

> 💡 **Remember:** `null` is the **default value** for uninitialized class and instance variables. Always initialize reference variables before using them!  
> 💡 **تذكر:** `null` هي القيمة الافتراضية للمتغيرات غير المهيأة في الكلاسات. دائماً قم بتهيئة متغيرات المرجع قبل استخدامها!

---

## 🖱️ Variable Access (Dot Operator)

> The **dot (`.`)** operator selects members of a class or object instance.

```java
int i = myObject.length;      // access instance variable
String s = myObject.name;     // access another variable
myObject.someMethod();        // invoke a method
```

### 🔗 Chaining (Compound Evaluation)

A reference‑type expression can be used in **compound evaluations** – multiple dots in one expression:

```java
int len = myObject.name.length();
int initialLen = myObject.name.substring(5, 10).length();
```

| English | العربية |
|---------|---------|
| This is also called **chaining method calls**. Each dot selects a member from the previous result. | هذا يسمى **تسلسل استدعاءات الدوال**. كل نقطة تختار عضواً من النتيجة السابقة. |

Familiar example:

```java
System.out.println("calling println on out");
```

---

## 📞 Method Invocation

> Methods are functions that live within a class. **Invoking a method** means executing its body, passing parameters, and possibly getting a return value.

| English | العربية |
|---------|---------|
| A method invocation is an **expression** that results in a value (or `void` if no value). | استدعاء الدالة هو **تعبير** ينتج قيمة (أو `void` إذا لم تكن هناك قيمة). |

```java
System.out.println("Hello, World...");   // void – no value
int myLength = myString.length();        // returns an int
```

> 🧪 **Try in jshell:**

```java
jshell> String myString = "Hi there!"
myString ==> "Hi there!"

jshell> int myLength = myString.length()
myLength ==> 9

jshell> int mistake = System.out.println("This is a mistake.")
|  Error:
|  incompatible types: void cannot be converted to int
```

> ℹ️ `void` methods (like `println`) produce output but **no value** – they cannot be assigned to a variable.

---

## 🏗️ Object Creation

> Objects in Java are allocated with the **`new`** operator.

```java
Object o = new Object();   // constructor call returns a reference
```

| English | العربية |
|---------|---------|
| The constructor is a method with the same name as the class. The `new` expression returns a reference of the object’s type. | الدالة البانية (constructor) لها نفس اسم الكلاس. تعبير `new` يرجع مرجعاً من نوع الكائن. |

### 🔄 Chaining without an intermediate variable

Because `new` binds tighter than dot (`.`), you can create an object and call a method on it **without storing the reference**:

```java
jshell> int hours = new Date().getHours()
hours ==> 13
```

| English | العربية |
|---------|---------|
| The `Date` object lives just long enough to call `getHours()`, then becomes eligible for garbage collection. | كائن `Date` يعيش فقط لوقت كافٍ لاستدعاء `getHours()`، ثم يصبح جاهزاً للتجميع (garbage collection). |

> 💡 **Style note:** This is common but can be less clear. For beginners, using an intermediate variable is often more readable.  
> 💡 **ملاحظة أسلوبية:** هذا شائع لكن قد يكون أقل وضوحاً. للمبتدئين، استخدام متغير وسيط غالباً ما يكون أوضح.

---

## 🔍 The `instanceof` Operator

> `instanceof` determines the type of an object **at runtime**. It tests if an object is of the same type or a subtype of the target type.

| English | العربية |
|---------|---------|
| Returns `true` if the object can be assigned to a variable of the target type. | يرجع `true` إذا كان الكائن يمكن تعيينه لمتغير من النوع المستهدف. |

```java
String str = "something";
boolean b = (str instanceof String);   // true
b = (str instanceof Object);           // true – String is a subclass of Object
```

### 🚨 Important: `null` is not an instance of anything

```java
jshell> String s = null
s ==> null

jshell> s instanceof String
$7 ==> false   // always false
```

> ⚠️ The compiler prevents impossible type checks:

```java
jshell> b = (str instanceof Date)
|  Error: incompatible types: String cannot be converted to Date
```

### 📦 Arrays with `instanceof`

```java
if (myVariable instanceof byte[]) {
    // myVariable is an array of bytes
}
```

---

## 🧮 Euclid’s GCD Algorithm – Putting It All Together

> A classic algorithm using a `while` loop, `if/else`, and assignments.

```java
// filename: ch04/examples/EuclidGCD.java
int a = 2701;
int b = 222;

while (b != 0) {
    if (a > b) {
        a = a - b;
    } else {
        b = b - a;
    }
}
System.out.println("GCD is " + a);   // GCD is 37
```

| English | العربية |
|---------|---------|
| This is exactly the kind of repetitive task computers excel at. Practice turning problems into algorithms and then into Java code. | هذا هو بالضبط نوع المهام المتكررة التي تتفوق فيها الحواسيب. تدرب على تحويل المشاكل إلى خوارزميات ثم إلى كود جافا. |

> 💪 **Exercise:** Put the GCD code inside a `main()` method. Change the values of `a` and `b`. Later (Chapter 8) you’ll learn to read numbers from command line arguments.

---

<div align="center">

---

**🎯 Summary – ملخص سريع**

| Concept | English | العربية |
|---------|---------|---------|
| Assignment | Is an **expression** returning a value | هو **تعبير** يرجع قيمة |
| `null` | No reference → `NullPointerException` if used | لا مرجع → استثناء إذا استخدم |
| Dot (`.`) | Selects members, supports chaining | يختار الأعضاء، يدعم التسلسل |
| Method invocation | Expression that may return a value or `void` | تعبير قد يرجع قيمة أو `void` |
| `new` | Creates objects, returns a reference | ينشئ كائنات، يرجع مرجعاً |
| `instanceof` | Runtime type check (false for `null`) | فحص النوع وقت التنفيذ (خطأ مع `null`) |

---

**🎉 Happy coding – برمجة سعيدة 🎉**

</div>
```

You can save this as `Java_Assignment_and_More_NotionStyle.md`. It includes:

- ✅ **Badges** for visual flair
- ✅ **Table of Contents** for navigation
- ✅ **Collapsible sections** (optional – I used plain headings for clarity, but you can wrap sections in `<details>` if desired)
- ✅ **Bilingual tables** for key concepts
- ✅ **Code blocks** with syntax highlighting
- ✅ **Callouts** (`> ℹ️`, `> ⚠️`)
- ✅ **jshell examples**
- ✅ **A final summary table**

The original content is preserved, only enhanced with structure, visuals, and Arabic translations.