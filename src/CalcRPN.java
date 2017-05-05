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
// construtor
    CalcRPN () {
        this.aPilha = new Pilha<Double>();
        //throw new Error("a ser completado");
    }
// Adi¸c~ao de dois elementos do topo da pilha
    void mais() {
        double operando1, operando2, resultado;
        operando1 = aPilha.desempilha() ;
        operando2 =aPilha.desempilha() ;
        resultado = operando1+operando2;
        aPilha.empilha(resultado);
        
//        throw new Error("a ser completado");
    }
// Subtra¸c~ao de dois elementos do topo da pilha
    void menos() {
        double operando1, operando2, resultado;
        operando1 = aPilha.desempilha() ;
        operando2 =aPilha.desempilha() ;
        resultado = operando1-operando2;
        aPilha.empilha(resultado);
        //throw new Error("a ser completado");
    }
// Multiplica¸c~ao de dois elementos do topo da pilha
    void vezes() {
        double operando1, operando2, resultado;
        operando1 = aPilha.desempilha() ;
        operando2 =aPilha.desempilha() ;
        resultado = operando2*operando1;
        aPilha.empilha(resultado);
       // throw new Error("a ser completado");
    }
// Divis~ao de dois elementos no topo da pilha
    void dividido() {
        double operando1, operando2, resultado;
        operando1 = aPilha.desempilha() ;
        operando2 =aPilha.desempilha() ;
        resultado = operando2/operando1;
        aPilha.empilha(resultado);
        //throw new Error("a ser completado");
    }
// retorna o conteudo do topo da pilha
    Double resultado() {
        return aPilha.topo();
        //throw new Error("a ser completado");
    }
// interpretador de comandos
    void exec(String cmd) {
        if(Double.valueOf(cmd) instanceof Double){
            aPilha.empilha(Double.parseDouble(cmd));
        }
        switch (cmd){
            case "+":
                this.mais();
                break;
            case "-":
                this.menos();
                break;
            case "*":
                this.vezes();
                break;
            case "/":
                this.dividido();
                break;
            default:
                break;
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
            interfaceUsuario();
        } catch (IOException e){
            System.out.println(e.getMessage());
        }
    }


    
}
    
    
    

