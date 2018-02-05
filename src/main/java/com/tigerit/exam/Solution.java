package com.tigerit.exam;


import static com.tigerit.exam.IO.*;
import  java.util.*                                                                                                                    ;  
/**
 * All of your application logic should be placed inside this class.
 * Remember we will load your application from our custom container.
 * You may add private method inside this class but, make sure your
 * application's execution points start from inside run method.
 */
public class Solution implements Runnable {
    @Override
    public void run() {
        // your application entry point

    	Integer T, nT, nD, nC, d, nQ;
    	String TableName, ColumnName;
    	int[][][] DbMat = new int[][][];
    	

    	T = readLineAsInteger();
    	for(int tc = 1; tc <= T; tc++)
    	{
    		nT = readLineAsInteger();
    		for(int it = 1; it <= nT; it++)
    		{
    			TableName = readLine();
    			nC = readLineAsInteger();
    			nD = readLineAsInteger();
    			ColumnNameLine = readLine();
    			String[] ColumnNameList = ColumnNameLine.split(" ");
    			for(int i=1; i<=nC; i++)
    			{
    				for(int j=1; j<=nD; i++)
    				{
    				}
    			}
    		}
    	}
    }
}
