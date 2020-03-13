package manejo_datos;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;

public interface Utils {
	
	default List<Player>getPlayers(){

        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        InputStream csvfile = loader.getResourceAsStream("data.csv");
        MappingIterator<Player> personIter;
        try {
            assert csvfile != null;
            personIter = new CsvMapper()
                    .readerWithTypedSchemaFor(Player.class)
                    .readValues(csvfile);
            return personIter.readAll();
        } catch (IOException e) {
            throw new RuntimeException("Error in setup, possibly by the file mapper");
        }
    }

}
