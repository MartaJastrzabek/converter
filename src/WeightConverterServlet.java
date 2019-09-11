import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/weightconverter")
public class WeightConverterServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        WeightConverter converter = new WeightConverter();

        String kilograms = request.getParameter("kilograms");
        String grams = request.getParameter("grams");
        String milligrams = request.getParameter("milligrams");

        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();

        if (!kilograms.isEmpty() && grams.isEmpty() && milligrams.isEmpty()) {
            converter.setKilograms(Double.parseDouble(kilograms));
            converter.setType(WeightType.KILOGRAMS);
            printWeightConverted(writer, converter);

        } else if (kilograms.isEmpty() && !grams.isEmpty() && milligrams.isEmpty()) {
            converter.setGrams(Double.parseDouble(grams));
            converter.setType(WeightType.GRAMS);
            printWeightConverted(writer, converter);

        } else if (kilograms.isEmpty() && grams.isEmpty() && !milligrams.isEmpty()) {
            converter.setMilligrams(Double.parseDouble(milligrams));
            converter.setType(WeightType.MILLIGRAMS);
            printWeightConverted(writer, converter);

        } else {
            writer.println("Nieprawidłowe dane wejściowe. Należy podać jedną wartość");
        }

    }

    private static void printWeightConverted(PrintWriter writer, WeightConverter converter) {
        converter.calculate();

        writer.println("<html>");
        writer.println("<head>");
        writer.println("<title>Przelicznik wag</title>");
        writer.println("</head>");
        writer.println("<body>");
        writer.println("<h2>Podana wartość w przeliczeniu na: </h2>");
        writer.println("<p>kilogramy: " + converter.getKilograms() + "</p>");
        writer.println("<p>gramy: " + converter.getGrams() + "</p>");
        writer.println("<p>miligramy: " + converter.getMilligrams() + "</p>");
        writer.println("</body>");
        writer.println("</html>");
    }
}
