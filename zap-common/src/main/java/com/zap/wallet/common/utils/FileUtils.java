package com.zap.wallet.common.utils;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

public class FileUtils {

    public static byte[] getFileBytes(String classPathRelativeFilename) throws IOException, URISyntaxException {

        final URL systemResource = FileUtils.class.getClassLoader().getResource(classPathRelativeFilename);

        final URI uri = Objects.requireNonNull(systemResource).toURI();

        final Path path = Paths.get(uri);

        return Files.readAllBytes(path);
    }

    public static void writeToFile(File file, String content) throws Exception {
        // Declaring the print writer with path
        PrintWriter pw = new PrintWriter(file);
        // Now calling writer() method with string
        pw.write(content);
        // Flushing the print writer
        pw.flush();
        // Lastly closing the printwriter
        // using the close() method
        pw.close();
    }
}
