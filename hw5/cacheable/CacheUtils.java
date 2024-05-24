package edu.phystech.hw5.cacheable;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

public class CacheUtils {

    public static <T> T getCacheProxy(Class<T> interfaceClass, T implementation) {
        return (T) Proxy.newProxyInstance(
                interfaceClass.getClassLoader(),
                new Class<?>[]{interfaceClass},
                new CacheInvocationHandler(implementation)
        );
    }

    private static class CacheInvocationHandler implements InvocationHandler, java.lang.reflect.InvocationHandler {
        private final Object target;
        private final Map<Method, Map<Object, Object>> cache = new HashMap<>();

        public CacheInvocationHandler(Object target) {
            this.target = target;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            try {
                if (method.isAnnotationPresent(Cacheable.class)) {
                    Map<Object, Object> methodCache = cache.computeIfAbsent(method, k -> new HashMap<>());
                    Object arg = args[0];
                    if (methodCache.containsKey(arg)) {
                        return methodCache.get(arg);
                    } else {
                        Object result = method.invoke(target, args);
                        methodCache.put(arg, result);
                        return result;
                    }
                } else {
                    return method.invoke(target, args);
                }
            } catch (InvocationTargetException e) {
                throw e.getTargetException();
            }
        }
    }
}
