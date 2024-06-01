package neural.objects;

import java.util.ArrayList;

public class Layer {
    private Layer                   previousLayer       = null;
    private ArrayList<Neuron>       layerNeurons        = new ArrayList<>();

    // Setters
    public void setPreviousLayer(Layer l)               {this.previousLayer = l;}
    public void setLayerNeurons(ArrayList<Neuron> n)    {this.layerNeurons = n;}

    // Getters 
    public Layer getPreviousLayer()                     {return this.previousLayer;}
    public ArrayList<Neuron> getLayerNeurons()          {return this.layerNeurons;}

    // Constructors
    public Layer() {}
    public Layer(Integer initialNeuronCount) {for (int l = 0; l < initialNeuronCount; l++) {this.layerNeurons.add(new Neuron());}}

    // Logic
    public void connectLayer(Layer l) {for (Neuron n : getLayerNeurons()) {for (Neuron o : previousLayer.getLayerNeurons()) {n.connectNeuron(o);}}}
    /**
     * Recalculates the activations of the layers.
     */
    public void recalculate() {for (Neuron n : layerNeurons) {n.recalculate();}}

}
