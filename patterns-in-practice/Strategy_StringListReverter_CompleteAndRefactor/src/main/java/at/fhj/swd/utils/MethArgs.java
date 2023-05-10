package at.fhj.swd.utils;

public class MethArgs {
    public static void requireNonNull(Object param, String detailedMessage){
        if (param == null) {
            if (detailedMessage== null) {
                throw new IllegalArgumentException();
            } else {
                throw new IllegalArgumentException(detailedMessage);
            }
        }
    }

    public static void requireNonNull(Object param){
        requireNonNull(param, null);
    }

}
