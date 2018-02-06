package com.tigerit.exam;


import static com.tigerit.exam.IO.*;
import  java.util.*;                                                                                                                    ;  
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
    	

    	T = readLineAsInteger();
    	for(int tc = 1; tc <= T; tc++)
    	{
            nT = readLineAsInteger();

            String TableName, ColumnName;
            Integer[][][] DbMat = new Integer[nT][][];
            String[][] ColumnNameList = new String[nT][];
            HashMap<String, Integer> Table = new HashMap<>();
            HashMap<String, Integer> Column = new HashMap<>();

    		for(int it = 0; it < nT; it++)
    		{
                Integer ColumnId=0;
    			TableName = readLine();
                Table.put(TableName, it);


                String tmp = readLine();
                String[] tmpA = tmp.split(" ");
                nC = Integer.parseInt(tmpA[0]);
                nD = Integer.parseInt(tmpA[1]);

    			String ColumnNameLine = readLine();
    			ColumnNameList[it] = ColumnNameLine.split(" ");
                for(String str:ColumnNameList[it]){
                    Column.put(str, ColumnId++);
                }

                DbMat[it] = new Integer[nD][nC];
    			for(int i=0; i<nD; i++)
    			{
                    String tmp2 = readLine();
                    String[] tmpA2 = tmp2.split(" ");
    				for(int j=0; j<nC; j++)
    				{
                        DbMat[it][i][j] = Integer.parseInt(tmpA2[j]);
    				}
    			}
    		}
    		/*for(int it=0; it<nT; it++)
    		{
    			for(int j=0; j<ColumnNameList[it].length; j++)
    			{
    				System.out.print(ColumnNameList[it][j]+" ");
    			}
    			System.out.println();
    			for(int i=0; i<nD; i++)
    			{
    				for(int j=0; j<nC; j++)
    				{
    					System.out.print(DbMat[it][i][j]+" ");
    				}
    				System.out.println();
    			}
    			System.out.println();
    		}*/
    		System.out.println("Test: "+tc);
            nQ = readLineAsInteger();
            for(int q=0; q<nQ; q++)
            {
                HashMap<String, String> table_alias = new HashMap<>();
                Integer t1,t2,c1,c2;

                //selection
                String s = readLine();
                String[] ss = s.split(" |\\,|\\.");
                Integer sl = ss.length;

                /*System.out.println();
                System.out.println(".......SELECTION.........");
                for(String sss: ss){
                	System.out.print(sss+" ");
                }
                System.out.println();*/

                //1st table
                String as = readLine();
                String[] aa = as.split(" ");
                Integer al = aa.length;
                if(al==2) t1 = Table.get(aa[1]);
                else
                {
                    table_alias.put(aa[2], aa[1]);
                    t1 = Table.get(table_alias.get(aa[2]));
                }

                /*System.out.println(".......TABLE1.........");
                for(String aaa: aa){
                	System.out.print(aaa+" ");
                }
                System.out.println();*/


                //2nd table
                String bs = readLine();
                String[] bb = bs.split(" ");
                Integer bl = bb.length;
                if(bl==2) t2 = Table.get(bb[1]);
                else
                {
                    table_alias.put(bb[2], bb[1]);
                    t2 = Table.get(table_alias.get(bb[2]));
                }

                /*System.out.println(".......TABLE2.........");
                for(String bbb: bb){
                	System.out.print(bbb+" ");
                }
                System.out.println();*/

                //condition
                String c = readLine();
                String[] cc = c.split(" |\\.");
                c1=Column.get(cc[2]);
                c2=Column.get(cc[5]);

                /*System.out.println(".......condition.........");
                for(String ccc: cc){
                	System.out.print(ccc+" ");
                }
                System.out.println();*/
			

                if(ss[1].equals("*"))
                {
                	//System.out.println("info------>>>>>"+ss[1]+" table1 = "+t1+" table2 = "+t2);
                    for(int i=0; i<ColumnNameList[t1].length; i++) System.out.print(ColumnNameList[t1][i]+" ");
                    for(int i=0; i<ColumnNameList[t2].length; i++) System.out.print(ColumnNameList[t2][i]+" ");
                    System.out.println();
                }
                for(int i=0; i<DbMat[t1].length; i++)
                {
                    for(int j=0; j<DbMat[t2].length; j++)
                    {                     
                        if(DbMat[t1][i][c1].equals(DbMat[t2][j][c2]))
                        {
                            if(ss[1].equals("*"))
                            {
                                for(int i2=0; i2<DbMat[t1][i].length; i2++) System.out.print(DbMat[t1][i][i2]+" ");
                                for(int j2=0; j2<DbMat[t2][j].length; j2++) System.out.print(DbMat[t2][j][j2]+" ");
                                System.out.println();
                            }   
                        }
                    }
                }
                System.out.println();
            }
    	}
    }
}
