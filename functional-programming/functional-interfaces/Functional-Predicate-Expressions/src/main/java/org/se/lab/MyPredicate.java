package org.se.lab;

@FunctionalInterface
public interface MyPredicate<T>
{
    boolean test(T t);

    default MyPredicate<T> negate()
    {
        MyPredicate<T> p = (t) -> {System.out.printf("negate: "); return !test(t); };
        return p;
    }

    default MyPredicate<T> and(MyPredicate<? super T> other)
    {
        return (t) -> {System.out.printf("and: "); return test(t) && other.test(t);};
    }

    default MyPredicate<T> or(MyPredicate<? super T> other)
    {
        return (t) -> {System.out.printf("or: "); return test(t) || other.test(t);};
    }
}
