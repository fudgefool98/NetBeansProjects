/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classroom;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author dale
 */
public class CourseXMLLoader {
    
    public static Course load(File xmlCourseFile) throws Exception {
        Course course = new Course();
        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlCourseFile);
            doc.getDocumentElement().normalize();
            NodeList studentNodes = doc.getElementsByTagName("student");
            for (int index = 0; index < studentNodes.getLength(); index++) {
                Node studentNode = studentNodes.item(index);
                if (studentNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element studentElement = (Element) studentNode;
                    String idString = studentElement.getAttribute("id");
                    String pawprint = studentElement.getElementsByTagName("pawprint").item(0).getTextContent();
                    String firstName = studentElement.getElementsByTagName("firstname").item(0).getTextContent();
                    String lastName = studentElement.getElementsByTagName("lastname").item(0).getTextContent();
                    String gradeString = studentElement.getElementsByTagName("grade").item(0).getTextContent();
                    
                    int id = Integer.parseInt(idString);
                    int grade = Integer.parseInt(gradeString);
                    
                    Student student = new Student(id, pawprint, firstName,lastName, grade);
                    course.addStudent(student);
                    
                }
            }
      } catch (Exception e) {
         throw e;
      }
        
      return course; 
    }
}
