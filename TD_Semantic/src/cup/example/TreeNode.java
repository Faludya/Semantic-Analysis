package cup.example;

import java.util.ArrayList;

public class TreeNode {
	private String data;

	private String extraData;

	private ArrayList<TreeNode> children = new ArrayList<TreeNode>();

	public TreeNode(String data, String extraData) {
		this.data = data;
		this.extraData = extraData;
	}

	public void addChild(TreeNode nodeToAdd) {
		children.add(nodeToAdd);
	}

	public String getData() {
		return data;
	}

	public String getExtraData() {
		return extraData;
	}

	public void setExtraData(String _extraData) {
		extraData = _extraData;
	}

	public ArrayList<TreeNode> getChildren() {
		return children;
	}
	
	public static TreeNode createProgramNode(TreeNode f_d, TreeNode p) {
		TreeNode newNode = new TreeNode("Program", "");
		if (f_d != null) {
			newNode.addChild(f_d);
		}
		if (p != null) {
			ArrayList<TreeNode> children = p.getChildren();
			for (TreeNode treeNode : children) {
				newNode.addChild(treeNode);
			}
		}
		
		return newNode;
	}
	
	public static TreeNode createFuncDeclNode(TreeNode t, TreeNode i, TreeNode p_l, TreeNode c_s) {
		TreeNode newNode = new TreeNode("FuncDecl", "");
		if (t != null) {
			newNode.addChild(t);
		}
		if (i != null) {
			newNode.addChild(i);
		}
		if (p_l != null) {
			newNode.addChild(p_l);
		}
		if (c_s != null) {
			newNode.addChild(c_s);
		}
		
		return newNode;
	}
	
	public static TreeNode createValDecl(TreeNode t, TreeNode i_d_l) {
		TreeNode newNode = new TreeNode("ValDecl", "");
		if (t != null) {
			newNode.addChild(t);
		}
		if (i_d_l != null) {
			newNode.addChild(i_d_l);
		}
		
		return newNode;
	}
	
	public static TreeNode createInitDeclaratorList(TreeNode i_d, TreeNode e_d) {
		TreeNode newNode = new TreeNode("InitDeclaratorList", "");
		if (i_d != null) {
			newNode.addChild(i_d);
		}
		if (e_d != null) {
			ArrayList<TreeNode> children = e_d.getChildren();
			for (TreeNode treeNode : children) {
				newNode.addChild(treeNode);
			}
			if (newNode.getChildren().size() == 1) {
				return newNode.getChildren().get(0);
			}
		}
		
		return newNode;
	}
	
	public static TreeNode createExtendedDeclarator(TreeNode i_d_l, TreeNode e_d) {
		TreeNode newNode = new TreeNode("ExtendedDeclarator", "");
		if (i_d_l != null) {
			ArrayList<TreeNode> children = i_d_l.getChildren();
			for (TreeNode treeNode : children) {
				newNode.addChild(treeNode);
			}
		}
		if (e_d != null) {
			ArrayList<TreeNode> children = e_d.getChildren();
			for (TreeNode treeNode : children) {
				newNode.addChild(treeNode);
			}
		}
		
		return newNode;
	}
	
	public static TreeNode createInitDeclarator(TreeNode d, TreeNode i) {
		TreeNode newNode = new TreeNode("InitDeclarator", "");
		if (d != null) {
			newNode.addChild(d);
		}
		if (i != null) {
			newNode.addChild(i);
		}
		
		return newNode;
	}
	
	public static TreeNode createDeclarator(TreeNode i) {
		return i;
	}
	
	public static TreeNode createDeclarator(TreeNode i, Integer i_l) {
		i.setExtraData(i.getExtraData() + "[" + Integer.toString(i_l) + "]");
		
		return i;
	}
	
	public static TreeNode createInitialiser(TreeNode e, TreeNode e_e) {
		TreeNode newNode = new TreeNode("Initialiser", "");
		if (e != null) {
			newNode.addChild(e);
		}
		if (e_e != null) {
			newNode.addChild(e_e);
		}
		
		return newNode;
	}
	
