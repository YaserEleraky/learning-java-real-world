Here is the **complete Markdown file** containing the original English text (unchanged) plus **Arabic explanations** added alongside each key point. The code blocks and arrow notes remain exactly as you provided.

---

# 📘 Java Statements & Expressions – مرجع ثنائي اللغة (عربي/إنجليزي)

> **English:** This document is a line‑by‑line annotated reference to the original textbook content about Java statements and expressions.  
> **العربية:** هذا المستند هو شرح سطر بسطر للنص الأصلي عن العبارات والتعابير في جافا، مع إضافة تفسيرات بالعربية إلى جانب الملاحظات الإنجليزية.

---

## Statements and Expressions

**→** This section introduces two core concepts: *statements* (actions) and *expressions* (values).  
**→ العربية:** يقدم هذا القسم مفهومين أساسيين: **العبارات** (أفعال) و **التعابير** (قيم).

Java statements appear inside methods and classes. They describe all activities of a Java program.  
**→** Statements are like **verbs** – they *do* things. They live inside methods (functions) or classes.  
**→ العربية:** العبارات تشبه **الأفعال** – تقوم بأعمال. توجد داخل الدوال (methods) أو الكلاسات (classes).

Variable declarations and assignments, such as those in the previous section, are statements, as are basic language structures such as if/then conditionals and loops. (More on these structures later in this chapter.)  
**→** Examples of statements: `int x = 5;` (declaration + assignment), `if (x > 0) ...`, `for(...){...}`.  
**→ العربية:** أمثلة على العبارات: تعريف متغير، جملة شرطية `if`، حلقات تكرار `for`.

Here are a few statements in Java:

```java
int size = 5;                        // → declaration statement
if (size > 10)                       // → conditional statement
  doSomething();                     // → method call statement
for (int x = 0; x < size; x++) {     // → loop statement (block)
  doSomethingElse();                 // → inside the loop
  doMoreThings();                    // → also inside the loop
}
```

Expressions produce values; Java evaluates an expression to produce a result.  
**→** An **expression** is like a question: `2 + 2` evaluates to `4`. A statement might use that expression.  
**→ العربية:** **التعبير** (expression) يشبه سؤالاً: `2 + 2` يُقيّم إلى `4`. العبارة قد تستخدم ذلك التعبير.

That result can then be used as part of another expression or in a statement.  
**→** Example: `int sum = 2 + 2;` – the expression `2 + 2` produces `4`, then the statement assigns it to `sum`.  
**→ العربية:** مثال: `int sum = 2 + 2;` – التعبير `2 + 2` يُنتج `4`، ثم العبارة تخزنه في `sum`.

Method calls, object allocations, and, of course, mathematical expressions are examples of expressions:

```java
// These are all valid Java expressions
new Object()                       // → creates a new object, yields a reference
Math.sin(3.1415)                   // → method call, returns a double
42 * 64                            // → arithmetic expression, returns an int
```

**→** Even a lone literal like `5` or `"hello"` is an expression.  
**→ العربية:** حتى القيم الثابتة مثل `5` أو `"hello"` تعتبر تعابير.

One of the tenets of Java is to keep things simple and consistent. To that end, when there are no other constraints, evaluations and initializations in Java always occur in the order in which they appear in the code—from left to right, top to bottom.  
**→** This is called **left-to-right evaluation**. Java guarantees that `a() + b()` calls `a()` first, then `b()`.  
**→ العربية:** هذا يسمى **تقييم من اليسار إلى اليمين**. جافا تضمن أن `a() + b()` تنفذ `a()` أولاً ثم `b()`.

You’ll see this rule used in the evaluation of assignment expressions, method calls, and array indexes, to name a few cases.  
**→** Example: `int x = (y = 3) + (z = 5);` – `y = 3` happens before `z = 5`.  
**→ العربية:** مثال: في `int x = (y = 3) + (z = 5);` فإن `y = 3` تحدث قبل `z = 5`.

In some other languages, the order of evaluation is more complicated or even implementation dependent. Java removes this element of danger by precisely and simply defining how the code is evaluated.  
**→** In C++, for instance, `i = i++` is undefined. Java avoids such pitfalls.  
**→ العربية:** في لغة سي بلس بلس، `i = i++` سلوكها غير معرف. جافا تمنع هذه المشاكل.

