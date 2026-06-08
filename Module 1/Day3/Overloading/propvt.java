package demo;

public class propvt {

        protected class Parent {
            void fun() {
                System.out.println("Parent");
            }
        }

        private class Child extends Parent {
            void show() {
                System.out.println("Child");
            }
        }

        private void test() {
            Parent p = new Child();
            p.fun();
        }
    }


