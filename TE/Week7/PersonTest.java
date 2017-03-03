import static org.junit.Assert.*;

import org.junit.Test;


public class PersonTest{
	//Default constructor
	@Test
	public void test1(){
		Person person = new Person();
		String testDescription = "Default Constructor";
		assertEquals(testDescription + ", verifying name", "John Doe", person.getName());
		assertEquals(testDescription + ", verifying age", 0, person.getAge());
	}

	// Single argument (name) constructor
	@Test
	public void test2() {
		Person person = new Person("");
		String testDescription = "Single argument constructor, setting name to empty string";
		assertEquals(testDescription + ", verifying name", "", person.getName());
		assertEquals (testDescription + ", verifying age", 0, person.getAge());
	}

	@Test
	public void test3() {
		Person person = new Person("Hello");
		String testDescription = "Single argument constructor, setting name to 'Hello'";
		assertEquals(testDescription + ", verifying name", "Hello", person.getName());
		assertEquals(testDescription + ", verifying age", 0, person.getAge());
	}

	// Two argument constructor
	@Test
	public void test4() {
		Person person = new Person("", 1);
		String testDescription = "Two argument constructor, setting name to empty string and age to 1";
		assertEquals(testDescription + ", verifying name", "", person.getName());
		assertEquals(testDescription + ", verifying age", 1, person.getAge());
	}

	@Test
	public void test5() {
		Person person = new Person("Jane Small", -1);
		String testDescription = "Two argument constructor, setting name to 'Jane Small' and ageto -1";
		assertEquals(testDescription + ", verifying name", "Jane Small",person.getName());
		assertEquals(testDescription + ", verifying age", 0, person.getAge());
	}

	// copy constructor
	@Test
	public void test6() {
		Person person1 = new Person("Bob Alice", 50);
		Person person2 = new Person(person1);
		String testDescription = "Copy constructor, copying 'Bob Alice', 50";
		assertEquals(testDescription + ", verifying copied name", "Bob Alice",person2.getName());
		assertEquals(testDescription + ", verifying copied age", 50, person2.getAge());
		assertEquals(testDescription + ", verifying original name", "Bob Alice",person1.getName());
		assertEquals(testDescription + ", verifying original age", 50, person1.getAge());
	}
}

