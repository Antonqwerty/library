package com.antonqwerty.library.service.impl;

import com.antonqwerty.library.service.FileService;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class FileServiceImpl implements FileService {
    private static final Path PATH = Paths.get("C:\\Users\\Admin\\Desktop\\FilesBooks");

    @SneakyThrows
    @Override
    public String saveBook(byte[] bytes, String name) {
        if (!Files.exists(PATH)) {
            Files.createDirectory(PATH);
        }
        Path file = Files.createFile(PATH.resolve(name));
        Files.write(file, bytes);
        return file.toString();
    }
}
