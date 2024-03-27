/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package util;

import java.util.ArrayList;


public class Sorter

{

  public ArrayList descendingSortData(ArrayList ali) 
  {

        for (int i = 0; i < (ali.size() - 1); i++)// bubble sort
        {
            for (int j = i + 1; j < ali.size(); j++) 
            {

                ArrayList m = new ArrayList();
                ArrayList h = new ArrayList();

                m = (ArrayList) ali.get(i);

                double a = Double.parseDouble(m.get(m.size() - 1).toString());

                h = (ArrayList) ali.get(j);
                double b = Double.parseDouble(h.get(m.size() - 1).toString());

                if (a <= b) {
                    ali.set(i, h);
                    ali.set(j, m);
                }

            }

        }

        return ali;
    }



    



     








 }







