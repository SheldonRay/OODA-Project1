import java.io.InputStream;
import java.util.Scanner;

public class Zoo {

    public static void runDaysAtZoo(int days, Animal[] ZooAnimals){//Encapsulation begins here
        int i = 0;
        while (i< days){
            System.out.println("Zookeeper arrives at zoo on Day "+ (i+1)+ " at the zoo!");
            ZooKeeper z = new ZooKeeper();
            for (int j = 0; j < ZooAnimals.length; j++) {
                z.wakeAnimals(ZooAnimals[j]);
            }
            System.out.println("\n" + "Roll Call!");
            for (int k = 0; k < ZooAnimals.length; k++) {
                z.RollCallAnimals(ZooAnimals[k]);
            }
            System.out.println("\n");
            for (int j = 0; j <ZooAnimals.length; j++){
                z.feedAnimals(ZooAnimals[j]);
            }
            System.out.println("\n");

            for (int g = 0; g < ZooAnimals.length ; g++) {
                z.exerciseAnimals(ZooAnimals[g]);
            }
            System.out.println("\n");
            for (int j = 0; j <ZooAnimals.length; j++){
                z.sleep(ZooAnimals[j]);
            }
            System.out.println("Zookeeper leaves the zoo for the night");
            i++;
        }
    }

    public static void main(String[] args){
        //need to instansiate the animals here first
        Animal Leo = new Lion("Leo the Lion");
        Animal Charlie = new Cat("Charlie the Cat");
        Animal Henry = new Hippo("Henry the Hippo");
        Animal Rich = new Rhino("Rich the Rhino");
        Animal Doug = new Dog("Doug the Dog");
        Animal Walter = new Wolf("Walter the Wolf");
        Animal Fred = new Frog("Fred the Frog");
        Animal Tim = new Toad("Tim the Toad");

        Animal[] ZooAnimals = {Leo, Charlie, Henry, Rich, Doug, Walter, Fred, Tim}; // All animals put into an Array

        Scanner in = new Scanner(System.in); //I have never used java so Scanner was found from ::https://stackoverflow.com/questions/4238384/java-equivalent-of-cin-c
        //I then reused logic of this for the rest of the assignment
        System.out.println("How many days would you like to run the zoo?");
        int days = 0;
        days = in.nextInt();
        runDaysAtZoo(days, ZooAnimals);

    }

    public static int RandNumberFunction(){
        return (int) (Math.random()*100);// Gives a random number from 1-100
        //This Randnumber function was taken from(below)
        //https://www.java67.com/2015/01/how-to-get-random-number-between-0-and-1-java.html
    }
}


class ZooEmployee extends Zoo{
    // Write the methods here for the things below
    //The zoo keeper has different things than the animals.
    //wake the animals, roll call the animals, feed the animals, exercise the animals, and tell the animals to sleep.

}


class ZooKeeper extends ZooEmployee{
    public void wakeAnimals(Animal A){
        System.out.println("Zookeeper wakes " + A.getName());
        System.out.println(A.getName()+ " wakes up");
    }
    public void RollCallAnimals(Animal A){
        System.out.println(A.getName()+ " is here");
    }
    public void feedAnimals(Animal A){
        System.out.println("Zookeeper feeds " + A.getName());
        System.out.println(A.getName()+ " eats");
    }
    public void exerciseAnimals(Animal A){
        System.out.println("Zookeeper tells " + A.getName() +" Exercises");
        System.out.println(A.getName()+ A.Exercise());
    }
    public void sleep(Animal A){
        System.out.println("Zookeeper tells " + A.getName() + " goes to Sleep");
        System.out.println(A.getName()+ A.Sleep());
    }
}


class Animal extends Zoo{
    private String name = "";

    public void setName(String s){
        name = s;
    }
    public String getName(){
        return name;
    }
    public void Roam(){
        System.out.println(name + " roams");
    }
    public String Sleep(){
        return " goes to sleep";
    }
    public void Eat(){
        System.out.println(name + " eats");
    }
    public String Exercise(){

        return " to exercise";
    }
    //All animals need to have the sleep, roam , eat functions.
    //This will correspond to the text that gets output.
    //All animals need to inherit these ::wake up, make noise, eat, roam, and sleep.
}
//Start all Pachyderms
class Pachyderm extends Animal{
    public String name ="";
    @Override
    public String  Exercise(){
        int randNum = RandNumberFunction();
        if (randNum <= 25){
            return " Charges!!";
        }
        return (name + " exercises");
    }

}

class Rhino extends Pachyderm{
    public String name ="";

    Rhino(String s){//Constuctor to make naming easier
        name = s;
    }
    @Override
    public String getName(){
        return name;
    }
}

class Hippo extends Pachyderm{
    public String name ="";

    Hippo(String s){//Constuctor to make naming easier
        name = s;
    }
    @Override
    public String getName(){
        return name;
    }
}
//End all Pachyderms

//Start all felines
class Feline extends Animal{
    public String name ="";
    public String makeNoise(){
        return " purrrr";
    }
    @Override
    public String Sleep(){
        int num = RandNumberFunction();
        if (num <= 30){//30% chance
            return " roams";
        }
        else if (num > 30 && num <=70){//40% Chance
            return  " goes to sleep";
        }else {
            return this.makeNoise(); //30% Chance
        }

    }
}

class Lion extends Feline{
    public String name ="";

    Lion(String s){//Constuctor to make naming easier
        name = s;
    }
    @Override
    public String makeNoise(){
        return  " Roars!";
    }
    @Override
    public String getName(){
        return name;
    }
}

class Cat extends Feline{
    public String name ="";

    Cat(String s){//Constuctor to make naming easier
        name = s;
    }
    @Override
    public String getName(){
        return name;
    }
    @Override
    public String makeNoise(){
        return  " Purrs...";
    }

}
//End all Felines

//Start all Canines
class Canine extends Animal{
    public String name ="";

}

class Dog extends Canine{
    public String name ="";

    Dog(String s){//Constuctor to make naming easier
        name = s;
    }
    @Override
    public String Exercise(){
        int num = RandNumberFunction();
        if(num <= 25){ // 25% chance
            return " decided to Dig instead of Exercise";
        }
        return " to Exercise";
    }
    @Override
    public String getName(){
        return name;
    }
}

class Wolf extends Canine{
    public String name ="";

    Wolf(String s){//Constuctor to make naming easier
        name = s;
    }
    @Override
    public String getName(){
        return name;
    }
}
//End all Canines

//Start all Amphibians
class Amphibian extends Animal{
    public String name ="";

}

class Frog extends Amphibian{
    public String name ="";

    Frog(String s){//Constuctor to make naming easier
        name = s;
    }
    @Override
    public String getName(){
        return name;
    }
}

class Toad extends Amphibian{
    public String name ="";

    Toad(String s){//Constuctor to make naming easier
        name = s;
    }
    @Override
    public String getName(){
        return name;
    }
}
//End all amphibians