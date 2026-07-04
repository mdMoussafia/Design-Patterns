package net.saadbr;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author saade
 **/
public class Main {
    public static void main(String[] args) throws Exception {
        Context context = new Context();
        Scanner scanner = new Scanner(System.in);
        IStrategy strategy;
        Map<String, IStrategy> map = new HashMap<>();
        while (true) {
            System.out.println("quelle stratégie?");
            String str = scanner.nextLine();
            strategy = map.get(str);
            if (strategy == null) {
                System.out.println("Nouvelle stratégie ajouté");
                strategy = (IStrategy) Class.forName("net.saadbr.StrategyImpl"+str).getConstructor().newInstance();
                map.put(str, strategy);
            }
            context.setStrategy(strategy);
            context.effectuerOperation();
        }
    }
}
