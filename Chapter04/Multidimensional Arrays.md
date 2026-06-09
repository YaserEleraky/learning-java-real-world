Here is the **professionally designed Markdown document** for **Multidimensional Arrays**, following the same Notion‑style aesthetic as before. It includes the complete original content, bilingual explanations, emojis, tables, callouts, and a visual array diagram description.


<div align="center">

# 🧩 Multidimensional Arrays in Java

### 📐 *Arrays of Arrays – Bilingual Guide*

[![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)](https://java.com)
[![Level](https://img.shields.io/badge/Level-Intermediate-blue?style=for-the-badge)](https://github.com)
[![jshell](https://img.shields.io/badge/Try_it_in-jshell-important?style=for-the-badge&logo=java)](https://docs.oracle.com/javase/9/jshell/introduction-jshell.htm)

</div>

---

## 📚 Table of Contents

| Section | Description |
|---------|-------------|
| [What are Multidimensional Arrays?](#-what-are-multidimensional-arrays) | Arrays of arrays – concept |
| [Creation & Access](#-creation--access) | Syntax with `new` and indices |
| [Partial Indexing (Subarrays)](#-partial-indexing-subarrays) | Getting a row as an array |
| [Non‑rectangular (Ragged) Arrays](#-nonrectangular-ragged-arrays) | Leaving dimensions unspecified |
| [When to Leave Dimensions Unspecified](#-when-to-leave-dimensions-unspecified) | Ragged arrays and flexibility |
| [Practice with `jshell`](#-practice-with-jshell) | Experimentation tips |
| [Summary Table](#-summary-table) | Quick reference |

---

## 🧠 What are Multidimensional Arrays?

> Java supports **multidimensional arrays** as **arrays of other arrays**.  
> العربية: تدعم جافا **المصفوفات متعددة الأبعاد** كـ **مصفوفات من مصفوفات أخرى**.

You create them with **multiple bracket pairs** – one for each dimension.

### ♟️ Chessboard example (8×8)

```java
ChessPiece[][] chessBoard;
chessBoard = new ChessPiece[8][8];

chessBoard[0][0] = new ChessPiece.Rook();
chessBoard[1][0] = new ChessPiece.Pawn();
chessBoard[0][1] = new ChessPiece.Knight();
// setup the remaining pieces
```

| English | العربية |
|---------|---------|
| `chessBoard` is declared as `ChessPiece[][]` (an array of `ChessPiece` arrays). The `new` operator creates an 8×8 grid. | `chessBoard` يُعرَّف كـ `ChessPiece[][]` (مصفوفة من مصفوفات `ChessPiece`). عامل `new` ينشئ شبكة 8×8. |

> 📌 **Visual idea:**  
> `chessBoard` → points to an array of 8 rows → each row is an array of 8 `ChessPiece` references.

---

## 🎨 Creation & Access

### 3‑dimensional array (RGB colour cube – 256³)

```java
Color[][][] rgb = new Color[256][256][256];
rgb[0][0][0] = Color.BLACK;
rgb[255][255][0] = Color.YELLOW;
rgb[128][128][128] = Color.GRAY;
// Only 16 million to go!
```

| English | العربية |
|---------|---------|
| You can have any number of dimensions. Access each element with the appropriate number of indices. | يمكن أن يكون لديك أي عدد من الأبعاد. الوصول إلى كل عنصر باستخدام العدد المناسب من الفهارس. |

---

## 🔍 Partial Indexing (Subarrays)

> A **partial index** returns a **subarray** – an array of the next lower dimension.

```java
ChessPiece[] homeRow = {
    new ChessPiece("Rook"), new ChessPiece("Knight"),
    new ChessPiece("Bishop"), new ChessPiece("King"),
    new ChessPiece("Queen"), new ChessPiece("Bishop"),
    new ChessPiece("Knight"), new ChessPiece("Rook")
};
chessBoard[0] = homeRow;   // assigns the entire first row
```

| English | العربية |
|---------|---------|
| `chessBoard[0]` is of type `ChessPiece[]` (the first row). | `chessBoard[0]` من النوع `ChessPiece[]` (الصف الأول). |

---

## 🔲 Non‑rectangular (Ragged) Arrays

> You can leave **trailing dimension sizes unspecified**, then assign arrays of different lengths later.

```java
boolean[][] checkerBoard = new boolean[8][];   // only first dimension fixed
// Now each row can be created separately:
checkerBoard[0] = new boolean[8];
checkerBoard[1] = new boolean[8];
// ...
checkerBoard[7] = new boolean[8];
```

This is **equivalent** to:

```java
boolean[][] checkerBoard = new boolean[8][8];
```

### 📐 Triangular array (ragged)

> Row 0 has 1 column, row 1 has 2 columns, row 2 has 3 columns, etc.

```
Row 0: [ ]
Row 1: [ ][ ]
Row 2: [ ][ ][ ]
Row 3: [ ][ ][ ][ ]
...
```

```java
int[][] triangle = new int[5][];
for (int i = 0; i < triangle.length; i++) {
    triangle[i] = new int[i + 1];
}
```

| English | العربية |
|---------|---------|
| Multidimensional arrays in Java **do not have to be rectangular**. Each inner array can have a different length. | المصفوفات متعددة الأبعاد في جافا **ليست بالضرورة مستطيلة**. كل مصفوفة داخلية يمكن أن يكون لها طول مختلف. |

---

## 🧪 When to Leave Dimensions Unspecified

Reasons:

1. You don't know the size of the inner arrays yet.
2. You want a **ragged array** (different lengths per row).
3. You will receive the inner arrays from elsewhere (e.g., as method parameters).

```java
// Example: storing rows given by user input
int[][] dynamicTable = new int[rows][];   // rows known, columns unknown
for (int i = 0; i < rows; i++) {
    int cols = getUserInputForRow(i);
    dynamicTable[i] = new int[cols];
}
```

> 💡 **Note:** The **first dimension** (the most significant) **must always be specified** when using `new`. All other dimensions may be left unspecified.

---

## 🧪 Practice with `jshell`

> The original text encourages experimentation:

> *“It’s always worth a moment to check your understanding of what a variable can store. Arrays in particular might benefit from a little experimentation.”*

Try these in `jshell`:

```java
jshell> int[][] matrix = new int[3][];
matrix[0] = new int[]{1,2};
matrix[1] = new int[]{3,4,5};
matrix[2] = new int[]{6};

jshell> matrix[1][2]
$5 ==> 5

jshell> int[][] square = {{1,2},{3,4}};
square ==> int[2][] { int[2] { 1, 2 }, int[2] { 3, 4 } }
```

You can also practice `if`, `while`, and loops inside `jshell` – it’s a great tool for learning.

---

## 📊 Summary Table

| Concept | Syntax Example | English Notes | العربية |
|---------|----------------|---------------|---------|
| Declaration | `int[][] matrix;` | Reference to a 2D array | مرجع لمصفوفة ثنائية الأبعاد |
| Creation (rectangular) | `matrix = new int[3][4];` | 3 rows, 4 columns | 3 صفوف، 4 أعمدة |
| Creation (ragged) | `matrix = new int[3][];` | Only first dimension fixed | فقط البعد الأول محدد |
| Access element | `matrix[1][2] = 42;` | Row index, then column index | فهرس الصف ثم فهرس العمود |
| Get a row (subarray) | `int[] row = matrix[0];` | Returns a 1D array | يرجع مصفوفة أحادية البعد |
| Curly‑brace init | `int[][] m = {{1,2},{3,4}};` | Nested braces | أقواس متداخلة |
| Ragged init | `int[][] r = new int[2][]; r[0]=new int[1]; r[1]=new int[2];` | Different inner lengths | أطوال داخلية مختلفة |

---

<div align="center">

---

**🎉 Arrays are powerful – explore them with `jshell`! 🎉**  
**🎉 المصفوفات أدوات قوية – اكتشفها باستخدام `jshell`! 🎉**

</div>
```

You can save this as `Java_Multidimensional_Arrays_NotionStyle.md`. It includes all the original content (chessboard, RGB, ragged arrays, triangular arrays, practice advice) with added Arabic translations, clean visual structure, and a summary table. The design uses badges, tables, code blocks, and consistent emoji headers.