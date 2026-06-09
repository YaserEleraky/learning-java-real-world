You're absolutely right — that table was **overly wide, hard to read, and mixed different types of examples poorly**. Let me give you a **clean, well-designed version** instead.

I will:
- Keep the original textbook content **unchanged**
- Keep the `→` English notes and `→ العربية:` Arabic notes
- Present **each operator with its own clear, separate example** in a clean vertical list (not a wide table)
- Make it easy to read on any device

---

# 📘 Java Operators – مرجع ثنائي اللغة (عربي/إنجليزي)

> **English:** This document is a line‑by‑line annotated reference to the original textbook content about Java operators.  
> **العربية:** هذا المستند هو شرح سطر بسطر للنص الأصلي عن المعاملات (Operators) في جافا، مع إضافة تفسيرات بالعربية.

---

## Operators

**→** Operators help you combine or alter expressions in various ways. They "operate" expressions.  
**→ العربية:** المعاملات تساعدك في دمج أو تغيير التعابير بطرق مختلفة. هي "تعمل على" التعابير.

Java supports almost all standard operators from the C language. These operators also have the same precedence in Java as they do in C, as shown in Table 4-3.  
**→** Precedence determines which operator is evaluated first in an expression (e.g., multiplication before addition).  
**→ العربية:** الأسبقية (precedence) تحدد أي معامل يُقيّم أولاً في التعبير (مثلاً الضرب قبل الجمع).

**Table 4-3. Java operators**  
**جدول 4-3. معاملات جافا**

| Precedence | Operator | Operand type | Description |
|------------|----------|--------------|-------------|
| 1 | `++` , `--` | Arithmetic | Increment and decrement |
| 1 | `+` , `-` | Arithmetic | Unary plus and minus |
| 1 | `~` | Integral | Bitwise complement |
| 1 | `!` | Boolean | Logical complement |
| 1 | `( type )` | Any | Cast |
| 2 | `*` , `/` , `%` | Arithmetic | Multiplication, division, remainder |
| 3 | `+` , `-` | Arithmetic | Addition and subtraction |
| 3 | `+` | String | String concatenation |
| 4 | `<<` | Integral | Left shift |
| 4 | `>>` | Integral | Right shift with sign extension |
| 4 | `>>>` | Integral | Right shift with no extension |
| 5 | `<` , `<=` , `>` , `>=` | Arithmetic | Numeric comparison |
| 5 | `instanceof` | Object | Type comparison |
| 6 | `==` , `!=` | Primitive | Equality and inequality of value |
| 6 | `==` , `!=` | Object | Equality and inequality of reference |
| 7 | `&` | Integral | Bitwise AND |
| 7 | `&` | Boolean | Boolean AND |
| 8 | `^` | Integral | Bitwise XOR |
| 8 | `^` | Boolean | Boolean XOR |
| 9 | `\|` | Integral | Bitwise OR |
| 9 | `\|` | Boolean | Boolean OR |
| 10 | `&&` | Boolean | Conditional AND |
| 11 | `\|\|` | Boolean | Conditional OR |
| 12 | `? :` | N/A | Conditional ternary operator |
| 13 | `=` | Any | Assignment |

**→** The table shows operators from highest precedence (1) to lowest (13).  
**→ العربية:** الجدول يظهر المعاملات من أعلى أسبقية (1) إلى أدنى أسبقية (13).

---

## 📌 Examples for Each Operator

Below is **one clear example per operator**. You can run these in `jshell`.

---

### 1. `++` (Increment)

```java
int a = 5;
int b = a++;   // b = 5, then a becomes 6
```

**→ English:** Post-increment: returns old value, then increases.  
**→ العربية:** الزيادة اللاحقة: ترجع القيمة القديمة، ثم تزيد.

```java
int a = 5;
int b = ++a;   // a becomes 6, then b = 6
```

**→ English:** Pre-increment: increases first, then returns new value.  
**→ العربية:** الزيادة السابقة: تزيد أولاً، ثم ترجع القيمة الجديدة.

---

### 2. `--` (Decrement)

```java
int a = 5;
int b = a--;   // b = 5, then a becomes 4
```

**→ English:** Post-decrement: returns old value, then decreases.  
**→ العربية:** الإنقاص اللاحق: يرجع القيمة القديمة، ثم ينقص.

```java
int a = 5;
int b = --a;   // a becomes 4, then b = 4
```

**→ English:** Pre-decrement: decreases first, then returns new value.  
**→ العربية:** الإنقاص السابق: ينقص أولاً، ثم يرجع القيمة الجديدة.

---

### 3. `+` (Unary plus)

```java
int a = +5;    // a = 5 (positive sign is usually omitted)
```

**→ English:** Unary plus – does nothing (just for clarity).  
**→ العربية:** الموجب الأحادي – لا يفعل شيئاً (للتوضيح فقط).

---

### 4. `-` (Unary minus)

```java
int a = -5;    // a = -5 (negative value)
```

**→ English:** Unary minus – negates the value.  
**→ العربية:** السالب الأحادي – يعكس الإشارة.

---

### 5. `~` (Bitwise complement)

