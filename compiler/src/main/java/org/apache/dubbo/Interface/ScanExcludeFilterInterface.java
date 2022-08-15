package org.apache.dubbo.Interface;

import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.classreading.MetadataReader;

public interface ScanExcludeFilterInterface {
    boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory);
    int getExcludedCount();
}