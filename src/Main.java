import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        int numeroCuenta;
        int DNI;
        double saldoActual;
        Scanner sc = new Scanner(System.in);
        List<CuentaBancaria> lista = new ArrayList<CuentaBancaria>();


        int opcion;
        do {
            System.out.println("\n=== MENÚ PRINCIPAL ===");
            System.out.println("1. Crear cuenta");
            System.out.println("2. Editar cuenta");
            System.out.println("3. Eliminar cuenta");
            System.out.println("4. Ver todas las cuentas");
            System.out.println("5. Operar con una cuenta");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();

            switch (opcion){
                case 1: //Insertar
                    System.out.println("*** Crear cuenta ***");
                    System.out.println("Número de cuenta: ");
                    numeroCuenta=sc.nextInt();
                    System.out.println("DNI: ");
                    DNI= sc.nextInt();
                    System.out.println("Saldo actual: ");
                    saldoActual=sc.nextDouble();

                    CuentaBancaria nueva = new CuentaBancaria(numeroCuenta,DNI,saldoActual);
                    lista.add(nueva);
                    System.out.println("Cuenta creada con exito");
                    break;
                case 2: //Editar
                    System.out.println("*** Editar cuenta ***");
                    System.out.println("Escriba el numero de cuenta: ");
                    int numEditar = sc.nextInt();
                    boolean encontrada = false;//Uso de variable auxiliar ya que dentro de un ciclo for each no se puede modificar una lista
                    for (CuentaBancaria c : lista) {
                        if(c.getNumeroCuenta()==numEditar){
                            System.out.println("Número de cuenta a editar: ");
                            int nuevoNum=sc.nextInt();
                            System.out.println("DNI: ");
                            int nuevoDni = sc.nextInt();
                            System.out.println("Saldo actual: ");
                            double nuevoSaldo =sc.nextDouble();

                            c.setNumeroCuenta(nuevoNum);
                            c.setDNI(nuevoDni);
                            c.setSaldoActual(nuevoSaldo);
                            encontrada = true;
                            break;
                        }
                    }
                    if (!encontrada) {
                        System.out.println("Cuenta no encontrada.");
                    }
                    break;
                case 3://Eliminar
                    System.out.println("*** Eliminar cuenta ***");
                    System.out.print("\nIngrese el número de cuenta a eliminar: ");
                    int numEliminar = sc.nextInt();
                    CuentaBancaria cuentaAEliminar = null;
                    for (CuentaBancaria c : lista) {
                        if (c.getNumeroCuenta() == numEliminar) {
                            cuentaAEliminar = c;
                            break;
                        }
                    }
                    if (cuentaAEliminar != null) {
                        lista.remove(cuentaAEliminar);
                        System.out.println("Cuenta eliminada.");
                    } else {
                        System.out.println("Cuenta no encontrada.");
                    }
                    break;
                case 4:
                    System.out.println("*** Ver todas las cuentas ***");

                    if(lista.isEmpty()){//Si la lista esta vacia
                        System.out.println("No hay cuentas regisradas");
                    }else{
                        for(CuentaBancaria c: lista){
                            c.consultarDatos();
                        }
                    }
                    break;

                case 5:
                    System.out.println("*** Operar con una cuenta ***");
                    System.out.println("Escriba el núnuero de la cuenta: ");
                    numeroCuenta= sc.nextInt();
                    CuentaBancaria seleccionada = null;
                    for (CuentaBancaria c : lista) {
                        if (c.getNumeroCuenta() == numeroCuenta) {
                            seleccionada = c;
                            break;
                        }
                    }
                    if(seleccionada != null){
                        int opcionCuenta;
                        do {
                            System.out.println("\n=== MENÚ BANCO ===");
                            System.out.println("1. Consignar dinero");
                            System.out.println("2. Retirar dinero");
                            System.out.println("3. Extracción rápida (máx 20% del saldo)");
                            System.out.println("4. Consultar saldo");
                            System.out.println("5. Consultar datos");
                            System.out.println("6. Salir");
                            System.out.print("Seleccione una opción: ");
                            opcionCuenta = sc.nextInt();

                            switch (opcionCuenta) {

                                case 1:
                                    System.out.print("Ingrese la cantidad a consignar: ");
                                    seleccionada.ingresar(sc.nextDouble());
                                    System.out.println("Saldo actualizado: $" + seleccionada.getSaldoActual());
                                    break;
                                case 2:
                                    System.out.print("Ingrese la cantidad a retirar: ");
                                    seleccionada.retirar(sc.nextDouble());
                                    System.out.println("Saldo actualizado: $" + seleccionada.getSaldoActual());
                                    break;
                                case 3:
                                    System.out.print("Ingrese la cantidad a retirar (Extracción rápida): ");
                                    seleccionada.extraccionRapida(sc.nextDouble());
                                    System.out.println("Saldo actualizado: $" + seleccionada.getSaldoActual());
                                    break;
                                case 4:
                                    seleccionada.consultarSaldo();
                                    break;
                                case 5:
                                    seleccionada.consultarDatos();
                                    break;
                                case 6:
                                    System.out.println("Gracias por usar nuestro banco. ¡Hasta luego!");
                                    break;
                                default:
                                    System.out.println("Opción inválida. Intente de nuevo.");
                            }
                        } while (opcionCuenta != 6);

                    }
            }

        }while (opcion !=6);

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