This doesn’t mean you should start writing obscure and convoluted statements, however. Relying on the order of evaluation of expressions in complex ways is a bad programming habit, even when it works. It produces code that is hard to read and harder to modify.  
**→** **Best practice:** Keep expressions simple. Don’t rely on subtle order-of-evaluation tricks.  
**→ العربية:** **أفضل ممارسة:** اجعل التعابير بسيطة. لا تعتمد على حيل ترتيب التقييم الدقيقة.

---

## Statements

In any program, statements perform the real magic. Statements help us implement those algorithms we mentioned at the beginning of this chapter. In fact, they don’t just help, they are precisely the programming ingredient we use; each step in an algorithm will correspond to one or more statements.  
**→** An algorithm is a step‑by‑step recipe. Each step becomes one or more Java statements.  
**→ العربية:** الخوارزمية هي وصفة خطوة بخطوة. كل خطوة تصبح عبارة أو أكثر في جافا.

Statements generally do one of four things:

- Gather input to assign to a variable
- Write output (to your terminal, to a JLabel, etc.)
- Make a decision about which statements to execute
- Repeat one or more other statements

**→** These correspond to **input**, **output**, **selection** (if/switch), and **iteration** (loops).  
**→ العربية:** هذه تقابل **الإدخال**، **الإخراج**، **الاختيار** (if/switch)، و **التكرار** (الحلقات).

Statements and expressions in Java appear within a code block. A code block contains a series of statements surrounded by an open curly brace (`{`) and a close curly brace (`}`).  
**→** Blocks group statements. They define **scope** (where variables live).  
**→ العربية:** الكتل (blocks) تجمع العبارات. وهي تحدد **النطاق** (أين تعيش المتغيرات).

The statements in a code block can include variable declarations and most of the other sorts of statements and expressions we mentioned earlier:

```java
{
  int size = 5;          // → declaration statement
  setName("Max");        // → method call statement
  // more statements could follow...
}
```

In a sense, methods are just code blocks that take parameters and can be called by their names—for example, a hypothetical method `setUpDog()` might start out like this:

```java
setUpDog(String name) {          // → method signature (code block starts)
  int size = 5;                  // → local variable
  setName(name);                 // → call to another method
  // do any other setup work ...
}
```

Variable declarations are scoped in Java. They are limited to their enclosing code block—that is, you cannot see or use a variable outside of the nearest set of braces:

```java
{
  // Scopes are like Vegas...
  // What's declared in a scope, stays in that scope
  int i = 5;
}
i = 6;  // Compile-time error, no such variable i
```

**→** This is called **block scope**. Variables declared inside `{}` vanish after the block ends.  
**→ العربية:** هذا يسمى **النطاق القُطري** (block scope). المتغيرات المعرف داخل `{}` تختفي بعد انتهاء الكتلة.

In this way, you can use code blocks to arbitrarily group statements and variables. The most common use of code blocks, however, is to define a group of statements for use in a conditional or iterative statement.

---

## if/else conditionals

One of the key concepts in programming is the notion of making a decision. “If this file exists” or “If the user has a WiFi connection” are examples of the decisions computer programs and apps make all the time.  
**→** Decision making = **control flow**. The `if` statement is the simplest form.  
**→ العربية:** اتخاذ القرار = **تدفق التحكم** (control flow). جملة `if` هي أبسط صورة.

Java uses the popular `if/else` statement for many of these types of decisions. Java defines an `if/else` clause as follows:

```
if (condition)
    statement1;
else
    statement2;
```

**→** The `condition` must be a boolean expression (true or false). No parentheses around the condition? Error.  
**→ العربية:** الشرط (`condition`) يجب أن يكون تعبيراً منطقياً (صحيح أو خطأ). إذا نسيت الأقواس يحدث خطأ.

In English, you could read that `if/else` statement as “if the condition is true, perform statement1. Otherwise, perform statement2.”

The condition is a Boolean expression and must be enclosed in parentheses. A Boolean expression, in turn, is either a Boolean value (`true` or `false`) or an expression that evaluates to one of those values.  
**→** Example boolean expressions: `x > 0`, `isReady == true`, `!done`.  
**→ العربية:** أمثلة لتعبيرات منطقية: `x > 0`, `isReady == true`, `!done`.

For example, `i == 0` is a Boolean expression that tests whether the integer `i` holds the value `0`:

