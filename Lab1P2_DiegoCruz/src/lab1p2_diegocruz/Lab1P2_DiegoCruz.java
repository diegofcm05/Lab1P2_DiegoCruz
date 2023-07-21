/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab1p2_diegocruz;

import java.util.Scanner;

/**
 *
 * @author dfcm9
 */
public class Lab1P2_DiegoCruz {
    
    static Scanner sc = new Scanner(System.in);
    static Scanner sc_int = new Scanner(System.in);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        boolean resp = true;
        while (resp){
            System.out.println("""
                               Menu de Lab 1
                               1. Newton-Raphson
                               2. Serie de Taylor
                               3. Salir
                               Ingrese una opcion
                               """);
                String op = sc.nextLine();
                while (!checknummenu(op)){
                        System.out.println("Ingrese un NUMERO, por favor.");
                        op = sc.nextLine();
                    }
            switch (Integer.parseInt(op)){
                case 1:
                {
                    System.out.println("Ingrese el coeficiente a: ");
                    String a = sc.nextLine();
                    while (!checknum(a) || Integer.parseInt(a)==0){
                        System.out.println("Ingrese un coeficiente valido, como por ejemplo 46 o -13. Recuerde que a no puede ser 0.");
                        a = sc.nextLine();
                    }
                    int a1 = Integer.parseInt(a);
                    System.out.println("Ingrese el coeficiente b:");
                    String b = sc.nextLine();
                    while (!checknum(b)){
                        System.out.println("Ingrese un coeficiente valido, como por ejemplo 46 o -13");
                        b = sc.nextLine();
                    }
                    int b1 = Integer.parseInt(b);
                    
                    System.out.println("Ingrese el coeficiente c:");
                    String c = sc.nextLine();
                    while (!checknum(c)){
                        System.out.println("Ingrese un coeficiente valido, como por ejemplo 46 o -13");
                        c = sc.nextLine();
                    }
                    int c1 = Integer.parseInt(c);
                    
                    double vertice = ((int)b1*-1.0/(2*(int)a1));
                    System.out.println(vertice);
                    double raiz = NewtonRaphson(a1,b1,c1,vertice-200, 100);
                    double raiz2 = NewtonRaphson(a1,b1,c1,vertice+200, 100);
                    
                    System.out.println("Ejecucion 1: x0 = "+vertice+" -200 = "+(vertice-200)+" Raiz encontrada: "+raiz);
                    System.out.println("Ejecucion 1: x0 = "+vertice+" +200 = "+(vertice+200)+" Raiz encontrada: "+raiz2);
                    
                    break;
                    
                    
                }
                case 2:
                {
                    System.out.println("Ingrese el numero del cual hallar sin,cos,tan ");
                    String x = sc.nextLine();
                    while (!checknum(x) || Integer.parseInt(x)==0){
                        System.out.println("Ingrese un coeficiente valido, como por ejemplo 46 o -13. Recuerde que a no puede ser 0.");
                        x= sc.nextLine();
                    }
                    int x1 = Integer.parseInt(x);
                    System.out.println("Ingrese el limite de las series: ");
                    String n = sc.nextLine();
                    while (!checknum(n) || Integer.parseInt(n)==0){
                        System.out.println("Ingrese un coeficiente valido, como por ejemplo 46 o -13. Recuerde que a no puede ser 0.");
                        n = sc.nextLine();
                    }
                    int n1 = Integer.parseInt(n);
                    System.out.println("El seno de "+x+" es "+sin(x1,n1,0,n1));
                    System.out.println("El coseno de "+x+" es "+cos(x1,n1,0,n1));
                    if(Integer.parseInt(x)>90){
                        System.out.println("La tangente de "+x+" es 0");
                    }
                    else{
                         System.out.println("La tangente de "+x+" es "+tan(x1,n1,1,n1));
                    }
                    break;
                }
                case 3:
                {
                    resp = false;
                    break;
                }
                default:
                {
                    System.out.println("Ingrese un NUMERO valido.");
                    break;
                }
            }
        // TODO code application logic here
        }
    }
    
    
    public static boolean checknum(String x){
        boolean esnum = true;
        for (int i = 0; i < x.length(); i++) {
            char s = x.charAt(i);
            if (i==0){
                if ((s < 48 || s>57) && s != 45) {
                    esnum = false;
                    break;
                }  
            }
            else{
                if (s < 48 || s >57) {
                    esnum = false;
                    break;
                }  
            }
        }
        
        return esnum;
        
    }
    
    public static double NewtonRaphson(int a, int b, int c, double desplazamiento, int cont){
        double coefi;
        if(cont==0){
            coefi = desplazamiento-((a*Math.pow(desplazamiento, 2)+b*desplazamiento+c)/(2*a*desplazamiento+b));
            return coefi;
        }
        else{
            double newx = NewtonRaphson(a,b,c,desplazamiento,cont-1);
            coefi = newx-((a*Math.pow(newx, 2)+b*newx+c)/(2*a*newx+b));
            return coefi;
        }
    }
    
    public static double sin(int x, int n, double acum, int cont){
        double resp;
        if (cont == n){
            resp = (Math.pow(-1, n)/factorial(2*n+1))*Math.pow(x, 2*n+1);
            acum = acum+resp;
            return acum; 
        }
        else{
            return acum+=sin(x,n+1,acum,cont++);
        }
        
    }
    
    public static double cos(int x, int n, double acum, int cont){
        double respuesta;
        if(cont == n){
            respuesta = (Math.pow(-1, n)/factorial(2*n))*Math.pow(x, 2*n);
            acum = acum+respuesta;
            return acum;
        }
        else{
            return acum+=cos(x,n+1,acum,cont++);
            
        }
        
    }
    
    public static double tan(int x, int n, double acum, int cont){
        double respuesta;
        if(cont == n){
            respuesta = (Math.pow(2, n)*Math.pow(-4, n)*(1-Math.pow(4, n)))/factorial(2*n)*Math.pow(x, 2*n-1);
            acum = acum+respuesta;
            return acum;
        }
        else{
            return acum+=tan(x,n+1,acum,cont++);
            
        }
    }
    
    public static int factorial(int num){
        int acum = 1;
        for (int i = 1; i <= num; i++) {
            acum = i*acum;
        }
        
        return acum;
    }
    
    public static boolean checknummenu(String x){
        boolean bueno = true;
        for (int i = 0; i <x.length(); i++) {
            char e = x.charAt(i);
            if (e<48 || e>57){
                bueno = false;
                break;
            }
            
            
        }
        return bueno;
                
    }
}
