package com.antonqwerty.library.service;

import lombok.SneakyThrows;

public interface FileService {

    @SneakyThrows
    String saveBook(byte[] bytes, String name);
}
