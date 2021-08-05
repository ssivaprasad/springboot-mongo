package com.ssp.apps.springboot.mongo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class File {
    private String uploadId;
    private String filename;
    private String fileType;
    private String fileSize;
    private byte[] file;
}
