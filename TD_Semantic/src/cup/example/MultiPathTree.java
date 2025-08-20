package cup.example;

import java.util.ArrayList;
import java.util.Hashtable;

enum IdentifierScope {
	Local, Global
}

enum SymbolType {
	Function, Variable, DataType
}

public class MultiPathTree {
	private TreeNode root;
	private Hashtable<String, SymTableEntry> table;
	private String dataName;
	private String context = "Global";

	public void initialize(TreeNode root) {
		this.root = root;
	}

	public void print() {
		printNode(root, 0);
	}

	private void printNode(TreeNode node, int level) {
		if (node == null) {
			return;
		}

		for (int i = 0; i < level; i++) {
			System.out.print("  ");
		}
		System.out.println(node.getData() + " ( " + node.getExtraData() + " )");

		ArrayList<TreeNode> children = node.getChildren();
		children.forEach(child -> {
			printNode(child, level + 1);
		});
	}

	public void createHashtable() {
		table = new Hashtable<String, SymTableEntry>();
		parseNode(root);
	}

	private void parseNode(TreeNode node) {
		String data = node.getData();
		boolean check = false;
		if (data == "FuncDecl") {
			check = true;
			String dataType = null;
			SymTableEntry entry;
			ArrayList<TreeNode> children = node.getChildren();
			for (TreeNode treeNode : children) {
				if (treeNode.getData() == "Type") {
					dataType = treeNode.getExtraData();
				}
				if (treeNode.getData() == "Identifier") {
					dataName = treeNode.getExtraData();
				}
			}
			if (context == "Global") {
				entry = new SymTableEntry(dataName, dataType, SymbolType.Function, IdentifierScope.Global,
						context);
			} else {
				entry = new SymTableEntry(dataName, dataType, SymbolType.Function, IdentifierScope.Local,
						context);
			}
			table.put(node.getData(), entry);
			table.get(node.getData()).print();
		}
		if (data == "ValDecl") {
			SymTableEntry entry;
			String dataType = null;
			ArrayList<TreeNode> children = node.getChildren();
			for (TreeNode treeNode : children) {
				if (treeNode.getData() == "Type") {
					dataType = treeNode.getExtraData();
				}
				if (treeNode.getData() == "InitDeclarator") {
					for (TreeNode treeNode2 : treeNode.getChildren()) {
						if (treeNode2.getData() == "Identifier") {
							dataName = treeNode2.getExtraData();
						}
					}
				}
			}
			if (context == "Global") {
				entry = new SymTableEntry(dataName, dataType, SymbolType.Variable, IdentifierScope.Global,
						context);
			} else {
				entry = new SymTableEntry(dataName, dataType, SymbolType.Variable, IdentifierScope.Local,
						context);
			}
			table.put(node.getData(), entry);
			table.get(node.getData()).print();
		}

		ArrayList<TreeNode> children = node.getChildren();
		if (node.getData() == "FuncDecl") {
			for (TreeNode treeNode2 : node.getChildren()) {
				if (treeNode2.getData() == "Identifier") {
					context = treeNode2.getExtraData();
				}
			}
		}
		for (TreeNode child : children) {
			parseNode(child);
			
		}
		if (node.getData() == "FuncDecl") {
			context = "Global";
		}
	}
}
