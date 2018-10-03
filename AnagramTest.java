import java.util.Scanner;


public class AnagramTest {

	public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String a = scan.next();
        String b = scan.next();
        scan.close();
        boolean ret = isAnagram(a, b);
        System.out.println( (ret) ? "Anagrams" : "Not Anagrams" );
    }
	
	
	static boolean isAnagram(String a, String b) {
		if(a.length() != b.length()){
			return false;
		}else{
			int [] frequency1 = new int[a.length()];
			char[] charArray1 = a.toCharArray();
			//char[] tempcharArray1 = new char[a.length()];
			String tempcharArray1 = "";
			int k = 0;
			for(int i=0;i<charArray1.length;i++){
				
				char ch = charArray1[i];
				if(!tempcharArray1.contains(String.valueOf(ch))){
					int charCount = 1;
					for(int j=i+1;j<charArray1.length;j++){
						if(ch == charArray1[j]){
							charCount++;
						}
					}
					frequency1[k++] = charCount;
					tempcharArray1 = tempcharArray1 + ch;
					System.out.print(charCount);
					System.out.print(" ");
				}
			}
			System.out.println(tempcharArray1);
			
			int [] frequency2 = new int[b.length()];
			char[] charArray2 = b.toCharArray();
			String tempcharArray2 = "";
			k = 0;
			for(int i=0;i<charArray2.length;i++){
				
				char ch = charArray2[i];
				if(!tempcharArray2.contains(String.valueOf(ch))){
					int charCount = 1;
					for(int j=i+1;j<charArray2.length;j++){
						if(ch == charArray2[j]){
							charCount++;
						}
					}
					frequency2[k++] = charCount;
					tempcharArray2 = tempcharArray2 + ch;
					System.out.print(charCount);
					System.out.print(" ");
				}
			}
			System.out.println(tempcharArray2);
			
			tempcharArray1 = tempcharArray1.toUpperCase();
			tempcharArray2 = tempcharArray2.toUpperCase();
			
			for(int i=0;i<tempcharArray1.length();i++){
				int frequencyCount1 = frequency1[i];
				String indexStr = String.valueOf(tempcharArray1.charAt(i));
				int index2 = tempcharArray2.indexOf(indexStr);
				if(index2 == -1){
					return false;
				}else{
					int frequencyCount2 = frequency2[index2];
					if(frequencyCount1 != frequencyCount2){
						return false;
					}
				}
			}
		}
		return true;
    }

}
