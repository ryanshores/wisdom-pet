package com.ryanshores.wisdompet.web.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class PostDto {
    private Long id;
    private String title;
    private String body;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
    private String author;

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", title='" + title + "'" +
                ", body='" + body + "'" +
                ", createdAt='" + createdAt + "'" +
                ", modifiedAt='" + modifiedAt + "'" +
                ", author='" + author + "'" +
                "}";
    }
}
