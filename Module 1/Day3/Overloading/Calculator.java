package demo;

public class Calculator {
    public int add(int a, int b){

        return a+b;
    }
    public byte add(byte a, byte b){
        System.out.println("byte addition");
        return (byte)(a+b);
    }
    public short add(short a, short b){
        System.out.println("short addition");
        return (short)(a+b);
    }
    //public long add(long a, long b){
      //  System.out.println("long addition");
        //return (long)(a+b);
    //}

    public float add(float a, float b){
        System.out.println("float addition");
        return (a+b);
    }
    public double add(double a, double b){
        System.out.println("double addition");
        return (a+b);
    }
    public int add(int a, int b, int c){

        return a+b+c;
    }
    public int add(int a, int b, int c, int d) {
        return a + b + c + d;
    }
    public String add(String a, String b){
    return a+b;
    }
}
