package ch.jmildner.syst.annotaion;


import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface Student
{
	String name();


	int matrikel();
}
