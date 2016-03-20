package eu.motogymkhana.server.jackson;

import org.restlet.data.MediaType;
import org.restlet.ext.jackson.JacksonConverter;
import org.restlet.ext.jackson.JacksonRepresentation;
import org.restlet.representation.Representation;

import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public class MyJacksonConverter extends JacksonConverter {

	@Override
	protected <T> JacksonRepresentation<T> create(MediaType mediaType, T source) {
		
		ObjectMapper mapper = createMapper();
		JacksonRepresentation<T> jr = new JacksonRepresentation<T>(mediaType, source);
		jr.setObjectMapper(mapper);
		return jr;
	}

	@Override
	protected <T> JacksonRepresentation<T> create(Representation source, Class<T> objectClass) {
		
		ObjectMapper mapper = createMapper();
		JacksonRepresentation<T> jr = new JacksonRepresentation<T>(source, objectClass);
		jr.setObjectMapper(mapper);
		return jr;
	}

	private ObjectMapper createMapper() {

		ObjectMapper mapper = new ObjectMapper() {
			{
				configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			}
		};
		
		mapper.setVisibility(PropertyAccessor.ALL, Visibility.NONE);
		mapper.setVisibility(PropertyAccessor.FIELD, Visibility.ANY);

		return mapper;
	}

}