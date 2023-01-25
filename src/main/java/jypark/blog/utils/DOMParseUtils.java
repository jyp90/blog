package jypark.blog.utils;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.w3c.dom.Node;

@Slf4j
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
            log.error(ExceptionUtils.getStackTrace(e));
            throw new RuntimeException(e);
        } catch (Exception e) {
            log.error(ExceptionUtils.getStackTrace(e));
        }
    }

    public static Document of(String str) {
        return new DOMParseUtils(str).doc;
    }

    public Node findAny(String className) {
        return null;
    }
}
