package ch.jmildner.syst.annotaion;



@Student(name = "Peter Müller", matrikel = 3141592)
public class Application
{
	public static void main(String[] args)
	{
		if (hasStudentAnnotation(Application.class))
		{
			printStudentAnnotation(Application.class);
		}
	}


	private static boolean hasStudentAnnotation(Class<?> c)
	{
		return c.isAnnotationPresent(Student.class);
	}


	private static void printStudentAnnotation(Class<?> c)
	{
		Student s = c.getAnnotation(Student.class);
		System.out.println("Student Information:");
		System.out.println("- Name:     " + s.name());
		System.out.println("- Matrikel: " + s.matrikel());
	}
}
