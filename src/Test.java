/**
 * Created by LENOVO on 2014/10/27.
 */
public class Test {
    public double add() {
        float a = 0.3f;
        double b = 1.4;
        return a+b;
    }
    public static void main(String[] args) {
        /*int n = 4;
        for(int i = 0; i < n; i ++) {
            for(int j = 0; j < n; j ++) {
                System.out.print(i+":"+j+"\t");
            }
            System.out.println();
        }*/
        Test t = new Test();
        System.out.println(t.add());

    }
}