```java
// filename: ch04/examples/IfDemo.java
int i = 0;
// you can use i now to do other work and then
// we can test it to see if anything has changed
if (i == 0)
  System.out.println("i is still zero");
else
  System.out.println("i is most definitely not zero");
```

**→** `==` is equality comparison (different from `=` assignment). `System.out.println` prints to console.  
**→ العربية:** `==` للمقارنة (يساوي؟) بينما `=` للتخصيص (يساوي يصبح). `System.out.println` تطبع على الشاشة.

The whole of the preceding example is itself a statement and could be nested within another `if/else` clause.  
**→** Nesting: `if (a) if (b) ... else ...` – the `else` belongs to the nearest `if` (unless braces are used).  
**→ العربية:** التداخل: `else` ينتمي لأقرب `if` ما لم تُستخدم الأقواس لتغيير ذلك.

The `if` clause has the common functionality of taking two different forms: a “one-liner” or a block. We’ll see this same pattern with other statements like the loops discussed in the next section.

If you only have one statement to execute (like the simple `println()` calls in the previous snippet), you can place that lone statement after the `if` test or after the `else` keyword. If you need to execute more than one statement, you use a block.

The block form looks like this:

```java
if (condition) {
  // condition was true, execute this block
  statement;
  statement;
  // and so on...
} else {
  // condition was false, execute this block
  statement;
  statement;
  // and so on...
}
```

**→** Always using braces `{ }` is a good habit – it avoids bugs when adding more statements later.  
**→ العربية:** استخدام الأقواس `{ }` دائماً عادة جيدة – تمنع الأخطاء عند إضافة عبارات لاحقاً.

Here, all the enclosed statements in the block are executed for whichever branch is taken. We can use this form when we need to do more than just print a message.

For example, we could guarantee that another variable, perhaps `j`, is not negative:

```java
// filename: ch04/examples/IfDemo.java
int j = 0;
// you can use j now to do work like i before,
// then make sure that work didn't drop
// j's value below zero
if (j < 0) {
  System.out.println("j is less than 0! Resetting.");
  j = 0;                       // → fix the negative value
} else {
  System.out.println("j is positive or 0. Continuing.");
}
```

Notice that we used curly braces for the `if` clause, with two statements, and for the `else` clause, which still has a single `println()` call. You can always use a block if you want. But if you only have one statement, the block with its braces is optional.  
**→** Style note: many Java style guides (e.g., Google) require braces even for single statements.  
**→ العربية:** ملاحظة أسلوبية: أدلة أسلوب جافا (مثل Google) تطلب الأقواس حتى للعبارة الواحدة.

---

## switch statements

Many languages support a “one of many” conditional commonly known as a `switch` or `case` statement.  
**→** `switch` is like a multi-way `if` – useful when one variable can match many constant values.  
**→ العربية:** `switch` يشبه `if` متعدد المسارات – مفيد عندما متغير واحد يمكن أن يطابق عدة قيم ثابتة.

Given one variable or expression, a `switch` statement provides multiple options that might match. And we do mean *might*. A value does not have to match any of the `switch` options; in that case nothing happens. If the expression does match a `case`, that branch is executed. If more than one case would match, the first match wins.

The most common form of the Java `switch` statement takes an integer (or a numeric type argument that can be automatically promoted to an integer type) or a string, and selects among a number of alternative, constant case branches:

```java
switch (expression) {
  case constantExpression1 :
    statement1;
    // optional break;
  case constantExpression2 :
    statement2;
    // optional break;
  // ...
  default :
    statementDefault;
}
```

**→** `case` values must be compile-time constants. Strings are allowed since Java 7.  
**→ العربية:** قيم `case` يجب أن تكون ثوابت وقت الترجمة (compile-time constants). السلاسل النصية مسموحة منذ Java 7.

The case expression for each branch must evaluate to a different constant integer or string value at compile time. Strings are compared using the `String equals()` method.

You can specify an optional `default` case to catch unmatched conditions.

When executed, the `switch` simply finds the branch matching its conditional expression (or the `default` branch) and executes the corresponding statement. But that’s not the end of the story.

Perhaps counterintuitively, the `switch` statement then **continues executing branches after the matched branch** until it hits the end of the `switch` or a special statement called `break`.  
**→** This is called **fall‑through**. It’s a feature, but often a bug if you forget the `break`.  
**→ العربية:** هذا يسمى **الانهيار** (fall‑through). هو ميزة، لكن غالباً ما يكون خطأ إذا نسيت `break`.

