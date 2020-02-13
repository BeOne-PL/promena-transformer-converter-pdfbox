package pl.beone.promena.transformer.converter.pdfbox

import pl.beone.promena.transformer.applicationmodel.mediatype.MediaType
import pl.beone.promena.transformer.contract.Transformer
import pl.beone.promena.transformer.contract.communication.CommunicationParameters
import pl.beone.promena.transformer.contract.communication.CommunicationWritableDataCreator
import pl.beone.promena.transformer.contract.data.DataDescriptor
import pl.beone.promena.transformer.contract.data.TransformedDataDescriptor
import pl.beone.promena.transformer.contract.data.toTransformedDataDescriptor
import pl.beone.promena.transformer.contract.model.Parameters
import pl.beone.promena.transformer.converter.pdfbox.applicationmodel.PdfBoxConverterSupport
import pl.beone.promena.transformer.converter.pdfbox.processor.Processor

class PdfBoxConverterTransformer(
    defaultParameters: PdfBoxConverterTransformerDefaultParameters,
    private val communicationParameters: CommunicationParameters,
    private val communicationWritableDataCreator: CommunicationWritableDataCreator
) : Transformer {

    private val processor = Processor(defaultParameters)

    override fun transform(dataDescriptor: DataDescriptor, targetMediaType: MediaType, parameters: Parameters): TransformedDataDescriptor =
        dataDescriptor.descriptors
            .map { processor.process(it, parameters, communicationWritableDataCreator.create(communicationParameters)) }
            .toTransformedDataDescriptor()

    override fun isSupported(dataDescriptor: DataDescriptor, targetMediaType: MediaType, parameters: Parameters) {
        PdfBoxConverterSupport.isSupported(dataDescriptor, targetMediaType, parameters)
    }
}