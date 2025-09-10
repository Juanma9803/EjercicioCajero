import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("* Ingrese sus datos Bnacarios *");
        CuentaBancaria cuenta = new CuentaBancaria();
        System.out.print("Ingrese el número de cuenta: ");
        cuenta.setNumeroCuenta(sc.nextInt());
        System.out.print("Ingrese su DNI: ");
        cuenta.setDNI(sc.nextInt());

        int opcion;
        do {
            System.out.println("\n=== MENÚ BANCO ===");
            System.out.println("1. Consignar dinero");
            System.out.println("2. Retirar dinero");
            System.out.println("3. Extracción rápida (máx 20% del saldo)");
            System.out.println("4. Consultar saldo");
            System.out.println("5. Consultar datos");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();

            switch (opcion) {

                case 1:
                    System.out.print("Ingrese la cantidad a consignar: ");
                    cuenta.ingresar(sc.nextDouble());
                    System.out.println("Saldo actualizado: $" + cuenta.getSaldoActual());
                    break;
                case 2:
                    System.out.print("Ingrese la cantidad a retirar: ");
                    cuenta.retirar(sc.nextDouble());
                    System.out.println("Saldo actualizado: $" + cuenta.getSaldoActual());
                    break;
                case 3:
                    System.out.print("Ingrese la cantidad a retirar (Extracción rápida): ");
                    cuenta.extraccionRapida(sc.nextDouble());
                    System.out.println("Saldo actualizado: $" + cuenta.getSaldoActual());
                    break;
                case 4:
                    cuenta.consultarSaldo();
                    break;
                case 5:
                    cuenta.consultarDatos();
                    break;
                case 6:
                    System.out.println("Gracias por usar nuestro banco. ¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
            }
        } while (opcion != 6);
    }
}

class CuentaBancaria{
    private int numeroCuenta;
    private int DNI;
    private double saldoActual;

    // Constructor con todos los atributos
    public CuentaBancaria(int numeroCuenta, int DNI, double saldoActual) {
        this.numeroCuenta = numeroCuenta;
        this.DNI = DNI;
        this.saldoActual = saldoActual;
    }

    // Constructor vacío
    public CuentaBancaria() {
    }

    // Getters y Setters
    public int getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(int numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public int getDNI() {
        return DNI;
    }

    public void setDNI(int DNI) {
        this.DNI = DNI;
    }

    public double getSaldoActual() {
        return saldoActual;
    }

    public void setSaldoActual(double saldoActual) {
        this.saldoActual = saldoActual;
    }

    //Ingresar dineri
    public void ingresar(double cantidad){
        this.saldoActual = this.saldoActual + cantidad;
    }

    //Retirar dinero
    public void retirar(double cantidad){

        if (this.saldoActual<cantidad){
            this.saldoActual = 0;
        }else{
            this.saldoActual = this.saldoActual-cantidad;
        }
    }

    //Extracción Rapida
    public void extraccionRapida(double cantidad){

        if(cantidad>(this.saldoActual*0.2)){
            System.out.println("La cantidad supera el 20%");
        }else{
            this.saldoActual = this.saldoActual-cantidad;
        }

    }

    //Consultar saldo
    public void consultarSaldo(){
        System.out.println("\nSu saldo es: "+ this.saldoActual);
    }

    //Consultar datos
    public void consultarDatos(){
        System.out.println("\n** Datos bancarios **");
        System.out.println("Su número de cuenta es: "+ this.numeroCuenta);
        System.out.println("Su DNI es: "+ this.DNI);
        System.out.println("Su saldo es: "+ this.saldoActual);
    }
}


