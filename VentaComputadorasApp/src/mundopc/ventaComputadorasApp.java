package mundopc;

import mundopc.modelo.Computadora;
import mundopc.modelo.Monitor;
import mundopc.modelo.Raton;
import mundopc.modelo.Teclado;
import mundopc.servicio.Orden;

public class ventaComputadorasApp {
    public static void main(String[] args) {

        //Se crean objetos para ejemplo de computadoras
        //Perifericos 1
        Raton ratonLenovo =new Raton("Bluetooth","Lenovo");
        Teclado tecladoLenovo = new Teclado("Bluetooth","Lenovo");
        Monitor monitorLenovo = new Monitor("Lenovo", 27);

        //Perifericos 2
        Raton ratonDell =new Raton("Bluetooth","Dell");
        Teclado tecladoDell = new Teclado("Bluetooth","Dell");
        Monitor monitorDell = new Monitor("Lenovo", 21);

        //Perifericos 3
        Raton ratonHp =new Raton("Usb","Hp");
        Teclado tecladoHp = new Teclado("Usb","Hp");
        Monitor monitorHp = new Monitor("HP", 26);


        //Crear objetos de tipo computadora
        //Computadora 1
        Computadora computadoraLenovo = new Computadora(
                "computadoraLenovo",
                monitorLenovo,
                tecladoLenovo,
                ratonLenovo
        );

        //Computadora 2
        Computadora computadoraDell = new Computadora(
                "computadoraDell",
                monitorDell,
                tecladoDell,
                ratonDell
        );

        //Computadora 3
        Computadora computadoraHp = new Computadora(
                "computadoraHp",
                monitorHp,
                tecladoHp,
                ratonHp
        );

        //Ordenes de compra
        Orden orden1 = new Orden();
        orden1.agregarComputadora(computadoraLenovo);
        orden1.agregarComputadora(computadoraDell);
        orden1.mostrarOrden();

        Orden orden2 = new Orden();
        orden2.agregarComputadora(computadoraHp);
        orden2.mostrarOrden();
    }
}