	public static TreeNode createExtendedExpr(TreeNode e, TreeNode e_e) {
		TreeNode newNode = new TreeNode("ExtendedExpr", "");
		if (e != null) {
			newNode.addChild(e);
		}
		if (e_e != null) {
			newNode.addChild(e_e);
		}
		
		return newNode;
	}
	
	public static TreeNode createType(String name) {
		TreeNode newNode = new TreeNode("Type", name);
		
		return newNode;
	}
	
	public static TreeNode createIdentifier(String id) {
		TreeNode newNode = new TreeNode("Identifier", id);
		
		return newNode;
	}
	
	public static TreeNode createCompoundStmt(TreeNode e_v_d, TreeNode e_s) {
		TreeNode newNode = new TreeNode("CompoundStmt", "");
		if (e_v_d != null) {
			newNode.addChild(e_v_d);
		}
		if (e_s != null) {
			newNode.addChild(e_s);
		}
		
		if (newNode.getChildren().size() == 0) {
			return null;
		}
		
		if (newNode.getChildren().size() == 1) {
			return newNode.getChildren().get(0);
		}
		
		return newNode;
	}
	
	public static TreeNode createExtendedVarDecl(TreeNode v_d, TreeNode e_v_d) {
		TreeNode newNode = new TreeNode("ExtendedVarDecl", "");
		if (v_d != null) {
			newNode.addChild(v_d);
		}
		if (e_v_d != null) {
			newNode.addChild(e_v_d);
		}
		
		return newNode;
	}
	
	public static TreeNode createExtendedStmt(TreeNode e, TreeNode e_e) {
		TreeNode newNode = new TreeNode("ExtendedStmt", "");
		if (e != null) {
			newNode.addChild(e);
		}
		if (e_e != null) {
			ArrayList<TreeNode> children = e_e.getChildren();
			for (TreeNode treeNode : children) {
				newNode.addChild(treeNode);
			}
		}
		
		return newNode;
	}
	
	public static TreeNode createStmt(TreeNode c_s) {
		return c_s;
	}
	
	public static TreeNode createIfStmt(TreeNode e, TreeNode s1, TreeNode s2) {
		TreeNode newNode = new TreeNode("IfStmt", "");
		if (e != null) {
			newNode.addChild(e);
		}
		if (s1 != null) {
			newNode.addChild(s1);
		}
		if (s2 != null) {
			newNode.addChild(s2);
		}
		
		return newNode;
	}
	
	public static TreeNode createForStmt(TreeNode e1, TreeNode e2, TreeNode e3, TreeNode s) {
		TreeNode newNode = new TreeNode("ForStmt", "");
		if (e1 != null) {
			newNode.addChild(e1);
		}
		if (e2 != null) {
			newNode.addChild(e2);
		}
		if (e3 != null) {
			newNode.addChild(e3);
		}
		if (s != null) {
			newNode.addChild(s);
		}
		
		return newNode;
	}
	
	public static TreeNode createWhileStmt(TreeNode e, TreeNode s) {
		TreeNode newNode = new TreeNode("WhileStmt", "");
		if (e != null) {
			newNode.addChild(e);
		}
		if (s != null) {
			newNode.addChild(s);
		}
		
		return newNode;
	}
	
	public static TreeNode createBreakStmt() {
		TreeNode newNode = new TreeNode("BreakStmt", "");
		
		return newNode;
	}
	
	public static TreeNode createContinueStmt() {
		TreeNode newNode = new TreeNode("ContinueStmt", "");
		
		return newNode;
	}
	
	public static TreeNode createReturnStmt(TreeNode e) {
		TreeNode newNode = new TreeNode("ReturnStmt", "");
		if (e != null) {
			newNode.addChild(e);
		}
		
		return newNode;
	}
	
	public static TreeNode createExprStmt(TreeNode e) {
		TreeNode newNode = new TreeNode("ExprStmt", "");
		if (e != null) {
			newNode.addChild(e);
		}
		
		return newNode;
	}
	
	public static TreeNode createAssignmentStmt(TreeNode a_e) {
		return a_e;
	}
	
