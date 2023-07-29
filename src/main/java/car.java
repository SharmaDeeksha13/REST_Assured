public class car extends vehicle {

    String i = "Child";

    public void gear() {
        System.out.println("gear from car class");
    }

    public void break1() {
        System.out.println("break1 from car class");
    }

    public void wheels() {
        System.out.println("wheels from car class");
    }

    public void wheels2() {
        System.out.println("wheels from car class");
    }

    public void child() {
        System.out.println("child method from vehicle class");
    }

    public static void main(String args[]) {
        car c1 = new car();


        vehicle v1 = new vehicle();
//        v1.gear();

//        car c5 = (car) new vehicle();
//        vehicle c6 = (vehicle) c5;

//
        vehicle v2 = new car();  // all parents class method and common methods
//        v2.gear();
        System.out.println(v2.i);


//        vehicle v3=new car();
//        car c5=(car) v3;
//
//        c5.gear();


    }
}
