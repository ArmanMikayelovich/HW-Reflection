package jar;

import jar.Annotations.Transient;

public class Sample {
	String name;
	public Sample() {}
	public Sample(String name) {this.name = name;}
	@Transient
	int x = 0;

	
	String s  = "Hello";
	double d = 1.25;


}