	public static TreeNode createAssignmentExpr(TreeNode e_c_o_e, TreeNode c_o_e) {
		TreeNode newNode = new TreeNode("AssignmentExpr", "");
		if (e_c_o_e != null) {
			newNode.addChild(e_c_o_e);
		}
		if (c_o_e != null) {
			newNode.addChild(c_o_e);
		}
		
		return newNode;
	}
	
	public static TreeNode createExtendedCondOrExpr(TreeNode e_c_o_e, TreeNode c_o_e) {
		TreeNode newNode = new TreeNode("ExtendedCondOrExpr", "");
		if (e_c_o_e != null) {
			ArrayList<TreeNode> children = e_c_o_e.getChildren();
			for (TreeNode treeNode : children) {
				newNode.addChild(treeNode);
			}
		}
		if (c_o_e != null) {
			return c_o_e;
		}
		
		if (newNode.getChildren().size() == 0) {
			return null;
		}
		
		return newNode;
	}
	
	public static TreeNode createCondOrExpr(TreeNode c_o_e, TreeNode c_a_e) {
		TreeNode newNode = new TreeNode("CondOrExpr", "");
		if (c_o_e != null) {
			newNode.addChild(c_o_e);
		}
		if (c_a_e != null) {
			newNode.addChild(c_a_e);
		}
		
		return newNode;
	}
	
	public static TreeNode createCondOrExpr(TreeNode c_o_e) {
		return c_o_e;
	}
	
	public static TreeNode createCondAndExpr(TreeNode c_a_e, TreeNode e_e) {
		TreeNode newNode = new TreeNode("CondAndExpr", "");
		if (c_a_e != null) {
			newNode.addChild(c_a_e);
		}
		if (e_e != null) {
			newNode.addChild(e_e);
		}
		
		return newNode;
	}
	
	public static TreeNode createCondAndExpr(TreeNode c_a_e) {
		return c_a_e;
	}
	
	public static TreeNode createEqualityExpr(TreeNode e_e, TreeNode r_e, String op) {
		TreeNode newNode = new TreeNode("EqualityExpr", op);
		if (e_e != null) {
			newNode.addChild(e_e);
		}
		if (r_e != null) {
			newNode.addChild(r_e);
		}
		
		return newNode;
	}
	
	public static TreeNode createEqualityExpr(TreeNode e_e) {
		return e_e;
	}
	
	public static TreeNode createRelExpr(TreeNode r_e, TreeNode a_e) {
		TreeNode newNode = new TreeNode("RelExpr", "");
		if (r_e != null) {
			newNode.addChild(r_e);
		}
		if (a_e != null) {
			newNode.addChild(a_e);
		}
		ArrayList<TreeNode> children = newNode.getChildren();
		if (children.size() == 1) {
			TreeNode child = children.get(0);
			children.remove(0);
			children.addAll(child.getChildren());
			newNode.setExtraData(child.getExtraData());
		}
		
		return newNode;
	}
	
	public static TreeNode createRelExpr(TreeNode r_e, TreeNode a_e, String op) {
		TreeNode newNode = new TreeNode("RelExpr", op);
		if (r_e != null) {
			newNode.addChild(r_e);
		}
		if (a_e != null) {
			newNode.addChild(a_e);
		}
		ArrayList<TreeNode> children = newNode.getChildren();
		if (children.size() == 1) {
			TreeNode child = children.get(0);
			children.remove(0);
			children.addAll(child.getChildren());
			newNode.setExtraData(child.getExtraData());
		}
		
		return newNode;
	}
	
	public static TreeNode createRelExpr(TreeNode r_e) {
		return r_e;
	}
	
	public static TreeNode createAdditiveExpr(TreeNode a_e, TreeNode m_e) {
		TreeNode newNode = new TreeNode("AdditiveExpr", "");
		if (a_e != null) {
			newNode.addChild(a_e);
		}
		if (m_e != null) {
			newNode.addChild(m_e);
		}
		
		return newNode;
	}
	
	public static TreeNode createAdditiveExpr(TreeNode a_e, TreeNode m_e, String op) {
		TreeNode newNode = new TreeNode("AdditiveExpr", op);
		if (a_e != null) {
			newNode.addChild(a_e);
		}
		if (m_e != null) {
			newNode.addChild(m_e);
		}
		
		return newNode;
	}
	
