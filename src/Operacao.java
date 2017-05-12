import java.util.ArrayList;

/**
 * Created by ericcalasans on 12/05/17.
 */
public class Operacao{
    private char char_code;
    private double a;
    private double b;

    ArrayList<String> valores = new ArrayList<String>();
    ArrayList<String> operadores = new ArrayList<String>();

    public char getChar_code() {
        return char_code;
    }

    public void setChar_code(char char_code) {
        this.char_code = char_code;
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public Operacao(double a){
        this.a = a;
        this.char_code = 'e';
    }

    public Operacao(char cod, double a, double b){
        this.char_code = cod;
        this.a = a;
        this.b = b;

    }

    public String toString(){

        if(this.char_code == 'e'){
            return ""+this.a;
        } else {
            return ""+this.char_code;
        }

    }

}
