package pl.beone.promena.transformer.converter.pdfbox.processor

import kotlinx.coroutines.asCoroutineDispatcher
import org.apache.pdfbox.pdmodel.PDDocument
import pl.beone.promena.transformer.contract.data.DataDescriptor
import pl.beone.promena.transformer.contract.data.TransformedDataDescriptor
import pl.beone.promena.transformer.contract.data.singleTransformedDataDescriptor
import pl.beone.promena.transformer.contract.model.Parameters
import pl.beone.promena.transformer.contract.model.data.WritableData
import pl.beone.promena.transformer.converter.pdfbox.PdfBoxConverterTransformerDefaultParameters
import pl.beone.promena.transformer.converter.pdfbox.extension.readPages
import pl.beone.promena.transformer.internal.extension.copy
import pl.beone.promena.transformer.util.execute
import java.util.concurrent.Executors

internal class Processor(
    private val defaultParameters: PdfBoxConverterTransformerDefaultParameters
) {

    private val executionDispatcher = Executors.newSingleThreadExecutor().asCoroutineDispatcher()

    fun process(
        singleDataDescriptor: DataDescriptor.Single,
        parameters: Parameters,
        transformedWritableData: WritableData
    ): TransformedDataDescriptor.Single {
        val (data, _, metadata) = singleDataDescriptor

        PDDocument.load(data.getInputStream()).use { pdDocument ->
            execute(parameters.getTimeoutOrNull() ?: defaultParameters.timeout, executionDispatcher) {
                transformedWritableData.copy(readText(pdDocument).byteInputStream())
            }
        }

        return singleTransformedDataDescriptor(transformedWritableData, metadata)
    }

    private fun readText(pdDocument: PDDocument): String =
        pdDocument.readPages().joinToString("\n")
}