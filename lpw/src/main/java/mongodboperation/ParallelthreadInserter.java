/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mongodboperation;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.util.ArrayList;
import org.bson.Document;


public class ParallelthreadInserter extends Thread
{

    public ArrayList attribute;
    public ArrayList mas;
    public  long time = 0;
    public  MongoCollection<Document> collection;
    
    
    
    public void setParam(ArrayList attribute,ArrayList mas,MongoCollection<Document> collection)
    {
      
        this.attribute=attribute;
        this.mas=mas;
        this.collection=collection;
        
        
    }
    
    public void run()
    {
         long start=System.currentTimeMillis();
        
    //  System.out.println("Collection sampleCollection selected successfully");
      
     
       Document d=null;
        for (int i = 0; i < mas.size(); i++)
        {
            d=new Document();
            ArrayList row=(ArrayList)mas.get(i);
            for (int j = 0; j < row.size(); j++) 
            {
             String attri=(String)attribute.get(j);
            String value=(String)row.get(j);
            d.append(attri, value);
            }
          
              collection.insertOne(d); 
              
        }
       long end=System.currentTimeMillis();
       time=end-start;
     // System.out.println("Document inserted successfully "+time+ " - "+mas.size());  
      

     
    }
}
