package pl.beone.promena.transformer.converter.pdfbox.util

import io.mockk.mockk
import pl.beone.promena.transformer.contract.communication.CommunicationParameters
import pl.beone.promena.transformer.contract.communication.CommunicationWritableDataCreator
import pl.beone.promena.transformer.contract.model.data.WritableData
import pl.beone.promena.transformer.converter.pdfbox.PdfBoxConverterTransformer
import pl.beone.promena.transformer.converter.pdfbox.PdfBoxConverterTransformerDefaultParameters
import pl.beone.promena.transformer.internal.model.data.memory.emptyMemoryWritableData

internal object MemoryCommunicationWritableDataCreator : CommunicationWritableDataCreator {
    override fun create(communicationParameters: CommunicationParameters): WritableData = emptyMemoryWritableData()
}

internal fun createPdfBoxConverterTransformer(
    parameters: PdfBoxConverterTransformerDefaultParameters = PdfBoxConverterTransformerDefaultParameters()
): PdfBoxConverterTransformer =
    PdfBoxConverterTransformer(parameters, mockk(), MemoryCommunicationWritableDataCreator)