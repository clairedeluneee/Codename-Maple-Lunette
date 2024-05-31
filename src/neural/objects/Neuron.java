package neural.objects;

import java.util.ArrayList;

public class Neuron {
    private Double activation = 0.0;
    private Double bias       = 0.0;

    private ArrayList<Neuron> connectedNeurons    = new ArrayList<>();
    private ArrayList<Double> connectionWeights = new ArrayList<>();

    // Setters
    public void setActivation           (Double a)              {this.activation        = a;}
    public void setBias                 (Double b)              {this.bias              = b;}
    public void setConnectedNeurons     (ArrayList<Neuron> n)   {this.connectedNeurons  = n;}
    public void setConnectionWeights    (ArrayList<Double> d)   {this.connectionWeights = d;}

    // Getters
    public Double               getActivation()         {return this.activation;}
    public Double               getBias()               {return this.bias;}
    public ArrayList<Neuron>    getConnectedNeurons()   {return this.connectedNeurons;}
    public ArrayList<Double>    getConnectionWeights()  {return this.connectionWeights;}

    // Constructors
    public Neuron() {}
    public Neuron(Double initialActivation) {this.setActivation(initialActivation);}
    public Neuron(Double initialActivation, Double initalBias) {this.setActivation(initialActivation); this.setBias(initalBias);}
    
    // Logic
    public void connectNeuron(Neuron n)             {this.connectedNeurons.add(n); this.connectionWeights.add(0.0);}
    public void connectNeuron(Neuron n, Double w)   {this.connectedNeurons.add(n); this.connectionWeights.add(w);}

    public void recalculate() {
        ArrayList<Double> weightedInputs = new ArrayList<>();
        for (int i = 0; i < connectedNeurons.size(); i++) {weightedInputs.add(neural.functions.Activations.reLU(connectedNeurons.get(i).getActivation()) * connectionWeights.get(i));}
        Double sum = 0.0;
        for (Double d : weightedInputs) {sum =+ d;}
        this.setActivation(sum);
    }

}
