public class MyPolynomial {
    private double[] coeffs;

    MyPolynomial(double ... coeffs) {
        this.coeffs = coeffs;
    }

    public int getDegree() {
        return coeffs.length - 1;
    }

    @Override
    public String toString() {
        String res = "";
        for (int i = coeffs.length - 1; i >= 0; i--) {
            res += coeffs[i];
            if (i > 1) res += "x^" + i + " + ";
            else if (i == 1) res += "x + ";
        }
        return res;
    }

    public double evaluate(double x) {
        double res = 0.0;

        for (int i = coeffs.length - 1; i >= 0; i--) {
            res += (coeffs[i] * Math.pow(x, i));
        }
        return res;
    }

    public MyPolynomial add(MyPolynomial right) {
        if (this.getDegree() < right.getDegree()) {
            double[] nc = new double[right.getDegree() + 1];
            for (int i = 0; i < this.getDegree() + 1 ; i++) {
                nc[i] = this.coeffs[i] + right.coeffs[i];
            }
            for (int i = this.getDegree() + 1; i < right.getDegree() + 1; i++)
                nc[i] = right.coeffs[i];
            MyPolynomial newPolynomial = new MyPolynomial(nc);
            return newPolynomial;
        } else {
            double[] nc = new double[this.getDegree() + 1];
            for (int i = 0; i < right.getDegree() + 1 ; i++) {
                nc[i] = right.coeffs[i] + this.coeffs[i];
            }
            for (int i = right.getDegree() + 1; i < this.getDegree() + 1; i++)
                nc[i] = this.coeffs[i];
            MyPolynomial newPolynomial = new MyPolynomial(nc);
            return newPolynomial;
        }
    }

    public MyPolynomial multiple(MyPolynomial right) {
        if (this.getDegree() < right.getDegree()) {
            double[] nc = new double[right.getDegree() + 1];
            for (int i = 0; i < this.getDegree() + 1 ; i++) {
                nc[i] = this.coeffs[i] * right.coeffs[i];
            }
            for (int i = this.getDegree() + 1; i < right.getDegree() + 1; i++)
                nc[i] = right.coeffs[i];
            MyPolynomial newPolynomial = new MyPolynomial(nc);
            return newPolynomial;
        } else {
            double[] nc = new double[this.getDegree() + 1];
            for (int i = 0; i < right.getDegree() + 1 ; i++) {
                nc[i] = right.coeffs[i] * this.coeffs[i];
            }
            for (int i = right.getDegree() + 1; i < this.getDegree() + 1; i++)
                nc[i] = this.coeffs[i];
            MyPolynomial newPolynomial = new MyPolynomial(nc);
            return newPolynomial;
        }
    }
}