	public static TreeNode createAdditiveExpr(TreeNode a_e) {
		return a_e;
	}
	
	public static TreeNode createMultiplicativeExpr(TreeNode m_e, TreeNode u_e, String op) {
		TreeNode newNode = new TreeNode("MultiplicativeExpr", op);
		if (m_e != null) {
			newNode.addChild(m_e);
		}
		if (u_e != null) {
			newNode.addChild(u_e);
		}
		
		return newNode;
	}
	
	public static TreeNode createMultiplicativeExpr(TreeNode m_e) {
		return m_e;
	}
	
	public static TreeNode createUnaryExpr(TreeNode u_e) {
		return u_e;
	}
	
	public static TreeNode createUnaryExpr(TreeNode u_e, String op) {
		u_e.setExtraData(op + u_e.getExtraData());
		
		return u_e;
	}
	
	public static TreeNode createPrimaryExpr(TreeNode i, TreeNode e) {
		TreeNode newNode = new TreeNode("PrimaryExpr", "");
		if (i != null) {
			newNode.addChild(i);
		}
		if (e != null) {
			newNode.addChild(e);
		}
		
		return newNode;
	}
	
	public static TreeNode createPrimaryExpr(TreeNode i) {
		return i;
	}
	
	public static TreeNode createPrimaryExpr(String val) {
		TreeNode newNode = new TreeNode("PrimaryExprVal", val);
		
		return newNode;
	}
	
	public static TreeNode createParaList(TreeNode p_p_l) {
		return p_p_l;
	}
	
	public static TreeNode createProperParaList(TreeNode p_d, TreeNode e_p_d) {
		TreeNode newNode = new TreeNode("ProperParaList", "");
		if (p_d != null) {
			newNode.addChild(p_d);
		}
		if (e_p_d != null) {
			ArrayList<TreeNode> children = e_p_d.getChildren();
			for (TreeNode treeNode : children) {
				newNode.addChild(treeNode);
			}
		}
		
		return newNode;
	}
	
	public static TreeNode createExtendedParaDecl(TreeNode p_d, TreeNode e_p_d) {
		TreeNode newNode = new TreeNode("ExtendedParaDecl", "");
		if (p_d != null) {
			newNode.addChild(p_d);
		}
		if (e_p_d != null) {
			ArrayList<TreeNode> children = e_p_d.getChildren();
			for (TreeNode treeNode : children) {
				newNode.addChild(treeNode);
			}
		}
		
		return newNode;
	}
	
	public static TreeNode createParaDecl(TreeNode t, TreeNode d) {
		TreeNode newNode = new TreeNode("ParaDecl", "");
		if (t != null) {
			newNode.addChild(t);
		}
		if (d != null) {
			newNode.addChild(d);
		}
		
		return newNode;
	}
	
	public static TreeNode createArgList(TreeNode p_a_l) {
		TreeNode newNode = new TreeNode("ArgList", "");
		if (p_a_l != null) {
			return p_a_l;
		}
		
		return null;
	}
	
	public static TreeNode createProperArgList(TreeNode a, TreeNode e_a) {
		TreeNode newNode = new TreeNode("ProperArgList", "");
		if (a != null) {
			newNode.addChild(a);
		}
		if (e_a != null) {
			ArrayList<TreeNode> children = e_a.getChildren();
			for (TreeNode treeNode : children) {
				newNode.addChild(treeNode);
			}
		}
		
		if (newNode.getChildren().size() == 1) {
			return newNode.getChildren().get(0);
		}
		
		return newNode;
	}
	
	public static TreeNode createExtendedArg(TreeNode a, TreeNode e_a) {
		TreeNode newNode = new TreeNode("ExtendedArg", "");
		if (a != null) {
			newNode.addChild(a);
		}
		if (e_a != null) {
			ArrayList<TreeNode> children = e_a.getChildren();
			for (TreeNode treeNode : children) {
				newNode.addChild(treeNode);
			}
		}
		
		return newNode;
	}
	
	public static TreeNode createArg(TreeNode e) {
		return e;
	}
}
