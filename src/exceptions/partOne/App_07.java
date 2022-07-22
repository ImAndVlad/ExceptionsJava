package exceptions;

public class App_07 {

    private static class App01 {
        public static void main(String[] args) {
            try {
                System.err.println("try");
                if (true) {throw new RuntimeException();}
            } finally {
                System.err.println("finally");
            }
            System.err.println("more");
        }
    }

//    private static class App02 {
//        // (Compiler error)
//        public static void main(String[] args) {
//            try {
//                System.err.println("try");
//                throw new RuntimeException();
//            } finally {
//                System.err.println("finally");
//            }
//            System.err.println("more");
//        }
//    }

    private static class App03 {
        public static void main(String[] args) {
            try {
                System.err.println("try");
                if (true) {return;}
            } finally {
                System.err.println("finally");
            }
            System.err.println("more");
        }
    }

    private static class App04 {
        public static void main(String[] args) {
            System.err.println(f());
        }
        public static int f() {
            try {
                return 0;
            } finally {
                return 1;
            }
        }
    }

    private static class App05 {
        public static void main(String[] args) {
            System.err.println(f());
        }
        public static int f() {
            try {
                throw new RuntimeException();
            } finally {
                return 1;
            }
        }
    }

    private static class App06 {
        public static void main(String[] args) {
            System.err.println(f());
        }
        public static int f() {
            try {
                return 0;
            } finally {
                throw new RuntimeException();
            }
        }
    }

    private static class App07 {
        public static void main(String[] args) {
            System.err.println(f());
        }
        public static int f() {
            try {
                throw new Error();
            } finally {
                throw new RuntimeException();
            }
        }
    }
}
