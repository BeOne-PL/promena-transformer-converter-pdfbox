package pl.beone.promena.transformer.converter.pdfbox.configuration

import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import pl.beone.promena.transformer.contract.communication.CommunicationParameters
import pl.beone.promena.transformer.contract.communication.CommunicationWritableDataCreator
import pl.beone.promena.transformer.converter.pdfbox.PdfBoxConverterTransformer
import pl.beone.promena.transformer.converter.pdfbox.PdfBoxConverterTransformerDefaultParameters

@Configuration
class PdfBoxConverterTransformerContext {

    @Bean
    fun pdfBoxConverterTransformer(
        defaultParameters: PdfBoxConverterTransformerDefaultParameters,
        @Qualifier("internalCommunicationParameters") communicationParameters: CommunicationParameters,
        @Qualifier("internalCommunicationWritableDataCreator") communicationWritableDataCreator: CommunicationWritableDataCreator
    ) =
        PdfBoxConverterTransformer(
            defaultParameters,
            communicationParameters,
            communicationWritableDataCreator
        )
}