//  Author: Nick Salerni
//  Copyright (c) 2014. All rights reserved.
//
// The following Java program finds the missing value in a list of ordered numbers.
// The numbers must be using an addition pattern.
//
// USAGE: Enter the number of values you will be entering, followed by a new line.
//		  Then, enter the n numbers separated by spaces or new line characters.

import java.io.*;
import java.util.Scanner;

public class PatternFinder
{
    public static void main(String args[])
    {
        Scanner scan = new Scanner(System.in);
        
        int N = scan.nextInt();
        
        int difference_array[] = new int[N - 1]; // Array which hold the differences in between values.
        int num_array[] = new int[N];            // Array which holds the numbers entered by the user.
        
        int diff_index = -1;
        
        for (int i = 0; i < N; i++)
        {
            num_array[i] = scan.nextInt();       // Reads values in from keyboard.
        }
        
        for (int i = 0; i < N -1; i++)
        {
            difference_array[i] = num_array[i+1] - num_array[i];
        }
        
        int first = difference_array[0];
        int second = difference_array[1];
        
        for (int i = 2; i < N -1; ++i)
        {
            if (first == second)
            {
				if (first != difference_array[i])
				{
					diff_index = i;
					break;
				}
                
            }
            
            else if (first != difference_array[i])
            {
                diff_index = i - 2;
                break;
            }
            
            else
            {
                diff_index = i - 1;
                break;
            }
            
            first = second;
            second = difference_array[i];
        }
        
        System.out.println("Missing value in the pattern is: " + (num_array[diff_index] + difference_array[(diff_index == 1) ? 0 : 1])); // Prints the missing value in the pattern.
    }
}