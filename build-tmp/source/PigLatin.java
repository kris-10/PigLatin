import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class PigLatin extends PApplet {



public void setup() {
	String lines[] = loadStrings("words.txt");
	System.out.println("there are " + lines.length + " lines");
	for (int i = 0 ; i < lines.length; i++) {
		System.out.println(pigLatin(lines[i]));
	}
}
public void draw()
{
}

public int findFirstVowel(String word)
{
	int index=0; 

	for(int i=0;i<word.length();i++)
	{
		
		if(word.charAt(i)=='a'||word.charAt(i)=='e'||word.charAt(i)=='i' ||word.charAt(i)=='o' ||word.charAt(i)=='u')
		{
			index=i;
			break;
		}
		else 
		{
			index=-1;
		}
	}
	
	return index;  
}


public String pigLatin(String sWord)
//precondition: sWord is a valid String of length greater than 0
//postcondition: returns the pig latin equivalent of sWord
{
	for (int i=0;i<sWord.length();i++)
	{
		if(sWord.charAt(0)=='q')
		{
			return sWord.substring(2) + "quay";
		}
	}
	
	if(findFirstVowel(sWord) == -1)
	{
		return sWord + "ay";
	}
	
	if(findFirstVowel(sWord) == 0)
	{
		return "sWord" + "way";
	}
	if(findFirstVowel(sWord) != -1 && findFirstVowel(sWord) != 0)
	{
		return sWord.substring(findFirstVowel(sWord)) + sWord.substring(0, findFirstVowel(sWord)) + "ay";
	}
	else
	{
		return "ERROR!";
	}
}
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "PigLatin" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
