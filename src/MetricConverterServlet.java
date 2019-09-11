import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/metricconverter")
public class MetricConverterServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        MetricConverter converter = new MetricConverter();

        String meters = request.getParameter("meters");
        String centimeters = request.getParameter("centimeters");
        String millimeters = request.getParameter("millimeters");

        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();

        if (!meters.isEmpty() && centimeters.isEmpty() && millimeters.isEmpty()) {
            converter.setMeters(Double.parseDouble(meters));
            converter.setType(MetricType.METERS);
            printMetricConverted(writer, converter);

        } else if (meters.isEmpty() && !centimeters.isEmpty() && millimeters.isEmpty()) {
            converter.setCentimeters(Double.parseDouble(centimeters));
            converter.setType(MetricType.CENTIMETRES);
            printMetricConverted(writer, converter);

        } else if (meters.isEmpty() && centimeters.isEmpty() && !millimeters.isEmpty()) {
            converter.setMillimeters(Double.parseDouble(millimeters));
            converter.setType(MetricType.MILLIMETERS);
            printMetricConverted(writer, converter);
        } else {
            writer.println("Nieprawidłowe dane wejściowe. Należy podać jedną wartość");
        }

    }

    private static void printMetricConverted(PrintWriter writer, MetricConverter converter) {
        converter.calculate();

        writer.println("<html>");
        writer.println("<head>");
        writer.println("<title>Przelicznik metryczny</title>");
        writer.println("</head>");
        writer.println("<body>");
        writer.println("<h2>Podana wartość w przeliczeniu na: </h2>");
        writer.println("<p>metry: " + converter.getMeters() + "</p>");
        writer.println("<p>centymetry: " + converter.getCentimeters() + "</p>");
        writer.println("<p>milimetry: " + converter.getMillimeters() + "</p>");
        writer.println("</body>");
        writer.println("</html>");
    }
}
