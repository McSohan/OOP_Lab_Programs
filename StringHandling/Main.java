import java.util.Scanner;
import java.util.ArrayList;

public class Main {

    public static String swapPythonJava (String string)
    {
        //returns the processed string
        int start, stop;
        start = string.indexOf("python");
        stop = start+6;
        if (start == -1)
            return string.replace("java", "python");
        else
            return string.substring(0,start).replace("java", "python")+"java"+swapPythonJava(string.substring(stop));
    }
    public static void main(String[] args)
    {
	    //String str;
	    String ch;
	    ArrayList<String> al = new ArrayList<String>();
        Scanner s = new Scanner (System.in);
	    System.out.println ("Enter a string of colours:");
	    al.add( s.nextLine());//read in a string successfully
        String stringArray[] = al.get(0).split(" ");
        System.out.println ("Enter a another string:");
        al.add( s.nextLine());//read in a string successfully
        System.out.println ("Original string: "+al.get(0));
        try {
            System.out.println("Second last word: " + stringArray[stringArray.length - 2]);
        }catch (ArrayIndexOutOfBoundsException aiobe)
        {
            System.out.println ("String does not contain enough words!!");
            aiobe.printStackTrace();
        }
        System.out.println ("Changing python, java: "+swapPythonJava (al.get(1)));
        System.out.println ("Enter the separator:");
        ch = s.next();
        stringArray = al.get(1).split(ch);
        System.out.println (ch+" sepatated substrings:");
        for (String subs:stringArray)
            System.out.println (subs);
    }
}
