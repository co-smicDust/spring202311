package exam01;

import lombok.*;

//@Getter
//@Setter
//@ToString
//@NoArgsConstructor(access = AccessLevel.PRIVATE)
//@AllArgsConstructor
//@RequiredArgsConstructor
//@EqualsAndHashCode
@Data
public class Book {
    String title;

    //@NonNull
    private String author;
    private String publisher;


}
