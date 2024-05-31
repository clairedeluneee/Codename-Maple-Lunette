package neural.objects;

import java.util.ArrayList;

public class Network {
    private ArrayList<Layer> layers = new ArrayList<>();

    // Setters
    public void setLayers(ArrayList<Layer> l) {this.layers = l;}

    // Getters
    public ArrayList<Layer> getLayers()       {return this.layers;}

    // Constructors
    public Network(ArrayList<Integer> n) {
        if (n.size() < 1) {throw new Error("A network must have at least two layers.");}
        for (Integer i : n) {layers.add(new Layer(i));}
    }

    // Logic
    public void connectLayers() {
        for (int i = 1; i < layers.size(); i++) {
            layers.get(i).connectLayer(layers.get(i - 1));
        }
    }
    public void recalculate() {
        for (Integer i = 1; i < layers.size(); i++) {layers.get(i).recalculate();}
    }
}
