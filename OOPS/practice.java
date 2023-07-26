public class practice{
    public static void main(String args[]){
        Complex c1 = new Complex(2, 4);
        Complex c2 = new Complex(3, 5);

        Complex c3 = Complex.add(c1, c2);
        Complex c4 = Complex.diff(c1, c2);
        Complex c5 = Complex.product(c1, c2);
        
        c3.getComplex();
        c4.getComplex();
        c5.getComplex();

    }
}

class Complex{
    int real, img;
    Complex(int real, int img){
        this.real = real;
        this.img = img;
    }

    public static Complex add(Complex a, Complex b){
        return new Complex((a.real + b.real), (a.img + b.img));
    }

    public static Complex diff(Complex a, Complex b){
        return new Complex((a.real - b.real), (a.img - b.img));
    }

    public static Complex product(Complex a, Complex b){
        return new Complex(((a.real * b.real) - (a.img * b.img)), ((a.real * b.img) + (a.img * b.real)));
    }

    public void getComplex(){
        if(real == 0 && img != 0){
            System.out.println("Imaginary = "+ img);
        } else if (real != 0 && img == 0){
            System.out.println("Real = "+real);
        } else{
            System.out.println("Real = "+real+" & "+"Imaginary = "+img);
        }
    }
}