package src.main.java.engine;
import javax.xml.namespace.QName;
import javax.xml.stream.*;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.LocalDate;

public class Parse {
    private Post post;
    private Users users;
    private Tag tag;

    public Parse() {
        this.post = new Post();
        this.users = new Users();
        this.tag = new Tag();
    }

    public void parsePosts(String fileName, Struct estrutura) {
        XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
        try {
            XMLEventReader xmlEventReader = xmlInputFactory.createXMLEventReader(new FileInputStream(fileName));
            while (xmlEventReader.hasNext()) {
                XMLEvent xmlEvent = xmlEventReader.nextEvent();
                if (xmlEvent.isStartElement()) {
                    StartElement startElement = xmlEvent.asStartElement();
                    if (startElement.getName().getLocalPart().equals("row")) {
                        this.post = new Post();
                        Attribute pIdAttr = startElement.getAttributeByName(new QName("PostTypeId"));
                        if (pIdAttr != null) {
                            this.post.setPostTypeId(Integer.parseInt(pIdAttr.getValue()));
                        }
                        Attribute parentIdAttr = startElement.getAttributeByName(new QName("ParentId"));
                        if (parentIdAttr != null) {
                            this.post.setParentID(Integer.parseInt(parentIdAttr.getValue()));
                        }
                        Attribute ownIdAttr = startElement.getAttributeByName(new QName("OwnerUserId"));
                        if (ownIdAttr != null) {
                            this.post.setOwnerUserID(Integer.parseInt(ownIdAttr.getValue()));
                        }
                        Attribute ACountAttr = startElement.getAttributeByName(new QName("AnswerCount"));
                        if (ACountAttr != null) {
                            this.post.setAnswerCount(Integer.parseInt(ACountAttr.getValue()));
                        }
                        Attribute CCountAttr = startElement.getAttributeByName(new QName("CommentCount"));
                        if (CCountAttr != null) {
                            this.post.setCommentCount(Integer.parseInt(CCountAttr.getValue()));
                        }
                        Attribute scoreAttr = startElement.getAttributeByName(new QName("Score"));
                        if (scoreAttr != null) {
                            this.post.setScore(Integer.parseInt(scoreAttr.getValue()));

    public void parseTags(String fileName, Struct estrutura) {
        XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
        try {
            XMLEventReader xmlEventReader = xmlInputFactory.createXMLEventReader(new FileInputStream(fileName));
            while (xmlEventReader.hasNext()) {
                this.tag = new Tag();
                XMLEvent xmlEvent = xmlEventReader.nextEvent();
                if (xmlEvent.isStartElement()) {
                    StartElement startElement = xmlEvent.asStartElement();
                    if (startElement.getName().getLocalPart().equals("row")) {
                        Attribute idAttr = startElement.getAttributeByName(new QName("Id"));
                        if (idAttr != null) {
                            this.tag.setId(Integer.parseInt(idAttr.getValue()));
                        }
                        Attribute nameAttr = startElement.getAttributeByName(new QName("TagName"));
                        if (nameAttr != null) {
                            this.tag.setTagName(nameAttr.getValue());
                        }
                    }
                }
                estrutura.addTags(this.tag);
            }
        } catch (FileNotFoundException | XMLStreamException e) {
            e.printStackTrace();
        }
    }
}

