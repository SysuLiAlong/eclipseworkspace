package lialong;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.TimeUnit;

public class Test {
    static Map wMap = new WeakHashMap();
    static Map map = new HashMap();
    public static void init(){
        String ref1= new String("obejct1");
        String ref2 = new String("obejct2");
        String ref3 = new String ("obejct3");
        String ref4 = new String ("obejct4");
        wMap.put(ref1, "chaheObject1");
        wMap.put(ref2, "chaheObject2");
        map.put(ref3, "chaheObject3");
        map.put(ref4, "chaheObject4");
        System.out.println("String引用ref1，ref2，ref3，ref4 消失");

    }
    public static void testWeakHashMap(){

        System.out.println("WeakHashMap GC之前");
        for (Object o : wMap.entrySet()) {
            System.out.println(o);
        }
        try {
            System.gc();
            TimeUnit.SECONDS.sleep(20);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("WeakHashMap GC之后");
        for (Object o : wMap.entrySet()) {
            System.out.println(o);
        }
    }
    public static void testHashMap(){
        System.out.println("HashMap GC之前");
        for (Object o : map.entrySet()) {
            System.out.println(o);
        }
        try {
            System.gc();
            TimeUnit.SECONDS.sleep(20);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("HashMap GC之后");
        for (Object o : map.entrySet()) {
            System.out.println(o);
        }
    }
    public static void setAge(int age){
    	  if(age<0){
    	    // untrack excaption---程序运行到这里就会终止
    	    RuntimeException e = new RuntimeException("年龄不能为负数");
    	    throw e;
    	    // track excaption --- 必须用try-catch进行捕捉或者声明(throws Exception)放在类声明中
//    	    Exception e = new Exception("年龄不能为负数");
//    	    throw e;
    	  }
    	}
    public static void main(String[] args) {
        init();
        testWeakHashMap();
        testHashMap();
    }
}