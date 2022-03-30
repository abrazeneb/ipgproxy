package com.sepacyber.services.sidecar.configsidecar;

import com.sepacyber.services.sidecar.configsidecar.domain.model.TenantConfigAsyncEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.UUID;

//@SpringBootTest
@Import( AppConfig.class )
class ConfigSidecarApplicationTests {

	@Autowired
	private RedisTemplate<String, TenantConfigAsyncEvent> publisherRedisTemplate;
	private final String channel =  "test_microservice".concat("_").concat("tenant_config_event_channel");

	//@Test
	public void testPubSubStoreAndCache() {


		TenantConfigAsyncEvent fakeTenantConfigEvent = TenantConfigAsyncEvent.builder()
				.tenantId(UUID.randomUUID().toString())
				.metaData(generateRandomConfigMetadataJsonString())
				.isDelete(false)
				.build();

		publisherRedisTemplate.convertAndSend(channel, fakeTenantConfigEvent);


	}

	private String generateRandomConfigMetadataJsonString() {

		String data = "{\n" +
				"  \"name\": \"Cecila Starbird\",\n" +
				"  \"userName\": \"moistben\",\n" +
				"  \"email\": \"randiexyst@hotmail.co.uk\",\n" +
				"  \"profiles\": [\n" +
				"    {\n" +
				"      \"profileId\": 964,\n" +
				"      \"profileAdded\": \"Mar 19, 1973 12:00:00 AM\"\n" +
				"    },\n" +
				"    {\n" +
				"      \"profileId\": 854,\n" +
				"      \"profileAdded\": \"Jun 3, 1978 12:00:00 AM\"\n" +
				"    }\n" +
				"  ]\n" +
				"}";

		return data;
	}

}
