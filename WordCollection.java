/*
A WordCollection, shown in the class declaration below, stores a group of 
words, sorted in ascending order. 

The collection may store multiple instances of any word. 
*/

import java.util.ArrayList;

public class WordCollection{

    private ArrayList<String> _collection;
       
    // constructor
    // postcondition: creates an empty WordCollection
    public WordCollection(){  
	_collection = new ArrayList<String> ();
    }

    //postcondition: Copys from the String[] to the WordCollection
    public WordCollection(String [] words){   
	_collection = new ArrayList<String> ();
	for(int i = 0; i < words.length; i++)
	    insert(words[i]);
	
    }

    // returns the total number of items stored in the collection
    public int size() {
	return _collection.size();
    }

    // returns kth word in alphabetical order, where
    // 0 ≤ k < size()
    public String findKth(int k) {
	return _collection.get(k);
    }
    // O(n)
    // adds word to the collection (duplicates allowed) by maintaining
    // a sorted(ascending) list of words.
    public void insert(String word){
	int pos = size();
	for(int i = 0 ; i < size(); i++){
	    if (word.compareTo(findKth(i)) <= 0){
		pos = i;
		break;
	    }
	}
	_collection.add(pos,word);
	
    }
    // O(n)
    // returns the index of the first occurrence of word in the collection
    // returns -1 if not found.
    public int indexOf(String word){
	for (int i = 0 ; i < size() ; i++)
	    if (findKth(i).equals(word))
		return i;
	return -1;
    }
    // O(n)
    // removes one instance of word from the collection if word is
    // present; otherwise, does nothing
    public void remove(String word){
	int index = indexOf(word);  // O(n)
	if (index == -1) return;
        _collection.remove(index); // O(n)
    }
  
    public String toString(){
	return _collection.toString();
    }

    public static void main(String [] args){
	String [] words = {"cat","bat","dog","ape","zebra","dog","cat"};
	WordCollection wc = new WordCollection(words);
	System.out.println("Size: " + wc.size());
	System.out.println("index of cat: " + wc.indexOf("cat"));
	System.out.println("remove cat");
	wc.remove("cat");
	System.out.println("collection: " + wc);
    }


}

/*
Part I:
=======
  i. Implement the constructor WordCollection().                            .
 ii. Implement the insert method. Classify the runtime complexity.
iii. Implement the overloaded constructor WordCollection(String []).
 iv. Implement the indexOf method. Classify the runtime complexity.
  v. Implement the remove method. Classify the runtime complexity.


Part II: AP Questions
========

(a) Write free function occurrences, as started below. occurrences returns the
    number of times that word appears in WordCollection C. If word is not in C,
    occurrences should return 0.
    
    In writing occurrences, you may call any of the member functions of the 
    WordCollection class.

    Assume that the member functions work as specified.
    Complete function occurrences below.
    public static int occurrences(WordCollection C, String  word)
    // postcondition: returns the number of occurrences of word in C
    */

	public static int occurrences(WordCollection C, String  word){
		int counter = 0;
		for (int i = C.indexOf(word); i < C.size(); i++){
			if (word.equals(C.findKth(i))) 
				counter++;
			else break;
		}
		return counter;
}

/*

(b) Write free function removeDuplicates, as started below. removeDuplicates 
    removes all but one occurrence of word from C. If word is not in collection
    C, then removeDuplicates does nothing.


In writing removeDuplicates, you may call function occurrences specified in
part (a). Assume that occurrences works as specified, regardless of what you
wrote in part (a).

Complete function removeDuplicates below.
	 public static void removeDuplicates(WordCollection C, String word)
	 // postcondition: if word is present in C, all but one occurrence
	 //is removed; otherwise, C is unchanged
*/

public static void removeDuplicates(WordCollection C, String word){
    int occur = C.occurrences(C,word);
    if (occur > 1){
	for (int i = 0; i < occur; i++)
	    C.remove(word); 
    }
		
}

/*
(c) Write free function mostCommon, as started below. mostCommon returns the
    word that appears most often in the collection. If there is more than one
    such word, return any one of them. You may assume that C is not empty.

    In writing mostCommon, you may call function occurrences specified in part
    (a). Assume that occurrences works as specified, regardless of what you
    wrote in part (a).

    Complete function mostCommon below.
 
    // precondition: C is not empty
    // postcondition: returns the word that appears most often in C;
    //if there is more than one such word, returns any one of those words
    public static String mostCommon( WordCollection  C)

*/

public static String mostCommon( WordCollection  C){
    String most = C.findKth(0);
    for (int i = 1; i < C.size(); i++){
	if (C.occurrence(C, C.indexOf(i)) > C.occurrences(C, C.indexOf(i-0)))
	    most = C.indexOf(i);
    }
    return most;
}



