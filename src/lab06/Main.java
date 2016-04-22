package lab06;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * @author antonio081014
 * @time Jul 5, 2013, 9:31:10 PM
 */
public class Main {

	static AVLTree<String> tree;

	public static void main(String[] args)
	{
		readInFromTxtFile();
		
		searchAndStepsTaken();
		//doAnInorderTraversal();
		
		//inputSpanishWordGetEnglishMeaningBack();
	}

	public static void readInFromTxtFile()
	{
		try {
			File file = new File("SpanishWords.txt");

			FileReader fileReader = new FileReader(file);

			BufferedReader bufferedReader = new BufferedReader(fileReader);

			// add line by line to tree:
			tree = new AVLTree<String>();

			String line;

			while ((line = bufferedReader.readLine()) != null) {
				// \\s+ means all types of white space and any amount
				// my splitArrays has: the two+ tokens in it starting from 0 to no. of single words-1.

				String[] splitArrays = line.split("[ \t]");
				
				//String theEnglishMeaning = ;
				
				tree.insert(splitArrays[0].substring(0, splitArrays[0].length()-1), splitArrays[1]);
				System.out.println(splitArrays[0].substring(0, splitArrays[0].length()-1) + "=" + splitArrays[1]);
			}
			fileReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void removeAPairing()
	{
		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter the new spanish below that you would like to remove:");
		String theSpanishWord = scanner.nextLine();

		//String wordsCombined = theSpanishWord + "	" + theEnglishWord; // the space you see is a table

		//before u delete it, check if it actually exists...
		if (tree.search(theSpanishWord) == true)
		{
			Node<String> theNodeToBeDeleted = tree.search2(theSpanishWord);
			System.out.println("yes the word exists.. you can delete it....");
			
			tree.delete2(theNodeToBeDeleted);
			System.out.println("The node has been deleted.");
		}
		else // if (tree.search(wordsCombined) == false) .. the word is not already existing....
		{
			// make a new node...
		
			// I can't simple add a node with no children... how will it relate to the tree?
			//Node<String> brandNewNode = new Node(theSpanishWord, theEnglishWord);
			
			System.out.println("The word doesn't even exist to be deleted.");
			tree.PrintTree();
		}
		scanner.close();
	}
	
	public static void allowUserToAddAnotherPairing()
	{
		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter the new  spanish below and press enter:");
		String theSpanishWord = scanner.nextLine();

		System.out.println("Enter the corresponding english translation of that spannish word below and press enter:");
		String theEnglishWord = scanner.nextLine();

		//String wordsCombined = theSpanishWord + "	" + theEnglishWord; // the space you see is a table

		//before u add it check if it already exists...
		if (tree.search(theSpanishWord) == true)
		{
			System.out.println("Sorry, that word already exists, you cannot add it.");
		}
		else // if (tree.search(wordsCombined) == false) .. the word is not already existing....
		{
			// make a new node...
		
			// I can't simple add a node with no children... how will it relate to the tree?
			//Node<String> brandNewNode = new Node(theSpanishWord, theEnglishWord);
			
			tree.insert(theSpanishWord, theEnglishWord);
			
			System.out.println("Your new spanish word - english word pair has been added, thank you.");
			tree.PrintTree();
		}
		scanner.close();
	}

	public static void inputSpanishWordGetEnglishMeaningBack()
	{
		Scanner scanner = new Scanner(System.in);

		System.out.println("Please input the spanish word which you want the english translation for:");

		String theSpanishWord = scanner.nextLine();
		
		Node<String> theNodeWithThatSpanishWordAsDataOne = tree.search2(theSpanishWord);
		
		// from that node take the english word our of it
		
		String theEnglishWord = theNodeWithThatSpanishWordAsDataOne.getData2();
		
		System.out.println("The english translation for the word you inputted is:" + theEnglishWord);

		System.out.println("tree.PrintTree()");
		// now i have the spanish word, how do i get back the english
		
		System.out.println("The no. of traversals to find that english pairing... " + tree.getTrav());
		
		scanner.close();
	}
	
	public static void doAnInorderTraversal()
	{
		// this is the method which gives back in alphabetical order the words (ordered by spanish word).
		System.out.println(" Here is all the words: listed aplphabetically:");
		// pass in the root..
		tree.inOrderTraversal(tree.getRoot());
	}
	
	public static void searchAndStepsTaken()
	{
		Scanner scanner = new Scanner(System.in);

		System.out.println("Please input the spanish word which you want the english translation for:");

		String theSpanishWord = scanner.nextLine();
		
		Node<String> theNodeWithThatSpanishWordAsDataOne = tree.search2(theSpanishWord);

		int noOfDepth = tree.getTrav();
		
		System.out.println(theNodeWithThatSpanishWordAsDataOne.data2 + noOfDepth);
		
		scanner.close();
	}

	// Find the meaning of a Spanish word entered from the keyboard, if it exists. 
	public void checkIfAWordExits()
	{
		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter the english word w below:");	
	}
}