import service.Calculator;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;

public class CalculatorClient {


    public static void main(String[] args) throws MalformedURLException {
        URL url = new URL("http://localhost:12345/calc?wsdl");

        QName qname = new QName("http://service/", "CalculatorImplService");
        Service service = Service.create(url, qname);

        Calculator cal = service.getPort(Calculator.class);

        System.out.println("Operations performed on 15, 3");

        System.out.println("add - " + cal.add(15, 3));
        System.out.println("sub - " + cal.sub(15, 3));
        System.out.println("mul - " + cal.mul(15, 3));
        System.out.println("div - " + cal.div(15, 3));
    }


}