Here are a couple of examples:

```java
// filename: ch04/examples/SwitchDemo.java
int value = 2;
switch(value) {
  case 1:
    System.out.println(1);   // → no break, so fall-through happens
  case 2:
    System.out.println(2);   // → prints 2
  case 3:
    System.out.println(3);   // → then prints 3
}
// prints both 2 and 3
```

Using `break` to terminate each branch is more common:

```java
// filename: ch04/examples/SwitchDemo.java
int value = GOOD;
switch (value) {
  case GOOD:
    // something good
    System.out.println("Good");
    break;                     // → exit switch here
  case BAD:
    System.out.println("Bad");
    break;
  default:
    System.out.println("Not sure");
    break;
}
// prints only "Good"
```

The “keep going” behavior of `switch` is justified when you want to cover several possible case values with the same statement(s) without resorting to duplicating a bunch of code:

```java
// filename: ch04/examples/SwitchDemo.java
int value = MINISCULE;
String size = "Unknown";
switch(value) {
  case MINISCULE:
  case TEENYWEENY:
  case SMALL:
    size = "Small";
    break;
  case MEDIUM:
    size = "Medium";
    break;
  case LARGE:
  case EXTRALARGE:
    size = "Large";
    break;
}
System.out.println("Your size is: " + size);
```

**→** This is the classic use of fall‑through: multiple `case` labels share the same code.  
**→ العربية:** هذا هو الاستخدام الكلاسيكي للانهيار: عدة تسميات `case` تشترك في نفس الكود.

This grouping feature can now appear directly in expressions. Java 12 offered `switch` expressions as a preview feature that was honed and made permanent with Java 14.  
**→** `switch` can now be used as an *expression* that returns a value, not just a statement.  
**→ العربية:** `switch` يمكن الآن استخدامه **كتعبير** يُعيد قيمة، ليس فقط كعبارة.

For example, rather than printing out the size names in the example above, we could assign our size label directly to a variable:

```java
// filename: ch04/examples/SwitchDemo.java
int value = EXTRALARGE;
String size = switch(value) {
  case MINISCULE, TEENYWEENY, SMALL -> "Small";   // → arrow syntax, no break
  case MEDIUM -> "Medium";
  case LARGE, EXTRALARGE -> "Large";
  default -> "Unknown";
};  // note the semicolon! It completes the switch statement
System.out.println("Your size is: " + size);
// prints "Your size is Large"
```

**→** The `->` arrow means "then return this value". No fall‑through. No need for `break`.  
**→ العربية:** السهم `->` يعني "ثم أعد هذه القيمة". لا انهيار، ولا حاجة لـ `break`.

Note the new “arrow” (a hyphen followed by the greater-than symbol) syntax. You still use separate `case` entries, but with this expression syntax, the case values are given in one comma-separated list rather than as separate, cascading entries. You then use `->` between the list and the value to return. This form can make the `switch` expression a little more compact and (hopefully) more readable.

---

## do/while loops

The other major concept in controlling which statement gets executed next (control flow or flow of control in programmerese) is repetition. Computers are really good at doing things over and over. Repeating a block of code is done with a loop. There are a number of different loop statements in Java. Each type of loop has advantages and disadvantages. Let’s look at these different types now.

The `do` and `while` iterative statements run as long as a Boolean expression (often referred to as the loop’s condition) returns a `true` value. The basic structure of these loops is straightforward:

```
while (condition)
    statement; // or block

do
    statement; // or block
while (condition);
```

**→** In `while`, condition is tested **before** the first execution. In `do-while`, tested **after** (so body runs at least once).  
**→ العربية:** في `while` يتم اختبار الشرط **قبل** التنفيذ الأول. في `do-while` يُختبر **بعد** (لذا يُنفذ الجسم مرة واحدة على الأقل).

A `while` loop is perfect for waiting on some external condition, such as getting new email:

```java
while(mailQueue.isEmpty())
    wait();
```

Of course, this hypothetical `wait()` method needs to have a limit (typically a time limit such as waiting for one second) so that it finishes and gives the loop another chance to run. But once you do have some email, you also want to process all of the messages that arrived, not just one. Again, a `while` loop is perfect.

You can use a block of statements inside curly braces if you need to execute more than one statement in your loop. Consider a simple countdown printer:

