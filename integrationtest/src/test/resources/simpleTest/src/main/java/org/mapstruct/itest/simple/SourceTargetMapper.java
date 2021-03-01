/*
 * Copyright MapStruct Authors.
 *
 * Licensed under the Apache License version 2.0, available at http://www.apache.org/licenses/LICENSE-2.0
 */
package org.mapstruct.itest.simple;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.factory.Mappers;

@Mapper(uses = ReferencedCustomMapper.class)
public interface SourceTargetMapper {

    SourceTargetMapper INSTANCE = Mappers.getMapper( SourceTargetMapper.class );

    @Mappings({
        @Mapping(target = "baz", source = "qax"),
        @Mapping(target = "qax", source = "baz"),
        @Mapping(target = "fromNested", source = "forNested.value")
    })
    Target sourceToTarget(Source source);

    @InheritInverseConfiguration
    @Mappings({
        @Mapping(target = "forNested", ignore = true),
        @Mapping(target = "extendsBound", ignore = true)
    })
    Source targetToSource(Target target);
}
