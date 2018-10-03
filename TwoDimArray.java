import java.util.Scanner;
import java.util.TreeSet;


public class TwoDimArray {
	private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int [][] input = new int [6][6]; 
        int [][] hourGlass = new int [3][3]; 
        TreeSet <Integer> outputList = new TreeSet<Integer>();
        
        for(int i=0;i<6;i++){
            String [] row = scanner.nextLine().split(" ");
            for(int j=0;j<6;j++){
                input[i][j] = Integer.parseInt(row[j]);
            }
        }
        
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                hourGlass[0] = new int[] {input[i][j],input[i][j+1],input[i][j+2]};
                hourGlass[1] = new int[] {input[i+1][j],input[i+1][j+1],input[i+1][j+2]};
                hourGlass[2] = new int[] {input[i+2][j],input[i+2][j+1],input[i+2][j+2]};
                
                int sum = getSumOfHourGlass(hourGlass);
                outputList.add(sum);
            }
        }
        
        System.out.println(outputList.last());
        scanner.close();
    }
    
    
    
    public static int getSumOfHourGlass(int [][] arr){
        int sum = 0;
        
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if((i == 1 && j == 0) || (i == 1 && j == 2)){
                    continue;
                }
                sum = sum + arr[i][j];
            }
        }
        return sum;
    }

}
