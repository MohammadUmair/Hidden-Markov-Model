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

    //String[] myStringArray = new String[3];
    //String[] myStringArray = {"a","b","c"};
    //String[] myStringArray = new String[]{"a","b","c"};

    //int[][] multi = new int[5][10];
    //
    //int[][] multi = new int[][]{
    //  { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
    //  { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
    //  { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
    //  { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
    //  { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }
    //};

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
  { 0 ,  0 ,  0  },
  { 0 ,  0 ,  0  },
  {.2 , .4 , .4  },
  {.5 , .4 , .1  }
};
    
    //
    double[][] transitionProMat = new double[][]{
  { 0 ,  0  , 0.8 , 0.2 },
  { 0 ,  1  ,  0  ,  0  },
  { 0 , 0.1 , 0.6 , 0.3 },
  { 0 , 0.1 , 0.4 , 0.5 }
};
    
    
   Double[][][]  recordHolder3D = new Double[numOfObservations][numOfStates][numOfStates];
   
  void forwardAlgo(){
    for(int transitionNo = 0; transitionNo < numOfObservations; transitionNo++){
        for(int previousState = 0; previousState < numOfStates; previousState++){
            for(int nextState = 0; nextState < numOfStates; nextState++){
          
            recordHolder3D[transitionNo][previousState][nextState] = transitionProMat[previousState][nextState] * emissionProMat[nextState][Arrays.asList(emmissionName).indexOf(observations[transitionNo])];  
            System.out.println(""+recordHolder3D[transitionNo][previousState][nextState]);

            //TP(CurState,PreState) X EP(Emission,CurState)
            count++;
            }
        }
       //break;
    }
      System.out.println("count = "+count);
    
      
      
  }
    
    
}






//Double[][]  recordHolder = new Double[numOfStates][numOfStates];
//   
//  void forwardAlgo(){
//    for(int transitionNo = 0; transitionNo < numOfObservations; transitionNo++){
//        System.err.println("E");
//        for(int previousState = 0; previousState < numOfStates; previousState++){
//            for(int nextState = 0; nextState < numOfStates; nextState++){
//          
//            recordHolder[previousState][nextState] = transitionProMat[previousState][nextState] * emissionProMat[nextState][Arrays.asList(emmissionName).indexOf(observations[transitionNo])];  
//            System.out.println(""+recordHolder[previousState][nextState]);
//
//            //TP(CurState,PreState) X EP(Emission,CurState)
//            count++;
//            }
//            break;
//        }
//        break;
//    }
//      
//      
//  }



//            System.out.println(""+previousState);    
//            System.out.println(""+nextState);
//            System.out.println(""+Arrays.asList(emmissionName).indexOf(observations[transitionNo]));
//            System.out.println(""+transitionNo);
//            System.out.println(observations[transitionNo]);
//System.out.println(""+emissionProMat[nextState][Arrays.asList(emmissionName).indexOf(observations[transitionNo])]);
//System.out.println(""+transitionProMat[previousState][nextState]);