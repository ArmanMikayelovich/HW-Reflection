package jar.Mapper;

import java.lang.IllegalAccessException;

import jar.Annotations.Transient;
import java.lang.reflect.*;
public class Mapper {
	public static <Obj> String[] map(Obj object) throws Exception  {
		Class target = object.getClass();
		Field[] fields = target.getDeclaredFields();
		//Constructing json format...
		StringBuilder jsonText = new StringBuilder();
		String tab = "\t";
		jsonText.append("{\n");
        String fullname = object.getClass().toString();
        String[] namearr = object.getClass().toString().split(" ");
        String className = namearr[1];
        jsonText.append(tab+"\"" + className + "\" : { \n");
		for(Field field : fields) {
			if(!field.isAnnotationPresent(Transient.class)) {
			    field.setAccessible(true);

//			System.out.println(field.toString());
//			System.out.println(field.getType());
//			System.out.println(field.getName());
//			System.out.println(field.get(object));
//			System.out.println(object.toString());
//			System.out.println("");

                jsonText.append(tab + "" + tab + "\"" + field.getName() + "\" : \"" + field.get(object) +  "\",\n " );


            }


		}
		//deleting last ","
        int lastIndex = jsonText.lastIndexOf(",");
        jsonText.setCharAt(lastIndex,' ');
        System.out.println();
        jsonText.append(tab + "}\n ");
        jsonText.append("}");
        System.out.println(jsonText.toString());
		return null;

	}
}