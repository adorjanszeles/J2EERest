package movie;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "movies")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "id", propOrder = {"idList"})
@XmlSeeAlso(Integer.class)
public class IDList {
	@XmlElement(name = "id", type = Integer.class, nillable = true)
	public List<Integer> idList;
	
	public IDList() {
		idList = new ArrayList<Integer>();
	}

}
