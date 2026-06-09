
<div align="center">

# 🛠️ Tools of the Trade – Java Development Kit

### ⚙️ *Compile, Run, Package, and Experiment – Bilingual Guide*

[![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)](https://java.com)
[![JDK](https://img.shields.io/badge/JDK-21_ea-blue?style=for-the-badge&logo=java)](https://jdk.java.net/21/)
[![jshell](https://img.shields.io/badge/REPL-jshell-important?style=for-the-badge&logo=java)](https://docs.oracle.com/javase/9/jshell/introduction-jshell.htm)

</div>

---

## 📚 Table of Contents

| Section | Description |
|---------|-------------|
| [Why Command‑Line Tools?](#-why-commandline-tools) | Beyond the IDE |
| [JDK Environment Setup](#-jdk-environment-setup) | `JAVA_HOME` and `PATH` |
| [The Java VM](#-the-java-vm) | What the virtual machine does |
| [Running Java Applications](#-running-java-applications) | `java` command, `main()` method |
| [System Properties](#-system-properties) | `-D` flags for configuration |
| [The Classpath](#-the-classpath) | How Java finds classes |
| [Modules](#-modules) | Brief note on Java 9+ modularity |
| [The Java Compiler](#-the-java-compiler) | `javac` usage and intelligence |
| [Trying Java with `jshell`](#-trying-java-with-jshell) | Interactive REPL examples |
| [JAR Files](#-jar-files) | Packaging, `jar` utility, manifests |
| [Review & Exercises](#-review--exercises) | Questions and code challenges |

---

## 🤔 Why Command‑Line Tools?

> While you will almost certainly do most Java development in an IDE (VS Code, IntelliJ IDEA), all core tools are in the JDK.

| English | العربية |
|---------|---------|
| Command‑line tools are essential when IDEs are impractical (e.g., remote servers, DevOps work). | أدوات سطر الأوامر ضرورية عندما تكون IDEs غير عملية (مثل الخوادم البعيدة، أعمال DevOps). |

**Core tools:**

| Tool | Purpose |
|------|---------|
| `javac` | Compiles `.java` → `.class` bytecode |
| `java` | Executes bytecode |
| `jar` | Packages classes into archives |
| `jshell` | Interactive REPL (Read‑Eval‑Print‑Loop) |

> 💡 Even if you use an IDE, understanding these tools gives you deeper control.

---

## 🖥️ JDK Environment Setup

After installation, the `java` command may not be in your `PATH`. You need to set `JAVA_HOME` and update `PATH`.

### Linux / macOS (bash/zsh)

```bash
export JAVA_HOME=/usr/lib/jvm/jdk-21-ea14          # adjust path
export PATH=$PATH:$JAVA_HOME/bin
```

### Windows (Command Prompt)

```cmd
set JAVA_HOME=c:\Program Files\Java\jdk21
set PATH=%PATH%;%JAVA_HOME%\bin
```

> ℹ️ On macOS, recent versions have “stubs” that prompt you to download Java if missing.

### Verify installation

```bash
java -version
javac -version
```

Example output:

```
openjdk version "21-ea" 2023-09-19
OpenJDK Runtime Environment (build 21-ea+14-1161)
OpenJDK 64-Bit Server VM (build 21-ea+14-1161, mixed mode, sharing)
javac 21-ea
```

> `ea` means “early access” – fine for learning.

---

## 🧠 The Java VM

> A **Java Virtual Machine (VM)** implements the Java runtime system and executes applications.

| English | العربية |
|---------|---------|
| The VM loads class files, verifies bytecode, manages memory, and performs dynamic optimization (JIT compilation). | الآلة الافتراضية تحمّل ملفات class، تتحقق من البايتكود، تدير الذاكرة، وتقوم بالتحسين الديناميكي (ترجمة JIT). |

---

## 🚀 Running Java Applications

A standalone Java application must have a class containing a `public static void main(String[] args)` method.

### Basic syntax

```bash
java [interpreter options] class_name [program arguments]
```

**Examples:**

```bash
cd ch03/examples
java animals.birds.BigBird
java MyTest
```

> ⚠️ Do **not** include the `.class` extension.

### Running an executable JAR

```bash
java -jar spaceblaster.jar
```

The JAR’s manifest specifies the main class.

### The `main()` method signature

```java
public static void main(String[] myArgs)
```

- `public` – accessible from anywhere
- `static` – belongs to the class, no instance needed
- `void` – returns nothing
- `String[]` – command‑line arguments

Access arguments:

```java
int numArgs = myArgs.length;
String firstArg = myArgs[0];
```

The interpreter runs until `main()` returns **and** all non‑daemon threads finish.

---

## 🎛️ System Properties

> Pass configuration with `-Dname=value` flags. Inside the program, use `System.getProperty()`.

```bash
java -Dstreet=sesame -Dscene=alley animals.birds.BigBird
```

```java
String street = System.getProperty("street");
```

| English | العربية |
|---------|---------|
| More portable than environment variables. | أكثر قابلية للحمل من متغيرات البيئة. |

---

## 📂 The Classpath

The **classpath** tells Java where to look for classes and packages. It can contain directories and JAR files.

### Setting the classpath

**Unix / macOS (colon‑separated)**

```bash
export CLASSPATH=/home/vicky/Java/classes:/home/josh/lib/foo.jar:.
```

**Windows (semicolon‑separated)**

```cmd
set CLASSPATH=C:\home\vicky\Java\classes;C:\home\josh\lib\foo.jar;.
```

- `.` (dot) = current directory
- Wildcard `*` includes all JARs in a directory: `/home/sarah/libs/*`

### Using `-classpath` option

```bash
javac -classpath /home/pat/classes:/utils/utils.jar:. Foo.java
```

> ⚠️ If you don’t set `CLASSPATH`, it defaults to the current directory (`.`). If you change it and forget to include `.`, your current directory classes will not be found.

### How searching works

For class `animals.birds.BigBird`, Java looks for:
- In directory `/usr/lib/java` → `/usr/lib/java/animals/birds/BigBird.class`
- In JAR `/home/sarah/zoo.jar` → entry `animals/birds/BigBird.class`

| English | العربية |
|---------|---------|
| Classpath problems are the #1 hurdle for beginners. | مشاكل Classpath هي العائق الأول للمبتدئين. |

---

## 📦 Modules (Java 9+)

Java 9 introduced **modules** for fine‑grained deployment. Modules are optional; you can still use the classic classpath. This book does not cover modules in depth. For more, see *Java 9 Modularity* by Bakker & Mak (O’Reilly).

---

## 🔨 The Java Compiler (`javac`)

`javac` turns `.java` source files into `.class` bytecode files.

### Basic usage

```bash
javac animals/birds/Bluebird.java
```

- Requires filename (with `.java` extension)
- One public class per file, filename must match public class name
- Multiple classes allowed in one file (only one public)

### `-d` option (output directory)

```bash
javac -d /home/vicky/Java/classes Bluebird.java
```

Creates class files in the appropriate package subdirectory.

### Intelligent compilation

`javac` compares timestamps of source and class files and recompiles as needed. It can also compile against binary class files (no source required).

> 💡 For real projects, use build tools like **Gradle** or **Maven**.

---

## 🧪 Trying Java with `jshell`

`jshell` is the Java REPL (Read‑Eval‑Print‑Loop), introduced in Java 9. Great for experimenting.

### Start jshell

```bash
jshell
```

### Example – creating a JFrame

```java
jshell> import javax.swing.*
jshell> JFrame frame = new JFrame("HelloJava2")
frame ==> javax.swing.JFrame[frame0,0,23,0x0,invalid,hidden...]

jshell> frame.setSize(300,200)
jshell> frame.setLocation(400,400)
jshell> frame.setVisible(true)
```

You’ll see a window pop up!

### Adding a label

```java
jshell> JLabel label = new JLabel("Hi jshell!")
jshell> frame.add(label)
jshell> frame.revalidate()   // refresh layout
jshell> frame.repaint()      // force redraw
```

### Fixing a typo (case‑sensitive)

```java
jshell> frame.setsize(300,100)
|  Error: cannot find symbol method setsize(int,int)
jshell> frame.setSize(300,100)   // correct
```

### Removing components

```java
jshell> frame.remove(label)
jshell> frame.setSize(400,150)   // repaint happens automatically
```

> 🎯 **Why jshell?** Instant feedback – no compile‑run cycle. Perfect for learning APIs.

---

## 🗃️ JAR Files (Java Archive)

JAR files are compressed (ZIP) bundles that can contain class files, images, data, and a **manifest**.

### The `jar` utility

| Command | Meaning |
|---------|---------|
| `jar -cvf jarFile path ...` | Create archive (c=create, v=verbose, f=file) |
| `jar -tvf jarFile` | List contents (t=table) |
| `jar -xvf jarFile` | Extract contents (x=extract) |

### Create a JAR

```bash
jar -cvf spaceblaster.jar spaceblaster/
```

Verbose output shows compression ratios.

### List contents

```bash
jar -tvf spaceblaster.jar
```

### Extract

```bash
jar -xvf spaceblaster.jar
jar -xvf spaceblaster.jar spaceblaster/docs/help2.html   # single file
```

### The `META-INF/MANIFEST.MF` file

Automatically added. Example:

```
Manifest-Version: 1.0
Created-By: 21-ea (Oracle Corporation)
```

### Adding custom manifest entries

Create a file `myManifest.mf`:

```
Name: spaceblaster/images/planetoid.gif
RevisionNumber: 42.7
Artist-Temperament: moody
```

Then:

```bash
jar -cvmf myManifest.mf spaceblaster.jar spaceblaster
```

> ⚠️ Order matters: `m` before `f` means manifest filename comes before JAR filename.

### Making a JAR executable

Add this line to `MANIFEST.MF`:

```
Main-Class: spaceblaster.game.Game
```

Then run:

```bash
java -jar spaceblaster.jar
```

> ℹ️ Most OS file browsers no longer support double‑clicking JARs; use a wrapper script (`.bat` / `.sh`) for desktop apps.

---

## 📝 Review Questions

1. What statement gives you access to the Swing components in your application?  
   *Answer:* `import javax.swing.*;`

2. What environment variable determines where Java looks for class files when compiling or executing?  
   *Answer:* `CLASSPATH`

3. What options do you use to look at the contents of a JAR file without unpacking it?  
   *Answer:* `jar -tvf jarfile.jar`

4. What entry is required in the `MANIFEST.MF` file to make a JAR file executable?  
   *Answer:* `Main-Class: fully.qualified.ClassName`

5. What tool allows you to try out Java code in an interactive fashion?  
   *Answer:* `jshell`

---

## 🧩 Code Exercises

### Basic Exercise

Run the interactive review application:

```bash
cd quiz
java -jar lj6review.jar
```

Answer multiple‑choice questions from all chapters.

### Advanced Exercise

Create an executable JAR from `HelloJar.java`:

1. Compile: `javac HelloJar.java` (produces two class files)
2. Create `manifest.mf` with: `Main-Class: HelloJar`
3. Package: `jar -cvmf manifest.mf hello.jar *.class`
4. Run: `java -jar hello.jar`

A graphical greeting should appear. If you run without a JAR, the manifest reading code will not work.

---

<div align="center">

---

**🎉 You now know the essential Java development tools – from `javac` to `jshell` to `jar`!**  
**🎉 أصبحت الآن تعرف أدوات تطوير جافا الأساسية – من `javac` إلى `jshell` إلى `jar`!**

</div>
```