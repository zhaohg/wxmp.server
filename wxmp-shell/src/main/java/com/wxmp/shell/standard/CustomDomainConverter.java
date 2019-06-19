package com.wxmp.shell.standard;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * @author zhaohg
 * @date 2019/06/15.
 */

@Component
public class CustomDomainConverter implements Converter<String, DomainObject> {
    
    @Override
    public DomainObject convert(String source) {
        return new DomainObject(source);
    }
}