import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class Main {
	protected ArrayList<Word> allWords = new ArrayList<Word>();
	protected ArrayList<Word> firstLine = new ArrayList<Word>();
	protected ArrayList<Word> secondLine = new ArrayList<Word>();
	protected ArrayList<Word> thirdLine = new ArrayList<Word>();
	private Word word;
	private String everything;
	int firstRow = 0;
	int secondRow = 0;
	int thirdRow = 0;
	
	public Main() throws IOException{
		readFile("TomSawyer.txt");
		doStuff(everything);
		checkHaiku(allWords);
	}
	public static void main(String[] args) throws IOException {
		new Main();
	}

	//Reads a text file in and puts it in a string called everything
	public void readFile(String fileName) throws IOException{
		BufferedReader br = new BufferedReader(new FileReader(fileName));
    	try {
    		StringBuilder sb = new StringBuilder();
    		String line = br.readLine();

    		while (line != null) {
    			sb.append(line);
    			sb.append(' ');
    			line = br.readLine();
    		}
    		everything = sb.toString();
    	} finally {
    		br.close();
    	}
	}
	
	//prints a line of the haiku
	public void printList(ArrayList<Word> list){
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<list.size(); i++){
			sb.append(list.get(i).toString());
		}
		String line = sb.toString();
		System.out.println(line);
	}
	
	//breaks up the string and adds each word as a Word to the allWords arraylist
	public void doStuff(String message){
		String[] test;
		int i = 0;
		test = everything.split(" ");
		while(i<test.length){
			word = new Word(test[i]);
			allWords.add(word);
			i++;
		}
	}
	
	//clears the three lines in haiku
	public void clear(){
		firstLine.clear();
		secondLine.clear();
		thirdLine.clear();
		firstRow=0;
		secondRow=0;
		thirdRow=0;
	}
	
	//iterates through the arraylist of words to find haikus. When one is found it is printed out.
	public void checkHaiku(ArrayList<Word> list){
		firstRow = 0;
		secondRow = 0;
		thirdRow = 0;
		int j = 0;
			while(j<list.size()){
				int temp = list.get(j).getSyllables();
				if(firstRow<5){
					//System.out.println("<5");
					if(firstRow+temp<=5){
						firstLine.add(list.get(j));
						firstRow=firstRow+temp;
					}else{
						clear();
					}
				}else if(firstRow==5&&secondRow<7){
					//System.out.println("<57");
					if(secondRow+temp<=7){
						secondLine.add(list.get(j));
						secondRow=secondRow+temp;
						}else{
							clear();
						}
				}else if(firstRow==5&&secondRow==7&&thirdRow<5){
					//System.out.println("<575");
					if(thirdRow+temp<=5){
						thirdLine.add(list.get(j));
						thirdRow=thirdRow+temp;
					}else{
						clear();
					}
				}else if(firstRow==5&&secondRow==7&&thirdRow==5){
					System.out.println("\nHaiku");
					printList(firstLine);
					printList(secondLine);
					printList(thirdLine);
					firstLine.clear();
					secondLine.clear();
					thirdLine.clear();
					firstRow=0;
					secondRow=0;
					thirdRow=0;
					if(firstRow+temp<=5){
						firstLine.add(list.get(j));
						firstRow=firstRow+temp;
					}
				}else{
					clear();
				}
				j++;
			}
			
	}
	
	
}