```java
int a = 5;     // binary: 0101
int b = ~a;    // b = -6 (binary: 1010)
```

**→ English:** Flips all bits (0 becomes 1, 1 becomes 0).  
**→ العربية:** يقلب جميع البتات (0 يصبح 1 و 1 يصبح 0).

---

### 6. `!` (Logical NOT)

```java
boolean flag = true;
boolean result = !flag;   // result = false
```

**→ English:** Negates a boolean value.  
**→ العربية:** يعكس القيمة المنطقية.

---

### 7. `(type)` (Cast)

```java
double d = 3.14;
int i = (int) d;   // i = 3 (truncated)
```

**→ English:** Converts one type to another.  
**→ العربية:** يحول نوع بيانات إلى آخر.

---

### 8. `*` (Multiplication)

```java
int product = 6 * 7;   // product = 42
```

**→ English:** Multiplies two numbers.  
**→ العربية:** يضرب رقمين.

---

### 9. `/` (Division)

```java
int quotient = 15 / 4;   // quotient = 3 (integer division truncates)
```

**→ English:** Divides two numbers (integer division truncates).  
**→ العربية:** يقسم رقمين (القسمة الصحيحة تقطع الكسور).

---

### 10. `%` (Remainder)

```java
int remainder = 15 % 4;   // remainder = 3
```

**→ English:** Returns the remainder after division.  
**→ العربية:** يرجع الباقي بعد القسمة.

---

### 11. `+` (Addition)

```java
int sum = 10 + 20;   // sum = 30
```

**→ English:** Adds two numbers.  
**→ العربية:** يجمع رقمين.

---

### 12. `-` (Subtraction)

```java
int difference = 20 - 8;   // difference = 12
```

**→ English:** Subtracts two numbers.  
**→ العربية:** يطرح رقمين.

---

### 13. `+` (String concatenation)

```java
String message = "Hello, " + "World";   // message = "Hello, World"
```

**→ English:** Joins two strings together.  
**→ العربية:** يدمج سلسلتين نصيتين.

---

### 14. `<<` (Left shift)

```java
int x = 3 << 1;   // 3 (binary 11) → 6 (binary 110)
```

**→ English:** Shifts bits to the left (multiplies by 2).  
**→ العربية:** يزيح البتات لليسار (يضرب في 2).

---

### 15. `>>` (Right shift with sign extension)

```java
int x = -8 >> 1;   // -8 → -4 (preserves negative sign)
```

**→ English:** Shifts right, preserving the sign bit.  
**→ العربية:** يزيح لليمين مع الحفاظ على بت الإشارة.

---

### 16. `>>>` (Right shift with zero extension)

```java
int x = -8 >>> 1;   // -8 becomes a large positive number (2147483644)
```

**→ English:** Shifts right, always fills with 0 (unsigned).  
**→ العربية:** يزيح لليمين ويملأ بالأصفار دائماً (بدون إشارة).

---

### 17. `<` (Less than)

```java
boolean result = 5 < 3;   // result = false
```

**→ English:** Checks if left is less than right.  
**→ العربية:** يتحقق إذا كان اليسار أصغر من اليمين.

---

### 18. `<=` (Less than or equal)

```java
boolean result = 5 <= 5;   // result = true
```

**→ English:** Checks if left is less than or equal to right.  
**→ العربية:** يتحقق إذا كان اليسار أصغر أو يساوي اليمين.

---

### 19. `>` (Greater than)

```java
boolean result = 5 > 3;   // result = true
```

**→ English:** Checks if left is greater than right.  
**→ العربية:** يتحقق إذا كان اليسار أكبر من اليمين.

---

### 20. `>=` (Greater than or equal)

```java
boolean result = 5 >= 6;   // result = false
```

**→ English:** Checks if left is greater than or equal to right.  
**→ العربية:** يتحقق إذا كان اليسار أكبر أو يساوي اليمين.

---

### 21. `instanceof` (Type comparison)

```java
String s = "hello";
boolean result = s instanceof String;   // result = true
```

**→ English:** Checks if an object is of a certain type.  
**→ العربية:** يتحقق إذا كان الكائن من نوع معين.

---

### 22. `==` (Equality – primitive)

```java
int a = 5, b = 5;
boolean result = a == b;   // result = true
```

**→ English:** Checks if two primitive values are equal.  
**→ العربية:** يتحقق إذا كانت قيمتان أوليتان متساويتين.

---

### 23. `!=` (Inequality – primitive)

```java
int a = 5, b = 6;
boolean result = a != b;   // result = true
```

**→ English:** Checks if two primitive values are not equal.  
**→ العربية:** يتحقق إذا كانت قيمتان أوليتان غير متساويتين.

---

### 24. `==` (Reference equality)

```java
String a = "hi";
String b = "hi";
boolean result = (a == b);   // may be true (same object in string pool)
```

**→ English:** Checks if two references point to the same object.  
**→ العربية:** يتحقق إذا كان مرجعان يشيران إلى نفس الكائن.

---

### 25. `!=` (Reference inequality)

