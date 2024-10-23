package hw04;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Find the key associated with the minimum value in a tree.
 */
public class MinKeyFinder implements CS232Visitor<String, Integer> {
	private String sk = null;
	private Integer sv = null;

	public MinKeyFinder() {
	}

	/**
	 * {@inheritDoc}
	 */
	public void visit(String key, Integer value) {
		if ((sk == null) || (sv > value)) {
			sk = key;
			sv = value;
		}
	}

	/**
	 * Get the key associated with the minimum value in the tree.
	 * 
	 * @return the key associated with the minimum value.
	 */
	public String getMinKey() {
		return sk;
	}
	
	public static void main(String[] args) {

		String[] keys = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J",
				"K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V",
				"W", "X", "Y", "Z" };
		
		ArrayList<Integer> vals = new ArrayList<Integer>();
		for (int i=0; i<keys.length; i++) {
			vals.add(i);
		}
	
		CS232LinkedBinaryTree<String, Integer> t = new CS232LinkedBinaryTree<String, Integer>(
				keys, vals.toArray(new Integer[] {}));
		MinKeyFinder mkf = new MinKeyFinder();
		t.visitPreOrder(mkf);
		System.out.println(mkf.getMinKey());
	}
}
