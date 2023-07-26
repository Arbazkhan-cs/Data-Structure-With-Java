public class ClassAndObjects{
    public static void main(String args[]){
        // 1). Encapsulation
        // // Creating Objects
        // Pen p1 = new Pen();

        // // Using setter seting the color and tip
        // p1.setColor("blue");
        // p1.setTip(5);

        // // using the getter geting the value of the color and tip
        // System.out.println(p1.getColor());
        // System.out.println(p1.getTip());



        // Constructors
        // Pen p1 = new Pen();
        // Pen p2 = new Pen("Blue");
        // Pen p3 = new Pen(5);



        // 2). Inheritance
        Student s1 = new Student();
        s1.name = "Arbaz";
        s1.color = "Blue";  // Using Pen Properties in Student Because of Extends kewword, we inheriteted the Student by Pen Class.
        s1.tip = 5;

        Teacher t1 = new Teacher();
        t1.name = "Shridha"; // Inheritance from Student class
        t1.color = "pink";  // Inheriatnec from Student and than Pan clas
    }
}

class Pen{
    // private String color; // we can use these two variable only in this class.
    // private int tip;

    String color;
    int tip;

    // constructors
    Pen(){
        System.out.println("Constructor without Parameters");
    }
    Pen(String color){
        this.color = color;
    }
    Pen(int tip){
        this.tip = tip;
    }


    // // setter      // Usefull when we created variable as private class
    // void setTip(int newTip){
    //     this.tip = newTip;
    // }
    // void setColor(String newColor){
    //     this.color = newColor;
    // }
    // // getter   
    // String getColor(){
    //     return this.color;
    // }
    // int getTip(){
    //     return this.tip;
    // }
}

class Student extends Pen{   // Inhertance/ Single Level Inheritnace
    String name;
    int age;
}

class Teacher extends Student{ // Multilevel Inhertance
    String subject;
    private int salary;

    void setSalary(int salary){
        this.salary = salary;
    }
    int getSalary(){
        return this.salary;
    }
}