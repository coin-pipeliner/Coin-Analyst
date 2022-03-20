package coinanalysis.records;

import org.apache.flink.api.common.serialization.DeserializationSchema;
import org.apache.flink.api.common.typeinfo.TypeInformation;
import org.apache.flink.shaded.jackson2.com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class PostDeserializationSchema implements DeserializationSchema<Post> {

    private static final long serialVersionUID = 1L;

    private static final ObjectMapper objectMapper = new ObjectMapper();


    @Override
    public Post deserialize(byte[] message) throws IOException {
        return objectMapper.readValue(message, Post.class);

    }

    @Override
    public boolean isEndOfStream(Post message) {
        return false;
    }

    @Override
    public TypeInformation<Post> getProducedType() {
        return TypeInformation.of(Post.class);
    }
}
