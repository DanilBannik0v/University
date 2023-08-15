package org.example.utility;

import org.example.models.Student;
import org.example.models.University;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.io.StringWriter;

public class JAXBUtility {
    public static String studentToXml(Student student){
        StringWriter writer = new StringWriter();
        JAXBContext context;
        Marshaller marshaller;
        try {
            context = JAXBContext.newInstance(Student.class);
            marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(student, writer);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return writer.toString();
    }

    public static Student xmlToStudent(String xml) {
        StringReader reader = new StringReader(xml);

        JAXBContext context = null;
        Student student;
        try {
            context = JAXBContext.newInstance(Student.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            student = (Student) unmarshaller.unmarshal(reader);
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
        return student;
    }
    public static String universityToXml(University university){
        StringWriter writer = new StringWriter();
        JAXBContext context;
        Marshaller marshaller;
        try {
            context = JAXBContext.newInstance(University.class);
            marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(university, writer);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return writer.toString();
    }

    public static University xmlToUniversity(String xml) {
        StringReader reader = new StringReader(xml);

        JAXBContext context = null;
        University university;
        try {
            context = JAXBContext.newInstance(University.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            university = (University) unmarshaller.unmarshal(reader);
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
        return university;
    }
}
