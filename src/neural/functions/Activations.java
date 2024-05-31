package neural.functions;

public abstract class Activations {
    public static Double reLU               (Double x) {return (x < 0 ? 0.0 : x);}
}
