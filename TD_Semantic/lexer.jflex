package cup.example;
import java_cup.runtime.ComplexSymbolFactory;
import java_cup.runtime.ComplexSymbolFactory.Location;
import java_cup.runtime.Symbol;
import java.lang.*;
import java.io.InputStreamReader;

%%

%class Lexer
%implements sym
%public
%unicode
%line
%column
%cup
%char
%{
	

    public Lexer(ComplexSymbolFactory sf, java.io.InputStream is){
		this(is);
        symbolFactory = sf;
    }
	public Lexer(ComplexSymbolFactory sf, java.io.Reader reader){
		this(reader);
        symbolFactory = sf;
    }
    
    private StringBuffer sb;
    private ComplexSymbolFactory symbolFactory;
    private int csline,cscolumn;

    public Symbol symbol(String name, int code){
		return symbolFactory.newSymbol(name, code,
						new Location(yyline+1,yycolumn+1, yychar), // -yylength()
						new Location(yyline+1,yycolumn+yylength(), yychar+yylength())
				);
    }
    public Symbol symbol(String name, int code, String lexem){
	return symbolFactory.newSymbol(name, code, 
						new Location(yyline+1, yycolumn +1, yychar), 
						new Location(yyline+1,yycolumn+yylength(), yychar+yylength()), lexem);
    }
    
    protected void emit_warning(String message){
    	System.out.println("scanner warning: " + message + " at : 2 "+ 
    			(yyline+1) + " " + (yycolumn+1) + " " + yychar);
    }
    
    protected void emit_error(String message){
    	System.out.println("scanner error: " + message + " at : 2" + 
    			(yyline+1) + " " + (yycolumn+1) + " " + yychar);
    }
%}

Newline    = \r | \n | \r\n
Whitespace = [ \t\f] | {Newline}
Number     = [0-9]+

letter = [a-zA-Z_]
digit = [0-9]
fraction = "."{digit}+
exponent = (E|e)(\+|\-)?{digit}+
int_lit     = {digit}({digit})*
float_lit   = ({digit}*{fraction}{exponent}?)|({digit}+".")|({digit}+"."?{exponent})
boolean_lit = true|false
identifier = {letter}({letter}|{digit})*
string_lit = \"{letter}({letter}|{digit})*\"


/* comments */
comment = {traditionalComment} | {endOfLineComment}
traditionalComment = "/*" {commentContent} \*+ "/"
endOfLineComment = "//" [^\r\n]* {Newline}
commentContent = ( [^*] | \*+[^*/] )*

ident = ([:jletter:] | "_" ) ([:jletterdigit:] | [:jletter:] | "_" )*


%eofval{
    return symbolFactory.newSymbol("EOF",sym.EOF);
%eofval}

%state CODESEG

%%  

<YYINITIAL> {

  {Whitespace} {                              }
  ";"          { return symbolFactory.newSymbol("SEMI", SEMI); }
  "+"          { return symbolFactory.newSymbol("PLUS", PLUS); }
  "-"          { return symbolFactory.newSymbol("MINUS", MINUS); }
  "*"          { return symbolFactory.newSymbol("TIMES", TIMES); }
  "("          { return symbolFactory.newSymbol("LPAREN", LPAREN); }
  ")"          { return symbolFactory.newSymbol("RPAREN", RPAREN); }
  
  "/"		   { return symbolFactory.newSymbol("DIV", DIV); }
  
  {comment}    { return symbolFactory.newSymbol("COMM", COMM); }
  
  "<"          { return symbolFactory.newSymbol("LESS", LESS); }
  "<="         { return symbolFactory.newSymbol("LESSEQUAL", LESSEQUAL); }
  ">"          { return symbolFactory.newSymbol("GREATER", GREATER); }
  ">="         { return symbolFactory.newSymbol("GREATEREQUAL", GREATEREQUAL); }
  
  "=="         { return symbolFactory.newSymbol("EQUAL", EQUAL); }
  "!="         { return symbolFactory.newSymbol("NOTEQUAL", NOTEQUAL); }
  
  "||"         { return symbolFactory.newSymbol("OR", OR); }
  "&&"         { return symbolFactory.newSymbol("AND", AND); }
  "!"          { return symbolFactory.newSymbol("NOT", NOT); }
  
  "="          { return symbolFactory.newSymbol("ASGOP", ASGOP); }
  
  "{"          { return symbolFactory.newSymbol("LCURLY", LCURLY); }
  "}"          { return symbolFactory.newSymbol("RCURLY", RCURLY); }
  "["          { return symbolFactory.newSymbol("LSQUARE", LSQUARE); }
  "]"          { return symbolFactory.newSymbol("RSQUARE", RSQUARE); }
  ","          { return symbolFactory.newSymbol("COMMA", COMMA); }
  
  "um"		   { return symbolFactory.newSymbol("UMINUS", UMINUS); }
  "up"         { return symbolFactory.newSymbol("UPLUS", UPLUS); }
  "unot"       { return symbolFactory.newSymbol("UNOT", UNOT); }
 
  "boolean"      { return symbolFactory.newSymbol("BOOLEAN", BOOLEAN); }
  "break"     	 { return symbolFactory.newSymbol("BREAK", BREAK); }
  "continue"     { return symbolFactory.newSymbol("CONTINUE", CONTINUE); }
  "else"     	 { return symbolFactory.newSymbol("ELSE", ELSE); }
  "for"      	 { return symbolFactory.newSymbol("FOR", FOR); }
  "float"     	 { return symbolFactory.newSymbol("FLOAT", FLOAT); }
  "if"     		 { return symbolFactory.newSymbol("IF", IF); }
  "int"     	 { return symbolFactory.newSymbol("INT", INT); }
  "return"     	 { return symbolFactory.newSymbol("RETURN", RETURN); }
  "void"     	 { return symbolFactory.newSymbol("VOID", VOID); }
  "while"     	 { return symbolFactory.newSymbol("WHILE", WHILE); }
  
  {int_lit}    	   { return symbolFactory.newSymbol("INT_LIT", INT_LIT, Integer.parseInt(yytext())); }
  {float_lit}      { return symbolFactory.newSymbol("FLOAT_LIT", FLOAT_LIT, Float.parseFloat(yytext())); }
  {boolean_lit}    { return symbolFactory.newSymbol("BOOLEAN_LIT", BOOLEAN_LIT, Boolean.parseBoolean(yytext())); }
  {string_lit}     { return symbolFactory.newSymbol("STRING_LIT", STRING_LIT, yytext()); }
  {identifier}     { return symbolFactory.newSymbol("ID", ID, yytext()); }
}



// error fallback
.|\n          { emit_warning("Unrecognized character '" +yytext()+"' -- ignored"); }
