package testCompare;

import java.util.Comparator;

public class PersonComparator implements Comparator<PersonSort>{

	@Override
	public int compare(PersonSort o1, PersonSort o2) {
		return o1.getAge()-o2.getAge();
	}
	
}
