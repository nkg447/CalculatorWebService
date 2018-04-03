package service;

import javax.jws.WebService;
import javax.xml.ws.Endpoint;

@WebService(endpointInterface = "service.Calculator")
public class CalculatorImpl implements Calculator {

    public static void main(String[] args) {
        String url = "http://0.0.0.0:12345/calc";
        Endpoint.publish(url, new CalculatorImpl());

    }


    public int calculate(int x, int y, String operation) {
        int result=0;
        operation=operation.toUpperCase();
        String op;
        if ("ADD".equals(operation)) {
            result = x + y;
            op = "+";
        } else if ("SUB".equals(operation)) {
            result = x - y;
            op = "-";
        } else if ("MULT".equals(operation)) {
            result = x * y;
            op = "*";
        } else if ("DIV".equals(operation)) {
            result = x / y;
            op = "/";
        } else {
            op="Enter ADD/SUB/MULT/DIV";
        }

        if(op.equals("Enter ADD/SUB/MULT/DIV"))
            System.out.println("\n\n"+op);
        else
            log(x, y, result, op);

        return result;
    }
    private static void log(int x, int y, int result, String op) {
        System.out.println("\n\n"+x+" "+op+" "+y+" = "+result);
    }
}