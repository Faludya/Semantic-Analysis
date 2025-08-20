# 📝 Syntax & Semantic Analysis — Translator Design Project

This project is an implementation of the **front-end of a compiler**.  
It includes:
- **Lexical Analysis** (Lexer)
- **Syntax Analysis** (Parser → Parse Tree / Abstract Syntax Tree)
- **Semantic Analysis** (Symbol Table, Type Checking)
- A simple **Driver** to run the full pipeline

The goal of the project is to process a small programming language, detect errors, and build intermediate representations of the source code.

---

## 📂 Project Structure
├── Driver.java # Main entry point — runs lexer, parser, semantic checks


├── Lexer.java # Lexical analyzer (tokenizes source input)


├── Parser.java # Syntactic analyzer (builds parse tree / AST)


├── TreeNode.java # Node representation for syntax tree


├── MultiPathTree.java # Tree data structure for multi-branch AST


├── sym.java # Symbol definitions (token types, categories, etc.)


├── SymTableEntry.java # Representation of a symbol table entry


└── Lexer.java~ # Backup copy of the lexer


---

## ⚙️ Components

### 🔹 Lexer
- Reads raw input (program source).  
- Breaks it into **tokens** (keywords, identifiers, literals, operators).  
- Provides tokens to the parser.  

### 🔹 Parser
- Consumes tokens from the lexer.  
- Implements a grammar for the mini-language.  
- Builds a **parse tree** or **abstract syntax tree (AST)** using `TreeNode` and `MultiPathTree`.  

### 🔹 Semantic Analysis
- Uses a **symbol table** (via `sym.java` and `SymTableEntry.java`).  
- Performs checks like:
  - Undeclared variables  
  - Duplicate declarations  
  - Type mismatches in assignments/operations  
- Ensures the program is semantically valid before code generation.  

### 🔹 Driver
- Runs the full pipeline:
  1. Call Lexer → tokenize input  
  2. Call Parser → build parse tree  
  3. Perform Semantic Analysis  
  4. Print results (tree or error messages)  
