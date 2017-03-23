package movie;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "result")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType
public class UniqueID {
	@XmlElement(name = "id")
	public int id;
	
	private static UniqueID instance = null;
	
	protected UniqueID(){}
	
	public static UniqueID getInstance() {
		if(instance == null) {
			instance = new UniqueID();
		}
		return instance;
	}

}
