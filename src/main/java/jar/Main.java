package jar;
import jar.Mapper.Mapper;
import jar.Annotations.Transient;


public class Main {
	public static void main(String[] args)throws Exception {
		Sample sample = new Sample();
		A a = new A();
		Mapper.map(sample);

	}
}