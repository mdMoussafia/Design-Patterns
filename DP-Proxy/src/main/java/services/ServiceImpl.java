package services;


public class ServiceImpl implements IService {
    @Override
    public double compute(int a) {
        System.out.println("Inside compute method");
        return Math.cos(a * Math.PI / 180)*Math.sqrt(a*a);
    }
}
