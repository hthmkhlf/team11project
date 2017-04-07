public class RecursionTest{

  public static int getVowels(String aString){
    if (aString.equals("") ) return 0;
    int numV = getVowels(aString.substring(1));
    if (aString.charAt(0) == 'a'){
      numV++;
    }else if(aString.charAt(0) == 'e'){
      numV++;
    }else if (aString.charAt(0) == 'i'){
      numV++;
    }else if (aString.charAt(0) == 'o'){
      numV++;
    }else if (aString.charAt(0) == 'u'){
      numV++;
    }
    return numV;
  }

  public static void main(String[] args){
   String s = args[0];
   int nums = getVowels(s);
   System.out.println(nums);
  }
}
