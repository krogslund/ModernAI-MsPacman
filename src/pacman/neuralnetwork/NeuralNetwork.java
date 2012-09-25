/*import java.security.InvalidParameterException;

*//** Neural Network skeleton class<br/> 
 * compile using "javac NeuralNetwork.java"<br/>
 * test using "java NeuralNetwork"<br/>
 * 
 * @author P. Burelli, edited by A.Liapis
 *//*

public class NeuralNetwork {
	
	*//** Backpropagation learning rate *//*
    protected float learningRate = 0.01f;
	
	// Put your data structures here

	*//** Allocate memory for the neural network and setup data structure 
     * @param neuronsPerLayer an array containing the numbers of neurons for each layer (input layer, hidden layer 1... , output layer)
     * @exception InvalidParameterException thrown if less then two layers are requested (input and output layers are mandatory) and if some layers don't contain at least 1 neuron. 
	*//*
	public NeuralNetwork( int neuronsPerLayer[] ) {
		if (neuronsPerLayer.length < 2)
			throw new InvalidParameterException("Invalid number of layers");
		
		for (int i=0;i<neuronsPerLayer.length;i++)
			if (neuronsPerLayer[i] < 1)
				throw new InvalidParameterException("Invalid number of neurons at layer "+i);
		
		// Put initialization code here 
		// (a) initialize data structures as dictated by neuronsPerLayer array
		// (b) randomize initial weights, if necessary
    }
    
    *//** Copy the inputs vector onto the inputs of the neural net 
     * @param inputs inputs values of the neural net
     *//*
    public void setInput( float inputs[] ) {
		// Put input assignment code here
    }
	
    *//** Return a copy of the current output values 
     * @return a copy of the current output values
     *//*
    public float[] getOutput() {
		// Put output return code here (and remove "return null;")
    	return null;
    }
    
    *//** Calculate the output of the neural network based on the input
     * 
     *//*
    public void activate() {		
		// Put activation code here (computing output based on the network's inputs)
    }
    
    *//** update the weights of the network based on the different between the actual output and the expectedOutput *//*
    public void applyBackpropagation( float expectedOutput[] ) {
		// The code for updating weights goes here 
		// NOTE: if using a single perceptron, this is not technically back-propagation, despite the function name 
    }
	 
    *//** Learning rate getter
	 * @return the learningRate
	 *//*
	public float getLearningRate() {
		return learningRate;
	}

	*//** Learning rate setter
	 * @param learningRate the learningRate to set
	 *//*
	public void setLearningRate(float learningRate) {
		this.learningRate = learningRate;
	}    
    
    *//** NeuralNetwork class testing method *//*
    public static void main( String[] args) {
		// A NOTE ON INPUT OUTPUT PAIRS
		// This class template uses 4 different sample sets of inputs and outputs.
		// 2 of them are for use with the single Perceptron tutorial (1 with a single input and 1 with two inputs)
		// the other 2 are for use with the Multilayer Network tutorial (1 with a single input and 1 with two inputs)
		// Simply uncomment the data set you want to work with
		// CAUTION: using the data sets intended for Multilayer Networks with a single Perceptron will not converge!

// **** DATA SET 1: For use with a single Perceptron (single input: height)
		float inputs[][] = { {170}, {190}, {165}, {180}, {210} };
		float expectedOutputs[][] = { {0}, {1}, {0}, {0}, {1} }; // **** DATA SET 2: For use with a single Perceptron (two inputs: height/weight)
//		float inputs[][] = { {170,60}, {190,70}, {175,105}, {180,90}, {210,100} };
//		float expectedOutputs[][] = { {1}, {1}, {0}, {0}, {1} }; 
// **** DATA SET 3: For use with a Multilayer network (single input: height)
//		float inputs[][] = { {170}, {190}, {165}, {180}, {210} };
//		float expectedOutputs[][] = { {1}, {0}, {1}, {0}, {1} }; 
// **** DATA SET 4: For use with a Multilayer network (two inputs: height/weight)
//		float inputs[][] = { {170,60}, {190,70}, {175,105}, {180,90}, {210,100} };
//		float expectedOutputs[][] = { {1}, {1}, {1}, {0}, {0} }; 
		
		// the above input/output pairs are intended with the Petra matchmaking tutorials in-class
		// if you want to try something simpler, try the following data sets approximating boolean operators
// **** AND gate: can be used with a single Perceptron
//		float inputs[][] = { { 1, 1}, {1,0}, {0,1}, {0,0} };
//		float expectedOutputs[][] = { {1}, {0}, {0}, {0} }; 
// **** XOR gate: must be used with a Multilayer Network
//		float inputs[][] = { { 1, 1}, {1,0}, {0,1}, {0,0} };
//		float expectedOutputs[][] = { {0}, {1}, {1}, {0} }; 
		
		
		float output[];
		
		// Create neural network: CHANGE the network structure depending on the input/output and hidden layers
		// Don't forget that the first integer in the layers array designates the number of inputs, 
		// while the second and following integers designate the number of neurons in that layer (hidden or output layers).
		int layers[]={1,1};
		NeuralNetwork neuralNet = new NeuralNetwork(layers);
		
		//Train neural network and print out to screen as we go along
		for(int i=0; i<1000; i++ ) {
		    System.out.println("##### EPOCH " + Integer.toString( i ) );
		    for(int p=0; p<4; p++ ) {
				System.out.print("INPUTS: " );
				for( int x=0; x< layers[0]; x++ ) { System.out.print( Float.toString( inputs[p][x] ) + " " ); }
				System.out.println("");
				neuralNet.setInput( inputs[p] );
				
				neuralNet.activate();
				
				output = neuralNet.getOutput();
				System.out.print("OUTPUTS: " );
				for( int x=0; x< layers[layers.length-1]; x++ ) { System.out.print( Float.toString( output[x] ) + " " ); }
				System.out.println("");
				
				neuralNet.applyBackpropagation( expectedOutputs[p] );
				System.out.print("EXPECTED OUTPUTS: " );
				for( int x=0; x< layers[layers.length-1]; x++ ) { System.out.print( Float.toString( expectedOutputs[p][x] ) + " " ); }
				System.out.println("");
		    }
		}
    }
};
*/