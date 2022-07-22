package exceptions.partTwo;

import java.io.EOFException;
import java.io.FileNotFoundException;

public class App_Two {

    private static class App01 {
        public static void main(String[] args) {
            f();
        }
        public static void f() throws RuntimeException {
        }
    }

    private static class App02 {
        // пугфем ОБОИМИ исключениями
        public static void main(String[] args) throws EOFException, FileNotFoundException {
            if (System.currentTimeMillis() % 2 == 0) {
                throw new EOFException();
            } else {
                throw new FileNotFoundException();
            }
        }
    }

    private static class App03 {
        // пугфем ОБОИМИ исключениями
        public static void main(String[] args) throws EOFException, FileNotFoundException {
           f0();
           f1();
        }
        public static void f0() throws EOFException {}
        
    }
}
