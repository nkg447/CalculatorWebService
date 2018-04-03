import service.Calculator;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;

public class CalculatorClient {


    public static void main(String[] args) throws MalformedURLException {
        URL url = new URL("http://0.0.0.0:12345/calc?wsdl");

        QName qname = new QName("http://service/", "CalculatorImplService");
        Service service = Service.create(url, qname);

        Calculator cal=service.getPort(Calculator.class);

        System.out.println(cal.add(10,15));
    }


}
