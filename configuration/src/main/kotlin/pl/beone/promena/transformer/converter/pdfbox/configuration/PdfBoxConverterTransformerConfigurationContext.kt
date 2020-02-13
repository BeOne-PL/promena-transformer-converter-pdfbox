package pl.beone.promena.transformer.converter.pdfbox.configuration

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.env.Environment
import pl.beone.promena.transformer.converter.pdfbox.PdfBoxConverterTransformerDefaultParameters
import pl.beone.promena.transformer.converter.pdfbox.configuration.extension.getNotBlankProperty
import pl.beone.promena.transformer.converter.pdfbox.configuration.extension.toDuration

@Configuration
class PdfBoxConverterTransformerConfigurationContext {

    companion object {
        private const val PROPERTY_PREFIX = "transformer.pl.beone.promena.transformer.converter.pdfbox"
    }

    @Bean
    fun pdfBoxConverterTransformerDefaultParameters(environment: Environment): PdfBoxConverterTransformerDefaultParameters =
        PdfBoxConverterTransformerDefaultParameters(
            environment.getNotBlankProperty("$PROPERTY_PREFIX.default.parameters.timeout")?.toDuration()
        )
}