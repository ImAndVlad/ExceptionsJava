package exceptions;

public class App {

    private static class App01 {
        // throws suitable
        public static void main(String[] args) throws Throwable {

        }
    }

//    private static class App02 {
//        // throws not suitable (Compilation error)
//        public static void main(String[] args) throws String {
//
//        }
//    }

    private static class App03 {
        // catch suitable
        public static void main(String[] args) {
            try {
            } catch (Throwable t) {
            }
        }
    }

//    private static class App04 {
//        // catch not suitable (Compilation error)
//        public static void main(String[] args) {
//            try {
//            } catch (String s) {}
//        }
//    }

    private static class App05 {
        // throw suitable
        public static void main(String[] args) {
            // Error - descendant of Throwable
            throw new Error();
        }
    }

//    private static class App06 {
//        // throw not suitable (Compilation error)
//        public static void main(String[] args) {
//            throw new String("Hello!");
//        }
//    }

    private static class App07 {
        // throw (Runtime error)
        public static void main(String[] args) {
            throw null; // (NullPointerException)
        }
    }

    private static class App08 {
        // throw / new (Runtime error: Error)
        public static void main(String[] args) {
            Error ref = new Error(); // create an instance
            throw ref;               // "throw"
        }
    }

    private static class App09 {
        // (Runtime error: StackOverflowError)
        public static void main(String[] args) {
            f(null);
        }

        public static void f(NullPointerException e) {
            try {
                throw e; // e = null type NullPointerException
            } catch (NullPointerException npe) {
                f(npe);
            }
        }
    }

    private static class App10 {
        public static void main(String[] args) {
            System.out.println("sout");
            throw new Error();

            // >> sout
            // >> RUNTIME ERROR
        }
    }
}
