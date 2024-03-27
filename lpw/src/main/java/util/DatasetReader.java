package util;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */



import java.io.*;
import java.util.ArrayList;
import jxl.*; /* Import declarations to the JExcel JAR file */
public class DatasetReader /* The name of our class file */
{
  
    public ArrayList getDataSetInList(String path)
    {
        ArrayList m=new ArrayList();
        
      

      try
        {
            Workbook ReadExcel = Workbook.getWorkbook(new File(path));
            Sheet sheet = ReadExcel.getSheet(0);
            int a=sheet.getColumns();
            int b=sheet.getRows();
                    
            for (int i=1;i<b;i++)
            {
                ArrayList in=new ArrayList();
               
                for(int j=0;j<a;j++)
                {

               

                Cell a1 = sheet.getCell(j,i); /* Get the first cell of Column A , 0 maps to A */

                String ed = a1.getContents();
                ed=ed.trim();
                if(ed.length()==0)
                {
                    ed="NILL";
                }
                
              

                in.add(ed);
                }
                m.add(in);
               
            }
              ReadExcel.close();
            }
        catch (Exception i)
        {
            System.out.println("Exception is "+i);
        }

        return m;
        
    }
    
    
    
    public ArrayList getAttributeName(String path)
    {
        ArrayList m=new ArrayList();

      try
        {
            Workbook ReadExcel = Workbook.getWorkbook(new File(path));
            Sheet sheet = ReadExcel.getSheet(0);
            int a=sheet.getColumns();
            int b=sheet.getRows();
                    
            for (int i=0;i<1;i++)
            {
                ArrayList in=new ArrayList();
                for(int j=0;j<a;j++)
                {

               

                Cell a1 = sheet.getCell(j,i); /* Get the first cell of Column A , 0 maps to A */

                String ed = a1.getContents();
                ed=ed.trim();
             
                m.add(ed);
                }
           
               
            }
              ReadExcel.close();
            }
        catch (Exception i)
        {
            System.out.println("Exception is "+i);
        }

        return m;
        
    }
    
     public ArrayList geIndex(String path,ArrayList attribute)
    {
       
        ArrayList index=new ArrayList();

      try
        {
            Workbook ReadExcel = Workbook.getWorkbook(new File(path));
            Sheet sheet = ReadExcel.getSheet(0);
            int a=sheet.getColumns();
            int b=sheet.getRows();
                    
            for (int i=1;i<2;i++)
            {
               
                for(int j=0;j<a;j++)
                {
                Cell a1 = sheet.getCell(j,i); /* Get the first cell of Column A , 0 maps to A */
                String ed = a1.getContents();
                ed=ed.trim();
                if(isDigit(ed))
                {
                    ArrayList temp=new ArrayList();
                    temp.add((String)attribute.get(j));
                    temp.add(Integer.toString(j));
                    index.add(temp);
                    
                }
                //value.add(ed);
                }
                       
            }
              ReadExcel.close();
              
            }
        catch (Exception i)
        {
            System.out.println("Exception is "+i);
        }

      
      
      
       
        return index;
        
    }
     
     public boolean isDigit(String str)
     {
         boolean flag=false;
         if(str.contains("."))
         {
             try
             {
                 Double.parseDouble(str);
                 flag=true;
                 
             }
             catch(Exception ex)
             {
                 flag=false;
             }
             
         }
         else
         {
              try
             {
                 Integer.parseInt(str);
                 flag=true;
                 
             }
             catch(Exception ex)
             {
                 flag=false;
             }
             
         }
         
         
         
         return flag;
     }
}