package Facade;

public class ComputerGame {

    public static void main(String args[]) {

        Monitor monitor = new Monitor();
        Keyboard keyboard = new Keyboard();
        Mouse mouse = new Mouse();

        ComputerFacade computer = new ComputerFacade(monitor, keyboard, mouse);
        computer.playGame("Bless");
        computer.gameOver();

    }
}
