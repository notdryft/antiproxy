package org.dryft.antiproxy.core.impl;

import org.dryft.antiproxy.core.Advice;
import org.dryft.antiproxy.core.AdviceContext;

import java.lang.reflect.AnnotatedElement;

public class AdviceContextImpl implements AdviceContext {

    private final Advice advice;
    private final AdviceContext next;

    public AdviceContextImpl(Advice advice, AdviceContext next) {
        this.advice = advice;
        this.next = next;
    }

    @Override
    public Object call(AnnotatedElement annotatedElement, Object receiver, Object[] arguments) {
        return advice.chain(annotatedElement, receiver, arguments, next);
    }
}
