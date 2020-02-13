package pl.beone.promena.configuration

import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.PropertySource

@Configuration
@ComponentScan(basePackages = ["pl.beone.promena.transformer.converter.pdfbox.configuration"])
@PropertySource("classpath:transformer-converter-pdfbox.properties")
class PdfBoxConverterTransformerModuleContext