package table;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class CSV extends IR {
    public CSV() {

    }

    public CSV(String filePath) throws FileNotFoundException {
        var fis = new FileInputStream(filePath);
        byte[] buff = new byte[1024];
        var sb = new StringBuilder();

        // TODO define setTable in IR super class
        try {
            while(fis.read(buff) > -1)
                for(byte b : buff) {
                    if(b == ',') {
                        // setTable(sb.toString());
                        sb.setLength(0);
                    } else if (b == '\n') {
                        // setTable(sb.toString);
                        sb.setLength(0);
                    } else
                        sb.append((char) b);
                }

            fis.close();
        } catch (IOException e) { e.printStackTrace(); }
    }

    @Override
    public void export() {}

    @Override
    public void export(String filePath) {}

}
