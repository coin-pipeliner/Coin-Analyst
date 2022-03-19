package coinanalysis.records;

import org.apache.flink.api.common.serialization.DeserializationSchema;
import org.apache.flink.api.common.typeinfo.TypeInformation;
import org.apache.flink.shaded.jackson2.com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

/**
 * 카프카의 역직렬화 스키마{@link DeserializationSchema}입니다.
 *
 * JSON으로부터 {@link Ticker}를 역질렬화 합니다.
 */
public class TickerDeserializationSchema implements DeserializationSchema<Ticker> {

    private static final long serialVersionUID = 1L;

    private static final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public Ticker deserialize(byte[] message) throws IOException {
        return objectMapper.readValue(message, Ticker.class);
    }

    @Override
    public boolean isEndOfStream(Ticker nextElement) {
        return false;
    }

    @Override
    public TypeInformation<Ticker> getProducedType() {
        return TypeInformation.of(Ticker.class);
    }
}
