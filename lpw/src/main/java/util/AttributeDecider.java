/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package util;



import java.util.ArrayList;


public class AttributeDecider
{

     public ArrayList getStandardData(ArrayList index, ArrayList data)
    {
        ArrayList  attribute=new ArrayList();
      
         
         
        for (int i = 0; i < index.size(); i++)
        {
            
            ArrayList temp=(ArrayList)index.get(i);
            String attri=(String)temp.get(0);
            int ind=Integer.parseInt((String)temp.get(1));
            
                      
           for (int j = 0; j < data.size(); j++)
        {
            ArrayList row=(ArrayList)data.get(j);
      
              String str=(String)row.get(ind);
             temp.add(str);
             
        }
             
            ArrayList tt=new DuplicateEliminator().getUnique(temp);
             
            ArrayList ttr=new ArrayList();
            
            ttr.add(attri);
            ttr.add(Integer.toString(ind));
            ttr.add(Integer.toString(tt.size()));
          //  System.out.println(ttr);
            
             attribute.add(ttr);
        }
              
        
       attribute=new Sorter().descendingSortData(attribute);
        
        return attribute;
}
}