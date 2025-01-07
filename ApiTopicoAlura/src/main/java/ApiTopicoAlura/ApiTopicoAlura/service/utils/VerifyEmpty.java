package ApiTopicoAlura.ApiTopicoAlura.service.utils;

import ApiTopicoAlura.ApiTopicoAlura.DTO.insertTopic.ValidadeInsertTopic;
import org.springframework.stereotype.Component;

@Component
public class VerifyEmpty {

    public static void validadesAll(ValidadeInsertTopic validadeInsertTopic) {
        verifyEmpty(validadeInsertTopic.title(), validadeInsertTopic.message());
        verifyDuplicate(validadeInsertTopic.title(), validadeInsertTopic.message());
    }

    public static void verifyEmpty(String title, String message) {
        if (title.trim().isEmpty() || message.trim().isEmpty()) {
            throw new IllegalArgumentException("Title and message must not be empty");
        }

    }

    public static void verifyDuplicate(String title, String message) {
        if (title.trim().equals(message)) {
            throw new IllegalArgumentException("Title and message must not be the same");
        }

    }
}
