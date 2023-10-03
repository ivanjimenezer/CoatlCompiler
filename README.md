# CoatlCompiler

## What is a Compiler?
A compiler is a specialized software tool that translates high-level programming code (source code) written by humans into low-level machine code that can be executed by a computer's CPU. The process of compilation involves several stages, including lexical analysis, syntactical analysis, and semantic analysis.

### EXAMPLE OF A COATL SCRIPT
![image](https://github.com/ivanjimenezer/CoatlCompiler/assets/73207110/56622c10-3675-450e-973c-f43f329c3f1c)

## About CoatlCompiler
CoatlCompiler is a compiler developed using Java and JavaCC. It is designed to work with a new programming language called Coatl. This compiler performs a comprehensive analysis of Coatl code, including lexical analysis (tokenization), syntactical analysis (parsing), and semantic analysis (checking for meaning and correctness). This project helped me to understand the deep layers of programming languages and the rules that they follow. 
This project was developed with my coworker [Selena](https://github.com/Neys2).


### Lexical Analyzer
A lexical analyzer, also known as a lexer or scanner, is responsible for breaking down the source code into meaningful tokens. These tokens represent the basic building blocks of the programming language, such as keywords, identifiers, numbers, and symbols.

## Lexical error
![image](https://github.com/ivanjimenezer/CoatlCompiler/assets/73207110/83e1f794-e119-4e88-b71e-4c75618d6df5)

## Output 
![image](https://github.com/ivanjimenezer/CoatlCompiler/assets/73207110/f3e89803-f3af-4233-83c9-b3af4ed63cd9)


When it finds an error, it will still run through all the code to analyze more errors. It also shows a hash table that contains all existing variables.


### Syntactical Analyzer
A syntactical analyzer, also known as a parser, checks the sequence and structure of tokens to ensure they conform to the language's grammar rules. It constructs a syntax tree or abstract syntax tree (AST) that represents the hierarchical structure of the code.

## Syntactical Error
![image](https://github.com/ivanjimenezer/CoatlCompiler/assets/73207110/b79edafa-1517-482c-aa58-093e616e7c9e)

## Output 
![image](https://github.com/ivanjimenezer/CoatlCompiler/assets/73207110/70dd8537-4a1b-4e68-bcda-1ce8b7afafd7)


### Semantical Analyzer
A semantical analyzer performs a deeper analysis of the code to ensure that it makes sense and adheres to the language's semantics. It checks for type compatibility, variable declarations, function definitions, and other language-specific rules.

##Semantical Error

![image](https://github.com/ivanjimenezer/CoatlCompiler/assets/73207110/77510bfc-c96e-4bd8-b8bc-664228e5fee0)

##Output

![image](https://github.com/ivanjimenezer/CoatlCompiler/assets/73207110/9552d683-23e2-4735-bcd1-8ce9e57add95)


Full documentation is [here](https://docs.google.com/document/d/1qRpKblueszS3fqqDzRHxCl6tEvAHGv74/edit?usp=sharing&ouid=103977191509495792883&rtpof=true&sd=true)


