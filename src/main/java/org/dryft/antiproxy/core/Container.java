package org.dryft.antiproxy.core;

import org.dryft.antiproxy.core.impl.AdviceContextImpl;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.lang.reflect.UndeclaredThrowableException;

public class Container {

    private AdviceContext context = new AdviceContextImpl((element, receiver, arguments, next) -> {
       try {
           return ((Method) element).invoke(receiver, arguments);
       } catch (IllegalAccessException | InvocationTargetException e) {
           throw new UndeclaredThrowableException(e);
       }
    }, null);

    public void addAdvice(Advice advice) {
        context = new AdviceContextImpl(advice, context);
    }

    public <S> S getService(Class<S> interfaceClass, Class<? extends S> implementationClass) {
        S implementation;

        try {
            implementation = implementationClass.newInstance();
        } catch (IllegalAccessException | InstantiationException e) {
            return null;
        }

        return interfaceClass.cast(Proxy.newProxyInstance(interfaceClass.getClassLoader(),
                new Class<?>[] { interfaceClass },
                (proxy, method, args) -> context.call(method, implementation, args)));
    }
}
