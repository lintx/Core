package com.iCo6.util;

import com.iCo6.iConomy;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

public class Common {
    public static void extract(String... names) {
        for(String name: names) {
            File actual = new File(iConomy.directory, name);

            if(actual.exists())
                continue;

            InputStream input = iConomy.class.getResourceAsStream("/resources/" + name);

            if(input == null)
                continue;

            FileOutputStream output = null;

            try {
                output = new FileOutputStream(actual);
                byte[] buf = new byte[8192];
                int length = 0;

                while ((length = input.read(buf)) > 0)
                    output.write(buf, 0, length);

                System.out.println("[iConomy] Default setup file written: " + name);
            } catch (Exception e) {
            } finally {
                try { if (input != null) input.close();
                } catch (Exception e) { }

                try { if (output != null) output.close();
                } catch (Exception e) { }
            }
        }
    }
}
