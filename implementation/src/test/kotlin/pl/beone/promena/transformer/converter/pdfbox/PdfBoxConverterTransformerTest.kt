package pl.beone.promena.transformer.converter.pdfbox

import io.kotlintest.matchers.collections.shouldHaveSize
import io.kotlintest.matchers.withClue
import io.kotlintest.shouldBe
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import pl.beone.lib.junit.jupiter.external.DockerExtension
import pl.beone.promena.transformer.applicationmodel.mediatype.MediaTypeConstants.APPLICATION_PDF
import pl.beone.promena.transformer.applicationmodel.mediatype.MediaTypeConstants.TEXT_PLAIN
import pl.beone.promena.transformer.contract.data.singleDataDescriptor
import pl.beone.promena.transformer.converter.pdfbox.applicationmodel.pdfBoxConverterParameters
import pl.beone.promena.transformer.converter.pdfbox.model.Resource.Document.TEST
import pl.beone.promena.transformer.converter.pdfbox.util.createPdfBoxConverterTransformer
import pl.beone.promena.transformer.converter.pdfbox.util.getResourceAsBytes
import pl.beone.promena.transformer.internal.model.data.memory.toMemoryData
import pl.beone.promena.transformer.internal.model.metadata.emptyMetadata

@ExtendWith(DockerExtension::class)
class PdfBoxConverterTransformerTest {

    @Test
    fun transform() {
        val mediaType = APPLICATION_PDF
        val metadata = emptyMetadata()

        with(
            createPdfBoxConverterTransformer()
                .transform(
                    singleDataDescriptor(getResourceAsBytes(TEST).toMemoryData(), mediaType, metadata),
                    TEXT_PLAIN,
                    pdfBoxConverterParameters()
                )
        ) {
            withClue("Transformed data should contain only <1> element") { descriptors shouldHaveSize 1 }

            with(descriptors[0]) {
                String(data.getBytes()) shouldBe
                        listOf("Page 1", "Page 2", "Page 3", "Page 4", "Page 5", "Page 6", "Page 7", "Page 8", "Page 9", "Page 10").joinToString("\n")
                this.metadata shouldBe metadata
            }
        }
    }
}