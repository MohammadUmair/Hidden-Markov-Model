/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hiddenmarkovmodel;

import java.util.Scanner;

/**
 *
 * @author Fighter
 */
public class HiddenMarkovModel {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // TODO code application logic here
        HMM hmm = new HMM();
        
        Scanner reader = new Scanner(System.in);  // Reading from System.in
        System.out.println("Enter a start state: ");
        String n;
        if((n=reader.next()).equalsIgnoreCase("No")){
           hmm.forwardAlgo(""); 
        }
        else{
            hmm.forwardAlgo(n);
        
        }
        
        //hmm.showOutputOfForwardAlgo();
    }
    
}
