package hw_6;

import java.lang.reflect.Method;

public class TestRunner {
    public static void runTests(Class<?> testClass) {
       try{
           Object instance = testClass.getDeclaredConstructor().newInstance();
           int passed = 0;
           int failed = 0;
           for (Method method : testClass.getDeclaredMethods()){
               if(method.isAnnotationPresent(FileTest.class)) {
                   try {
                       method.invoke(instance);
                       passed++;
                   }
                   catch (Exception e){
                       failed++;
                   }
               }
           }
       }
       catch (Exception e ){
       }
    }
}
