package jypark.blog.entities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;

@Entity
@Data
@NoArgsConstructor
public class Mandalat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mandalat_id")
    private Long id;

    private String list;

    private int ordering;

    private Long userId;

    public List<String> getList() {
        return StringUtils.isNotBlank(list) ? Arrays.stream(list.split(",")).toList() : new ArrayList<>();
    }


}
