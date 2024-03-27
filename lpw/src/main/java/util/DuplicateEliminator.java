/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package util;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;


public class DuplicateEliminator 
{
 
    public ArrayList getUnique(ArrayList aa)
    {
        
        
          Set hh1=new HashSet();
              hh1.addAll(aa);
             aa.clear();
             aa.addAll(hh1);
             //System.out.println(aa);
             
             return aa;
    }
    
}
