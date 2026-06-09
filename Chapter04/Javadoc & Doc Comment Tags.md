## What Javadoc does

- The `javadoc` command-line tool creates HTML documentation for classes by reading the source code and extracting embedded doc comments and `@` tags.
- Example tags:
    - `@author` and `@version` add author and version information to the class documentation.
    - `@see` produces hypertext links to related class documentation.

## Compiler behavior & `@deprecated`

- The compiler also reads doc comments, especially the `@deprecated` tag.
- `@deprecated` marks a method/item as obsolete and should be avoided in new code.
- Compiled classes include metadata about deprecated methods so the compiler can warn when deprecated features are used (even if source code isn’t available).

## Where doc comments can appear

- Doc comments can appear above:
    - class definitions
    - method definitions
    - variable definitions
- Some tags only apply in certain contexts (e.g., `@exception` only applies to methods).

## Common doc comment tags (summary)

| Tag | Description | Applies to |
| --- | --- | --- |
| @see | Associated class name | Class, method, or variable |
| @code | Source code content | Class, method, or variable |
| @link | Associated URL | Class, method, or variable |
| @author | Author name | Class |
| @version | Version string | Class |
| @param | Parameter name and description | Method |
| @return | Description of return value | Method |
| @exception | Exception name and description | Method |
| @deprecated | Declares an item to be obsolete | Class, method, or variable |
| @since | Notes API version when item was added | Variable |

## Javadoc tags vs Java annotations

- Javadoc tags are metadata in comments (descriptive information about code structure/contents).
- Java annotations provide a more formal and extensible way to attach metadata to classes, methods, and variables.
- Annotation metadata is also available at runtime.