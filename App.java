import java.util.ArrayList;

public class App {
    public static void main(String [] args){
        Person kid1 = new Person("kid1",1);
        Person kid2 = new Person("kid2",3);
        Person dad = new Person("dad",8);
        Person mom = new Person("mom",7);
        Person grandpa = new Person ("pouspa",12);

        State s1 = new State();
        
        
        s1.rightside.add(kid1);
        s1.rightside.add(kid2);
        s1.rightside.add(dad);
        s1.rightside.add(mom);
        s1.rightside.add(grandpa);

        
    


     System.out.println(s1);

     State s2 = new State(s1.getChildren().get(1));
     State s3 = new State(s1.getChildren().get(2));
     State s4 = new State(s1.getChildren().get(5));

     System.out.println(s2);
     System.out.println(s3);
     System.out.println(s4);
    //   System.out.println(s1.getChildren());
    //   System.out.println(s1.getChildren());
    //   System.out.println(s1.getChildren());

    //   State s2 = new State(s1.getChildren().get(1));

    //   System.out.println(s2.rightside);
    //   System.out.println(s2.leftside);

    //   for(int i =0; i<s2.rightside.size();i++){
    //     System.out.println(s2.rightside.get(i).getName()+ " State 2 rightside");
    //   }
    //   for(int i =0; i<s2.leftside.size();i++){
    //     System.out.println(s2.leftside.get(i).getName()+" State 2 left side");
    //   }

    //   State s3 = new State(s2.getChildren().get(1));

    //   for(int i =0; i<s3.rightside.size();i++){
    //     System.out.println(s3.rightside.get(i).getName()+" State 3 rightside");
    //   }
    //   for(int i =0; i<s3.leftside.size();i++){
    //     System.out.println(s3.leftside.get(i).getName()+" Sate 3 leftside");
    //   }

    //   State s4 = new State(s3.getChildren().get(1));

    //   for(int i =0; i<s4.rightside.size();i++){
    //     System.out.println(s4.rightside.get(i).getName()+" State 4 rightside");
    //   }
    //   for(int i =0; i<s4.leftside.size();i++){
    //     System.out.println(s4.leftside.get(i).getName()+" Sate 4 leftside");
    //   }
        
    }
}
