package cup.example;

public class SymTableEntry {

	private String symbolName; // numele variabilei sau functiei
	private String dataType; // tipul de date al variabilei
	private SymbolType symbolType; // tipul simbolului - variabila sau functie
	private IdentifierScope symbolScope; // scopul variabilei/functiei - global sau local
	private String contextName; // contextul in care este declarata variabila/functia. ex. Daca variabila x

	public SymTableEntry(String symbolName, String dataType, SymbolType symbolType, IdentifierScope symbolScope,
			String contextName) {
		this.symbolName = symbolName;
		this.dataType = dataType;
		this.symbolType = symbolType;
		this.symbolScope = symbolScope;
		this.contextName = contextName;
	}

	public void print() {
		System.out.println(String.format("Name: %10s | DType: %10s | SType: %10s | Scope: %10s | Context: %10s", 
				symbolName, dataType, symbolType, symbolScope, contextName));
	}
}
