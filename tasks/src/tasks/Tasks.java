/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tasks;

import java.util.*;

public class Tasks {

     //Решение первой задачи двумя способами
   
    public static int[] sort(int[] array){
        Arrays.sort(array);
        int n = array.length;
        int[] answer = new int[3];
        for(int i = 0; i < 3; i++){
            answer[i] = array[n - 1 - i];
        }
        return answer;
    }
    
    public static int[] sort2(int[] array){
        int n = array.length;
        int[] answer = new int[3];
        int max1 = 0, max2 = 0, max3 = 0;
        for(int i = 0; i < n; i++){
            if (array[i] > max1){
                max3 = max2;
                max2 = max1;
                max1 = array[i];
            } else{
                if (array[i] > max2){
                    max3 = max2;
                    max2 = array[i];
                } else {
                    if(array[i] > max3){
                        max3 = array[i];
                    }
                }
            }
        }
        answer[0] = max1;
        answer[1] = max2;
        answer[2] = max3;
        return answer;
    }
    
    // Решение второй задачи
    public static int sumOfDigits(int number){
        int sum = 0;
        number = Math.abs(number);
        while (number != 0){
            sum += number % 10;
            number /= 10;
        }
        return sum;
    }
    
    
    // Решение третьей задачи
    public static void partitionProblem(int[] array, int countgroups){
        int n = array.length;
        double countmask = Math.pow(countgroups, n);
        
        
        for (int i = 0; i < countmask; i++){
            int[] mask = new int[n];
            int[] sumgroup = new int[countgroups];
            int sum = 0;
            int masknum = i;
            for (int j = 0; j < n; j++){
                
                mask[j] = masknum % countgroups;
                masknum /= countgroups;
            }
            
            for (int j = 0; j < n; j++){
                sumgroup[mask[j]] += array[j];
                sum += array[j];
            }
            
           
            
            int flag = 0;
            for (int j = 0; j < countgroups; j++){
                if (sumgroup[j] * countgroups != sum){
                    flag = 1;
                    break;
                }
            }
            
            if (flag == 0){               
                ArrayList<ArrayList<Integer>> groups = new ArrayList<ArrayList<Integer>>();
                
                for (int j = 0; j < countgroups; j++){
                    ArrayList<Integer> empty = new ArrayList<Integer>();
                    groups.add(empty);
                }
                
                for (int j = 0; j < n; j++){
                    groups.get(mask[j]).add(array[j]);                                     
                    //System.out.println(groups.get(mask[j]));
                }
                
                for (int j = 0; j < countgroups; j++){
                    System.out.println(groups.get(j));
                }
                
                return;
            }
        }
        
        System.out.println("Решения нет");
    }
    
    
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        
        // Для проверки первой задачи
        /*
        int a[] = {1, 2, 3, 6, 7, 9, 12, 53, 67, 56, 34, 3, 2, 9, 76};
        int[] t = new int[3];
        t = sort(a); // или t = sort2(a);
        for (int i = 0; i < 3; i++){
            System.out.print(t[i] + " ");
        } 
        */
        
        
        
        // Для проверки второй задачи
        /*
        int n = scanner.nextInt();
        System.out.print(sumOfDigits(n));
        */
        
        //Для проверки третьей задачи 
        
        int b[] = {1, 4, 5, 8, 12, 4, 23, 34, 21, 14, 18, 19, 25};
        int c[] = {1, 1, 1, 2, 3};
        partitionProblem(b, 4);     
    }
}
