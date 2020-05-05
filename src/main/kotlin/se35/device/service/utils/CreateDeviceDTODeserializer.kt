package se35.device.service.utils

import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.core.JsonProcessingException
import com.fasterxml.jackson.databind.*
import com.fasterxml.jackson.databind.util.StdDateFormat
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import se35.device.service.dto.entities.CreateDryerDTO
import se35.device.service.dto.entities.CreateWashingMachineDTO
import se35.device.service.dto.interfaces.CreateDeviceDTO
import se35.device.service.exceptions.APIException
import se35.device.service.exceptions.APIExceptionCode
import se35.device.service.models.enums.DeviceType
import java.io.IOException

class CreateDeviceDTODeserializer : JsonDeserializer<CreateDeviceDTO>() {

    @Throws(IOException::class, JsonProcessingException::class)
    override fun deserialize(jp: JsonParser, ctxt: DeserializationContext): CreateDeviceDTO? {
        val node: JsonNode = jp.codec.readTree(jp)
        if (node.get("type") == null) {
            throw APIException(APIExceptionCode.CREATE_DEVICE_INVALID_TYPE)
        }
        val mapper = jsonMapper()
        return when(node.get("type").asText()) {
            DeviceType.WASHING_MACHINE.name -> mapper.readValue(node.toString(), CreateWashingMachineDTO::class.java)
            DeviceType.DRYER.name -> mapper.readValue(node.toString(), CreateDryerDTO::class.java)
            else -> throw APIException(APIExceptionCode.CREATE_DEVICE_INVALID_TYPE)
        }
    }

    private fun jsonMapper(): ObjectMapper {
        val mapper = jacksonObjectMapper()
                .registerModule(Jdk8Module())
                .registerModule(JavaTimeModule())
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
        mapper.dateFormat = StdDateFormat()
        return mapper
    }

}