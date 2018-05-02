/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hiddenmarkovmodel;

import java.util.Arrays;

/**
 *
 * @author Fighter
 */

public class HMM {
    
    int count=0;
    int numOfObservations = 3; 
    String[] observations = new String[] {"3","1","3"};
    
    int numOfEmmissionsType = 3;
    String[] emmissionName = new String[] {"1","2","3"};
    
    int numOfStates = 4;
    String[] statesName = new String[] {"Start","End","Hot","Cold"};
    
    
//    double[] emissionProMatForHot = new double[] {.2,.4,.4 };
//    double[] emissionProMatForCold = new double[] {.5,.4,.1 };
//    //OR
    double[][] emissionProMat = new double[][]{
  { 0 ,  0 ,  0  },  //S
  { 0 ,  0 ,  0  },  //E
  {.2 , .4 , .4  },  //H
  {.5 , .4 , .1  }   //C
};
    
    //
    double[][] transitionProMat = new double[][]{
  { 0 ,  0  , 0.8 , 0.2 }, //S
  { 0 ,  1  ,  0  ,  0  }, //E
  { 0 , 0.1 , 0.6 , 0.3 }, //H
  { 0 , 0.1 , 0.4 , 0.5 }  //C
};
    
    double[][] probabiltyMatrix = new double[][]{
  //S    E     H    C
  { 0 ,  0  ,  0 ,  0},
  { 0 ,  0  ,  0 ,  0}, 
  { 0 ,  0  ,  0 ,  0}, 
};
    //or 
    
    
   Double[][][]  recordHolder3D = new Double[numOfObservations][numOfStates][numOfStates];
   
   
   
   
   
  void forwardAlgo(String input){
    
    initialize3DArray();
    for(int transitionNo = 0; transitionNo < numOfObservations; transitionNo++){
        System.out.println("transitionNo = "+(transitionNo+1));
        for(int previousState = 0; previousState < numOfStates; previousState++){
            System.out.println("From "+ statesName[previousState]);
            
            for(int nextState = 0; nextState < numOfStates; nextState++){
   
                if(transitionNo==0&&input!=""){
                    int Startindex = Arrays.asList(statesName).indexOf(input);
                           
                    if(Startindex == previousState){
                           recordHolder3D[transitionNo][previousState][nextState] = 
                           transitionProMat[previousState][nextState] * emissionProMat[nextState][Arrays.asList(emmissionName).indexOf(observations[transitionNo])];
                    }
                }
                else if(transitionNo==0&&input==""){
                           recordHolder3D[transitionNo][previousState][nextState] = 
                           transitionProMat[previousState][nextState] * emissionProMat[nextState][Arrays.asList(emmissionName).indexOf(observations[transitionNo])];  
                }        
                
                else if(transitionNo>0) {
                    recordHolder3D[transitionNo][previousState][nextState] = 
                    (transitionProMat[previousState][nextState] * emissionProMat[nextState][Arrays.asList(emmissionName).indexOf(observations[transitionNo])])
                    *(probabiltyMatrix[transitionNo-1][previousState]);
                }
       
                System.out.println(""+recordHolder3D[transitionNo][previousState][nextState]);
            }
    //   break;        
        }
        for(int i =0;i<numOfStates; i++){
            double sum1 = 0;
            for(int j =0;j<numOfStates; j++){
                sum1 = sum1 + recordHolder3D[transitionNo][j][i];
            }
            probabiltyMatrix[transitionNo][i] = sum1;
            System.out.println("PM = "+probabiltyMatrix[transitionNo][i]);
        }
       //break;
    }
      //System.out.println("count = "+count);
      count = 0;
      
      
  }
  
  void showOutputOfForwardAlgo(){
      
    //  initialize3DArray();
      for(int transitionNo = 0; transitionNo < numOfObservations; transitionNo++){
        System.out.println("transitionNo = "+(transitionNo+1));
          
        for(int previousState = 0; previousState < numOfStates; previousState++){
            System.out.println("From "+ statesName[previousState]);
                
            for(int nextState = 0; nextState < numOfStates; nextState++){       
               System.out.println(""+recordHolder3D[transitionNo][previousState][nextState]);
               count++;
            }
        }
        System.out.println("count = "+count);
   
       //break;
      }
        System.out.println("count = "+count);
   
      
  }
  
  void initialize3DArray(){
      for(int transitionNo = 0; transitionNo < numOfObservations; transitionNo++){
        
        for(int previousState = 0; previousState < numOfStates; previousState++){
                
            for(int nextState = 0; nextState < numOfStates; nextState++){       
              
                recordHolder3D[transitionNo][previousState][nextState] = 0.0;
                count++;
            }
        }
   
      }
      //System.err.println("count = "+count);
  }
  
    
    
}


