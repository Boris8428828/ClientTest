package test.clienttest.DTO;

import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ContactDTO {
    Long id;

    Long clientId;

    String contactType;

    String contactValue;
}
