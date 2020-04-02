package Adapter;

public class Main {
    public static void main(String args[]) {
        Connectable conUSBport = new AdapterPhoneByUSBport();
        conUSBport.connectSamsungPhone();
        conUSBport.connectLGPhone();
    }
}
