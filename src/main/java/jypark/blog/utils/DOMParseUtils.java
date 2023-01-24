package jypark.blog.utils;

import java.io.IOException;
import java.io.StringReader;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.NodeFilter;
import org.w3c.dom.Node;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class DOMParseUtils {

    DocumentBuilderFactory factory;
    DocumentBuilder documentBuilder;
    Document doc;


    public DOMParseUtils(String str) {
        this.factory = DocumentBuilderFactory.newInstance();
        try {
            this.documentBuilder = factory.newDocumentBuilder();
            this.doc = Jsoup.parse(str);
        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Document of(String str) {
        return new DOMParseUtils(str).doc;
    }

    public Node findAny(String className) {
        return null;
    }
}
