package www.hbc.test5.DynamicAgentDesinMode;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Author: Beer
 * @Date: 2019/4/2 0:36
 * @Description:
 */
public class ProxySubject implements InvocationHandler {
    //绑定任意借口的对象
    private Object target;

    /**
     * 实现真实对象绑定处理，
     * @param target
     * @return  并返回代理对象
     */
    public Object bind(Object target) {
        //保存真实主题对象
        this.target = target;
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),this);
    }

    public void prevHandle() {
        System.out.println("[ProxySubjext] prevHandle");
    }

    public void afterHandle() {
        System.out.println("[ProxySubject] afterHandle");
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        this.prevHandle();
        //反射调用方法
        Object ret = method.invoke(this.target,args);
        this.afterHandle();
        return ret;
    }
}
