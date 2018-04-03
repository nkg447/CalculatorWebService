package service;

import javax.jws.WebService;
import javax.xml.ws.Endpoint;

@WebService(endpointInterface = "service.Calculator")
public class CalculatorImpl implements Calculator {

    public static void main(String[] args) {
        String url = "http://0.0.0.0:12345/calc";
        Endpoint.publish(url, new CalculatorImpl());

        System.out.println("Web Service started");
        System.out.println("wsdl link - " + url + "?wsdl");
    }

    private static void log(int x, int y, String op) {
        System.out.println("result for (" + x + " " + op + " " + y + ") sent");
    }

    @Override
    public int add(int a, int b) {
        log(a, b, "+");
        return a + b;
    }

    @Override
    public int sub(int a, int b) {
        log(a, b, "-");
        return a - b;
    }

    @Override
    public int mul(int a, int b) {
        log(a, b, "*");
        return a * b;
    }

    @Override
    public int div(int a, int b) {
        log(a, b, "/");
        return a / b;
    }
}