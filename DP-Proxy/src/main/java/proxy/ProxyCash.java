package proxy;

import services.IService;
import services.ServiceImpl;

import java.util.HashMap;
import java.util.Map;


public class ProxyCash implements IService {
    private ServiceImpl service;
    private Map<Integer, Double> cash = new HashMap<Integer, Double>();
    @Override
    public double compute(int a) {
        if (service == null) {service = new ServiceImpl();}
        if(!cash.containsKey(a)){
            double res = service.compute(a);
            cash.put(a, res);
            return res;
        } else
            return cash.get(a);
    }
}
