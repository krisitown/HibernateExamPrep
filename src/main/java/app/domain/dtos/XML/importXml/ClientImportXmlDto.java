package app.domain.dtos.XML.importXml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * Created by krisitown on 10.12.16.
 */
@XmlRootElement(name = "client")
@XmlAccessorType(XmlAccessType.FIELD)
public class ClientImportXmlDto implements Serializable{

    @XmlAttribute
    private String name;

    @XmlAttribute
    private String town;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }
}