```java
// filename: ch04/examples/WhileDemo.java
int count = 10;
while(count > 0) {
  System.out.println("Counting down: " + count);
  // maybe do other useful things
  // and decrement our count
  count = count - 1;        // → without this, infinite loop!
}
System.out.println("Done");
```

**→** The loop variable `count` must eventually make the condition `false` to stop.  
**→ العربية:** متغير الحلقة `count` يجب أن يجعل الشرط `false` في النهاية ليتوقف.

In this example, we use the `>` comparison operator to monitor our `count` variable. We want to keep working while the countdown is positive. Inside the body of the loop, we print out the current value of `count` and then reduce it by one before repeating. When we eventually reduce `count` to 0, the loop will halt because the comparison returns `false`.

Unlike `while` loops which test their conditions first, a `do-while` loop (or more often just a `do` loop) always executes its statement body at least once.  
**→** Use `do-while` when you need to guarantee one iteration (e.g., user input validation).  
**→ العربية:** استخدم `do-while` عندما تحتاج ضمان تكرار واحد على الأقل (مثل التحقق من إدخال المستخدم).

A classic example is validating input from a user. You know you need to get some information, so you request that information in the body of the loop. The loop’s condition can test for errors. If there’s a problem, the loop will start over and request the information again. That process can repeat until your request comes back without errors and you know you have good information.

```java
do {
  System.out.println("Please enter a valid email: ");
  String email = askUserForEmail();
} while (email.hasErrors());     // → condition checked after the body
```

Again, the body of a `do` loop executes at least once. If the user gives us a valid email address the first time, we just don’t repeat the loop.

---

## The for loop

Another popular loop statement is the `for` loop. It excels at counting. The most general form of the `for` loop is also a holdover from the C language. It can look a little messy, but it compactly represents quite a bit of logic:

```
for (initialization; condition; incrementor)
    statement; // or block
```

**→** Three parts: 1) init (once), 2) condition (test before each iteration), 3) increment (after each iteration).  
**→ العربية:** ثلاثة أجزاء: 1) التهيئة (مرة واحدة)، 2) الشرط (يُختبر قبل كل تكرار)، 3) الزيادة (بعد كل تكرار).

The variable initialization section can declare or initialize variables that are limited to the scope of the `for` body.

The `for` loop then begins a possible series of rounds in which the condition is first checked and, if true, the body statement (or block) is executed. Following each execution of the body, the incrementor expressions are evaluated to give them a chance to update variables before the next round begins.

Consider a classic counting loop:

```java
// filename: ch04/examples/ForDemo.java
for (int i = 0; i < 100; i++) {
  System.out.println(i);
  int j = i;
  // do any other work needed
}
```

**→** This prints 0 through 99. `i++` is shorthand for `i = i + 1`.  
**→ العربية:** هذا يطبع من 0 إلى 99. `i++` هي اختصار لـ `i = i + 1`.

This loop will execute 100 times, printing values from 0 to 99. We declare and initialize a variable, `i`, to zero. We use the condition clause to see if `i` is less than 100. If it is, then Java executes the body of the loop. In the increment clause, we bump `i` up by one. (We’ll see more on the comparison operators like `<` and `>`, as well as the increment shortcut `++` in the next section, “Expressions” on page 114.) After `i` is incremented, the loop goes back to check the condition. Java keeps repeating these steps (condition, body, increment) until `i` reaches 100.

Remember that the variable `j` is local to the block (visible only to statements within it) and will not be accessible to the code after the `for` loop.

If the condition of a `for` loop returns `false` on the first check (for example, if we set `i` to 1,000 in the initialization clause), the body and incrementor section will never be executed.

You can use multiple comma-separated expressions in the initialization and incrementation sections of the `for` loop. For example:

```java
// filename: ch04/examples/ForDemo.java
// generate some coordinates
for (int x = 0, y = 10; x < y; x++, y--) {
  System.out.println(x + ", " + y);
  // do other stuff with our new (x, y)...
}
```

**→** This declares two variables `x` and `y`, increments `x` while decrementing `y` each iteration.  
**→ العربية:** هذا يعرف متغيرين `x` و `y`، يزيد `x` وينقص `y` كل تكرار.

You can also initialize existing variables from outside the scope of the `for` loop within the initializer block. You might do this if you wanted to use the end value of the loop variable elsewhere. This practice is generally frowned upon: it’s prone to mistakes and can make your code difficult to reason about. Nonetheless, it is legal and you may hit a situation where this behavior makes the most sense to you:

```java
int x;
for(x = 0; x < someHaltingValue; x++) {
  System.out.print(x + ": ");
  // do whatever work you need ...
}
// x is still valid and available
System.out.println("After the loop, x is: " + x);
```

**→** Here `x` was declared before the loop, so it remains accessible after.  
**→ العربية:** هنا `x` عُرف قبل الحلقة، لذا يبقى متاحاً بعدها.

In fact, you can leave out the initialization step completely if you want to work with a variable that already has a good starting value:

```java
int x = 1;
for(; x < someHaltingValue; x++) {
  System.out.print(x + ": ");
  // do whatever work you need ...
}
```

Note that you do still need the semicolon that normally separates the initialization step from the condition.

---

## The enhanced for loop

Java’s auspiciously dubbed “enhanced for loop” acts like the `foreach` statement in some other languages, iterating over a series of values in an array or other type of collection:

```
for (varDeclaration : iterable)
    statement_or_block;
```

**→** Read as “for each element in the collection”.  
**→ العربية:** تُقرأ “لكل عنصر في المجموعة”.

The enhanced `for` loop can be used to loop over arrays of any type as well as any kind of Java object that implements the `java.lang.Iterable` interface. (We’ll have more to say on arrays, classes, and interfaces in Chapter 5.) This includes most of the classes of the Java Collections API (see Chapter 7). Here are a couple of examples:

```java
// filename: ch04/examples/EnhancedForDemo.java
int [] arrayOfInts = new int [] { 1, 2, 3, 4 };
int total = 0;
for(int i : arrayOfInts) {
  System.out.println(i);
  total = total + i;
}
System.out.println("Total: " + total);

// ArrayList is a popular collection class
ArrayList<String> list = new ArrayList<String>();
list.add("foo");
list.add("bar");
for(String s : list)
  System.out.println(s);
```

**→** No index variable needed. Safer and more concise when you don’t need the index.  
**→ العربية:** لا حاجة لمتغير فهرس. أكثر أماناً وإيجازاً عندما لا تحتاج إلى الفهرس.

Again, we haven’t discussed arrays or the `ArrayList` class and its special syntax in this example. What we’re showing here is the syntax of the enhanced `for` loop iterating over both an array and a list of string values. The brevity of this form makes it popular whenever you need to work with a collection of items.

---

## break/continue

The Java `break` statement and its friend `continue` can also be used to cut a loop or conditional statement short by jumping out of it.

A `break` causes Java to stop the current loop (or `switch`) statement and skip the rest of the body. Java picks up executing the code that comes after the loop.

In the following example, the `while` loop goes on endlessly until the `watchForErrors()` method returns `true`, triggering a `break` statement that stops the loop and proceeds at the point marked “after the while loop”:

```java
while(true) {
  if (watchForErrors())
    break;        // → exit the loop immediately
  // No errors yet so do some work...
}
// The "break" will cause execution to
// resume here, after the while loop
```

A `continue` statement causes `for` and `while` loops to move on to their next iteration by returning to the point where they check their condition.

The following example prints the numbers 0 through 9, skipping the number 5:

```java
// filename: ch04/examples/ForDemo.java
for (int i = 0; i < 10; i++) {
  if (i == 5)
    continue;      // → skip the rest of the body, go to i++
  System.out.println(i);
}
```

**→** `continue` jumps to the next iteration. For `for` loops, it goes to the increment step.  
**→ العربية:** `continue` يقفز إلى التكرار التالي. في حلقات `for` يذهب إلى خطوة الزيادة.

The `break` and `continue` statements look like those in the C language, but Java’s forms have the additional ability to take a **label** as an argument and jump out multiple levels to the scope of the labeled point in the code. This usage is not very common in day-to-day Java coding but may be important in special cases. Here is what that looks like:

```java
labelOne:
while (condition1) {
  // ...
  labelTwo:
  while (condition2) {
    // ...
    if (smallProblem)
      break;                 // → breaks out of just labelTwo loop
    if (bigProblem)
      break labelOne;        // → breaks out of both loops, goes after labelOne
  }
  // after labelTwo
}
// after labelOne
```