```java
String a = new String("hi");
String b = new String("hi");
boolean result = (a != b);   // result = true (different objects)
```

**→ English:** Checks if two references point to different objects.  
**→ العربية:** يتحقق إذا كان مرجعان يشيران إلى كائنات مختلفة.

---

### 26. `&` (Bitwise AND)

```java
int x = 5 & 3;   // 5 (0101) & 3 (0011) = 1 (0001)
```

**→ English:** Performs AND on each bit pair.  
**→ العربية:** ينفذ عملية AND على كل زوج من البتات.

---

### 27. `&` (Boolean AND)

```java
boolean a = true, b = false;
boolean result = a & b;   // result = false (evaluates both sides)
```

**→ English:** Logical AND (always evaluates both sides).  
**→ العربية:** AND منطقي (يُقيّم الطرفين دائماً).

---

### 28. `^` (Bitwise XOR)

```java
int x = 5 ^ 3;   // 5 (0101) ^ 3 (0011) = 6 (0110)
```

**→ English:** Performs XOR on each bit pair (1 if bits differ).  
**→ العربية:** XOR على البتات (1 إذا اختلفت البتات).

---

### 29. `^` (Boolean XOR)

```java
boolean a = true, b = false;
boolean result = a ^ b;   // result = true (different values)
```

**→ English:** Logical XOR – true if operands differ.  
**→ العربية:** XOR منطقي – true إذا اختلف المعاملان.

---

### 30. `|` (Bitwise OR)

```java
int x = 5 | 3;   // 5 (0101) | 3 (0011) = 7 (0111)
```

**→ English:** Performs OR on each bit pair.  
**→ العربية:** ينفذ عملية OR على كل زوج من البتات.

---

### 31. `|` (Boolean OR)

```java
boolean a = true, b = false;
boolean result = a | b;   // result = true (evaluates both sides)
```

**→ English:** Logical OR (always evaluates both sides).  
**→ العربية:** OR منطقي (يُقيّم الطرفين دائماً).

---

### 32. `&&` (Conditional AND – short-circuit)

```java
boolean a = false;
boolean result = a && (10/0 > 0);   // result = false, no division by zero!
```

**→ English:** Stops if first operand is false (short-circuit).  
**→ العربية:** يتوقف إذا كان المعامل الأول false (اختصار).

---

### 33. `||` (Conditional OR – short-circuit)

```java
boolean a = true;
boolean result = a || (10/0 > 0);   // result = true, no division by zero!
```

**→ English:** Stops if first operand is true (short-circuit).  
**→ العربية:** يتوقف إذا كان المعامل الأول true (اختصار).

---

### 34. `? :` (Ternary conditional)

```java
int age = 20;
String status = (age >= 18) ? "adult" : "minor";   // status = "adult"
```

**→ English:** If condition true → first value, else → second value.  
**→ العربية:** إذا كان الشرط صحيحاً → القيمة الأولى، وإلاً → القيمة الثانية.

---

### 35. `=` (Assignment)

```java
int x;
x = 10;   // x now holds 10
```

**→ English:** Assigns the value on the right to the variable on the left.  
**→ العربية:** يضع قيمة الطرف الأيمن في المتغير الأيسر.

---

We should also note that the percent (`%`) operator is not strictly a modulo but a remainder, and it can have a negative value.  
**→** In Java, `%` returns the remainder, which can be negative if the left operand is negative.  
**→ العربية:** في جافا، `%` يرجع الباقي، وقد يكون سالباً إذا كان المعامل الأيسر سالباً.

Try playing with some of these operators in `jshell` to get a better sense of their effects. If you’re somewhat new to programming, it is particularly useful to get comfortable with operators and their order of precedence. You’ll regularly encounter expressions and operators even when performing mundane tasks in your code:

```java
jshell> int x = 5
x ==> 5

jshell> int y = 12
y ==> 12

jshell> int sumOfSquares = x * x + y * y
sumOfSquares ==> 169

jshell> int explicitOrder = (((x * x) + y) * y)
explicitOrder ==> 444

jshell> sumOfSquares % 5
$7 ==> 4
```

Java also adds some new operators. As we’ve seen, you can use the `+` operator with `String` values to perform string concatenation.  
**→** Example: `"Hello, " + "World"` results in `"Hello, World"`.  
**→ العربية:** مثال: `"Hello, " + "World"` ينتج `"Hello, World"`.

Because all integer types in Java are signed values, you can use the `>>` operator to perform a right-arithmetic-shift operation with sign extension. The `>>>` operator treats the operand as an unsigned number and performs a right-arithmetic-shift with no sign extension.

As programmers, we don’t need to manipulate the individual bits in our variables nearly as much as we used to, so you likely won’t see these shift operators very often. If they do crop up in encoding or binary data parsing examples you read online, feel free to pop into `jshell` to see how they work. This type of play is one of our favorite uses for `jshell`!

---

> **End of annotated document.**  
> **نهاية المستند المُعلّق.**
```

This version is **clean, readable, and well-organized** – each operator has its own numbered section with a clear example and bilingual explanation. You can save it as `Java_Operators_Clean.md`.