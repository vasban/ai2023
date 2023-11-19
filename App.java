import java.util.ArrayList;

public class App {
    public static void main(String [] args){
        Person kid1 = new Person("kid1",1);
        Person kid2 = new Person("kid2",3);
        Person dad = new Person("dad",8);
        Person mom = new Person("mom",7);
        Person grandpa = new Person ("pouspa",12);

        State s1 = new State();
        
       

        System.out.println(s1.getF());
        System.out.println(s1.getG());
        System.out.println(s1.getH());
        
        s1.rightside.add(kid1);
        s1.rightside.add(kid2);
        s1.rightside.add(dad);
        s1.rightside.add(mom);
        s1.rightside.add(grandpa);

        for(Person p : s1.rightside){
            System.out.println(p.getName()+" time is :"+p.getTime());
        }

      

      for (Person p : s1.leftside){
        System.out.println(p.getName()+" time is :"+p.getTime());
      }
      s1.evaluate();
       System.out.println(s1.getF());
        System.out.println(s1.getG());
        System.out.println(s1.getH());

      System.out.println(s1.getChildren());
      System.out.println(s1.getChildren());
      System.out.println(s1.getChildren());

      State s2 = new State(s1);
      for(Person p : s2.leftside)
        System.out.println(p.getName());
        //tsekare ta paidia State;
    }
}
