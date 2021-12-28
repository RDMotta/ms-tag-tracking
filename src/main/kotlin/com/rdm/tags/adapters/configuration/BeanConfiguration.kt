package com.rdm.tags.adapters.configuration

import com.rdm.tags.MsTagsApplication
import com.rdm.tags.application.ports.TagRepositoryPort
import com.rdm.tags.application.services.TagServiceImpl
import org.modelmapper.ModelMapper
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration

@Suppress("SpringJavaInjectionPointsAutowiringInspection")
@Configuration
@ComponentScan(basePackageClasses = arrayOf(MsTagsApplication::class))
class BeanConfiguration {

    @Bean
    fun tagServiceImpl(port: TagRepositoryPort): TagServiceImpl {
        return TagServiceImpl(port)
    }

    @Bean
    fun modelMapper(): ModelMapper {
        return ModelMapper()
    }
}