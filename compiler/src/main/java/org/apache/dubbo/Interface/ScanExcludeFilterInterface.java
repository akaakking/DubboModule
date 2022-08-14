package org.apache.dubbo.Interface;

import ;

public interface ScanExcludeFilterInterface{
    boolean match(org.springframework.core.type.classreading.MetadataReader metadataReader, org.springframework.core.type.classreading.MetadataReaderFactory metadataReaderFactory);
    int getExcludedCount();

}