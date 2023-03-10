import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import database.DataBase;
import fileio.input.InputData;
import fileio.output.OutputData;
import site.Site;
import site.UserLoggedIn;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    /**
     * Read values, write values and is the entry to site
     * @param args store inputPath and outputPath
     */
    public static void main(final String[] args) {
        String inputPath = args[0];
        String outputPath = args[1];

        File inputFile = new File(inputPath);
        File outputFile = new File(outputPath);

        ObjectMapper objectMapper = new ObjectMapper();

        /* Read values from input files */
        InputData inputData = new InputData();
        try {
            inputData = objectMapper.readValue(inputFile, InputData.class);
        } catch (IOException exception) {
            exception.printStackTrace();
        }

        /* Set DataBase */
        DataBase.setDataBase(inputData);

        ArrayList<OutputData> outputData = new ArrayList<>();

        Site.useSite(outputData, inputData);

        ObjectWriter objectWriter = objectMapper.writer(new DefaultPrettyPrinter());
        try {
            File output = new File(inputPath + "out");
            objectWriter.writeValue(outputFile, outputData);
        } catch (IOException exception) {
            exception.printStackTrace();
        }

        DataBase.resetDB();
        UserLoggedIn.getInstance().reset();
    }
}
