public class Person{
    private String name;
    private int age;

    public Person(){
        this("John Doe",0);
    }

    public Person(String newName){
        this(newName,0);
    }

    public Person(String newName, int newAge){
        name = newName;
        if(newAge >= 0){
            age = newAge;
        }
    }

    public Person(Person otherPerson){
      this(otherPerson.name, otherPerson.age);
    }

    public String getName(){
        return name;
    }

    public int getAge(){
        return age;
    }
}
