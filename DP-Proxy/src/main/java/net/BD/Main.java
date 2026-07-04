package net.BD;

import controllers.Client;
import proxy.ProxyCash;
import proxy.SecuredProxy;
import services.IService;
import services.ServiceImpl;


public class Main {
    public static void main(String[] args) {
        IService cash = new ProxyCash();
        var securedProxy = new SecuredProxy();
        securedProxy.setTarget(cash);
        securedProxy.setPassword("1234");
        Client client = new Client();
        client.setService(securedProxy);
        System.out.println("Res="+client.perform(23));
        System.out.println("Res="+client.perform(23));
        System.out.println("Res="+client.perform(25));
        System.out.println("Res="+client.perform(23));
    }
}