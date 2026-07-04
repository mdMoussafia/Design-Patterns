package proxy;

import services.IService;


public class SecuredProxy implements IService {
    private IService target;
    private String password;
    @Override
    public double compute(int a) {
        if(password == "1234") {
            return target.compute(a);
        }
        else throw new RuntimeException("Not Authenticated");
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public void setTarget(IService target) {
        this.target = target;
    }
}
