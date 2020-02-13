package pl.beone.promena.transformer.converter.pdfbox

import io.mockk.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import pl.beone.lib.junit.jupiter.external.DockerExtension
import pl.beone.promena.transformer.applicationmodel.mediatype.MediaType
import pl.beone.promena.transformer.contract.data.DataDescriptor
import pl.beone.promena.transformer.contract.model.Parameters
import pl.beone.promena.transformer.converter.pdfbox.applicationmodel.PdfBoxConverterSupport
import pl.beone.promena.transformer.converter.pdfbox.util.createPdfBoxConverterTransformer

@ExtendWith(DockerExtension::class)
class PdfBoxConverterTransformerSupportTest {

    @Test
    fun isSupported() {
        val dataDescriptor = mockk<DataDescriptor>()
        val targetMediaType = mockk<MediaType>()
        val parameters = mockk<Parameters>()

        mockkStatic(PdfBoxConverterSupport::class)
        every { PdfBoxConverterSupport.isSupported(dataDescriptor, targetMediaType, parameters) } just Runs

        createPdfBoxConverterTransformer()
            .isSupported(dataDescriptor, targetMediaType, parameters)

        verify(exactly = 1) { PdfBoxConverterSupport.isSupported(dataDescriptor, targetMediaType, parameters) }
    }
}