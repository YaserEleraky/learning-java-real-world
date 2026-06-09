# Primitive Types

## Overview

- Numbers, characters, and boolean values are *primitive* elements in Java.
- Unlike some other object-oriented languages, primitives are not objects.
- When it’s desirable to treat a primitive value as an object, Java provides **wrapper classes**.
- Treating primitives as special allows the compiler/runtime to optimize their implementation; operations can be mapped efficiently to hardware.

## Portability

- Java primitive types are precisely defined (e.g., `int` is always a 32-bit signed number), so their sizes don’t vary by platform.

## Size & capacity

- The “size” of a numeric type determines how large (or precise) a value it can store.
- Examples:
    - `byte`: 8-bit signed, range -128 to 127
    - `int`: 32-bit signed, range roughly ±2.1 billion

## Java primitive data types

| Type | Definition | Approximate range or precision |
| --- | --- | --- |
| boolean | Logical value | true or false |
| char | 16-bit, Unicode character | 64K characters |
| byte | 8-bit, signed integer | -128 to 127 |
| short | 16-bit, signed integer | -32,768 to 32,767 |
| int | 32-bit, signed integer | -2.1e9 to 2.1e9 |
| long | 64-bit, signed integer | -9.2e18 to 9.2e18 |
| float | 32-bit, IEEE 754 floating-point value | 6–7 significant decimal places |
| double | 64-bit, IEEE 754 | 15 significant decimal places |

## Why sizes exist (efficiency)

- Using smaller primitive types when appropriate can improve efficiency and optimization.
- Example intuition:
    - Goals scored in a soccer match usually fit in a `byte`.
    - Fan counts may require an `int` (or `long` depending on scale).
    - Total money spent across many events may require a `long` (or bigger).
- Picking the right size can help code run faster and/or use fewer system resources.

## Bigger / higher-precision numbers

- If you need numbers bigger than primitive types (or more precision than floating-point types), use:
    - `java.math.BigInteger` (near-infinite integer size)
    - `java.math.BigDecimal` (near-infinite decimal precision)
- These are common in scientific and cryptographic use cases where accuracy matters more than performance.

## Floating-point precision & `strictfp`

- Java floating-point follows IEEE 754, so results are normally consistent across platforms.
- Java may allow extended precision on some platforms, which can cause tiny differences in high-precision results.
- To force consistent floating-point behavior across platforms, use `strictfp` on the class that performs the floating-point work; this disables platform-specific floating-point optimizations.

## Variable declaration & initialization

- Declaration examples:
    - `int foo;`
    - `double d1, d2;`
    - `boolean isFun;`
- Declaration + initialization examples:
    - `int foo = 42;`
    - `double d1 = 3.14, d2 = 2 * 3.14;`
    - `boolean isFun = true;`
- **Class member variables** get default values if not initialized:
    - numeric → `0` (of the appropriate type)
    - `char` → `\\0`
    - `boolean` → `false`
    - reference types → `null`
- **Local variables** (inside methods) must be explicitly initialized before use; the compiler enforces this.

## Integer literals

- Integer literals can be specified in:
    - binary (base 2): prefix `0b` / `0B`
    - octal (base 8): leading `0`
    - decimal (base 10): default
    - hexadecimal (base 16): prefix `0x` / `0X`
- Examples:
    - `int i = 1230;`
    - `int i = 0b01001011; // 75 decimal`
    - `int i = 01230; // 664 decimal`
    - `int i = 0xFFFF; // 65535 decimal`
- Integer literals are `int` by default, unless suffixed with `L` (long):
    - `long l = 13L;`
    - `long l = 13; // promoted from int`

## Promotion & casting

- When a smaller numeric type is used with a larger-range type, Java may **promote** it.
- Example:
    - `byte b = 42;`
    - `int i = 43;`
    - `int result = b * i; // b promoted to int`
- Assigning from a larger range to a smaller range requires an explicit **cast**:
    - `int i = 13;`
    - `byte b = (byte) i;`
- Converting floating-point to integer always requires an explicit cast (possible loss of precision).

## Underscores in numeric literals

- You can add `_` between digits for readability:
    - `int JAVA_ID = 0xCAFE_BABE;`
    - `long grandTotal = 40_123_456_789L;`
- Underscores can only appear **between digits** (not at start/end, not next to the `L` suffix).

## Floating-point literals

- Floating-point literals can be decimal or scientific notation.
- They are `double` by default unless suffixed with `f`/`F` (float).
- Examples:
    - `double d = 8.31;`
    - `double e = 3.00e+8;`
    - `float f = 8.31F;`
    - `float g = 3.00e+8F;`
    - `float pi = 3.1415_9265F;`

## Character literals

- Characters can be written as single-quoted characters or escaped sequences:
    - `char a = 'a';`
    - `char newline = '\\n';`
    - `char smiley = '\\u263a';`
- You’ll often use `String`, but `char` is still useful for tasks like processing keyboard input one character at a time.