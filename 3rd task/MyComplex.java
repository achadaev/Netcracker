public class MyComplex {
    private double real = 0.0;
    private double imag = 0.0;

    MyComplex() {}

    MyComplex(double real, double imag) {
        this.real = real;
        this.imag = imag;
    }

    public double getReal() {
        return real;
    }

    public void setReal(double real) {
        this.real = real;
    }

    public double getImag() {
        return imag;
    }

    public void setImag(double imag) {
        this.imag = imag;
    }

    public void setValue(double real, double imag) {
        this.real = real;
        this.imag = imag;
    }

    @Override
    public String toString() {
        return ("(" + real + "+" + imag + "i)");
    }

    public boolean isReal() {
        return (real != 0) ? true : false;
    }

    public boolean isImaginary() {
        return (imag != 0) ? true : false;
    }

    public boolean equals(double real, double imag) {
        return (real == real && imag == imag) ? true : false;
    }

    public boolean equals(MyComplex another) {
        return (real == another.getReal() && imag == another.getImag()) ? true : false;
    }

    public double magnitude() {
        return Math.sqrt(Math.pow(real, 2) + Math.pow(imag, 2));
    }

    public double argument() {
        return Math.atan(imag / real);
    }

    public MyComplex add(MyComplex right) {
        real += right.getReal();
        imag += right.getImag();
        return this;
    }

    public MyComplex addNew(MyComplex right) {
        MyComplex newComplex = new MyComplex(real + right.getReal(), imag + right.getImag());
        return newComplex;
    }

    public MyComplex subtract(MyComplex right) {
        real -= right.getReal();
        imag -= right.getImag();
        return this;
    }

    public MyComplex subtractNew(MyComplex right) {
        MyComplex newComplex = new MyComplex(real - right.getReal(), imag - right.getImag());
        return newComplex;
    }

    public MyComplex multiply(MyComplex right) {
        double tempReal = (real * right.getReal() - imag * right.getImag());
        double tempImag = (real * right.getImag() + imag * right.getReal());
        real = tempReal;
        imag = tempImag;
        return this;
    }

    public MyComplex divide(MyComplex right) {
        double tempReal = (real * right.getReal() + imag * right.getImag())
                / ((Math.pow(right.getReal(), 2)) + Math.pow(right.getImag(), 2));
        double tempImag = ((right.getReal() * imag) - (right.getImag() * real))
                / ((Math.pow(right.getReal(), 2)) + Math.pow(right.getImag(), 2));
        real = tempReal;
        imag = tempImag;
        return this;
    }

    public MyComplex conjugate() {
        MyComplex newComplex = new MyComplex(real, -imag);
        return newComplex;
    }

    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof MyComplex)) return false;
        if (!super.equals(object)) return false;

        MyComplex myComplex = (MyComplex) object;

        if (Double.compare(myComplex.real, real) != 0) return false;
        if (Double.compare(myComplex.imag, imag) != 0) return false;

        return true;
    }

    public int hashCode() {
        int result = super.hashCode();
        long temp;
        temp = Double.doubleToLongBits(real);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(imag);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
