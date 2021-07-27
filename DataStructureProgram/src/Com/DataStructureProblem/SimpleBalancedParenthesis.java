/**
* <h1>Welcome to the data structure problem !!</h1> 
* <h2>Implementing simple balanced parenthesis program</h2>
* <p><b>Desc -></b>Take an Arithmetic Expression such as
* 				   (5+6)∗(7+8)/(4+3)(5+6)∗(7+8)/(4+3) where parentheses are used to order 
* the performance of operations. Ensure parentheses must appear in a balanced fashion.
* <p><b>I/P --> </b>Read in arithmetic expression such as (5+6)∗(7+8)/(4+3)(5+6)∗(7+8)/(4+3)</p>
* <p><b>Logic :: </b>Write a Stack Class to push open parenthesis “(“ and pop closed
* 					 parenthesis “)”. At the End of the Expression if the Stack is Empty 
* then the Arithmetic Expression is Balanced. Stack Class Methods are Stack(), push(),
* pop(), peak(), isEmpty(), size()</p>
* <p><b>O/P --> </b>True or False to Show Arithmetic Expression is balanced or not.</p>
* 
* @author Official_vk
* @version 1.0
* @since 2021-07-28
*/

package Com.DataStructureProblem;

public class SimpleBalancedParenthesis {
	public static void main(String[] args) {
		SimpleBalancedParenthesis sbp = new SimpleBalancedParenthesis();
		String expr = "(5+6)∗(7+8)/(4+3)(5+6)∗(7+8)/(4+3)";
		String expr1 = "[{()}]";
		sbp.checkIsBalanced(expr);
		sbp.checkIsBalanced(expr1);
	}

	/**
	 * To check if the string is balanced or not
	 * 
	 * @param expr string expression
	 */
	private void checkIsBalanced(String expr) {
		if (areBracketsBalanced(expr)) {
			System.out.println(expr + " is Balanced ");
		} else {
			System.out.println(expr + " is Not Balanced ");
		}
	}

	/**
	 * to push open parenthesis “(“ and pop closed parenthesis “)”. At the End of
	 * the Expression if the Stack is Empty then the Arithmetic Expression is
	 * Balanced.
	 */
	private boolean areBracketsBalanced(String expr) {
		Stack<Character> stack = new Stack<Character>();
		for (int i = 0; i < expr.length(); i++) {
			char x = expr.charAt(i);
			if (x == '(' || x == '[' || x == '{') {
				stack.push(x);
				continue;
			}
			if (stack.isEmpty())
				return false;
			char check;
			switch (x) {
			case ')' -> {
				check = stack.pop();
				if (check == '{' || check == '[')
					return false;
			}
			case '}' -> {
				check = stack.pop();
				if (check == '(' || check == '[')
					return false;
			}
			case ']' -> {
				check = stack.pop();
				if (check == '(' || check == '{')
					return false;
			}
			}
		}
		return (stack.isEmpty());
	}

}
