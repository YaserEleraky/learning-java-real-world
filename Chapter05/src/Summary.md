Below is a **comprehensive ASCII diagram** that visually organizes all the key concepts from both `Classes.md` and `AdvancedClasses.md`. It uses a graph‑like structure, grouping related topics, showing relationships, and including brief notes to ensure no data is missing. You can paste this into any Markdown viewer.

```text
┌─────────────────────────────────────────────────────────────────────────────────────────────────────────────┐
│                                         🧬 OBJECTS IN JAVA (Chapter 5)                                       │
│                                         ============================                                         │
└─────────────────────────────────────────────────────────────────────────────────────────────────────────────┘
                                                    │
        ┌───────────────────────────────────────────┼───────────────────────────────────────────┐
        │                                           │                                           │
        ▼                                           ▼                                           ▼
┌───────────────────┐                    ┌───────────────────┐                    ┌───────────────────┐
│  CLASSES & OBJECTS│                    │  ADVANCED FEATURES│                    │   UTILITIES &    │
│  (blueprints)     │                    │  (inheritance,     │                    │   TOOLS          │
│                   │                    │   polymorphism)    │                    │   (wrappers, GC)  │
└─────────┬─────────┘                    └─────────┬─────────┘                    └─────────┬─────────┘
          │                                          │                                          │
          ▼                                          ▼                                          ▼
┌─────────────────────────────────────────────────────────────────────────────────────────────────────────────┐
│ 🧩 CLASS DECLARATION & INSTANTIATION                                                                            │
│ ┌─────────────────────────┐    ┌─────────────────────────┐    ┌─────────────────────────┐                     │
│ │ class Apple {           │    │ Apple a1;               │    │ a1 = new Apple();       │                     │
│ │   float mass;           │    │ // declaration          │    │ // instantiation        │                     │
│ │ }                       │    │                         │    │                         │                     │
│ └─────────────────────────┘    └─────────────────────────┘    └─────────────────────────┘                     │
│                                                                                                               │
│ 🔹 Instance variables: belong to each object  🔹 Static variables: shared by all instances (static float g)   │
│ 🔹 Methods: behavior (void printDetails())    🔹 Constructors: same name as class, no return type            │
│ 🔹 `this`: current object reference           🔹 Default constructor provided if none defined                │
│ 🔹 Method overloading: same name, different params                                                           │
│ 🔹 Local variables: must be initialized before use                                                           │
│ 🔹 Argument passing: primitives by value, objects by reference (reference copied)                            │
└─────────────────────────────────────────────────────────────────────────────────────────────────────────────┘

┌─────────────────────────────────────────────────────────────────────────────────────────────────────────────┐
│ 🔗 INHERITANCE & POLYMORPHISM                                                                                 │
│                                                                                                               │
│   ┌────────────┐          ┌────────────┐          ┌────────────┐                                           │
│   │   Object   │◄─────────│   Animal   │◄─────────│   Mammal   │◄─────────┐                                 │
│   │ (root)     │  extends  │ (abstract?)│  extends  │            │          │ extends                       │
│   └────────────┘          └────────────┘          └─────┬──────┘          │                                 │
│                                                         │                 │                                 │
│                                                         ▼                 ▼                                 │
│                                                  ┌────────────┐    ┌────────────┐                           │
│                                                  │    Cat     │    │    Dog     │                           │
│                                                  └────────────┘    └────────────┘                           │
│                                                                                                               │
│ 🔹 Single inheritance (extends only one parent)                                                               │
│ 🔹 Overriding (runtime): same signature, dynamic lookup  🔹 Overloading (compile‑time)                       │
│ 🔹 `super` keyword to access parent members                                                                   │
│ 🔹 Shadowed variables: child declares same name – both exist, use `super.var`                                 │
└─────────────────────────────────────────────────────────────────────────────────────────────────────────────┘

┌─────────────────────────────────────────────────────────────────────────────────────────────────────────────┐
│ 🧾 INTERFACES & ABSTRACT CLASSES                                                                              │
│                                                                                                               │
│   ┌──────────────────┐         ┌──────────────────┐                                                         │
│   │ «interface»      │         │ «abstract»       │                                                         │
│   │ Driveable        │         │ Animal           │                                                         │
│   ├──────────────────┤         ├──────────────────┤                                                         │
│   │ + startEngine()  │         │ + makeSound()    │  (abstract method)                                      │
│   │ + stopEngine()   │         │ + sleep()        │  (concrete method)                                      │
│   └────────┬─────────┘         └────────┬─────────┘                                                         │
│            │ implements                 │ extends                                                            │
│            ▼                             ▼                                                                   │
│   ┌──────────────────┐         ┌──────────────────┐                                                         │
│   │ Automobile       │         │ Dog              │                                                         │
│   └──────────────────┘         └──────────────────┘                                                         │
│                                                                                                               │
│ 🔹 Interfaces: pure contract, multiple implementation allowed                                                │
│ 🔹 Abstract classes: cannot be instantiated, may have concrete methods                                       │
│ 🔹 Both promote polymorphism without implementation details                                                  │
└─────────────────────────────────────────────────────────────────────────────────────────────────────────────┘

┌─────────────────────────────────────────────────────────────────────────────────────────────────────────────┐
│ 📦 PACKAGES & IMPORTS                                                                                        │
│                                                                                                               │
│   package ch05.examples;                     // must be first line                                          │
│   import javax.swing.JFrame;                 // single class import                                         │
│   import javax.swing.*;                      // wildcard (all classes in package)                           │
│   javax.swing.JFrame frame = new ...;        // fully qualified name (no import)                           │
│                                                                                                               │
│ 🔹 Reverse domain naming: com.oreilly.learningjava6e                                                        │
│ 🔹 Compile: javac com/oreilly/.../*.java      🔹 Run: java com.oreilly...HelloJava                           │
│ 🔹 Default package (no name) – not recommended for real projects                                             │
└─────────────────────────────────────────────────────────────────────────────────────────────────────────────┘

┌─────────────────────────────────────────────────────────────────────────────────────────────────────────────┐
│ 🔒 VISIBILITY MODIFIERS (Access Control)                                                                     │
│                                                                                                               │
│   Modifier      │ Same class │ Same package │ Subclass (diff pkg) │ Any class                               │
│   ──────────────┼────────────┼──────────────┼─────────────────────┼──────────                               │
│   private       │     ✅     │      ❌      │         ❌          │    ❌                                   │
│   (default)     │     ✅     │      ✅      │         ❌          │    ❌                                   │
│   protected     │     ✅     │      ✅      │         ✅          │    ❌                                   │
│   public        │     ✅     │      ✅      │         ✅          │    ✅                                   │
│                                                                                                               │
│ 🔹 Best practice: use private fields with public getters/setters                                              │
└─────────────────────────────────────────────────────────────────────────────────────────────────────────────┘

┌─────────────────────────────────────────────────────────────────────────────────────────────────────────────┐
│ 🧩 INNER CLASSES (4 types)                                                                                    │
│                                                                                                               │
│   1. Non‑static inner ── needs outer instance ── Outer.Inner inner = outer.new Inner();                     │
│   2. Static nested    ── no outer instance ── new Outer.StaticNested();                                      │
│   3. Local class      ── inside a method ── visible only within that method                                 │
│   4. Anonymous inner  ── no name, instantiated at same place ── new Interface() { ... };                    │
│                                                                                                               │
│ 🔹 Anonymous inner class example (from HelloJava3):                                                          │
│   addMouseMotionListener(new MouseMotionListener() {                                                         │
│       public void mouseDragged(MouseEvent e) { ... }                                                         │
│   });                                                                                                        │
└─────────────────────────────────────────────────────────────────────────────────────────────────────────────┘

┌─────────────────────────────────────────────────────────────────────────────────────────────────────────────┐
│ 📦 WRAPPERS FOR PRIMITIVE TYPES & AUTOBOXING                                                                │
│                                                                                                               │
│   Primitive → Wrapper: int→Integer, double→Double, boolean→Boolean, char→Character, etc.                   │
│   Manual: Integer i = new Integer(33);   int n = i.intValue();                                              │
│   Autoboxing: List<Integer> list = new ArrayList<>(); list.add(33); // int→Integer                          │
│   Unboxing: int val = list.get(0); // Integer→int                                                           │
└─────────────────────────────────────────────────────────────────────────────────────────────────────────────┘

┌─────────────────────────────────────────────────────────────────────────────────────────────────────────────┐
│ 🏗️ CONSTRUCTORS & GARBAGE COLLECTION                                                                         │
│                                                                                                               │
│   🔹 Constructor chaining: this(args) must be first statement                                               │
│   🔹 Default constructor provided if none written                                                            │
│   🔹 Garbage collection: automatic – object becomes unreachable when no references point to it              │
│   🔹 System.gc() hints (not guaranteed)                                                                      │
│   🔹 finalize() deprecated – do not use                                                                      │
└─────────────────────────────────────────────────────────────────────────────────────────────────────────────┘

┌─────────────────────────────────────────────────────────────────────────────────────────────────────────────┐
│ 📐 BEST PRACTICES (Organizing Content)                                                                       │
│                                                                                                               │
│   🔹 Hide implementation (private fields + getters/setters)                                                  │
│   🔹 Composition over inheritance (reuse via fields instead of subclassing)                                  │
│   🔹 Minimize coupling, use packages to hide internal classes                                                │
│   🔹 Use meaningful package names (reverse domain)                                                           │
│   🔹 Example: AppleToss game – Apple, Tree, Physicist implement GamePiece; Field extends JComponent          │
└─────────────────────────────────────────────────────────────────────────────────────────────────────────────┘

╔═════════════════════════════════════════════════════════════════════════════════════════════════════════════╗
║  📌 QUICK REFERENCE – ALL KEYWORDS & CONCEPTS                                                                ║
╠═════════════════════════════════════════════════════════════════════════════════════════════════════════════╣
║  class │ new │ this │ super │ extends │ implements │ interface │ abstract │ static │ final │ private        ║
║  protected │ public │ package │ import │ return │ void │ int │ float │ boolean │ char │ null               ║
║  instanceof │ gc() │ Number │ Integer │ Double │ Boolean │ Character │ autoboxing │ unboxing               ║
║  overloading │ overriding │ shadowing │ inner class │ anonymous class │ local class │ static nested         ║
║  constructor │ default constructor │ constructor chaining │ garbage collection │ reachable │ unreachable    ║
╚═════════════════════════════════════════════════════════════════════════════════════════════════════════════╝
```

This single diagram includes every major topic from both files: class basics, inheritance, interfaces, abstract classes, packages, imports, access modifiers, inner classes (all four types), wrappers & autoboxing, constructors, garbage collection, and best practices. No data is omitted.