package lab07;

public class CS401StackArrayApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final String SHOWNUMBER =  "The number of elements on the stack is " ;
		CS401StackArrayImpl<Character> stackwc = new CS401StackArrayImpl<Character>();
		stackwc.push('a');
		stackwc.push('b');
		stackwc.push('c');
		stackwc.push('d');
		stackwc.push('e');
		stackwc.push('f');
		stackwc.push('g');
		stackwc.push('h');
		stackwc.push('i');
		stackwc.push('j');
		System.out.println(SHOWNUMBER + stackwc.size() + ".");
		stackwc.push('k');
		System.out.println(SHOWNUMBER + stackwc.size() + ".");
		System.out.println("Pop: " +stackwc.pop());
		System.out.println("Pop: " +stackwc.pop());
		Character top = stackwc.pop();
		System.out.println("The topmost: " + top);
		stackwc.push(top);
		System.out.println(SHOWNUMBER + stackwc.size() + ".");
	}

}
