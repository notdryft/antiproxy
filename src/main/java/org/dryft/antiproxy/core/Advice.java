package org.dryft.antiproxy.core;

import java.lang.reflect.AnnotatedElement;

public interface Advice {

    Object chain(AnnotatedElement element, Object receiver, Object[] arguments, AdviceContext context);
}
