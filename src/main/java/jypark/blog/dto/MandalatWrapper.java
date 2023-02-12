package jypark.blog.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import jypark.blog.entities.Mandalat;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MandalatWrapper {

    private List<Long> ids;

    private List<String> main;
    private List<String> first;
    private List<String> second;
    private List<String> third;
    private List<String> fourth;
    private List<String> fifth;
    private List<String> sixth;

    private List<String> seventh;
    private List<String> eighth;

    private boolean saved;

    public MandalatWrapper(List<Mandalat> entities) {
        ids = entities.stream().map(Mandalat::getId).collect(Collectors.toList());
        saved = !ids.isEmpty();
        if(saved) {
            for(Mandalat m : entities) {
                if(m.getOrdering() == 0) {
                    main = m.getList();
                }
                if(m.getOrdering() == 1) {
                    first = m.getList();
                }
                if(m.getOrdering() == 2) {
                    second = m.getList();
                }
                if(m.getOrdering() == 3) {
                    third = m.getList();
                }
                if(m.getOrdering() == 4) {
                    fourth = m.getList();
                }
                if(m.getOrdering() == 5) {
                    fifth = m.getList();
                }
                if(m.getOrdering() == 6) {
                    sixth = m.getList();
                }
                if(m.getOrdering() == 7) {
                    seventh = m.getList();
                }
                if(m.getOrdering() == 8) {
                    eighth = m.getList();
                }
            }
        } else {
            main = getEmptyList();
            first = getEmptyList();
            second = getEmptyList();
            third = getEmptyList();
            fourth = getEmptyList();
            fifth = getEmptyList();
            sixth = getEmptyList();
            seventh = getEmptyList();
            eighth = getEmptyList();
        }

    }

    public List<String> getEmptyList() {
        List<String> blank = new ArrayList<>();
        for(int i = 0; i < 9; i++) {
            blank.add("");
        }
        return blank;
    }

    public static MandalatWrapper of(List<Mandalat> entities) {
        return new MandalatWrapper(entities);
    }
}
