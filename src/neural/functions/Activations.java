package neural.functions;

public abstract class Activations {
    private static final Double e = Math.E;

    public static Double identity           (Double x) {return x;}
    
    public static Double binaryStep         (Double x) {return (x < 0 ? 0.0 : 1.0);}

    public static Double logistic           (Double x)              {return (1 / 1 + Math.pow(e, -x));}
    public static Double sigmoid            (Double x)              {return logistic(x);}
    public static Double softStep           (Double x)              {return logistic(x);}

    public static Double hyperbolic         (Double x)              {return (Math.pow(e, x) - Math.pow(e, -x)) / (Math.pow(e, x) + Math.pow(e, -x));}
    public static Double tanh               (Double x)              {return hyperbolic(x);}

    public static Double reLU               (Double x)              {return (x < 0 ? 0.0 : x);}

    public static Double geLU               (Double x)              {return (1/2 * x) * (1 * erf(x / Math.sqrt(2)));}

    public static Double softplus           (Double x)              {return Math.log(1 + Math.pow(e, x));}

    public static Double eLU                (Double x)              {return (x <= 0 ? (Math.pow(e, x) - 1) : 1.0);}
    public static Double eLU                (Double x, Double a)    {return (x <= 0 ? a * (Math.pow(e, x) - 1) : 1.0);}

    public static Double scaledELU          (Double x)              {return eLU(x);}
    public static Double scaledELU          (Double x, Double s)    {return s * eLU(x);}

    public static Double leakyReLU          (Double x)              {return (x <= 0 ? x * 0.01 : x);}
    public static Double PReLU              (Double x, Double a)    {return (x <= 0 ? x * a    : x);}

    public static Double siLU               (Double x)              {return (x / 1 + Math.pow(e, -x));}
    public static Double sigmoidShrinkage   (Double x)              {return siLU(x);}
    public static Double siL                (Double x)              {return siLU(x);}
    public static Double swishOne           (Double x)              {return siLU(x);}





    private static Double erf(Double x) {
        // Conversion 

        // Constants
        final Double a1 =  0.254829592;
        final Double a2 = -0.284496736;
        final Double a3 =  1.421413741;
        final Double a4 = -1.453152027;
        final Double a5 =  1.061405429;
        final Double p  =  0.3275911;

        // Save the sign of x
        final Double sign = (x < 0 ? -1.0 : 1.0);
        x = Math.abs(x);

        // A & S 7.1.26
        Double t = 1.0/(1.0 + p*x);
        Double y = 1.0 - (((((a5*t + a4)*t) + a3)*t + a2)*t + a1)*t*Math.exp(-x*x);

    return sign*y;

    }
}
