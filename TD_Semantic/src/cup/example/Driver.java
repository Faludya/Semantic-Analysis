package cup.example;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import java_cup.runtime.*;

class Driver {

    public static void main(String[] args) throws Exception {
        Parser parser = new Parser();
        parser.parse();
        MultiPathTree tree=parser.getParseTree();
        tree.print();
        tree.createHashtable();
//        ComplexSymbolFactory symbolFactory= new ComplexSymbolFactory();
//
//        File file = new File("input.txt");
//        FileInputStream fis = null;
//        try {
//          fis = new FileInputStream(file);
//        } catch (IOException e) {
//          e.printStackTrace();
//        } 
//        Lexer lexer = new Lexer(symbolFactory,fis);
//
//        Symbol currentSymbol;
//        while ((currentSymbol = lexer.next_token()).sym != sym.EOF)
//        {
//            System.out.println(currentSymbol.toString());
//        }
    }    
}