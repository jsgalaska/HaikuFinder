
public class Word {
	private String word;
	private int syllables;
	private char previousVowel;
	private int currentPOS;
	private boolean vowelFound;
	
	public Word(String _word){
		word = _word;
		calcSyllables();
	}
	
	public int getSyllables(){
		return syllables;
	}
	
	public String toString(){
		return word+" ";
	}
	
	//calculates number of syllables in word based on vowels
	private void calcSyllables(){
		vowelFound=false;
		for(int i=0; i<word.length(); i++){
       	 currentPOS = i;
       	 if(isVowel(word.charAt(i))&&vowelFound==false){
       		 if(i==(word.length()-1)&&word.charAt(i)=='e'){
       			 vowelFound = false;
       		 }else{
       			vowelFound = true;
       		 syllables++; 
       		 }
       		 
       	 }else{
       		 vowelFound=false;
       	 }
        }
	}
	
	//checks to see if string ends with e. returns true if it does, false if not
	private boolean endsWithE(String word){
		if(word.charAt(word.length()-1)=='e'){
			return true;
		}
		return false;
	}
	
	//checks if char is a vowel
	private boolean isVowel(char c){
		if(c=='a'||c=='e'||c=='i'||c=='o'||c=='u'||c=='y'){
			previousVowel = c;
			return true;
			}
		return false;
	}
}
