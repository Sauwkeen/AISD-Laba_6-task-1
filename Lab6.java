//var 6 | DKrishen
import java.util.Scanner;

 public class Lab6{	
	public static void firstQueuePrint(){
		System.out.println();
		System.out.println("\t<====================X====================>");
		System.out.println("\t1 - add a student to the retake queue   - 1");
		System.out.println("\t2 - send student to retake              - 2");
		System.out.println("\t3 - print queue                         - 3");
		System.out.println("\t4 - add a top exam ticket               - 4");
		System.out.println("\t5 - add a lower exam ticket             - 5");
		System.out.println("\t6 - add a exem task                     - 6");
		System.out.println("\t9 - program shutdown                    - 9");
		System.out.println("\t<====================X====================>");
		System.out.println();
	}
	public static void examTicketsPrint(){
		System.out.println();
		System.out.println("\t<====================X====================>");
		System.out.println("\t1 - choose the top exam ticket          - 1");
		System.out.println("\t2 - choose a lower exam ticket          - 2");
		System.out.println("\t9 - program shutdown                    - 9");
		System.out.println("\t<====================X====================>");
		System.out.println();
	}
	public static void examTaskPrint(){
		System.out.println();
		System.out.println("\t<====================X====================>");
		System.out.println("\t1 - choose the exam task                - 1");
		System.out.println("\t9 - program shutdown                    - 9");
		System.out.println("\t<====================X====================>");
		System.out.println();
	}
	public static void examPrint(){
		System.out.println();
		System.out.println("\t<====================X====================>");
		System.out.println("\t1 - student passed the exam             - 1");
		System.out.println("\t2 - send for retake 			          - 2");
		System.out.println("\t9 - program shutdown                    - 9");
		System.out.println("\t<====================X====================>");
		System.out.println();
	}
	public static void main(String[] args){
		Queue queue = new Queue();
		Stack stack = new Stack();
		Deck  deck  = new Deck();

		String tempStack = "";
		String tempDeck = "";
		String tempQueue = "";

		Scanner in = new Scanner(System.in);
		char controlButton;  

		while(true){
			firstQueuePrint();
			System.out.print(":>> ");
			controlButton = in.next().charAt(0);


			switch (controlButton) {
           	case  ('1'):////////////////////////////////////////////////////////////////////////////////////////////////////
           		System.out.print("Enter a student name :>> ");
               	queue.insert(in.next());
				          
				System.out.println("\n\t<student add successfully>");
               	break;
           	case ('2'):////////////////////////////////////////////////////////////////////////////////////////////////////
           		tempQueue = queue.remove();
           		Boolean run = true;
           		while(run){
					examTicketsPrint();
					System.out.print(":>> ");
					controlButton = in.next().charAt(0);
					switch (controlButton){
					case  ('1'):
						tempDeck = deck.removeRight();
						System.out.println("\nselected exam ticket: " + tempDeck);						
						System.out.println("\n\t<exam ticket select successfully>");
						run = false;          
               			break;
           			case ('2'):	
           				tempDeck = deck.removeLeft();    
						System.out.println("\nselected exam ticket: " + tempDeck);
						System.out.println("\n\t<exam ticket select successfully>");
           				run = false;      
		           		break;
		           	case ('9'):////////////////////////////////////////////////////////////////////////////////////////////////////
		           	    System.out.println("\t<Program shutdown>\n");
		           		System.exit(0);
		              	break;
		           	default:////////////////////////////////////////////////////////////////////////////////////////////////////
		               	System.out.println("\t<ERROR> unknown button <ERROR>");
		               break;
					}
				}
				run = true;
				while(run){
					examTaskPrint();
					System.out.print(":>> ");
					controlButton = in.next().charAt(0);
					switch (controlButton){
					case  ('1'):
						tempStack = stack.pop();
						System.out.println("\nselected exam task: " + tempStack);
						System.out.println("\n\t<exam task select successfully>");
						run = false;
               			break;
		           	case ('9'):////////////////////////////////////////////////////////////////////////////////////////////////////
		           	    System.out.println("\t<Program shutdown>\n");
		           		System.exit(0);
		              	break;
		           	default:////////////////////////////////////////////////////////////////////////////////////////////////////
		               	System.out.println("\t<ERROR> unknown button <ERROR>");
		               break;
					}
				}
				run = true;
				while(run){
					examPrint();
					System.out.print(":>> ");
					controlButton = in.next().charAt(0);
					switch (controlButton){
					case  ('1'):
						System.out.println("Good job, student!");
						run = false;
               			break;
					case  ('2'):
						System.out.println("Sauwkeen, go to learn!");
						queue.insert(tempQueue);
						run = false;
               			break;
		           	case ('9'):////////////////////////////////////////////////////////////////////////////////////////////////////
		           	    System.out.println("\t<Program shutdown>\n");
		           		System.exit(0);
		              	break;
		           	default:////////////////////////////////////////////////////////////////////////////////////////////////////
		               	System.out.println("\t<ERROR> unknown button <ERROR>");
		               break;
					}
					stack.push(tempStack);
					deck.insertLeft(tempDeck);
				}
               break;
           	case ('3'):////////////////////////////////////////////////////////////////////////////////////////////////////
				System.out.print("first: "); queue.printFirst();
				System.out.print("\nlast: ");  queue.printLast();
               	break;
           	case ('4'):// select //////////////////////////////////////////////////////////////////////////////////////////////////
           		System.out.print("Enter a exam ticket :>> ");
               	deck.insertRight(in.next());
				          
				System.out.print("top: "); deck.printRight();
				System.out.print("\nlower: ");  deck.printLeft();
				System.out.println("\n\t<exam ticket add successfully>");
           		break;
           	case ('5'):// insert //////////////////////////////////////////////////////////////////////////////////////////////////
           		System.out.print("Enter a exam ticket :>> ");
               	deck.insertLeft(in.next());
				          
				System.out.print("\ntop: "); deck.printRight();
				System.out.print("\nlower: ");  deck.printLeft();
				System.out.println("\n\t<exam ticket add successfully>");
           		break;
           	case ('6'):// bubble //////////////////////////////////////////////////////////////////////////////////////////////////
           		System.out.print("Enter a exam task :>> ");
               	stack.push(in.next());
				          
				System.out.print("\n\ttop: ");  stack.print();
				System.out.println("\n\t<exam task add successfully>");		       
           		break;
           	case ('9'):////////////////////////////////////////////////////////////////////////////////////////////////////
           	    System.out.println("\t<Program shutdown>\n");
           		System.exit(0);
              	break;
           	default:////////////////////////////////////////////////////////////////////////////////////////////////////
               	System.out.println("\t<ERROR> unknown button <ERROR>");
               break;
       		}
		}

	}
}