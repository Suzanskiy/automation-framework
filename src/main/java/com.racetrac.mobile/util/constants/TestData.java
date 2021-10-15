package com.racetrac.mobile.util.constants;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

public class TestData {

    private static final Logger LOG = LoggerFactory.getLogger(TestData.class);

    public static String readFromFile(String path) {
        String fileContent = "";

        ClassPathResource resource = new ClassPathResource(path);

        try (InputStream inputStream = resource.getInputStream()) {
            fileContent = IOUtils.toString(inputStream, Charset.defaultCharset());
        } catch (IOException e) {
            LOG.error(e.getMessage());
        }
        return fileContent;
    }
}