**→** Labeled breaks allow exiting nested loops cleanly without messy flags.  
**→ العربية:** `break` المُسمّى يسمح بالخروج من حلقات متداخلة بطريقة نظيفة بدون متغيرات مساعدة.

Enclosing statements, such as code blocks, conditionals, and loops, can be labeled with identifiers like `labelOne` and `labelTwo`. In this example, a `break` or `continue` without an argument has the same effect as the earlier examples. A `break` causes processing to resume at the point labeled “after labelTwo“; a `continue` immediately causes the `labelTwo` loop to return to its condition test.

We could use the statement `break labelTwo` in the `smallProblem` statement. It would have the same effect as an ordinary `break`, but `break labelOne`, as seen with the `bigProblem` statement, breaks out of both levels and resumes at the point labeled “after labelOne.” Similarly, `continue labelTwo` would serve as a normal `continue`, but `continue labelOne` would return to the test of the `labelOne` loop.

Multilevel `break` and `continue` statements remove the main justification for the much maligned `goto` statement in C/C++.

There are a few Java statements we aren’t going to discuss right now. The `try`, `catch`, and `finally` statements are used in exception handling, as we’ll discuss in Chapter 6. The `synchronized` statement in Java is used to coordinate access to statements among multiple threads of execution; see Chapter 9 for a discussion of thread synchronization.

---

## Unreachable statements

On a final note, we should mention that the Java compiler flags **unreachable statements** as compile-time errors.  
**→** Unreachable code is code that can never be executed, e.g., after a `return` or an always-false condition.  
**→ العربية:** الكود غير المُتاح هو كود لا يمكن تنفيذه أبداً، مثلاً بعد `return` أو شرط دائم الخطأ.

An unreachable statement is one that the compiler determines will never be called. Of course, many methods or bits of code may never actually be called in your program, but the compiler detects only those that it can “prove” are never called with some clever checking at compile time.

For example, a method with an unconditional `return` statement in the middle of it causes a compile-time error, as does a method with a conditional that the compiler can tell will never be fulfilled:

```java
if (1 < 2) {
  // This branch always runs and the compiler knows it
  System.out.println("1 is, in fact, less than 2");
  return;                     // → method ends here
} else {
  // unreachable statements, this branch never runs
  System.out.println("Look at that, seems we got \"math\" wrong.");
}
```

**→** The `else` block will never run because `1 < 2` is always true. Compiler error.  
**→ العربية:** كتلة `else` لن تُنفذ أبداً لأن `1 < 2` دائماً صحيح. خطأ من المُترجم.

You have to correct the unreachable errors before you can complete the compilation. Fortunately, most instances of this error are just typos that are easily fixed. On the rare occasion that this compiler check uncovers a fault in your logic and not your syntax, you can always rearrange or delete the code that cannot be executed.

---

## Expressions

An expression produces a result, or value, when it is evaluated. The value of an expression can be a numeric type, as in an arithmetic expression; a reference type, as in an object allocation; or the special type, `void`, which is the declared type of a method that doesn’t return a value.  
**→** `void` expressions are used only for side effects (e.g., `System.out.println` returns `void`).  
**→ العربية:** تعابير `void` تُستخدم فقط للتأثيرات الجانبية (مثل `System.out.println` الذي يُعيد `void`).

In the last case, the expression is evaluated only for its side effects; that is, the work it does aside from producing a value.

The compiler knows the type of an expression. The value produced at runtime will either have this type or, in the case of a reference type, a compatible (assignable) subtype. (More on that compatibility in Chapter 5.)

We’ve seen several expressions already in our example programs and code snippets. We’ll also see many more examples of expressions in the section “Assignment” on page 116.

**→** The book continues with operator precedence, assignments, and more – but this is where the provided excerpt ends.  
**→ العربية:** الكتاب يستكمل بأسبقية المعاملات والتخصيص وغيرها – لكن هذا هو نهاية المقتطف المُقدّم.

---

> **End of annotated document.**  
> **نهاية المستند المُعلّق.**

I hope this **line‑by‑line annotated reference** (with Arabic) helps you study Java statements and expressions.  
أتمنى أن يساعدك هذا المرجع (مع العربية) في دراسة عبارات وتعابير جافا.
```

---

You can save this content as a `.md` file (e.g., `Java_Statements_Expressions_AR_EN.md`) and open it with any Markdown viewer. The original English text and arrow notes are preserved exactly as you wrote them, and each major point now has an Arabic counterpart.