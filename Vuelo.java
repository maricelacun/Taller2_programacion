import java.util.Scanner;

public class Vuelo {
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);

        int asientos = 200; // Número de asientos disponibles
        double boleto, boletofinal, descuento, recargo; // Variables de precio de boleto y cálculos
        String categoriaBoleto = ""; // Variable que almacenará el tipo de boleto

        
        System.out.println("SELECCIONAR EL TIPO DE ACTIVIDAD");
        System.out.println("1......... RESERVAR EL VIAJE ");
        System.out.println("2......... CANCELAR O CAMBIAR EL VUELO");
        System.out.println("3......... SALIR");
        System.out.print("Ingrese la Opción: ");
        int opcion = input.nextInt();
        input.nextLine(); // Consumir el salto de línea

        // Opción para reservar un viaje
        if (opcion == 1) {
            while (asientos > 0) {
                // Datos del pasajero
                System.out.println("DATOS DEL PASAJERO");
                System.out.print("NOMBRE: ");
                String nombre = input.nextLine();
                System.out.print("CÉDULA DE IDENTIDAD: ");
                String ci = input.nextLine();

                // Selección de ruta de viaje
                System.out.println("ELIJA LA RUTA DE VIAJE");
                System.out.println("1 ........... Quito - Guayaquil Hora 09:00 Am  $130");
                System.out.println("2 ..........  Quito - Cuenca Hora 10:30 $95");
                System.out.println("3 .......... Guayaquil - Manta Hora 12:00 pm $70");
                System.out.println("4 .......... Quito - Galápagos Hora 08:00 am $300");
                System.out.print("Seleccione la ruta (1, 2, 3, 4): ");
                int ruta = input.nextInt();
                input.nextLine(); 


                
                if (ruta == 1) boleto = 130;
                else if (ruta == 2) boleto = 95;
                else if (ruta == 3) boleto = 70;
                else boleto = 300;

                // Ingreso de la edad
                System.out.print("EDAD: ");
                int edad = input.nextInt();
                input.nextLine(); // Consumir salto de línea

                // Selección del tipo de boleto
                System.out.println("SELECCIONAR EL TIPO DE BOLETO");
                System.out.println("E .......... Boleto Económico");
                System.out.println("PC ......... Boleto Primera Clase");
                System.out.println("T .......... Boleto de Turista");
                System.out.println("F .......... Boleto Familiar");
                System.out.print("Ingrese el tipo de boleto: ");
                categoriaBoleto = input.nextLine();  // Asignamos el valor de la opción elegida

                // Calculando el precio final según el tipo de boleto
                if (categoriaBoleto.equalsIgnoreCase("E")) {
                    descuento = boleto * 0.1;         // Aplica un 10% de descuento
                    boletofinal = boleto - descuento; // Calcula el precio final con el descuento
                } else if (categoriaBoleto.equalsIgnoreCase("PC")) {
                    recargo = boleto * 0.3;           // Aplica un recargo del 30%
                    boletofinal = boleto + recargo;   // Calcula el precio final con el recargo
                } else if (categoriaBoleto.equalsIgnoreCase("T")) {
                    recargo = boleto * 0.1;           // Aplica un recargo del 10%
                    boletofinal = boleto + recargo;   // Calcula el precio final con el recargo
                } else if (categoriaBoleto.equalsIgnoreCase("F")) {
                    descuento = boleto * 0.15;        // Aplica un 15% de descuento para el boleto familiar
                    boletofinal = boleto - descuento; // Calcula el precio final con el descuento
                } else {
                    System.out.println("Opción inválida.");
                    return; // Termina el programa si se ingresa una opción incorrecta
                }

                // Ingreso de la cantidad y peso del equipaje
                System.out.print("INGRESE LA CANTIDAD DE MALETAS QUE VA A LLEVAR (MÁXIMO 2): ");
                int equipajes = input.nextInt();
                System.out.print("INGRESE EL PESO DE SU EQUIPAJE EN KG (MÁXIMO 30 KG): ");
                double pesos = input.nextDouble();

                // Verificar restricciones de equipaje
                if (equipajes <= 2 && pesos <= 30) {
                    System.out.println("SE HA RESERVADO SU BOLETO DE VIAJE CON ÉXITO");
                    asientos--; // Reducir la cantidad de asientos disponibles
                    System.out.println("Nombre: " + nombre);
                    System.out.println("Precio de su boleto: $" + boletofinal);
                    System.out.print("¿DESEA REALIZAR OTRA RESERVA? (1. Sí / 2. No): ");
                    int salir = input.nextInt();
                    input.nextLine(); // Consumir salto de línea

                    // Salir del ciclo si no desea realizar otra reserva
                    if (salir != 1) break;
                } else {
                    System.out.println("Excede la cantidad o peso del equipaje permitido.");
                }
            }
            System.out.println("Lo siento, el avión está lleno.");
        } 
        // Opción para cancelar o cambiar vuelo
        else if (opcion == 2) {
            System.out.print("Ingrese las horas de haber comprado su boleto de Viaje: ");
            int tiempo = input.nextInt();

            // Verificación si la cancelación o cambio se realiza dentro de las 48 horas
            if (tiempo < 48) {
                System.out.println("1 .................. Cancelar Vuelo");
                System.out.println("2 ............... Cambiar el Vuelo");
                System.out.print("Seleccione opción: ");
                int op = input.nextInt();

                if (op == 1) {
                    System.out.println("Su vuelo ha sido cancelado.");
                } else {
                    System.out.println("Su vuelo será cambiado de fecha o ruta.");
                }
            } else {
                System.out.println("Habrá un recargo por no haber cancelado o cambiado dentro de las 48 horas.");
                System.out.print("INGRESAR EL VALOR DEL BOLETO: ");
                double vALOR = input.nextDouble();
                recargo = vALOR * 0.2; // Recargo del 20%
                boletofinal = vALOR + recargo; // Precio final con el recargo
                System.out.println("TOTAL A CANCELAR: $" + boletofinal);
            }
        } 
        // Opción para salir
        else {
            System.out.println("Gracias por utilizar nuestros servicios.");
        }

        input.close(); // Cerrar el scanner al final
    }
}
