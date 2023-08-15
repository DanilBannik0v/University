package org.example.io;

import org.example.models.Info;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class XmlWriter {
    private static Logger logger = Logger.getLogger(XmlWriter.class.getName());

    private XmlWriter() {
    }

    public static void writeXmlFile(Info info){
        logger.log(Level.INFO, "XML marshalling started");
        try {
            Files.createDirectory(Paths.get("D:\\JavaProgramming\\Projects\\University\\src\\xmlReqs"));
            logger.log(Level.INFO, "Directory created successfully");
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Directory already created");
        }

        File file = new File("D:\\JavaProgramming\\Projects\\University\\src\\xmlReqs\\req" + new Date().getTime() + ".xml");
        JAXBContext context;
        Marshaller marshaller;
        try {
            context = JAXBContext.newInstance(Info.class);
            marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(info, file);
        } catch (JAXBException jaxbE) {
            logger.log(Level.SEVERE, "XML marshalling failed", jaxbE);
        }
        logger.log(Level.INFO, "XML marshalling finished");
    }
}
