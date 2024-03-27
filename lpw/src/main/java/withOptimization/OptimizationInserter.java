
package withOptimization;


import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.io.File;
import java.util.ArrayList;
import mongodboperation.Connection;
import mongodboperation.ParallelthreadInserter;
import org.bson.Document;
import util.DatasetReader;


public class OptimizationInserter
{
    
    public ArrayList initiateProcess(String path)
    {
        
        File f=new File(path);
        String fname=f.getName();
        String dbname="datasecurity";
        String collectioname=fname.substring(0, fname.indexOf("."))+"_with_Opti_info";
        
        
        ArrayList attributes = new DatasetReader().getAttributeName(path);
        System.out.println("Attributes List is " + attributes+"\n");

        ArrayList data=new DatasetReader().getDataSetInList(path);
        int size=data.size();
       
        
        ArrayList indices=new DataClassifier().getIndex(size,15);
        
       System.out.println("Total partition Numbers Are: "+size);  
        
       System.out.println("Total partition Are: "+indices);
         
         ArrayList datapartition=new ArrayList();
         
                
         for(int i=0;i<indices.size();i++)
         {
             ArrayList temp1= new ArrayList();
             
             ArrayList temp2=(ArrayList) indices.get(i);
             int x1= (int) temp2.get(0);
             int x2=(int) temp2.get(1);
             
             
             for(int j=x1;j<=x2;j++)
             {
                 ArrayList tempdatarow =(ArrayList) data.get(j);
                 temp1.add(tempdatarow);
             }
           
             datapartition.add(temp1);
             System.out.println(temp1);
         }
         
          ArrayList mapping_thread=new ArrayList();
     
      MongoDatabase  database= new Connection().getConnection("admin", dbname, "1234");
      MongoCollection<Document> collection = database.getCollection(collectioname); 
        
     for(int i=0;i<datapartition.size();i++)
     {
       
         ArrayList single=(ArrayList)datapartition.get(i);
         ParallelthreadInserter  mi=new ParallelthreadInserter();
         mi.setParam(attributes, single, collection);
         
        
         mi.start();
         mapping_thread.add(mi);
          
     }
     
        System.out.println("mapping thread: "+mapping_thread);
     int x=mapping_thread.size();
     
      while(true)
        {
            int count=0;
          
            for(int i=0;i<mapping_thread.size();i++)
            {
               ParallelthreadInserter dt= (ParallelthreadInserter)mapping_thread.get(i);
               if(!dt.isAlive())
               {
                   count++;
               }
                   
            }
            if(x==count)
            {
                 break;
            }
           
        }
      
      ParallelthreadInserter dt1= (ParallelthreadInserter)mapping_thread.get(0);
              long smallt=dt1.time;
     // long smallt=0;
      for(int i=0;i<mapping_thread.size();i++)
            {
              ParallelthreadInserter dt= (ParallelthreadInserter)mapping_thread.get(i);
              long t=dt.time;
//                System.out.println("total time is "+t);
              if(t<smallt)
                  smallt=t;
                   
            }
      ArrayList res=new ArrayList();
      res.add(Integer.toString(data.size()));
      res.add(Long.toString(smallt));
     
        System.out.println("\n\n TOTAL TIME FOR THE DATA INSERTING USING OPTIMIZATION PROCESS IS "+smallt);
        
        return res;
          
    }
}
