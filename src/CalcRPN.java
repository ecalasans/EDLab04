/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//package calcrpn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author E6
 */
public class CalcRPN {
    
    // vari´aveis da instancia :
// uma pilha para os c´alculos
   Pilha<Double> aPilha;
   Pilha<Operacao> hist;
// construtor
    CalcRPN () {
        this.aPilha = new Pilha<Double>();
        this.hist = new Pilha<Operacao>();
        //throw new Error("a ser completado");
    }
// Adi¸c~ao de dois elementos do topo da pilha
    void mais() {
        double operando1, operando2, resultado;
        operando1 = aPilha.desempilha() ;
        operando2 =aPilha.desempilha() ;
        resultado = operando1+operando2;
        aPilha.empilha(resultado);
        Operacao op = new Operacao('+', operando2, operando1);
        hist.empilha(op);
        
//        throw new Error("a ser completado");
    }
// Subtra¸c~ao de dois elementos do topo da pilha
    void menos() {
        double operando1, operando2, resultado;
        operando1 = aPilha.desempilha() ;
        operando2 =aPilha.desempilha() ;
        resultado = operando1-operando2;
        aPilha.empilha(resultado);
        Operacao op = new Operacao('-', operando2, operando1);
        hist.empilha(op);
        //throw new Error("a ser completado");
    }
// Multiplica¸c~ao de dois elementos do topo da pilha
    void vezes() {
        double operando1, operando2, resultado;
        operando1 = aPilha.desempilha() ;
        operando2 =aPilha.desempilha() ;
        resultado = operando2*operando1;
        aPilha.empilha(resultado);
        Operacao op = new Operacao('*', operando2, operando1);
        hist.empilha(op);

       // throw new Error("a ser completado");
    }
// Divis~ao de dois elementos no topo da pilha
    void dividido() {
        double operando1, operando2, resultado;
        operando1 = aPilha.desempilha() ;
        operando2 =aPilha.desempilha() ;
        resultado = operando2/operando1;
        aPilha.empilha(resultado);
        Operacao op = new Operacao('/', operando2, operando1);
        hist.empilha(op);
        //throw new Error("a ser completado");
    }


// retorna o conteudo do topo da pilha
    Double resultado() {
        return aPilha.topo();
        //throw new Error("a ser completado");
    }
// interpretador de comandos
    boolean testaDouble(String s){
        try{
            Double.parseDouble(s);
            return true;
        } catch (NumberFormatException e){
            return false;
        }
    }

    void exec(String cmd) {
        if(testaDouble(cmd)){
            aPilha.empilha(Double.parseDouble(cmd));
        } else {
            switch (cmd){
                case "+":
                    Operacao opMais = new Operacao(aPilha.topo());
                    hist.empilha(opMais);
                    this.mais();
                    break;
                case "-":
                    Operacao opMenos = new Operacao(aPilha.topo());
                    hist.empilha(opMenos);
                    this.menos();
                    break;
                case "*":
                    Operacao opVezes = new Operacao(aPilha.topo());
                    hist.empilha(opVezes);
                    this.vezes();
                    break;
                case "/":
                    Operacao opDiv = new Operacao(aPilha.topo());
                    hist.empilha(opDiv);
                    this.dividido();
                    break;
                case "clear":
                    aPilha.reinicialize();
                    hist.reinicialize();
                    break;
                default:
                    break;
            }
        }

    }
    
    static void test() {
        CalcRPN calc = new CalcRPN() ;
        System.out.print("3 2 + = ");
        calc.aPilha.empilha(3.0);
        calc.aPilha.empilha(2.0);
        calc.mais();
        System.out.println(calc.resultado());
        calc = new CalcRPN();
        System.out.print("3 2 - = ");
        calc.aPilha.empilha(3.0);
        calc.aPilha.empilha(2.0);
        calc.menos();
        System.out.println(calc.resultado());
        calc = new CalcRPN();
        System.out.print("3 2 * = ");
        calc.aPilha.empilha(3.0);
        calc.aPilha.empilha(2.0);
        calc.vezes();
        System.out.println(calc.resultado());
        calc = new CalcRPN();
        System.out.print("3 2 / = ");
        calc.aPilha.empilha(3.0);
        calc.aPilha.empilha(2.0);
        calc.dividido();
        System.out.println(calc.resultado());
        calc = new CalcRPN();
        System.out.print("1 2 + 3 4 - / 10 3 - * = ");
        calc.aPilha.empilha(1.0);
        calc.aPilha.empilha(2.0);
        calc.mais();
        calc.aPilha.empilha(3.0);
        calc.aPilha.empilha(4.0);
        calc.menos();
        calc.dividido();
        calc.aPilha.empilha(10.0);
        calc.aPilha.empilha(3.0);
        calc.menos();
        calc.vezes();
        System.out.println(calc.resultado());
    }

    static void interfaceUsuario() throws IOException {
        CalcRPN calc = new CalcRPN();
        String line;

        BufferedReader reader = new BufferedReader
                (new InputStreamReader(System.in));
        while ((line = reader.readLine()) != null) {
            if (line.isEmpty())
                continue;
            for (String s : line.split(" "))
                calc.exec(s);
            System.out.println("Pilha = " + calc.aPilha);
        }
        throw new IOException("Deu problema!");
    }
    
    public static void main(String[] args) {
        try{
            Operacao[] op = new Operacao[9];
            op[0] = new Operacao(16.0);
            op[1] = new Operacao(8.0);
            op[2] = new Operacao(4.0);
            op[3] = new Operacao(2.0);
            op[4] = new Operacao(1.0);
            op[5] = new Operacao('+', 2.0, 1.0);
            op[6] = new Operacao('-', 4.0, 3.0);
            op[7] = new Operacao('*', 8.0, 1.0);
            op[8] = new Operacao('/', 16.0, 8.0);
            for (int i=0; i<op.length; i++)
                System.out.print(op[i] + " ");
            System.out.println();
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }


    
}
    
    
    

