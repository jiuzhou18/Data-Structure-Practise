package lab07;

import java.util.Scanner;

public class CS401ITPApp {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		do{
			Caculate(sc);
			System.out.println("Do you want to quit the system? [Q for quit]");
		}while(!sc.nextLine().toUpperCase().contains("Q"));
		
	}
	
	public static int Caculate(Scanner sc){
		System.out.print("Enter infix string:");
		String input = sc.nextLine();
		String[] infix = input.split(" ");
		String postfix = new String();
		int priority = 0;
		CS401StackLinkedListImpl<Character> operater = new CS401StackLinkedListImpl<Character>();
		for(int i=0; i<infix.length; i++){
			if(infix[i].matches("[0-9]+")){
				postfix += infix[i] + " ";
			}else if (infix[i].matches("[*/]")){
				if (priority > 1){
					while(operater.size()>0){
						postfix += operater.pop() + " ";
					}
				}
				priority = 2;
				operater.push(infix[i].charAt(0));
			}else if (infix[i].matches("[+-]")){
				while(operater.size()>0){
					postfix += operater.pop() + " ";
				}
				operater.push(infix[i].charAt(0));	
				priority = 1;
			}
		}
		while(operater.size()>0)
			postfix += operater.pop() + " ";
		System.out.println("Corresponding postfix string: " + postfix); 
		String[] postsplit = postfix.split(" ");
		CS401StackLinkedListImpl<String> evaluate = new CS401StackLinkedListImpl<String>();
		int a,b;
		for(int i=0; i<postsplit.length; i++){
			if(postsplit[i].matches("[0-9]+")){
				evaluate.push(postsplit[i]);
			}else{
				a = Integer.parseInt(evaluate.pop());
				b = Integer.parseInt(evaluate.pop());
				if(postsplit[i].matches("[+]")) evaluate.push(String.valueOf(b+a));
				if(postsplit[i].matches("[-]")) evaluate.push(String.valueOf(b-a));
				if(postsplit[i].matches("[*]")) evaluate.push(String.valueOf(b*a));
				if(postsplit[i].matches("[/]")) evaluate.push(String.valueOf(b/a));			
			}
		}
		a = Integer.parseInt(evaluate.pop());
		System.out.println("Evaluation of postfix string: " + a);
		return a;
	}
	

}
