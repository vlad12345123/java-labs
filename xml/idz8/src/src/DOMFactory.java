import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class DOMFactory {


    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        Document document = builder.parse(new File("XmlExRates.aspx.xml"));

        NodeList currencyNodeList = document.getElementsByTagName("Currency");
        ArrayList<Currency> currencyList = new ArrayList<Currency>();
        Element currElement = (Element) document.getElementsByTagName("DailyExRates").item(0);
        String date = currElement.getAttribute("Date");
        System.out.println("Date = " + date);


        for (int i = 0; i < currencyNodeList.getLength(); i++) {
            if (currencyNodeList.item(i).getNodeType() == Node.ELEMENT_NODE) {
                Element curElement = (Element) currencyNodeList.item(i);
                Currency currency = new Currency();
                Element cuElement = (Element) document.getElementsByTagName("Currency").item(0);
                currency.setId(Integer.parseInt(cuElement.getAttribute("Id")));
                NodeList currencyNodes = curElement.getChildNodes();
                for (int j = 0; j < currencyNodes.getLength(); j++) {
                    if (currencyNodes.item(j).getNodeType() == Node.ELEMENT_NODE) {
                        Element currencyElement = (Element) currencyNodes.item(j);
                        switch (currencyElement.getNodeName()) {
                            case "NumCode": {
                                currency.setNumCode(currencyElement.getTextContent()); // получение текстового контента
                            }
                            break;
                            case "CharCode": {
                                currency.setCharCode(currencyElement.getTextContent());
                            }
                            break;
                            case "Scale": {
                                currency.setScale(currencyElement.getTextContent());
                            }
                            break;
                            case "Name": {
                                currency.setName(currencyElement.getTextContent());
                            }
                            break;
                            case "Rate": {
                                currency.setRate(currencyElement.getTextContent());
                            }

                        }

                    }
                }
                currencyList.add(currency);
            }

        }
        currencyList.forEach(System.out::println);


    }

}
