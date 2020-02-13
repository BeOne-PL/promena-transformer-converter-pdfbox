package pl.beone.promena.transformer.converter.pdfbox.configuration

import mu.KotlinLogging
import org.springframework.context.annotation.Configuration
import pl.beone.promena.transformer.converter.pdfbox.PdfBoxConverterTransformer
import pl.beone.promena.transformer.converter.pdfbox.PdfBoxConverterTransformerDefaultParameters
import javax.annotation.PostConstruct

@Configuration
class PdfBoxConverterTransformerLogger(
    private val defaultParameters: PdfBoxConverterTransformerDefaultParameters
) {

    companion object {
        private val logger = KotlinLogging.logger {}
    }

    @PostConstruct
    private fun log() {
        logger.info {
            "Run <${PdfBoxConverterTransformer::class.java.canonicalName}> with <$defaultParameters>"
        }
    }
}