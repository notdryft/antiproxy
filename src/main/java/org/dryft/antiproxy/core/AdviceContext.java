package org.dryft.antiproxy.core;

import java.lang.reflect.AnnotatedElement;

public interface AdviceContext {

    Object call(AnnotatedElement element, Object receiver, Object[] arguments);
}
